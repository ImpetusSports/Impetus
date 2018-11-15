package com.impetussports.bluetooth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.microedition.io.StreamConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael Orner
 */
public class BluetoothRead { 
    public ArrayList<Double> StreamData = new ArrayList<>();
    
    public void BluetoothRead(StreamConnection stream) throws IOException {
        stream = BluetoothClientConnection.getStream();
        System.out.println("Reading Input");
        InputStream dataIn = stream.openInputStream();
        BufferedReader readInput = new BufferedReader(new InputStreamReader(dataIn));
        while (true) {
            try {
                String lineRead = readInput.readLine();
                System.out.println("The incoming message says: \n\t" + lineRead);
                StreamData.add(Double.parseDouble(lineRead));
                if (lineRead.equalsIgnoreCase("finsihed counting")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("input null");
            }
        }
    }
}
