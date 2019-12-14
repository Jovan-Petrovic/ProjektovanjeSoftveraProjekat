/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladistee;

import domen.Projekcija;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface SkladisteProjekcija {
    
    Projekcija sacuvaj(Projekcija projekcija);

    public List<Projekcija> vratiSve();
}
