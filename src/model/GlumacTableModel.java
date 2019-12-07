/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Glumac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class GlumacTableModel extends AbstractTableModel {
    
    private final List<Glumac> glumci;
    private final String[] imenaKolona = new String[]{"ID","IME","PREZIME","DRZANLJANSTVO"};
    private final Class[] klaseKolona = new Class[]{Long.class, String.class, String.class, String.class};

    public GlumacTableModel(List<Glumac> glumci) {
        this.glumci = glumci;
    }

    @Override
    public int getRowCount() {
        if(glumci == null) {
            return 0;
        }
        return glumci.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Glumac glumac = glumci.get(red);
        switch(kolona) {
            case 0:
                return glumac.getId();
            case 1:
                return glumac.getIme();
            case 2:
                return glumac.getPrezime();
            case 3:
                return glumac.getDrzanljanstvo();
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

    public void dodajGlumca(Glumac glumac) {
        if(!glumci.contains(glumac)) {
            glumci.add(glumac);
        }
        fireTableDataChanged();
    }

    

    
}
