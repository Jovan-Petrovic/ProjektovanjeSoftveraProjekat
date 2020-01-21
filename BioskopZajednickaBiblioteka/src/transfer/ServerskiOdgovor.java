/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.Status;
import java.io.Serializable;

/**
 *
 * @author Bron Zilar
 */
public class ServerskiOdgovor implements Serializable {
    
    private Object odgovor;
    private String poruka;
    private Status status;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, String poruka, Status status) {
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.status = status;
    }

    
    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}
