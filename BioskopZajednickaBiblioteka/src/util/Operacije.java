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
    
}
