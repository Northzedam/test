/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinwin;

/**
 *
 * @author Luciano Beemeequis
 */

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Contenedor extends JComponent {

    static JPanel panel;
    static int fila = 100;
    static int columna = 3;
    static int numero =1;
    
    Contenedor (JPanel panel){
        this.panel = panel;
        setBounds(0,0,panel.getWidth(),panel.getHeight());
        
        
    }
    
    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+numero+".png")).getImage());
        g.drawImage(imagen.getImage(),columna,fila,206,320,null);
      
    }
    
    static Thread hilo = new Thread(){
        
        @Override
        public void run(){
            try{
                while(true){
                
                    numero++;
                    if(numero==12){
                        numero=1;
                    }
                    panel.repaint();
                    
                    hilo.sleep(100);
                }  
            }catch (java.lang.InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
        }
    }; 
    
    public static void mover(){
        if(!hilo.isAlive()){
            hilo.start();
        }
        columna = 3;
    }
    
        
}
