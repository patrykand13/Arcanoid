package com.arcanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board extends JPanel {

    private Timer timer;
    private String message = "Game Over";
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;
    private boolean inGame = true;
    private String level = "easy";
    private int size = 0;
    public boolean bonus = false;
    private int time =0;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        JButton button = new JButton("Go to menu");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game gameFrame = new Game();
                gameFrame.setVisible(true);
                gameFrame.pack();
                setVisible(false);

            }
        });
        add(button);
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
        File myObj;
        try{
            myObj = new File("difficulty.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                level = myReader.nextLine();
            }
            myReader.close();
        }catch(IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

        gameInit();
    }

    private void gameInit() {



        ball = new Ball();
        paddle = new Paddle();

        int k = 0;
        int sizeI=3;
        size =18;
        if(level.equals("medium")){
            sizeI=10;
            size = 60;
        }
        if(level.equals("hard")){
            sizeI=15;
            size = 90;
        }
        bricks = new Brick[size];
        Random r = new Random();
        int rn = 0;
        boolean bonus = false;
        for (int i = 0; i < sizeI; i++) {
            for (int j = 0; j < 6; j++) {
                rn = r.nextInt() % 10;
                if(rn==1){
                    bonus=true;
                }
                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50,bonus);
                bonus=false;
                k++;
            }
        }



        timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {

            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {

        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                ball.getImageWidth(), ball.getImageHeight(), this);
        if(bonus==false) {
            g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                    paddle.getImageWidth(), paddle.getImageHeight(), this);
        }else if(bonus==true&&time<=600){
            var ii = new ImageIcon("src/resources/bonuspaddle.png");
            g2d.drawImage(ii.getImage(), paddle.getX(), paddle.getY(),
                    80, paddle.getImageHeight(), this);
            time++;
        }else if(time>600){
            time =0;
            bonus=false;
        }

        for (int i = 0; i < size; i++) {

            if (!bricks[i].isDestroyed()) {

                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getImageWidth(),
                        bricks[i].getImageHeight(), this);
            }
        }
    }

    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);

        g2d.drawString(message,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.WIDTH / 2);
        g2d.drawString("On difficulty: "+level,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2 -30,
                Commons.WIDTH / 2+50);

    }



    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            paddle.keyPressed(e);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {

        ball.move();
        paddle.move();
        checkCollision();
        repaint();
    }

    private void stopGame() {

        inGame = false;
        timer.stop();
    }

    private void checkCollision() {

        if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {

            stopGame();
        }

        for (int i = 0, j = 0; i < size; i++) {

            if (bricks[i].isDestroyed()) {

                j++;
            }

            if (j == size) {

                message = "Victory";
                stopGame();
            }
        }
        int paddleLPosY = (int) paddle.getRect().getMinY();
        int ballLPosY = (int) ball.getRect().getMinY();
        int paddleLPos = (int) paddle.getRect().getMinX();
        int ballLPos = (int) ball.getRect().getMinX();
        int first = paddleLPos + 8;
        int second = paddleLPos + 16;
        int third = paddleLPos + 24;
        int fourth = paddleLPos + 32;
        int last = paddleLPos +40;
        if(bonus==true){
            first = paddleLPos + 16;
            second = paddleLPos + 32;
            third = paddleLPos + 48;
            fourth = paddleLPos + 64;
            last = paddleLPos +80;
        }
        if(ballLPosY>=paddleLPosY && ballLPos>=paddleLPos && ballLPos<=last){
            if (ballLPos < first) {

                ball.setXDir(-1);
                ball.setYDir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {

                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {

                ball.setXDir(0);
                ball.setYDir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {

                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos > fourth) {

                ball.setXDir(1);
                ball.setYDir(-1);
            }
        }

        for (int i = 0; i < size; i++) {

            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight)) {

                        ball.setXDir(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {

                        ball.setXDir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {

                        ball.setYDir(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {

                        ball.setYDir(-1);
                    }

                    bricks[i].setDestroyed(true);
                    if(bricks[i].bonusbrick==true){
                        bonus=true;
                    }
                }
            }
        }
    }
}
