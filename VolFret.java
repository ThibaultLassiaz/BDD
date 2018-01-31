
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
public class VolFret {
    private int numVolFret;
    private Date date;
    private int heureDepart; 
    private int dureeVol;
    private int distanceVol;
    private int volumeDispo;
    private int prixVolume;
    private String aeroportDestination;
    private String aeroportOrigine;
    private int numAvionFret;

    VolFret() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getNumVolFret() {
        return numVolFret;
    }

    public void setNumVolFret(int numVolFret) {
        this.numVolFret = numVolFret;
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

    public int getVolumeDispo() {
        return volumeDispo;
    }

    public void setVolumeDispo(int volumeDispo) {
        this.volumeDispo = volumeDispo;
    }

    public int getPrixVolume() {
        return prixVolume;
    }

    public void setPrixVolume(int prixVolume) {
        this.prixVolume = prixVolume;
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

    public int getNumAvionFret() {
        return numAvionFret;
    }

    public void setNumAvionFret(int numAvionFret) {
        this.numAvionFret = numAvionFret;
    }

    public VolFret(int numVolFret, Date date, int heureDepart, int dureeVol, int distanceVol, int volumeDispo, int prixVolume, String aeroportDestination, String aeroportOrigine, int numAvionFret) {
        this.numVolFret = numVolFret;
        this.date = date;
        this.heureDepart = heureDepart;
        this.dureeVol = dureeVol;
        this.distanceVol = distanceVol;
        this.volumeDispo = volumeDispo;
        this.prixVolume = prixVolume;
        this.aeroportDestination = aeroportDestination;
        this.aeroportOrigine = aeroportOrigine;
        this.numAvionFret = numAvionFret;
    }
    
     public String getAllVoyageBeforeDate(){
         String query="SELECT * FROM VolFret WHERE dateVol>sysdate";
         return query;
    }
    

}
