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
import Logica.EspecNodos.NodoColaboradorLD;

/**
 *
 * @author xhunik
 */


//TODO: add metodo para eliminar por nickname
//      eliminacion recursiva
public class ColaboradoresLD {
    public NodoColaboradorLD ini;
    public NodoColaboradorLD end;
    public int contador;
    public String nombre;
    
    public ColaboradoresLD(String nombre){
        this.nombre = nombre;
        ini = end = null;
        contador = 0;
    }
    
    public ColaboradoresLD(){
        this("Colaboradores Registrados");
    }
    
    public void insertarColaborador(Colaborador c) throws InvalidNickException, NickVacioException{
        if (c.nickname.equals(""))
            throw new NickVacioException();
        if (estaVacia()){
            insertarAlFinal(c);
            contador++;
        }
        else {
            if (checkExistsNickname(c.nickname))
                throw new InvalidNickException();
            
            else {
                NodoColaboradorLD act = ini;
                while (act != null){
                    if (act.sig == null){
                        if (c.nickname.compareToIgnoreCase(act.dato.nickname) > 0){
                            insertarAlFinal(c);
                            contador++;
                            return;
                        }
                        else {
                            insertarAlFrente(c);
                            contador++;
                            return;
                        }
                    }
                    else if (c.nickname.compareToIgnoreCase(act.dato.nickname)> 0){
                        NodoColaboradorLD nuevo = new NodoColaboradorLD(c, act, act.sig);
                        act.sig.ant = nuevo;
                        act.sig = nuevo;
                        contador++;
                        return;
                    }
                    act = act.sig;
                }         
            }
        }
    }
    //false si no existe, true si si existe
    public boolean checkExistsNickname(String nick){
        NodoColaboradorLD act = ini;
        while (act != null){
            if (act.dato.nickname.equals(nick))
                return true;
            act =act.sig;
        }
        return false;
    }
    
    public void insertarAlFrente(Colaborador dato){
        if (estaVacia())
            ini = end = new NodoColaboradorLD(dato);
        else
            ini = ini.ant = new NodoColaboradorLD(dato, null, ini);
    }
    
    public void insertarAlFinal(Colaborador dato){
        if (estaVacia())
            ini = end = new NodoColaboradorLD(dato);
        else
            end = end.sig = new NodoColaboradorLD(dato, end, null);
    }
    
    public Colaborador eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Colaborador datosAct = ini.dato;
        
        if (ini == end)
            ini = end = null;
        else{
            ini = ini.sig;
            ini.ant = null;
        }
        return datosAct;
    }
    
    public Colaborador eliminarAlFinal(){
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Colaborador datosAct = end.dato;
        
        if (ini == end)
            ini = end = null;
        else {
            end = end.ant;
            end.sig = null;
        }
        return datosAct;
    }
    
    public Colaborador[] getArrayColaborador(){
        Colaborador[] retorno = new Colaborador[contador];
        NodoColaboradorLD act = ini;
        int i = 0;
        while (act != null){
            retorno[i] = act.dato;
            act = act.sig;
            i++;
        }
        return retorno;
    }
    
    public boolean estaVacia(){
        return (ini == null && end == null);
    }

    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoColaboradorLD act = ini;
        
        while (act != null){
            try{
                System.out.println(act.ant.dato + "<-"+ act.dato + "->" + act.sig.dato);
            }
            catch (NullPointerException npe){
                if (act.ant == null && act.sig == null){
                    System.out.println("null <-"+ act.dato + "-> null");
                    continue;
                }
                if (act.ant == null){
                    System.out.println("null <-"+ act.dato + "->" + act.sig.dato);
                    continue;
                }
                if (act.sig == null){
                    System.out.println(act.ant.dato + "<-"+ act.dato + "-> null");    
                    continue;
                }
                //npe.printStackTrace();
            }
            finally {act = act.sig;}
        }
    }
}
