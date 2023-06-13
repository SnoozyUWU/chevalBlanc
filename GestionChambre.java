package maVersion;

import java.util.ArrayList;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GestionChambre extends Stage{
	// les données
	ObservableList<String> liste = FXCollections.observableArrayList();
	ArrayList<Chambre> listeSelect = new ArrayList<Chambre>();//je change de ChambreItem a chambres
	
	// Elements
	private ComboBox<String> champRechNumero = new ComboBox<String>();
	private ComboBox<String> champRechCateg = new ComboBox<String>();
	private ComboBox<String> champRechEtat = new ComboBox<String>();
	private Button bnAjouter = new Button("Ajouter");
	private Button bnModifier = new Button("Modifier");
	private Button bnSupprimer = new Button("Supprimer");
	
	// Boites
	public static ListView<Chambre> listeChambres = new ListView<Chambre>();//ce qui est affiché
	private AnchorPane racine = new AnchorPane();
	
	public GestionChambre(){
		this.setTitle("Gestion des chambres");
		this.setMinWidth(700);
		this.setMinHeight(300);
		this.setResizable(true);
		//Chambre c1 =  new Chambre(001, 2, true,Catego.collectionCategories.get("Standard"));
		this.setScene(new Scene(creerContenu()));
	}
	
	
	private Parent creerContenu() {
		listeChambres.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		// A FAIRE : lier le ListView a la liste observable "liste"
		
		
		
		// Mettre tooltip sur barres de recherches
		champRechNumero.setTooltip(new Tooltip("Numero de la chambre recherchée"));
		champRechCateg.setTooltip(new Tooltip("Categorie de la chambre recherchée"));
		champRechEtat.setTooltip(new Tooltip("Etat de la chambre recherchée"));
		
		// Mettre tooltip sur les boutons
		bnAjouter.setTooltip(new Tooltip("Créer une nouvelle chambre"));
		bnModifier.setTooltip(new Tooltip("Modifier la catégorie de la chambre"));
		bnSupprimer.setTooltip(new Tooltip("Supprimer la chambre"));
		
		// detection et traitement des evenements
		bnAjouter.setOnAction(e -> { //la j'ai pas le choix donc g le droit
			try {
				gererCreation(new create());
			} catch (Exception e1) {
				System.out.println("nah marche pas");
				e1.printStackTrace();
			}
			});
		
		bnModifier.setOnAction(e -> {
			for(Chambre n : listeSelect) {
				Modification mod = new Modification(CollectionChambre.collectionChambres.get(n.getNumero()));
			} 
		});
		
		bnSupprimer.setOnAction(e -> {
			System.out.println("Supprime");
		});
		
		/*listeChambres.setCellFactory(CheckBoxListCell.forListView(new Callback<ChambreItem, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(ChambreItem item) {
                return item.onProperty();
            }
        }));*/
		refresh();
		
		// Placement des champs de recherche
		champRechNumero.setPrefWidth(150);
		AnchorPane.setTopAnchor(champRechNumero, 10.0);
		AnchorPane.setLeftAnchor(champRechNumero, 45.0);
		
		champRechCateg.getItems().addAll(Catego.collectionCategories.keySet());
		champRechCateg.setPrefWidth(150);
		AnchorPane.setTopAnchor(champRechCateg, 10.0);
		AnchorPane.setLeftAnchor(champRechCateg, 210.0);
				
		champRechEtat.setPrefWidth(150);
		champRechEtat.getItems().addAll("Libre","Occupé");
		AnchorPane.setTopAnchor(champRechEtat, 10.0);
		AnchorPane.setLeftAnchor(champRechEtat, 375.0);
		
		// Placement des boutons
		bnAjouter.setPrefWidth(100);
		AnchorPane.setTopAnchor(bnAjouter, 25.0);
		AnchorPane.setRightAnchor(bnAjouter, 25.0);
		
		bnModifier.setPrefWidth(100);
		AnchorPane.setTopAnchor(bnModifier, 65.0);
		AnchorPane.setRightAnchor(bnModifier, 25.0);
		
		bnSupprimer.setPrefWidth(100);
		AnchorPane.setTopAnchor(bnSupprimer, 105.0);
		AnchorPane.setRightAnchor(bnSupprimer, 25.0);
		
		// Placement de la liste
		AnchorPane.setTopAnchor(listeChambres, 50.0);
		AnchorPane.setLeftAnchor(listeChambres, 10.0);
		AnchorPane.setRightAnchor(listeChambres, 150.0);
		AnchorPane.setBottomAnchor(listeChambres, 10.0);
		
		// Ajout des éléments
		racine.getChildren().addAll(champRechNumero,champRechCateg,champRechEtat,listeChambres, bnAjouter, bnModifier, bnSupprimer);
		return racine;
	}
	
	//ouverture des fenetres du menu
	public void gererCreation(Stage stage) throws Exception {
		stage = new create(); 
		stage.show();
	}
	
	public void gererModification(Stage stage,Chambre c) throws Exception {
		stage = new Modification(c); 
		stage.show();
	}
	
	/// gere l'affichage
	public static void refresh() {
		System.out.println("rentré");
		listeChambres.getItems().clear();
		Map<Integer,Chambre> map = CollectionChambre.collectionChambres;
        for (Map.Entry<Integer,Chambre> entry : map.entrySet()) {
        	listeChambres.getItems().add(entry.getValue());
        }
	}
}

/*
 * ChambreItem item = new ChambreItem(1, "Categ", "Etat", false);
			item.onProperty().addListener((obs, wasOn, isNowOn) -> {
				if (isNowOn) {
					listeSelect.add(item);
				} else {
					listeSelect.remove(item);
				}
				for(ChambreItem n : listeSelect) {
					System.out.println(n);
				}
            });

            listeChambres.getItems().add(item);
 * */