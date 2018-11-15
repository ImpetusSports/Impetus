/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.controllers;

import com.impetussports.utils.ArrayListFinder;
import com.impetussports.utils.PackageContents;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Michael Orner
 */
public class AnchorController implements Initializable {

    private final Map<Node, Object> controllerTable = new HashMap();
    private static final List<Node> VIEWS = new ArrayList<>();

    @FXML
    private BorderPane mainBorderPane;

    public void setMainBorderPaneCenter(Pane stackPane) {
        mainBorderPane.setCenter(stackPane);
    }

    public static List<Node> getViews() {
        return VIEWS;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Loading GUIs");
            loadAllGuis();
        } catch (Exception ex) {
            System.out.println("Could Not Load Views");
        }
        setNavigationController();
        setMainBorderPane();
    }

    private void loadAllGuis() {
        try {
            ArrayList<String> viewNames = PackageContents.getPackageContentsNames("com.impetussports.scenes");
            ArrayList<String> viewPaths = PackageContents.getPackageFXMLPaths("com.impetussports.scenes");
            for (String viewName : viewNames) {
                if ((!viewName.equals("Anchor"))) {
                    try {
                        VIEWS.add(getPane(viewPaths.get(ArrayListFinder.indexOfString(viewPaths, viewName)), viewName));
                    } catch (Exception ex) {
                        Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ClassNotFoundException | IOException | URISyntaxException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNavigationController() {
        NavigationBarController NavBar = (NavigationBarController) getController(VIEWS.get(ArrayListFinder.indexOfNode(VIEWS, "NavigationBar")));
        NavBar.setMainController(this);

    }

    private void setMainBorderPane() {
        mainBorderPane.setTop(VIEWS.get(ArrayListFinder.indexOfNode(VIEWS, "Menu")));
        mainBorderPane.setLeft(VIEWS.get(ArrayListFinder.indexOfNode(VIEWS, "NavigationBar")));  
    }
    

    private Pane getPane(String viewPath, String viewName) {
        try {
            System.out.println(viewName);
            Pane pane = new Pane();
            pane.setId(viewName);
            URL location = getClass().getResource("/" + viewPath);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Node root = (Node) fxmlLoader.load(location.openStream());
            Object guiController = (Object) fxmlLoader.getController();
            pane.getChildren().add(root);
            controllerTable.put(pane, guiController);
            return pane;
        } catch (IOException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Error could not load fxml: " + viewName + " from location : " + viewPath);
        return null;
    }

    public Object getController(Node node){
        return controllerTable.get(node);
    }

    public void setCenterPane(Node node) {
        mainBorderPane.setCenter(node);
    }

    public void setTopPane(Node node) {
        mainBorderPane.setTop(node);
    }

    public void setBottomPane(Node node) {
        mainBorderPane.setBottom(node);
    }

    public void setLeftPane(Node node) {
        mainBorderPane.setLeft(node);
    }
}
