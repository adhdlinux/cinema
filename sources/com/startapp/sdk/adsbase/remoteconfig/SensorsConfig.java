package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class SensorsConfig implements Serializable {
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private BaseSensorConfig ambientTemperatureSensor = new BaseSensorConfig(14);
    private boolean enabled = false;
    @j0(complex = true)
    private BaseSensorConfig gravitySensor = new BaseSensorConfig(9);
    @j0(complex = true)
    private BaseSensorConfig gyroscopeUncalibratedSensor = new BaseSensorConfig(18);
    @j0(complex = true)
    private BaseSensorConfig lightSensor = new BaseSensorConfig(3);
    @j0(complex = true)
    private BaseSensorConfig linearAccelerationSensor = new BaseSensorConfig(9);
    @j0(complex = true)
    private BaseSensorConfig magneticFieldSensor = new BaseSensorConfig(3);
    @j0(complex = true)
    private BaseSensorConfig pressureSensor = new BaseSensorConfig(9);
    private long refreshInterval = 900000;
    @j0(complex = true)
    private BaseSensorConfig relativeHumiditySensor = new BaseSensorConfig(14);
    @j0(complex = true)
    private BaseSensorConfig rotationVectorSensor = new BaseSensorConfig(9);
    private int timeoutInSec = 10;

    public BaseSensorConfig a() {
        return this.ambientTemperatureSensor;
    }

    public BaseSensorConfig b() {
        return this.gravitySensor;
    }

    public BaseSensorConfig c() {
        return this.gyroscopeUncalibratedSensor;
    }

    public BaseSensorConfig d() {
        return this.lightSensor;
    }

    public BaseSensorConfig e() {
        return this.linearAccelerationSensor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SensorsConfig.class != obj.getClass()) {
            return false;
        }
        SensorsConfig sensorsConfig = (SensorsConfig) obj;
        if (this.timeoutInSec != sensorsConfig.timeoutInSec || this.enabled != sensorsConfig.enabled || this.refreshInterval != sensorsConfig.refreshInterval || !lb.a(this.ambientTemperatureSensor, sensorsConfig.ambientTemperatureSensor) || !lb.a(this.gravitySensor, sensorsConfig.gravitySensor) || !lb.a(this.lightSensor, sensorsConfig.lightSensor) || !lb.a(this.linearAccelerationSensor, sensorsConfig.linearAccelerationSensor) || !lb.a(this.magneticFieldSensor, sensorsConfig.magneticFieldSensor) || !lb.a(this.pressureSensor, sensorsConfig.pressureSensor) || !lb.a(this.relativeHumiditySensor, sensorsConfig.relativeHumiditySensor) || !lb.a(this.rotationVectorSensor, sensorsConfig.rotationVectorSensor) || !lb.a(this.gyroscopeUncalibratedSensor, sensorsConfig.gyroscopeUncalibratedSensor)) {
            return false;
        }
        return true;
    }

    public BaseSensorConfig f() {
        return this.magneticFieldSensor;
    }

    public BaseSensorConfig g() {
        return this.pressureSensor;
    }

    public long h() {
        return this.refreshInterval;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.timeoutInSec), Boolean.valueOf(this.enabled), Long.valueOf(this.refreshInterval), this.ambientTemperatureSensor, this.gravitySensor, this.lightSensor, this.linearAccelerationSensor, this.magneticFieldSensor, this.pressureSensor, this.relativeHumiditySensor, this.rotationVectorSensor, this.gyroscopeUncalibratedSensor};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public BaseSensorConfig i() {
        return this.relativeHumiditySensor;
    }

    public BaseSensorConfig j() {
        return this.rotationVectorSensor;
    }

    public int k() {
        return this.timeoutInSec;
    }

    public boolean l() {
        return this.enabled;
    }
}
