package kody;

import aplikace.Prihlaseni;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Duckyta
 */
public class Spojeni {

    private Connection conn;
    private Statement sts;
    private Statement ste;
    Prihlaseni pr = new Prihlaseni();

    Spojeni(Connection conn) {
        this.conn = conn;
    }

    public void select(String query) throws SQLException {
        aplikace.HlavniOkno.selectCount.vypocitejCas(0);
        sts = this.conn.createStatement();
        sts.executeQuery(query);
        sts.close();
    }

    public void execute(String query) throws SQLException {
        if (pr.volba == 3 || pr.volba == 4) {
            query = query.replaceAll("BEGIN TRANSACTION(.*)", "START TRANSACTION");
            query = query.replaceAll("COMMIT TRANSACTION(.*)", "COMMIT");
        }
        if (pr.volba == 0) {
            query = query.replaceAll("BEGIN TRANSACTION(.*)", "COMMIT");
            query = query.replaceAll("COMMIT TRANSACTION(.*)", "COMMIT");
        }
        if (pr.volba == 1 || pr.volba == 2) {
            query = query.replaceAll("BEGIN TRANSACTION", "BEGIN TRANSACTION");
        }
        aplikace.HlavniOkno.executeCount.vypocitejCas(0);
        ste = conn.createStatement();
        ste.executeUpdate(query);
        ste.close();
    }

}
