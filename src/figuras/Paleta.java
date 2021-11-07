package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Paleta extends JComponent {
    
    private final int w = 50;       // Ancho
    private final int h = 200;      // Alto
    private int x;                  // Posicion en x
    private int y;                  // Posicion en y
    private int r;                  // Rojo       
    private int g;                  // Verde
    private int b;                  // Azul
    private int numero;             // Identificador
    private int puntos;             // Score
    
    public Paleta(int num) {
        setBounds(0, 0, Tablero.ANCHO, Tablero.ALTO ); //Determinar espacio del diseño
        puntos = 0;                         // Inicializamos puntos en cero
        numero = num;                       // Pasamos al campo el valor num
        x = num == 1 ? 10: Tablero.ANCHO - w -10;   // Operador ternario   
        //var  = <comparacion> ? valor_verdadero: valor_falso;
        // posicionando la paleta horizontalmente dependiendo el identificador numero
        y = Tablero.ALTO / 2 - h / 2; //posicionando verticamente
    }

    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;         // Conversion
        //g2.setColor(new Color(r, this.g, b));
        g2.fillRoundRect(x, y, w, h, 20, 20);   // Dibujar la paleta
    }
    
    public void mover(boolean arriba, boolean abajo){
        
        int velocidad = 10; //Velocidad de la paleta
        if (arriba) {       // arriba == true
            y = y - velocidad; // desplazar la paleta hacia arriba 
            if (y < 0) {    // Preguntando si llego a la parte superior
                y = 0;      // y nos aseguramos que no suba mas
            }            
        }
        if (abajo) {        // abajo  == true
            y = y + velocidad;  //desplazar la paleta hacia abajo
            if (y + h > Tablero.ALTO) { // Preguntando si llego a la parte inferior
                y = Tablero.ALTO - h;   // y nos aseguramos que no baje mas
            }
        }

    }
    

    int getPosX() {
        return x;
    }

    int getW() {
        return w;
    }

    int getPosY() {
        return y;
    }

    int getH() {
        return h;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuntos() {
        return puntos;
    }

    public void incrementarPuntos() {
        puntos++;
    }
    
    
}
