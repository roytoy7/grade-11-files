import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;


public class Lesson3_KeyListener extends JPanel implements KeyListener{
    // Class Variables
    public static BufferedImage ninja;
    public static int ninjaX = 275;
    public static int ninjaY = 215;
    public Lesson3_KeyListener(){
        setPreferredSize(new Dimension(600, 480));
        this.setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g){
        // Clear screen command
        super.paintComponent(g);
        g.drawImage(ninja, ninjaX, ninjaY, null);
    }

    // Key Listener Methods:
    // The computer needs to know what commands to execute
    // for the following 3 situations:
    // keyPressed, keyReleased, and keyTyped
    // You must have these 3 methods, otherwise it won't run </3
    // You can choose to not fill in the commands if you do not plan on using it
    public void keyPressed(KeyEvent e){
        // Capture WASD
        if (e.getKeyChar() == 'w') {
            ninjaY -= 10;
            // NEVER USE THIS GRRR paintComponent(this.getGraphics());
            repaint();
        }
        if (e.getKeyChar() == 'a') {
            ninjaX -= 10;
            repaint();
        }
        if (e.getKeyChar() == 's') {
            ninjaY += 10;
            repaint();
        }
        if (e.getKeyChar() == 'd') {
            ninjaX += 10;
            repaint();
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    public static void main(String[] args) throws IOException{
        ninja = ImageIO.read(new File("forehead.png"));
        JFrame frame = new JFrame("Lesson 3 - Key Listener");
        Lesson3_KeyListener panel = new Lesson3_KeyListener();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

