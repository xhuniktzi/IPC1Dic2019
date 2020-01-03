/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Exceptions.InvalidNickException;
import Exceptions.ListaVaciaException;
import Exceptions.NickVacioException;
import Logica.Elements.Colaborador;
import Logica.EspecNodos.NodoColaboradorLS;

/**
 *
 * @author xhunik
 */

//TODO: add metodo para eliminar por nickname
//      eliminacion recursiva
public class ColaboradoresLS {
    public NodoColaboradorLS ini;
    public int contador;
    public String nombre;
    
    public ColaboradoresLS(String nombre){
        this.nombre = nombre;
        contador = 0;
        ini = null;
    }
    public ColaboradoresLS(){
        this("mi lista");
    }
    public void insertarAlFrente(Colaborador dato){
        if (estaVacia())
            ini = new NodoColaboradorLS(dato);
        else
            ini = new NodoColaboradorLS(dato, ini);
    }
    
    public void insertarAlFinal(Colaborador dato){
        if (estaVacia())
            ini = new NodoColaboradorLS(dato);
        else{
            NodoColaboradorLS act = ini;
            NodoColaboradorLS ant = null;
            do {
                ant = act;
                act = act.sig;
            }while (act != null);
            ant.sig = act = new NodoColaboradorLS(dato, null);
        }
        
    }
    public void insertarColaborador(Colaborador c) throws NickVacioException, InvalidNickException{
        if (c.nickname.equals(""))
            throw new NickVacioException();
        if (estaVacia()){
            insertarAlFinal(c);
            contador++;
        }
        else {
            if (checkExistsNickname(c.nickname))
                throw new InvalidNickException();
            else{
                insertarAlFinal(c);
                contador++;
            }
        }
    }
    public boolean checkExistsNickname(String nick){
        NodoColaboradorLS act = ini;
        while (act != null){
            if (act.dato.nickname.equals(nick) )
                return true;
            act = act.sig;
        }
        return false;
    }
    public Colaborador eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Colaborador datosAct = ini.dato;
        
        ini = ini.sig;
        
        return datosAct;
    }
    
    public Colaborador eliminarAlFinal() throws ListaVaciaException {
        Colaborador dato;
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        else {
            NodoColaboradorLS act = ini;
            NodoColaboradorLS ant = null;
            while (act.sig != null){
                ant = act;
                act = act.sig;
            }
            dato = act.dato;
            ant.sig = act = null;
            
        }
        return dato;
    }
    
    public Colaborador eliminarColaborador(String nick) throws InvalidNickException{
        if (!checkExistsNickname(nick)){
            throw new InvalidNickException();
        }
        else {
            NodoColaboradorLS act = ini;
            NodoColaboradorLS ant = null;
            Colaborador dato = null;
            while (act != null){
                if (act.dato.nickname.equals(nick)){
                    if (ant == null){
                        System.out.println("Eliminar enfrente");
                        dato = eliminarAlFrente();
                        contador--;
                        break;
                    }
                    if (act.sig == null){
                        System.out.println("Eliminar atras");
                        dato = eliminarAlFinal();
                        contador--;
                        break;
                    }
                    System.out.println("eliminar de otra posicion");
                    dato = act.dato;
                    ant.sig = act.sig;
                    contador--;
                    break;
                    
                }
                ant = act;
                act = act.sig;
            }
            return dato;
        }
        
    }
    
    public boolean estaVacia(){
        return (ini == null);
    }

    public Colaborador[] getColaboradoresArray(){
        Colaborador[] retorno = new Colaborador[contador];
        int i = 0;
        NodoColaboradorLS act = ini;
        while (act != ini){
            retorno[i] = act.dato;
            i++;
            act = act.sig;
        }
        return retorno;
    }
    
    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoColaboradorLS act = ini;
        
        while (act != null){
            try {
            System.out.println(act.dato + "->" + act.sig.dato);
            }
            catch (NullPointerException npe){
                System.out.println(act.dato + "-> null");
                //npe.printStackTrace();
            }
            finally{act = act.sig;}
        }
    }

}
