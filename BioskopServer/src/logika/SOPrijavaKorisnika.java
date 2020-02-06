/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Korisnik;

/**
 *
 * @author Bron Zilar
 */
public class SOPrijavaKorisnika extends SistemskaOperacija {

    Korisnik korisnik;
    
    public SOPrijavaKorisnika(Korisnik korisnik) {
        super();
        odo = korisnik;
        this.korisnik = new Korisnik();
    }

    @Override
    protected void operacija() throws Exception {
        if(dbbr.vratiSaUslovom(odo) != null) {
            this.korisnik = (Korisnik) dbbr.vratiSaUslovom(odo);
        } else {
            this.korisnik = null;
        }
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }
    
    
}
