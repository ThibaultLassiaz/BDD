package airChance;


import airChance.requeteAirChancePetit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Connexionsgbd {

    private static final String configurationFile
            = "BD.properties";

    public static void main(String args[]) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            System.out.println(dbUrl);
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Connection conn2 = DriverManager.getConnection(dbUrl, username, password);
            conn.setAutoCommit(false); 
            conn2.setAutoCommit(false); 
            
            
            System.out.println("test requête");
            //RequeteAirChance.updatePilote(conn);
            //RequeteAirChance.deletePiloteVolPassager(conn);
            //RequeteAirChance.scenario1(conn, conn2);
            System.out.println("------------------- ");
            //RequeteAirChance.getAllPiloteVolPassager(conn);
            
            //RequeteAirChance.planificationVol(conn);
            
            requeteAirChancePetit.getAllvoyageAfterDate(conn);

            // Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            
            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }

    }
}
