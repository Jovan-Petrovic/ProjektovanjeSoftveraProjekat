/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Film;
import domen.Zanr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladistee.SkladisteFilm;

/**
 *
 * @author Bron Zilar
 */
public class BazapodatakaSkladisteFilm  implements SkladisteFilm {

    Broker broker = new Broker();
    
    @Override
    public Film sacuvaj(Film film) {
        try {
            broker.otvoriKonekciju();
            String upit = "insert into film (naziv, trajanje, zanr, godina, jezik, ocenaIMDb) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, film.getNaziv());
            preparedStatement.setInt(2, film.getTrajanje());
            preparedStatement.setString(3, film.getZanr().toString());
            preparedStatement.setInt(4, film.getGodina());
            preparedStatement.setString(5, film.getJezik());
            preparedStatement.setDouble(6, film.getOcenaIMDb());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                film.setId(rs.getLong(1));
            }
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }

    @Override
    public List<Film> vratiSve() {
        List<Film> filmovi = new ArrayList<>();
        try {
            broker.otvoriKonekciju();
            String upit = "select * from film";
            Connection koneckija = broker.getKonekcija();
            Statement statement = koneckija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long id = rs.getLong("id");
                String naziv = rs.getString("naziv");
                int trajanje = rs.getInt("trajanje");
                Zanr zanr = Zanr.valueOf(rs.getString("zanr"));
                int godina = rs.getInt("godina");
                String jezik = rs.getString("jezik");
                double ocenaIMDb = rs.getInt("ocenaIMDb");
                Film film = new Film(id, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
                filmovi.add(film);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazapodatakaSkladisteFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmovi;
    }
    
}
