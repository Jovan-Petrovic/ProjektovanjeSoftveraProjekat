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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.net.ssl.SSLSocket;
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
        try {
            FileInputStream in=new FileInputStream("klijent.properties");
            Properties props=new Properties();
            props.load(in);
            String adresa = props.getProperty("ip");
            String soket = props.getProperty("socket");
            int s = Integer.parseInt(soket);
            socket=new Socket(adresa, s);
        } catch(java.net.ConnectException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut", "Greska", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public static Kontroler getInstanca() throws IOException {
        if(instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

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

    public ServerskiOdgovor sacuvajRezervisanje(Rezervisanje rezervisanje) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_REZERVACIJU);
        kz.setParametar(rezervisanje);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return so;
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

    public ServerskiOdgovor obrisiRezervaciju(Rezervisanje r) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OTAKZI_REZERVACIJU);
        kz.setParametar(r);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return so;
    }

    public ServerskiOdgovor prijava(Korisnik k) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRIJAVA);
        kz.setParametar(k);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return so;
    }

    public ArrayList<Film> vratiFiltriraneFilmove(Film film) throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_FILTRIRANE_FILMOVE);
        kz.setParametar(film);
        posaljiZahtev(kz);
        ServerskiOdgovor so = primiOdgovor();
        return (ArrayList<Film>) so.getOdgovor();
    }

    

}
