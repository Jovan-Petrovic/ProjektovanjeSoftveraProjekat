/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Film;
import domen.Zanr;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bron Zilar
 */
public class FilmTableModel extends AbstractTableModel {
    
    private final List<Film> filmovi;
    private final String[] imenaKolona = new String[]{"ID","NAZIV","TRAJANJE","ZANR","GODINA","JEZIK","ocenaIMDb"};
    private final Class[] klaseKolona = new Class[]{Long.class, String.class, Integer.class, String.class,Integer.class,String.class,Double.class};

    public FilmTableModel(List<Film> filmovi) {
        this.filmovi = filmovi;
    }

    @Override
    public int getRowCount() {
        if(filmovi == null) {
            return 0;
        }
        return filmovi.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Film film = filmovi.get(red);
        switch(kolona) {
            case 0:
                return film.getId();
            case 1:
                return film.getNaziv();
            case 2:
                return film.getTrajanje();
            case 3:
                return film.getZanr();
            case 4:
                return film.getGodina();
            case 5:
                return film.getJezik();
            case 6:
                return film.getOcenaIMDb();
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

    public void pretraziFilmove(Zanr zanr, String naziv) {
        List<Film> zaUklanjanje = new ArrayList<>();
        for (Film film : filmovi) {
            if(!film.getZanr().equals(zanr) || !film.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
                zaUklanjanje.add(film);
            }
        }
        filmovi.removeAll(zaUklanjanje);
        fireTableDataChanged();
    }

    public Film nadjiFilm(Long id) {
        for (Film film : filmovi) {
            if(film.getId().equals(id)) {
                return film;
            }
        }
        return null;
    }
   
}
