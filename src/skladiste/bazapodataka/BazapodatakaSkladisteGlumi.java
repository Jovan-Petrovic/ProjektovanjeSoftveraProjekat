/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Glumi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteGlumi;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteGlumi implements SkladisteGlumi {

    Broker broker = new Broker();
    
    @Override
    public void sacuvaj(Glumi glumi) {
        try {
            broker.otvoriKonekciju();
            String upit = "insert into glumi (film, glumac, ocena, napomena) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, glumi.getFilm().getId());
            preparedStatement.setLong(2, glumi.getGlumac().getId());
            preparedStatement.setDouble(3, glumi.getOcena());
            preparedStatement.setString(4, glumi.getNapomena());
            preparedStatement.executeUpdate();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteGlumi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
