/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.impetus;

import com.impetussports.database.DBConnect;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Michael Orner
 */
public class MainApp extends Application {

    final MySplashScreen splashScreen = new MySplashScreen();

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Starting SplashScreen...");
        startSplashScreen();
        System.out.println("Splashscreen Started");
        System.out.println("Connecting to Database...");
        DBConnect databaseConnection = new DBConnect();
        System.out.println("Database Connected");
        System.out.println("Launching GUI....");
        setPrimaryStageAndShow(stage);
        shutdownDatabase(stage);
        System.out.println("GUI Launched");
        System.out.println("Closing Splash Screen...");
        splashScreen.getSplash().close();
        System.out.println("Splashscreen Closed");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void setPrimaryStageAndShow(Stage stage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("com/impetussports/scenes/Anchor.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Impetus - Make It Happen");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Could Not Load Main Screen");
        }
    }

    
    //this method creates and starts a thread for the splash screen
    private void startSplashScreen() {
        Thread splashWindow = new Thread(splashScreen);
        splashWindow.start();
    }
    
    
    //this method shuts down the database connection when the application is closed
    private void shutdownDatabase(Stage stage) {
        stage.showingProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Program Closed");
            System.out.println("Closing Database Connection...");
            DBConnect.getSession().close();
            DBConnect.getDbFactory().close();
            System.out.println("Good Bye");
        });
    }
}
