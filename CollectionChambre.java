package maVersion;

import java.util.Map;
import java.util.HashMap;

public class CollectionChambre {

    public static Map<Integer,Chambre> collectionChambres = new HashMap<>(); 
     
    //le constructeur
    public CollectionChambre(){ 
    }

    //le geteur
    public Map<Integer,Chambre> getCollection(){
        return collectionChambres;
    }

    // les seteurs
    public void suprimmerChambre(Chambre c){
        Integer clef;//oui je sais je l'écris a l'ancienne
        clef = c.getNumero();
        if ( collectionChambres.containsKey(clef) ) {
            collectionChambres.remove(clef);
        }else{
            System.out.println("le code n'exixte pas");//pourrait créer une exeption
        }
    }
    // AJOUT D'UNE CHAMBRE
    public static void ajouterChambre(Chambre c){
        if (    collectionChambres.containsKey(c.getNumero())   ) { 
            System.out.println("La chambre spécifié existe déja");
        }else{
            collectionChambres.put(c.getNumero(),c);//pourrait créer une exeption
        }
    }
    
    //affichage
    public static void affichage() {
    	Map<Integer,Chambre> map = collectionChambres;
        for (Map.Entry<Integer,Chambre> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
