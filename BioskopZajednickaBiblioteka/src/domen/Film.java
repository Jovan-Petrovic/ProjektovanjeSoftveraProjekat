/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Film implements Serializable, DomenskiObjekat {
    private Long id;
    private String naziv;
    private int trajanje;
    private Zanr zanr;
    private int godina;
    private String jezik;
    private double ocenaIMDb;

    public Film() {
    }
    
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

    @Override
    public String getImeTabele() {
        return "film";
    }

    @Override
    public String getImenaAtributaZaUbacivanje() {
        return "naziv, trajanje, zanr, godina, jezik, ocenaIMDb";
    }

    @Override
    public String getVrednostiAtributaZaUbacivanje() {
         return "'"+naziv+"', "+trajanje+", '"+zanr.toString()+"', "+godina+", '"+jezik+"', "+ocenaIMDb;
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjekatID(Long id) {
        setId(id);
    }

    @Override
    public List<DomenskiObjekat> ucitajListu(ResultSet rs) {
        List<DomenskiObjekat> filmovi = new ArrayList<>();
        try {
            while(rs.next()) {
                Long id = rs.getLong("id");
                String naziv = rs.getString("naziv");
                int trajanje = rs.getInt("trajanje");
                Zanr zanr = Zanr.valueOf(rs.getString("zanr"));
                int godina = rs.getInt("godina");
                String jezik = rs.getString("jezik");
                double ocenaIMDb = rs.getInt("ocenaIMDb");
                Film film = new Film(id, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
                filmovi.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Film.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmovi;
    }

    @Override
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
