
package airChance;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Date;
import java.util.List;
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

        conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        Pilote p = new Pilote();
        // Execute the query
        //ResultSet rs = stmt.executeQuery(p.updatePilote());
        
        stmt.executeUpdate(p.updatePilote());
        //ResultSet rs = stmt.executeQuery("SELECT numVolPassager FROM volPassager where numVolPassager = 2");

        // Close the result set, statement and the connection 
        //rs.close();
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

    public static void newScneraio1Planification(Connection conn) throws
            SQLException {

        conn.setAutoCommit(false);
        conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);

        Statement stmt = conn.createStatement();

        RequeteAirChance.planificationVol(conn);

    }

    public static void newScneraio1Update(Connection conn) throws
            SQLException {

        conn.setAutoCommit(false);
        conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select numpilote, numvolpassager from pilotevolpassager");

        while (rs.next()) {
            System.out.print("NumPilote : " + rs.getInt(1) + " ");
            System.out.println("NumVol : " + rs.getInt(2) + " ");
        }
        Pilote p = new Pilote();
        // Execute the query
        rs = stmt.executeQuery(p.updatePilote());

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
            System.out.print("NumPilote : " + rs2.getInt(1) + " ");
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
            System.out.print("NumPilote : " + rs.getInt(1) + " ");
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
        while (rs.next()) {
            System.out.println(i + "-  Nom Aeroport : " + rs.getString(1));
            i++;
        }

        i = 1;
        String nomAeroportOrigine = "";
        int aeroportOrigine = LectureClavier.lireEntier("Choisir l'aeroport d'origine");
        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        while (rs.next() && i <= aeroportOrigine) {
            if (i == aeroportOrigine) {
                nomAeroportOrigine = rs.getString(1);
            }
            i++;
        }

        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");

        i = 1;
        while (rs.next()) {
            System.out.println(i + "-  Nom Aeroport : " + rs.getString(1));
            i++;
        }

        i = 1;
        String nomAeroportDest = "";
        int aeroportDest = LectureClavier.lireEntier("Choisir l'aeroport destination");
        rs = stmt.executeQuery("select nomaeroport from aeroport order by 1 ASC");
        while (rs.next() && i <= aeroportDest) {
            if (i == aeroportDest) {
                nomAeroportDest = rs.getString(1);
            }
            i++;
        }

        rs = stmt.executeQuery("select a.numavionpassager, nommodele from AVIONPASSAGER a where a.numavionpassager NOT IN (select v.numavionpassager from VOLPASSAGER v)");
        while (rs.next()) {
            System.out.print("  Num Avion : " + rs.getInt(1) + " ");
            System.out.println("  Nom Modele : " + rs.getString(2) + " ");
        }

        rs = stmt.executeQuery("select v.numavionpassager, max(v.dateVol) from avionpassager a \n"
                + "join volpassager v on v.numavionpassager = a.numavionpassager \n"
                + "group by a.numavionpassager\n"
                + "order by 1");

        List<VolPassager> listVolPassager = new ArrayList<VolPassager>();

        while (rs.next()) {
            VolPassager vp = new VolPassager();
            vp.setNumAvionPassager(rs.getInt(1));
            vp.setDate(rs.getDate(2));

            listVolPassager.add(vp);

        }
        for (int y = 0; y < listVolPassager.size(); y++) {
            VolPassager vp2 = listVolPassager.get(y);
            SimpleDateFormat formater = null;
            formater = new SimpleDateFormat("dd/MM/yyyy");

            ResultSet rs2 = stmt.executeQuery("select distinct v.numAvionpassager, v.estTermine, av.nommodele from volpassager v join avionpassager av on av.numavionpassager = v.numavionpassager  where v.numavionpassager = " + vp2.getNumAvionPassager() + " and dateVol = TO_DATE('" + formater.format(vp2.getDate()) + "','DD/MM/YYYY')");
            while (rs2.next()) {

                if (rs2.getInt(2) == 1) {
                    System.out.print("  Num Avion : " + rs2.getInt(1) + " ");
                    System.out.println("  Nom Modele : " + rs2.getString(3) + " ");
                }
            }
        }

        while (rs.next()) {
            System.out.print("  Num Avion : " + rs.getInt(1) + " ");
            System.out.println("  Nom Modele : " + rs.getString(3) + " ");
        }

        int numAvion = LectureClavier.lireEntier("Choisir le numéro de l'avion du vol");

        rs = stmt.executeQuery("select max(numvolpassager) from volpassager");
        int numVol = 0;
        while (rs.next()) {
            numVol = rs.getInt(1);
        }

        numVol++;
        VolPassager vp1 = new VolPassager();

        rs = stmt.executeQuery(vp1.insertVol(numVol, nomAeroportOrigine, nomAeroportDest, numAvion));

        System.out.println("\nA ce stade, nous avons crée notre vol avec les informations suivantes : Aeroport Origine, Aeroport Destination ....\n\nNous allons désormais affecter du personnel à ce vol");

        System.out.println("===========================\n===========================\n===========================\nA partir d'ici nous allons gérer l'aspect concurentiel\n===========================\n===========================\n===========================\n");

        rs = stmt.executeQuery("select p.numpilote, nompersonnel from Pilote p where p.numpilote NOT IN (select pvp.numpilote from PILOTEVOLPASSAGER pvp)");

        while (rs.next()) {
            System.out.print("  Num Pilote : " + rs.getInt(1) + " ");
            System.out.println("  Nom Pilote : " + rs.getString(2) + " ");
        }

        rs = stmt.executeQuery("select p.numpilote, p.nompersonnel, max(pvp.datevol) from PiloteVolPassager pvp \n"
                + "join pilote p on p.numPilote = pvp.numpilote\n"
                + "join VolPassager v on v.numVolPassager = pvp.numVolPassager\n"
                + "where estTermine = 1\n"
                + "group by p.numpilote, p.nompersonnel");

        while (rs.next()) {
            System.out.print("  Num Pilote : " + rs.getInt(1) + " ");
            System.out.println("  Nom Pilote : " + rs.getString(2) + " ");
        }

        int numPilote = LectureClavier.lireEntier("Choisir le pilote à affecter à ce vol");

        rs = stmt.executeQuery("select h.numhotesse, nompersonnel from Hotesse h where h.numhotesse NOT IN (select hvp.numhotesse from HOTESSEVOLPASSAGER hvp)");

        while (rs.next()) {
            System.out.print("  Num Hotesse : " + rs.getInt(1) + " ");
            System.out.println("  Nom Hotesse : " + rs.getString(2) + " ");
        }

        rs = stmt.executeQuery("select h.numhotesse, h.nompersonnel, max(hvp.datevol) from HotesseVolPassager hvp \n"
                + "join hotesse h on h.numHotesse = hvp.numHotesse\n"
                + "join VolPassager v on v.numVolPassager = hvp.numVolPassager\n"
                + "where estTermine = 1\n"
                + "group by h.numhotesse, h.nompersonnel");
        while (rs.next()) {
            System.out.print("  Num Hotesse : " + rs.getInt(1) + " ");
            System.out.println("  Nom Hotesse : " + rs.getString(2) + " ");
        }
        int numHotesse = LectureClavier.lireEntier("Choisir l'hotesse à affecter à ce vol");

        PiloteVolPassager p = new PiloteVolPassager();
        stmt.executeUpdate(p.insertPilote(numPilote, numVol));

        HotesseVolPassager h = new HotesseVolPassager();
        stmt.executeUpdate(h.insertHotesse(numHotesse, numVol));

        System.out.println("Le vol crée est le suivant :");
        rs = stmt.executeQuery("select aeroportDestination, aeroportOrigine, numAvionPassager from volpassager where numvolpassager = " + numVol);
        while (rs.next()) {
            System.out.println("  Aeroport Destination : " + rs.getString(1) + " ");
            System.out.println("  Aeroport Origine : " + rs.getString(2) + " ");
            System.out.println("  Numero Avion : " + rs.getInt(3) + " ");
        }

        System.out.println("Le personnel de ce vol est : ");
        rs = stmt.executeQuery("select numpilote from pilotevolpassager where numvolpassager = " + numVol);
        while (rs.next()) {
            System.out.println("  Numéro Pilote : " + rs.getInt(1) + " ");
        }

        rs = stmt.executeQuery("select numhotesse from hotessevolpassager where numvolpassager = " + numVol);
        while (rs.next()) {
            System.out.println("  Numéro Hotesse : " + rs.getInt(1) + " ");
        }

        rs = stmt.executeQuery("Select numpilote, nompersonnel, localisationActuel from pilote where numpilote = " + numPilote);

        while (rs.next()) {
            System.out.print("NumPilote : " + rs.getInt(1) + " ");
            System.out.println("Nom Personnel : " + rs.getString(2) + " ");
            System.out.println("Localisation Actuelle : " + rs.getString(3) + " ");
        }

        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }

    public static void deleteVol(Connection conn) throws SQLException {

        VolPassager vp = new VolPassager();
        Statement stmt = conn.createStatement();
        List<VolPassager> listvol = new ArrayList<VolPassager>();
        // Execute the query
        ResultSet rs = stmt.executeQuery("select numvolpassager from volpassager");
        while (rs.next()) {
            System.out.println("Numero Vol Passager " + rs.getInt(1));
        }

        int numVol = LectureClavier.lireEntier("Choisir le Vol a supprimer");

        rs = stmt.executeQuery(vp.delete(numVol));

    }

        
        
    public static void insertOrDeletePersonnelDeVol(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();
        System.out.println("1 - Ajouter un personnel à un vol");
        System.out.println("2 - Supprimer un personnel à un vol");

        int choixAction = LectureClavier.lireEntier("Que voulez-vous faire ?");

        System.out.println("1 - Pilote");
        System.out.println("2 - Hotesse");

        int choixSujet = LectureClavier.lireEntier("Sur quel type de personnel voulez-vous agir ?");

        String sujet = "";
        if (choixSujet == 1) {
            sujet = "pilote";
        } else {
            sujet = "hotesse";
        }

        if (choixAction == 1) {
            ResultSet rs = stmt.executeQuery("select * from" + sujet);
            while (rs.next()) {
                System.out.println("Numero Pilote " + rs.getInt(1));
            }
        }

    }

    public static void consultationNbHeurePilote(Connection conn) throws
            SQLException {

        Pilote p = new Pilote();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select numpilote, nompersonnel from pilote");
        while (rs.next()) {
            System.out.print("Numero Pilote  :  " + rs.getInt(1) + "  ");
            System.out.println("Nom Pilote :  " + rs.getString(2));
        }

        int choixPilote = LectureClavier.lireEntier("Choisir le numéro du pilote a consulter");

        rs = stmt.executeQuery(p.viewHours(choixPilote));

        while (rs.next()) {
            System.out.print("Numero Pilote  :  " + rs.getInt(1) + "  |  ");
            System.out.print("Nom Pilote :  " + rs.getString(2) + "  |  ");
            System.out.print("Nombre Heure :  " + rs.getString(3) + "h  ");
        }
    }


}
