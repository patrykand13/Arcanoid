package com.arcanoid;

import javax.swing.ImageIcon;

public class Ball extends Sprite {

    private int moveX;
    private int moveY;

    public Ball() {

        initBall();
    }

    private void initBall() {
        
        moveX = 1;
        moveY = -1;

        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() {

        var ii = new ImageIcon("src/resources/ball.png");
        image = ii.getImage();
    }

    void move() {

        x += moveX;
        y += moveY;

        if (x == 0) {

            setXDir(1);
        }

        if (x == Commons.WIDTH - imageWidth) {
            setXDir(-1);
        }

        if (y == 0) {
            setYDir(1);
        }
    }

    private void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {

        moveX = x;
    }

    void setYDir(int y) {

        moveY = y;
    }

    int getYDir() {

        return moveY;
    }
}
