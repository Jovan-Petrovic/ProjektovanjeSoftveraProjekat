/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Reditelj;
import java.util.List;
import servis.ServisReditelj;
import skladiste.bazapodataka.BazaPodatakaSkladisteReditelj;
import skladistee.SkladisteReditelj;

/**
 *
 * @author Bron Zilar
 */
public class ServisRediteljImplementacija implements ServisReditelj {
    
    private final SkladisteReditelj skladisteReditelj;

    public ServisRediteljImplementacija() {
        skladisteReditelj = new BazaPodatakaSkladisteReditelj();
    }
    

    @Override
    public List<Reditelj> vratiSve() throws Exception {
        return skladisteReditelj.vratiSve();
    }
    
    
}
