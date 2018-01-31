package airChance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rambaudb
 */
public class AvionFret {
    
    private int numAvionFret;
    private int volumeTransportable;
    private int poidsTransportable;
    private String nomModele;

    public int getNumAvionFret() {
        return numAvionFret;
    }

    public void setNumAvionFret(int numAvionFret) {
        this.numAvionFret = numAvionFret;
    }

    public int getVolumeTransportable() {
        return volumeTransportable;
    }

    public void setVolumeTransportable(int volumeTransportable) {
        this.volumeTransportable = volumeTransportable;
    }

    public int getPoidsTransportable() {
        return poidsTransportable;
    }

    public void setPoidsTransportable(int poidsTransportable) {
        this.poidsTransportable = poidsTransportable;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }
}
