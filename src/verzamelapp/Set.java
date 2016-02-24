/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import static java.lang.Double.compare;
import java.util.*;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class Set implements Comparable<Set>{
    private String naam;
    private int jaar;
    private List<Voorwerp> voorwerpen;

    public String getNaam() {
        return naam;
    }

    public int getJaar() {
        return jaar;
    }

    public List<Voorwerp> getVoorwerpen() {
        return this.voorwerpen;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public void setVoorwerpen(List<Voorwerp> voorwerpen) {
        this.voorwerpen = voorwerpen;
    }
    
    public void addVoorwerp(Voorwerp voorwerp) {
        this.voorwerpen.add(voorwerp);
    }
    
    public Set(String naam, int jaar) {
        this.naam = naam;
        this.jaar = jaar;
        this.voorwerpen = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return this.jaar + " - " + this.naam;
    }
    
    @Override
    public int compareTo(Set other) {
        int result = compare(this.jaar, other.jaar);
        return result;
    }
}
