package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class i implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private final m f15802a;

    /* renamed from: b  reason: collision with root package name */
    private final SensorManager f15803b;

    /* renamed from: c  reason: collision with root package name */
    private final Sensor f15804c;

    /* renamed from: d  reason: collision with root package name */
    private final a f15805d;

    /* renamed from: e  reason: collision with root package name */
    private float f15806e;

    public interface a {
        void b();

        void c();
    }

    public i(m mVar, a aVar) {
        this.f15802a = mVar;
        SensorManager sensorManager = (SensorManager) mVar.L().getSystemService("sensor");
        this.f15803b = sensorManager;
        this.f15804c = sensorManager.getDefaultSensor(1);
        this.f15805d = aVar;
    }

    public void a() {
        this.f15803b.unregisterListener(this);
        this.f15803b.registerListener(this, this.f15804c, (int) TimeUnit.MILLISECONDS.toMicros(50));
        this.f15802a.aj().unregisterReceiver(this);
        this.f15802a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f15802a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void b() {
        this.f15802a.aj().unregisterReceiver(this);
        this.f15803b.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f15803b.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f2 = this.f15806e;
            float f3 = (f2 * 0.5f) + (max * 0.5f);
            this.f15806e = f3;
            if (f2 < 0.8f && f3 > 0.8f) {
                this.f15805d.c();
            } else if (f2 > -0.8f && f3 < -0.8f) {
                this.f15805d.b();
            }
        }
    }
}
