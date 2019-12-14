/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Film;
import domen.Glumac;
import domen.Projekcija;
import domen.Reditelj;
import java.util.List;
import servis.ServisFilm;
import servis.ServisGlumac;
import servis.ServisProjekcija;
import servis.ServisReditelj;
import servis.implementacija.ServisFilmImplementacija;
import servis.implementacija.ServisGlumacImplementacija;
import servis.implementacija.ServisProjekcijaImplementacija;
import servis.implementacija.ServisRediteljImplementacija;

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
    
    public Kontroler() {
        servisFilm = new ServisFilmImplementacija();
        servisReditelj = new ServisRediteljImplementacija();
        servisGlumac = new ServisGlumacImplementacija();
        servisProjekcija = new ServisProjekcijaImplementacija();
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
    
    public List<Reditelj> vratiSveReditelje() throws Exception {
        return servisReditelj.vratiSve();
    }

    public List<Glumac> vratiSveGlumce() throws Exception {
        return servisGlumac.vratiSve();
    }

    public List<Film> vratiSveFilmove() throws Exception {
        return servisFilm.vratiSve();
    }

    public Projekcija sacuvajProjekciju(Projekcija projekcija) throws Exception {
        return servisProjekcija.sacuvaj(projekcija);
    }

    public List<Projekcija> vratiSveProjekcije() throws Exception {
        return servisProjekcija.vratiSve();
    }

}
