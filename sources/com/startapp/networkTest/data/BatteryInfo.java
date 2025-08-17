package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.BatteryChargePlugTypes;
import com.startapp.networkTest.enums.BatteryHealthStates;
import com.startapp.networkTest.enums.BatteryStatusStates;
import java.io.Serializable;

public class BatteryInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = -937846764179533362L;
    public int BatteryCapacity;
    public BatteryChargePlugTypes BatteryChargePlug = BatteryChargePlugTypes.Unknown;
    public int BatteryCurrent;
    public BatteryHealthStates BatteryHealth = BatteryHealthStates.Unknown;
    public float BatteryLevel;
    public long BatteryRemainingEnergy;
    public BatteryStatusStates BatteryStatus = BatteryStatusStates.Unknown;
    public String BatteryTechnology = "";
    public String BatteryTemp = "";
    public int BatteryVoltage;
    public boolean MissingPermission = false;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "BatteryLevel: " + this.BatteryLevel + "% BatteryStatus: " + this.BatteryStatus + " BatteryHealth: " + this.BatteryHealth + " BatteryVoltage: " + this.BatteryVoltage + " mV BatteryTemp: " + this.BatteryTemp + " °C BatteryChargePlug: " + this.BatteryChargePlug + " BatteryTechnology: " + this.BatteryTechnology + " Battery Current " + this.BatteryCurrent + " mA BatteryCapacity " + this.BatteryCapacity + " mAh BatteryRemainingEnergy " + this.BatteryRemainingEnergy + " nWh";
    }
}
