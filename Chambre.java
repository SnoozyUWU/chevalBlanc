package maVersion;
/*
 * Etant donné la simplicité (de principe) du programme mon bute sera la lisibilitée de mon programme 
 * ainsi que le respect des convention afin d'améloirer mon code dans une optique de travail en équipe.
 */

public class Chambre {
    private         int         numero;
    private         int         capacite;
    private         Boolean     etat;// true occupé false libre
    private         Catego      categorie;

    //constructeur
    public Chambre(int num,int capa,Boolean e,Catego cat){
        this.numero = num;
        this.capacite = capa;
        this.etat = e;
        this.categorie = cat; 
    }

    // Les geteurs
    public int getNumero(){
        return this.numero;
    }

    public int getCapacite(){
        return this.capacite;
    }

    public Boolean getOccupe(){
        return this.etat;
    }
    public String getEtat() {
    	String etatString;
    	if (this.etat) {
    		etatString = "Occupé";
		} else {
			etatString ="Libre";
		}
    	return etatString;
    }

    public Catego getCategorie(){
        return this.categorie; 
    }

    public Double getTarif(){
        return this.categorie.getTarif();
    }
    //toString
    public String toString() {
    	if ( this.getOccupe() ) { 
    		return "Chambre numero: "+this.getNumero()+" "+this.getCategorie().toString()+" Et est occupé";
		}else {
    		return "Chambre numero: "+this.getNumero()+" "+this.getCategorie().toString()+" Et est libre";			
		}
    }

    // les seteurs
    public void setCategorie(Catego nouvelleCat){
        this.categorie = nouvelleCat;
    }

}
