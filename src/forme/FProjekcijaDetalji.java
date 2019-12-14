/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Projekcija;

/**
 *
 * @author Bron Zilar
 */
public class FProjekcijaDetalji extends javax.swing.JDialog {

    Projekcija projekcija;
    
    /**
     * Creates new form FProjekcijaDetalji
     */
    public FProjekcijaDetalji(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    FProjekcijaDetalji(FPretragaProjekcije aThis, boolean b, Projekcija projekcija) {
        super(aThis, b);
        this.projekcija = projekcija;
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

        jlblID = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jlabFilm = new javax.swing.JLabel();
        jtxtFilm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtDatum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtSala = new javax.swing.JTextField();
        jtxtIzadji = new javax.swing.JButton();
        jbtnFilmDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Projekcija");

        jlblID.setText("ID:");

        jtxtID.setEnabled(false);

        jlabFilm.setText("Film:");

        jtxtFilm.setEnabled(false);

        jLabel1.setText("Datum:");

        jtxtDatum.setEnabled(false);

        jLabel2.setText("Sala:");

        jtxtSala.setEnabled(false);

        jtxtIzadji.setText("Izadji");
        jtxtIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIzadjiActionPerformed(evt);
            }
        });

        jbtnFilmDetalji.setText("Prikazi detalje o filmu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtIzadji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jbtnFilmDetalji))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jlabFilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSala)
                            .addComponent(jtxtDatum)
                            .addComponent(jtxtFilm)
                            .addComponent(jtxtID))))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblID)
                    .addComponent(jtxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabFilm)
                    .addComponent(jtxtFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtIzadji)
                    .addComponent(jbtnFilmDetalji))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIzadjiActionPerformed
        dispose();
    }//GEN-LAST:event_jtxtIzadjiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnFilmDetalji;
    private javax.swing.JLabel jlabFilm;
    private javax.swing.JLabel jlblID;
    private javax.swing.JTextField jtxtDatum;
    private javax.swing.JTextField jtxtFilm;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JButton jtxtIzadji;
    private javax.swing.JTextField jtxtSala;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() {
        jtxtID.setText(projekcija.getId().toString());
        jtxtFilm.setText(projekcija.getFilm().getNaziv());
        jtxtDatum.setText(projekcija.getDatum().toString());
        jtxtSala.setText(projekcija.getSala()+"");
    }
}
