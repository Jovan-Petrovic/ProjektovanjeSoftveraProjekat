/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Projekcija;

/**
 *
 * @author Bron Zilar
 */
public class SOUbaciProjekciju extends SistemskaOperacija {

    public SOUbaciProjekciju(Projekcija projekcija) {
        super();
        odo = projekcija;
    }

    @Override
    protected void operacija() throws Exception {
         dbbr.ubaci(odo);
    }
    
}
