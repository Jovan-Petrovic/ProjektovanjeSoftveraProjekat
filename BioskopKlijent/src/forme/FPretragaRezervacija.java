/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Film;
import domen.Korisnik;
import domen.Projekcija;
import domen.Rezervisanje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kontroler.Kontroler;
import model.RezervisanjeTableModel;

/**
 *
 * @author Bron Zilar
 */
public class FPretragaRezervacija extends javax.swing.JDialog {
 
    Korisnik k;
    
    /**
     * Creates new form FPretragaRezervacija
     */
    public FPretragaRezervacija(java.awt.Frame parent, boolean modal, Korisnik korisnik) throws Exception {
        super(parent, modal);
        initComponents();
        k = korisnik;
        setLocationRelativeTo(null);
        setTitle("Korisnik: " + k.getIme() + " " + k.getPrezime());
        
        pripremiFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRezervacije = new javax.swing.JTable();
        jlabSveProjekcije = new javax.swing.JLabel();
        jbtnIzadji = new javax.swing.JButton();
        jbtnFilmDetalji = new javax.swing.JButton();
        jbtnOtkazivanjeRezervacije = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblRezervacije);

        jlabSveProjekcije.setText("Sve Vase rezervacije:");

        jbtnIzadji.setText("Izadji");
        jbtnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzadjiActionPerformed(evt);
            }
        });

        jbtnFilmDetalji.setText("Detalji o filmu");
        jbtnFilmDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFilmDetaljiActionPerformed(evt);
            }
        });

        jbtnOtkazivanjeRezervacije.setText("Otkazi rezervaciju");
        jbtnOtkazivanjeRezervacije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOtkazivanjeRezervacijeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabSveProjekcije, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jbtnIzadji)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnFilmDetalji)
                            .addGap(51, 51, 51)
                            .addComponent(jbtnOtkazivanjeRezervacije))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlabSveProjekcije, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIzadji)
                    .addComponent(jbtnFilmDetalji)
                    .addComponent(jbtnOtkazivanjeRezervacije))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnFilmDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFilmDetaljiActionPerformed
        int selektovanRed = jtblRezervacije.getSelectedRow();
        RezervisanjeTableModel rtm = (RezervisanjeTableModel) jtblRezervacije.getModel();
        Rezervisanje rezervisanje = rtm.vratiRezervisanje(selektovanRed);
        Long filmID = rezervisanje.getProjekcija().getFilm().getId();
        List<Film> filmovi = null;
        try {
           filmovi = Kontroler.getInstanca().vratiSveFilmove();
        } catch (Exception ex) {
            Logger.getLogger(FPretragaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        Film f = null;
        for (Film film : filmovi) {
            if(film.getId().equals(filmID)) {
                f = film;
                break;
            }
        }
        JDialog forma;
        try {
            forma = new FFilmDetalji(this, true, f, FormaMod.FORMA_PRETRAGA);
            forma.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FPretragaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnFilmDetaljiActionPerformed

    private void jbtnOtkazivanjeRezervacijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOtkazivanjeRezervacijeActionPerformed
        int rezultat = JOptionPane.showConfirmDialog(this, "Da li zaista zelite da otkazete rezervaciju?", "Potvrda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(rezultat == JOptionPane.YES_OPTION) {
            otkaziRezervaciju();
        }
    }//GEN-LAST:event_jbtnOtkazivanjeRezervacijeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnFilmDetalji;
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnOtkazivanjeRezervacije;
    private javax.swing.JLabel jlabSveProjekcije;
    private javax.swing.JTable jtblRezervacije;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() throws Exception {
        List<Rezervisanje> svaRezervisanja = Kontroler.getInstanca().vratiSvaRezervisanja();
        List<Rezervisanje> korisnikovaRezervisanja = new ArrayList<>();
        for (Rezervisanje rezervisanje : svaRezervisanja) {
            if(rezervisanje.getKorisnik().getId().equals(k.getId())) {
                korisnikovaRezervisanja.add(rezervisanje);
            }
        }
        jtblRezervacije.setModel(new RezervisanjeTableModel(korisnikovaRezervisanja));
    }

    private void otkaziRezervaciju() {
        int selektovanRed = jtblRezervacije.getSelectedRow();
        Long projekcijaID = (Long) jtblRezervacije.getValueAt(selektovanRed, 0);
        List<Projekcija> projekcije = null;
        try {
            projekcije = Kontroler.getInstanca().vratiSveProjekcije();
        } catch (Exception ex) {
            Logger.getLogger(FPretragaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        Projekcija p = null;
        for (Projekcija projekcija : projekcije) {
            if(projekcija.getId().equals(projekcijaID)) {
                p = projekcija;
            }
        }
        boolean signal = false;
        Map<String,Long> podaci = new HashMap<>();
        podaci.put("projekcijaID", projekcijaID);
        podaci.put("korisnikID", k.getId());
        try {
            //signal = Kontroler.getInstanca().obrisiRezervaciju(projekcijaID, k.getId());
            signal = Kontroler.getInstanca().obrisiRezervaciju(podaci);
        } catch (Exception ex) {
            Logger.getLogger(FPretragaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(signal) {
            JOptionPane.showMessageDialog(this, "Rezervacija filma " + p.getFilm().getNaziv() + " datuma " + p.getDatum() + " je uspesno obrisana");
        } else {
            JOptionPane.showMessageDialog(this, "Doslo je do greske. Rezervacija filma " + p.getFilm().getNaziv() + " datuma " + p.getDatum() + " nije uspesno obrisana");
        }
    }
}
