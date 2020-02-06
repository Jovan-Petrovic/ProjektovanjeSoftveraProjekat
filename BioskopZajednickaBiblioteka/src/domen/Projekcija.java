/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Projekcija implements Serializable, DomenskiObjekat {
    private Long id;
    private Timestamp datumVreme;
    private String sala;
    private Film film;

    public Projekcija() {
    }

    public Projekcija(Long id, Timestamp datumVreme, String sala, Film film) {
        this.id = id;
        this.datumVreme = datumVreme;
        this.sala = sala;
        this.film = film;
    }
    
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    public Timestamp getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Timestamp datumVreme) {
        this.datumVreme = datumVreme;
    }

    @Override
    public String getImeTabele() {
        return "projekcija";
    }

    @Override
    public String getImenaAtributaZaUbacivanje() {
        return "datum, sala, filmID";
    }

    @Override
    public String getVrednostiAtributaZaUbacivanje() {
        return "'"+new java.sql.Timestamp(datumVreme.getTime())+"', '"+sala+"', "+film.getId();
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjekatID(Long id) {
        setId(id);
    }

    @Override
    public List<DomenskiObjekat> ucitajListu(ResultSet rs) {
        List<DomenskiObjekat> projekcije = new ArrayList<>();
        try {
            while(rs.next()) {
                Long idFilm = rs.getLong("film.id");
                String naziv = rs.getString("naziv");
                int trajanje = rs.getInt("trajanje");
                Zanr zanr = Zanr.valueOf(rs.getString("zanr"));
                int godina = rs.getInt("godina");
                String jezik = rs.getString("jezik");
                double ocenaIMDb = rs.getInt("ocenaIMDb");
                Film film = new Film(idFilm, naziv, trajanje, zanr, godina, jezik, ocenaIMDb);
                
                Long idProjekcija = rs.getLong("projekcija.id");
                Timestamp datumVreme = rs.getTimestamp("datum");
                String sala = rs.getString("sala");
                Projekcija projekcija = new Projekcija(idProjekcija, datumVreme, sala, film);
                
                projekcije.add(projekcija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Projekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projekcije;
    }

    @Override
    public String vratiJoinTabelu() {
        return "film";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "projekcija.filmID = film.id";
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "id = " + id;
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

}
