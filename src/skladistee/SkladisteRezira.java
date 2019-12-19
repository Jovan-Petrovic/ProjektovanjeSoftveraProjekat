/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladistee;

import domen.Rezira;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface SkladisteRezira {
    
    void sacuvaj(Rezira rezira);

    public List<Rezira> vratiSve();
}
