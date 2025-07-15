import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class sCROLL extends JPanel implements MouseListener {
    // Class Variables
    public static BufferedImage screen1;

    // Default Setting for JPanel
    public sCROLL(){
        setPreferredSize(new Dimension(3000, 450));
        this.setFocusable(true);
        addMouseListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // Clears the screen
        g.setFont(new Font("Copperlate", Font.BOLD, 50));
        g.drawString("213", 50, 50);
        g.drawImage(screen1, 0, 0, null);

    }

    public static void main(String[] args) throws IOException {
        // Image Importation
        screen1 = ImageIO.read(new File("backgroundwith.png"));

        JFrame frame = new JFrame(("checkcoords"));
        sCROLL panel = new sCROLL();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {

        System.out.println(e.getX() +" " +e.getY());

    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
}
