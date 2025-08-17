package com.facebook.ads.internal.g;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static SensorManager f20161a;

    /* renamed from: b  reason: collision with root package name */
    private static Sensor f20162b;

    /* renamed from: c  reason: collision with root package name */
    private static Sensor f20163c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile float[] f20164d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile float[] f20165e;

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, String> f20166f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private static String[] f20167g = {"x", "y", "z"};

    /* renamed from: h  reason: collision with root package name */
    private static SensorEventListener f20168h;

    /* renamed from: i  reason: collision with root package name */
    private static SensorEventListener f20169i;

    /* renamed from: com.facebook.ads.internal.g.a$a  reason: collision with other inner class name */
    private static class C0032a implements SensorEventListener {
        private C0032a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] unused = a.f20164d = sensorEvent.values;
            a.d();
        }
    }

    private static class b implements SensorEventListener {
        private b() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] unused = a.f20165e = sensorEvent.values;
            a.e();
        }
    }

    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f20166f);
        a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r5) {
        /*
            java.lang.Class<com.facebook.ads.internal.g.a> r0 = com.facebook.ads.internal.g.a.class
            monitor-enter(r0)
            b((android.content.Context) r5)     // Catch:{ all -> 0x0064 }
            c(r5)     // Catch:{ all -> 0x0064 }
            d(r5)     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r1 = f20161a     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = "sensor"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch:{ all -> 0x0064 }
            android.hardware.SensorManager r5 = (android.hardware.SensorManager) r5     // Catch:{ all -> 0x0064 }
            f20161a = r5     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x001e
            monitor-exit(r0)
            return
        L_0x001e:
            android.hardware.Sensor r5 = f20162b     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x002b
            android.hardware.SensorManager r5 = f20161a     // Catch:{ all -> 0x0064 }
            r1 = 1
            android.hardware.Sensor r5 = r5.getDefaultSensor(r1)     // Catch:{ all -> 0x0064 }
            f20162b = r5     // Catch:{ all -> 0x0064 }
        L_0x002b:
            android.hardware.Sensor r5 = f20163c     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x0038
            android.hardware.SensorManager r5 = f20161a     // Catch:{ all -> 0x0064 }
            r1 = 4
            android.hardware.Sensor r5 = r5.getDefaultSensor(r1)     // Catch:{ all -> 0x0064 }
            f20163c = r5     // Catch:{ all -> 0x0064 }
        L_0x0038:
            android.hardware.SensorEventListener r5 = f20168h     // Catch:{ all -> 0x0064 }
            r1 = 3
            r2 = 0
            if (r5 != 0) goto L_0x004e
            com.facebook.ads.internal.g.a$a r5 = new com.facebook.ads.internal.g.a$a     // Catch:{ all -> 0x0064 }
            r5.<init>()     // Catch:{ all -> 0x0064 }
            f20168h = r5     // Catch:{ all -> 0x0064 }
            android.hardware.Sensor r3 = f20162b     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x004e
            android.hardware.SensorManager r4 = f20161a     // Catch:{ all -> 0x0064 }
            r4.registerListener(r5, r3, r1)     // Catch:{ all -> 0x0064 }
        L_0x004e:
            android.hardware.SensorEventListener r5 = f20169i     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x0062
            com.facebook.ads.internal.g.a$b r5 = new com.facebook.ads.internal.g.a$b     // Catch:{ all -> 0x0064 }
            r5.<init>()     // Catch:{ all -> 0x0064 }
            f20169i = r5     // Catch:{ all -> 0x0064 }
            android.hardware.Sensor r2 = f20163c     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0062
            android.hardware.SensorManager r3 = f20161a     // Catch:{ all -> 0x0064 }
            r3.registerListener(r5, r2, r1)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r0)
            return
        L_0x0064:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.a.a(android.content.Context):void");
    }

    private static void a(Map<String, String> map) {
        float[] fArr = f20164d;
        float[] fArr2 = f20165e;
        if (fArr != null) {
            int min = Math.min(f20167g.length, fArr.length);
            for (int i2 = 0; i2 < min; i2++) {
                map.put("accelerometer_" + f20167g[i2], String.valueOf(fArr[i2]));
            }
        }
        if (fArr2 != null) {
            int min2 = Math.min(f20167g.length, fArr2.length);
            for (int i3 = 0; i3 < min2; i3++) {
                map.put("rotation_" + f20167g[i3], String.valueOf(fArr2[i3]));
            }
        }
    }

    private static void b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f20166f.put("available_memory", String.valueOf(memoryInfo.availMem));
        f20166f.put("total_memory", String.valueOf(memoryInfo.totalMem));
    }

    private static void c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        f20166f.put("free_space", String.valueOf(((long) statFs.getAvailableBlocks()) * blockSize));
    }

    /* access modifiers changed from: private */
    public static synchronized void d() {
        synchronized (a.class) {
            SensorManager sensorManager = f20161a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(f20168h);
            }
            f20168h = null;
        }
    }

    private static void d(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            boolean z2 = intExtra3 == 2 || intExtra3 == 5;
            f20166f.put("battery", String.valueOf(intExtra2 > 0 ? (((float) intExtra) / ((float) intExtra2)) * 100.0f : 0.0f));
            f20166f.put("charging", z2 ? "1" : "0");
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void e() {
        synchronized (a.class) {
            SensorManager sensorManager = f20161a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(f20169i);
            }
            f20169i = null;
        }
    }
}
