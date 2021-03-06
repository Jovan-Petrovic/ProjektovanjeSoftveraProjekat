/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import niti.ServerNit;

/**
 *
 * @author Bron Zilar
 */
public class FMain extends javax.swing.JFrame {

    private ServerNit serverNit;
    
    /**
     * Creates new form FMain
     */
    public FMain() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmbGlavniMeni = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jmiStart = new javax.swing.JMenuItem();
        jmiStop = new javax.swing.JMenuItem();
        jmKonfiguracija = new javax.swing.JMenu();
        jmiKonfiguracijaServera = new javax.swing.JMenuItem();
        jmiKonfiguracijaBaze = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        jmServer.setText("Server");

        jmiStart.setText("Start");
        jmiStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiStartActionPerformed(evt);
            }
        });
        jmServer.add(jmiStart);

        jmiStop.setText("Stop");
        jmiStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiStopActionPerformed(evt);
            }
        });
        jmServer.add(jmiStop);

        jmbGlavniMeni.add(jmServer);

        jmKonfiguracija.setText("Konfiguracija");

        jmiKonfiguracijaServera.setText("Konfiguracija servera");
        jmiKonfiguracijaServera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKonfiguracijaServeraActionPerformed(evt);
            }
        });
        jmKonfiguracija.add(jmiKonfiguracijaServera);

        jmiKonfiguracijaBaze.setText("Konfiguracija baze");
        jmiKonfiguracijaBaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKonfiguracijaBazeActionPerformed(evt);
            }
        });
        jmKonfiguracija.add(jmiKonfiguracijaBaze);

        jmbGlavniMeni.add(jmKonfiguracija);

        setJMenuBar(jmbGlavniMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiStartActionPerformed
        if (serverNit == null || !serverNit.isAlive()) {
            try {
                serverNit = new ServerNit();
                serverNit.start();
            } catch (IOException ex) {
                Logger.getLogger(FMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jmiStartActionPerformed

    private void jmiStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiStopActionPerformed
        if (serverNit != null && serverNit.getServerSocket().isBound()) {
            try {
                serverNit.zaustaviServerskuNit();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Server je zaustavljen");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jmiStopActionPerformed

    private void jmiKonfiguracijaBazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiKonfiguracijaBazeActionPerformed
        JDialog forma = new FKonfiguracijaBaze(this, true);
        forma.setVisible(true);
    }//GEN-LAST:event_jmiKonfiguracijaBazeActionPerformed

    private void jmiKonfiguracijaServeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiKonfiguracijaServeraActionPerformed
        JDialog forma = new FKonfiguracijaServera(this, true);
        forma.setVisible(true);
    }//GEN-LAST:event_jmiKonfiguracijaServeraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jmKonfiguracija;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbGlavniMeni;
    private javax.swing.JMenuItem jmiKonfiguracijaBaze;
    private javax.swing.JMenuItem jmiKonfiguracijaServera;
    private javax.swing.JMenuItem jmiStart;
    private javax.swing.JMenuItem jmiStop;
    // End of variables declaration//GEN-END:variables
}
