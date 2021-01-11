package com.arcanoid;

import javax.swing.ImageIcon;

public class Brick extends Sprite {

    private boolean isDestroyed;
    public boolean bonusbrick=false;

    public Brick(int x, int y,boolean bonus) {
        initBrick(x, y, bonus);
    }
    
    private void initBrick(int x, int y,boolean bonus) {
        this.x = x;
        this.y = y;
        bonusbrick=bonus;
        
        isDestroyed = false;

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
        return isDestroyed;
    }

    void setDestroyed(boolean val) {
        isDestroyed = val;
    }
}
