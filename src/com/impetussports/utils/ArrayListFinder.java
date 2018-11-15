/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.utils;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Michael Orner
 */
public class ArrayListFinder {

    public static int indexOfString(ArrayList<String> array2Search, String string2Find) {
        int index = 0;
        for (String currentElement : array2Search) {
            if (currentElement.contains(string2Find)) {
                return index;
            } else {
                index++;
            }
        }
        System.out.println("Error: Could Not Find String In Array");
        return -1;
    }

    public static int indexOfStackPane(ArrayList<StackPane> array2Search, String string2Find) {
        int index = 0;
        for (StackPane currentElement : array2Search) {
            if (currentElement.getId().contains(string2Find)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public static int indexOfPane(ArrayList<Pane> array2Search, String string2Find) {
        int index = 0;
        for (Pane currentElement : array2Search) {
            if (currentElement.getId().contains(string2Find)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
}
