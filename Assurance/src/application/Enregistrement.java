package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Enregistrement implements Initializable {

    @FXML
    private JFXTextField   txt_nom;

    @FXML
    private JFXTextField   txt_prenom;

    @FXML
    private JFXTextField   txt_phone;

    @FXML
    private JFXComboBox<?> txt_proprietai;

    @FXML
    private JFXTextField   txt_matricule;

    @FXML
    private JFXTextField   txt_marque;

    @FXML
    private JFXTextField   txt_model;

    @FXML
    private JFXComboBox<?> txt_usage;

    @FXML
    private JFXTextField   txt_puissance;

    @FXML
    private JFXTextField   txt_carburant;

    @FXML
    private JFXTextField   txt_nbr_places;

    @Override
    public void initialize( URL arg0, ResourceBundle arg1 ) {
        // TODO Auto-generated method stub

    }

    @FXML
    void enregistrement( ActionEvent event ) {

    }

    @FXML
    void vider( ActionEvent event ) {

    }

}
