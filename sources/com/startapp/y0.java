package com.startapp;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.enums.BatteryChargePlugTypes;
import com.startapp.networkTest.enums.BatteryHealthStates;
import com.startapp.networkTest.enums.BatteryStatusStates;

public class y0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36933a = "y0";

    /* renamed from: b  reason: collision with root package name */
    private BatteryManager f36934b;

    /* renamed from: c  reason: collision with root package name */
    private Context f36935c;

    public y0(Context context) {
        this.f36934b = (BatteryManager) context.getSystemService("batterymanager");
        this.f36935c = context;
    }

    public BatteryInfo a() {
        BatteryChargePlugTypes batteryChargePlugTypes;
        BatteryHealthStates batteryHealthStates;
        Intent intent = null;
        try {
            intent = this.f36935c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable th) {
            l2.a(th);
        }
        BatteryInfo batteryInfo = new BatteryInfo();
        if (intent == null) {
            batteryInfo.MissingPermission = true;
            return batteryInfo;
        }
        int intExtra = intent.getIntExtra("status", 1);
        BatteryStatusStates batteryStatusStates = BatteryStatusStates.Unknown;
        if (intExtra == 2) {
            batteryStatusStates = BatteryStatusStates.Charging;
        } else if (intExtra == 3) {
            batteryStatusStates = BatteryStatusStates.Discharging;
        } else if (intExtra == 4) {
            batteryStatusStates = BatteryStatusStates.NotCharging;
        } else if (intExtra == 5) {
            batteryStatusStates = BatteryStatusStates.Full;
        }
        batteryInfo.BatteryStatus = batteryStatusStates;
        int intExtra2 = intent.getIntExtra("plugged", -1);
        if (intExtra2 == 1) {
            batteryChargePlugTypes = BatteryChargePlugTypes.AC;
        } else if (intExtra2 == 2) {
            batteryChargePlugTypes = BatteryChargePlugTypes.USB;
        } else if (intExtra2 != 4) {
            batteryChargePlugTypes = BatteryChargePlugTypes.Unknown;
        } else {
            batteryChargePlugTypes = BatteryChargePlugTypes.Wireless;
        }
        batteryInfo.BatteryChargePlug = batteryChargePlugTypes;
        batteryInfo.BatteryLevel = (((float) intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((float) intent.getIntExtra("scale", -1))) * 100.0f;
        int intExtra3 = intent.getIntExtra("health", -1);
        if (intExtra3 == 2) {
            batteryHealthStates = BatteryHealthStates.Good;
        } else if (intExtra3 == 3) {
            batteryHealthStates = BatteryHealthStates.Overheat;
        } else if (intExtra3 == 4) {
            batteryHealthStates = BatteryHealthStates.Dead;
        } else if (intExtra3 == 5) {
            batteryHealthStates = BatteryHealthStates.OverVoltage;
        } else if (intExtra3 != 7) {
            batteryHealthStates = BatteryHealthStates.Unknown;
        } else {
            batteryHealthStates = BatteryHealthStates.Cold;
        }
        batteryInfo.BatteryHealth = batteryHealthStates;
        int intExtra4 = intent.getIntExtra("temperature", -1);
        if (intExtra4 > -1) {
            batteryInfo.BatteryTemp = (((float) intExtra4) / 10.0f) + "";
        }
        int intExtra5 = intent.getIntExtra("voltage", -1);
        if (intExtra5 > -1) {
            batteryInfo.BatteryVoltage = intExtra5;
        }
        batteryInfo.BatteryTechnology = f3.a(intent.getStringExtra("technology"));
        try {
            a(batteryInfo);
        } catch (Throwable th2) {
            l2.a(th2);
        }
        return batteryInfo;
    }

    @TargetApi(21)
    private void a(BatteryInfo batteryInfo) {
        BatteryManager batteryManager = this.f36934b;
        if (batteryManager != null) {
            int intProperty = batteryManager.getIntProperty(1);
            if (intProperty != Integer.MIN_VALUE) {
                batteryInfo.BatteryCapacity = intProperty;
            }
            int intProperty2 = this.f36934b.getIntProperty(2);
            if (intProperty2 != Integer.MIN_VALUE) {
                batteryInfo.BatteryCurrent = intProperty2;
            }
            long longProperty = this.f36934b.getLongProperty(5);
            if (longProperty != Long.MIN_VALUE) {
                batteryInfo.BatteryRemainingEnergy = longProperty;
            }
        }
    }
}
