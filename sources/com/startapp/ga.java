package com.startapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.startapp.sdk.adsbase.remoteconfig.BaseSensorConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.SensorsConfig;
import java.util.HashMap;
import org.json.JSONArray;

public class ga {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, b> f34580a = null;

    /* renamed from: b  reason: collision with root package name */
    public fa f34581b = new fa();

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f34582c;

    /* renamed from: d  reason: collision with root package name */
    public xb f34583d;

    /* renamed from: e  reason: collision with root package name */
    public int f34584e;

    /* renamed from: f  reason: collision with root package name */
    public SensorEventListener f34585f = new a();

    public class a implements SensorEventListener {
        public a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            int size;
            JSONArray jSONArray;
            fa faVar = ga.this.f34581b;
            synchronized (faVar) {
                int type = sensorEvent.sensor.getType();
                SensorEvent sensorEvent2 = faVar.f34528a.get(Integer.valueOf(type));
                if (sensorEvent2 == null || sensorEvent2.accuracy <= sensorEvent.accuracy) {
                    faVar.f34528a.put(Integer.valueOf(type), sensorEvent);
                }
                size = faVar.f34528a.size();
            }
            ga gaVar = ga.this;
            if (size == gaVar.f34584e) {
                gaVar.f34582c.unregisterListener(gaVar.f34585f);
                ga gaVar2 = ga.this;
                xb xbVar = gaVar2.f34583d;
                if (xbVar != null) {
                    try {
                        jSONArray = gaVar2.f34581b.a();
                    } catch (Exception unused) {
                        jSONArray = null;
                    }
                    xbVar.a(jSONArray);
                }
            }
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f34587a;

        /* renamed from: b  reason: collision with root package name */
        public int f34588b;

        public b(ga gaVar, int i2, int i3) {
            this.f34587a = i2;
            this.f34588b = i3;
        }
    }

    public ga(Context context, xb xbVar) {
        this.f34582c = (SensorManager) context.getSystemService("sensor");
        this.f34583d = xbVar;
        this.f34584e = 0;
        a();
    }

    public final void a() {
        this.f34580a = new HashMap<>();
        SensorsConfig C = MetaData.f36379h.C();
        a(13, C.a());
        a(9, C.b());
        a(5, C.d());
        a(10, C.e());
        a(2, C.f());
        a(6, C.g());
        a(12, C.i());
        a(11, C.j());
        a(16, C.c());
    }

    public void b() {
        Sensor defaultSensor;
        for (Integer intValue : this.f34580a.keySet()) {
            int intValue2 = intValue.intValue();
            b bVar = this.f34580a.get(Integer.valueOf(intValue2));
            if (Build.VERSION.SDK_INT >= bVar.f34587a && (defaultSensor = this.f34582c.getDefaultSensor(intValue2)) != null) {
                this.f34582c.registerListener(this.f34585f, defaultSensor, bVar.f34588b);
                this.f34584e++;
            }
        }
    }

    public final void a(int i2, BaseSensorConfig baseSensorConfig) {
        if (baseSensorConfig.c()) {
            this.f34580a.put(Integer.valueOf(i2), new b(this, baseSensorConfig.b(), baseSensorConfig.a()));
        }
    }
}
