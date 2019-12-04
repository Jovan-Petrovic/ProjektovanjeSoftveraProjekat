/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Film;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
