package kody;

import aplikace.HlavniOkno;
import aplikace.Prihlaseni;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static kody.metodyOrcl.h1;

/**
 *
 * @author Duckyta
 */
public class metodyOstatni {

    Prihlaseni pr = new Prihlaseni();
    static HlavniOkno h1 = new HlavniOkno();

    public static void vytvorTabulkyMySQL(Connection conn) {

        try {
            Statement stmt1 = null, stmt2 = null, stmt3 = null,
                    stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null,
                    stmt9 = null, stmt10 = null;
            stmt9 = conn.createStatement();
            stmt9.executeUpdate(kody.createTablesOstatni.createDatabase);
            stmt10 = conn.createStatement();
            stmt10.executeUpdate(kody.createTablesOstatni.useDatabaze);
            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOstatni.createTableZakaznik);
            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.createTableDruhZbozi);
            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOstatni.createTableSklad);
            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOstatni.createTableAdresa);
            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOstatni.createTableObjednavka);
            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOstatni.createTableProdukt);
            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOstatni.createTablePolozkaObjednavka);
            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOstatni.createTableZasoby);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vytvořeno.");
            if (stmt9 != null) {
                stmt9.close();
            }   if (stmt10 != null) {
                stmt10.close();
            }   if (stmt1 != null) {
                stmt1.close();
            }   if (stmt2 != null) {
                stmt2.close();
            }   if (stmt3 != null) {
                stmt3.close();
            }   if (stmt4 != null) {
                stmt4.close();
            }   if (stmt5 != null) {
                stmt5.close();
            }   if (stmt6 != null) {
                stmt6.close();
            }   if (stmt7 != null) {
                stmt7.close();
            }   if (stmt8 != null) {
                stmt8.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 1);
        }
    }

    public static void vytvorTabulkyMicrosoftSQL(Connection conn) {

        try {
            Statement stmt1 = null, stmt2 = null, stmt3 = null,
                    stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null,
                    stmt9 = null, stmt10 = null;
            Statement ste = null;
            ste = conn.createStatement();
            ste.execute("SET TRANSACTION ISOLATION LEVEL READ COMMITTED");
            stmt9 = conn.createStatement();
            stmt9.executeUpdate(kody.createTablesOstatni.createDatabase);
            stmt10 = conn.createStatement();
            stmt10.executeUpdate(kody.createTablesOstatni.useDatabaze);
            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOstatni.createTableZakaznik);
            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.createTableDruhZbozi);
            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOstatni.createTableSklad);
            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOstatni.createTableAdresa);
            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOstatni.createTableObjednavka);
            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOstatni.createTableProdukt);
            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOstatni.createTablePolozkaObjednavka);
            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOstatni.createTableZasoby);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vytvořeno.");
            if (stmt9 != null) {
                stmt9.close();
            }   if (stmt10 != null) {
                stmt10.close();
            }   if (stmt1 != null) {
                stmt1.close();
            }   if (stmt2 != null) {
                stmt2.close();
            }   if (stmt3 != null) {
                stmt3.close();
            }   if (stmt4 != null) {
                stmt4.close();
            }   if (stmt5 != null) {
                stmt5.close();
            }   if (stmt6 != null) {
                stmt6.close();
            }   if (stmt7 != null) {
                stmt7.close();
            }   if (stmt8 != null) {
                stmt8.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 1);
        }
    }

    public static void vytvorDatabazi(Connection conn) throws SQLException {
        Statement st1 = null;
        st1 = conn.createStatement();
        st1.executeUpdate(kody.createTablesOstatni.createDatabase);

        if (st1 != null) {
            st1.close();
        }
    }

    public static void vytvorTabulkyPostgre(Connection conn) {

        try {
            Statement stmt1 = null, stmt2 = null, stmt3 = null,
                    stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null,
                    stmt9 = null, stmt10 = null;
            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOstatni.createTableZakaznik);
            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.createTableDruhZbozi);
            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOstatni.createTableSklad);
            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOstatni.createTableAdresa);
            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOstatni.createTableObjednavka);
            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOstatni.createTableProdukt);
            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOstatni.createTablePolozkaObjednavka);
            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOstatni.createTableZasoby);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vytvořeno.");
            if (stmt9 != null) {
                stmt9.close();
            }   if (stmt10 != null) {
                stmt10.close();
            }   if (stmt1 != null) {
                stmt1.close();
            }   if (stmt2 != null) {
                stmt2.close();
            }   if (stmt3 != null) {
                stmt3.close();
            }   if (stmt4 != null) {
                stmt4.close();
            }   if (stmt5 != null) {
                stmt5.close();
            }   if (stmt6 != null) {
                stmt6.close();
            }   if (stmt7 != null) {
                stmt7.close();
            }   if (stmt8 != null) {
                stmt8.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 0);
        }

    }

    public static void vytvorInMemTabulky(Connection conn)  {
        try {
            Statement stmt1 = null, stmt2 = null, stmt3 = null, stmt9 = null, stmt10 = null, stmt4 = null;
            Statement stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null, stmt11 = null, stmt12 = null;
            Statement ste = null;
            ste = conn.createStatement();
            ste.execute("SET TRANSACTION ISOLATION LEVEL READ COMMITTED");
            stmt9 = conn.createStatement();
            stmt9.executeUpdate(kody.createTablesOstatni.createDatabase);
            stmt10 = conn.createStatement();
            stmt10.executeUpdate(kody.createTablesOstatni.useDatabaze);
            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOstatni.addFilegroupStep1);
            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.addFilegroupStep2);
            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOstatni.createTableZakaznikInMem);
            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOstatni.createTableAdresaInMem);
            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOstatni.createTableDruhZboziInMem);
            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOstatni.createTableSkladInMem);
            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOstatni.createTableObjednavkaInMem);
            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOstatni.createTableProduktInMem);
            stmt11 = conn.createStatement();
            stmt11.executeUpdate(kody.createTablesOstatni.createTablePolozkaObjednavkaInMem);
            stmt12 = conn.createStatement();
            stmt12.executeUpdate(kody.createTablesOstatni.createTableZasobyInMem);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vytvořeno.", "Stav vytváření tabulek.", 1);
            if (stmt1 != null) {
                stmt1.close();
            }   if (stmt2 != null) {
                stmt2.close();
            }   if (stmt3 != null) {
                stmt3.close();
            }   if (stmt4 != null) {
                stmt4.close();
            }   if (stmt5 != null) {
                stmt5.close();
            }   if (stmt6 != null) {
                stmt6.close();
            }   if (stmt7 != null) {
                stmt7.close();
            }   if (stmt8 != null) {
                stmt8.close();
            }   if (stmt9 != null) {
                stmt9.close();
            }   if (stmt10 != null) {
                stmt10.close();
            }   if (stmt11 != null) {
                stmt11.close();
            }   if (stmt12 != null) {
                stmt12.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 0);
        }
    }

    public static void smazProstresti(Connection conn) {
        Statement stmt = null, stmt2 = null;
        try {

            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.anotherDatabase);
            stmt = conn.createStatement();
            stmt.executeUpdate(kody.createTablesOstatni.dropDatabase);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vymazáno.", "Stav prostředí", 1);

        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(metodyOstatni.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt2 != null) {
                try {
                    stmt2.close();

                } catch (SQLException ex) {
                    Logger.getLogger(metodyOstatni.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void smazProstrestiMySQL(Connection conn) {
        Statement stmt = null, stmt2 = null;
        try {
            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOstatni.anotherDatabaseMySQL);
            stmt = conn.createStatement();
            stmt.executeUpdate(kody.createTablesOstatni.dropDatabase);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vymazáno.", "Stav prostředí", 1);

        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(metodyOstatni.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt2 != null) {
                try {
                    stmt2.close();

                } catch (SQLException ex) {
                    Logger.getLogger(metodyOstatni.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void smazProstrestiPostge(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(kody.createTablesOstatni.dropDatabase);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vymazáno.", "Stav prostředí", 1);
        } catch (SQLException ex) {
            Logger.getLogger(metodyOstatni.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(metodyOstatni.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
}
