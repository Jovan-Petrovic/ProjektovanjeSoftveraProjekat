/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Film;
import domen.Reditelj;
import domen.Rezira;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
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
            String upit = "insert into rezira (film, reditelj) values (?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, rezira.getFilm().getId());
            preparedStatement.setLong(2, rezira.getReditelj().getId());
            preparedStatement.executeUpdate();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public List<Rezira> vratiSve() {
//        List<Rezira> reziranja = new ArrayList<>();
//        try {
//            broker.otvoriKonekciju();
//            String upit = "select * from rezira";
//            Connection koneckija = broker.getKonekcija();
//            Statement statement = koneckija.createStatement();
//            ResultSet rs = statement.executeQuery(upit);
//            while(rs.next()) {
//                Long idFilm = rs.getLong("film");
//                List<Film> filmovi = Kontroler.getInstanca().vratiSveFilmove();
//                Film f = null;
//                for (Film film : filmovi) {
//                    if(idFilm.equals(film.getId())) {
//                        f = film;
//                        break;
//                    }
//                }
//                Long idReditelj = rs.getLong("reditelj");
//                List<Reditelj> reditelji = Kontroler.getInstanca().vratiSveReditelje();
//                Reditelj r = null;
//                for (Reditelj reditelj : reditelji) {
//                    if(idReditelj.equals(reditelj.getId())) {
//                        r = reditelj;
//                        break;
//                    }
//                }
//                Rezira rezira = new Rezira(f, r);
//                reziranja.add(rezira);
//            }
//            statement.close();
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return reziranja;
//    }
//    

    @Override
    public List<Rezira> vratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
