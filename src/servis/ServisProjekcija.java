/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Projekcija;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface ServisProjekcija {
    
    Projekcija sacuvaj(Projekcija projekcija) throws Exception;

    public List<Projekcija> vratiSve() throws Exception;

    public boolean obrisi(Long id) throws Exception;
}
