/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.util.*;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class Voorwerp {
    private List<Set> sets;

    public List<Set> getSets() {
        return this.sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }
    
    public Voorwerp(List<Set> sets) {
        this.sets = sets;
    }
}
