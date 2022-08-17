package game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Menu extends JPanel implements Commons {


    Font optionFont, titleFont;
    ArrayList<String> options;
    int cursorPosition;
    Breakout mainFrame;
    Menu(Breakout mainframe){
        mainFrame =mainframe;
        optionFont = new Font(null, Font.BOLD, 20);
        titleFont = new Font(null, Font.BOLD, 30);
        cursorPosition = 0;
        setupOptions();
        setBackground(Color.decode("#1b3a4e"));

        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));

    }

    public void drawCenteredText(Graphics g, String text, Font font, Color color, int x, int y){
        FontMetrics metrics = g.getFontMetrics(font);
        x = x - metrics.stringWidth(text) / 2;
        y = y - metrics.getHeight() / 2;
        g.setFont(font);
        g.setColor(color);
        g.drawString(text, x, y + metrics.getHeight());
    }

    private void setupOptions(){
        options = new ArrayList<>();
        Collections.addAll(options, "Start", "About", "Quit");
    }

    public void doGameCycle(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCenteredText(g, "Brick Breaker", titleFont, Color.decode("#dbd7b6"),
                150, 100);

        for (int i = 0; i < options.size(); i++){
            if (i == cursorPosition){
                g.setColor(Color.decode("#96a78e"));
                g.fillRect(50, 170 + i * 40, 200, 30);
            }
            drawCenteredText(g, options.get(i), optionFont, Color.decode("#dbd7b6"),
                    150, 180 + i * 40);
        }
    }



    private void selectOption(){
        switch (options.get(cursorPosition)){
            case "Start":
                mainFrame.setPanel("Game");
                break;
            case "About":
                mainFrame.setPanel("About");
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                cursorPosition = (cursorPosition - 1 + options.size()) % options.size();
                break;
            case KeyEvent.VK_DOWN:
                cursorPosition = (cursorPosition + 1) % options.size();
                break;
            case KeyEvent.VK_ENTER:
                selectOption();
                break;

        }

    }

    public void keyReleased(KeyEvent e){
    }
}
