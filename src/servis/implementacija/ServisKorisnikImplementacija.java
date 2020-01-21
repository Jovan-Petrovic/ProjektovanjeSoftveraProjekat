/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Korisnik;
import java.util.List;
import servis.ServisKorisnik;
import skladiste.bazapodataka.BazapodatakaSkladisteKorisnik;
import skladistee.SkladisteKorisnik;

/**
 *
 * @author Bron Zilar
 */
public class ServisKorisnikImplementacija implements ServisKorisnik{

    private final SkladisteKorisnik skladisteKorisnik;

    public ServisKorisnikImplementacija() {
        skladisteKorisnik = new BazapodatakaSkladisteKorisnik();
    }
 
    @Override
    public List<Korisnik> vratiSve() throws Exception {
        return skladisteKorisnik.vratiSve();
    }
    
}
