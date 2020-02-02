/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Reditelj;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class RediteljTableModel extends AbstractTableModel {
    
    private final List<Reditelj> reditelji;
    private final String[] imenaKolona = new String[]{"ID","IME","PREZIME","DRZANLJANSTVO","BROJ FILMOVA"};
    private final Class[] klaseKolona = new Class[]{Long.class, String.class, String.class, String.class, Integer.class};
    private final List<Reditelj> listaObrisanih;

    public RediteljTableModel(List<Reditelj> reditelji) {
        this.reditelji = reditelji;
        this.listaObrisanih = new ArrayList<>();
    }

    public RediteljTableModel() {
        this.reditelji = new ArrayList<>();
        this.listaObrisanih = new ArrayList<>();
    }

    
    
    @Override
    public int getRowCount() {
        if(reditelji == null) {
            return 0;
        }
        return reditelji.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Reditelj reditelj = reditelji.get(red);
        switch(kolona) {
            case 0:
                return reditelj.getId();
            case 1:
                return reditelj.getIme();
            case 2:
                return reditelj.getPrezime();
            case 3:
                return reditelj.getDrzanljanstvo();
            case 4:
                return reditelj.getBrojFilmova();
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

    public void dodajReditelja(Reditelj reditelj) {
        if(!reditelji.contains(reditelj)) {
            reditelji.add(reditelj);
        }
        fireTableDataChanged();
    }

    public void obrisiReditelja(Long id) {
        Reditelj r = null;
        for (Reditelj reditelj : reditelji) {
            if(reditelj.getId().equals(id)) {
                r = reditelj;
            }
        }
        reditelji.remove(r);
        fireTableDataChanged();
    }

    public List<Reditelj> getReditelji() {
        return reditelji;
    }

    @Override
    public void setValueAt(Object vrednost, int red, int kolona) {
        Reditelj reditelj = reditelji.get(red);
        switch(kolona) {
            case 1:
                reditelj.setIme((String) vrednost);
                break;
            case 2:
                reditelj.setPrezime((String) vrednost);
                break;
            case 3:
                reditelj.setDrzanljanstvo((String) vrednost);
                break;
            case 4:
                reditelj.setBrojFilmova((int) vrednost);
                break;
        }
    }

    public void obrisiReditelja(int selektovanRed) {
        reditelji.remove(selektovanRed);
        fireTableDataChanged();
    }

    public void dodajRediteljaZaIzmenu(Reditelj reditelj) {
        if(!reditelji.contains(reditelj)) {
            reditelj.setStatus("dodaj");
            reditelji.add(reditelj);
        }
        fireTableDataChanged();
    }

    public Reditelj vratiReditelja(int selektovanRed) {
        return reditelji.get(selektovanRed);
    }

    public void obrisiRediteljaZaIzmenu(Reditelj r) {
        r.setStatus("obrisi");
        listaObrisanih.add(r);
        reditelji.remove(r);
        fireTableDataChanged();
    }

    public List<Reditelj> vratiSveReditelje() {
        List<Reditelj> lista = reditelji;
        lista.addAll(listaObrisanih);
        return lista;
    }
 
}
