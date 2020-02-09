/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Rezervisanje;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciRezervisanje extends SistemskaOperacija {

    public SOUbaciRezervisanje(Rezervisanje rezervisanje) {
        super();
        odo = rezervisanje;
    }

    @Override
    protected void operacija() throws Exception {
        dbbr.ubaciSaIzmenom(odo);
    }
    
    
}
