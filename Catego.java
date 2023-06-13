package maVersion;

import java.util.Map;

//import javax.swing.RowFilter.Entry;

import java.util.HashMap;
/*
 * Etant donné la simplicité (de principe) du programme mon bute sera la lisibilitée de mon programme 
 * ainsi que le respect des convention afin d'améloirer mon code dans une optique de travail en équipe.
 */

public class Catego {
    private             Double                  tarifBase;
    private             String                  nom;
    private             String                  description;
    public static       Map<String,Catego>      collectionCategories = new HashMap<>();
    
    //Constructeur comprenant deux arguments
    public Catego(String n,String d,Double tb){ 
        this.nom = n;
        this.tarifBase = tb;
        this.description = d;
    }

    // les geteurs
    public String getNom(){
        return this.nom;
    }
    public Double getTarif(){
        return this.tarifBase;
    }
    public String getDescription(){
        return this.description;
    }

    //le toString
    public String toString(){
        return "Catégorie: "+this.nom+" est équipé de: "+this.description+" au tarif de base de: "+this.tarifBase+" euros.";
    }
 
    //les seteurs
    public void setTarif(Double nT){// nT pour nouveau Tarif
        this.tarifBase = nT;
    }

    // les methodes custom
    //la methode d'initialisation de la collection de chambres
    public static void initCat(){
        collectionCategories.clear();
        collectionCategories.put("Economie",new Catego("Economie","douche, vue sur rue",60.00));
        collectionCategories.put("Standard",new Catego("Standard","baignoire, vue sur rue",80.00));
        collectionCategories.put("Supérieur",new Catego("Supérieur","baignoire, vue sur jardin",110.00));
        collectionCategories.put("Petite suite",new Catego("Petite suite","douche, vue sur jardin",140.00));
        collectionCategories.put("Suite supérieur",new Catego("Suite supérieur","baignoire, vue sur jardin",180.00));
    }

    // une methode d'affichage
    public static void affichage(Map<String,Catego> map) {
        for (Map.Entry<String,Catego> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
