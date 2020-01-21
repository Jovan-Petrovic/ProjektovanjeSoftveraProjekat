/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Rezervisanje;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bron Zilar
 */
public interface ServisRezervisanje {
    
    boolean sacuvaj(Rezervisanje rezervisanje) throws Exception;

    public List<Rezervisanje> vratiSva() throws Exception;

    public boolean obrisi(Long projekcijaID, Long korisnikID) throws Exception;

    public boolean obrisi(Map<String, Long> mapa);
}
