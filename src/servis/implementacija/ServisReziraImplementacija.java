/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Rezira;
import servis.ServisRezira;
import skladiste.bazapodataka.BazapodatakaSkladisteRezira;
import skladistee.SkladisteRezira;

/**
 *
 * @author Bron Zilar
 */
public class ServisReziraImplementacija implements ServisRezira{
    
    private final SkladisteRezira skladisteRezira;

    public ServisReziraImplementacija() {
        skladisteRezira = new BazapodatakaSkladisteRezira();
    }

    @Override
    public void sacuvaj(Rezira rezira) throws Exception {
        skladisteRezira.sacuvaj(rezira);
    }
    
    
}
