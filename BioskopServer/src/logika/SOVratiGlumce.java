/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Glumac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiGlumce extends SistemskaOperacija {

    List<DomenskiObjekat> lista;

    public SOVratiGlumce(Glumac glumac) {
        super();
        odo = glumac;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
        lista = dbbr.vratiBezUslova(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}
