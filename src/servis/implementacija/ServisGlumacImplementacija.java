/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Glumac;
import java.util.List;
import servis.ServisGlumac;
import skladiste.bazapodataka.BazapodatakaSkladisteGlumac;
import skladistee.SkladisteGlumac;

/**
 *
 * @author Bron Zilar
 */
public class ServisGlumacImplementacija implements ServisGlumac {
    
    private final SkladisteGlumac skladisteGlumac;

    public ServisGlumacImplementacija() {
        skladisteGlumac = new BazapodatakaSkladisteGlumac();
    }

    @Override
    public List<Glumac> vratiSve() throws Exception {
        return skladisteGlumac.vratiSve();
    }
    
    
}
