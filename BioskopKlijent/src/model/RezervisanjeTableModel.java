/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Projekcija;
import domen.Rezervisanje;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class RezervisanjeTableModel extends AbstractTableModel {
    
    private final List<Rezervisanje> rezervisanja;
    private final String[] imenaKolona = new String[]{"PROJEKCIJA_ID","FILM","DATUM","SALA"};
    private final Class[] klaseKolona = new Class[]{Long.class,String.class, Date.class, Integer.class};

    public RezervisanjeTableModel(List<Rezervisanje> rezervisanja) {
        this.rezervisanja = rezervisanja;
    }

    @Override
    public int getRowCount() {
        if(rezervisanja == null) {
            return 0;
        }
        return rezervisanja.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Rezervisanje rezervisanje = rezervisanja.get(red);
        switch(kolona) {
            case 0:
                return rezervisanje.getProjekcija().getId();
            case 1:
                return rezervisanje.getProjekcija().getFilm().getNaziv();
            case 2:
                return rezervisanje.getProjekcija().getDatum();
            case 3:
                return rezervisanje.getProjekcija().getSala();
            default:
                return "N/A";            
        }
    }

    @Override
    public String getColumnName(int kolona) {
        if(kolona > imenaKolona.length) {
            return "N/A";
        }
        return imenaKolona[kolona];
    }

    @Override
    public Class<?> getColumnClass(int kolona) {
        return klaseKolona[kolona];
    }

    public Rezervisanje vratiRezervisanje(int selektovanRed) {
        return rezervisanja.get(selektovanRed);
    }

    

}
