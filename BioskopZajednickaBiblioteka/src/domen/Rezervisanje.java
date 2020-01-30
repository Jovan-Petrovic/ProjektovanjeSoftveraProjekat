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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Rezervisanje implements Serializable, DomenskiObjekat {
    private Date datumRezervacije;
    private Korisnik korisnik;
    private Projekcija projekcija;

    public Rezervisanje() {
    }
    
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
        List<DomenskiObjekat> rezervisanja = new ArrayList<>();
        try {
            while(rs.next()) {
                Long filmID = rs.getLong("film.id");
                String filmNaziv = rs.getString("film.naziv");
                int filmTrajanje = rs.getInt("film.trajanje");
                String zanr = rs.getString("film.zanr");
                Zanr zanrFilma = Zanr.valueOf(zanr);
                int godinaFilma = rs.getInt("film.godina");
                String jezikFilma = rs.getString("film.jezik");
                double ocenaIMDb = rs.getDouble("film.ocenaIMDb");
                Film film = new Film(filmID, filmNaziv, filmTrajanje, zanrFilma, godinaFilma, jezikFilma, ocenaIMDb);
                
                Long projekcijaId = rs.getLong("projekcija.id");
                java.util.Date datumProjekcije = rs.getDate("projekcija.datum");
                String salaProjekcije = rs.getString("projekcija.sala");
                Projekcija projekcija = new Projekcija(projekcijaId, datumProjekcije, salaProjekcije, film);
                
                Long korisnikID = rs.getLong("korisnik.id");
                String korisnickoIme = rs.getString("korisnik.korisnickoIme");
                String sifra = rs.getString("korisnik.sifra");
                String ime = rs.getString("korisnik.ime");
                String prezime = rs.getString("korisnik.prezime");
                String email = rs.getString("korisnik.email");
                Korisnik korisnik = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, email);
                
                Rezervisanje rezervisanje = new Rezervisanje(datumProjekcije, korisnik, projekcija);
                
                rezervisanja.add(rezervisanje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervisanja;
    }

    @Override
    public String vratiJoinTabelu() {
        return "projekcija";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "rezervisanje.projekcija=projekcija.id";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "korisnik";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "rezervisanje.korisnik=korisnik.id";
    }

    @Override
    public String vratiJoinTabelu3() {
        return "film";
    }

    @Override
    public String vratiUslovZaJoin3() {
        return "projekcija.filmID=film.id";
    }
    
    
    
}
