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
public class Verzamelapp {
    private static Registry registry;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        registry = new Registry();
        
        start();
    }
    
    private static void start() {
        showMenuOptions();
                
        chooseMenu();
    }
    
    private static void showMenuOptions() {
        System.out.println("Welkom bij de Verzamel app!");
        System.out.println("");
        System.out.println("Kies een van de onderstaande opties:");
        System.out.println("1: Voeg een set toe");
        System.out.println("2: Voeg een postzegel toe");
        System.out.println("3: Voeg een bierdop toe");
        System.out.println("4: Verwijder een bierdop");
        System.out.println("5: Verwijder een postzegel");
        System.out.println("6: Bekijk alle voorwerpen gesorteerd op jaar");
        System.out.println("7: Bekijk alle postzegels gesorteerd op grootte");
        System.out.println("8: Exit");
        System.out.println("9: TestDatabase");
    }
    
    private static void chooseMenu() {
        Scanner input = new Scanner(System.in, "UTF-8");
        try{
            int keuze = input.nextInt();

            switch(keuze) {
                case 1:
                    addSet();
                    break;
                case 2:
                    addPostzegel();
                    break;
                case 3:
                    addBierdop();
                    break;
                case 4:
                    removeBierdop();
                    break;
                case 5:
                    removePostzegel();
                    break;
                case 6:
                    showVoorwerpen();
                    break;
                case 7:
                    showPostzegels();
                    break;
                case 8:
                    exit();
                    break;
                case 9:
                    testDatabase();
                    break;
                default:
                    restart();
            }
        } catch(InputMismatchException e) {
            System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
            restart();
        }
    }
    
    private static Set chooseSet() {
        Set set = null;
        int index = 0;
        int keuze;
        boolean failed = true;
        
        System.out.println("Kies een van de onderstaande sets:");
        
        while(failed) {
            for(Set s : registry.getSets()) {
                System.out.printf("%d: %s %n", index, s.toString());
                index++;
            }

            try{
                Scanner input = new Scanner(System.in, "UTF-8");
                keuze = input.nextInt();

                if(keuze >= 0 && registry.getSets().size() >= keuze) {
                    failed = false;
                    set = registry.getSets().get(keuze);
                    return set;
                } else {
                    System.out.println("Verkeerde input, kies een juist nummer.");
                }
            } catch(InputMismatchException e) {
                System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
            }
        }
        
        return set;
    }
    
    private static void addSet() {
        String naam;
        int jaar = 0;
        
        System.out.println("--------------------------------");
        
        System.out.println("Naam set:");
        Scanner input = new Scanner(System.in, "UTF-8");
        naam = input.nextLine();
        
        boolean failed = true;
        
        while(failed) {
            System.out.println("Jaar: ");
            input = new Scanner(System.in, "UTF-8");            
            try{
                jaar = input.nextInt();
                failed = false;
            } catch(InputMismatchException e) {
                System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
            }
        }
        
        Set set = new Set(naam, jaar);
        registry.getSets().add(set);
        for(Set s : registry.getSets()){
            System.out.println(s.toString());
        }
        System.out.println("--------------------------------");
        start();
    }
    
    private static void addPostzegel() {
        System.out.println("--------------------------------");
        if(!registry.getSets().isEmpty()) {
            Set set = null;
            double lengte = 0;
            double breedte = 0;
            
            set = chooseSet();
        
            boolean failed = true;

            while(failed) {
                System.out.println("Lengte: ");
                Scanner input = new Scanner(System.in, "UTF-8");            
                try{
                    lengte = input.nextDouble();
                    failed = false;
                } catch(InputMismatchException e) {
                    System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
                }
            }
        
            failed = true;

            while(failed) {
                System.out.println("Breedte: ");
                Scanner input = new Scanner(System.in, "UTF-8");            
                try{
                    breedte = input.nextDouble();
                    failed = false;
                } catch(InputMismatchException e) {
                    System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
                }
            }
            Postzegel postzegel = new Postzegel(lengte, breedte);
            set.addVoorwerp(postzegel);            
        } else {
            System.out.println("Voeg a.u.b. eerst een set toe");
            System.out.println("--------------------------------");
            start();
        }
        System.out.println("--------------------------------");
        start();
    }
    
    private static void addBierdop() {
        System.out.println("--------------------------------");
        if(!registry.getSets().isEmpty()) {
            Set set = null;
            String merk;
            
            set = chooseSet();
            
            System.out.println("Naam Merk:");
            Scanner input = new Scanner(System.in, "UTF-8");
            merk = input.nextLine();
            
            Bierdopje bierdopje = new Bierdopje(merk);
            set.addVoorwerp(bierdopje);
        } else {
            System.out.println("Voeg a.u.b. eerst een set toe");
            System.out.println("--------------------------------");
            start();
        }
        System.out.println("--------------------------------");
        start();
    }
    
    private static void removeBierdop() {
        System.out.println("Kies een bierdopje om te verwijderen:");
        List<Bierdopje> bierdopjes = new ArrayList<>();
        Bierdopje remove = null;
        for(Set set : registry.getSets()) {
            for(Voorwerp voorwerp : set.getVoorwerpen()) {
                if(voorwerp instanceof Bierdopje) {
                    bierdopjes.add((Bierdopje) voorwerp);
                }
            }
        }
        
        if(!bierdopjes.isEmpty()) {
            for(int i = 0; i < bierdopjes.size(); i++) {
                Bierdopje bierdopje = bierdopjes.get(i);
                System.out.println(i + ": " + bierdopje.toString());
            }
            
            Scanner input = new Scanner(System.in, "UTF-8");
            boolean failed = true;
            
            while(failed){
                try{
                    int keuze = input.nextInt();
                    if(keuze >= 0 && keuze < bierdopjes.size()){
                        remove = bierdopjes.get(keuze);
                        for(Set set : registry.getSets()) {
                            if(set.getVoorwerpen().contains(remove)){
                                set.getVoorwerpen().remove(remove);
                                failed = false;
                            }
                        }
                    } else {
                        System.out.println("Verkeerde input, Kies a.u.b. een juist bierdopje.");
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
                }
            }
            
        } else {
            System.out.println("Geen bierdopjes gevonden...");
        }
        restart();
    }
    
    private static void removePostzegel() {
        System.out.println("Kies een postzegel om te verwijderen:");
        List<Postzegel> postzegels = new ArrayList<>();
        Postzegel remove = null;
        for(Set set : registry.getSets()) {
            for(Voorwerp voorwerp : set.getVoorwerpen()) {
                if(voorwerp instanceof Postzegel) {
                    postzegels.add((Postzegel) voorwerp);
                }
            }
        }
        
        if(!postzegels.isEmpty()) {
            for(int i = 0; i < postzegels.size(); i++) {
                Postzegel postzegel = postzegels.get(i);
                System.out.println(i + ": " + postzegel.toString());
            }
            
            Scanner input = new Scanner(System.in, "UTF-8");
            boolean failed = true;
            
            while(failed){
                try{
                    int keuze = input.nextInt();
                    if(keuze >= 0 && keuze < postzegels.size()){
                        remove = postzegels.get(keuze);
                        for(Set set : registry.getSets()) {
                            if(set.getVoorwerpen().contains(remove)){
                                set.getVoorwerpen().remove(remove);
                                failed = false;
                            }
                        }
                    } else {
                        System.out.println("Verkeerde input, Kies a.u.b. een juiste postzegel.");
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Verkeerde input, gebruik a.u.b. alleen nummers.");
                }
            }
            
        } else {
            System.out.println("Geen postzegels gevonden...");
        }
        restart();
    }
    
    private static void showVoorwerpen() {
        System.out.println("Voorwerpen: ");
        Collections.sort(registry.getSets());
        for(Set set : registry.getSets()) {
            System.out.println(set.toString());
            for(Voorwerp voorwerp : set.getVoorwerpen()) {
                System.out.println("- " + voorwerp.toString());
            }
        }
        System.out.println("Press enter to continue...");
        Scanner wait = new Scanner(System.in, "UTF-8");
        wait.nextLine();
        System.out.println("--------------------------------");
        start();
    }
    
    private static void showPostzegels() {
        System.out.println("Postzegels:");
        List<Postzegel> postzegels = new ArrayList<>();
        for(Set set : registry.getSets()) {
            for(Voorwerp voorwerp : set.getVoorwerpen()) {
                if(voorwerp instanceof Postzegel) {
                    postzegels.add((Postzegel) voorwerp);
                }
            }
        }
        
        if(!postzegels.isEmpty()) {
            Collections.sort(postzegels);
            for(Postzegel postzegel : postzegels) {
                System.out.println(postzegel.toString());
            }
        } else {
            System.out.println("Geen postzegels gevonden...");
        }
            
        System.out.println("Press enter to continue...");
        Scanner wait = new Scanner(System.in, "UTF-8");
        wait.nextLine();
        
        System.out.println("--------------------------------");
        start();
    }
    
    private static void exit() {
        System.out.println("--------------------------------");
    }
    
    private static void restart() {
        System.out.println("--------------------------------");
        start();
    }

    private static void testDatabase() {
        Database database = new Database(new Properties());
    }
}
