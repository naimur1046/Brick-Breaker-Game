package game1;


import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Breakout extends JFrame implements KeyListener, ActionListener{

    JPanel currentPanel;
    Commons currentStage;
    Timer timer;
    public Breakout() {

        initUI();
    }

    private void initUI() {
        Menu menu = new Menu(this);
        currentPanel = menu;
        currentStage = menu;
        add(currentPanel);
        addKeyListener(this);
        setTitle("Breakout");
        setBounds(10,10,700,600);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new Breakout();
            game.setVisible(true);
        });
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
