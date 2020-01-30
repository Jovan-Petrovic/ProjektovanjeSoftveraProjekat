/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.DomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
}
