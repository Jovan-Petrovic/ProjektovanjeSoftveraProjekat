/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Rezervisanje;
import java.util.List;
import servis.ServisRezervisanje;
import skladiste.bazapodataka.BazapodatakaSkladisteRezervisanje;
import skladistee.SkladisteRezervisanje;

/**
 *
 * @author Bron Zilar
 */
public class ServisRezervisanjeImplementacija implements ServisRezervisanje{

    private final SkladisteRezervisanje skladisteRezervisanje;

    public ServisRezervisanjeImplementacija() {
        skladisteRezervisanje = new BazapodatakaSkladisteRezervisanje();
    }
    
    @Override
    public boolean sacuvaj(Rezervisanje rezervisanje) throws Exception {
        return skladisteRezervisanje.sacuvaj(rezervisanje);
    }

    @Override
    public List<Rezervisanje> vratiSva() throws Exception {
        return skladisteRezervisanje.vratiSva();
    }

    @Override
    public boolean obrisi(Long projekcijaID, Long korisnikID) throws Exception {
        return skladisteRezervisanje.obrisi(projekcijaID, korisnikID);
    }
    
}
