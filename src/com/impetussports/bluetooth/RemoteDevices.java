/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.bluetooth;

import java.io.IOException;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

/**
 *
 * @author Michael Orner
 */
public class RemoteDevices {
    RemoteDevice[] remoteDevices;

    public RemoteDevice[] getRemoteDevices() {
        return remoteDevices;
    }

    public void setRemoteDevices() throws BluetoothStateException, IOException { 
        LocalDevice thisDevice = LocalDevice.getLocalDevice();
        System.out.println("The Local Device is: " + thisDevice.getFriendlyName());
        RemoteDevice[] bluetoothDevicesPaired = thisDevice.getDiscoveryAgent().retrieveDevices(DiscoveryAgent.PREKNOWN);
        for (RemoteDevice remoteDevice : bluetoothDevicesPaired) {
                System.out.println("Remote Device Name : " + remoteDevice.getFriendlyName(false));
        }
        this.remoteDevices = bluetoothDevicesPaired;
    }
    
}
