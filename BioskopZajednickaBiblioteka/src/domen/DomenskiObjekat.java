/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

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
    public List<DomenskiObjekat> ucitajListu(ResultSet rs);
    public String vratiJoinTabelu();
    public String vratiUslovZaJoin();
    public String vratiJoinTabelu2();
    public String vratiUslovZaJoin2();
    public String vratiJoinTabelu3();
    public String vratiUslovZaJoin3();
    public String vratiUslovZaBrisanje();
    public String vratiVrednostiZaOperacijuUpdate();
    public String vratiUslovZaOperacijuUpdate();
    public String vratiUslovZaCitanje();
    public DomenskiObjekat ucitajDomenskiObjekat(ResultSet rs);

}
