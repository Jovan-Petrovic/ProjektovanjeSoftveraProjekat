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
public class Glumi implements Serializable, DomenskiObjekat {
    private Film film;
    private Glumac glumac;

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
    
    
}
