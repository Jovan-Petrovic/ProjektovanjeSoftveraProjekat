/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Rezervisanje;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteRezervisanje;

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
            String upit = "insert into rezervisanje (projekcija, korisnik, datum) values (?,?,?)";
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
    
}
