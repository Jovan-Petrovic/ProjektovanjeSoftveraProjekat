/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import kontroler.Kontroler;

/**
 *
 * @author Bron Zilar
 */
public class FPrijava extends javax.swing.JFrame {

    /**
     * Creates new form FPrijava
     */
    public FPrijava() {
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

        jlabKorisnickoIme = new javax.swing.JLabel();
        jabLozinka = new javax.swing.JLabel();
        jtxtKorisnickoIme = new javax.swing.JTextField();
        jbtnIzlaz = new javax.swing.JButton();
        jbtnPrijava = new javax.swing.JButton();
        jlabKorisnickoImeGreska = new javax.swing.JLabel();
        jlabLozinkaGreska = new javax.swing.JLabel();
        jtxtLozinka = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabKorisnickoIme.setText("Korisnicko ime:");

        jabLozinka.setText("Lozinka:");

        jbtnIzlaz.setText("Izlaz");
        jbtnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzlazActionPerformed(evt);
            }
        });

        jbtnPrijava.setText("Prijava");
        jbtnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIzlaz)
                        .addGap(177, 177, 177)
                        .addComponent(jbtnPrijava))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jabLozinka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabKorisnickoImeGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jlabLozinkaGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtLozinka))))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabKorisnickoIme)
                    .addComponent(jtxtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jlabKorisnickoImeGreska)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabLozinka)
                    .addComponent(jtxtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jlabLozinkaGreska)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnPrijava)
                    .addComponent(jbtnIzlaz))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrijavaActionPerformed
        try {
            validacija(jtxtKorisnickoIme, jtxtLozinka);
            
            //dispose();
            if(jtxtKorisnickoIme.getText().equals("a") && jtxtLozinka.getText().equals("a")) {
                new FGlavnaFormaAdmin().setVisible(true);
                dispose();
            } else {
                List<Korisnik> korisnici = new ArrayList<>();
                korisnici = Kontroler.getInstanca().vratiSveKorisnike();
                for (Korisnik korisnik : korisnici) {
                    if(korisnik.getKorisnickoIme().equals(jtxtKorisnickoIme.getText().trim()) && korisnik.getSifra().equals(jtxtLozinka.getText().trim())) {
                        new FGlavnaFormaKorisnik(korisnik).setVisible(true);
                        dispose();
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FPrijava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnPrijavaActionPerformed

    private void jbtnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzlazActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzlazActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jabLozinka;
    private javax.swing.JButton jbtnIzlaz;
    private javax.swing.JButton jbtnPrijava;
    private javax.swing.JLabel jlabKorisnickoIme;
    private javax.swing.JLabel jlabKorisnickoImeGreska;
    private javax.swing.JLabel jlabLozinkaGreska;
    private javax.swing.JTextField jtxtKorisnickoIme;
    private javax.swing.JPasswordField jtxtLozinka;
    // End of variables declaration//GEN-END:variables

    private void validacija(JTextField jtxtKorisnickoIme, JTextField jtxtLozinka) throws Exception {
        jlabKorisnickoIme.setText("");
        jlabLozinkaGreska.setText("");
        
        if(jtxtKorisnickoIme.getText().isEmpty()) {
            jlabKorisnickoImeGreska.setText("Korisnicko ime je prazno");
            throw new Exception("Korisnicko ime ne moze biti prazno");
        }
        if(String.valueOf(this.jtxtLozinka.getPassword()).isEmpty()) {
            jlabLozinkaGreska.setText("Lozinka je prazna");
            throw new Exception("Lozinka ne sme biti prazna");
        }
    }
}