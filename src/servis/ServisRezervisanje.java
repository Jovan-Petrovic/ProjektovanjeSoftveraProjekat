/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Rezervisanje;

/**
 *
 * @author Bron Zilar
 */
public interface ServisRezervisanje {
    
    boolean sacuvaj(Rezervisanje rezervisanje) throws Exception;
}
