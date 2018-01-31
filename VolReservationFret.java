
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
public class VolReservationFret {
    
    private int numVolFret;
    private int numResa;

    public int getNumVolFret() {
        return numVolFret;
    }

    public void setNumVolFret(int numVolFret) {
        this.numVolFret = numVolFret;
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
    private Date dateVol;
}
