/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladistee;

import domen.Film;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public interface SkladisteFilm {
    
    Film sacuvaj(Film film);
    
    List<Film> vratiSve();

    public boolean izmeni(Film film);

    public Film sacuvajFilmReziraGlumi(Map<String, Object> podaci);

    public boolean izmeniFilmRediteljeGlumce(Map<String, Object> podaci);

    
}
