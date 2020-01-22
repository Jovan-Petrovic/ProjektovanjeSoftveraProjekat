/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Bron Zilar
 */
public interface DomenskiObjekat {
    public String getImeTabele();
    public String getImenaAtributaZaUbacivanje();
    public String getVrednostiAtributaZaUbacivanje();
    public boolean isAutoincrement();
    public void setObjekatID(Long id);
}
