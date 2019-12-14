/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Projekcija;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class ProjekcijaTableModel extends AbstractTableModel {

    private final List<Projekcija> projekcije;
    private final String[] imenaKolona = new String[]{"ID","DATUM","SALA","FILMID"};
    private final Class[] klaseKolona = new Class[]{Long.class, Date.class, Integer.class, Long.class};

    public ProjekcijaTableModel(List<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }
 
    @Override
    public int getRowCount() {
        if(projekcije == null) {
            return 0;
        }
        return projekcije.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Projekcija projekcija = projekcije.get(red);
        switch(kolona) {
            case 0:
                return projekcija.getId();
            case 1:
                return projekcija.getDatum();
            case 2:
                return projekcija.getSala();
            case 3:
                return projekcija.getFilm().getId();
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

    public void pretraziProjekcijePoNazivuFilma(String naziv) {
        List<Projekcija> zaUklanjanje = new ArrayList<>();
        for (Projekcija projekcija : projekcije) {
            if(!projekcija.getFilm().getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
                zaUklanjanje.add(projekcija);
            }
        }
        projekcije.removeAll(zaUklanjanje);
        fireTableDataChanged();
    }

    public Projekcija nadjiProjekciju(Long id) {
        for (Projekcija projekcija : projekcije) {
            if(projekcija.getId().equals(id)) {
                return projekcija;
            }
        }
        return null;
    }
    
    
}
