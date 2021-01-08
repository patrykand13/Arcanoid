package com.zetcode;

import javax.swing.ImageIcon;

public class Brick extends Sprite {

    private boolean destroyed;
    private boolean bonusbrick=false;

    public Brick(int x, int y,boolean bonus) {
        initBrick(x, y, bonus);
    }
    
    private void initBrick(int x, int y,boolean bonus) {
        
        this.x = x;
        this.y = y;
        bonusbrick=bonus;
        
        destroyed = false;

        loadImage();
        getImageDimensions();
    }
    
    private void loadImage() {
        var ii = new ImageIcon("src/resources/brick.png");
        if(bonusbrick==true){
            ii = new ImageIcon("src/resources/brickbonus.png");
        }
        image = ii.getImage();        
    }

    boolean isDestroyed() {
        return destroyed;
    }

    void setDestroyed(boolean val) {
        System.out.println("tutaj "+val +"czy bonus "+bonusbrick);
        if(bonusbrick==false){
            Paddle padl = new Paddle();
            var ii = new ImageIcon("src/resources/paddle.png");
            padl.image = ii.getImage();
        }
        destroyed = val;
    }
}