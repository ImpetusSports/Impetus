/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.utils;


import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author Michael Orner
 */
public class RandomColor {

    
    Color randomColor;

    public Color getRandomColor() {
        Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        Color theColor = Color.rgb(r, g, b);
        return theColor;
    }

 

}
