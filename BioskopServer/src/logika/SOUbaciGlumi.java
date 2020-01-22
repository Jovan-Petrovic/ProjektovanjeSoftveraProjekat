/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Glumi;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciGlumi extends SistemskaOperacija {

    public SOUbaciGlumi(Glumi glumi) {
        super();
        odo = glumi;
    }

    @Override
    protected void operacija() throws Exception {
        dbbr.ubaci(odo);
    }
    
}
