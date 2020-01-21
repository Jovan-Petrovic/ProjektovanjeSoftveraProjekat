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
public class Reditelj implements Serializable {
    private Long id;
    private String ime;
    private String prezime;
    private String drzanljanstvo;
    private int brojFilmova;

    public Reditelj(Long id, String ime, String prezime, String drzanljanstvo, int brojFilmova) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.drzanljanstvo = drzanljanstvo;
        this.brojFilmova = brojFilmova;
    }

    public String getDrzanljanstvo() {
        return drzanljanstvo;
    }

    public void setDrzanljanstvo(String drzanljanstvo) {
        this.drzanljanstvo = drzanljanstvo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
     public int getBrojFilmova() {
        return brojFilmova;
    }

    public void setBrojFilmova(int brojFilmova) {
        this.brojFilmova = brojFilmova;
    }
    
    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }

}
