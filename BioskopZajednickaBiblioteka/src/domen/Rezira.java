/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Rezira implements Serializable, DomenskiObjekat {
    private Film film;
    private Reditelj reditelj;

    public Rezira() {
    }
    
    public Rezira(Film film, Reditelj reditelj) {
        this.film = film;
        this.reditelj = reditelj;
    }

    public Reditelj getReditelj() {
        return reditelj;
    }

    public void setReditelj(Reditelj reditelj) {
        this.reditelj = reditelj;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String getImeTabele() {
        return "rezira";
    }

    @Override
    public String getImenaAtributaZaUbacivanje() {
        return "film, reditelj";
    }

    @Override
    public String getVrednostiAtributaZaUbacivanje() {
        return film.getId()+", "+reditelj.getId();
    }

    @Override
    public boolean isAutoincrement() {
        return false;
    }

    @Override
    public void setObjekatID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DomenskiObjekat> ucitajListu(ResultSet rs) {
        List<DomenskiObjekat> reziranja = new ArrayList<>();
        try {
            while(rs.next()) {
                Long idFilm = rs.getLong("film.id");
                String naziv = rs.getString("film.naziv");
                int trajanje = rs.getInt("film.trajanje");
                Zanr zanr = Zanr.valueOf(rs.getString("film.zanr"));
                int godina = rs.getInt("film.godina");
                String jezik = rs.getString("film.jezik");
                double ocenaIMDb = rs.getInt("film.ocenaIMDb");
                Film film = new Film(idFilm, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
                
                Long idReditelj = rs.getLong("reditelj.id");
                String ime = rs.getString("reditelj.ime");
                String prezime = rs.getString("reditelj.prezime");
                String drzanljanstvo = rs.getString("reditelj.drzanljanstvo");
                int brojFilmova = rs.getInt("reditelj.brojFilmova");
                Reditelj reditelj = new Reditelj(idReditelj, ime, prezime, drzanljanstvo, brojFilmova);
                
                Rezira rezira = new Rezira(film, reditelj);
                
                reziranja.add(rezira);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reziranja;
    }

    @Override
    public String vratiJoinTabelu() {
        return "film";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "rezira.film=film.id";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "reditelj";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "rezira.reditelj=reditelj.id";
    }

    @Override
    public String vratiJoinTabelu3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " film = " + film.getId() + " AND reditelj = " + reditelj.getId();
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaCitanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DomenskiObjekat ucitajDomenskiObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaCitanjeListe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
