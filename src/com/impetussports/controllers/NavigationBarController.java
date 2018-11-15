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
public class NavigationBarController implements Initializable {
   
    AnchorController setMainController;
    
    private AnchorController mainController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setMainController(AnchorController aThis) {
        this.mainController = aThis;
    }
    
    @FXML
    void showLoginScreen(ActionEvent event) {
        mainController.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "LoginScreen")));
    }

    @FXML
    void showStettings(ActionEvent event) {

    }
    
    
    
    
    
}
