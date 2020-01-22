/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    
    
}
