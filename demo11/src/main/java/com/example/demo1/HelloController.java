package com.example.demo1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import packageDao.Imple;
import com.example.demo1.Candidats;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

     Imple imlementation = new Imple();
    @FXML
    private Button Ajouter_candidat;

    @FXML
    private Button Lister_candidat;

    @FXML
    private Button Modifier_candidat;

    @FXML
    private Button Supprimer_candidat;

    @FXML
    private TextField adresse;

    @FXML
    private TextField id_candidate;

    @FXML
    private TextField mail;

    @FXML
    private TextField nom;

    @FXML
    private TextField pays;

    @FXML
    private TextField prenom;

    @FXML
    private TextField ville;

    @FXML
    private TableView<Candidats> tvCandidat;
    @FXML
    private TableColumn<Candidats, String> coladresse;

    @FXML
    private TableColumn<Candidats, Integer> cold;

    @FXML
    private TableColumn<Candidats, String> colmail;

    @FXML
    private TableColumn<Candidats, String> colnom;

    @FXML
    private TableColumn<Candidats, String> colpays;

    @FXML
    private TableColumn<Candidats, String> colprenom;

    @FXML
    private TableColumn<Candidats, String> colville;

    @FXML
   void Ajouter_candidat(ActionEvent event) {

        imlementation.AjouterCandidat(id_candidate.getText(),nom.getText(),prenom.getText(),adresse.getText(),mail.getText(),ville.getText(),pays.getText());
        AfficherCandidats();
        }


    @FXML
    void Modifier_candidat(ActionEvent event) {

        imlementation.ModifierCandidat(id_candidate.getText(),nom.getText(),prenom.getText(),adresse.getText(),mail.getText(),ville.getText(),pays.getText());
        AfficherCandidats();
    }

    @FXML
    void Supprimer_candidat(ActionEvent event) {
        imlementation.SupprimerCandidat(id_candidate.getText());
        AfficherCandidats();
    }
    public void AfficherCandidats(){
        ObservableList<Candidats>  Liist =  imlementation.candidatsList();

        cold.setCellValueFactory(new PropertyValueFactory<Candidats,Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Candidats,String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Candidats,String>("prenom"));
        coladresse.setCellValueFactory(new PropertyValueFactory<Candidats,String>("adresse"));
        colmail.setCellValueFactory(new PropertyValueFactory<Candidats,String>("mail"));
        colville.setCellValueFactory(new PropertyValueFactory<Candidats,String>("ville"));
        colpays.setCellValueFactory(new PropertyValueFactory<Candidats,String>("pays"));

        tvCandidat.setItems(Liist);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         AfficherCandidats();
    }


}