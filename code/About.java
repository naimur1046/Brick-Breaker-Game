package game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class About extends JPanel implements Commons
{
    private Breakout mainFrame;
    private Font font;
    private Font font2;
    About(Breakout mainframe)
    {
        this.mainFrame = mainframe;
        this.font = new Font((String)null, 1, 20);
        this.font2 = new Font("Times New Roman",Font.BOLD,15);
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
        g.setColor(Color.decode("#F675A8"));
        g.setFont(font);
        g.drawString("Brick Breaker Game",20,20);
        g.setFont(font2);
        g.setColor(Color.decode("#1CD6CE"));
        g.drawString("Space Outlaw is a like fun brick breaking",20,45);
        g.drawString("game  with  the  theme  of space and ",20,60);
        g.drawString("intergalactic experiences! Come enjoy one",20,80);
        g.drawString(" of the best brick breaking games!",20,100);
        g.setFont(font);
        g.setColor(Color.decode("#F675A8"));
        g.drawString("How to play",20,120);
        g.setColor(Color.decode("#1CD6CE"));
        g.setFont(font2);
        g.drawString("->Easy and simple mechanics that anyone",20,145);
        g.drawString("can utilize and enjoy.",20,160);
        g.drawString("->Shoot the ball and break the bricks",20,180);
        g.drawString("->Take the ball by moving paddle.",20,200);
        g.drawString("->There are a things to destroy such",20,220);
        g.drawString("as bricks to win.",20,240);



    }

    @Override
    public void doGameCycle() {

    }
}
