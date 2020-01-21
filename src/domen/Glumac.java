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
public class Glumac {
    private Long id;
    private String ime;
    private String prezime;
    private String drzanljanstvo;

    public Glumac(Long id, String ime, String prezime, String drzanljanstvo) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.drzanljanstvo = drzanljanstvo;
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

    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }
    
}
