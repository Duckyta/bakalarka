/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kody;

import aplikace.HlavniOkno;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Duckyta
 */
public class metodyOrcl {

    static HlavniOkno h1 = new HlavniOkno();

    public static void createINmemTables(Connection conn) throws SQLException {
        Statement stmt1 = null, stmt2 = null, stmt3 = null,
                stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null;
        Statement ste = null;
        try {
            ste = conn.createStatement();
            ste.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOrcl.createTableZakaznikINMEM);

            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOrcl.createTableDruhZboziINMEM);

            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOrcl.createTableSkladINMEM);

            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOrcl.createTableAdresaINMEM);

            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOrcl.createTableObjednavkaINMEM);

            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOrcl.createTableProduktINMEM);

            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOrcl.createTablePolozkaObjednavkaINMEM);

            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOrcl.createTableZasobyINMEM);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí s In-Memory bylo úspěšně vytvořeno.");
        } catch (SQLException ex) {
            Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 0);
        } finally {
            if (stmt1 != null) {
                try {
                    stmt1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt2 != null) {
                try {
                    stmt2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt3 != null) {
                try {
                    stmt3.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt4 != null) {
                try {
                    stmt4.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt5 != null) {
                try {
                    stmt5.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt6 != null) {
                try {
                    stmt6.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt7 != null) {
                try {
                    stmt7.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt8 != null) {
                try {
                    stmt8.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ste != null) {
                ste.close();
            }
        }
    }

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt1 = null, stmt2 = null, stmt3 = null,
                stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null;
        Statement ste = null;
        try {

            ste = conn.createStatement();
            ste.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOrcl.createTableZakaznik);

            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOrcl.createTableDruhZbozi);

            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOrcl.createTableSklad);

            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOrcl.createTableAdresa);

            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOrcl.createTableObjednavka);

            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOrcl.createTableProdukt);

            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOrcl.createTablePolozkaObjednavka);

            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOrcl.createTableZasoby);
            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vytvořeno.", "Stav vytváření tabulek.", 1);
        } catch (SQLException ex) {
            Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(h1, "Nelze vytvořit testovací prostředí, již existuje.", "Stav vytváření tabulek", 0);
        } finally {
            if (stmt1 != null) {
                stmt1.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }
            if (stmt3 != null) {
                stmt3.close();
            }
            if (stmt4 != null) {
                stmt4.close();
            }
            if (stmt5 != null) {
                stmt5.close();
            }
            if (stmt6 != null) {
                stmt6.close();
            }
            if (stmt7 != null) {
                stmt7.close();
            }
            if (stmt8 != null) {
                stmt8.close();
            }
            if (ste != null) {
                ste.close();
            }
        }
    }

    public static void dropTables(Connection conn) {
        Statement stmt1 = null, stmt2 = null, stmt3 = null,
                stmt4 = null, stmt5 = null, stmt6 = null, stmt7 = null, stmt8 = null;
        try {

            stmt8 = conn.createStatement();
            stmt8.executeUpdate(kody.createTablesOrcl.dropTableZasoby);

            stmt3 = conn.createStatement();
            stmt3.executeUpdate(kody.createTablesOrcl.dropTableSklad);

            stmt7 = conn.createStatement();
            stmt7.executeUpdate(kody.createTablesOrcl.dropTablePolozka);

            stmt6 = conn.createStatement();
            stmt6.executeUpdate(kody.createTablesOrcl.dropTableProdukt);

            stmt2 = conn.createStatement();
            stmt2.executeUpdate(kody.createTablesOrcl.dropTableDruhZbozi);

            stmt4 = conn.createStatement();
            stmt4.executeUpdate(kody.createTablesOrcl.dropTableAdresa);

            stmt5 = conn.createStatement();
            stmt5.executeUpdate(kody.createTablesOrcl.dropTableObjednavka);

            stmt1 = conn.createStatement();
            stmt1.executeUpdate(kody.createTablesOrcl.dropTableZakaznik);

            JOptionPane.showMessageDialog(h1, "Testovací prostředí bylo úspěšně vymazáno.");

        } catch (SQLException ex) {
            Logger.getLogger(HlavniOkno.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt1 != null) {
                try {
                    stmt1.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt2 != null) {
                try {
                    stmt2.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt3 != null) {
                try {
                    stmt3.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt4 != null) {
                try {
                    stmt4.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt5 != null) {
                try {
                    stmt5.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt6 != null) {
                try {
                    stmt6.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt7 != null) {
                try {
                    stmt7.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt8 != null) {
                try {
                    stmt8.close();

                } catch (SQLException ex) {
                    Logger.getLogger(HlavniOkno.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

}
