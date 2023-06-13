package maVersion;

import java.util.Map;
import java.util.Set;

/*Tnum, Tetat, Ttarif, Tcategorie, tcapacite retourne TOUS des strings
Utiliser un get pour obtenir leurs valeurs et les fourrés dans ton constructeur pour faire une nouvelle chambre
ta nouvelle chambre ensuite tu la met dans la liste des chambres et c'est bon
*/

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class create extends Stage { 
	private Button bnOK = new Button("OK");
	private Button bnAnnuler = new Button("Annuler");
	private VBox root = new VBox();
	private Label titreZoneChambre = new Label("Créer une nouvelle chambre");
	private VBox zoneChambre = new VBox();
	private HBox Boutons = new HBox();
	private VBox Chambre = new VBox(); 
	
	//Identite
	private HBox fieldNum = new HBox();
	private HBox fieldTNum = new HBox();
	private Label num = new Label("Numéro* :");
	private TextField Tnum = new TextField();

	private Label categorie = new Label("Catégorie* :");
	private ComboBox<String> Tcategorie = new ComboBox<String>();
	
	private HBox fieldtarif = new HBox();
	private Label capacite = new Label("Capacité* :");
	private Spinner<Integer> Tcapacite = new Spinner<Integer>();
	
	private HBox fieldetat = new HBox();
	private Label etat = new Label("Etat :");
	private ComboBox<String> Tetat = new ComboBox<String>();
		
		
	public create(){ 
		this.setTitle("Créer");
		this.setResizable(false);
		this.sizeToScene();
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
	}

	private Parent creerContenu(){
		
		//CollectionChambre.ajouterChambre( new Chambre(201,15,true,Catego.collectionCategories.get("Petite Suite") ) );
		bnOK.setDefaultButton(true);
		bnAnnuler.setCancelButton(true);
		this.initModality(Modality.APPLICATION_MODAL);
		
		bnOK.setOnAction(e -> getCreerChambre());
		bnAnnuler.setOnAction(e -> closed());
		Boutons.getChildren().addAll(bnOK,bnAnnuler);
		
		titreZoneChambre.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		
		zoneChambre.setBorder(new Border(new BorderStroke(
			Color.BLACK, //couleur du contour
			BorderStrokeStyle.SOLID, //forme du contour
			new CornerRadii(0), //taille d’arrondi des angles
			new BorderWidths(1) //épaisseur du contour
		)));
		
		zoneChambre.setMinHeight(120);
		zoneChambre.setMaxHeight(120);
		zoneChambre.setMinWidth(400);
		zoneChambre.setMaxWidth(400);
		zoneChambre.setPadding(new Insets(10, 10, 10, 10));
		
		Tnum.setMaxWidth(60);
		//Tcategorie.setMaxWidth(180);
		Tetat.setMaxWidth(100);
		Tetat.setMinWidth(100);
		Tcapacite.setMaxWidth(60);
		etat.setMinWidth(58.0);
		
		num.setMinWidth(83.0);
		categorie.setMinWidth(70.0);
		
		Tnum.setOnKeyTyped(e ->{
			String text = Tnum.getText();
			if(text.matches("[0-9]*")!=true) {
				Tnum.deletePreviousChar();
			}
			if (Tnum.getText().length() >=5 )
			{
				Tnum.deletePreviousChar();
			}
		});
		
		
		
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 1);
        
        Set<String> keys = Catego.collectionCategories.keySet();
        Tcategorie.getItems().addAll(keys);
        //Tcategorie.getItems().addAll("Economie","Standard","Supérieur","Petite suite","Suite supérieur");
        Tcapacite.setValueFactory(valueFactory);
		
        
		Tetat.getItems().addAll("Occupé","Libre");
		
		
		Tnum.setTooltip(new Tooltip("Maximum 4 caractères"));

		
		fieldTNum.getChildren().addAll(num,Tnum);
		
		fieldNum.getChildren().addAll(fieldTNum,categorie,Tcategorie);
		
		fieldNum.setSpacing(10.0);
		
						
		fieldtarif.getChildren().addAll(capacite,Tcapacite);
		
		fieldtarif.setSpacing(10.0);
		
		fieldetat.getChildren().addAll(etat,Tetat);
		
		fieldetat.setSpacing(25.0);
				
		zoneChambre.getChildren().addAll(fieldNum,fieldetat);
		
		zoneChambre.setSpacing(10.0);

		Chambre.getChildren().addAll(titreZoneChambre,zoneChambre);	
		
		root.setMinHeight(190);
		root.setMaxHeight(190);
		root.setMinWidth(420);
		root.setMaxWidth(420);
		Boutons.setSpacing(10);
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));

		
		root.getChildren().addAll(Chambre,Boutons);
		return root;
	}
	
	private void closed(){
		this.close();
	}
	
	public void getCreerChambre() {
		if (Tetat.getValue() == "Occupé") {
			Chambre ajout = new Chambre(Integer.valueOf(Tnum.getText()),Tcapacite.getValue(),true, Catego.collectionCategories.get(Tcategorie.getValue()) );
			CollectionChambre.collectionChambres.put(Integer.valueOf(Tnum.getText()), ajout);
			closed();
			GestionChambre.refresh();
			// vire le apres avoir fini
			CollectionChambre.affichage();
		} else {
			Chambre ajout = new Chambre(Integer.valueOf(Tnum.getText()),Tcapacite.getValue(),false, Catego.collectionCategories.get(Tcategorie.getValue()) );
			CollectionChambre.collectionChambres.put(Integer.valueOf(Tnum.getText()), ajout);
			closed();
			GestionChambre.refresh();
			//vire le apres avoir fini
			CollectionChambre.affichage();
		}
	}
}

