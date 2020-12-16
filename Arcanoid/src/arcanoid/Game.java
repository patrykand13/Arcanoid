/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcanoid;

/**
 *
 * @author Patryk
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startBT = new javax.swing.JButton();
        settingsBT = new javax.swing.JButton();
        QuitBT = new javax.swing.JButton();
        breakP = new javax.swing.JLabel();
        padleMailP = new javax.swing.JLabel();
        padleMain2P = new javax.swing.JLabel();
        ballP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        breakP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/break.jpg"))); // NOI18N

        padleMailP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/padleMain.png"))); // NOI18N

        padleMain2P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/padleMain2.png"))); // NOI18N

        ballP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/ball.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(padleMailP)
                .addGap(78, 78, 78)
                .addComponent(startBT)
                .addGap(18, 18, 18)
                .addComponent(settingsBT)
                .addGap(10, 10, 10)
                .addComponent(QuitBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ballP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(padleMain2P)
                .addContainerGap())
            .addComponent(breakP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(padleMailP)
                        .addComponent(padleMain2P)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startBT)
                            .addComponent(settingsBT)
                            .addComponent(QuitBT)))
                    .addComponent(ballP, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(breakP))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBTActionPerformed
        start();
    }//GEN-LAST:event_startBTActionPerformed

    private void settingsBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBTActionPerformed
        settings();
    }//GEN-LAST:event_settingsBTActionPerformed

    private void QuitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitBTActionPerformed
        quit();
    }//GEN-LAST:event_QuitBTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    public void start(){
        //open new 
        Breakout breakoutFrame = new Breakout();
        breakoutFrame.setVisible(true);
        //close this frame
        this.dispose();
    }
    public void settings(){
        //open new 
        Settings settingsFrame = new Settings();
        settingsFrame.setVisible(true);
        settingsFrame.pack();
        settingsFrame.setLocationRelativeTo(null);
        //close this frame
        this.dispose();
    }
    public void quit(){
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton QuitBT;
    private javax.swing.JLabel ballP;
    private javax.swing.JLabel breakP;
    private javax.swing.JLabel padleMailP;
    private javax.swing.JLabel padleMain2P;
    private javax.swing.JButton settingsBT;
    private javax.swing.JButton startBT;
    // End of variables declaration//GEN-END:variables
}
