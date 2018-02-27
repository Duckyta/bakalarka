package kody;

import aplikace.HlavniOkno;
import aplikace.Prihlaseni;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static kody.metodyOrcl.h1;

/**
 *
 * @author Duckyta
 */
public class HlavniTest extends Thread {

    public String hlaska;
    double blocks;
    Prihlaseni pr = new Prihlaseni();
    HlavniOkno h1 = new HlavniOkno();

    public HlavniTest(double blocks) {
        this.blocks = blocks;
    }

    public void runTest(Connection con) throws SQLException, IOException {
        JOptionPane.showMessageDialog(h1, "Test je úspěšně spuštěn. Vyčkejte na dialogové okno oznamující jeho ukončení.", "Test", 1);
        Spojeni conn1 = new Spojeni(con);
        Random generator = new Random();
        Stopky stopwatchV = new Stopky();
        stopwatchV.start();
        Stopky stopwatchQ = new Stopky();

        // % * pocet kroku v 1 bloku
        int[] rozlozeni = new int[7];
        rozlozeni[0] = 15 * 5; //1 Objednavka
        rozlozeni[1] = 30 * 1; //2 Vypis zbozi 
        rozlozeni[2] = 10 * 1; //3 Nejobsazenejsi sklad
        rozlozeni[3] = 30 * 1; //4 Razeni zbozi
        rozlozeni[4] = 1 * 1; //5 Vypocet trzeb
        rozlozeni[5] = 1 * 1; //6 Prumerna cena objednavky
        rozlozeni[6] = 8 * 1; //7 Vypis zakazniku

        //prepocitani poctu dotazu pro bloky s vice nez jednim dotazem
        blocks = Math.round(blocks + ((rozlozeni[0] / 5d * 4) / 100d * blocks));
        int suma = 0;
        for (int j = 0; j < rozlozeni.length; j++) {
            suma = suma + rozlozeni[j];
        }
        //prideleni maximalnich poctu opakovani pro jednotlive dotazy
        long[] counter = new long[rozlozeni.length];
        for (int j = 0; j < rozlozeni.length; j++) {
            counter[j] = Math.round((double) rozlozeni[j] / suma * blocks);
        }
        //promnene pro cykleni 7 kroku objednavky
        int id_user = 0;
        int id_objednavky = 1;
        int step = 0;
        int id = 1;
        Set s2 = new HashSet();

        for (int i = 1; i < blocks; ++i) {
            // nahodny vyber dotazu podle zadanych %
            int rand = generator.nextInt(1000);
            int selector = 0;
            double x = 0;
            for (int j = 0; j < rozlozeni.length; j++) {
                x = x + ((double) rozlozeni[j] / suma * 1000);
                if (counter[j] > 0) {
                    selector = j + 1;
                }
                if (x >= rand && counter[j] > 0) {
                    selector = j + 1;
                    break;
                }
            }
            if (selector > 0) {
                --counter[selector - 1];
            }
            //---------test
            switch (selector) {
                //objednavka
                case 1:
                    switch (step) {
                        case 0: {
                            //vytvoreni objednavky
                            int polozkyVkosiku = generator.nextInt(5) + 1;
                            id_user = generator.nextInt(1500) + 1;
                            Set s = new HashSet();
                            for (int j = 0; j < polozkyVkosiku; ++j) {
                                s.add(generator.nextInt(2000) + 1);
                            }
                            s2 = s;
                            stopwatchQ.start();
                            conn1.execute("INSERT INTO testobjednavka (idObjednavka, idZakaznik, stavObjednavky)"
                                    + " VALUES('" + id_objednavky + "','" + id_user + "','0')");
                            Iterator it = s.iterator();
                            while (it.hasNext()) {
                                conn1.execute("INSERT INTO testpolozkaobjednavka VALUES"
                                        + "('" + id + "','" + id_objednavky + "','" + it.next()
                                        + "','" + (generator.nextInt(10) + 1) + "')");
                                id++;
                            }

                            stopwatchQ.stop();
                            System.out.println("blok1step1 : " + stopwatchQ);
                            HlavniOkno.casObednavkaVytvor.vypocitejCas(stopwatchQ.ubehlyCas());
                            step = 1;
                            break;
                        }
                        case 1: {
                            // odecteni zbozi sklad
                            Iterator it = s2.iterator();
                            stopwatchQ.start();
                            while (it.hasNext()) {
                                try {
                                    conn1.execute("UPDATE testZasoby SET mnozstvi = (mnozstvi - " + (generator.nextInt(10) + 1) + ") WHERE idProdukt = '" + it.next() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            stopwatchQ.stop();
                            System.out.println("blok1step2 : " + stopwatchQ);
                            aplikace.HlavniOkno.casOdepsaniSkladu.vypocitejCas(stopwatchQ.ubehlyCas());
                            step = 2;
                            break;
                        }
                        case 2:
                            stopwatchQ.start();
                             {
                                try {
                                    conn1.execute("UPDATE testObjednavka SET stavObjednavky = '1' WHERE idObjednavka = '" + id_objednavky + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            stopwatchQ.stop();
                            System.out.println("blok1step3 : " + stopwatchQ);
                            aplikace.HlavniOkno.casExpeduj.vypocitejCas(stopwatchQ.ubehlyCas());
                            step = 3;
                            break;
                        case 3:
                            stopwatchQ.start();
                             {
                                try {
                                    conn1.select("SELECT obj.idObjednavka, pol.idProdukt, pol.pocetks, prod.cenaKS, adr.ulice, adr.mesto, adr.psc,"
                                            + "zak.jmeno, zak.prijmeni FROM testobjednavka obj"
                                            + " JOIN testpolozkaObjednavka pol ON obj.idObjednavka = pol.idObjednavka "
                                            + "JOIN testzakaznik zak ON obj.idZakaznik = zak.idZakaznik "
                                            + "JOIN testadresa adr ON zak.idZakaznik = adr.idZakaznik "
                                            + "JOIN testprodukt prod ON pol.idProdukt = prod.idProdukt "
                                            + "WHERE obj.idZakaznik = '" + id_user + "' AND obj.STAVOBJEDNAVKY = '1'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            stopwatchQ.stop();
                            System.out.println("blok1step4 : " + stopwatchQ);
                            aplikace.HlavniOkno.casFaktura.vypocitejCas(stopwatchQ.ubehlyCas());
                            step = 0;
                            id_user = 0;
                            id_objednavky++;
                            break;
                    }
                    break;
                //vypiszbozi
                case 2:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("SELECT prod.idProdukt, prod.nazevProdukt, prod.cenaKs, zas.idSklad, zas.Mnozstvi, dr.Nazev from testProdukt prod "
                                    + "join testzasoby zas on prod.IDPRODUKT = zas.IDPRODUKT "
                                    + "join testdruhZbozi dr on prod.IDKATEGORIE = dr.IDKATEGORIE");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok2 : " + stopwatchQ);
                    aplikace.HlavniOkno.casVypisZbozi.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
                //skladTop
                case 3:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("SELECT sk.idSklad, sk.nazev FROM testsklad sk "
                                    + "join testzasoby zas on sk.IDSKLAD = zas.idSklad "
                                    + "where zas.mnozstvi = (select MAX(mnozstvi) from testzasoby)");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok3 : " + stopwatchQ);
                    aplikace.HlavniOkno.casTopSklad.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
                //razeniZbozi
                case 4:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("SELECT prod.idProdukt, prod.nazevProdukt, prod.cenaKs, zas.idSklad, zas.Mnozstvi, dr.Nazev from testProdukt prod "
                                    + "join testzasoby zas on prod.IDPRODUKT = zas.IDPRODUKT "
                                    + "join testdruhZbozi dr on prod.IDKATEGORIE = dr.IDKATEGORIE "
                                    + "order by prod.nazevProdukt ASC");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok4 : " + stopwatchQ);
                    aplikace.HlavniOkno.casRazeniZbozi.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
                //vypocetTrzeb
                case 5:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("select SUM(polObj.pocetKs * prod.cenaKS) AS VYDELEK "
                                    + "from testpolozkaObjednavka polObj "
                                    + "join testprodukt prod on prod.idProdukt = polObj.idProdukt "
                                    + "join testobjednavka obj on polObj.idObjednavka = obj.idObjednavka "
                                    + "where obj.stavObjednavky = 1");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok5 : " + stopwatchQ);
                    aplikace.HlavniOkno.casSumTrzba.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
                //prumerCena
                case 6:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("select AVG(polObj.pocetKs * prod.cenaKS)"
                                    + " AS PRUMER from testpolozkaObjednavka polObj "
                                    + "join testprodukt prod on prod.idProdukt = polObj.idProdukt "
                                    + "join testobjednavka obj on polObj.idObjednavka = obj.idObjednavka "
                                    + "where polObj.idObjednavka = obj.idObjednavka");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok6 : " + stopwatchQ);
                    aplikace.HlavniOkno.casAvgObj.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
                //prehledZakaznici
                case 7:
                    stopwatchQ.start();
                     {
                        try {
                            conn1.select("select zak.jmeno, zak.prijmeni,"
                                    + " adr.ulice, adr.cpop, adr.psc, adr.mesto from testadresa adr "
                                    + "join testzakaznik zak on zak.idZakaznik = adr.IDZAKAZNIK "
                                    + "order by zak.jmeno ASC");
                        } catch (SQLException ex) {
                            Logger.getLogger(HlavniTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    stopwatchQ.stop();
                    System.out.println("blok7 : " + stopwatchQ);
                    aplikace.HlavniOkno.casInfoZak.vypocitejCas(stopwatchQ.ubehlyCas());
                    break;
            }
        }
        stopwatchV.stop();
        hlaska = "Test hotovo. " + stopwatchV.toString();
        JOptionPane.showMessageDialog(h1, hlaska, "Stav testu", 1);
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter("vysledkyTestu.txt"));
        int celkem_dotazu = h1.selectCount.getPocetDotazu() + h1.executeCount.getPocetDotazu();
        float dotazSekunda = celkem_dotazu / stopwatchV.ubehlyCas();
        String vysledek = "Probehly test trval " + Float.toString(stopwatchV.ubehlyCas()) + " s.";
        String vysledek1 = "Celkovy pocet dotazu: " + Integer.toString(celkem_dotazu) + ", Prumer dotaz/s: " + Float.toString(dotazSekunda);
        writer.write(vysledek);
        writer.newLine();
        writer.write(vysledek1);
        writer.newLine();
        String vyslVytvorObj = "Blok 1 - vytvareni objednavky: " + h1.casObednavkaVytvor;
        String vyslOdepis = "Blok 1 - odepsani skladu: " + h1.casOdepsaniSkladu;
        String vyslExpeduj = "Blok 1 - expedice objednavky: " + h1.casExpeduj;
        String vyslFaktura = "Blok 1 - faktura: " + h1.casFaktura;
        writer.write(vyslVytvorObj);
        writer.newLine();
        writer.write(vyslOdepis);
        writer.newLine();
        writer.write(vyslExpeduj);
        writer.newLine();
        writer.write(vyslFaktura);
        writer.newLine();
        String vyslVypis = "Blok 2 - vypis zbozi: " + h1.casVypisZbozi;
        String vyslTop = "Blok 3 - nejobsazenejsi sklad: " + h1.casTopSklad;
        String vyslRazeni = "Blok 4 - razeny vypis:" + h1.casRazeniZbozi;
        String vyslSum = "Blok 5 - soucet trzeb: " + h1.casSumTrzba;
        String vyslAvg = "Blok 6 - prumerna cena objednavky: " + h1.casAvgObj;
        String vyslInfor = "Blok 7 - informace o zakaznicich: " + h1.casInfoZak;
        writer.write(vyslVypis);
        writer.newLine();
        writer.write(vyslTop);
        writer.newLine();
        writer.write(vyslRazeni);
        writer.newLine();
        writer.write(vyslSum);
        writer.newLine();
        writer.write(vyslAvg);
        writer.newLine();
        writer.write(vyslInfor);
        writer.newLine();
        writer.close();
    }

}
