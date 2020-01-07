/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Exceptions.ColaboradorNotFoundException;
import Exceptions.InvalidNickException;
import Exceptions.ListaVaciaException;
import Exceptions.NickVacioException;
import Logica.Elements.Colaborador;
import Logica.EspecNodos.NodoColaboradorLD;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
            ordenarColaboradores();
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
                            ordenarColaboradores();
                            return;
                        }
                        else {
                            insertarAlFrente(c);
                            contador++;
                            ordenarColaboradores();
                            return;
                        }
                    }
                    else if (c.nickname.compareToIgnoreCase(act.dato.nickname)> 0){
                        NodoColaboradorLD nuevo = new NodoColaboradorLD(c, act, act.sig);
                        act.sig.ant = nuevo;
                        act.sig = nuevo;
                        contador++;
                        ordenarColaboradores();
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
    
    public Colaborador getColaboradorByNickname(String nickname) throws ListaVaciaException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoColaboradorLD act = ini;
        while (act != null){
            if (act.dato.nickname.equals(nickname)){
                return act.dato;
            }
            act = act.sig;
        }
        throw new ColaboradorNotFoundException();
    }
    
    public Colaborador eliminarColaboradorByNickname (String nick) throws ListaVaciaException, ColaboradorNotFoundException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoColaboradorLD act = ini;
        while (act != null){
            if (act.dato.nickname.equals(nick)){
                //delete;
                NodoColaboradorLD prev = act.ant;
                NodoColaboradorLD next = act.sig;
                if (act.ant == null){
                    contador--;
                    return eliminarAlFrente();
                }
                if (act.sig == null){
                    contador--;
                    return eliminarAlFinal();
                }
                Colaborador data = act.dato;
                prev.sig = next;
                next.ant = prev;
                contador--;
                return data;
            }
            act = act.sig;
        }
        throw new ColaboradorNotFoundException();
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
    
    public void ordenarColaboradores(){
        if(estaVacia())
            throw new ListaVaciaException(nombre);
        
        Colaborador[] listaColaboradores = new Colaborador[contador];
        NodoColaboradorLD act = ini;
        int i = 0;
        while (act != null){
            listaColaboradores[i] = act.dato;
            act = act.sig;
            i++;
        }
        
        int n = 0;
        for (int j = 0; j < listaColaboradores.length; j++){
            Colaborador aux = listaColaboradores[j];
            n = j;
            while (n > 0 && listaColaboradores[n-1].nickname.compareToIgnoreCase(aux.nickname)>0){
                listaColaboradores[n] = listaColaboradores [n-1];
                --n;
            }
            listaColaboradores[n] = aux;
        }
        
        int k = 0;
        NodoColaboradorLD actAux = ini;
        while (actAux != null){
            actAux.dato = listaColaboradores[k];
            actAux = actAux.sig;
            k++;
        }
    }
   
    
    public void drawGraphviz(String ruta) throws IOException{
        String path = ruta + "/dot/colaboradores.dot";
        String pathImg = ruta+ "/img/colaboradores.jpg";
        File drawFile = new File(path);
        if (drawFile.exists()){
            drawFile.delete();
            drawFile.createNewFile();
        }
        else {
            drawFile.createNewFile();
        }
        
        FileWriter txt2 = new FileWriter(drawFile,true);
        PrintWriter txt = new PrintWriter(txt2);
        
        txt.println("digraph A{");
        if (estaVacia())
            txt.println("ini->null");
        else {
            txt.println("ini->" + ini.hashCode());
            NodoColaboradorLD act =ini;
            while (act != null){
                if (act.sig != null){
                    txt.println(act.hashCode() + "->" + act.sig.hashCode() + "");
                    txt.println(act.hashCode() + " [label=\"" + act.dato.nickname + "\"];");
                    txt.println(act.sig.hashCode() + " [label=\"" + act.sig.dato.nickname + "\"];");
                }
                else{
                    txt.println(act.hashCode() + "-> null");
                    txt.println(act.hashCode() + " [label=\"" + act.dato.nickname + "\"];");
                }
                
                if (act.ant != null){
                    txt.println(act.hashCode() + "->" + act.ant.hashCode());
                    txt.println(act.hashCode() + " [label=\"" + act.dato.nickname + "\"];");
                    txt.println(act.ant.hashCode() + " [label=\"" + act.ant.dato.nickname + "\"];");
                }
                else{
                    txt.println(act.hashCode() + "-> Null");
                    txt.println(act.hashCode() + " [label=\"" + act.dato.nickname + "\"];");
                }
                
            act = act.sig;
            }
        }
        
        txt.println("}");
        
        txt.close();
        txt2.close();
        
        String command = "dot -Tjpg " + path + " -o " + pathImg;
        
        Runtime run = Runtime.getRuntime();
        run.exec(command);
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
