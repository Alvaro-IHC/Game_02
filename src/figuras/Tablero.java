package figuras;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Tablero extends JComponent implements Runnable, KeyListener{
    public static final int ANCHO = 1000;
    public static final int ALTO = 550;
    private boolean w, s, up, down;
    JFrame ventana;
    Pelota pe ;
    Paleta p1;
    Paleta p2;
    public Tablero() {
        pe = new Pelota();
        p1 = new Paleta(1);
        p2 = new Paleta(2);
        ventana = new JFrame("GAME 02");
        ventana.add(this);
        ventana.addKeyListener(this);
        ventana.setBounds(0, 0, ANCHO+15, ALTO+35);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        //ventana.setResizable(false);
        ventana.add(pe);
        ventana.add(p2);
        ventana.add(p1);
    }

    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);                                
        g2.drawLine(ANCHO/2, 0, ANCHO/2, ALTO);
        g2.drawOval(ANCHO/2-150, ALTO/2-150, 300, 300);
        g2.setFont(new Font("Arial", Font.BOLD, 50));        
        g2.drawString(p1.getPuntos()+"", ANCHO / 2 - 90, 50);
        g2.drawString(p2.getPuntos()+"", ANCHO / 2 + 65, 50);
    }

    @Override
    public void run() {
        while(true){
            pe.mover(p1, p2);
            p1.mover(w, s);
            p2.mover(up, down);
            paintImmediately(0, 0, ANCHO, ALTO);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
    }
    
    
    
}
