import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class Lesson4_GameStateTransition extends JPanel implements KeyListener{

    // Game State Variable
    // gs0 = menu
    // gs1 = level 1
    // gs2 = level 2
    // gs3 = win
    // gs4 = lose
    // gs5 = creds

    // Image Variables
    public static int gs = 0;
    public static BufferedImage gs0;
    public static BufferedImage gs1;
    public static BufferedImage gs2;
    public static BufferedImage gs3;
    public static BufferedImage gs4;
    public static BufferedImage gs5;


    public Lesson4_GameStateTransition(){
        setPreferredSize(new Dimension(500, 500));
        this.setFocusable(true);
        addKeyListener(this);
    }
    public void paintComponent(Graphics g){
        if (gs==0){
            g.drawImage(gs0, 0, 0, null);
        }
        else if (gs==1){
            g.drawImage(gs1, 0, 0, null);
        }
        else if (gs==2){
            g.drawImage(gs2, 0, 0, null);
        }
        else if (gs==3){
            g.drawImage(gs3, 0, 0, null);
        }
        else if (gs==4){
            g.drawImage(gs4, 0, 0, null);
        }
        else if (gs==5){
            g.drawImage(gs5, 0, 0, null);
        }
    }
    public void keyPressed(KeyEvent e){
        if (gs==0){
            if (e.getKeyChar()=='s'){
                gs = 1;
                repaint();
            }
            else if (e.getKeyChar()=='c'){
                gs = 5;
                repaint();
            }
        } else if (gs==1){
            if (e.getKeyChar()=='+'){
                gs = 2;
                repaint();
            }
            else if (e.getKeyChar()=='-'){
                gs = 4;
                repaint();
            }
        } else if (gs==2){
            if (e.getKeyChar()=='+'){
                gs = 3;
                repaint();
            }
            else if (e.getKeyChar()=='-'){
                gs = 4;
                repaint();
            }
        } else if (gs==3||gs==4){
            gs = 0;
            repaint();
        } else if (gs==5){
            if (e.getKeyCode()==27){
                gs = 0;
                repaint();
            }
        }
    }

    public static void main (String[] args) throws IOException{
        // Image Importation
        gs0 = ImageIO.read(new File("gs0.png"));
        gs1 = ImageIO.read(new File("gs1.png"));
        gs2 = ImageIO.read(new File("gs2.png"));
        gs3 = ImageIO.read(new File("gs3.png"));
        gs4 = ImageIO.read(new File("gs4.png"));
        gs5 = ImageIO.read(new File("gs5.png"));

        JFrame frame = new JFrame("Lesson 4 - Game State Transition");
        Lesson4_GameStateTransition panel = new Lesson4_GameStateTransition();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }


    //useless methods
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}


}
