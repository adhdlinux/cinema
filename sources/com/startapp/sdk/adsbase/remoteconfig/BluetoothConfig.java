package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import org.joda.time.DateTimeConstants;

public class BluetoothConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int discoveryIntervalInMinutes = DateTimeConstants.MINUTES_PER_DAY;
    private boolean enabled = false;
    private long refreshInterval = 900000;
    private int timeoutInSec = 20;

    public int a() {
        return this.discoveryIntervalInMinutes;
    }

    public long b() {
        return this.refreshInterval;
    }

    public int c() {
        return this.timeoutInSec;
    }

    public boolean d() {
        return this.enabled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BluetoothConfig.class != obj.getClass()) {
            return false;
        }
        BluetoothConfig bluetoothConfig = (BluetoothConfig) obj;
        if (this.timeoutInSec == bluetoothConfig.timeoutInSec && this.enabled == bluetoothConfig.enabled && this.discoveryIntervalInMinutes == bluetoothConfig.discoveryIntervalInMinutes && this.refreshInterval == bluetoothConfig.refreshInterval) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.timeoutInSec), Boolean.valueOf(this.enabled), Integer.valueOf(this.discoveryIntervalInMinutes), Long.valueOf(this.refreshInterval)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
