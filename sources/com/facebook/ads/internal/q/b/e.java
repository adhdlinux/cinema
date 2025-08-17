package com.facebook.ads.internal.q.b;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e {

    /* renamed from: a  reason: collision with root package name */
    static final int f20722a;

    /* renamed from: b  reason: collision with root package name */
    static final ExecutorService f20723b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f20724c = true;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f20725d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f20726e;

    /* renamed from: f  reason: collision with root package name */
    private final a f20727f = new d();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f20722a = availableProcessors;
        f20723b = Executors.newFixedThreadPool(availableProcessors);
    }

    public e(Bitmap bitmap) {
        this.f20725d = bitmap;
    }

    public Bitmap a() {
        return this.f20726e;
    }

    public Bitmap a(int i2) {
        Bitmap a2 = this.f20727f.a(this.f20725d, (float) i2);
        this.f20726e = a2;
        return a2;
    }
}
