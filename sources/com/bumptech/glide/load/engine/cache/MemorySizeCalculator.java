package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class MemorySizeCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final int f16637a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16638b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16639c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16640d;

    public static final class Builder {

        /* renamed from: i  reason: collision with root package name */
        static final int f16641i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        final Context f16642a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f16643b;

        /* renamed from: c  reason: collision with root package name */
        ScreenDimensions f16644c;

        /* renamed from: d  reason: collision with root package name */
        float f16645d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f16646e = ((float) f16641i);

        /* renamed from: f  reason: collision with root package name */
        float f16647f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f16648g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f16649h = 4194304;

        public Builder(Context context) {
            this.f16642a = context;
            this.f16643b = (ActivityManager) context.getSystemService("activity");
            this.f16644c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.e(this.f16643b)) {
                this.f16646e = 0.0f;
            }
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }
    }

    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f16650a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f16650a = displayMetrics;
        }

        public int a() {
            return this.f16650a.heightPixels;
        }

        public int b() {
            return this.f16650a.widthPixels;
        }
    }

    interface ScreenDimensions {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        int i2;
        boolean z2;
        this.f16639c = builder.f16642a;
        if (e(builder.f16643b)) {
            i2 = builder.f16649h / 2;
        } else {
            i2 = builder.f16649h;
        }
        this.f16640d = i2;
        int c2 = c(builder.f16643b, builder.f16647f, builder.f16648g);
        float b2 = (float) (builder.f16644c.b() * builder.f16644c.a() * 4);
        int round = Math.round(builder.f16646e * b2);
        int round2 = Math.round(b2 * builder.f16645d);
        int i3 = c2 - i2;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f16638b = round2;
            this.f16637a = round;
        } else {
            float f2 = (float) i3;
            float f3 = builder.f16646e;
            float f4 = builder.f16645d;
            float f5 = f2 / (f3 + f4);
            this.f16638b = Math.round(f4 * f5);
            this.f16637a = Math.round(f5 * builder.f16646e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f16638b));
            sb.append(", pool size: ");
            sb.append(f(this.f16637a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            if (i4 > c2) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(builder.f16643b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(builder.f16643b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.f16639c, (long) i2);
    }

    public int a() {
        return this.f16640d;
    }

    public int b() {
        return this.f16637a;
    }

    public int d() {
        return this.f16638b;
    }
}
