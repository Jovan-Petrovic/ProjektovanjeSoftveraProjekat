/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Glumac;
import java.util.ArrayList;
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
    private final List<Glumac> listaObrisanih;

    public GlumacTableModel(List<Glumac> glumci) {
        this.glumci = glumci;
        this.listaObrisanih = new ArrayList<>();
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

    public void obrisiGlumca(Long id) {
        Glumac g = null;
        for (Glumac glumac : glumci) {
            if(glumac.getId().equals(id)) {
                g = glumac;
            }
        }
        glumci.remove(g);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object vrednost, int red, int kolona) {
        Glumac glumac = glumci.get(red);
        switch(kolona) {
            case 1:
                glumac.setIme((String) vrednost);
                break;
            case 2:
                glumac.setPrezime((String) vrednost);
                break;
            case 3:
                glumac.setDrzanljanstvo((String) vrednost);
                break;
        }
    }

    public List<Glumac> getGlumci() {
        return glumci;
    }

    public void obrisiGlumca(int selektovanRed) {
        glumci.remove(selektovanRed);
        fireTableDataChanged();
    }

    public Glumac vratiGlumca(int selektovanRed) {
        return glumci.get(selektovanRed);
    }

    public void obrisiGlumcaZaIzmenu(Glumac g) {
        g.setStatus("obrisi");
        listaObrisanih.add(g);
        glumci.remove(g);
        fireTableDataChanged();
    }

    public void dodajGlumcaZaIzmenu(Glumac glumac) {
        if(!glumci.contains(glumac)) {
            glumac.setStatus("dodaj");
            glumci.add(glumac);
        }
        fireTableDataChanged();
    }

    public List<Glumac> vratiSveGlumce() {
        List<Glumac> lista = glumci;
        lista.addAll(listaObrisanih);
        return lista;
    }
  
    
}
