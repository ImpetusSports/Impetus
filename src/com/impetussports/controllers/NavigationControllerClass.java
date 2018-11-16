/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

/**
 *
 * @author Michael Orner
 */
public abstract class NavigationControllerClass extends Object{
    /**
     * Allows for navigation by getting the mainBorderPane
     */ 
    AnchorController setMainController;  
    public AnchorController mainBorderPane;
    public void setMainController(AnchorController aThis) {
        this.mainBorderPane = aThis;
    }
}
