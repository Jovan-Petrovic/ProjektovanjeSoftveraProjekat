/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

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
                    case Operacije.SACUVAJ_REZERVACIJU:
                        Rezervisanje rezervisanje = (Rezervisanje) kz.getParametar();
                        so = sacuvajRezervisanje(rezervisanje);
                        break;
                    case Operacije.VRATI_REZERVACIJE:
                        so = vratiSvaRezervisanja();
                        break;
                    case Operacije.OTAKZI_REZERVACIJU:
                        Map<String,Long> mapa = (Map<String,Long>) kz.getParametar();
                        so = otkaziRezervaciju(mapa);
                        break;
                    case Operacije.IZMENI_FILM:
                        Film film = (Film) kz.getParametar();
                        so = izmeniFilm(film);
                        break;
                    case Operacije.IZMENI_FILM_REDITELJE_GLUMCE:
                        Map<String,Object> frg = (Map<String,Object>) kz.getParametar();
                        so = izmeniFilmRediteljeGlumce(frg);
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
            ArrayList<DomenskiObjekat> filmovi = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSveFilmove();
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

//    private ServerskiOdgovor sacuvajFilmReziraGlumi(Map<String, Object> podaci) {
//        ServerskiOdgovor so = new ServerskiOdgovor();
//        Film film = Kontroler.getInstanca().sacuvajFilmReziraGlumi(podaci);
//        if(film != null) {
//            so.setOdgovor(film);
//            so.setStatus(Status.U_REDU);
//        } else {
//            so.setOdgovor(film);
//            so.setStatus(Status.GRESKA);
//        }
//        return so;
//    }
    
    private ServerskiOdgovor sacuvajFilmReziraGlumi(Map<String, Object> podaci) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Film f = Kontroler.getInstanca().sacuvajFilmReziraGlumi(podaci);
            so.setStatus(Status.U_REDU);
            so.setOdgovor(f);
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor vratiSveProjekcije() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<DomenskiObjekat> projekcije = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSveProjekcije();
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

//    private ServerskiOdgovor sacuvajProjekciju(Projekcija projekcija) throws Exception {
//        ServerskiOdgovor so = new ServerskiOdgovor();
//        Projekcija p = Kontroler.getInstanca().sacuvajProjekciju(projekcija);
//        so.setOdgovor(p);
//        if(p != null) {
//            so.setStatus(Status.U_REDU);
//        } else {
//            so.setStatus(Status.GRESKA);
//        }
//        return so;
//    }
    
    private ServerskiOdgovor sacuvajProjekciju(Projekcija projekcija){
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Kontroler.getInstanca().sacuvajProjekciju(projekcija);
            so.setStatus(Status.U_REDU);
            so.setOdgovor(projekcija);
            so.setPoruka("Projekcija je uspeno sacuvana");
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            so.setPoruka("Doslo je do greske. Projekcija nije uspesno sacuvana.");
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

//    private ServerskiOdgovor sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
//        ServerskiOdgovor so = new ServerskiOdgovor();
//        Boolean odgovor = Kontroler.getInstanca().sacuvajRezervisanje(rezervisanje);
//        if(odgovor) {
//            so.setOdgovor(true);
//            so.setStatus(Status.U_REDU);
//        } else {
//            so.setOdgovor(false);
//            so.setStatus(Status.GRESKA);
//        }
//        return so;
//    }
    
    private ServerskiOdgovor sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Kontroler.getInstanca().sacuvajRezervisanje(rezervisanje);
            so.setStatus(Status.U_REDU);
            so.setOdgovor(true);
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            so.setOdgovor(false);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor vratiSvaRezervisanja() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<Rezervisanje> rezervisanja = (ArrayList<Rezervisanje>) Kontroler.getInstanca().vratiSvaRezervisanja();
            so.setOdgovor(rezervisanja);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
             so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja rezervacija iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor otkaziRezervaciju(Map<String, Long> mapa) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        boolean odgovor = Kontroler.getInstanca().obrisiRezervaciju(mapa);
        if(odgovor) {
            so.setOdgovor(true);
            so.setStatus(Status.U_REDU);
        } else {
            so.setOdgovor(false);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor izmeniFilm(Film film) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        boolean p = Kontroler.getInstanca().izmeniFilm(film);
        if(p) {
            so.setOdgovor(p);
            so.setStatus(Status.U_REDU);
        } else {
            so.setOdgovor(p);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor izmeniFilmRediteljeGlumce(Map<String, Object> podaci) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        boolean odgovor = Kontroler.getInstanca().izmeniFilmRediteljeGlumce(podaci);
        if(odgovor) {
            so.setOdgovor(odgovor);
            so.setStatus(Status.U_REDU);
        } else {
            so.setOdgovor(odgovor);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    
}
