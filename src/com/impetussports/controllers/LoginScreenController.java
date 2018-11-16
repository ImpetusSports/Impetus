/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

import com.impetussports.utils.ArrayListFinder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class LoginScreenController extends NavigationControllerClass implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberMe;

    @FXML
    void login(ActionEvent event) {
        if (usernameField.getText().isEmpty() | passwordField.getText().isEmpty()) {
            showMessageDialog(null, "Enter Username or Password");
        } else {
            if (rememberMe.isSelected()) {
                System.out.println("Remember User");
            }
            System.out.println("Login");
            System.out.println("Getting User Infromation");
            mainBorderPane.setLeftPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "NavigationBar")));
            mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualUserProfile")));
        }
    }

    @FXML
    void dontLogIn(ActionEvent event) {
        System.out.println("Login as defualt user");
        System.out.println("Getting Defualt Information");
        mainBorderPane.setLeftPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "NavigationBar")));
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "DefualtUserProfile")));

    }

    @FXML
    void newUser(ActionEvent event) {
        System.out.println("Create New User");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "NewUserTypeSelection")));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
