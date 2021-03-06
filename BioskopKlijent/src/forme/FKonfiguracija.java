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
public class FKonfiguracija extends javax.swing.JDialog {

    /**
     * Creates new form FKonfiguracija
     */
    public FKonfiguracija(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try {
            srediFormu();
        } catch (IOException ex) {
            Logger.getLogger(FKonfiguracija.class.getName()).log(Level.SEVERE, null, ex);
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

        jlblBrojPorta = new javax.swing.JLabel();
        jtxtBrojPorta = new javax.swing.JTextField();
        jlblIPAdresa = new javax.swing.JLabel();
        jtxtIPAdresa = new javax.swing.JTextField();
        jbtnIzadji = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Konfiguracija");

        jlblBrojPorta.setText("Soket broj porta:");

        jlblIPAdresa.setText("Adresa servera:");

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
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIzadji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(jbtnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblBrojPorta)
                            .addComponent(jlblIPAdresa))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtBrojPorta)
                            .addComponent(jtxtIPAdresa))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblBrojPorta)
                    .addComponent(jtxtBrojPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIPAdresa)
                    .addComponent(jtxtIPAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIzadji)
                    .addComponent(jbtnSacuvaj))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        FileInputStream in = null;
        try {
            in = new FileInputStream("klijent.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            
            FileOutputStream out = new FileOutputStream("klijent.properties");
            Integer s = 0;
            try {
                s = Integer.parseInt(jtxtBrojPorta.getText().trim());
                if(s<0 || s>65535) {
                props.setProperty("socket", "9000");
                props.setProperty("ip", "localhost");
                props.store(out, null);
                out.close();
                JOptionPane.showMessageDialog(this, "Broj porta mora biti u opsegu 0-65535", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
                }
            } catch(NumberFormatException ex) {
                props.setProperty("socket", "9000");
                props.setProperty("ip", "localhost");
                props.store(out, null);
                out.close();
                JOptionPane.showMessageDialog(this, "Port soketa mora biti ceo broj.", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            props.setProperty("socket", s.toString());
            props.setProperty("ip", jtxtIPAdresa.getText().trim());
            props.store(out, null);
            out.close();
            JOptionPane.showMessageDialog(this, "Uspesno promenjeni parametari za konfiguraciju.");
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom cuvanja promenjenih parametara", "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FGlavnaFormaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom cuvanja promenjenih parametara", "Greska", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FGlavnaFormaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(FGlavnaFormaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JLabel jlblBrojPorta;
    private javax.swing.JLabel jlblIPAdresa;
    private javax.swing.JTextField jtxtBrojPorta;
    private javax.swing.JTextField jtxtIPAdresa;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() throws FileNotFoundException, IOException {
        FileInputStream in=new FileInputStream("klijent.properties");
        Properties props=new Properties();
        props.load(in);
        
        String brojPorta = props.getProperty("socket");
        String ip = props.getProperty("ip");
        
        jtxtBrojPorta.setText(brojPorta);
        jtxtIPAdresa.setText(ip);
        
        setLocationRelativeTo(null);
    }
}
