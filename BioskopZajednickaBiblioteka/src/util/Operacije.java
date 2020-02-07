/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Bron Zilar
 */
public class Operacije implements Serializable {
    
    public static final int VRATI_KORISNIKE = 1;
    public static final int VRATI_FILMOVE = 2;
    public static final int VRATI_REZIRANJA = 3;
    public static final int VRATI_REDITELJE = 4;
    public static final int VRATI_ULOGE = 5;
    public static final int VRATI_GLUMCE = 6;
    public static final int SACUVAJ_FILM_REZIRA_GLUMI = 7;
    public static final int VRATI_PROJEKCIJE = 8;
    public static final int OBRISI_PROJEKCIJU = 9;
    public static final int SACUVAJ_PROJEKCIJU = 10;
    public static final int SACUVAJ_REZERVACIJU = 11;
    public static final int VRATI_REZERVACIJE = 12;
    public static final int OTAKZI_REZERVACIJU = 13;
    public static final int IZMENI_FILM = 14;
    public static final int IZMENI_FILM_REDITELJE_GLUMCE = 15;
    public static final int IZMENI_FILM_REZIRA_GLUMI = 16;
    public static final int PRIJAVA = 17;
    public static final int VRATI_FILTRIRANE_FILMOVE = 18;
    public static final int ODJAVA = 19;
 
}
