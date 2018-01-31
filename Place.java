
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
public class Place {
    
    private int numPlace;
    private String categoriePlace;
    private String positionPlace;
    private int prixPlace;
    private Date dateChangementPlace;
    private int numAvionPassager;

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

    public String getCategoriePlace() {
        return categoriePlace;
    }

    public void setCategoriePlace(String categoriePlace) {
        this.categoriePlace = categoriePlace;
    }

    public String getPositionPlace() {
        return positionPlace;
    }

    public void setPositionPlace(String positionPlace) {
        this.positionPlace = positionPlace;
    }

    public int getPrixPlace() {
        return prixPlace;
    }

    public void setPrixPlace(int prixPlace) {
        this.prixPlace = prixPlace;
    }

    public Date getDateChangementPlace() {
        return dateChangementPlace;
    }

    public void setDateChangementPlace(Date dateChangementPlace) {
        this.dateChangementPlace = dateChangementPlace;
    }

    public int getNumAvionPassager() {
        return numAvionPassager;
    }

    public void setNumAvionPassager(int numAvionPassager) {
        this.numAvionPassager = numAvionPassager;
    }
}
