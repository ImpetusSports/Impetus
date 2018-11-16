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

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class NavigationBarController extends NavigationControllerClass implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void showLoginScreen(ActionEvent event) {
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "LoginScreen")));
    }

    @FXML
    void showStettings(ActionEvent event) {
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "Settings")));
    }

    @FXML
    void showUserProfile(ActionEvent event) {
        System.out.println("fix to get user type then set controller");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualUserProfile")));
    }

    @FXML
    void showWorkout(ActionEvent event) {
        System.out.println("fix to get user type then set controller");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualUserWorkoutDisplay")));
    }

    @FXML
    void showWorkoutBuilder(ActionEvent event) {
        System.out.println("fix to get user type then set controller");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualWorkoutBuilder")));
    }

    @FXML
    void showWorkoutHistory(ActionEvent event) {
        System.out.println("fix to get user type then set controller");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualUserHistory")));
    }

}
