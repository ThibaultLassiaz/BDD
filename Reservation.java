/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airChance;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sarigult
 */
public class Reservation {
    
    private int numResa;
    private Date dateResa;
    private int volumeResa;
    private int poidsResa;
    private int estResaFret;
    private int numClient;

    public int getNumResa() {
        return numResa;
    }

    public Date getDateResa() {
        return dateResa;
    }

    public int getVolumeResa() {
        return volumeResa;
    }

    public int getPoidsResa() {
        return poidsResa;
    }

    

    public int getNumClient() {
        return numClient;
    }

    public void setNumResa(int numResa) {
        this.numResa = numResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    public void setVolumeResa(int volumeResa) {
        this.volumeResa = volumeResa;
    }

    public void setPoidsResa(int poidsResa) {
        this.poidsResa = poidsResa;
    }

    public int getEstResaFret() {
        return estResaFret;
    }

    public void setEstResaFret(int estResaFret) {
        this.estResaFret = estResaFret;
    }

    

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    
    
    public String insertReservation(int numResa,int volumeResa, int poidsResa, int estResaFret, int numClient){
        
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");
                
        String query = "INSERT INTO RESERVATION values ("+ numResa+",sysdate,"+volumeResa+","+poidsResa+","+estResaFret+","+numClient+")";
        System.out.println("Reservation Créé");
        return query;
    }
    
    public String maxResa(){
        
        String query = "SELECT MAX(numResa) FROM RESERVATION";
        
        return query;
    }
}
