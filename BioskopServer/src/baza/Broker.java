 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.DomenskiObjekat;
import domen.Film;
import domen.Glumac;
import domen.Glumi;
import domen.Reditelj;
import domen.Rezira;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron Zilar
 */
public class Broker {
    
    private Connection konekcija;
    
    public void otvoriKonekciju() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileInputStream in=new FileInputStream("db.properties");
            Properties props=new Properties();
            props.load(in);
            String driver=props.getProperty("driver");
            String url=props.getProperty("url");
            String user=props.getProperty("user");
            String password=props.getProperty("password");
            
            Class.forName(driver);
            
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju() {
        if(konekcija != null) {
            try {
                konekcija.close();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void commit() {
        if(konekcija != null) {
            try {
                konekcija.commit();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void rollback() {
        if(konekcija != null) {
            try {
                konekcija.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public DomenskiObjekat ubaci(DomenskiObjekat odo) throws Exception {
        try {
            String upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
            System.out.println(upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            
            if(odo.isAutoincrement()) {
                ResultSet rs=statement.getGeneratedKeys();
                if(rs.next()){
                    odo.setObjekatID(rs.getLong(1));
                }
            }           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja "+odo.getImeTabele()+" u bazi!\n");
        }
        return odo;
    }
    
    public List<DomenskiObjekat> vratiBezUslova(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.getImeTabele();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.ucitajListu(rs);
    }
    
    public List<DomenskiObjekat> vratiDveTabele(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+odo.getImeTabele()+ " JOIN "
                +odo.vratiJoinTabelu()+ " ON "+odo.vratiUslovZaJoin();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }
    
     public List<DomenskiObjekat> vratiTriTabele(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+odo.getImeTabele()+ " JOIN "
                +odo.vratiJoinTabelu()+ " ON "+odo.vratiUslovZaJoin()+" JOIN "
                +odo.vratiJoinTabelu2()+ " ON "+odo.vratiUslovZaJoin2();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }
    
     public List<DomenskiObjekat> vratiCetiriTabele(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM "+odo.getImeTabele()+ " JOIN "
                +odo.vratiJoinTabelu()+ " ON "+odo.vratiUslovZaJoin()+" JOIN "
                +odo.vratiJoinTabelu2()+ " ON "+odo.vratiUslovZaJoin2()+" JOIN "+odo.vratiJoinTabelu3()+" ON "+odo.vratiUslovZaJoin3();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void ubaciSlozenSlucaj(DomenskiObjekat odo, Map<String, Object> podaci) throws Exception {
        try {
            String upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
            System.out.println(upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            
            if(odo.isAutoincrement()) {
                ResultSet rs=statement.getGeneratedKeys();
                if(rs.next()){
                    odo.setObjekatID(rs.getLong(1));
                }
            }           
            ArrayList<DomenskiObjekat> lista1 = (ArrayList<DomenskiObjekat>) podaci.get("rezira");
            for (DomenskiObjekat domenskiObjekat : lista1) {
                odo = domenskiObjekat;
                upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
                System.out.println(upit);
                statement = konekcija.createStatement();
                statement.executeUpdate(upit);
                if(odo.isAutoincrement()) {
                ResultSet rs=statement.getGeneratedKeys();
                    if(rs.next()){
                        odo.setObjekatID(rs.getLong(1));
                    }
                }     
            }
            ArrayList<DomenskiObjekat> lista2 = (ArrayList<DomenskiObjekat>) podaci.get("glumi");
            for (DomenskiObjekat domenskiObjekat : lista2) {
                odo = domenskiObjekat;
                upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
                System.out.println(upit);
                statement = konekcija.createStatement();
                statement.executeUpdate(upit);
                if(odo.isAutoincrement()) {
                ResultSet rs=statement.getGeneratedKeys();
                    if(rs.next()){
                        odo.setObjekatID(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja "+odo.getImeTabele()+" u bazi!\n");
        }
    }
    
    public void obrisi(DomenskiObjekat odo) throws Exception {
        try {
            String upit = "DELETE FROM " + odo.getImeTabele() + " WHERE " + odo.vratiUslovZaBrisanje();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom brisanja projekcije u bazi");
        }
    }

    public void izmeniSlozenSlucaj(DomenskiObjekat odo, Map<String, Object> podaci) throws Exception {
        try {
            Film film = (Film) odo;
            String upit = "UPDATE "+odo.getImeTabele()+" SET "+odo.vratiVrednostiZaOperacijuUpdate()+" WHERE "+odo.vratiUslovZaOperacijuUpdate();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            
            ArrayList<DomenskiObjekat> lista1 = (ArrayList<DomenskiObjekat>) podaci.get("reditelji");
            for (DomenskiObjekat domenskiObjekat : lista1) {
                boolean status = false;
                Reditelj r = (Reditelj) domenskiObjekat;
                odo = new Rezira(film, r);
                if(r.getStatus() != null && r.getStatus().equals("dodaj")) {
                    upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
                    status = true;
                }
                if(r.getStatus() != null && r.getStatus().equals("obrisi")) {
                    upit = "DELETE FROM " + odo.getImeTabele() + " WHERE " + odo.vratiUslovZaBrisanje();
                    status = true;
                }
                if(status) {
                    System.out.println(upit);
                    s = konekcija.createStatement();
                    s.executeUpdate(upit);
                }
            }
            ArrayList<DomenskiObjekat> lista2 = (ArrayList<DomenskiObjekat>) podaci.get("glumci");
            for (DomenskiObjekat domenskiObjekat : lista2) {
                boolean status = false;
                Glumac g = (Glumac) domenskiObjekat;
                odo = new Glumi(film, g);
                if(g.getStatus() != null && g.getStatus().equals("dodaj")) {
                    upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
                    status = true;
                } 
                if(g.getStatus() != null && g.getStatus().equals("obrisi")) {
                    upit = "DELETE FROM " + odo.getImeTabele() + " WHERE " + odo.vratiUslovZaBrisanje();
                    status = true;
                }
                if(status) {
                    System.out.println(upit);
                    s = konekcija.createStatement();
                    s.executeUpdate(upit);  
                }
            }
            s.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom izmene "+odo.getImeTabele()+" u bazi!\n");
        }
    }

    public DomenskiObjekat vratiSaUslovom(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.getImeTabele() + " WHERE " + odo.vratiUslovZaCitanje() + " LIMIT 1";
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.ucitajDomenskiObjekat(rs);
    }
    
    public List<DomenskiObjekat> vratiListuSaUslovom(DomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.getImeTabele() + " WHERE " + odo.vratiUslovZaCitanjeListe();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.ucitajListu(rs);
    }
    
    public DomenskiObjekat ubaciSaIzmenom(DomenskiObjekat odo) throws Exception {
        try {
            String upit = "insert into "+odo.getImeTabele()+" ("+odo.getImenaAtributaZaUbacivanje()+") values ("+odo.getVrednostiAtributaZaUbacivanje()+")";
            System.out.println(upit);
            Statement statement = konekcija.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            
            if(odo.isAutoincrement()) {
                ResultSet rs=statement.getGeneratedKeys();
                if(rs.next()){
                    odo.setObjekatID(rs.getLong(1));
                }
            }
            
            upit = "UPDATE "+odo.getImePovezaneTabele()+" SET "+odo.vratiVrednostiZaOperacijuUpdatePovezaneTabele()+" WHERE "+odo.vratiUslovZaOperacijuUpdatePovezaneTabele();
            System.out.println(upit);
            statement = konekcija.createStatement();
            statement.executeUpdate(upit);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage()+"Greska prilikom kreiranja "+odo.getImeTabele()+" u bazi!\n");
        }
        return odo;
    }
}
