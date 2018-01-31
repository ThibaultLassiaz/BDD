
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
public class AvionPassager {
    
    private int numAvionPassager;
    private int nombrePlaceEco;
    private int nombrePlacePremiere;
    private int nombrePlaceAffaire;
    private String nomModele;

    public int getNumAvionPassager() {
        return numAvionPassager;
    }

    public void setNumAvionPassager(int numAvionPassager) {
        this.numAvionPassager = numAvionPassager;
    }

    public int getNombrePlaceEco() {
        return nombrePlaceEco;
    }

    public void setNombrePlaceEco(int nombrePlaceEco) {
        this.nombrePlaceEco = nombrePlaceEco;
    }

    public int getNombrePlacePremiere() {
        return nombrePlacePremiere;
    }

    public void setNombrePlacePremiere(int nombrePlacePremiere) {
        this.nombrePlacePremiere = nombrePlacePremiere;
    }

    public int getNombrePlaceAffaire() {
        return nombrePlaceAffaire;
    }

    public void setNombrePlaceAffaire(int nombrePlaceAffaire) {
        this.nombrePlaceAffaire = nombrePlaceAffaire;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public AvionPassager(int numAvionPassager, int nombrePlaceEco, int nombrePlacePremiere, int nombrePlaceAffaire, String nomModele) {
        this.numAvionPassager = numAvionPassager;
        this.nombrePlaceEco = nombrePlaceEco;
        this.nombrePlacePremiere = nombrePlacePremiere;
        this.nombrePlaceAffaire = nombrePlaceAffaire;
        this.nomModele = nomModele;
    }
    
}
