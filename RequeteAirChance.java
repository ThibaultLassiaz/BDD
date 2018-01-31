
package airChance;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in 
 Project Properties.
 * To change this template file, choose To
 ols | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class RequeteAirChance {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexio n � la base de donn � es
     * @throws SQLException en cas d'erreur d'acc � s � la base de donn � es
     */
    public static void updatePilote(Connection conn) throws
            SQLException {
        
        conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        
        Pilote p = new Pilote();
        // Execute the query
        ResultSet rs = stmt.executeQuery(p.updatePilote());
        //ResultSet rs = stmt.executeQuery("SELECT numVolPassager FROM volPassager where numVolPassager = 2");
        
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        

    }

    public static void deletePiloteVolPassager(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        
        Statement stmt = conn.createStatement();
        
        
        PiloteVolPassager pvp = new PiloteVolPassager();
        // Execute the query
        ResultSet rs = stmt.executeQuery(pvp.deletePilote5Vol4());
        
        // Close the result set, statement and the connection 
        
        rs.close();
        stmt.close();
    }
    
        public static void scenario1(Connection conn, Connection conn2) throws
            SQLException {
        // Get a statement from the connection
        
        conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
        conn.setAutoCommit(false); 
        Statement stmt = conn.createStatement();
        
        PiloteVolPassager pvp = new PiloteVolPassager();
        // Execute the query
        ResultSet rs = stmt.executeQuery(pvp.insert());
        
        conn2.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
        conn2.setAutoCommit(false); 
        Statement stmt2 = conn2.createStatement();
        
        ResultSet rs2 = stmt2.executeQuery("Select numpilote, numvolpassager from pilotevolpassager");
        
        while (rs2.next()) {
            System.out.print("NumPilote : " + rs2.getInt(1)+" ");
            System.out.println("NumVol : " + rs2.getInt(2) + " ");
        }
       
        
        rs.close();
        stmt.close();
        
        rs2.close();
        stmt2.close();
    }
        
    public static void getAllPiloteVolPassager(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("Select numpilote, numvolpassager from pilotevolpassager");
        
        while (rs.next()) {
            System.out.print("NumPilote : " + rs.getInt(1)+" ");
            System.out.println("NumVol : " + rs.getInt(2) + " ");
        }
      
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    
    
    
    
   
    public static void planificationVol(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        System.out.println("===Planificaiton d'un vol===");
        
        ResultSet rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        
        int i = 1;
        while(rs.next()){
            System.out.println(i+"-  Nom Aeroport : " + rs.getString(1));
            i++;
        }

        
        i = 1;
        String nomAeroportOrigine ="";
        int aeroportOrigine = LectureClavier.lireEntier("Choisir l'aeroport d'origine");
        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        while(rs.next() && i <= aeroportOrigine){
            if (i == aeroportOrigine){
                nomAeroportOrigine = rs.getString(1);
            }
            i++;
        }
        

        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        
        i = 1;
        while(rs.next()){
            System.out.println(i+"-  Nom Aeroport : " + rs.getString(1));
            i++;
        }
        
        
        i = 1;
        String nomAeroportDest ="";
        int aeroportDest = LectureClavier.lireEntier("Choisir l'aeroport destination");
        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        while(rs.next() && i <= aeroportDest){
            if (i == aeroportDest){
                nomAeroportDest = rs.getString(1);
            }
            i++;
        }

        rs = stmt.executeQuery("select numavionpassager, nommodele from avionpassager");
        while(rs.next()){
            System.out.print("  Num Avion : " + rs.getInt(1)+" ");
            System.out.println("  Nom Modele : " + rs.getString(2)+" ");
        }
        
        int numAvion = LectureClavier.lireEntier("Choisir l'avion du vol");
        
        rs = stmt.executeQuery("select max(numvolpassager) from volpassager");
        int numVol = 0;
        while(rs.next()){
            numVol = rs.getInt(1);
        }
        
        numVol++;
        VolPassager vp = new VolPassager();
        rs = stmt.executeQuery(vp.insertVol(numVol,nomAeroportOrigine, nomAeroportDest, numAvion));
        
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }
    
        public static void deleteVol(Connection conn) throws
            SQLException {
            
        VolPassager vp = new VolPassager();
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("select numvolpassager from volpassager");
        while(rs.next()){
            System.out.println("Numero Vol Passager "+rs.getInt(1));
        }
        
        int numVol = LectureClavier.lireEntier("Choisir le Vol a supprimer");
        
        rs = stmt.executeQuery(vp.delete(numVol));
        
        }
        
        
        public static void insertOrDeletePersonnelDeVol(Connection conn) throws
                SQLException {
        
            Statement stmt = conn.createStatement();
            System.out.println("1 - Ajouter un personnel à un vol");
            System.out.println("2 - Supprimer un personnel à un vol");
            
            int aeroportDest = LectureClavier.lireEntier("Choisir le pilote/hotesse à enlever du vol");
            ResultSet rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
            

            
        }

}
