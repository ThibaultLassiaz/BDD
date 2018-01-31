
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

            int choix = 0;
            do {
            System.out.println("************ MENU ************");
            System.out.println("1 - Plannifier un vol");
            System.out.println("2 - Modifier un vol");            
            System.out.println("3 - Supprimer un vol");            
            System.out.println("4 - Terminer un vol");
            System.out.println("5 - Ajouter/Supprimer un personnel-");
            System.out.println("6 - Consulter les commandes d'un client");
            System.out.println("7 - Reservation d'un vol");      
            System.out.println("8 - Modifier une reservation");   
            System.out.println("9 - Supprimer une reservation");
            System.out.println("10 - Scenario 1");
            System.out.println("11 - Quitter");            
            System.out.println("******************************");            
            //RequeteAirChance.updatePilote(conn);
            //RequeteAirChance.deletePiloteVolPassager(conn);
            //RequeteAirChance.scenario1(conn, conn2);
            choix = LectureClavier.lireEntier("Votre choix : \n");
            switch (choix) {
            case 1: 
                    System.out.println("******************************"); 
                    RequeteAirChance.planificationVol(conn);
                     break;
            case 2:  
                     System.out.println("******************************"); 
                     RequeteAirChance.updatePilote(conn);
                     break;
            case 3:  
                     System.out.println("******************************");
                     RequeteAirChance.deleteVol(conn); 
                     break;
            case 4:  
                     System.out.println("******************************");  
                     break;
            case 5:  
                     System.out.println("******************************");  
                     break;
            case 6:  
                     System.out.println("******************************");  
                     break;
            case 7:  
                     System.out.println("******************************");
                     requeteAirChancePetit.getAllvoyageAfterDate(conn);
                     break;
            case 8:  
                     System.out.println("******************************");  
                     break;
            case 9:  
                     System.out.println("******************************");  
                     break;
            case 10 :
                     System.out.println("******************************");
                     RequeteAirChance.updatePilote(conn);
                     RequeteAirChance.deletePiloteVolPassager(conn);
                     RequeteAirChance.scenario1(conn, conn2);
            case 11 :
                    System.out.println("Deconnexion");
                    choix = 11;
        }
            } while (choix != 11);
            
            System.out.println("test requête");
      
              //RequeteAirChance.deletePiloteVolPassager(conn);
            //RequeteAirChance.scenario1(conn, conn2);
            //RequeteAirChance.updatePilote(conn);
            System.out.println("------------------- ");
            //RequeteAirChance.getAllPiloteVolPassager(conn);
            
            //RequeteAirChance.newScneraio1Planification(conn);
            
            //RequeteAirChance.newScneraio1Update(conn);
            
            //RequeteAirChance.planificationVol(conn);
            
            //RequeteAirChance.deleteVol(conn);
            
            //RequeteAirChance.consultationNbHeurePilote(conn);
            //RequeteAirChance.deleteVol(conn);

            //RequeteAirChance.deleteVol(conn);

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
