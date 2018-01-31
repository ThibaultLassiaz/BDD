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
public class Aeroport {
    
    private String nomAeroport;
    private String paysAeroport;

    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }

    public String getPaysAeroport() {
        return paysAeroport;
    }

    public void setPaysAeroport(String paysAeroport) {
        this.paysAeroport = paysAeroport;
    }

    public Aeroport(String nomAeroport, String paysAeroport) {
        this.nomAeroport = nomAeroport;
        this.paysAeroport = paysAeroport;
    }
}
