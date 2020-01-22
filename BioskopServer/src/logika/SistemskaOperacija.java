/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.Broker;
import domen.DomenskiObjekat;

/**
 *
 * @author Bron Zilar
 */
public abstract class SistemskaOperacija {
    Broker dbbr;
    DomenskiObjekat odo;

    public SistemskaOperacija() {
        dbbr = new Broker();
    }
    
     protected void konektujSkladiste() throws Exception{
        dbbr.otvoriKonekciju();
    }
     
    protected void diskonektujSkladiste() throws Exception{
        dbbr.zatvoriKonekciju();
    }
    
    protected abstract void operacija() throws Exception;
    
    public void execute() throws Exception{
        konektujSkladiste();
        try {
            operacija();
            dbbr.commit();
        } catch (Exception ex) {
            dbbr.rollback();
            throw ex;
        }finally{
            diskonektujSkladiste();
        }
    }

    public DomenskiObjekat getOdo() {
        return odo;
    }

    
    
    
}
