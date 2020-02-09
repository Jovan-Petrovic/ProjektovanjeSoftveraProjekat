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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Glumi implements Serializable, DomenskiObjekat {
    private Film film;
    private Glumac glumac;

    public Glumi() {
    }

    public Glumi(Film film, Glumac glumac) {
        this.film = film;
        this.glumac = glumac;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String getImeTabele() {
        return "glumi";
    }

    @Override
    public String getImenaAtributaZaUbacivanje() {
        return "film, glumac";
    }

    @Override
    public String getVrednostiAtributaZaUbacivanje() {
        return film.getId()+", "+glumac.getId();
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
        List<DomenskiObjekat> uloge = new ArrayList<>();
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
                
                Long idGlumac = rs.getLong("glumac.id");
                String ime = rs.getString("glumac.ime");
                String prezime = rs.getString("glumac.prezime");
                String drzanljanstvo = rs.getString("glumac.drzanljanstvo");
                Glumac glumac = new Glumac(idGlumac, ime, prezime, drzanljanstvo);
                
                Glumi glumi = new Glumi(film, glumac);
                
                uloge.add(glumi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uloge;
    }

    @Override
    public String vratiJoinTabelu() {
        return "film";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "glumi.film=film.id";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "glumac";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "glumi.glumac=glumac.id";
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
        return " film = " + film.getId() + " AND glumac = " + glumac.getId();
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

    @Override
    public String getImePovezaneTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdatePovezaneTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaOperacijuUpdatePovezaneTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
