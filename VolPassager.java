
package airChance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.text.SimpleDateFormat;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeRegExp.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rambaudb
 */
public class VolPassager {


    private int numVolPassager;
    private Date date = new Date();
    private int heureDepart = 10;

    private int dureeVol = 14;
    private int distanceVol = 150;
    private int nombrePlaceDispoEco = 50;
    private int nombrePlaceDispoAffaire = 15;
    private int nombrePlaceDispoPremiere = 50;
    private String aeroportDestination;
    private String aeroportOrigine;
    private int numAvionPassager;

    VolPassager() {
    }

    public int getNumVolPassager() {
        return numVolPassager;
    }

    public void setNumVolPassager(int numVolPassager) {
        this.numVolPassager = numVolPassager;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }

    public int getDureeVol() {
        return dureeVol;
    }

    public void setDureeVol(int dureeVol) {
        this.dureeVol = dureeVol;
    }

    public int getDistanceVol() {
        return distanceVol;
    }

    public void setDistanceVol(int distanceVol) {
        this.distanceVol = distanceVol;
    }

    public int getNombrePlaceDispoEco() {
        return nombrePlaceDispoEco;
    }

    public void setNombrePlaceDispoEco(int nombrePlaceDispoEco) {
        this.nombrePlaceDispoEco = nombrePlaceDispoEco;
    }

    public int getNombrePlaceDispoAffaire() {
        return nombrePlaceDispoAffaire;
    }

    public void setNombrePlaceDispoAffaire(int nombrePlaceDispoAffaire) {
        this.nombrePlaceDispoAffaire = nombrePlaceDispoAffaire;
    }

    public int getNombrePlaceDispoPremiere() {
        return nombrePlaceDispoPremiere;
    }

    public void setNombrePlaceDispoPremiere(int nombrePlaceDispoPremiere) {
        this.nombrePlaceDispoPremiere = nombrePlaceDispoPremiere;
    }

    public String getAeroportDestination() {
        return aeroportDestination;
    }

    public void setAeroportDestination(String aeroportDestination) {
        this.aeroportDestination = aeroportDestination;
    }

    public String getAeroportOrigine() {
        return aeroportOrigine;
    }

    public void setAeroportOrigine(String aeroportOrigine) {
        this.aeroportOrigine = aeroportOrigine;
    }

    public int getNumAvionPassager() {
        return numAvionPassager;
    }

    public void setNumAvionPassager(int numAvionPassager) {
        this.numAvionPassager = numAvionPassager;
    }

    public VolPassager(int numVolPassager, Date date, int heureDepart, int dureeVol, int distanceVol, int nombrePlaceDispoEco, int nombrePlaceDispoAffaire, int nombrePlaceDispoPremiere, String aeroportDestination, String aeroportOrigine, int numAvionPassager) {
        this.numVolPassager = numVolPassager;
        this.date = date;
        this.heureDepart = heureDepart;
        this.dureeVol = dureeVol;
        this.distanceVol = distanceVol;
        this.nombrePlaceDispoEco = nombrePlaceDispoEco;
        this.nombrePlaceDispoAffaire = nombrePlaceDispoAffaire;
        this.nombrePlaceDispoPremiere = nombrePlaceDispoPremiere;
        this.aeroportDestination = aeroportDestination;
        this.aeroportOrigine = aeroportOrigine;
        this.numAvionPassager = numAvionPassager;
    }

    public String insertVol(int numVol, String origine, String destination, int numAvion) {

        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");

        String query = "INSERT INTO VolPassager values (" + numVol + ",TO_DATE('" + formater.format(this.date) + "','DD/MM/YYYY'),'" + this.heureDepart + "','" + this.dureeVol + "','" + this.distanceVol + "','" + this.nombrePlaceDispoEco + "','" + this.nombrePlaceDispoAffaire + "','" + this.nombrePlaceDispoPremiere + "','" + destination
                + "','" + origine + "','" + numAvion + "')";

        return query;
    }

    public String delete(int numVolPassager) {
        String query = "DELETE FROM VolPassager where numVolPassager='" + numVolPassager + "' ";

        return query;
    }

    public String finishVol(int numVolPassager) {
        String query = "UPDATE VolPassager SET estTermine=1 where numvolpassager = '" + numVolPassager + "'";

        return query;
    }

    public String getAllVoyageBeforeDate() {
        String query = "SELECT * FROM VolPassager WHERE dateVol>sysdate";
        return query;
    }

    public String getNbPlaceDispo(int numVolpassager, Date dateVol) {
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");
        String query = "SELECT nombrePlaceDispoEco,nombrePlaceDispoAffaire,nombrePlaceDispoPremiere FROM VolPassager WHERE dateVol=TO_DATE('" + formater.format(dateVol) + "','DD/MM/YYYY') AND numVolpassager=" + numVolpassager;
        return query;
    }
    
    
}
