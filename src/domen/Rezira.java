/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Bron Zilar
 */
public class Rezira {
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
    
    
}
