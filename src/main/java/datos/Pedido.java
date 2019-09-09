/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import polera.Polera;

/**
 *
 * @author usuario
 */
public class Pedido {
    public ArrayList<Polera> pedido;

    /**
     * junta todos los metodos para crear el objeto pedido en el arraylist
     */
    public void ingresarPedido(){
        pedido = new ArrayList();
            String Talla=leerTalla();
            String Tipo=leerTipo();
            boolean estampado=leerBooleano();
            pedido.add(new Polera(Talla,Tipo,estampado));
    }

    /**
     *
     * @return Tipo de polera
     */
    public String leerTipo(){
        String tipo="";
        System.out.println("Ingrese el numero del tipo de la polera \n 1.- algodon \n 2.- polyester \n 3.- spandex");
        try{
            int num=leerTeclado();
            switch(num){
                case 1:
                    tipo="algodon";
                case 2:
                    tipo="polyester";
                case 3:
                    tipo="spandex";
            }
            return tipo;
        }catch(InputMismatchException e){
            tipo="polyester";
            return tipo;
        }
        }

    /**
     *
     * @return Talla e polera
     */
    public String leerTalla(){
        String talla="";
        System.out.println("Ingrese el numero de la talla de la polera \n 1.-S \n 2.M \n 3.-L \n 4.-XL");
        try{
            int num=leerTeclado();
            switch(num){
                case 1:
                   talla ="S";
                case 2:
                    talla="M";
                case 3:
                    talla="L";
                case 4:
                    talla="XL";
            }
            return talla;
        }catch(InputMismatchException e){
            talla="L";
            return talla;
        }
    }

    /**
     *
     * @return true o false, si quieren estapado o no
     */
    public boolean leerBooleano(){
        boolean estampado=false; 
        try{
        System.out.println("Ingrese 0 si desea su polera con estampado o un 1 si desea su polera sin estampado");
        int num=leerTeclado();
        if (num == 0) {
            estampado = true;
        } else if (num == 1) {
            estampado = false;
        }
        }catch (InputMismatchException e){
            System.out.println("no lleva estampado");
            estampado=false;
        }
        return estampado;
    }

    /**
     *
     * @param  posicion a borrar
     * borra el pedido indicado
     */
    public void quitarPedido(int posicion) {
        try{
            pedido.remove(posicion);
        }catch (NullPointerException e){
            System.out.println("no hay pedidos para borrar");
        }
        
    }

    /**
     * tostring para mostrar arraylist
     */
    public void mostrarPedido(){
        try{
        for(int i=0;i<pedido.size();i++){
            System.out.println(pedido.get(i).toString());
        }
        }catch(NullPointerException e){
                System.out.println("no hay pedidos");
                }
    }

    /**
     *
     * @return el numero ingresado por pantalla
     */
    public int leerTeclado() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        try {
            numero = teclado.nextInt();
            if (numero < 0) {
                System.out.println("ingrese un numero mayor que 0");
                leerTeclado();
            }
        } catch (InputMismatchException e) {
            System.out.println("Dato ingresado incorrecto, ingrese un numero");
            numero = leerTeclado();
        }
        return numero;
    }

    /**
     * menu de para elegir que hacer
     */
    public void menu(){
            System.out.println(" 1.Agregar pedido \n 2.Quitar pedido \n 3.Mostrar pedidos \n 4.Salir");
            int opcion = leerTeclado();
            switch(opcion){
                case 1:
                    ingresarPedido();
                    menu();
                    break;
                case 2:
                    System.out.println("ingrese el numero de pedido a quitar");
                    int posicion=leerTeclado();
                    quitarPedido(posicion-1);
                    menu();
                    break;
                case 3:
                    mostrarPedido();
                    menu();
                    break;
                case 4:
                    break;
                default:
                    break;
                
            }
    
    }
}
