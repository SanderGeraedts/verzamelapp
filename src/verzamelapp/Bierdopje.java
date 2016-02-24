/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.util.List;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class Bierdopje extends Voorwerp{
    private String merk;

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Bierdopje(String merk, List<Set> sets) {
        super(sets);
        this.merk = merk;
    }
    
    public String toString() {
        return "Bierdopje - " + this.merk;
    }
}
