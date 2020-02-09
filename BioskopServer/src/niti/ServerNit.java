/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Bron Zilar
 */
public class ServerNit extends Thread {
    
    private ServerSocket serverSocket;
    List<ObradaKlijentskogZahtevaNit> klijenti;

    public ServerNit() throws IOException {
        FileInputStream in=new FileInputStream("db.properties");
        Properties props=new Properties();
        props.load(in);
        String serverSoc = props.getProperty("serverSocket");
        int ss = Integer.parseInt(serverSoc);
        serverSocket = new ServerSocket(ss);
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        while(!serverSocket.isClosed()) {
            System.out.println("Cekanje...");
            try {
                Socket socket=serverSocket.accept();
                System.out.println("Klijent se povezao");
                ObradaKlijentskogZahtevaNit klijent=new ObradaKlijentskogZahtevaNit(socket);
                klijent.start();
                klijenti.add(klijent);
            } catch (IOException ex) {
                //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Server je zaustavljen");
            }
        }
        zaustaviObraduKlijentskogZahteva();
    }

    private void zaustaviObraduKlijentskogZahteva() {
        for (ObradaKlijentskogZahtevaNit klijent : klijenti) {
             try {
                klijent.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void zaustaviServerskuNit() throws IOException{
        serverSocket.close();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
