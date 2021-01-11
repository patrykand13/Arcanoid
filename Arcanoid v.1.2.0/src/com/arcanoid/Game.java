/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcanoid;

import java.awt.*;

public class Game extends javax.swing.JFrame {

    public Game() {
        
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        startBT = new javax.swing.JButton();
        settingsBT = new javax.swing.JButton();
        QuitBT = new javax.swing.JButton();
        padleMailP = new javax.swing.JLabel();
        padleMain2P = new javax.swing.JLabel();
        ballP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arcanoid");

        startBT.setText("Start");
        startBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBTActionPerformed(evt);
            }
        });

        settingsBT.setText("Settings");
        settingsBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBTActionPerformed(evt);
            }
        });

        QuitBT.setText("Quit");
        QuitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitBTActionPerformed(evt);
            }
        });

        padleMailP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/padleMain.png"))); // NOI18N

        padleMain2P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/padleMain2.png"))); // NOI18N

        ballP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/ball.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/breakers.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(padleMailP)
                .addGap(23, 23, 23)
                .addComponent(startBT)
                .addGap(18, 18, 18)
                .addComponent(settingsBT)
                .addGap(18, 18, 18)
                .addComponent(QuitBT)
                .addGap(18, 18, 18)
                .addComponent(padleMain2P))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(ballP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(padleMailP)
                    .addComponent(padleMain2P)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startBT)
                            .addComponent(settingsBT)
                            .addComponent(QuitBT))))
                .addGap(6, 6, 6)
                .addComponent(ballP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
        );

        pack();
    }

    private void startBTActionPerformed(java.awt.event.ActionEvent evt) {
        Breakout breakoutFrame = new Breakout();
        breakoutFrame.setVisible(true);
        this.dispose();
    }

    private void settingsBTActionPerformed(java.awt.event.ActionEvent evt) {
        Settings settingsFrame = new Settings();
        settingsFrame.setVisible(true);
        settingsFrame.pack();
        this.dispose();
    }

    private void QuitBTActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    private javax.swing.JButton QuitBT;
    private javax.swing.JLabel ballP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel padleMailP;
    private javax.swing.JLabel padleMain2P;
    private javax.swing.JButton settingsBT;
    private javax.swing.JButton startBT;
}
