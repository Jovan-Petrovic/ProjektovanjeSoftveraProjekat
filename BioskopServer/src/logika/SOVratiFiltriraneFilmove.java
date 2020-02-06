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
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiFiltriraneFilmove extends SistemskaOperacija {

    List<DomenskiObjekat> lista;
    
    public SOVratiFiltriraneFilmove(Film film) {
        super();
        odo = film;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
       lista = dbbr.vratiListuSaUslovom(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
}
