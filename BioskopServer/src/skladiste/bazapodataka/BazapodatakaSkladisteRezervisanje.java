/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Film;
import domen.Korisnik;
import domen.Projekcija;
import domen.Rezervisanje;
import domen.Zanr;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import skladistee.SkladisteRezervisanje;
import sun.security.ec.point.ProjectivePoint;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteRezervisanje implements SkladisteRezervisanje{

    Broker broker = new Broker();
    
    @Override
    public boolean sacuvaj(Rezervisanje rezervisanje) {
        boolean signal = false;
        try {
            broker.otvoriKonekciju();
            String upit = "insert into rezervisanje (projekcija, korisnik, datumRezervacije) values (?,?,?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, rezervisanje.getProjekcija().getId());
            preparedStatement.setLong(2, rezervisanje.getKorisnik().getId());
            Date datum = new Date(rezervisanje.getDatumRezervacije().getTime());
            preparedStatement.setDate(3, datum);
            preparedStatement.executeUpdate();
            broker.commit();
            signal = true;
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

    @Override
    public List<Rezervisanje> vratiSva() {
        List<Rezervisanje> rezervisanja = new ArrayList<>();
        try {
            broker.otvoriKonekciju();
            String upit = "SELECT * FROM rezervisanje r JOIN projekcija p ON r.projekcija=p.id JOIN korisnik k ON r.korisnik=k.id JOIN film f ON p.filmID=f.id";
            Connection koneckija = broker.getKonekcija();
            Statement statement = koneckija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long filmID = rs.getLong("f.id");
                String filmNaziv = rs.getString("f.naziv");
                int filmTrajanje = rs.getInt("f.trajanje");
                String zanr = rs.getString("f.zanr");
                Zanr zanrFilma = Zanr.valueOf(zanr);
                int godinaFilma = rs.getInt("f.godina");
                String jezikFilma = rs.getString("f.jezik");
                double ocenaIMDb = rs.getDouble("f.ocenaIMDb");
                Film film = new Film(filmID, filmNaziv, filmTrajanje, zanrFilma, godinaFilma, jezikFilma, ocenaIMDb);
                
                Long projekcijaId = rs.getLong("p.id");
                java.sql.Timestamp datumVremeProjekcije = rs.getTimestamp("p.datum");
                String salaProjekcije = rs.getString("p.sala");
                int ostaloMesta = rs.getInt("preostaloMesta");
                Projekcija projekcija = new Projekcija(projekcijaId, datumVremeProjekcije, salaProjekcije, film, ostaloMesta);
                
                Long korisnikID = rs.getLong("k.id");
                String korisnickoIme = rs.getString("k.korisnickoIme");
                String sifra = rs.getString("k.sifra");
                String ime = rs.getString("k.ime");
                String prezime = rs.getString("k.prezime");
                String email = rs.getString("k.email");
                Korisnik korisnik = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, email);
                
                Date datumRezervisanja = rs.getDate("r.datumRezervacije");
                Rezervisanje rezervisanje = new Rezervisanje(datumRezervisanja, korisnik, projekcija);
                
                rezervisanja.add(rezervisanje);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervisanja;
    }

    @Override
    public boolean obrisi(Long projekcijaID, Long korisnikID) {
        try {
            broker.otvoriKonekciju();
            String upit = "delete from rezervisanje where projekcija=? and korisnik=?";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, projekcijaID);
            preparedStatement.setLong(2, korisnikID);
            preparedStatement.execute();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean obrisi(Map<String, Long> mapa) {
         try {
            broker.otvoriKonekciju();
            String upit = "delete from rezervisanje where projekcija=? and korisnik=?";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            long projekcijaID = mapa.get("projekcijaID");
            long korisnikID = mapa.get("korisnikID");
            preparedStatement.setLong(1, projekcijaID);
            preparedStatement.setLong(2, korisnikID);
            preparedStatement.execute();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
