
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
public class HotesseVolPassager {
    
    private int numHotesse;
    private int numVolPassager;
    private Date dateVol = new Date();

    public int getNumHotesse() {
        return numHotesse;
    }

    public void setNumHotesse(int numHotesse) {
        this.numHotesse = numHotesse;
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
    
    
    
    public String insertHotesse(int numHotesse, int numVol){
        
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");
        String query ="INSERT INTO HotesseVolPassager values('"+numHotesse+"','"+numVol+"',TO_DATE('"+formater.format(this.dateVol)+"','DD/MM/YYYY'))";
        return query; 
    }
}
