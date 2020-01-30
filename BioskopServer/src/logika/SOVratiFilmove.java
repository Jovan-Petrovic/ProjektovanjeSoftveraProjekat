/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Film;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiFilmove extends SistemskaOperacija {

    List<DomenskiObjekat> lista;
    
    public SOVratiFilmove(Film film) {
        super();
        odo = film;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
       lista = dbbr.vratiBezUslova(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
}
