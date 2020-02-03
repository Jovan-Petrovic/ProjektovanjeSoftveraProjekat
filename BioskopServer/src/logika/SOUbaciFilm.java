/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Film;
import domen.Glumi;
import domen.Rezira;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciFilm extends SistemskaOperacija {

    Map<String, Object> podaci;
    
    public SOUbaciFilm(Film film, Map<String, Object> podaci) {
        super();
        odo = film;
        this.podaci = podaci;
    }
 
    @Override
    protected void operacija() throws Exception {
        Film film = (Film) podaci.get("film");
        ArrayList<Rezira> reziranja = (ArrayList<Rezira>) podaci.get("rezira");
        ArrayList<Glumi> uloge = (ArrayList<Glumi>) podaci.get("glumi");
        for (Rezira rezira : reziranja) {
            rezira.setFilm(film);

        }
        for (Glumi glumi : uloge) {
            glumi.setFilm(film);
        }
        dbbr.ubaciSlozenSlucaj(odo,podaci);
    }
    
}
