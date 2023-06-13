package maVersion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FenListeEmployes extends Stage {
	// les données
	ObservableList<String> liste = FXCollections.observableArrayList();
	
	// les composants de la fenetre
	private AnchorPane  		racine	= new AnchorPane();
	private ListView<String> 	listeEmployes= new ListView<String>();
	private Button 				bnAjouter 	= new Button("Ajouter");
	private Button 				bnSupprimer = new Button("Supprimer");

	// constructeur : initialisation de la fenetre
	public FenListeEmployes(){
		liste.add("LECLERC");
		liste.add("BIRAUD");
		liste.add("BERGER");
		liste.add("MERCIER");
		this.setTitle("Liste des employes");
		this.setMinWidth(300);
		this.setMinHeight(300);
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
	}
	
	
	private Parent creerContenu() {
		listeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// A FAIRE : lier le ListView a la liste observable "liste"
		
		
		
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> liste.add("Clint Eastwood"));
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> {
			if (listeEmployes.getSelectionModel().getSelectedIndex()!=-1) {
				liste.remove(listeEmployes.getSelectionModel().getSelectedIndex() );
			}
		});
			
		// creation du Scene graph
		AnchorPane.setTopAnchor(bnAjouter, 10.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 50.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setTopAnchor(listeEmployes, 10.0);
		AnchorPane.setLeftAnchor(listeEmployes, 10.0);
		AnchorPane.setRightAnchor(listeEmployes, 150.0);
		AnchorPane.setBottomAnchor(listeEmployes, 10.0);	
		racine.getChildren().addAll(listeEmployes, bnAjouter, bnSupprimer);
		return racine;
	}
}
