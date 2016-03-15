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
public class Registry {
    private List<Set> sets;

    public List<verzamelapp.Set> getSets() {
        return sets;
    }

    public void setSets(List<verzamelapp.Set> sets) {
        this.sets = sets;
    }

    public Registry() {
        this.sets = new ArrayList<>();
    }
    
    public boolean open() {
        return false;
    }
    
    public boolean close() {
        return false;
    }
}
