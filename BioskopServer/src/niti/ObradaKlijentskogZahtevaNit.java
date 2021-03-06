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
import javax.swing.JOptionPane;
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
                        Rezervisanje r = (Rezervisanje) kz.getParametar();
                        so = otkaziRezervaciju(r);
                        break;
                    case Operacije.IZMENI_FILM:
                        Film film = (Film) kz.getParametar();
                        so = izmeniFilm(film);
                        break;
                    case Operacije.IZMENI_FILM_REDITELJE_GLUMCE:
                        Map<String,Object> frg = (Map<String,Object>) kz.getParametar();
                        so = izmeniFilmRediteljeGlumce(frg);
                        break;
                    case Operacije.IZMENI_FILM_REZIRA_GLUMI:
                        Map<String,Object> mapa1 = (Map<String,Object>) kz.getParametar();
                        so = izmeniFilmReziraGlumi(mapa1);
                        break;
                    case Operacije.PRIJAVA:
                        Korisnik k = (Korisnik) kz.getParametar();
                        so = prijava(k);
                        break;
                    case Operacije.VRATI_FILTRIRANE_FILMOVE:
                        Film f = (Film) kz.getParametar();
                        so = vratiFiltriraneFilmove(f);
                        break;
                    case Operacije.ODJAVA:
                        Korisnik korisnik = (Korisnik) kz.getParametar();
                        so = odjava(korisnik);
                        break;
                }
                posaljiOdgovor(so);
            } catch (IOException ex) {
                //Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                Kontroler.getInstanca().getPrijavljeniKorisnici().removeAll(Kontroler.getInstanca().getPrijavljeniKorisnici());
                JOptionPane.showMessageDialog(null, "Server je zaustavljen");
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
            ArrayList<DomenskiObjekat> reziranja = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSvaReziranja();
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
            ArrayList<DomenskiObjekat> reditelji = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSveReditelje();
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
            ArrayList<DomenskiObjekat> reziranja = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSveUloge();
            so.setOdgovor(reziranja);
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
            ArrayList<DomenskiObjekat> reziranja = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSveGlumce();
            so.setOdgovor(reziranja);
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
            so.setPoruka("Doslo je do greske prilikom citanja projekcija iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    
    private ServerskiOdgovor obrisiProjekciju(Projekcija p) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Kontroler.getInstanca().obrisiProjekciju(p);
            so.setOdgovor(true);
            so.setPoruka("Uspesno obrisana projekcija");
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setOdgovor(false);
            so.setPoruka("projekcija nije uspesno obrisana");
            so.setStatus(Status.GRESKA);
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    
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
    
    private ServerskiOdgovor sacuvajRezervisanje(Rezervisanje rezervisanje) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<DomenskiObjekat> rezervacije = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSvaRezervisanja();
            if(rezervacije.contains(rezervisanje)) {
                so.setOdgovor(false);
                so.setStatus(Status.GRESKA);
                so.setPoruka("Vec ste rezervisali mesto na datoj projekciji.");
            } else {
                Kontroler.getInstanca().sacuvajRezervisanje(rezervisanje);
                so.setStatus(Status.U_REDU);
                so.setOdgovor(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
            so.setOdgovor(false);
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom rezervacije mesta!");
        }
        return so;
    }
    
    private ServerskiOdgovor vratiSvaRezervisanja() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<DomenskiObjekat> rezervacije = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiSvaRezervisanja();
            so.setOdgovor(rezervacije);
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
    
    private ServerskiOdgovor izmeniFilmReziraGlumi(Map<String, Object> mapa1) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        boolean odgovor = Kontroler.getInstanca().izmeniFilmReziraGlumi(mapa1);
        if(odgovor) {
            so.setOdgovor(odgovor);
            so.setStatus(Status.U_REDU);
        } else {
            so.setOdgovor(odgovor);
            so.setStatus(Status.GRESKA);
        }
        return so;
    }

    private ServerskiOdgovor otkaziRezervaciju(Rezervisanje r) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Kontroler.getInstanca().otkaziRezervaciju(r);
            so.setOdgovor(true);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setOdgovor(false);
            so.setStatus(Status.GRESKA);
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor prijava(Korisnik k) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            so = Kontroler.getInstanca().prijava(k);
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor vratiFiltriraneFilmove(Film film) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ArrayList<DomenskiObjekat> filmovi = (ArrayList<DomenskiObjekat>) Kontroler.getInstanca().vratiFiltriraneFilmove(film);
            so.setOdgovor(filmovi);
            so.setStatus(Status.U_REDU);
        } catch (Exception ex) {
            so.setStatus(Status.GRESKA);
            so.setPoruka("Doslo je do greske prilikom citanja filmova iz baze");
            Logger.getLogger(ObradaKlijentskogZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    private ServerskiOdgovor odjava(Korisnik korisnik) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        so = Kontroler.getInstanca().odjava(korisnik);
        return so;
    }

    
}
