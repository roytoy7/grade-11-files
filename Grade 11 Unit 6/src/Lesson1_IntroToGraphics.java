import java.awt.*; // little micro stuff like adding a scrollbar or tabs
import javax.swing.*; //responsible for heavier stuff like panel and frame
// java completed JPanel, an incomplete class
// Extend means that we'll complete the JPanel class
// which was left incomplete by the Java developers

// The moment you extend it, this Java class(Lesson1_Intro) BECOMES a panel
public class Lesson1_IntroToGraphics extends JPanel{

    // Setting up the JPanel
    public Lesson1_IntroToGraphics(){
        setPreferredSize(new Dimension(800, 450));

    }

    public void paintComponent(Graphics g){
        g.setColor(new Color(99, 133, 255));
        g.drawLine(50, 75, 400, 240);
        g.fillRect(30, 300, 200, 100);

        g.setColor(new Color(255, 134, 180));
        g.fillRect(500, 400, 50, 50);

        g.setColor(new Color(98,20,165));
        g.fillOval(450, 100, 100, 50);

        g.setColor(new Color(246, 227, 10));
        g.fillArc(350, 360, 100, 100, 30, 300);

        g.setColor(new Color(245, 121, 46));
        g.setFont(new Font("Impact", Font.BOLD, 50));
        // Unlike most of the draw commands where it uses the top left corner
        // This one uses top right wow :3
        g.drawString("KAILYN!!!!!!!", 34, 60);

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Kailyn's First Lesson!"); // use new for anything not primitive
        Lesson1_IntroToGraphics panel = new Lesson1_IntroToGraphics();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
