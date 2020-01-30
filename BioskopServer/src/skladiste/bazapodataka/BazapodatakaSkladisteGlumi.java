/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Film;
import domen.Glumac;
import domen.Glumi;
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
            String upit = "insert into glumi (film, glumac) values (?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, glumi.getFilm().getId());
            preparedStatement.setLong(2, glumi.getGlumac().getId());
            preparedStatement.executeUpdate();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteGlumi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BazapodatakaSkladisteGlumi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazapodatakaSkladisteGlumi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public List<Glumi> vratiSve() {
//        List<Glumi> uloge = new ArrayList<>();
//        try {
//            broker.otvoriKonekciju();
//            String upit = "select * from glumi";
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
//                Long idGlumac = rs.getLong("glumac");
//                List<Glumac> glumci = Kontroler.getInstanca().vratiSveGlumce();
//                Glumac g = null;
//                for (Glumac glumac : glumci) {
//                    if(idGlumac.equals(glumac.getId())) {
//                        g = glumac;
//                        break;
//                    }
//                }
//                Glumi glumi = new Glumi(f, g);
//                uloge.add(glumi);
//            }
//            statement.close();
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(BazapodatakaSkladisteRezira.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return uloge;
//    }

    @Override
    public List<Glumi> vratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
