/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.internal;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author xhunik
 */
public class Gestor {
    private ListaProducto productosDisponibles;
    private ListaPedido pedidosRealizados;
    private Inventario inventario;
    private int contadorProductos;
    private int contadorPedidos;

    public Gestor() {
        productosDisponibles = new ListaProducto(1);
        pedidosRealizados = new ListaPedido(1);
        inventario = new Inventario();
        contadorProductos=0;
        contadorPedidos= 0;
    }
    public void loadProductosFromXML(String path){
        //TO DO: <- Flag de productos (y de Insumos?) e id de los productos
        try {
            File archivo = new File(path);
            DocumentBuilderFactory docBuildFactoryProductos = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderProductos = docBuildFactoryProductos.newDocumentBuilder();
            Document docProductos = docBuilderProductos.parse(archivo);
            
            docProductos.getDocumentElement().normalize();
            
            NodeList listaProductos = docProductos.getElementsByTagName("producto");
            
            for (int i = 0; i < listaProductos.getLength();i++){
                Node nodo = listaProductos.item(i);
                Producto productoNuevo = new Producto();
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nodo;
                    productoNuevo.setNombre(element.getAttribute("nombre"));
                    productoNuevo.setPrecio(Double.parseDouble(element.getAttribute("precio")));
                    productoNuevo.setDescripcion(element.getAttribute("descripcion"));
                    productoNuevo.setPathImg(element.getAttribute("imagen"));
                    
                    ListaInsumo insumosProducto = new ListaInsumo(1);
                    NodeList listaInsumos = element.getElementsByTagName("insumo");
                    for (int j = 0; j < listaInsumos.getLength();j++){
                        Node nodoInternal = listaInsumos.item(j);
                        Insumo insumoNuevo = new Insumo();
                        
                        if (nodoInternal.getNodeType() == Node.ELEMENT_NODE){
                            Element elementInternal = (Element) nodoInternal;
                            
                            insumoNuevo.setId(Integer.parseInt(elementInternal.getAttribute("codigo")));
                            insumoNuevo.setCantidad(Integer.parseInt(elementInternal.getTextContent()));
                            insumoNuevo.setNombre(elementInternal.getAttribute("nombre"));
                        }
                        insumoNuevo.setFlag(true);
                        insumosProducto.addInsumo(insumoNuevo);
                    }
                    productoNuevo.setInsumosNecesarios(insumosProducto);
                }
                productoNuevo.setFlag(true);
                
                contadorProductos++;
                productoNuevo.setId(contadorProductos);
                productosDisponibles.addProducto(productoNuevo);
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Inventario getInventario() {
        return inventario;
    }


    public ListaPedido getPedidosRealizados() {
        return pedidosRealizados;
    }

    public ListaProducto getProductosDisponibles() {
        return productosDisponibles;
    }

    public boolean checkoutProductoById(int id){
        ListaInsumo listaToCheckout = new ListaInsumo(1);
        if (productosDisponibles.existsProductoId(id)){
            Producto p = productosDisponibles.searchProductoByID(id);
            for (int i = 0; i < p.getInsumosNecesarios().getSize();i++){
                Insumo insumoTemp = p.getInsumosNecesarios().getInsumoByIndex(i);
                if (insumoTemp.getCantidad() < inventario.searchInsumoById(insumoTemp.getId()).getCantidad()){
                    
                        listaToCheckout.addInsumo(insumoTemp);
                }
                else {
                    
                    return false;
                }
            }
            
            
            for (int i = 0; i < listaToCheckout.getSize();i++){
                int nuevaCantidad = inventario.searchInsumoById(listaToCheckout.getInsumoByIndex(i).getId()).getCantidad()-listaToCheckout.getInsumoByIndex(i).getCantidad();
                if (!(nuevaCantidad > inventario.searchInsumoById(listaToCheckout.getInsumoByIndex(i).getId()).getCantidadMinima())){
                    
                    
                    
                    return false;
                }
            }
            
            for (int i = 0; i < listaToCheckout.getSize();i++){
                int nuevaCantidad = inventario.searchInsumoById(listaToCheckout.getInsumoByIndex(i).getId()).getCantidad()-listaToCheckout.getInsumoByIndex(i).getCantidad();
                inventario.searchInsumoById(listaToCheckout.getInsumoByIndex(i).getId()).setCantidad(nuevaCantidad);
            }
            
            
            
            
            Pedido pedido = new Pedido();
            pedido.addNuevoProducto(p);
            contadorPedidos++;
            pedido.setId(contadorPedidos);
            pedido.setFlag(true);
            pedidosRealizados.addPedido(pedido);
            System.out.println(inventario);
            return true;
        }
        else {
            
            return false;
        }
    }
    
    public double calculateVentaByIdproducto(int id){
        Producto p = productosDisponibles.searchProductoByID(id);
        return p.getPrecio();
    }
    
    public double calculateCostoReabastecerInsumo(int id){
        if (inventario.getInsumosDisponibles().existsInsumoId(id)){
            Insumo i = inventario.getInsumosDisponibles().searchInsumoByID(id);
            if (i.getCantidad() >= i.getCantidadMaxima()){
                return 0.0;
            }
            else {
                int resta;
                resta = i.getCantidadMaxima() - i.getCantidad();
                return resta * i.getCosto();
            }
        }
        return -1;
    }
    
    public void executeReabastecerInsumo(int id){
        Insumo i = inventario.getInsumosDisponibles().searchInsumoByID(id);
        inventario.getInsumosDisponibles().searchInsumoByID(id).setCantidad(i.getCantidadMaxima());
        System.out.println(inventario);
    }
    
    
    public void RegisterNewInsumo(String nombre,int cantidad, int cantMax,int cantMin,double costo, String descripcion){
        Insumo i = new Insumo();
        getInventario().setContadorInsumos(getInventario().getContadorInsumos()+1);
        
        i.setId(getInventario().getContadorInsumos());
        i.setNombre(nombre);
        i.setCantidad(cantidad);
        i.setCantidadMaxima(cantMax);
        i.setCantidadMinima(cantMin);
        i.setCosto(costo);
        i.setDescripcion(descripcion);
        i.setFlag(true);
        
        getInventario().addInsumo(i);
    }
    
    public void RegisterNewProducto(String nombre,ListaInsumo l,double costo, String descripcion){
        Producto p = new Producto();
        contadorProductos++;
        
        p.setId(contadorProductos);
        p.setNombre(nombre);
        
        p.setInsumosNecesarios(l);
        p.setPrecio(costo);
        p.setDescripcion(descripcion);
        p.setFlag(true);
        
        productosDisponibles.addProducto(p);
    }
    
    @Override
    public String toString() {
        String str = "";
        str += "Inventario de Insumos: \n";
        str += inventario;
        str += "Productos Disponibles: \n";
        str += productosDisponibles;
        return str;
    }
    
    
}
