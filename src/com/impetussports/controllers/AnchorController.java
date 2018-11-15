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

    private final Map<Pane, Object> stackPaneControllerTable = new HashMap();
    private static final ArrayList<Pane> views = new ArrayList<>();

    @FXML
    private BorderPane mainBorderPane;

    public void setMainBorderPaneCenter(Pane stackPane) {
        mainBorderPane.setCenter(stackPane);
    }

    public static ArrayList<Pane> getViews() {
        return views;
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
            ArrayList<String> controllerPaths = PackageContents.getPackageContentsPaths("com.impetussports.controllers");
            for (String viewName : viewNames) {
                if ((!viewName.equals("Anchor"))) {
                    try {
                        views.add(getPane(viewPaths.get(ArrayListFinder.indexOfString(viewPaths, viewName)), viewName));
                    } catch (Exception ex) {
                        Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNavigationController() {
        NavigationBarController NavBar = (NavigationBarController) getPaneController(views.get(ArrayListFinder.indexOfPane(views, "NavigationBar")));
        NavBar.setMainController(this);

    }

    private void setMainBorderPane() {
        mainBorderPane.setTop(views.get(ArrayListFinder.indexOfPane(views, "Menu")));
        mainBorderPane.setCenter(views.get(ArrayListFinder.indexOfPane(views, "Login")));
        mainBorderPane.getLeft().managedProperty().bind(mainBorderPane.getLeft().visibleProperty());
        mainBorderPane.getRight().managedProperty().bind(mainBorderPane.getRight().visibleProperty());
//        mainBorderPane.setCenter(views.get(ArrayListFinder.indexOfPane(views, "Login")));
        
    }

    private Pane getPane(String viewPath, String viewName) {
        try {
            Pane pane = new Pane();
            pane.setId(viewName);
            URL location = getClass().getResource("/" + viewPath);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Node root = (Node) fxmlLoader.load(location.openStream());
            Object guiController = (Object) fxmlLoader.getController();
            pane.getChildren().add(root);
            stackPaneControllerTable.put(pane, guiController);
            return pane;
        } catch (IOException ex) {
            Logger.getLogger(AnchorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Error");
        return null;
    }

    public Object getPaneController(Pane pane){
        return stackPaneControllerTable.get(pane);
    }

    public void setCenterPane(Pane pane) {
        mainBorderPane.setCenter(pane);
    }

    public void setTopPane(Pane pane) {
        mainBorderPane.setTop(pane);
    }

    public void setBottomPane(Pane pane) {
        mainBorderPane.setBottom(pane);
    }

    public void setLeftPane(Pane pane) {
        mainBorderPane.setLeft(pane);
    }
}
