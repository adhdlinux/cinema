package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {

    /* renamed from: k  reason: collision with root package name */
    private static final Bitmap.Config f16599k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final LruPoolStrategy f16600a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f16601b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16602c;

    /* renamed from: d  reason: collision with root package name */
    private final BitmapTracker f16603d;

    /* renamed from: e  reason: collision with root package name */
    private long f16604e;

    /* renamed from: f  reason: collision with root package name */
    private long f16605f;

    /* renamed from: g  reason: collision with root package name */
    private int f16606g;

    /* renamed from: h  reason: collision with root package name */
    private int f16607h;

    /* renamed from: i  reason: collision with root package name */
    private int f16608i;

    /* renamed from: j  reason: collision with root package name */
    private int f16609j;

    private interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    LruBitmapPool(long j2, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.f16602c = j2;
        this.f16604e = j2;
        this.f16600a = lruPoolStrategy;
        this.f16601b = set;
        this.f16603d = new NullBitmapTracker();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = f16599k;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f16606g + ", misses=" + this.f16607h + ", puts=" + this.f16608i + ", evictions=" + this.f16609j + ", currentSize=" + this.f16605f + ", maxSize=" + this.f16604e + "\nStrategy=" + this.f16600a);
    }

    private void j() {
        q(this.f16604e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy l() {
        return new SizeConfigStrategy();
    }

    private synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap d2;
        f(config);
        LruPoolStrategy lruPoolStrategy = this.f16600a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f16599k;
        }
        d2 = lruPoolStrategy.d(i2, i3, config2);
        if (d2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f16600a.b(i2, i3, config));
            }
            this.f16607h++;
        } else {
            this.f16606g++;
            this.f16605f -= (long) this.f16600a.e(d2);
            this.f16603d.a(d2);
            p(d2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f16600a.b(i2, i3, config));
        }
        h();
        return d2;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j2) {
        while (this.f16605f > j2) {
            Bitmap removeLast = this.f16600a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f16605f = 0;
                return;
            }
            this.f16603d.a(removeLast);
            this.f16605f -= (long) this.f16600a.e(removeLast);
            this.f16609j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f16600a.a(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            q(n() / 2);
        }
    }

    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0);
    }

    public synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f16600a.e(bitmap)) <= this.f16604e) {
                        if (this.f16601b.contains(bitmap.getConfig())) {
                            int e2 = this.f16600a.e(bitmap);
                            this.f16600a.c(bitmap);
                            this.f16603d.b(bitmap);
                            this.f16608i++;
                            this.f16605f += (long) e2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f16600a.a(bitmap));
                            }
                            h();
                            j();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f16600a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f16601b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap m2 = m(i2, i3, config);
        if (m2 == null) {
            return g(i2, i3, config);
        }
        m2.eraseColor(0);
        return m2;
    }

    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap m2 = m(i2, i3, config);
        if (m2 == null) {
            return g(i2, i3, config);
        }
        return m2;
    }

    public long n() {
        return this.f16604e;
    }

    public LruBitmapPool(long j2) {
        this(j2, l(), k());
    }
}
