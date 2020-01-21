/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Glumac;
import java.util.List;

/**
 *
 * @author Bron Zilar
 */
public interface ServisGlumac {
    
    List<Glumac> vratiSve() throws Exception;
}
