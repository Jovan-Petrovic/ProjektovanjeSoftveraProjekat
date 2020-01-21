/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Bron Zilar
 */
public class Projekcija implements Serializable {
    private Long id;
    private Date datum;
    private String sala;
    private Film film;

    public Projekcija(Long id, Date datum, String sala, Film film) {
        this.id = id;
        this.datum = datum;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    
    
    
}
