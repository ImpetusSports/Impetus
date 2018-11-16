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
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class NewUserTypeSelectionController extends NavigationControllerClass implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void createAthlete(ActionEvent event) {
        System.out.println("Create Trainer User");
        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "CreateIndividualUser")));
    }

    @FXML
    void createTrainer(ActionEvent event) {
        System.out.println("Create Athlete User");
        showMessageDialog(null, "Option Not Available");
//        mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "")));
    }

}
