package principal;

import figuras.Tablero;

public class Principal {
    
    //public static long startTime;

    public static void main(String[] args) {
        //startTime = System.currentTimeMillis();
        Tablero ta = new Tablero();
        Thread hilo = new Thread(ta);
        hilo.start();
        
    }
    
}
