/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Elements;

/**
 *
 * @author xhunik
 */
public class Colaborador {
    public String nombre;
    public String nickname;
    public String rol;
    public int telfono;

    public Colaborador(String nombre, String nickname, String rol, int telfono) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.rol = rol;
        this.telfono = telfono;
    }
    public Colaborador(){
        this("","","",0);
    }

    @Override
    public String toString() {
        return ("n: " + nombre + " nick: " + nickname + " rol: " + rol + " tel: " + telfono);
    }
    
}
