/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logica.Containers.ColaboradoresLS;
import Logica.Elements.Colaborador;

/**
 *
 * @author xhunik
 */
public class MainProbe {
    
    public static void main(String[] args){
        ColaboradoresLS lista = new ColaboradoresLS("colaboradores");
        //lista.insertarColaborador(new Colaborador("xhunik", "xhuniktzi", "algo", 546));
        lista.insertarColaborador(new Colaborador("ix", "ixchumil", "algo2", 55446));
        lista.imprimir();
        System.out.printf("\n");
        
        lista.eliminarColaborador("ixchumil");
        System.out.printf("\n");
        lista.imprimir();
        /*
        lista.eliminarColaborador("xhuniktzi");
        System.out.printf("\n");
        lista.imprimir();
*/
    }
}
