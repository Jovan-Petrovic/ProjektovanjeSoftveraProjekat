/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Bron Zilar
 */
public class Rezira implements Serializable, DomenskiObjekat {
    private Film film;
    private Reditelj reditelj;

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
    
    
}
