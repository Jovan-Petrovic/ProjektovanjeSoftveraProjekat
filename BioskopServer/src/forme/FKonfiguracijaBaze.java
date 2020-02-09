/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bron Zilar
 */
public class FKonfiguracijaBaze extends javax.swing.JDialog {

    /**
     * Creates new form FKonfiguracijaBaze
     */
    public FKonfiguracijaBaze(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try {
            srediFormu();
        } catch (IOException ex) {
            Logger.getLogger(FKonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblDriver = new javax.swing.JLabel();
        jlblURL = new javax.swing.JLabel();
        jlblUsername = new javax.swing.JLabel();
        jlblPassword = new javax.swing.JLabel();
        jtxtDriver = new javax.swing.JTextField();
        jtxtURL = new javax.swing.JTextField();
        jtxtUsername = new javax.swing.JTextField();
        jtxtPassword = new javax.swing.JTextField();
        jbtnIzadji = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Konfiguracija baze");

        jlblDriver.setText("Driver:");

        jlblURL.setText("URL:");

        jlblUsername.setText("Username:");

        jlblPassword.setText("Password:");

        jbtnIzadji.setText("Izadji");
        jbtnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzadjiActionPerformed(evt);
            }
        });

        jbtnSacuvaj.setText("Sacuvaj");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIzadji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(jbtnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlblDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                            .addComponent(jlblPassword))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtDriver)
                            .addComponent(jtxtURL)
                            .addComponent(jtxtUsername)
                            .addComponent(jtxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDriver)
                    .addComponent(jtxtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblURL)
                    .addComponent(jtxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblUsername)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPassword)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIzadji)
                    .addComponent(jbtnSacuvaj))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        FileInputStream in = null;
        try {
            in = new FileInputStream("db.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            
            FileOutputStream out = new FileOutputStream("db.properties");
            props.setProperty("driver", jtxtDriver.getText().trim());
            props.setProperty("url", jtxtURL.getText().trim());
            props.setProperty("user", jtxtUsername.getText().trim());
            props.setProperty("password", jtxtPassword.getText().trim());
            props.store(out, null);
            out.close();
            JOptionPane.showMessageDialog(this, "Uspesno promenjeni parametari za konfiguraciju baze.");
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom cuvanja promenjenih parametara", "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FKonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom cuvanja promenjenih parametara", "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FKonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(FKonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JLabel jlblDriver;
    private javax.swing.JLabel jlblPassword;
    private javax.swing.JLabel jlblURL;
    private javax.swing.JLabel jlblUsername;
    private javax.swing.JTextField jtxtDriver;
    private javax.swing.JTextField jtxtPassword;
    private javax.swing.JTextField jtxtURL;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() throws FileNotFoundException, IOException {
        FileInputStream in=new FileInputStream("db.properties");
        Properties props=new Properties();
        props.load(in);
        String driver=props.getProperty("driver");
        String url=props.getProperty("url");
        String user=props.getProperty("user");
        String password=props.getProperty("password");
        
        jtxtDriver.setText(driver);
        jtxtURL.setText(url);
        jtxtUsername.setText(user);
        jtxtPassword.setText(password);
        
        setLocationRelativeTo(null);
    }
}
