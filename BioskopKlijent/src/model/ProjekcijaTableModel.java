/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import domen.Projekcija;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private final String[] imenaKolona = new String[]{"DATUM I VREME","SALA","FILMID","NAZIV_FILMA","PREOSTALO_MESTA"};
    private final Class[] klaseKolona = new Class[]{String.class, String.class, Long.class, String.class, Integer.class}; 

    public ProjekcijaTableModel(List<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }

    public ProjekcijaTableModel() {
        projekcije = new ArrayList<>();
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
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String datumVreme = sdf.format(projekcija.getDatumVreme());
                return datumVreme;
            case 1:
                return projekcija.getSala();
            case 2:
                return projekcija.getFilm().getId();
            case 3:
                return projekcija.getFilm().getNaziv();
            case 4:
                return projekcija.getBrojMesta();
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

    public void pretraziProjekcijePoNazivuFilmaIDatumuProjekcije(String naziv, Date datum) {
        List<Projekcija> zaUklanjanje = new ArrayList<>();
        if(datum == null) {
            for (Projekcija projekcija : projekcije) {
                if(!projekcija.getFilm().getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
                    zaUklanjanje.add(projekcija);
                }
            }
        } else {
            for (Projekcija projekcija : projekcije) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                String d1 = sdf.format(datum);
                String d2 = sdf.format(projekcija.getDatumVreme());
                if(!projekcija.getFilm().getNaziv().toLowerCase().contains(naziv.toLowerCase()) || !d1.equals(d2)) {
                    zaUklanjanje.add(projekcija);
                }
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

    public boolean dodajProjekciju(Projekcija p) {
        if(!projekcije.contains(p)) {
            projekcije.add(p);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    public void obrisiProjekciju(int selektovanRed) {
        projekcije.remove(selektovanRed);
        fireTableDataChanged();
    }

    public List<Projekcija> vratiProjekcije() {
        return projekcije;
    }

    public Projekcija vratiProjekciju(int red) {
        return projekcije.get(red);
    }

    public Projekcija nadjiProjekciju(int selektovanRed) {
        return projekcije.get(selektovanRed);
    }
    
    
}
