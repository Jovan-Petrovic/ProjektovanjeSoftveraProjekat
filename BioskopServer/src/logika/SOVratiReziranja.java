/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Rezira;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiReziranja extends SistemskaOperacija {
    
    List<DomenskiObjekat> lista;

    public SOVratiReziranja(Rezira rezira) {
        super();
        odo = rezira;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
        lista = dbbr.vratiTriTabele(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}
