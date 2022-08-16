package game1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Breakout extends JFrame implements KeyListener, ActionListener{

    JPanel currentPanel;
    Commons currentStage;
    Timer timer;
    public Breakout() {

        Menu menu = new Menu(this);
        currentPanel = menu;
        currentStage = menu;
        add(currentPanel);
        addKeyListener(this);
        setTitle("Break-The-Brick");
        setBounds(10,10,700,600);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(600,500);
        pack();
        timer = new Timer(Commons.PERIOD, this);
        timer.start();

    }

    public void setPanel(String panelName){
        switch(panelName){
            case "Game":
                getContentPane().remove(currentPanel);
                Board game = new Board(this);
                currentStage = game;
                currentPanel = game;
                add(currentPanel);
                invalidate();
                revalidate();
                break;
            case "MainMenu":
                getContentPane().remove(currentPanel);
                Menu menu = new Menu(this);
                currentStage = menu;
                currentPanel = menu;
                add(currentPanel);
                invalidate();
                revalidate();
                break;
            case "About":
                getContentPane().remove(currentPanel);
                About about=new About(this);
                currentStage = about;
                currentPanel = about;
                add(currentPanel);
                invalidate();
                revalidate();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentStage.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentStage.keyReleased(e);
    }

    public void doGameCycle(){
        currentStage.doGameCycle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        doGameCycle();
    }
}
