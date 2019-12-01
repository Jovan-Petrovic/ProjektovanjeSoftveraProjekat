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
    private double Ocena;
    private String napomena;
    private Film film;
    private Reditelj reditelj;

    public Rezira(double Ocena, String napomena, Film film, Reditelj reditelj) {
        this.Ocena = Ocena;
        this.napomena = napomena;
        this.film = film;
        this.reditelj = reditelj;
    }

    public Reditelj getReditelj() {
        return reditelj;
    }

    public void setReditelj(Reditelj reditelj) {
        this.reditelj = reditelj;
    }

    public double getOcena() {
        return Ocena;
    }

    public void setOcena(double Ocena) {
        this.Ocena = Ocena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    
}
