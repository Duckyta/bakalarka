package kody;

import aplikace.HlavniOkno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Duckyta
 */

//adresy/zakaznici - 1500, sklad/kategorie 10, produkty/zasoby 2000, 
public class naplneniDaty {

    public static void napln(Connection conn) throws FileNotFoundException, IOException, SQLException {
        HlavniOkno h1 = new HlavniOkno();
        Stopky stopwatch1 = new Stopky();
        Stopky stopwatch2 = new Stopky();
        Stopky stopwatch3 = new Stopky();
        Stopky stopwatch4 = new Stopky();
        Stopky stopwatch5 = new Stopky();
        Stopky stopwatch6 = new Stopky();
        
        File file = new File("dataDB/zakaznici.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch1.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch1.stop();
        }

        file = new File("dataDB/kategorie.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch2.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch2.stop();
        }

        file = new File("dataDB/sklad.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch3.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch3.stop();
        }

        file = new File("dataDB/adresy.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch4.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch4.stop();
        }

        file = new File("dataDB/produkty.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch5.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch5.stop();
        }

        file = new File("dataDB/zasoby.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Statement stmt = null;
            stopwatch6.start();
            while ((line = br.readLine()) != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(line);
                stmt.close();
            }
            stopwatch6.stop();
            
        }
        HlavniOkno.nacteniDatDoDb.vypocitejCas(stopwatch1.ubehlyCas() + stopwatch2.ubehlyCas() + stopwatch3.ubehlyCas()
        + stopwatch4.ubehlyCas() + stopwatch5.ubehlyCas() + stopwatch6.ubehlyCas());
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter("vysledkyImport.txt"));
        Float v = stopwatch1.ubehlyCas() + stopwatch2.ubehlyCas() + stopwatch3.ubehlyCas()
        + stopwatch4.ubehlyCas() + stopwatch5.ubehlyCas() + stopwatch6.ubehlyCas();
        String vysledek = "Probehly import trval " + Float.toString(v) + " s.";
        writer.write(vysledek);
        writer.close();
        JOptionPane.showMessageDialog(h1, "Naplnění daty proběhlo v pořádku.", "Naplnění daty", 1);
    }

}
