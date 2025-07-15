import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class Lesson7_SpriteAnimation extends JPanel implements KeyListener, Runnable{
    public static int posX = 50;
    public static int posY = 150;
    public static BufferedImage[] pikachus = new BufferedImage[4];
    public static int pikachuIndex = 0;
    public static int pikachuFrameCounter = 0;
    public static boolean aPressed = false;
    public static boolean dPressed = false;
    public Lesson7_SpriteAnimation(){
        setPreferredSize(new Dimension(500, 300));
        this.setFocusable(true);
        addKeyListener(this);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(aPressed) posX -=5;
        if(dPressed) posX +=5;
        g.drawImage(pikachus[pikachuIndex], posX, posY, null);
        // Adjust the sprite number

        pikachuFrameCounter++;
        if(pikachuFrameCounter==3) {
            pikachuIndex++;
            if (pikachuIndex == 4) pikachuIndex = 0;
            if (pikachuFrameCounter==3) pikachuFrameCounter = 0;
        }

    }

    public static void main(String[] args) throws IOException{
        // Image Importation
        pikachus[0] = ImageIO.read(new File("pikachu0.png"));
        pikachus[1] = ImageIO.read(new File("pikachu1.png"));
        pikachus[2] = ImageIO.read(new File("pikachu2.png"));
        pikachus[3] = ImageIO.read(new File("pikachu3.png"));

        JFrame frame = new JFrame("Lesson 7 - Sprite Animation");
        Lesson7_SpriteAnimation panel = new Lesson7_SpriteAnimation();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='a') aPressed = true;
        if(e.getKeyChar()=='d') dPressed = true;
    }
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='a') aPressed = false;
        if(e.getKeyChar()=='d') dPressed = false;
    }


    public void run() {
        while (true){
            // 1) Set up frame rate
            try{
                Thread.sleep(20);
            }
            catch(Exception e){}

            // 2) Redraw the screen
            repaint();
        }
    }


    // useless methods
    public void keyTyped(KeyEvent e) {}
}
