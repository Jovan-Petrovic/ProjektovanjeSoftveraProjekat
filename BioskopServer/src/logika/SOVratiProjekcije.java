/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.DomenskiObjekat;
import domen.Projekcija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public class SOVratiProjekcije extends SistemskaOperacija {

    List<DomenskiObjekat> lista;

    public SOVratiProjekcije(Projekcija projekcija) {
        super();
        odo = projekcija;
        lista = new ArrayList<>();
    }

    @Override
    protected void operacija() throws Exception {
        lista = dbbr.vratiDveTabele(odo);
    }

    public List<DomenskiObjekat> getLista() {
        return lista;
    }
    
    
}
