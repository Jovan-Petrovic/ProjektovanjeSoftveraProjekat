/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Film;
import domen.Projekcija;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import kontroler.Kontroler;
import model.FilmTableModel;
import model.ProjekcijaTableModel;

/**
 *
 * @author Bron Zilar
 */
public class FProjekcija extends javax.swing.JDialog {

    private Film film;
    
    /**
     * Creates new form FProjekcija
     */
    public FProjekcija(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
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

        jPanel1 = new javax.swing.JPanel();
        jlabId = new javax.swing.JLabel();
        jtxtId = new javax.swing.JTextField();
        jlabDatum = new javax.swing.JLabel();
        jtxtDatum = new javax.swing.JTextField();
        jlabSala = new javax.swing.JLabel();
        jtxtSala = new javax.swing.JTextField();
        jlabFilm = new javax.swing.JLabel();
        jbtnPretraziFilm = new javax.swing.JButton();
        jtxtFilm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProjekcije = new javax.swing.JTable();
        jbtnDodajProjekciju = new javax.swing.JButton();
        jbtnObrisiProjekciju = new javax.swing.JButton();
        jbtnIzadji = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova projekcija"));

        jlabId.setText("Id:");

        jtxtId.setEnabled(false);

        jlabDatum.setText("Datum:");

        jlabSala.setText("Sala:");

        jlabFilm.setText("Film:");

        jbtnPretraziFilm.setText("Pretrazi film");
        jbtnPretraziFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziFilmActionPerformed(evt);
            }
        });

        jtblProjekcije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblProjekcije);

        jbtnDodajProjekciju.setText("Dodaj projekciju");
        jbtnDodajProjekciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajProjekcijuActionPerformed(evt);
            }
        });

        jbtnObrisiProjekciju.setText("Obrisi projekciju");
        jbtnObrisiProjekciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiProjekcijuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnDodajProjekciju, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226)
                                .addComponent(jbtnObrisiProjekciju))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabId, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabSala, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtxtDatum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                        .addComponent(jtxtSala, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtxtFilm))
                                    .addComponent(jtxtId))))
                        .addGap(29, 29, 29)
                        .addComponent(jbtnPretraziFilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnPretraziFilm)
                    .addComponent(jlabFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabSala, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodajProjekciju)
                    .addComponent(jbtnObrisiProjekciju))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbtnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIzadji)
                    .addComponent(jbtnSacuvaj))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnPretraziFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziFilmActionPerformed
        try {
            JDialog forma = new FPretragaFilma(this, true, FormaMod.FORMA_DODAVANJE);
            forma.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnPretraziFilmActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        ProjekcijaTableModel ptm = (ProjekcijaTableModel) jtblProjekcije.getModel();
        List<Projekcija> projekcije = ptm.vratiProjekcije();        
            //        try {
//            for (Projekcija projekcija : projekcije) {
//                projekcija = Kontroler.getInstanca().sacuvajProjekciju(projekcija);                
//            }
//            
//        } catch (Exception ex) {
//            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            boolean odgovor = Kontroler.getInstanca().sacuvajSveprojekcije(projekcije);
            if(odgovor) {
                JOptionPane.showMessageDialog(this, "Sve projekcije su uspesno sacuvane.");
            } else {
                JOptionPane.showMessageDialog(this, "Doslo je do greske. Projekcije nisu uspesno sacuvane.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jbtnDodajProjekcijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajProjekcijuActionPerformed
        Film f = this.film;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        Date datum = null;
        try {
            datum = sdf.parse(jtxtDatum.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sala = jtxtSala.getText().trim();
        Projekcija p = new Projekcija(-1l, datum, sala, film);
        ProjekcijaTableModel ptm = (ProjekcijaTableModel) jtblProjekcije.getModel();
        ptm.dodajProjekciju(p);
    }//GEN-LAST:event_jbtnDodajProjekcijuActionPerformed

    private void jbtnObrisiProjekcijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiProjekcijuActionPerformed
        int selektovanRed = jtblProjekcije.getSelectedRow();
        if(selektovanRed != -1) {
            ProjekcijaTableModel ptm = (ProjekcijaTableModel) jtblProjekcije.getModel();
            ptm.obrisiProjekciju(selektovanRed);
        } else {
            JOptionPane.showMessageDialog(this, "Morate prvo selektovati red");
        }
    }//GEN-LAST:event_jbtnObrisiProjekcijuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDodajProjekciju;
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnObrisiProjekciju;
    private javax.swing.JButton jbtnPretraziFilm;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JLabel jlabDatum;
    private javax.swing.JLabel jlabFilm;
    private javax.swing.JLabel jlabId;
    private javax.swing.JLabel jlabSala;
    private javax.swing.JTable jtblProjekcije;
    private javax.swing.JTextField jtxtDatum;
    private javax.swing.JTextField jtxtFilm;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtSala;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() throws Exception {
        jtxtFilm.setEditable(false);
        ProjekcijaTableModel ptm = new ProjekcijaTableModel();
        jtblProjekcije.setModel(ptm);
    }

    public JTextField getJtxtFilm() {
        return jtxtFilm;
    }

    public void setJtxtFilm(JTextField jtxtFilm) {
        this.jtxtFilm = jtxtFilm;
    }

    private void sacuvajProjekciju() throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            Date datum = sdf.parse(jtxtDatum.getText().trim());
            String sala = jtxtSala.getText().trim();
            List<Film> filmovi = Kontroler.getInstanca().vratiSveFilmove();
            Film f = null;
            for (Film film : filmovi) {
                if(jtxtFilm.getText().equals(film.getNaziv())) {
                    f = film;
                }
            }
            Projekcija projekcija = new Projekcija(null, datum, sala, f);
            projekcija = Kontroler.getInstanca().sacuvajProjekciju(projekcija);
            JOptionPane.showMessageDialog(this, "Projekcija je sacuvana sa ID-em: " + projekcija.getId());
        } catch (ParseException ex) {
            Logger.getLogger(FProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
}
