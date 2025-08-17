package com.startapp;

import com.startapp.networkTest.enums.Os;
import com.startapp.networkTest.enums.PhoneTypes;
import com.startapp.networkTest.enums.SimStates;
import com.startapp.networkTest.enums.ThreeState;

public class f1 implements Cloneable {
    @j0(complex = true)
    public o1 BluetoothInfo = new o1();
    public String BuildFingerprint = "";
    public String DeviceManufacturer = "";
    public String DeviceName = "";
    public long DeviceUpTime;
    @j0(complex = true)
    public p1 HostAppInfo = new p1();
    public boolean IsRooted;
    @j0(complex = true)
    public q1 MultiSimInfo = new q1();
    public Os OS = Os.Android;
    public String OSVersion = "";
    public String OsSystemVersion = "";
    public int PhoneCount = -1;
    public PhoneTypes PhoneType = PhoneTypes.Unknown;
    public ThreeState PowerSaveMode = ThreeState.Unknown;
    public String SimOperator = "";
    public String SimOperatorName = "";
    public SimStates SimState = SimStates.Unknown;
    public String TAC = "";
    public String UserLocal = "";

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
