/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Rezervisanje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiRezervacije extends SistemskaOperacija {

    List<DomenskiObjekat> lista;

    public SOVratiRezervacije(Rezervisanje rezervisanje) {
        super();
        odo = rezervisanje;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
        lista = dbbr.vratiCetiriTabele(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
}
