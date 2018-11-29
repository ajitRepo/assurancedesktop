package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import donner.GetVoiture;
import donner.ModelListeVoiture;
import donner.RegisterData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Enregistrement implements Initializable {
    String                                          usage        = null;
    String                                          proprietaire = null;
    GetVoiture                                      listing      = new GetVoiture();

    @FXML
    JFXTextField                                    txt_nom      = new JFXTextField();

    @FXML
    private JFXTextField                            txt_prenom;

    @FXML
    private JFXTextField                            txt_phone;
    @FXML
    private JFXTextField                            txt_nfcid;

    @FXML
    private JFXComboBox<String>                     txt_proprietai;
    @FXML
    private JFXComboBox<String>                     txt_usage;

    @FXML
    private JFXTextField                            txt_matricule;

    @FXML
    private JFXTextField                            txt_marque;

    @FXML
    private JFXTextField                            txt_model;

    @FXML
    private JFXTextField                            txt_puissance;

    @FXML
    private JFXTextField                            txt_carburant;

    @FXML
    private JFXTextField                            txt_nbr_places;
    @FXML
    private TableView<ModelListeVoiture>            table_inscrit;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_matricule;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_Marque;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_model;

    @FXML
    private TableColumn<ModelListeVoiture, Integer> colun_puissance;
    @FXML
    private TableColumn<ModelListeVoiture, Integer> colun_nbrplace;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_carburan;

    @FXML
    private TableColumn<ModelListeVoiture, Object>  colun_nfcid;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_nom;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_usage;
    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_prenom;

    @FXML
    private TableColumn<ModelListeVoiture, String>  colun_telephone;
    @FXML
    private TableColumn<ModelListeVoiture, Boolean> colun_proprio;

    @FXML
    public ObservableList<ModelListeVoiture>        liste;

    @Override
    public void initialize( URL arg0, ResourceBundle arg1 ) {
        // TODO Auto-generated method stub
        liste = FXCollections.observableArrayList();
        try {
            tableaux();
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        combobox();
    }

    @FXML
    private void enregistrement( ActionEvent event ) {
        CorespondanceDesChamp();
        Clear();
    }

    @FXML
    private void vider( ActionEvent event ) {
        Clear();
    }

    public void tableaux() throws SQLException {
        try {
            listing.call_me();
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int tail = listing.taille;
        for ( int i = 0; i < tail; i++ ) {
            liste.add( new ModelListeVoiture( listing.listmatricule.get( i ), listing.listmarque.get( i ),
                    listing.listmodel.get( i ), listing.listusage.get( i ), listing.listpuissance.get( i ),
                    listing.listtypeCarburant.get( i ), listing.listnombrePlaces.get( i ), listing.listnfcid.get( i ),
                    listing.listnom.get( i ), listing.listprenom.get( i ), listing.listtelephone.get( i ),
                    listing.listproprietaire.get( i )

            ) );
        }

        colun_matricule.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "matricule" ) );
        colun_Marque.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "marque" ) );
        colun_model.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "model" ) );
        colun_usage.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "usage" ) );
        colun_puissance.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, Integer>( "puissance" ) );
        colun_carburan.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "typeCarburant" ) );
        colun_nbrplace.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, Integer>( "nombrePlaces" ) );
        colun_nfcid.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, Object>( "nfcid" ) );
        colun_nom.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "nom" ) );
        colun_telephone.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "prenom" ) );
        colun_prenom.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, String>( "telephone" ) );
        colun_proprio.setCellValueFactory( new PropertyValueFactory<ModelListeVoiture, Boolean>( "proprietaire" ) );

        table_inscrit.setItems( liste );
    }

    private void Clear() {
        txt_carburant.clear();
        txt_marque.clear();
        txt_matricule.clear();
        txt_model.clear();
        txt_nbr_places.clear();
        txt_nfcid.clear();
        txt_nom.clear();
        txt_phone.clear();
        txt_prenom.clear();
        txt_puissance.clear();
        txt_proprietai.setPromptText( "Proprietaire du vehicule ? " );
        txt_usage.setPromptText( "Usage du Vehicule " );

    }

    public void CorespondanceDesChamp() {

        String matricule = txt_matricule.getText();
        String marque = txt_marque.getText();
        String model = txt_model.getText();
        String puissance = txt_puissance.getText();
        String typeCarburant = txt_carburant.getText();
        String nombrePlaces = txt_nbr_places.getText();
        String nfcid = txt_nfcid.getText();
        String nom = txt_nom.getText();
        String prenom = txt_prenom.getText();
        String telephone = txt_phone.getText();

        RegisterData enregistrement = new RegisterData();
        try {
            enregistrement.enregistre( matricule, marque, model, usage,
                    puissance, typeCarburant, nombrePlaces, nfcid, nom, prenom,
                    telephone, proprietaire );
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void combobox() {
        txt_usage.getItems().add( new String( "VP" ) );
        txt_usage.getItems().add( new String( "TPV" ) );
        txt_usage.getItems().add( new String( "TPC" ) );
        txt_usage.getItems().add( new String( "Scooter" ) );

        txt_proprietai.getItems().add( new String( "true" ) );
        txt_proprietai.getItems().add( new String( "false" ) );

        txt_usage.getSelectionModel().selectedItemProperty()
                .addListener( new ChangeListener<String>() {
                    public void changed( ObservableValue<? extends String> observable,
                            String oldValue, String usagess ) {
                        usage = usagess;
                    }
                } );

        txt_proprietai.getSelectionModel().selectedItemProperty()
                .addListener( new ChangeListener<String>() {
                    public void changed( ObservableValue<? extends String> observable,
                            String oldValue, String proprietairec ) {
                        proprietaire = proprietairec;

                    }
                } );
    }
}
