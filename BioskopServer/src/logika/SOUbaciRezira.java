/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Rezira;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciRezira extends SistemskaOperacija {

    public SOUbaciRezira(Rezira rezira) {
        super();
        odo = rezira;
    }
 
    @Override
    protected void operacija() throws Exception {
        dbbr.ubaci(odo);
    }
    
}
