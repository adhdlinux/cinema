package com.startapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.startapp.sdk.adsbase.remoteconfig.MotionMetadata;
import com.startapp.x6;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class je {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f34775a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public final Context f34776b;

    /* renamed from: c  reason: collision with root package name */
    public final x6 f34777c;

    /* renamed from: d  reason: collision with root package name */
    public final ua<MotionMetadata> f34778d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f34779e;

    /* renamed from: f  reason: collision with root package name */
    public le f34780f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34781g;

    /* renamed from: h  reason: collision with root package name */
    public int f34782h;

    /* renamed from: i  reason: collision with root package name */
    public Sensor f34783i;

    /* renamed from: j  reason: collision with root package name */
    public final SensorEventListener f34784j = new a();

    public class a implements SensorEventListener {
        public a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            je jeVar;
            boolean z2;
            try {
                je jeVar2 = je.this;
                le leVar = jeVar2.f34780f;
                if (leVar != null) {
                    if (leVar.f34880b.offer(sensorEvent)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        jeVar2.a(8, (Throwable) null);
                    }
                }
            } catch (OutOfMemoryError unused) {
                jeVar = je.this;
                jeVar.getClass();
                jeVar.e();
            } catch (Throwable th) {
                y8.a(jeVar.f34776b, th);
            }
        }
    }

    public je(Context context, x6 x6Var, ua<MotionMetadata> uaVar, Handler handler) {
        this.f34776b = context;
        this.f34777c = x6Var;
        this.f34778d = uaVar;
        this.f34779e = handler;
    }

    public final MotionMetadata a() {
        MotionMetadata call = this.f34778d.call();
        if (call == null || !call.u()) {
            return null;
        }
        return call;
    }

    public double b() {
        MotionMetadata a2 = a();
        if (a2 == null) {
            return -1.0d;
        }
        le leVar = this.f34780f;
        if (leVar != null) {
            return Double.longBitsToDouble(leVar.f34882d.get());
        }
        return ((double) this.f34777c.getFloat("e9142de3c7cc5952", 0.0f)) * k0.a(System.currentTimeMillis(), this.f34777c.getLong("7783513af1730383", 0), a2.b(), a2.a(), a2.c(), p.a(0.0d, a2.a(), a2.c()));
    }

    public final void c() {
        if (this.f34780f != null) {
            x6.a a2 = this.f34777c.edit();
            float longBitsToDouble = (float) Double.longBitsToDouble(this.f34780f.f34883e.get());
            a2.a("e9142de3c7cc5952", Float.valueOf(longBitsToDouble));
            a2.f36915a.putFloat("e9142de3c7cc5952", longBitsToDouble);
            long j2 = this.f34780f.f34884f.get();
            a2.a("7783513af1730383", Long.valueOf(j2));
            a2.f36915a.putLong("7783513af1730383", j2);
            a2.apply();
            if (a(4)) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "MP.save";
                y8Var.f36955e = String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(b())});
                y8Var.a(this.f34776b);
            }
        }
    }

    public final void d() {
        SensorManager sensorManager;
        MotionMetadata a2 = a();
        if (a2 != null && (sensorManager = (SensorManager) this.f34776b.getSystemService("sensor")) != null && this.f34783i == null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            int min = Math.min(Math.max(10000, (int) (lb.e(a2.r()) * 1000)), 100000);
            if (defaultSensor != null && sensorManager.registerListener(this.f34784j, defaultSensor, min)) {
                this.f34783i = defaultSensor;
                double d2 = (double) this.f34777c.getFloat("e9142de3c7cc5952", 0.0f);
                long j2 = this.f34777c.getLong("7783513af1730383", 0);
                le leVar = this.f34780f;
                if (leVar != null) {
                    leVar.interrupt();
                    this.f34780f = null;
                }
                if (this.f34780f == null) {
                    le leVar2 = new le("startapp-mp-" + f34775a.incrementAndGet(), this.f34776b, a2, a2.q(), d2, j2);
                    this.f34780f = leVar2;
                    leVar2.start();
                }
                if (a(1)) {
                    y8 y8Var = new y8(z8.f36995b);
                    y8Var.f36954d = "MP.start";
                    y8Var.f36955e = defaultSensor.getName() + "," + defaultSensor.getMinDelay() + "," + defaultSensor.getPower();
                    y8Var.a(this.f34776b);
                }
            }
        }
    }

    public final void e() {
        Sensor sensor;
        SensorManager sensorManager = (SensorManager) this.f34776b.getSystemService("sensor");
        if (sensorManager != null && (sensor = this.f34783i) != null) {
            sensorManager.unregisterListener(this.f34784j, sensor);
            this.f34783i = null;
            c();
            le leVar = this.f34780f;
            if (leVar != null) {
                leVar.interrupt();
                this.f34780f = null;
            }
            if (a(2)) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "MP.stop";
                y8Var.a(this.f34776b);
            }
        }
    }

    public final boolean a(int i2) {
        MotionMetadata a2;
        if (!this.f34781g || (a2 = a()) == null || (i2 & a2.j()) == 0) {
            return false;
        }
        return true;
    }

    public final void a(int i2, Throwable th) {
        if (a(i2)) {
            int i3 = this.f34782h;
            if (!((i3 & i2) != 0)) {
                this.f34782h = i3 | i2;
                if (th != null) {
                    y8.a(this.f34776b, th);
                    return;
                }
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "MP";
                y8Var.f36955e = String.valueOf(i2);
                y8Var.a(this.f34776b);
            }
        }
    }
}
