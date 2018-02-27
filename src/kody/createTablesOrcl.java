package kody;

/**
 *
 * @author Duckyta
 */
public class createTablesOrcl {

    public static String createTableZakaznik = "CREATE TABLE testZakaznik"
            + "(idZakaznik number(10) NOT NULL,"
            + "jmeno varchar2(50) NOT NULL,"
            + "prijmeni varchar2(50) NOT NULL,"
            + "telefon varchar2(15) NOT NULL,"
            + "PRIMARY KEY (idZakaznik))";

    public static String createTableZakaznikINMEM = "CREATE TABLE testZakaznik"
            + "(idZakaznik number(10) NOT NULL,"
            + "jmeno varchar2(50) NOT NULL,"
            + "prijmeni varchar2(50) NOT NULL,"
            + "telefon varchar2(15) NOT NULL,"
            + "PRIMARY KEY (idZakaznik)) INMEMORY";

    public static String createTableDruhZbozi = "CREATE TABLE testDruhZbozi"
            + "(idKategorie number (10) NOT NULL,"
            + "nazev varchar2(50) NOT NULL,"
            + "PRIMARY KEY (idKategorie))";

    public static String createTableDruhZboziINMEM = "CREATE TABLE testDruhZbozi"
            + "(idKategorie number (10) NOT NULL,"
            + "nazev varchar2(50) NOT NULL,"
            + "PRIMARY KEY (idKategorie)) INMEMORY";

    public static String createTableSklad = "CREATE TABLE testSklad"
            + "(idSklad number(10) NOT NULL,"
            + "nazev varchar2(50) NOT NULL,"
            + "PRIMARY KEY (idSklad))";

    public static String createTableSkladINMEM = "CREATE TABLE testSklad"
            + "(idSklad number(10) NOT NULL,"
            + "nazev varchar2(50) NOT NULL,"
            + "PRIMARY KEY (idSklad)) INMEMORY";

    public static String createTableAdresa = "CREATE TABLE testAdresa"
            + "(idAdresa number(10) NOT NULL,"
            + "idZakaznik number(10) NOT NULL,"
            + "ulice varchar2(50) NOT NULL,"
            + "cpop number(10) NOT NULL,"
            + "mesto varchar2(50) NOT NULL,"
            + "psc number(5) NOT NULL,"
            + "PRIMARY KEY (idAdresa),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik(idZakaznik))";

    public static String createTableAdresaINMEM = "CREATE TABLE testAdresa"
            + "(idAdresa number(10) NOT NULL,"
            + "idZakaznik number(10) NOT NULL,"
            + "ulice varchar2(50) NOT NULL,"
            + "cpop number(10) NOT NULL,"
            + "mesto varchar2(50) NOT NULL,"
            + "psc number(5) NOT NULL,"
            + "PRIMARY KEY (idAdresa),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik(idZakaznik)) INMEMORY";

    public static String createTableObjednavka = "CREATE TABLE testObjednavka"
            + "(idObjednavka number(10) NOT NULL,"
            + "idZakaznik number(10) NOT NULL,"
            + "datumObjednavky date,"
            + "stavObjednavky number (1) NOT NULL,"
            + "PRIMARY KEY (idObjednavka),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik (idZakaznik))";

    public static String createTableObjednavkaINMEM = "CREATE TABLE testObjednavka"
            + "(idObjednavka number(10) NOT NULL,"
            + "idZakaznik number(10) NOT NULL,"
            + "datumObjednavky date,"
            + "stavObjednavky number (1) NOT NULL,"
            + "PRIMARY KEY (idObjednavka),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik (idZakaznik)) INMEMORY";

    public static String createTableProdukt = "CREATE TABLE testProdukt"
            + "(idProdukt number(10) NOT NULL,"
            + "idKategorie number(10) NOT NULL,"
            + "nazevProdukt varchar2(50) NOT NULL,"
            + "cenaKS number(6,2) NOT NULL,"
            + "popis varchar2(200),"
            + "PRIMARY KEY (idProdukt),"
            + "FOREIGN KEY (idKategorie) REFERENCES testDruhZbozi (idKategorie))";

    public static String createTableProduktINMEM = "CREATE TABLE testProdukt"
            + "(idProdukt number(10) NOT NULL,"
            + "idKategorie number(10) NOT NULL,"
            + "nazevProdukt varchar2(50) NOT NULL,"
            + "cenaKS number(6,2) NOT NULL,"
            + "popis varchar2(200),"
            + "PRIMARY KEY (idProdukt),"
            + "FOREIGN KEY (idKategorie) REFERENCES testDruhZbozi (idKategorie)) INMEMORY";

    public static String createTablePolozkaObjednavka = "CREATE TABLE testPolozkaObjednavka"
            + "(idSloupec number(10) NOT NULL,"
            + "idObjednavka number(10) NOT NULL,"
            + "idProdukt number(10) NOT NULL,"
            + "pocetKs number(10) NOT NULL,"
            + "PRIMARY KEY(idSloupec),"
            + "FOREIGN KEY (idObjednavka) REFERENCES testObjednavka (idObjednavka),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt (idProdukt))";

    public static String createTablePolozkaObjednavkaINMEM = "CREATE TABLE testPolozkaObjednavka"
            + "(idSloupec number(10) NOT NULL,"
            + "idObjednavka number(10) NOT NULL,"
            + "idProdukt number(10) NOT NULL,"
            + "pocetKs number(10) NOT NULL,"
            + "FOREIGN KEY (idObjednavka) REFERENCES testObjednavka (idObjednavka),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt (idProdukt)) INMEMORY";

    public static String createTableZasoby = "CREATE TABLE testZasoby"
            + "(idSloupec number(10) NOT NULL,"
            + "idSklad number(10) NOT NULL,"
            + "idProdukt number(10) NOT NULL,"
            + "mnozstvi number(10) NOT NULL,"
            + "PRIMARY KEY(idSloupec),"
            + "FOREIGN KEY (idSklad) REFERENCES testSklad (idSklad),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt(idProdukt))";

    public static String createTableZasobyINMEM = "CREATE TABLE testZasoby"
            + "(idSloupec number(10) NOT NULL,"
            + "idSklad number(10) NOT NULL,"
            + "idProdukt number(10) NOT NULL,"
            + "mnozstvi number(10) NOT NULL,"
            + "PRIMARY KEY (idSloupec),"
            + "FOREIGN KEY (idSklad) REFERENCES testSklad (idSklad),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt(idProdukt)) INMEMORY";

    public static String dropTableZasoby = "drop table testZasoby";
    public static String dropTableSklad = "drop table testSklad";
    public static String dropTablePolozka = "drop table testPolozkaObjednavka";
    public static String dropTableProdukt = "drop table testProdukt";
    public static String dropTableDruhZbozi = "drop table testDruhZbozi";
    public static String dropTableAdresa = "drop table testAdresa";
    public static String dropTableObjednavka = "drop table testObjednavka";
    public static String dropTableZakaznik = "DROP TABLE testZakaznik";

}
