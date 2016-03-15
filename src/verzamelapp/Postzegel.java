/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import static java.lang.Double.compare;
import java.util.List;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class Postzegel extends Voorwerp implements Comparable<Postzegel>{
    private double lengte;
    private double breedte;

    public double getLengte() {
        return lengte;
    }

    public double getBreedte() {
        return breedte;
    }
    
    public double getSize() {
        return lengte * breedte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public Postzegel(double lengte, double breedte){
        this.lengte = lengte;
        this.breedte = breedte;
    }

    @Override
    public int compareTo(Postzegel other) {
        int result = compare(this.getSize(), other.getSize());
        return result;
    }
    
    @Override
    public String toString() {
        return "Postzegel - Lengte: " + this.lengte + "mm | Breedte: " + this.breedte + "mm";
    }
    
    
}
