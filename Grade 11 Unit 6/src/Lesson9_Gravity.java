import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class Lesson9_Gravity extends JPanel implements KeyListener, Runnable{
    // Game Stats
    public static BufferedImage[] trex = new BufferedImage[3];
    public static int trexIndex = 0;
    public static int trexX = 110;
    public static int trexY = 206;
    public static int trexFrameCounter = 0;
    public static int velocity = -15;
    public static int gravity = 2;
    public static boolean isJumping = false;

    // JPanel
    public Lesson9_Gravity(){
        setPreferredSize(new Dimension(300, 300));
        this.setFocusable(true);
        addKeyListener(this);
        Thread thread = new Thread(this);
        thread.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (isJumping){
            trexIndex = 2;
            trexY += velocity;
            velocity += gravity;

            if (trexY==206){
                isJumping=false;
                trexIndex = 0;
                velocity = -15;
            }
        }
        else {  // If trex is NOT jumping, he's on the ground
            trexFrameCounter++;
            if (trexFrameCounter == 20) {
                trexIndex++;
                if (trexIndex == 2) trexIndex = 0;
                trexFrameCounter = 0;
            }
        }

        g.drawImage(trex[trexIndex], trexX, trexY, null);
    }
    public static void main(String[] args) throws IOException{
        // Image Importation
        trex[0] = ImageIO.read(new File("trexright.png"));
        trex[1] = ImageIO.read(new File("trexleft.png"));
        trex[2] = ImageIO.read(new File("trexjump.png"));

        JFrame frame = new JFrame("Lesson 9 - Gravity");
        Lesson9_Gravity panel = new Lesson9_Gravity();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==32){
            isJumping = true;
        }
    }


    public void keyReleased(KeyEvent e) {

    }


    public void run() {
        while(true){
            // sleep
            try{Thread.sleep(20);}
            catch(Exception e){}

            // 2) Drawing screen
            repaint();
        }
    }
}
