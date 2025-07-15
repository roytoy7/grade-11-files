import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class Lesson5_MouseListener extends JPanel implements MouseListener{
    // Class Variables
    public static BufferedImage screen1;
    public static BufferedImage screen2;
    public static int gameState = 1;

    // Default Setting for JPanel
    public Lesson5_MouseListener(){
        setPreferredSize(new Dimension(400, 400));
        this.setFocusable(true);
        addMouseListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // Clears the screen
        if (gameState==1){
            g.drawImage(screen1, 0, 0, null);
        } else if (gameState==2){
            g.drawImage(screen2, 0, 0, null);
        }
    }

    public static void main(String[] args) throws IOException{
        // Image Importation
        screen1 = ImageIO.read(new File("screen1.png"));
        screen2 = ImageIO.read(new File("screen2.png"));

        JFrame frame = new JFrame(("Lesson 5 - Mouse Listener"));
        Lesson5_MouseListener panel = new Lesson5_MouseListener();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void mouseExited(MouseEvent e) {
        if (gameState==2){
            gameState =1;
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (gameState==1){
            // The commands to retrieve the x and y coords
            // e.getX() && e.getY
            // e.getButton()==1 is for left click
            if (e.getX()>= 80 && e.getX()<=320 && e.getY()>=70 && e.getY()<=150 && e.getButton()==1){
                gameState = 2;
                repaint();
            }
            //System.out.println("" + e.getX() +" " +e.getY());
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}



}
