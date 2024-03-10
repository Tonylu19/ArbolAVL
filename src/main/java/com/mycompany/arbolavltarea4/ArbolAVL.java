
package com.mycompany.arbolavltarea4;

import static java.time.Clock.system;

public class ArbolAVL {
    
    private Nodo raiz;
    public ArbolAVL(){
        raiz = null;
    }
    public Nodo obtenerRaiz(){
        return raiz;
    }
    public Nodo buscar(int d, Nodo r){
        if(raiz == null){
            return null;
        }else if(r.dato == d){
            return r;
        }else if(r.dato <d){
            return buscar (d,r.hijoDerecho);
        }else{
           return buscar(d,r.hijoDerecho); 
        }
    }
    
    public int obtenerFE(Nodo x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    
    public Nodo rotacionIzquierda(Nodo c){
        Nodo auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) +1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) +1;
        return auxiliar; 
    }
    
    public Nodo rotacionDerecha(Nodo c){
        Nodo auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) +1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) +1;
        return auxiliar;
    }
    
    public Nodo rotaciondobleIzquierda(Nodo c){
        c.hijoIzquierdo =  rotacionDerecha(c.hijoIzquierdo);
        Nodo temporal = rotacionIzquierda(c);
        return temporal;
    }
    
    public Nodo rotacionDobleDerecha (Nodo c){
        Nodo temporal;
        c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
        temporal = rotacionDerecha (c);
                return temporal;
    }
    
    public Nodo insertarAVL(Nodo nuevo, Nodo subAr){
        Nodo nuevoPadre = subAr;
        if(nuevo.dato < subAr.dato){
                if(subAr.hijoIzquierdo == null){
                    subAr.hijoIzquierdo = nuevo;
                }else{
                    subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                    if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho) == 2)){
                        if(nuevo.dato < subAr.hijoIzquierdo.dato){
                            nuevoPadre = rotacionIzquierda(subAr);
                        }else{
                            nuevoPadre = rotacionDerecha(subAr);
                        }
                    }
                }
        }
        else if (nuevo.dato > subAr.dato){
            if(subAr.hijoDerecho == null){
                subAr.hijoDerecho = nuevo;
            }else{
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)- obtenerFE(subAr.hijoIzquierdo) ==2)){
                    if(nuevo.dato> subAr.hijoDerecho.dato){
                    nuevoPadre = rotacionDerecha(subAr);
                   }else{
                        nuevoPadre = rotacionDobleDerecha(raiz);
                    }
                }
            }
        }else{
            system.out.println("Nodo duplicado");
        }
        
        if((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho!=null)){
            subAr.fe = subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho == null) && subAr.hijoIzquierdo!=null){
            subAr.fe = subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) +1;
        }
        return nuevoPadre;
    }
    
    public void insertar(int d){
        Nodo nuevo = new Nodo(d);
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = insertarAVL(nuevo, raiz);
        }
    }
    
    public void inOrden(Nodo r){
        if(r!=null){
            inOrden (r.hijoIzquierdo);
            System.out.println(r.dato+ " ");
            inOrden(r.hijoDerecho);
        }
    }

    public void preOrden(Nodo r){
        if(r!=null){
            System.out.println(r.dato+ " ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }
    
    public void posOrden(Nodo r){
        if(r!=null){
            posOrden(r.hijoIzquierdo);
            posOrden(r.hijoDerecho);
            System.out.println(r.dato+ " ");          
        }
    }
    
    public String obtenerCodigoGraphviz(){
        string texto = "digraph G\n"
                +"(\n)"
                +"      node[shape = circle]\n"
                +"      node[style = filled]\n"
                +"      node[fillcolor = \"#EEEEE\"]\n"
                +"      node[color = \"#EEEEE\"]\n"
                +"      edge[color = \"#31CEF0\"]\n";
        if(raiz !=null){
            texto += "\n";
            return texto;
        }   
    } 
    
    private void escribirArchivo(String ruta, String contenido){
        FileWriter fichero = null;
        PrintWrite pw = null;
            
        try{
            fichero = new FileWriter(ruta);
            pw = null PrintWriter(fichero);
            pw.Write(contenido);
            pw.close();
        }catch(Exeption e){
            System.out.println(e.getMessage());
        }finally{
            if(pw = !=null){
                pw.close();
            }
        }
    }
    
    public void dibujarGraphviz(){
        try{
            escribirArchivo("archivo.dot", obtenerCodigoGraphviz());
            ProcessBuilder;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "arbol.png", "archivo.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
            
        }catch (Exeption e){
            e.printStackTrace();
        }
    }
}
  