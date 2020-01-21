/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladistee;

import domen.Rezervisanje;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public interface SkladisteRezervisanje {
    
    boolean sacuvaj(Rezervisanje rezervisanje);

    public List<Rezervisanje> vratiSva();

    public boolean obrisi(Long projekcijaID, Long korisnikID);

    public boolean obrisi(Map<String, Long> mapa);
}
