/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Korisnik;
import domen.Projekcija;
import domen.Rezervisanje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            preparedStatement.setDate(3, (Date) rezervisanje.getDatumRezervacije());
            preparedStatement.executeUpdate();
            broker.commit();
            signal = true;
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezervisanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

    @Override
    public List<Rezervisanje> vratiSva() {
        List<Rezervisanje> rezervisanja = new ArrayList<>();
        try {
            broker.otvoriKonekciju();
            String upit = "select * from rezervisanje";
            Connection koneckija = broker.getKonekcija();
            Statement statement = koneckija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long projekcijaID = rs.getLong("projekcija");
                List<Projekcija> projekcije = Kontroler.getInstanca().vratiSveProjekcije();
                Projekcija p = null;
                for (Projekcija projekcija : projekcije) {
                    if(projekcija.getId().equals(projekcijaID)) {
                        p = projekcija;
                        break;
                    }
                }
                Long korisnikID = rs.getLong("korisnik");
                List<Korisnik> korisnici = Kontroler.getInstanca().vratiSveKorisnike();
                Korisnik k = null;
                for (Korisnik korisnik : korisnici) {
                    if(korisnik.getId().equals(korisnikID)) {
                        k = korisnik;
                        break;
                    }
                }
                Date datum = rs.getDate("datumRezervacije");
                Rezervisanje rezervisanje = new Rezervisanje(datum, k, p);
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
        }
        return true;
    }
    
}
