/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Bron Zilar
 */
public class Rezervisanje implements Serializable {
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
    
    
    
}
