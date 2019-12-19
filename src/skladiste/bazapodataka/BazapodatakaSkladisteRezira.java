/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Rezira;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteRezira;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteRezira implements SkladisteRezira{

    Broker broker = new Broker();
    
    @Override
    public void sacuvaj(Rezira rezira) {
        try {
            broker.otvoriKonekciju();
            String upit = "insert into rezira (film, reditelj, ocena, napomena) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, rezira.getFilm().getId());
            preparedStatement.setLong(2, rezira.getReditelj().getId());
            preparedStatement.setDouble(3, rezira.getOcena());
            preparedStatement.setString(4, rezira.getNapomena());
            preparedStatement.executeUpdate();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
