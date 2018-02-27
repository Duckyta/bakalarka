package kody;

import aplikace.HlavniOkno;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Duckyta
 */
public class createTablesOstatni {

    static HlavniOkno h1 = new HlavniOkno();

    public static String createTableZakaznik = "CREATE TABLE testZakaznik"
            + "(idZakaznik numeric(10) NOT NULL,"
            + "jmeno varchar(50) NOT NULL,"
            + "prijmeni varchar(50) NOT NULL,"
            + "telefon varchar(15) NOT NULL,"
            + "PRIMARY KEY (idZakaznik))";

    public static String createTableDruhZbozi = "CREATE TABLE testDruhZbozi"
            + "(idKategorie numeric (10) NOT NULL,"
            + "nazev varchar(50) NOT NULL,"
            + "PRIMARY KEY (idKategorie))";

    public static String createTableSklad = "CREATE TABLE testSklad"
            + "(idSklad numeric(10) NOT NULL,"
            + "nazev varchar(50) NOT NULL,"
            + "PRIMARY KEY (idSklad))";

    public static String createTableAdresa = "CREATE TABLE testAdresa"
            + "(idAdresa numeric(10) NOT NULL,"
            + "idZakaznik numeric(10) NOT NULL,"
            + "ulice varchar(50) NOT NULL,"
            + "cpop numeric(10) NOT NULL,"
            + "mesto varchar(50) NOT NULL,"
            + "psc numeric(5) NOT NULL,"
            + "PRIMARY KEY (idAdresa),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik(idZakaznik))";

    public static String createTableObjednavka = "CREATE TABLE testObjednavka"
            + "(idObjednavka numeric(10) NOT NULL,"
            + "idZakaznik numeric(10) NOT NULL,"
            + "datumObjednavky date,"
            + "stavObjednavky numeric(1) NOT NULL,"
            + "PRIMARY KEY (idObjednavka),"
            + "FOREIGN KEY (idZakaznik) REFERENCES testZakaznik (idZakaznik))";

    public static String createTableProdukt = "CREATE TABLE testProdukt"
            + "(idProdukt numeric(10) NOT NULL,"
            + "idKategorie numeric(10) NOT NULL,"
            + "nazevProdukt varchar(50) NOT NULL,"
            + "cenaKS numeric(6,2) NOT NULL,"
            + "popis varchar(200),"
            + "PRIMARY KEY (idProdukt),"
            + "FOREIGN KEY (idKategorie) REFERENCES testDruhZbozi (idKategorie))";

    public static String createTablePolozkaObjednavka = "CREATE TABLE testPolozkaObjednavka"
            + "(idSloupec numeric (10) NOT NULL,"
            + "idObjednavka numeric(10) NOT NULL,"
            + "idProdukt numeric(10) NOT NULL,"
            + "pocetKs numeric(10) NOT NULL,"
            + "PRIMARY KEY (idSloupec),"
            + "FOREIGN KEY (idObjednavka) REFERENCES testObjednavka (idObjednavka),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt (idProdukt))";

    public static String createTableZasoby = "CREATE TABLE testZasoby"
            + "(idSloupec numeric (10) NOT NULL,"
            + "idSklad numeric(10) NOT NULL,"
            + "idProdukt numeric(10) NOT NULL,"
            + "mnozstvi numeric(10) NOT NULL,"
            + "PRIMARY KEY (idSloupec),"
            + "FOREIGN KEY (idSklad) REFERENCES testSklad (idSklad),"
            + "FOREIGN KEY (idProdukt) REFERENCES testProdukt(idProdukt))";

    public static String createTableZakaznikInMem = "CREATE TABLE testZakaznik"
            + "(idZakaznik numeric(10) NOT NULL CONSTRAINT pk_zakaznik PRIMARY KEY NONCLUSTERED,"
            + "jmeno varchar(50) NOT NULL,"
            + "prijmeni varchar(50) NOT NULL,"
            + "telefon varchar(15) NOT NULL"
            + ")"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTableDruhZboziInMem = "CREATE TABLE testDruhZbozi"
            + "(idKategorie numeric (10) NOT NULL CONSTRAINT pk_druhZbozi PRIMARY KEY NONCLUSTERED,"
            + "nazev varchar(50) NOT NULL)"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTableSkladInMem = "CREATE TABLE testSklad"
            + "(idSklad numeric(10) NOT NULL CONSTRAINT pk_sklad PRIMARY KEY NONCLUSTERED,"
            + "nazev varchar(50) NOT NULL"
            + ")"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTableAdresaInMem = "CREATE TABLE testAdresa"
            + "(idAdresa numeric(10) NOT NULL CONSTRAINT pk_adresa PRIMARY KEY NONCLUSTERED,"
            + "idZakaznik numeric(10) NOT NULL CONSTRAINT fk_adresa FOREIGN KEY REFERENCES testZakaznik(idZakaznik),"
            + "ulice varchar(50) NOT NULL,"
            + "cpop numeric(10) NOT NULL,"
            + "mesto varchar(50) NOT NULL,"
            + "psc numeric(5) NOT NULL)"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTableObjednavkaInMem = "CREATE TABLE testObjednavka"
            + "(idObjednavka numeric(10) NOT NULL CONSTRAINT pk_objednavka PRIMARY KEY NONCLUSTERED,"
            + "idZakaznik numeric(10) NOT NULL CONSTRAINT fk_objednavka FOREIGN KEY REFERENCES testZakaznik(idZakaznik),"
            + "datumObjednavky date,"
            + "stavObjednavky numeric(1) NOT NULL"
            + ")"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTableProduktInMem = "CREATE TABLE testProdukt"
            + "(idProdukt numeric(10) NOT NULL CONSTRAINT pk_produkt PRIMARY KEY NONCLUSTERED,"
            + "idKategorie numeric(10) NOT NULL CONSTRAINT fk_produkt FOREIGN KEY REFERENCES testDruhZbozi(idKategorie),"
            + "nazevProdukt varchar(50) NOT NULL,"
            + "cenaKS numeric(6,2) NOT NULL,"
            + "popis varchar(200)"
            + ")"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_AND_DATA)";

    public static String createTablePolozkaObjednavkaInMem = "CREATE TABLE testPolozkaObjednavka"
            + "(idTabulka numeric(10) NOT NULL CONSTRAINT pk_polobj PRIMARY KEY NONCLUSTERED,"
            + "idObjednavka numeric(10) NOT NULL CONSTRAINT fk_polozka REFERENCES testObjednavka(idObjednavka),"
            + "idProdukt numeric(10) NOT NULL CONSTRAINT fk_polozka1 REFERENCES testProdukt(idProdukt),"
            + "pocetKs numeric(10) NOT NULL)"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_ONLY)";

    public static String createTableZasobyInMem = "CREATE TABLE testZasoby"
            + "(idTabulka numeric(10) NOT NULL CONSTRAINT pk_zas PRIMARY KEY NONCLUSTERED,"
            + "idSklad numeric(10) NOT NULL CONSTRAINT fk_zasoby REFERENCES testSklad(idSklad),"
            + "idProdukt numeric(10) NOT NULL CONSTRAINT fk_zasoby2 REFERENCES testProdukt(idProdukt),"
            + "mnozstvi numeric(10) NOT NULL"
            + ")"
            + "WITH (MEMORY_OPTIMIZED = ON, DURABILITY = SCHEMA_ONLY)";

    public static String createDatabase = "CREATE DATABASE testovaciProstredi";

    public static String addFilegroupStep1 = "ALTER DATABASE testovaciProstredi ADD FILEGROUP testovaciProstredi_mod CONTAINS MEMORY_OPTIMIZED_DATA";

    public static String addFilegroupStep2 = "ALTER DATABASE testovaciProstredi "
            + "ADD FILE (name='testovaciProstredi_mod1', filename='c:\\testovaciProstredi_mod1') TO FILEGROUP testovaciProstredi_mod";

    public static String useDatabaze = "USE testovaciProstredi";

    public static String dropDatabase = "DROP DATABASE testovaciprostredi";

    public static String anotherDatabase = "USE master";

    public static String anotherDatabaseMySQL = "USE sys";


}
