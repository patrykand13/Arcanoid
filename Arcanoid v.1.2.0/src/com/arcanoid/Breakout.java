package com.arcanoid;

import javax.swing.JFrame;
import java.awt.*;

public class Breakout extends JFrame {


    public Breakout() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());
        setTitle("Arcanoid");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2-155, dim.height/2-this.getSize().height/2-215);
        setResizable(false);
        pack();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var game = new Breakout();
            game.setVisible(true);
        });
    }
    public void wylacz (){
        this.dispose();
    }
}

