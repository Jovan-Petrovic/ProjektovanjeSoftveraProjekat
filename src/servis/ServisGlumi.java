/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Glumi;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface ServisGlumi {
    
    void sacuvaj(Glumi glumi) throws Exception;

    public List<Glumi> vratiSve();
    
}
