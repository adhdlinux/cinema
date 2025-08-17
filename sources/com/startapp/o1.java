package com.startapp;

import com.startapp.networkTest.enums.bluetooth.BluetoothConnectionState;
import java.util.ArrayList;

public class o1 {
    public BluetoothConnectionState A2DPConnectionState;
    public boolean BluetoothEnabled;
    @j0(type = ArrayList.class, value = n1.class)
    public ArrayList<n1> ConnectedA2DPBluetoothDevices = new ArrayList<>();
    @j0(type = ArrayList.class, value = n1.class)
    public ArrayList<n1> ConnectedHeadsetBluetoothDevices = new ArrayList<>();
    @j0(type = ArrayList.class, value = n1.class)
    public ArrayList<n1> ConnectedHealthBluetoothDevices = new ArrayList<>();
    public BluetoothConnectionState HeadsetConnectionState;
    public BluetoothConnectionState HealthConnectionState;
    public boolean MissingPermission = false;
    @j0(type = ArrayList.class, value = n1.class)
    public ArrayList<n1> PairedBluetoothDevices = new ArrayList<>();

    public o1() {
        BluetoothConnectionState bluetoothConnectionState = BluetoothConnectionState.Unknown;
        this.HealthConnectionState = bluetoothConnectionState;
        this.HeadsetConnectionState = bluetoothConnectionState;
        this.A2DPConnectionState = bluetoothConnectionState;
    }
}
