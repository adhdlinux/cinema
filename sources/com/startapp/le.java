package com.startapp;

import android.content.Context;
import android.hardware.SensorEvent;
import com.startapp.sdk.adsbase.remoteconfig.MotionMetadata;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;

public class le extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34879a;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingDeque<SensorEvent> f34880b;

    /* renamed from: c  reason: collision with root package name */
    public final o0 f34881c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f34882d = new AtomicLong(Double.doubleToRawLongBits(0.0d));

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f34883e = new AtomicLong(Double.doubleToRawLongBits(0.0d));

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f34884f = new AtomicLong(0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public le(String str, Context context, MotionMetadata motionMetadata, int i2, double d2, long j2) {
        super(str);
        this.f34879a = context;
        o0 o0Var = r1;
        o0 o0Var2 = new o0(motionMetadata.f(), motionMetadata.g(), motionMetadata.h(), motionMetadata.i(), motionMetadata.s(), motionMetadata.t(), motionMetadata.d(), motionMetadata.e(), motionMetadata.b(), motionMetadata.a(), motionMetadata.c(), motionMetadata.o(), motionMetadata.p(), motionMetadata.m(), motionMetadata.l(), motionMetadata.n());
        o0 o0Var3 = o0Var;
        this.f34881c = o0Var3;
        o0Var3.a(d2, j2);
        this.f34880b = new LinkedBlockingDeque(i2);
    }

    public void run() {
        while (true) {
            try {
                SensorEvent take = this.f34880b.take();
                if (take != null) {
                    o0 o0Var = this.f34881c;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = take.timestamp;
                    float[] fArr = take.values;
                    o0Var.a(currentTimeMillis, j2, (double) fArr[0], (double) fArr[1], (double) fArr[2]);
                    this.f34882d.set(Double.doubleToRawLongBits(this.f34881c.f35542k.f34799i));
                    this.f34883e.set(Double.doubleToRawLongBits(this.f34881c.f35542k.f34797g));
                    this.f34884f.set(this.f34881c.f35542k.f34798h);
                } else {
                    return;
                }
            } catch (InterruptedException unused) {
                return;
            } catch (Throwable th) {
                y8.a(this.f34879a, th);
                return;
            }
        }
    }
}
