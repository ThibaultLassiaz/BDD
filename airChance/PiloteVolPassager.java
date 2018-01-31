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
public class PiloteVolPassager {
    
    private int numPilote;
    private int numVolPassager;
    private Date dateVol = new Date();

    PiloteVolPassager() {

    }

    public int getNumPilote() {
        return numPilote;
    }

    public void setNumPilote(int numPilote) {
        this.numPilote = numPilote;
    }

    public int getNumVolPassager() {
        return numVolPassager;
    }

    public void setNumVolPassager(int numVolPassager) {
        this.numVolPassager = numVolPassager;
    }

    public Date getDateVol() {
        return dateVol;
    }

    public void setDateVol(Date dateVol) {
        this.dateVol = dateVol;
    }

    public PiloteVolPassager(int numPilote, int numVolPassager, Date dateVol) {
        this.numPilote = numPilote;
        this.numVolPassager = numVolPassager;
        this.dateVol = dateVol;
    }
    
    public String deletePilote5Vol4(){
        String query = "DELETE FROM PiloteVolPassager WHERE numpilote=5 and numvolpassager=4";
        return query;
    }
    
    public String insert(){
        String query ="INSERT INTO PiloteVolPassager values(5,4,TO_DATE('29/01/2018', 'DD/MM/YYYY'))";
        return query;
    }
    
    public String insertPilote(int numPilote, int numVol){
        
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");
        String query ="INSERT INTO PiloteVolPassager values('"+numPilote+"','"+numVol+"',TO_DATE('"+formater.format(this.dateVol)+"','DD/MM/YYYY'))";
        return query; 
    }
   
    
}
