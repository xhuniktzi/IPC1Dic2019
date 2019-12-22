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

//TO DO: <- Implementar carga de insumos
//implementar manejo de inventario
//implementar ordenes
public class Inventario {
    private ListaInsumo insumosDisponibles;
    private int contadorInsumos;

    public Inventario() {
        insumosDisponibles = new ListaInsumo(1);
        contadorInsumos = 0;
    }
    
    public void loadInsumosFromXML(String path){
        try {
            File archivo = new File(path);
            DocumentBuilderFactory docBuildFactoryInsumos = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilderInsumos = docBuildFactoryInsumos.newDocumentBuilder();
            Document docInsumos = docBuilderInsumos.parse(archivo);
            
            docInsumos.getDocumentElement().normalize();
            
            NodeList listaInsumos = docInsumos.getElementsByTagName("insumo");
            for (int i = 0; i < listaInsumos.getLength();i++){
                Insumo insumoNuevo = new Insumo();
                Node nodo = listaInsumos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nodo;
                    insumoNuevo.setId(Integer.parseInt(element.getAttribute("id")));
                    
                    NodeList elementNombre = element.getElementsByTagName("nombre");
                    Node nodoNombre = elementNombre.item(0);
                    if (nodoNombre.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoNombre;
                        insumoNuevo.setNombre(elementInternal.getTextContent());
                    }
                    
                    NodeList elementCantidad = element.getElementsByTagName("cantidad");
                    Node nodoCantidad = elementCantidad.item(0);
                    if (nodoCantidad.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoCantidad;
                        insumoNuevo.setCantidad(Integer.parseInt(elementInternal.getTextContent()));
                    }
                    
                    NodeList elementMinimo = element.getElementsByTagName("minimo");
                    Node nodoMinimo = elementMinimo.item(0);
                    if (nodoMinimo.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoMinimo;
                        insumoNuevo.setCantidadMinima(Integer.parseInt(elementInternal.getTextContent()));
                    }
                    
                    NodeList elementMaximo = element.getElementsByTagName("maximo");
                    Node nodoMaximo = elementMaximo.item(0);
                    if (nodoMaximo.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoMaximo;
                        insumoNuevo.setCantidadMaxima(Integer.parseInt(elementInternal.getTextContent()));
                    }
                    
                    NodeList elementCosto = element.getElementsByTagName("costo");
                    Node nodoCosto = elementCosto.item(0);
                    if (nodoCosto.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoCosto;
                        insumoNuevo.setCosto(Double.parseDouble(elementInternal.getTextContent()));
                    }
                    
                    NodeList elementDescripcion = element.getElementsByTagName("descripcion");
                    Node nodoDescripcion = elementDescripcion.item(0);
                    if (nodoDescripcion.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoDescripcion;
                        insumoNuevo.setDescripcion(elementInternal.getTextContent());
                    }
                    
                    NodeList elementImg = element.getElementsByTagName("imagen");
                    Node nodoImg = elementImg.item(0);
                    if (nodoImg.getNodeType() == Node.ELEMENT_NODE){
                        Element elementInternal = (Element) nodoImg;
                        insumoNuevo.setPathImg(elementInternal.getTextContent());
                    }
                }
                insumoNuevo.setFlag(true);
                contadorInsumos++;
                insumosDisponibles.addInsumo(insumoNuevo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ListaInsumo getInsumosDisponibles(){
        return insumosDisponibles;
    }
    
    public void addInsumo (Insumo s){
        insumosDisponibles.addInsumo(s);
    }

    public void setInsumosDisponibles(ListaInsumo insumosDisponibles) {
        this.insumosDisponibles = insumosDisponibles;
    }

    public Insumo searchInsumoById(int id){
        return insumosDisponibles.searchInsumoByID(id);
    }

    public int getContadorInsumos() {
        return contadorInsumos;
    }

    public void setContadorInsumos(int contadorInsumos) {
        this.contadorInsumos = contadorInsumos;
    }
    
    
    
    @Override
    public String toString() {
        String str = "";
        str += "Estado del inventario:\n";
        str += "Insumos disponibles:\n";
        str += insumosDisponibles;
    
        return str;
    }
    
}
