/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.implementacija;

import domen.Projekcija;
import java.util.List;
import servis.ServisProjekcija;
import skladiste.bazapodataka.BazapodatakaSkladisteProjekcija;
import skladistee.SkladisteProjekcija;

/**
 *
 * @author Bron Zilar
 */
public class ServisProjekcijaImplementacija implements ServisProjekcija {
    
    private final SkladisteProjekcija skladisteProjekcija;

    public ServisProjekcijaImplementacija() {
        skladisteProjekcija = new BazapodatakaSkladisteProjekcija();
    }

    @Override
    public Projekcija sacuvaj(Projekcija projekcija) {
        return skladisteProjekcija.sacuvaj(projekcija);
    }

    @Override
    public List<Projekcija> vratiSve() throws Exception {
        return skladisteProjekcija.vratiSve();
    }

    
    
    
}
