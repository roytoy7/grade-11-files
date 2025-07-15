import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Lesson2_ImportingImages extends JPanel{

    // Class Variable: a type of GLOBAL VARIABLE
    // that are accessible in any methods inside this java class file
    public static BufferedImage ninja;

    public Lesson2_ImportingImages(){
        setPreferredSize(new Dimension(600, 480));
    }

    public void paintComponent(Graphics g){
        g.drawImage(ninja, 275, 215, null);
    }

    public static void main(String[] args) throws IOException{
        ninja = ImageIO.read(new File("forehead.png"));
        // import b4 frame
        JFrame frame = new JFrame("Lesson 2");
        Lesson2_ImportingImages panel = new Lesson2_ImportingImages();
        frame.add(panel);
        frame.setVisible(true);
    }
}
