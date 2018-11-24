/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

import com.impetussports.database.DBConnect;
import com.impetussports.dbobjects.Account;
import com.impetussports.utils.ArrayListFinder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class LoginScreenController extends NavigationControllerClass implements Initializable {

    private static Account USER = null;
    
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberMe;

    @FXML
    void login(ActionEvent event) {
        if (usernameField.getText().isEmpty() | passwordField.getText().isEmpty()) {
            showMessageDialog(null, "Enter Username and Password");
        } else {
            if (rememberMe.isSelected()) {
                System.out.println("Remember User");
            }
            System.out.println("Login");
            USER = getAccount(usernameField.getText(), passwordField.getText());
            System.out.println("Getting User Infromation");
            if (USER != null) {
                mainBorderPane.setLeftPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "NavigationBar")));
                mainBorderPane.setCenterPane(AnchorController.getViews().get(ArrayListFinder.indexOfNode(AnchorController.getViews(), "IndividualUserProfile")));
            } else {
                showMessageDialog(null, "Username or Password is incorrect");
            }
        }
    }

    public static Account getUSER() {
        return USER;
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

    private Account getAccount(String username, String password) {
        try {
            Session s = DBConnect.getSession();
            Transaction tx = s.beginTransaction();
            Account user = (Account) s.get(Account.class, username);
            s.flush();
            tx.commit();
            System.out.println(user.getUsername() + " " + user.getPassword());
            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception ex) {
            System.out.println("Oops... Something went wrong");
        }
        return null;
    }

}
