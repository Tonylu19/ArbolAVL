
package com.mycompany.arbolavltarea4;

public class Nodo {
    int d;
    int fe;
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;
    int dato;
    
    
    public Nodo (int d){
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    
    }
    
    public String textoGraphviz(String dato){
        if(hijoIzquierdo == null && this.hijoDerecho == null){
          return String.value(dato);
        }else {
            String texto ="";
            if(hijoIzquierdo !=null){
                texto = dato + "->" +hijoIzquierdo.textoGraphviz()+ "\n";
            }
            if(hijoDerecho !=null){
                texto = dato + "->" +hijoDerecho.textoGraphviz()+ "\n";
             }
            return texto;
           } 
        }

   