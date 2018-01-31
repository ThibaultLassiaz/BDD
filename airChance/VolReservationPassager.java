
package airChance;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rambaudb
 */
public class VolReservationPassager {
    
    private int numVolPassager;
    private int numResa;
    private Date dateVol;

    public int getNumVolPassager() {
        return numVolPassager;
    }

    public void setNumVolPassager(int numVolPassager) {
        this.numVolPassager = numVolPassager;
    }

    public int getNumResa() {
        return numResa;
    }

    public void setNumResa(int numResa) {
        this.numResa = numResa;
    }

    public Date getDateVol() {
        return dateVol;
    }

    public void setDateVol(Date dateVol) {
        this.dateVol = dateVol;
    }
    public String insertVolResaPassager(int numVolPassager,int numResa, Date dateVol){
                     
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");
        
        String query = "INSERT INTO VolReservationPassager values ("+ numVolPassager+","+numResa+",TO_DATE('"+formater.format(dateVol)+"','DD/MM/YYYY'))";
        System.out.println("Reservation Vol Créé");
        return query;
    }
}
