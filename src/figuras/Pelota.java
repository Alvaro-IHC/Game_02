package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Pelota extends JComponent{
    
    private final int w = 30;   // Ancho
    private final int h = 30;   // Alto
    private int x;              // posicion en x
    private int y;              // posicion en y
    private int dx = 1;         // direccion horizontal
    private int dy = 1;         // direccion vertical
    private int cantRebotes;    // contador de la Cantidad de rebotes
    private int velocidad;      // velocidad de la pelota
    private int r;              // rojo
    private int g;              // verde
    private int b;              // azul
    
    

    public Pelota() {
        setBounds(0, 0, Tablero.ANCHO, Tablero.ALTO );//espacio de diseño
        cantRebotes = 0;    //inicializamos cantidad de rebotes
        velocidad = 7;      //inicializamos la velocidad
        x = Tablero.ANCHO / 2 - w / 2;  //calcular el centro de la ventana
        y = Tablero.ALTO / 2 - h / 2;   //calcular el centro de la ventana
        r = 125;
        g = 51;
        b = 200;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(r, this.g, b));    //Asignamos color azul
        g2.fillOval(x, y, w, h);                 // Dibujamos la pelota
    }
    
    
    
    
    public void mover(Paleta p1, Paleta p2){
        velocidad = 5;// 
        
        y = y + dy*velocidad; //mover verticamente
        x = x + dx*velocidad; //mover horizontalmente
        /********** Colisiones con los bordes de la ventana  *********///
        if (y < 0)      // Colision con la parte superior
            dy = 1;         // direccion hacia abajo
        if (y + h > Tablero.ALTO) // Colision con la parte inferior
            dy = -1;
        
        if (x < 0){            //Colision con el lado izquierdo
            cantRebotes = 0;    //resetear rebotes
            p2.incrementarPuntos(); //incrementando puntos del jugador 2
            dx = 1;                 //cambiamos la direccion de x
            x = Tablero.ANCHO / 2 - w / 2;  //centramos horizontalmente
            y = Tablero.ALTO / 2 - h / 2;//centramos verticalmente
        }if (x + w > Tablero.ANCHO){    //Colision con el lado derecho
            cantRebotes = 0;
            p1.incrementarPuntos();//incrementando puntos del jugador 1
            dx = -1;
            x = Tablero.ANCHO / 2 - w / 2;
            y = Tablero.ALTO / 2 - h / 2;
        }
        /********** Colisiones con las paletas  *********///
        
        if (x < p1.getPosX()+p1.getW() && y > p1.getPosY() && y + h < p1.getPosY()+p1.getH()){//Colision con P1
            dx = 1 + (cantRebotes / 2);
            cantRebotes++;
            x = p1.getPosX() + p1.getW();
        }
        if (x + w > p2.getPosX() && y > p2.getPosY() && y + h < p2.getPosY()+p2.getH()){    //Colision con P2
            cantRebotes++;
            dx = - 1 - (cantRebotes / 2);
            x = p2.getPosX() - w;
        }
    }

 
    
    
}
