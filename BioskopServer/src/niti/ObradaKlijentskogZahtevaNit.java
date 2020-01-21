/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Film;
import domen.Glumac;
import domen.Glumi;
import domen.Korisnik;
import domen.Projekcija;
import domen.Reditelj;
import domen.Rezira;
import domen.Status;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.Operacije;

/**
 *
 * @author Bron Zilar
 */
public class ObradaKlijentskogZahtevaNit extends Thread {
    
    private Socket socket;

    public ObradaKlijentskogZahtevaNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        KlijentskiZahtev kz = null;
        ServerskiOdgovor so = null;
        while(!socket.isClosed()) {
            try {
                kz = primiZahtev();
                switch(kz.getOperacija()) {
                    case Operacije.VRATI_KORISNIKE:
                        so = vratiSveKorisnike();
                        break;
                    case Operacije.VRATI_FILMOVE:
                        so = vratiSveFilmove();
                        break;
                    case Operacije.VRATI_REZIRANJA:
                        so = vratiSvaReziranja();
                        break;
                    case Operacije.VRATI_REDITELJE:
                        so = vratiSveReditelje();
                        break;
                    case Operacije.VRATI_ULOGE:
                        so = vratiSveUloge();
                        break;
                    case Operacije.VRATI_GLUMCE:
                        so = vratiSveGlumce();
                        break;
                    case Operacije.SACUVAJ_FILM_REZIRA_GLUMI:
                        Map<String,Object> podaci = (Map<String,Object>) kz.getParametar();
                        so = sacuvajFilmReziraGlumi(podaci);
                        break;
                    case Operacije.VRATI_PROJEKCIJE:
                        so = vratiSveProjekcije();
                        break;
                    case Operacije.OBRISI_PROJEKCIJU:
                        Projekcija p = (Projekcija) kz.getParametar();
                        so = obrisiProjekciju(p);
                        break;
                    case Operacije.SACUVAJ_PROJEKCIJU:
                        Projekcija projekcija = (Projekcija) kz.getParametar();
                        so = sacuvajProjekciju(projekcija);
                        break;
                }
                posaljiOdgovor(so);
            } catch (IOException ex) {
                Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (KlijentskiZahtev) in.readObject();
    }
    
    public void posaljiOdgovor(ServerskiOdgovor so) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(so);
        out.flush();
    }

    public Socket getSocket() {
        return socket;
    }

    private ServerskiOdgovor vratiSveKorisnike() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
           ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) Kontroler.getInstanca().vratiSveKorisnike();
            so.setOdgovor(korisnici);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja korisnika iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiSveFilmove() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Film> filmovi = (ArrayList<Film>) Kontroler.getInstanca().vratiSveFilmove();
            so.setOdgovor(filmovi);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja filmova iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiSvaReziranja() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Rezira> reziranja = (ArrayList<Rezira>) Kontroler.getInstanca().vratiSvaReziranja();
            so.setOdgovor(reziranja);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
             so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja reziranja iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiSveReditelje() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Reditelj> reditelji = (ArrayList<Reditelj>) Kontroler.getInstanca().vratiSveReditelje();
            so.setOdgovor(reditelji);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
             so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja reditelja iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiSveUloge() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Glumi> uloge = (ArrayList<Glumi>) Kontroler.getInstanca().vratiSveUloge();
            so.setOdgovor(uloge);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja uloga iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiSveGlumce() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Glumac> glumci = (ArrayList<Glumac>) Kontroler.getInstanca().vratiSveGlumce();
            so.setOdgovor(glumci);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
             so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja glumaca iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor sacuvajFilmReziraGlumi(Map<String, Object> podaci) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Film film = Kontroler.getInstanca().sacuvajFilmReziraGlumi(podaci);
        if(film != null) {
            so.setOdgovor(film);
            so.setStatus(Status.U_REDU);
            so.setPoruka("Uspesno sacuvan film sa Id-em: " + film.getId());
        } else {
            so.setOdgovor(film);
            so.setStatus(Status.GRESKA);
            so.setPoruka("film nije uspesno sacuvan");
        }
        return so;
    }

    private ServerskiOdgovor vratiSveProjekcije() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Projekcija> projekcije = (ArrayList<Projekcija>) Kontroler.getInstanca().vratiSveProjekcije();
            so.setOdgovor(projekcije);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja filmova iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor obrisiProjekciju(Projekcija p) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        boolean odgovor = Kontroler.getInstanca().obrisiProjekciju(p.getId());
        if(odgovor) {
            so.setOdgovor(true);
            so.setPoruka("Uspesno obrisana projekcija");
            so.setStatus(Status.U_REDU);
        } else {
            so.setOdgovor(false);
            so.setPoruka("projekcija nije uspesno obrisana");
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor sacuvajProjekciju(Projekcija projekcija) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Projekcija p = Kontroler.getInstanca().sacuvajProjekciju(projekcija);
        if(p != null) {
            so.setOdgovor(p);
            so.setStatus(Status.U_REDU);
            so.setPoruka("Uspesno sacuvana projekcija sa Id-em: " + p.getId());
        } else {
            so.setOdgovor(p);
            so.setStatus(Status.GRESKA);
            so.setPoruka("Projekcija nije uspesno sacuvana");
        }
        return so;
    }

    
}
