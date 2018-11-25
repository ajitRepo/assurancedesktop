package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import donner.RegisterData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Enregistrement implements Initializable {
    String                      usage        = null;
    String                      proprietaire = null;

    @FXML
    JFXTextField                txt_nom      = new JFXTextField();

    @FXML
    private JFXTextField        txt_prenom;

    @FXML
    private JFXTextField        txt_phone;
    @FXML
    private JFXTextField        txt_nfcid;

    @FXML
    private JFXComboBox<String> txt_proprietai;
    @FXML
    private JFXComboBox<String> txt_usage;

    @FXML
    private JFXTextField        txt_matricule;

    @FXML
    private JFXTextField        txt_marque;

    @FXML
    private JFXTextField        txt_model;

    @FXML
    private JFXTextField        txt_puissance;

    @FXML
    private JFXTextField        txt_carburant;

    @FXML
    private JFXTextField        txt_nbr_places;

    @Override
    public void initialize( URL arg0, ResourceBundle arg1 ) {
        // TODO Auto-generated method stub
        combobox();
    }

    @FXML
    private void enregistrement( ActionEvent event ) {
        name();
        Clear();
    }

    @FXML
    private void vider( ActionEvent event ) {

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

    public void name() {

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
