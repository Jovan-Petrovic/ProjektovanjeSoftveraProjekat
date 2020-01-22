/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Film;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciFilm extends SistemskaOperacija {

    public SOUbaciFilm(Film film) {
        super();
        odo = film;
    }
 
    @Override
    protected void operacija() throws Exception {
        dbbr.ubaci(odo);
    }
    
}
