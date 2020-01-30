/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class Rezervisanje implements Serializable, DomenskiObjekat {
    private Date datumRezervacije;
    private Korisnik korisnik;
    private Projekcija projekcija;

    public Rezervisanje(Date datumRezervacije, Korisnik korisnik, Projekcija projekcija) {
        this.datumRezervacije = datumRezervacije;
        this.korisnik = korisnik;
        this.projekcija = projekcija;
    }

    public Projekcija getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(Projekcija projekcija) {
        this.projekcija = projekcija;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String getImeTabele() {
        return "rezervisanje";
    }

    @Override
    public String getImenaAtributaZaUbacivanje() {
        return "projekcija, korisnik, datumRezervacije";
    }

    @Override
    public String getVrednostiAtributaZaUbacivanje() {
        return projekcija.getId()+", "+korisnik.getId()+", '"+new java.sql.Date(datumRezervacije.getTime())+"'";
    }

    @Override
    public boolean isAutoincrement() {
        return false;
    }

    @Override
    public void setObjekatID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DomenskiObjekat> ucitajListu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
