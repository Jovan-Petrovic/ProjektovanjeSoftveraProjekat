/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.bazapodataka;

import baza.Broker;
import domen.Film;
import domen.Projekcija;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
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

    @Override
    public List<Projekcija> vratiSve() {
        List<Projekcija> projekcije = new ArrayList<>();
        List<Film> filmovi = null;
        try {
            filmovi = Kontroler.getInstanca().vratiSveFilmove();
        } catch (Exception ex) {
            Logger.getLogger(BazapodatakaSkladisteProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            broker.otvoriKonekciju();
            String upit = "select * from projekcija";
            Connection koneckija = broker.getKonekcija();
            Statement statement = koneckija.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()) {
                Long id = rs.getLong("id");
                Date datum = rs.getDate("datum");
                int sala = rs.getInt("sala");
                Long filmID = rs.getLong("filmID");
                Film f = null;
                for(Film film : filmovi) {
                    if(film.getId().equals(filmID)) {
                        f = film;
                    }
                }
                Projekcija projekcija = new Projekcija(id, datum, sala, f);
                projekcije.add(projekcija);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BazapodatakaSkladisteProjekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projekcije;
    }

    @Override
    public boolean obrisi(Long id) {
        try {
            broker.otvoriKonekciju();
            String upit = "delete from projekcija where id=?";
            PreparedStatement preparedStatement = broker.getKonekcija().prepareStatement(upit);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            broker.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            broker.rollback();
            Logger.getLogger(BazapodatakaSkladisteProjekcija.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}
