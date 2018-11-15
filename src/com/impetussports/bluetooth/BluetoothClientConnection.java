/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.bluetooth;

import java.io.IOException;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author Michael Orner
 */
public class BluetoothClientConnection {

    String BluetoothStatus = "Not Connected";
    static StreamConnection stream;

    public String getBluetoothStatus() {
        return BluetoothStatus;
    }

    public static StreamConnection getStream() {
        return stream;
    }

    public void setBluetoothStatus(String BluetoothStatus) {
        this.BluetoothStatus = BluetoothStatus;
    }

    public void BluetoothClientConnection(RemoteDevice bluetoothDevice) throws BluetoothStateException, IOException {
        String connectionURL = ("btspp://" + bluetoothDevice.getBluetoothAddress() + ":1;master=false;encrypt=false;authenticate=false");
        System.out.println("The URL: " + connectionURL);
        try {
            stream = (StreamConnection) Connector.open(connectionURL);
            setBluetoothStatus("Connected");
            System.out.println("Client was able to connect");

            System.out.println("Closing connection");
            stream.close();

        } catch (IOException e) {
            System.out.println("Client was unable to connect");
            System.out.println(e);

        }
    }

}
