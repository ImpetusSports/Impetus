/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.impetus;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Orner
 */
public class MySplashScreen extends Frame implements Runnable  {

    final SplashScreen splash = SplashScreen.getSplashScreen();

    public SplashScreen getSplash() {
        return splash;
    }
    

    @Override
    public void run() {
        if (splash == null) {
            System.out.println("SplashSCreen.getSplashScreen() reutrned null");
            try {
                splash.setImageURL(new URL("https://preview.ibb.co/hwF0VK/Splash_Screen.png"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(MySplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(MySplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MySplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(MySplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        Graphics2D g = splash.createGraphics();

        if (g == null) {
            System.out.println("Splash Screen Graphics is Null");
            return;
        }
        try {
            for (int i = 0; i < 100; i++) {
                renderSplashFrame(g, i);
                splash.update();
                Thread.sleep(90);
            }
        } catch (Exception e) {
            System.out.println("Splash Screen Closed");
        }
        toFront();
    }

    static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"Database", "Bluetooh Connection", "Views", "Templates"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, 2000, 2000);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading " + comps[(frame / 30) % 4] + "...", 250, 200);
    }
}
