/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Glumi;
import java.util.List;
import servis.ServisGlumi;
import skladiste.bazapodataka.BazapodatakaSkladisteGlumi;
import skladistee.SkladisteGlumi;

/**
 *
 * @author Bron Zilar
 */
public class ServisGlumiImplementacija implements ServisGlumi {

    private final SkladisteGlumi skladisteGlumi;

    public ServisGlumiImplementacija() {
        skladisteGlumi = new BazapodatakaSkladisteGlumi();
    }
    
    
    
    @Override
    public void sacuvaj(Glumi glumi) throws Exception {
        skladisteGlumi.sacuvaj(glumi);
    }

    @Override
    public List<Glumi> vratiSve() {
        return skladisteGlumi.vratiSve();
    }
    
}
