package maVersion;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Modification extends Stage{
	private Catego retour;
	private Label numeroChambre;
	private Label nvCategorie = new Label("Nouvelle Catégorie  :");
	private ComboBox<String> Tcategorie = new ComboBox<String>();
	private Label acCategorie;
	private VBox root = new VBox();
	private Button bnOK = new Button("OK");
	private Button bnAnnuler = new Button("Annuler");
	private HBox Boutons = new HBox();
	private VBox Categories = new VBox();
	private HBox nvCategories = new HBox(); 

	public Modification(Chambre modif){ 
		this.setTitle("Modifier");
		this.setResizable(false);
		this.sizeToScene();
		Scene laScene = new Scene(creerContenu(modif));
		this.setScene(laScene);
	}
	
	private Parent creerContenu(Chambre modif){
		numeroChambre = new Label("Numéro de la chambre  : " + modif.getNumero());
		acCategorie= new Label("Ancienne Catégorie : " + modif.getCategorie().getNom());
		acCategorie.setMinWidth(180);
		nvCategories.setSpacing(10);
		categorie();
		Tcategorie.setValue("Economie");
	    
		Categories.setSpacing(10);
		nvCategories.getChildren().addAll(nvCategorie,Tcategorie);
		Categories.getChildren().addAll(numeroChambre,acCategorie,nvCategories);
		
		bnOK.setOnAction(e -> confirm(modif));
		bnAnnuler.setOnAction(e -> closed());
		Boutons.getChildren().addAll(bnOK,bnAnnuler);
		root.getChildren().addAll(Categories,Boutons);
		
		root.setMinHeight(100);
		root.setMinWidth(250);
		Boutons.setSpacing(10);
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		return root;
	}
	
	private void closed(){
		this.close();
	}
	
	private void confirm(Chambre modif){
		Catego.collectionCategories.forEach((k, v) -> {
			if(v.getNom()==Tcategorie.getValue()) {
				retour = v;
			}
		}
		);
		CollectionChambre.collectionChambres.forEach((k, v) -> {
			if(v.getNumero()==modif.getNumero()) {
				CollectionChambre.collectionChambres.get(k).setCategorie(retour);
			}
		}
		);
		this.close();
	}
	
	private void categorie() {
		Catego.collectionCategories.forEach((k, v) -> 
		Tcategorie.getItems().addAll(v.getNom())
		);
	}
	

}