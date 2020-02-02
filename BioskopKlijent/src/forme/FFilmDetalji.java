/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Film;
import domen.Glumac;
import domen.Glumi;
import domen.Reditelj;
import domen.Rezira;
import domen.Zanr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kontroler.Kontroler;
import model.GlumacTableModel;
import model.RediteljTableModel;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.Operacije;

/**
 *
 * @author Bron Zilar
 */
public class FFilmDetalji extends javax.swing.JDialog {

    Film film;
    
    /**
     * Creates new form FFilmDetalji
     */
    public FFilmDetalji(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        
        pripremiFormu1();
    }

    FFilmDetalji(FPretragaFilma aThis, boolean b, Film film, FormaMod formaMod) throws Exception {
        super(aThis, b);
        this.film = film;
        initComponents();
        setLocationRelativeTo(null);
        
        if(formaMod.equals(FormaMod.FORMA_PRETRAGA)) {
            pripremiFormu1();
        } else {
            pripremiFormu2();
        }
    }
    
    FFilmDetalji(FProjekcijaDetalji aThis, boolean b, Film film) throws Exception {
        super(aThis, b);
        this.film = film;
        initComponents();
        setLocationRelativeTo(null);
        
        pripremiFormu1();
    }
    
    FFilmDetalji(FPretragaRezervacija aThis, boolean b, Film film, FormaMod formaMod) throws Exception {
        super(aThis, b);
        this.film = film;
        initComponents();
        setLocationRelativeTo(null);
        
        if(formaMod.equals(FormaMod.FORMA_PRETRAGA)) {
            pripremiFormu1();
        } else {
            pripremiFormu2();
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

        jPanel1 = new javax.swing.JPanel();
        jlabID = new javax.swing.JLabel();
        jlabNaziv = new javax.swing.JLabel();
        jlabTrajanje = new javax.swing.JLabel();
        jlabZanr = new javax.swing.JLabel();
        jlabGodina = new javax.swing.JLabel();
        jlabJezik = new javax.swing.JLabel();
        jlabOcenaIMDb = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jtxtNaziv = new javax.swing.JTextField();
        jtxtTrajanje = new javax.swing.JTextField();
        jtxtGodina = new javax.swing.JTextField();
        jtxtJezik = new javax.swing.JTextField();
        jtxtOcenaIMDb = new javax.swing.JTextField();
        jlabReditelji = new javax.swing.JLabel();
        jlabGlumci = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblReditelji = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblGlumci = new javax.swing.JTable();
        jtxtZanr = new javax.swing.JTextField();
        jbtnIzadji = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();
        jcmbReditelji = new javax.swing.JComboBox();
        jcmbGlumci = new javax.swing.JComboBox();
        jbtnDodajReditelja = new javax.swing.JButton();
        jbtnObrisiReditelja = new javax.swing.JButton();
        jbtnDodajGlumca = new javax.swing.JButton();
        jbtnObrisiGlumca = new javax.swing.JButton();
        jbtnSacuvajPromene = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Film"));

        jlabID.setText("ID:");

        jlabNaziv.setText("Naziv:");

        jlabTrajanje.setText("Trajanje(min):");

        jlabZanr.setText("Zanr:");

        jlabGodina.setText("Godina:");

        jlabJezik.setText("Jezik:");

        jlabOcenaIMDb.setText("OcenaIMDb:");

        jtxtID.setEnabled(false);

        jtxtNaziv.setEnabled(false);

        jtxtTrajanje.setEnabled(false);

        jtxtGodina.setEnabled(false);

        jtxtJezik.setEnabled(false);

        jtxtOcenaIMDb.setEnabled(false);

        jlabReditelji.setText("Reditelji:");

        jlabGlumci.setText("Glumci:");

        jtblReditelji.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblReditelji);

        jtblGlumci.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtblGlumci);

        jtxtZanr.setEnabled(false);

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

        jcmbReditelji.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcmbGlumci.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnDodajReditelja.setText("Dodaj");
        jbtnDodajReditelja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajRediteljaActionPerformed(evt);
            }
        });

        jbtnObrisiReditelja.setText("Obrisi");
        jbtnObrisiReditelja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiRediteljaActionPerformed(evt);
            }
        });

        jbtnDodajGlumca.setText("Dodaj");
        jbtnDodajGlumca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajGlumcaActionPerformed(evt);
            }
        });

        jbtnObrisiGlumca.setText("Obrisi");
        jbtnObrisiGlumca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiGlumcaActionPerformed(evt);
            }
        });

        jbtnSacuvajPromene.setText("Sacuvaj promene");
        jbtnSacuvajPromene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajPromeneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlabReditelji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabNaziv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabTrajanje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabZanr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                    .addComponent(jtxtID)
                                    .addComponent(jtxtTrajanje)
                                    .addComponent(jtxtZanr, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcmbReditelji, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtnDodajReditelja)
                                        .addGap(80, 80, 80)
                                        .addComponent(jbtnObrisiReditelja)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlabGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabJezik, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabOcenaIMDb, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtJezik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtGodina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jbtnDodajGlumca)
                                                .addGap(47, 47, 47)
                                                .addComponent(jbtnObrisiGlumca))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jcmbGlumci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtxtOcenaIMDb, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))))))
                            .addComponent(jlabGlumci, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSacuvajPromene)
                        .addGap(41, 41, 41)
                        .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabID)
                    .addComponent(jtxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabGodina)
                    .addComponent(jtxtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabNaziv)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabJezik)
                    .addComponent(jtxtJezik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabTrajanje)
                    .addComponent(jtxtTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabOcenaIMDb)
                    .addComponent(jtxtOcenaIMDb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabZanr)
                    .addComponent(jtxtZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabReditelji)
                    .addComponent(jlabGlumci)
                    .addComponent(jcmbReditelji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbGlumci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodajReditelja)
                    .addComponent(jbtnObrisiReditelja)
                    .addComponent(jbtnDodajGlumca)
                    .addComponent(jbtnObrisiGlumca))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnSacuvaj)
                            .addComponent(jbtnIzadji)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnSacuvajPromene)))
                .addGap(18, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnIzadjiActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        Long id = Long.parseLong(jtxtID.getText().trim());
        String naziv = jtxtNaziv.getText().trim();
        int trajanje = Integer.parseInt(jtxtTrajanje.getText().trim());
        String z = jtxtZanr.getText().trim();
        ArrayList<String> zanrovi = new ArrayList<String>() {
            {
                add("KOMEDIJA");
                add("AKCIJA");
                add("TRILER");
                add("DRAMA");
                add("NAUCNA_FANTASTIKA");
                add("DOKUMENTARNI");
                add("MISTERIJA");
                add("HOROR");
                
            }
        };
        Zanr zanr = null;
        if(zanrovi.contains(z)) {
            zanr = Zanr.valueOf(jtxtZanr.getText().trim());
        } else {
            JOptionPane.showMessageDialog(this, "Morate uneti jedan od sledecih zanrova: KOMEDIJA, AKCIJA, TRILER, DRAMA, NAUCNA_FANTASTIKA, DOKUMENTARNI, MISTERIJA, HOROR");
            return;
        }
        int godina = Integer.parseInt(jtxtGodina.getText().trim());
        String jezik = jtxtJezik.getText().trim();
        double ocenaIMDb = Double.parseDouble(jtxtOcenaIMDb.getText().trim());
        
        Film film = new Film(id, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
        
        RediteljTableModel rtm = (RediteljTableModel) jtblReditelji.getModel();
        List<Reditelj> reditelji = rtm.getReditelji();
        GlumacTableModel gtm = (GlumacTableModel) jtblGlumci.getModel();
        List<Glumac> glumci = gtm.getGlumci();
        Map<String,Object> podaci = new HashMap<>();
        podaci.put("film", film);
        podaci.put("reditelji", reditelji);
        podaci.put("glumci", glumci);
        boolean status = false;
        try {
            //status = Kontroler.getInstanca().izmeniFilm(film);
            status = Kontroler.getInstanca().izmeniFilmRediteljeGlumce(podaci);
        } catch (IOException ex) {
            Logger.getLogger(FFilmDetalji.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FFilmDetalji.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(status) {
            JOptionPane.showMessageDialog(this, "Uspesno izmenjen film: " + film);
        } else {
            JOptionPane.showMessageDialog(this, "Doslo je do greske. Film nije uspesno izmenjen: " + film);
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jbtnObrisiRediteljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiRediteljaActionPerformed
        int selektovanRed = jtblReditelji.getSelectedRow();
        if(selektovanRed == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
            return;
        }
        RediteljTableModel rtm = (RediteljTableModel) jtblReditelji.getModel();
        Reditelj r = rtm.vratiReditelja(selektovanRed);
        rtm.obrisiRediteljaZaIzmenu(r);
    }//GEN-LAST:event_jbtnObrisiRediteljaActionPerformed

    private void jbtnObrisiGlumcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiGlumcaActionPerformed
        int selektovanRed = jtblGlumci.getSelectedRow();
        if(selektovanRed == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red");
            return;
        }
        GlumacTableModel gtm = (GlumacTableModel) jtblGlumci.getModel();
        Glumac g = gtm.vratiGlumca(selektovanRed);
        gtm.obrisiGlumcaZaIzmenu(g);
    }//GEN-LAST:event_jbtnObrisiGlumcaActionPerformed

    private void jbtnDodajRediteljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajRediteljaActionPerformed
        Reditelj reditelj = (Reditelj) jcmbReditelji.getSelectedItem();
        RediteljTableModel rtm = (RediteljTableModel) jtblReditelji.getModel();
        rtm.dodajRediteljaZaIzmenu(reditelj);
    }//GEN-LAST:event_jbtnDodajRediteljaActionPerformed

    private void jbtnDodajGlumcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajGlumcaActionPerformed
        Glumac glumac = (Glumac) jcmbGlumci.getSelectedItem();
        GlumacTableModel gtm = (GlumacTableModel) jtblGlumci.getModel();
        gtm.dodajGlumcaZaIzmenu(glumac);
    }//GEN-LAST:event_jbtnDodajGlumcaActionPerformed

    private void jbtnSacuvajPromeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajPromeneActionPerformed
        Long id = Long.parseLong(jtxtID.getText().trim());
        String naziv = jtxtNaziv.getText().trim();
        int trajanje = Integer.parseInt(jtxtTrajanje.getText().trim());
        String z = jtxtZanr.getText().trim();
        ArrayList<String> zanrovi = new ArrayList<String>() {
            {
                add("KOMEDIJA");
                add("AKCIJA");
                add("TRILER");
                add("DRAMA");
                add("NAUCNA_FANTASTIKA");
                add("DOKUMENTARNI");
                add("MISTERIJA");
                add("HOROR");
                
            }
        };
        Zanr zanr = null;
        if(zanrovi.contains(z)) {
            zanr = Zanr.valueOf(jtxtZanr.getText().trim());
        } else {
            JOptionPane.showMessageDialog(this, "Morate uneti jedan od sledecih zanrova: KOMEDIJA, AKCIJA, TRILER, DRAMA, NAUCNA_FANTASTIKA, DOKUMENTARNI, MISTERIJA, HOROR");
            return;
        }
        int godina = Integer.parseInt(jtxtGodina.getText().trim());
        String jezik = jtxtJezik.getText().trim();
        double ocenaIMDb = Double.parseDouble(jtxtOcenaIMDb.getText().trim());
        
        Film film = new Film(id, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
        
        RediteljTableModel rtm = (RediteljTableModel) jtblReditelji.getModel();
        List<Reditelj> reditelji = rtm.vratiSveReditelje();
        GlumacTableModel gtm = (GlumacTableModel) jtblGlumci.getModel();
        List<Glumac> glumci = gtm.vratiSveGlumce();
        Map<String,Object> podaci = new HashMap<>();
        podaci.put("film", film);
        podaci.put("reditelji", reditelji);
        podaci.put("glumci", glumci);
        
        boolean status = false;
        try {
            //status = Kontroler.getInstanca().izmeniFilm(film);
            status = Kontroler.getInstanca().izmeniFilmReziraGlumi(podaci);
        } catch (IOException ex) {
            Logger.getLogger(FFilmDetalji.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FFilmDetalji.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(status) {
            JOptionPane.showMessageDialog(this, "Uspesno izmenjen film: " + film);
        } else {
            JOptionPane.showMessageDialog(this, "Doslo je do greske. Film nije uspesno izmenjen: " + film);
        }
    }//GEN-LAST:event_jbtnSacuvajPromeneActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnDodajGlumca;
    private javax.swing.JButton jbtnDodajReditelja;
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnObrisiGlumca;
    private javax.swing.JButton jbtnObrisiReditelja;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JButton jbtnSacuvajPromene;
    private javax.swing.JComboBox jcmbGlumci;
    private javax.swing.JComboBox jcmbReditelji;
    private javax.swing.JLabel jlabGlumci;
    private javax.swing.JLabel jlabGodina;
    private javax.swing.JLabel jlabID;
    private javax.swing.JLabel jlabJezik;
    private javax.swing.JLabel jlabNaziv;
    private javax.swing.JLabel jlabOcenaIMDb;
    private javax.swing.JLabel jlabReditelji;
    private javax.swing.JLabel jlabTrajanje;
    private javax.swing.JLabel jlabZanr;
    private javax.swing.JTable jtblGlumci;
    private javax.swing.JTable jtblReditelji;
    private javax.swing.JTextField jtxtGodina;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtJezik;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTextField jtxtOcenaIMDb;
    private javax.swing.JTextField jtxtTrajanje;
    private javax.swing.JTextField jtxtZanr;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu1() throws Exception {
        jtxtID.setText(film.getId().toString());
        jtxtNaziv.setText(film.getNaziv());
        jtxtTrajanje.setText(film.getTrajanje()+"");
        jtxtZanr.setText(film.getZanr().toString());
        jtxtGodina.setText(film.getGodina()+"");
        jtxtJezik.setText(film.getJezik());
        jtxtOcenaIMDb.setText(film.getOcenaIMDb()+"");
        jbtnSacuvaj.setVisible(false);
        jcmbReditelji.setVisible(false);
        jcmbGlumci.setVisible(false);
        jbtnDodajReditelja.setVisible(false);
        jbtnObrisiReditelja.setVisible(false);
        jbtnDodajGlumca.setVisible(false);
        jbtnObrisiGlumca.setVisible(false);
        
        popuniTabeluReditelji();
        popuniTabeluGlumci();
        
    }
    
    private void pripremiFormu2() throws Exception {
        jtxtID.setText(film.getId().toString());
        jtxtNaziv.setText(film.getNaziv());
        jtxtTrajanje.setText(film.getTrajanje()+"");
        jtxtZanr.setText(film.getZanr().toString());
        jtxtGodina.setText(film.getGodina()+"");
        jtxtJezik.setText(film.getJezik());
        jtxtOcenaIMDb.setText(film.getOcenaIMDb()+"");
        
        jtxtNaziv.setEnabled(true);
        jtxtTrajanje.setEnabled(true);
        jtxtZanr.setEnabled(true);
        jtxtGodina.setEnabled(true);
        jtxtJezik.setEnabled(true);
        jtxtOcenaIMDb.setEnabled(true);
        
        popuniComboReditelji();
        popuniComboGlumci();
        popuniTabeluReditelji();
        popuniTabeluGlumci();
    }

    private void popuniTabeluReditelji() throws Exception {
        List<Rezira> reziranja = Kontroler.getInstanca().vratiSvaReziranja();
        List<Reditelj> reditelji = new ArrayList<>();
        for (Rezira rezira : reziranja) {
            if(rezira.getFilm().getId().equals(this.film.getId())) {
                Long rediteljID = rezira.getReditelj().getId();
                List<Reditelj> sviSvireditelji = Kontroler.getInstanca().vratiSveReditelje();
                for (Reditelj reditelj : sviSvireditelji) {
                    if(rediteljID.equals(reditelj.getId())) {
                        reditelji.add(reditelj);
                    }
                }
            }
        }
        RediteljTableModel rtm = new RediteljTableModel(reditelji);
        jtblReditelji.setModel(rtm);
        
    }

    private void popuniTabeluGlumci() throws Exception {
        List<Glumi> uloge = Kontroler.getInstanca().vratiSveUloge();
        List<Glumac> glumci = new ArrayList<>();
        for (Glumi glumi : uloge) {
            if(glumi.getFilm().getId().equals(this.film.getId())) {
                Long glumacID = glumi.getGlumac().getId();
                List<Glumac> sviGlumci = Kontroler.getInstanca().vratiSveGlumce();
                for (Glumac glumac : sviGlumci) {
                    if(glumacID.equals(glumac.getId())) {
                        glumci.add(glumac);
                    }
                }
            }
        }
        GlumacTableModel gtm = new GlumacTableModel(glumci);
        jtblGlumci.setModel(gtm);
    }

    private void popuniComboReditelji() throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_REDITELJE);
        Kontroler.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Kontroler.getInstanca().primiOdgovor();
        ArrayList<Reditelj> reditelji = (ArrayList<Reditelj>) so.getOdgovor();
        jcmbReditelji.removeAllItems();
        for (Reditelj reditelj : reditelji) {
            jcmbReditelji.addItem(reditelj);
        }
    }

    private void popuniComboGlumci() throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_GLUMCE);
        Kontroler.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Kontroler.getInstanca().primiOdgovor();
        ArrayList<Glumac> glumci = (ArrayList<Glumac>) so.getOdgovor();
        jcmbGlumci.removeAllItems();
        for (Glumac glumac : glumci) {
            jcmbGlumci.addItem(glumac);
        }
    }

}
