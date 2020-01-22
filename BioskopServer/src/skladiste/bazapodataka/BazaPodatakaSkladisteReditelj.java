/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Reditelj;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteReditelj;

/**
 *
 * @author Bron Zilar
 */
public class BazaPodatakaSkladisteReditelj implements SkladisteReditelj {
    
    Broker broker = new Broker();

    @Override
    public List<Reditelj> vratiSve() {
        List<Reditelj> reditelji = new ArrayList<>();
        try {            
            broker.otvoriKonekciju();
            String upit = "select * from reditelj";
            Connection koneckija = broker.getKonekcija();
            Statement statement = koneckija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long id = rs.getLong("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String drzanljanstvo = rs.getString("drzanljanstvo");
                int brojFilmova = rs.getInt("brojFilmova");
                Reditelj reditelj = new Reditelj(id, ime, prezime, drzanljanstvo, brojFilmova);
                reditelji.add(reditelj);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazaPodatakaSkladisteReditelj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BazaPodatakaSkladisteReditelj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaPodatakaSkladisteReditelj.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reditelji;
    }
    
    
}
