/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.DomenskiObjekat;
import domen.Film;
import domen.Zanr;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kontroler.Kontroler;
import model.FilmTableModel;

/**
 *
 * @author Bron Zilar
 */
public class FPretragaFilma extends javax.swing.JDialog {

    FProjekcija fp;
    /**
     * Creates new form FPretragaFilma
     */
    public FPretragaFilma(java.awt.Frame parent, boolean modal, FormaMod formaMod) throws Exception {
        super(parent, modal);
        initComponents();
        if(formaMod.equals(FormaMod.FORMA_PRETRAGA)) {
            jbtnDodaj.setVisible(false);
        }
        if(parent instanceof FGlavnaFormaKorisnik) {
            jbtnIzmeni.setVisible(false);
        }
        
        setLocationRelativeTo(null);
        
        pripremiFormu();
    }
    
    public FPretragaFilma(java.awt.Dialog parent, boolean modal, FormaMod formaMod) throws Exception {
        super(parent, modal);
        fp = (FProjekcija) parent;
        initComponents();
        jbtnIzmeni.setVisible(false);
        setLocationRelativeTo(null);
        if(formaMod.equals(FormaMod.FORMA_PRETRAGA)) {
            jbtnDodaj.setEnabled(false);
        }
        
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
        jtblFilmovi = new javax.swing.JTable();
        jlblPretraziPoZanru = new javax.swing.JLabel();
        jcomboPretraziPoZanru = new javax.swing.JComboBox<>();
        jlblPretraziPoImenu = new javax.swing.JLabel();
        jtxtPretraziPoImenu = new javax.swing.JTextField();
        jbtnDetalji = new javax.swing.JButton();
        jbtnIzadji = new javax.swing.JButton();
        jbtnPretrazi = new javax.swing.JButton();
        jbtnDodaj = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtblFilmovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblFilmovi);

        jlblPretraziPoZanru.setText("Pretrazi po zanru:");

        jcomboPretraziPoZanru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlblPretraziPoImenu.setText("Pretrazi po imenu:");

        jbtnDetalji.setText("Detalji");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        jbtnIzadji.setText("Izadji");
        jbtnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzadjiActionPerformed(evt);
            }
        });

        jbtnPretrazi.setText("Pretrazi");
        jbtnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziActionPerformed(evt);
            }
        });

        jbtnDodaj.setText("Dodaj");
        jbtnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlblPretraziPoImenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblPretraziPoZanru, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcomboPretraziPoZanru, 0, 284, Short.MAX_VALUE)
                            .addComponent(jtxtPretraziPoImenu))
                        .addGap(309, 309, 309))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnIzadji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnIzmeni)
                        .addGap(36, 36, 36)
                        .addComponent(jbtnDodaj)
                        .addGap(55, 55, 55)
                        .addComponent(jbtnDetalji)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPretraziPoZanru, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboPretraziPoZanru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnPretrazi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPretraziPoImenu)
                    .addComponent(jtxtPretraziPoImenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDetalji)
                    .addComponent(jbtnIzadji)
                    .addComponent(jbtnDodaj)
                    .addComponent(jbtnIzmeni))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
        Zanr zanr = (Zanr) jcomboPretraziPoZanru.getSelectedItem();
        String naziv = jtxtPretraziPoImenu.getText().trim();
        TableModel tm = jtblFilmovi.getModel();
        FilmTableModel ftm = (FilmTableModel) tm;
        ftm.pretraziFilmove(zanr, naziv);
        if(jtblFilmovi.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje filmove po zadatoj vrednosti!");
        }
    }//GEN-LAST:event_jbtnPretraziActionPerformed

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        int selektovanRed = jtblFilmovi.getSelectedRow();
        if(selektovanRed == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red!");
            return;
        }
        TableModel tm = jtblFilmovi.getModel();
        FilmTableModel ftm = (FilmTableModel) tm;
        Long id = (Long) ftm.getValueAt(selektovanRed, 0);
        Film film = ftm.nadjiFilm(id);
        JDialog forma;
        try {
            forma = new FFilmDetalji(this, true, film, FormaMod.FORMA_PRETRAGA);
            forma.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FPretragaFilma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void jbtnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajActionPerformed
        int selektovanRed = jtblFilmovi.getSelectedRow();
        TableModel tm = jtblFilmovi.getModel();
        FilmTableModel ftm = (FilmTableModel) tm;
        Film film = ftm.vratiFilm(selektovanRed);
//        String naziv = (String) ftm.getValueAt(selektovanRed, 1);
//        fp.getJtxtFilm().setText(naziv);
//        fp.setFilm(ftm.nadjiFilm(Long.valueOf((Long) ftm.getValueAt(selektovanRed, 0))));
        fp.getJtxtFilm().setText(film.getNaziv());
        fp.setFilm(film);
//        JOptionPane.showMessageDialog(this, "Uspesno dodat film: " + naziv);
        this.setVisible(false);
    }//GEN-LAST:event_jbtnDodajActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        int selektovanRed = jtblFilmovi.getSelectedRow();
        if(selektovanRed == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
            return;
        }
        TableModel tm = jtblFilmovi.getModel();
        FilmTableModel ftm = (FilmTableModel) tm;
//        Long id = (Long) ftm.getValueAt(selektovanRed, 0);
//        Film film = ftm.nadjiFilm(id);
          Film film = ftm.vratiFilm(selektovanRed);
        JDialog forma;
        try {
            forma = new FFilmDetalji(this, true, film, FormaMod.FORMA_IZMENA);
            forma.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FPretragaFilma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JButton jbtnDodaj;
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JComboBox<Object> jcomboPretraziPoZanru;
    private javax.swing.JLabel jlblPretraziPoImenu;
    private javax.swing.JLabel jlblPretraziPoZanru;
    private javax.swing.JTable jtblFilmovi;
    private javax.swing.JTextField jtxtPretraziPoImenu;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() throws Exception {
        popuniZanrove();
        
        List<Film> filmovi = (List<Film>)Kontroler.getInstanca().vratiSveFilmove();
        jtblFilmovi.setModel(new FilmTableModel(filmovi));
    }

    private void popuniZanrove() {
        jcomboPretraziPoZanru.removeAllItems();
        
        jcomboPretraziPoZanru.addItem(Zanr.AKCIJA);
        jcomboPretraziPoZanru.addItem(Zanr.DOKUMENTARNI);
        jcomboPretraziPoZanru.addItem(Zanr.DRAMA);
        jcomboPretraziPoZanru.addItem(Zanr.HOROR);
        jcomboPretraziPoZanru.addItem(Zanr.KOMEDIJA);
        jcomboPretraziPoZanru.addItem(Zanr.MISTERIJA);
        jcomboPretraziPoZanru.addItem(Zanr.NAUCNA_FANTASTIKA);
        jcomboPretraziPoZanru.addItem(Zanr.TRILER);
    }

}
