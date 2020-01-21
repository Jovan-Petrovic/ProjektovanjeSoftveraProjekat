/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.memorija;

import domen.Film;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class MemorijaSkladisteFilm {
    private final List<Film> filmovi;

    public MemorijaSkladisteFilm() {
        filmovi = new LinkedList<>();
    }

    public void dodaj(Film film) {
        filmovi.add(film);
    }
    
    public List<Film> vratiSve() {
        return filmovi;
    }
}
