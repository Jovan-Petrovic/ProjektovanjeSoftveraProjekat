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
import domen.Rezira;
import domen.Zanr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public boolean izmeni(Film film) {
        boolean signal = false;
        try {
            broker.otvoriKonekciju();
            String upit = "update film set naziv = ?, trajanje = ?, zanr = ?, godina = ?, jezik = ?, ocenaIMDb = ? where id = ?";
            Connection konekcija = broker.getKonekcija();
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setString(1, film.getNaziv());
            ps.setInt(2, film.getTrajanje());
            ps.setString(3, film.getZanr().toString());
            ps.setInt(4, film.getGodina());
            ps.setString(5, film.getJezik());
            ps.setDouble(6, film.getOcenaIMDb());
            ps.setLong(7, film.getId());
            ps.executeUpdate();
            broker.commit();
            konekcija.close();
            signal = true;
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

    @Override
    public Film sacuvajFilmReziraGlumi(Map<String, Object> podaci) {
        Film film = (Film) podaci.get("film");
        List<Rezira> reziranja = (List<Rezira>) podaci.get("rezira");
        List<Glumi> glumljenja = (List<Glumi>) podaci.get("glumi");
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
            
            upit = "insert into rezira (film, reditelj) values (?, ?)";
            for (Rezira rezira : reziranja) {
                preparedStatement = broker.getKonekcija().prepareStatement(upit);
                //preparedStatement.setLong(1, rezira.getFilm().getId());
                preparedStatement.setLong(1, film.getId());
                preparedStatement.setLong(2, rezira.getReditelj().getId());
                preparedStatement.executeUpdate();
            }
            
            upit = "insert into glumi (film, glumac) values (?, ?)";
            for (Glumi glumi : glumljenja) {
                preparedStatement = broker.getKonekcija().prepareStatement(upit);
                //preparedStatement.setLong(1, glumi.getFilm().getId());
                preparedStatement.setLong(1, film.getId());
                preparedStatement.setLong(2, glumi.getGlumac().getId());
                preparedStatement.executeUpdate();
            }
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteFilm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return film;
    }

    
    
}
