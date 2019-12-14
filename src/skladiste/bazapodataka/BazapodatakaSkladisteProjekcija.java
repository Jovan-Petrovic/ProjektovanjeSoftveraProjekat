/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Projekcija;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteProjekcija;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteProjekcija implements SkladisteProjekcija {

    Broker broker = new Broker();
    
    @Override
    public Projekcija sacuvaj(Projekcija projekcija) {
        try {
            broker.otvoriKonekciju();
            String upit = "insert into projekcija (datum, sala, filmID) values (?, ?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, new Date(projekcija.getDatum().getTime()));
            preparedStatement.setInt(2, projekcija.getSala());
            preparedStatement.setLong(3, projekcija.getFilm().getId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                projekcija.setId(rs.getLong(1));
            }
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazapodatakaSkladisteProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projekcija;
    }
    
}
