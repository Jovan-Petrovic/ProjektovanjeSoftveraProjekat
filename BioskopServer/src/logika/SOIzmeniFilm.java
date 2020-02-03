/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Film;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public class SOIzmeniFilm extends SistemskaOperacija{

    Map<String, Object> podaci;

    public SOIzmeniFilm(Map<String, Object> podaci) {
        super();
        odo = (DomenskiObjekat) podaci.get("film");
        this.podaci = podaci;
    }

    @Override
    protected void operacija() throws Exception {
        dbbr.izmeniSlozenSlucaj(odo,podaci);
    }
    
}
