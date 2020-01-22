/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Korisnik;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteKorisnik;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteKorisnik implements SkladisteKorisnik{

    Broker broker = new Broker();
    
    @Override
    public List<Korisnik> vratiSve() {
        List<Korisnik> korisnici = new ArrayList<>();
        try { 
            broker.otvoriKonekciju();
            String upit = "select * from korisnik";
            Connection konekcija = broker.getKonekcija();
            Statement statement = konekcija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long id = rs.getLong("id");
                String korisnickoIme = rs.getString("korisnickoIme");
                String sifra = rs.getString("sifra");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                Korisnik korisnik = new Korisnik(id, korisnickoIme, sifra, ime, prezime, email);
                korisnici.add(korisnik);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazapodatakaSkladisteKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;
    }
    
}
