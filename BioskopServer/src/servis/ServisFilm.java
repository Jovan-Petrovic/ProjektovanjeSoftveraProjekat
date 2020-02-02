/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Film;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public interface ServisFilm {
    
    Film sacuvaj(Film film) throws Exception;
    
    List<Film> vratiSve() throws Exception;

    public boolean izmeni(Film film);

    public Film sacuvajFilmReziraglumi(Map<String, Object> podaci);

    public boolean izmeniFilmRediteljeGlumce(Map<String, Object> podaci);

    public boolean izmeniFilmReziraGlumi(Map<String, Object> mapa1);
   
}
