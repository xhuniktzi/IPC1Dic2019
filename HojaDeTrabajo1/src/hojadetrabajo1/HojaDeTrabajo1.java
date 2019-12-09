/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadetrabajo1;

/**
 *
 * @author arthu
 */

import java.util.Scanner;

public class HojaDeTrabajo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int seleccion;
        
        
        System.out.println("Elija el ejercicio: ");
        System.out.println("1. Verificar si un numero es entero y si lo es verificar si es multiplo de 2");
        System.out.println("2. Verificar año y fecha");
        System.out.println("3. conversor de unidades");
        System.out.println("4. Comparar alturas y edades");
        seleccion = sc.nextInt();
        switch (seleccion){
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            default:
                System.out.println("Ingresa una opcion valida");
        }
        
        
    }
private static void ejercicio1(){
    double var;
    System.out.print("Ingrese un numero: ");
        Scanner sc = new Scanner(System.in);
        var = sc.nextDouble();
        if (var % 1 != 0){
            System.out.println("el numero es decimal");
        }
        else {
            if (var % 2 != 0){
                System.out.println("el numero no es multiplo de 2");
            }
            else {
                System.out.println("el numero es multiplo de 2");
            }
        }
}
private static void ejercicio2(){
    Scanner sc = new Scanner(System.in);
    Fecha fecha = new Fecha();
    
    System.out.println("Ingrese una fecha:\n");
    System.out.println("Ingrese un dia:\n");
    fecha.dia = sc.nextInt();
    System.out.println("Ingrese un mes:\n");
    fecha.mes = sc.nextInt();
    System.out.println("Ingrese un año:");
    fecha.anyo = sc.nextInt();
    
    if (fecha.obtenerDias() == -1)
        System.out.println("Ingresa una fecha valida!!!");
    else
        System.out.println("Fecha Valida: " + fecha);
        System.out.println("Dia numero: " + fecha.obtenerDias());
}
private static void ejercicio3(){
    Scanner sc = new Scanner(System.in);
    int selector;
    double var;
    boolean flag = true;
    
    while (flag){
    System.out.println("1. Masa\n2.Longitud");
    selector = sc.nextInt();
    
    if (selector == 1){
        System.out.println("ingrese kilogramos:");
        var = sc.nextDouble();
        if(var < 0)
            flag = false;
        else
            System.out.println(var + " kilogramos en libras es: " + var*2.205 );
    }
    else if (selector == 2){
        System.out.println("ingrese pulgadas:");
        var = sc.nextDouble();
        if (var < 0)
            flag = false;
        else
            System.out.println(var + " pulgadas en centimetros es: " + var*2.54 );
    }
    else {
        System.out.println("Ingresa una opcion valida");
    }
    }
    System.out.println("Finalizado");
}

private static void ejercicio4(){
    Scanner sc = new Scanner(System.in);
    int promedioEdad;
    double promedioAltura;
    
    int[] edad;
    double[] altura;
    
    edad = new int[6];
    altura = new double[6];
    
    int contador = 1;
    int cantMayores = 0;
    int cantMasAltos = 0;
    while (contador <= 6){
        System.out.println("Ingrese la edad del estudiante " + contador + ":");
        edad[contador-1] = sc.nextInt();
        System.out.println("Ingrese la altura del estudiante " + contador + ":");
        altura[contador-1] = sc.nextDouble();
        contador++;
    }
    contador = 1;
    promedioEdad = (edad[0] + edad[1] + edad[2] + edad[3] + edad[4] + edad[5])/6;
    promedioAltura = (altura[0] + altura[1] + altura[2] + altura[3] + altura[4] + altura[5])/6;
    while (contador <= 6){
        if (edad[contador-1] > 18){
            cantMayores++;
        }
        if (altura[contador-1] > 1.7)
            cantMasAltos++;
        contador++;
    }
    System.out.println("Promedio de altura: " + promedioAltura);
    System.out.println("Promedio de edades: " + promedioEdad);
    System.out.println("Estudiantes mayores de 18 años: " + cantMayores);
    System.out.println("Estudiantes que miden mas de 1.70: " + cantMasAltos);
}
}
class Fecha {
    public int dia;
    public int mes;
    public int anyo;
    
    private int contadorDias;
    
    public Fecha(){
        this.contadorDias = 0;
    }
    
    public int obtenerDias(){
        
        if (dia > 31)
            contadorDias = -1;
        else {
            if (mes > 12)
                contadorDias = -1;
            else {
                if (mes == 4 && dia > 30 || mes == 6 && dia > 30 || mes == 9 && dia > 30 || mes == 11 && dia > 30 || mes == 2 && dia > 28){
                    contadorDias = -1;
                }
                else{
                    switch (mes){
                        case 1:
                            contadorDias = 0;
                            break;
                        case 2:
                            contadorDias = 31;
                            break;
                        case 3:
                            contadorDias = 31 + 28;
                            break;
                        case 4:
                            contadorDias = 31 + 28 + 31;
                            break;
                        case 5:
                            contadorDias = 31 + 28 + 31 + 30;
                            break;
                        case 6:
                            contadorDias = 31 + 28 + 31 + 30 + 31;
                            break;
                        case 7:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 30;
                            break;
                        case 8:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                            break;
                        case 9:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                            break;
                        case 10:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 20 + 31 + 31 + 30;
                            break;
                        case 11:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                            break;
                        case 12:
                            contadorDias = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                            break;
                            
                }
                    contadorDias+= dia;
                }
            }
        }
        return contadorDias;
    }
    public String toString(){
        return dia + "/" + mes + "/" + anyo;
    }
}
