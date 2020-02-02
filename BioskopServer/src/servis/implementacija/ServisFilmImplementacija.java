/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Film;
import java.util.List;
import java.util.Map;
import servis.ServisFilm;
import skladiste.bazapodataka.BazapodatakaSkladisteFilm;
import skladistee.SkladisteFilm;

/**
 *
 * @author Bron Zilar
 */
public class ServisFilmImplementacija implements ServisFilm {
    
    private final SkladisteFilm skladisteFilm;

    public ServisFilmImplementacija() {
        skladisteFilm = new BazapodatakaSkladisteFilm();
    }

    @Override
    public Film sacuvaj(Film film) throws Exception {
        return skladisteFilm.sacuvaj(film);
    }

    @Override
    public List<Film> vratiSve() {
        return skladisteFilm.vratiSve();
    }

    @Override
    public boolean izmeni(Film film) {
        return skladisteFilm.izmeni(film);
    }

    @Override
    public Film sacuvajFilmReziraglumi(Map<String, Object> podaci) {
        return skladisteFilm.sacuvajFilmReziraGlumi(podaci);
    }

    @Override
    public boolean izmeniFilmRediteljeGlumce(Map<String, Object> podaci) {
        return skladisteFilm.izmeniFilmRediteljeGlumce(podaci);
    }

    @Override
    public boolean izmeniFilmReziraGlumi(Map<String, Object> mapa1) {
        return skladisteFilm.izmeniFilmReziraGlumi(mapa1);
    }
    
    
}
