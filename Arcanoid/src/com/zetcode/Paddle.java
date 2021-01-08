package com.zetcode;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Paddle extends Sprite  {

    private int dx;
    private String color ="blue";

    public Paddle() {
        File myObj;
        try{
            myObj = new File("paddlecolor.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                color = myReader.nextLine();
            }
            myReader.close();
        }catch(IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        initPaddle();        
    }
    
    private void initPaddle() {

        loadImage();
        getImageDimensions();

        resetState();
    }
    
    private void loadImage() {
        var ii = new ImageIcon("src/resources/paddle.png");
        if(color.equals("red")){
            ii = new ImageIcon("src/resources/redpaddle.png");
        }else if(color.equals("green")){
            ii = new ImageIcon("src/resources/greenpaddle.png");
        }
        image = ii.getImage();        
    }    

    void move() {

        x += dx;

        if (x <= 0) {

            x = 0;
        }

        if (x >= Commons.WIDTH - imageWidth) {

            x = Commons.WIDTH - imageWidth;
        }
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 1;
        }
    }

    void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

    private void resetState() {

        x = Commons.INIT_PADDLE_X;
        y = Commons.INIT_PADDLE_Y;
    }
}
