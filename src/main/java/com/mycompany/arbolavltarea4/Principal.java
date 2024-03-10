
package com.mycompany.arbolavltarea4;

public class Principal {

    public static void main(String[] args) {
        ArbolAVL arbol = null ArbolAVL();
        
        arbol.insertar(8);
        arbol.insertar(7);
        arbol.insertar(5);
        arbol.insertar(4);
        arbol.insertar(2);
        arbol.insertar(9);
        arbol.insertar(15);
        arbol.insertar(14);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(21);
        arbol.insertar(16);
        arbol.insertar(0);
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(3);
        
        arbol.dibujarGraphviz();
        System.out.println("En orden");
        arbol.inOrden(arbol.obtenerRaiz());
        System.out.println("Pre orden");
        arbol.preOrden(arbol.obtenerRaiz());
        System.out.println("Poat orden");
        arbol.posOrden(arbol.obtenerRaiz());
               
    }

    private static void ArbolAVL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
