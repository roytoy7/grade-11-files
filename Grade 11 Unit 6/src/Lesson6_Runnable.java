import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class Lesson6_Runnable extends JPanel implements KeyListener, Runnable{
    // Class Variables
    public static BufferedImage ninja;
    public static int ninjaX = 0;
    public static int ninjaY = 0;
    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;
    // JPanel Settings
    public Lesson6_Runnable(){
        setPreferredSize(new Dimension(500, 500));
        // Adding keylistener
        this.setFocusable(true);
        addKeyListener(this);
        // Adding Thread (Timer)
        Thread thread = new Thread(this);
        thread.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (wPressed) ninjaY -=5;
        if (aPressed) ninjaX -=5;
        if (sPressed) ninjaY +=5;
        if (dPressed) ninjaX +=5;
        g.drawImage(ninja, ninjaX, ninjaY, null);

    }
    public static void main(String[] args) throws IOException{
        // Image Importation
        ninja = ImageIO.read(new File("forehead.png"));

        // Graphics Window
        JFrame frame = new JFrame("Lesson 6 - Runnable");
        Lesson6_Runnable panel = new Lesson6_Runnable();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void run() {
        while(true){
            // Screen Freeze
            try{
                Thread.sleep(20);
            }
            catch (Exception e){}

            // Redraw
            repaint();

            // Note: If you implement runnable, there should only be one repaint command
        }
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='w'){
            wPressed = true;
        } if (e.getKeyChar()=='a'){
            aPressed = true;
        }if (e.getKeyChar()=='s'){
            sPressed = true;
        }if (e.getKeyChar()=='d'){
            dPressed = true;
        }
    }


    // useless
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar()=='w'){
            wPressed = false;
        } if (e.getKeyChar()=='a'){
            aPressed = false;
        }if (e.getKeyChar()=='s'){
            sPressed = false;
        }if (e.getKeyChar()=='d'){
            dPressed = false;
        }
    }


}
