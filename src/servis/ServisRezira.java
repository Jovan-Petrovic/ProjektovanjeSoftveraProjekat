/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Rezira;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface ServisRezira {
    
    void sacuvaj(Rezira rezira) throws Exception;

    public List<Rezira> vratiSve() throws Exception;
}
