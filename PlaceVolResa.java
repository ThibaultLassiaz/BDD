
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
public class PlaceVolResa {
    
    private int numPlace;
    private int numVolPassager;
    private int numResa;
    private Date dateVol;

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

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
    
}
