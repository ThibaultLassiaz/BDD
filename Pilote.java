/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rambaudb
 */
public class Pilote {
    
    private int numPilote;
    private String nomPersonnel;
    private String prenomPersonnel;
    private int numeroRuePersonnel;
    private String nomRuePersonnel;
    private int codePostalPersonnel;
    private String villePersonnel;
    private String paysPersonnel;
    private int nbHeureTotal;
    private String localisationActuelle;

    Pilote() {
       
    }

    public int getNumPilote() {
        return numPilote;
    }

    public void setNumPilote(int numPilote) {
        this.numPilote = numPilote;
    }

    public String getNomPersonnel() {
        return nomPersonnel;
    }

    public void setNomPersonnel(String nomPersonnel) {
        this.nomPersonnel = nomPersonnel;
    }

    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    public void setPrenomPersonnel(String prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    public int getNumeroRuePersonnel() {
        return numeroRuePersonnel;
    }

    public void setNumeroRuePersonnel(int numeroRuePersonnel) {
        this.numeroRuePersonnel = numeroRuePersonnel;
    }

    public String getNomRuePersonnel() {
        return nomRuePersonnel;
    }

    public void setNomRuePersonnel(String nomRuePersonnel) {
        this.nomRuePersonnel = nomRuePersonnel;
    }

    public int getCodePostalPersonnel() {
        return codePostalPersonnel;
    }

    public void setCodePostalPersonnel(int codePostalPersonnel) {
        this.codePostalPersonnel = codePostalPersonnel;
    }

    public String getVillePersonnel() {
        return villePersonnel;
    }

    public void setVillePersonnel(String villePersonnel) {
        this.villePersonnel = villePersonnel;
    }

    public String getPaysPersonnel() {
        return paysPersonnel;
    }

    public void setPaysPersonnel(String paysPersonnel) {
        this.paysPersonnel = paysPersonnel;
    }

    public int getNbHeureTotal() {
        return nbHeureTotal;
    }

    public void setNbHeureTotal(int nbHeureTotal) {
        this.nbHeureTotal = nbHeureTotal;
    }

    public String getLocalisationActuelle() {
        return localisationActuelle;
    }

    public void setLocalisationActuelle(String localisationActuelle) {
        this.localisationActuelle = localisationActuelle;
    }

    public Pilote(int numPilote, String nomPersonnel, String prenomPersonnel, int numeroRuePersonnel, String nomRuePersonnel, int codePostalPersonnel, String villePersonnel, String paysPersonnel, int nbHeureTotal, String localisationActuelle) {
        this.numPilote = numPilote;
        this.nomPersonnel = nomPersonnel;
        this.prenomPersonnel = prenomPersonnel;
        this.numeroRuePersonnel = numeroRuePersonnel;
        this.nomRuePersonnel = nomRuePersonnel;
        this.codePostalPersonnel = codePostalPersonnel;
        this.villePersonnel = villePersonnel;
        this.paysPersonnel = paysPersonnel;
        this.nbHeureTotal = nbHeureTotal;
        this.localisationActuelle = localisationActuelle;
    }
    
    
    public String updatePilote(){
        
        System.out.print("Entrer une nouvelle localisation");
        String newLocalisation = LectureClavier.lireChaine();
        String query = "UPDATE Pilote SET localisationActuel = '"+newLocalisation+"' where numpilote=5";
        
        return query;
    }
    
    public String viewHours(int numPilote){
        

        String query = "select numpilote, nompersonnel, nbheuretotal from pilote where numpilote = "+numPilote;
        return query;
    }
    
    
    
}
