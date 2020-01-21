/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Bron Zilar
 */
public class Film {
    private Long id;
    private String naziv;
    private int trajanje;
    private Zanr zanr;
    private int godina;
    private String jezik;
    private double ocenaIMDb;

    public Film(Long id, String naziv, int trajanje, Zanr zanr, int godina, String jezik, double ocenaIMDb) {
        this.id = id;
        this.naziv = naziv;
        this.trajanje = trajanje;
        this.zanr = zanr;
        this.godina = godina;
        this.jezik = jezik;
        this.ocenaIMDb = ocenaIMDb;
    }

    public double getOcenaIMDb() {
        return ocenaIMDb;
    }

    public void setOcenaIMDb(double ocenaIMDb) {
        this.ocenaIMDb = ocenaIMDb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
    
    
}
