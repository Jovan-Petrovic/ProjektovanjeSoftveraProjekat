/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.DomenskiObjekat;
import domen.Film;
import domen.Glumac;
import domen.Glumi;
import domen.Korisnik;
import domen.Projekcija;
import domen.Reditelj;
import domen.Rezervisanje;
import domen.Rezira;
import domen.Zanr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logika.SOUbaciFilm;
import logika.SOUbaciGlumi;
import logika.SOUbaciProjekciju;
import logika.SOUbaciRezervisanje;
import logika.SOUbaciRezira;
import logika.SOVratiFilmove;
import logika.SOVratiGlumce;
import logika.SOVratiProjekcije;
import logika.SOVratiReditelje;
import logika.SOVratiRezervacije;
import logika.SOVratiReziranja;
import logika.SOVratiUloge;
import logika.SistemskaOperacija;
import servis.ServisFilm;
import servis.ServisGlumac;
import servis.ServisGlumi;
import servis.ServisKorisnik;
import servis.ServisProjekcija;
import servis.ServisReditelj;
import servis.ServisRezervisanje;
import servis.ServisRezira;
import servis.implementacija.ServisFilmImplementacija;
import servis.implementacija.ServisGlumacImplementacija;
import servis.implementacija.ServisGlumiImplementacija;
import servis.implementacija.ServisKorisnikImplementacija;
import servis.implementacija.ServisProjekcijaImplementacija;
import servis.implementacija.ServisRediteljImplementacija;
import servis.implementacija.ServisRezervisanjeImplementacija;
import servis.implementacija.ServisReziraImplementacija;

/**
 *
 * @author Bron Zilar
 */
public class Kontroler {
    
    private static Kontroler instanca;
    private final ServisFilm servisFilm;
    private final ServisReditelj servisReditelj;
    private final ServisGlumac servisGlumac;
    private final ServisProjekcija servisProjekcija;
    private final ServisRezira servisRezira;
    private final ServisGlumi servisGlumi;
    private final ServisKorisnik servisKorisnik;
    private final ServisRezervisanje servisRezervisanje;
    
    public Kontroler() {
        servisFilm = new ServisFilmImplementacija();
        servisReditelj = new ServisRediteljImplementacija();
        servisGlumac = new ServisGlumacImplementacija();
        servisProjekcija = new ServisProjekcijaImplementacija();
        servisRezira = new ServisReziraImplementacija();
        servisGlumi = new ServisGlumiImplementacija();
        servisKorisnik = new ServisKorisnikImplementacija();
        servisRezervisanje = new ServisRezervisanjeImplementacija();
    }

    public static Kontroler getInstanca() {
        if(instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    public Film sacuvajFilm(Film film) throws Exception {
        return servisFilm.sacuvaj(film);
    }
    
//    public List<Reditelj> vratiSveReditelje() throws Exception {
//        return servisReditelj.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSveReditelje() throws Exception {
        SistemskaOperacija so = new SOVratiReditelje(new Reditelj());
        so.execute();
        return ((SOVratiReditelje)so).getLista();
    }

//    public List<Glumac> vratiSveGlumce() throws Exception {
//        return servisGlumac.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSveGlumce() throws Exception {
        SistemskaOperacija so = new SOVratiGlumce(new Glumac());
        so.execute();
        return ((SOVratiGlumce)so).getLista();
    }

//    public List<Film> vratiSveFilmove() throws Exception {
//        return servisFilm.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSveFilmove() throws Exception {
        SistemskaOperacija so = new SOVratiFilmove(new Film());
        so.execute();
        return ((SOVratiFilmove)so).getLista();
    }

//    public Projekcija sacuvajProjekciju(Projekcija projekcija) throws Exception {
//        return servisProjekcija.sacuvaj(projekcija);
//    }
    
    public void sacuvajProjekciju(Projekcija projekcija) throws Exception {
        SistemskaOperacija so = new SOUbaciProjekciju(projekcija);
        so.execute();
    }

//    public List<Projekcija> vratiSveProjekcije() throws Exception {
//        return servisProjekcija.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSveProjekcije() throws Exception {
        SistemskaOperacija so = new SOVratiProjekcije(new Projekcija());
        so.execute();
        return ((SOVratiProjekcije)so).getLista();
    }

    public boolean obrisiProjekciju(Long id) throws Exception {
        return servisProjekcija.obrisi(id);
    }

    public void sacuvajRezira(Rezira rezira) throws Exception {
        servisRezira.sacuvaj(rezira);
    }

    public void sacuvajGlumi(Glumi glumi) throws Exception {
        servisGlumi.sacuvaj(glumi);
    }

//    public List<Rezira> vratiSvaReziranja() throws Exception {
//        return servisRezira.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSvaReziranja() throws Exception {
        SistemskaOperacija so = new SOVratiReziranja(new Rezira());
        so.execute();
        return ((SOVratiReziranja)so).getLista();
    }

//    public List<Glumi> vratiSveUloge() {
//        return servisGlumi.vratiSve();
//    }
    
    public List<DomenskiObjekat> vratiSveUloge() throws Exception {
        SistemskaOperacija so = new SOVratiUloge(new Glumi());
        so.execute();
        return ((SOVratiUloge)so).getLista();
    }

    public boolean izmeniFilm(Film film) {
        return servisFilm.izmeni(film);
    }

    public List<Korisnik> vratiSveKorisnike() throws Exception {
        return servisKorisnik.vratiSve();
    }

//    public boolean sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
//        return servisRezervisanje.sacuvaj(rezervisanje);
//    }
    
    public void sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
        SistemskaOperacija so = new SOUbaciRezervisanje(rezervisanje);
        so.execute();
    }

//    public List<Rezervisanje> vratiSvaRezervisanja() throws Exception {
//        return servisRezervisanje.vratiSva();
//    }
    
    public List<DomenskiObjekat> vratiSvaRezervisanja() throws Exception {
        SistemskaOperacija so = new SOVratiRezervacije(new Rezervisanje());
        so.execute();
        return ((SOVratiRezervacije)so).getLista();
    }

    public boolean obrisiRezervaciju(Long projekcijaID, Long korisnikID) throws Exception {
        return servisRezervisanje.obrisi(projekcijaID, korisnikID);
    }

//    public Film sacuvajFilmReziraGlumi(Map<String, Object> podaci) {
//        return servisFilm.sacuvajFilmReziraglumi(podaci);
//    }
    
    public Film sacuvajFilmReziraGlumi(Map<String, Object> podaci) throws Exception {
        Film film = (Film) podaci.get("film");
        ArrayList<Rezira> reziranja = (ArrayList<Rezira>) podaci.get("rezira");
        ArrayList<Glumi> glumljenja = (ArrayList<Glumi>) podaci.get("glumi");
        SistemskaOperacija so = new SOUbaciFilm(film);
        so.execute();
        
        for (Rezira rezira : reziranja) {
            rezira.setFilm(film);
            SistemskaOperacija so1 = new SOUbaciRezira(rezira);
            so1.execute();
        }
        
        for (Glumi glumi : glumljenja) {
            glumi.setFilm(film);
            SistemskaOperacija so2 = new SOUbaciGlumi(glumi);
            so2.execute();
        }
        
        return film;
    }

    public boolean obrisiRezervaciju(Map<String, Long> mapa) {
        return servisRezervisanje.obrisi(mapa);
    }

    public boolean izmeniFilmRediteljeGlumce(Map<String, Object> podaci) {
        return servisFilm.izmeniFilmRediteljeGlumce(podaci);
    }

    

}
