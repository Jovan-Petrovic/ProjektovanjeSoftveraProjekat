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
public class Glumi {
    private double ocena;
    private String napomena;
    private Film film;
    private Glumac glumac;

    public Glumi(double ocena, String napomena, Film film, Glumac glumac) {
        this.ocena = ocena;
        this.napomena = napomena;
        this.film = film;
        this.glumac = glumac;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
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
