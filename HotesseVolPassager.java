
package airChance;


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
    private Date dateVol;
}
