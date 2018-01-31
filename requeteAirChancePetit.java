/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airChance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sarigult
 */
public class requeteAirChancePetit {

    public static void getAllvoyageAfterDate(Connection conn) throws
            SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        ResultSet rs;
        ResultSet rs2;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs5 = null;
        ResultSet rs6 = null;
        ResultSet rs7 = null;
        ResultSet rs8 = null;
        int PrixResaEco = 0;
        int PrixResaAff = 0;
        int PrixResaPremiere = 0;
        int PrixResa;
        int PrixAvecReduction = 0;
        int PrixResaVol = 0;
        int PrixTotal = 0;

        int compteur = 0;
        List<Integer> listChoixVol = new ArrayList<Integer>();

        int nbPlaceEco = 0;
        int nbPlaceAff = 0;
        int nbPlacePremiere = 0;

        Client c = new Client();
        rs2 = stmt.executeQuery(c.getAllClient());
        while (rs2.next()) {
            System.out.println(rs2.getInt(1) + "- // Prenom : " + rs2.getString(3) + " // Nom :" + rs2.getString(2) + " //");
        }
        int intNumeroClient = LectureClavier.lireEntier("Votre Client:");

        rs3 = stmt.executeQuery(c.getFideliteCLient(intNumeroClient));
        while (rs3.next()) {
            System.out.println("Vous avez " + rs3.getInt(1) + " points");
        }

        System.out.println("1 - VolFret");
        System.out.println("2 - VolPassager");
        int intTypeVol = LectureClavier.lireEntier("Votre Type:");

        if (intTypeVol == 1) {
            List<VolFret> listVolFret = new ArrayList<VolFret>();
            VolFret vf = new VolFret();
            rs = stmt.executeQuery(vf.getAllVoyageBeforeDate());
        } else {
            List<VolPassager> listVolPassager = new ArrayList<VolPassager>();
            VolPassager vp = new VolPassager();
            rs = stmt.executeQuery(vp.getAllVoyageBeforeDate());

            while (rs.next()) {
                vp.setNumVolPassager(rs.getInt(1));
                vp.setDate(rs.getDate(2));
                vp.setAeroportOrigine(rs.getString(10));
                vp.setAeroportDestination(rs.getString(9));
                vp.setNumAvionPassager(rs.getInt(11));
                compteur += 1;
                listVolPassager.add(vp);

            }
            for (int i = 0; i < compteur; i++) {
                System.out.println(i + 1 + "- Depart : " + listVolPassager.get(i).getAeroportOrigine() + "// Destination :" + listVolPassager.get(i).getAeroportDestination() + " //");

            }
            int intNumVoyage = 1;
            while (intNumVoyage != 0) {
                intNumVoyage = LectureClavier.lireEntier("Entrez vos voyage (0 pour quitter) :");
                if (intNumVoyage == 0) {

                } else {
                    listChoixVol.add(intNumVoyage - 1);
                }
            }
            listChoixVol.sort(Comparator.naturalOrder());
            List<Integer> listChoixUnique = new ArrayList<Integer>();
            int nombreactuel = listChoixVol.get(0);
            listChoixUnique.add(listChoixVol.get(0));

            for (int i = 0; i < listChoixVol.size(); i++) {

                if (nombreactuel != listChoixVol.get(i)) {
                    listChoixUnique.add(listChoixVol.get(i));
                    nombreactuel = listChoixVol.get(i);
                }
            }
            for (int j = 0; j < listChoixUnique.size(); j++) {
                System.out.println(listChoixUnique.get(j));
            }
            System.out.println("Vous avez selectionnés " + listChoixUnique.size() + " voyage(s)");
            for (int i = 0; i < listChoixUnique.size(); i++) {
                int valueChoix = listChoixUnique.get(i);
                VolPassager v = listVolPassager.get(valueChoix);
                System.out.println(i + 1 + "- Depart : " + v.getAeroportOrigine() + "// Destination :" + v.getAeroportDestination() + " //");
            }

            Reservation r = new Reservation();

            rs4 = stmt.executeQuery(r.maxResa());
            int MaxResa = 0;
            while (rs4.next()) {
                MaxResa = rs4.getInt(1) + 1;
                rs3 = stmt.executeQuery(r.insertReservation(MaxResa, 0, 0, 0, intNumeroClient));
            }
            for (int i = 0; i < listChoixUnique.size(); i++) {
                int valueChoix = listChoixUnique.get(i);
                VolPassager v = listVolPassager.get(valueChoix);
                VolReservationPassager vv = new VolReservationPassager();
                rs5 = stmt.executeQuery(vv.insertVolResaPassager(v.getNumVolPassager(), MaxResa, v.getDate()));

                int intCategorie = 1;

                rs4 = stmt.executeQuery(v.getNbPlaceDispo(v.getNumVolPassager(), v.getDate()));
                while (rs4.next()) {
                    System.out.println("Nombre Place Economie Dispo : " + rs4.getInt(1));
                    System.out.println("Nombre Place Affaire Dispo : " + rs4.getInt(2));
                    System.out.println("Nombre Place Premiere Dispo : " + rs4.getInt(3));
                }

                while (intCategorie != 0) {
                    System.out.println("1- Economie // 2- Affaire // 3- Premiere // 0- Pour quitter");
                    intCategorie = LectureClavier.lireEntier("Choisissez votre categorie:");
                    if (intCategorie != 0) {
                        int nbPersonne = LectureClavier.lireEntier("Indiquez le nombre de Place :");

                        if (intCategorie == 1) {
                            nbPlaceEco = nbPersonne;
                            for (int j = 0; j < nbPlaceEco; j++) {
                                PrixResaEco = PrixResaEco + 45;
                                Place p = new Place();
                                rs6 = stmt.executeQuery(p.maxPlace());
                                int maxPlace = 0;
                                while (rs6.next()) {
                                    maxPlace = rs6.getInt(1) + 1;
                                    rs7 = stmt.executeQuery(p.insertPlace(maxPlace, "Eco", "Ranger", 45, v.getNumVolPassager()));
                                    PlaceVolResa pvr = new PlaceVolResa();
                                    rs8 = stmt.executeQuery(pvr.insertPlaceVol(maxPlace, v.getNumVolPassager(), MaxResa, v.getDate()));
                                }
                            }
                        } else if (intCategorie == 2) {
                            nbPlaceAff = nbPersonne;
                            for (int j = 0; j < nbPlaceAff; j++) {
                                PrixResaAff = PrixResaAff + 120;
                                Place p = new Place();
                                rs6 = stmt.executeQuery(p.maxPlace());
                                int maxPlace = 0;
                                while (rs6.next()) {
                                    maxPlace = rs6.getInt(1) + 1;
                                    rs7 = stmt.executeQuery(p.insertPlace(maxPlace, "Affaire", "Ranger", 120, v.getNumVolPassager()));
                                    PlaceVolResa pvr = new PlaceVolResa();
                                    rs8 = stmt.executeQuery(pvr.insertPlaceVol(maxPlace, v.getNumVolPassager(), MaxResa, v.getDate()));
                                }
                            }
                        } else if (intCategorie == 3) {
                            nbPlacePremiere = nbPersonne;
                            for (int j = 0; j < nbPlacePremiere; j++) {
                                PrixResaPremiere = PrixResaPremiere + 90;
                                Place p = new Place();
                                rs6 = stmt.executeQuery(p.maxPlace());
                                int maxPlace = 0;
                                while (rs6.next()) {
                                    maxPlace = rs6.getInt(1) + 1;
                                    rs7 = stmt.executeQuery(p.insertPlace(maxPlace, "Premiere", "Ranger", 90, v.getNumVolPassager()));
                                    PlaceVolResa pvr = new PlaceVolResa();
                                    rs8 = stmt.executeQuery(pvr.insertPlaceVol(maxPlace, v.getNumVolPassager(), MaxResa, v.getDate()));

                                }
                            }
                        }

                    }
                }
                rs4 = stmt.executeQuery(v.getNbPlaceDispo(v.getNumVolPassager(), v.getDate()));
                while (rs4.next()) {
                    System.out.println("Nombre Place Economie Dispo : " + rs4.getInt(1));
                    System.out.println("Nombre Place Affaire Dispo : " + rs4.getInt(2));
                    System.out.println("Nombre Place Premiere Dispo : " + rs4.getInt(3));
                }

                PrixResaVol = PrixResaPremiere + PrixResaAff + PrixResaEco;
                System.out.println("Prix de la reservation pour ce Vol :" + PrixResaVol + "€");
                PrixTotal = PrixTotal + PrixResaVol;
                System.out.println("Prix total de la Reservation :" + PrixResaVol + "€");
                int consulterSolde = LectureClavier.lireEntier("Consulter ses points (0:Non // 1:Oui):");
                if (consulterSolde == 1) {

                    rs3 = stmt.executeQuery(c.getFideliteCLient(intNumeroClient));
                    while (rs3.next()) {
                        System.out.println("Vous avez " + rs3.getInt(1) + " points");
                        if (rs3.getInt(2) == 1) {
                            int reduction = LectureClavier.lireEntier("Voulez-vous utiliser votre reduction (0:Non // 1:Oui):");
                            if (reduction == 1) {
                                double reductionPrix = PrixTotal * 0.05;
                                double PrixFinalAvecReduction = PrixTotal - reductionPrix;
                                System.out.println("Prix avec reduction : " + PrixFinalAvecReduction + "€");
                                rs4 = stmt.executeQuery(c.updateClient(intNumeroClient));
                            }
                        }
                    }
                }
            }
        }
        // Execute the query
        //ResultSet rs = stmt.executeQuery(p.updatePilote
        //ResultSet rs = stmt.executeQuery("SELECT numVolPassager FROM volPassager where numVolPassager = 2");
        // Close the result set, statement and the connection 
        rs.close();

        rs2.close();

        rs3.close();

        rs4.close();

        rs5.close();

        rs6.close();

        rs7.close();

        rs8.close();

        stmt.close();

    }

}
