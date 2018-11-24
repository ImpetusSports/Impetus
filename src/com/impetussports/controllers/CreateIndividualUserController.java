/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

import com.impetussports.database.DBConnect;
import com.impetussports.dbobjects.Account;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javax.swing.JOptionPane.showMessageDialog;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class CreateIndividualUserController extends NavigationControllerClass implements Initializable {

    public static Account athlete = new Account();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField birthdateField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField weightField;

    @FXML
    void createNewAthlete(ActionEvent event) {
        try {
            for (Node child : gridPane.getChildren()) {
                if (child.getId() != null) {
                    if (child.getId().contains("Field")) {
                        if (!isEmpty((TextField) child)) {
                            setUserInfo((TextField) child);
                        } else {
                            showMessageDialog(null, "Enter " + child.getId().substring(0, child.getId().length() - 5));
                            return;
                        }
                    }
                }
            }
            createNewAthlete();
        } catch (Exception ex) {
            showMessageDialog(null, "Error creating user account");
        }

    }

    private Boolean isEmpty(TextField child) {
        Boolean hasContent = null;
        if (child.getText().isEmpty()) {
            hasContent = true;
        } else {
            hasContent = false;
        }
        return hasContent;
    }

    private void setUserInfo(TextField child) {
        switch (child.getId().substring(0, child.getId().length() - 5)) {
            case "username":
                athlete.setUsername(child.getText());
                System.out.println("User name set to:" + child.getText());
                break;
            case "usertype":
                athlete.setUsertype("athlete");
                System.out.println("User type set to:" + child.getText());
                break;
            case "firstname":
                athlete.setFirstname(child.getText());
                System.out.println("User firstname set to:" + child.getText());
                break;
            case "lastname":
                athlete.setLastname(child.getText());
                System.out.println("User lastname set to:" + child.getText());
                break;
            case "password":
                athlete.setPassword(child.getText());
                System.out.println("User password set to:" + child.getText());
                break;
            case "birthdate":
                athlete.setBirthdate(child.getText());
                System.out.println("User birthdate set to:" + child.getText());
                break;
            case "weight":
                athlete.setWeight(child.getText());
                System.out.println("User weight set to:" + child.getText());
                break;
            case "hieght":
                athlete.setHieght(child.getText());
                System.out.println("User height set to:" + child.getText());
                break;
        }
    }

    private void createNewAthlete() {
        Session s = DBConnect.getSession();
        Transaction tx = s.beginTransaction();
        s.save(athlete);
        s.flush();
        tx.commit();

    }

}
