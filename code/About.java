
package game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class About extends JPanel implements Commons
{
    private Breakout mainFrame;
    private Font font;
    About(Breakout mainframe)
    {
        this.mainFrame = mainframe;
        this.font = new Font((String)null, 1, 20);
        this.setBackground(Color.decode("#1b3a4e"));
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 400));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                mainFrame.setPanel("MainMenu");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(50, 50, 20, 20);
    }

    @Override
    public void doGameCycle() {

    }
}
