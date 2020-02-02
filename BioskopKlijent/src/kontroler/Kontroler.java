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
import domen.Status;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.Operacije;

/**
 *
 * @author Bron Zilar
 */
public class Kontroler {
    
    private static Kontroler instanca;
    private Socket socket;
    
    private Kontroler() throws IOException {
        socket=new Socket("localhost", 9000);
    }

    public static Kontroler getInstanca() throws IOException {
        if(instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }
    /*
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

    public boolean obrisiProjekciju(Long id) throws Exception {
        return servisProjekcija.obrisi(id);
    }

    public void sacuvajRezira(Rezira rezira) throws Exception {
        servisRezira.sacuvaj(rezira);
    }

    public void sacuvajGlumi(Glumi glumi) throws Exception {
        servisGlumi.sacuvaj(glumi);
    }

    public List<Rezira> vratiSvaReziranja() throws Exception {
        return servisRezira.vratiSve();
    }

    public List<Glumi> vratiSveUloge() {
        return servisGlumi.vratiSve();
    }

    public boolean izmeniFilm(Film film) {
        return servisFilm.izmeni(film);
    }

    public List<Korisnik> vratiSveKorisnike() throws Exception {
        return servisKorisnik.vratiSve();
    }

    public boolean sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
        return servisRezervisanje.sacuvaj(rezervisanje);
    }

    public List<Rezervisanje> vratiSvaRezervisanja() throws Exception {
        return servisRezervisanje.vratiSva();
    }

    public boolean obrisiRezervaciju(Long projekcijaID, Long korisnikID) throws Exception {
        return servisRezervisanje.obrisi(projekcijaID, korisnikID);
    }
    */

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(kz);
        out.flush();
    }
    
    public ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor)in.readObject();
        return so;
    }
    
    public List<Korisnik> vratiSveKorisnike() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_KORISNIKE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        List<Korisnik> korisnici = (List<Korisnik>) so.getOdgovor();
        return korisnici;
    }

    public List<Reditelj> vratiSveReditelje() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_REDITELJE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        List<Reditelj> reditelji = (List<Reditelj>) so.getOdgovor();
        return reditelji;
    }

    public Film sacuvajFilm(Film film) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Glumac> vratiSveGlumce() throws IOException, ClassNotFoundException, Exception {
         KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_GLUMCE);
        posaljiZahtev(kz); 
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        List<Glumac> glumci = (List<Glumac>) so.getOdgovor();
        return glumci;
    }

//    public void sacuvajRezira(Rezira rezira) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void sacuvajGlumi(Glumi glumi) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public boolean izmeniFilm(Film film) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_FILM);
        kz.setParametar(film);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            return false;
        }
        return true;
    }

    public List<Rezira> vratiSvaReziranja() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_REZIRANJA);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        return (List<Rezira>) so.getOdgovor();
    }

    public List<Glumi> vratiSveUloge() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_ULOGE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        return (List<Glumi>) so.getOdgovor();
    }

    public List<Film> vratiSveFilmove() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_FILMOVE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        return (List<Film>) so.getOdgovor();
    }

    public boolean obrisiProjekciju(Projekcija p) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_PROJEKCIJU);
        kz.setParametar(p);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        if(so.getStatus().equals(Status.GRESKA)) {
            return false;
        }
        return true;
    }

    public List<Projekcija> vratiSveProjekcije() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_PROJEKCIJE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        return (List<Projekcija>) so.getOdgovor();
    }

    public boolean sacuvajRezervisanje(Rezervisanje rezervisanje) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_REZERVACIJU);
        kz.setParametar(rezervisanje);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return (boolean) so.getOdgovor();
    }

    public List<Rezervisanje> vratiSvaRezervisanja() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_REZERVACIJE);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            throw new Exception(so.getPoruka());
        }
        return (List<Rezervisanje>) so.getOdgovor();
    }

//    public boolean obrisiRezervaciju(Long projekcijaID, int korisnikID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public Projekcija sacuvajProjekciju(Projekcija projekcija) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_PROJEKCIJU);
        kz.setParametar(projekcija);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return (Projekcija) so.getOdgovor();
    }

    public Film sacuvajFilmReziraGlumi(Map<String, Object> podaci) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_FILM_REZIRA_GLUMI);
        kz.setParametar(podaci);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return (Film) so.getOdgovor();
    }

    public boolean obrisiRezervaciju(Map<String, Long> podaci) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OTAKZI_REZERVACIJU);
        kz.setParametar(podaci);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            return false;
        }
        return true;
    }

    public boolean sacuvajSveprojekcije(List<Projekcija> projekcije) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_PROJEKCIJU);
        for (Projekcija projekcija : projekcije) {
            kz.setParametar(projekcija);
            posaljiZahtev(kz);
            ServerskiOdgovor so = primiOdgovor();
            if(so.getStatus().equals(Status.GRESKA)) {
                return false;
            }
        } 
        return true;
    }

    public boolean izmeniFilmRediteljeGlumce(Map<String, Object> podaci) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_FILM_REDITELJE_GLUMCE);
        kz.setParametar(podaci);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            return false;
        }
        return true;
    }

    public boolean izmeniFilmReziraGlumi(Map<String, Object> podaci) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_FILM_REZIRA_GLUMI);
        kz.setParametar(podaci);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        if(so.getStatus().equals(Status.GRESKA)) {
            return false;
        }
        return true;
    }

    

}
