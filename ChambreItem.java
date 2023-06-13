package maVersion;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ChambreItem {
    private final BooleanProperty on = new SimpleBooleanProperty();
    private Chambre chambre;
     
    public ChambreItem(Chambre c) { 
    	this.chambre = c ;
    }
    
    public int getNum() {
		return this.chambre.getNumero();
	}
    
    public Catego getCateg() {
		return this.chambre.getCategorie();
	}
    
    public String getEtat() {
		return this.chambre.getEtat();
	}
	
	public final BooleanProperty onProperty() {
        return this.on;
    }

    public final boolean isOn() {
        return this.onProperty().get();
    }

    public final void setOn(final boolean on) {
        this.onProperty().set(on);
    }

    @Override
    public String toString() {
    	String numBuff = "",categBuff = "";
    	int numLen = String.valueOf(this.chambre.getNumero()).length();
    	int categLen = this.chambre.getCategorie().toString().length();
    	for (int i=0;i<(32-numLen);i++) {
    		numBuff+=" ";
    	}
    	numBuff+=" |     ";
    	for (int i=0;i<(29-categLen);i++) {
    		categBuff+=" ";
    	}
    	categBuff+=" |     ";
        return "    "+getNum()+numBuff+getCateg().getNom()+categBuff+getEtat();
    }
    

}


