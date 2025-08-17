package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class n implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private final int f15896a;

    /* renamed from: b  reason: collision with root package name */
    private final float f15897b;

    /* renamed from: c  reason: collision with root package name */
    private final SensorManager f15898c;

    /* renamed from: d  reason: collision with root package name */
    private final Sensor f15899d;

    /* renamed from: e  reason: collision with root package name */
    private final Sensor f15900e;

    /* renamed from: f  reason: collision with root package name */
    private final m f15901f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f15902g;

    /* renamed from: h  reason: collision with root package name */
    private float f15903h;

    public n(m mVar) {
        this.f15901f = mVar;
        SensorManager sensorManager = (SensorManager) mVar.L().getSystemService("sensor");
        this.f15898c = sensorManager;
        this.f15899d = sensorManager.getDefaultSensor(9);
        this.f15900e = sensorManager.getDefaultSensor(4);
        this.f15896a = ((Integer) mVar.a(b.dR)).intValue();
        this.f15897b = ((Float) mVar.a(b.dQ)).floatValue();
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void a() {
        this.f15898c.unregisterListener(this);
        if (((Boolean) this.f15901f.K().a(b.dO)).booleanValue()) {
            this.f15898c.registerListener(this, this.f15899d, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f15896a));
        }
        if (((Boolean) this.f15901f.K().a(b.dP)).booleanValue()) {
            this.f15898c.registerListener(this, this.f15900e, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f15896a));
        }
    }

    public float b() {
        return this.f15903h;
    }

    public float c() {
        float[] fArr = this.f15902g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f15898c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f15902g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f2 = this.f15903h * this.f15897b;
            this.f15903h = f2;
            this.f15903h = f2 + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
