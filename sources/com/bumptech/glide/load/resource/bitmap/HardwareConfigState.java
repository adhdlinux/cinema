package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

public final class HardwareConfigState {

    /* renamed from: f  reason: collision with root package name */
    private static final File f16856f = new File("/proc/self/fd");

    /* renamed from: g  reason: collision with root package name */
    private static volatile HardwareConfigState f16857g;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16858a = d();

    /* renamed from: b  reason: collision with root package name */
    private final int f16859b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16860c;

    /* renamed from: d  reason: collision with root package name */
    private int f16861d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16862e = true;

    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16859b = 20000;
            this.f16860c = 0;
            return;
        }
        this.f16859b = TypefaceStyle.BOLD;
        this.f16860c = 128;
    }

    public static HardwareConfigState a() {
        if (f16857g == null) {
            synchronized (HardwareConfigState.class) {
                if (f16857g == null) {
                    f16857g = new HardwareConfigState();
                }
            }
        }
        return f16857g;
    }

    private synchronized boolean b() {
        boolean z2 = true;
        int i2 = this.f16861d + 1;
        this.f16861d = i2;
        if (i2 >= 50) {
            this.f16861d = 0;
            int length = f16856f.list().length;
            if (length >= this.f16859b) {
                z2 = false;
            }
            this.f16862e = z2;
            if (!z2 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f16859b);
            }
        }
        return this.f16862e;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c2 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public boolean c(int i2, int i3, boolean z2, boolean z3) {
        int i4;
        if (!z2 || !this.f16858a || Build.VERSION.SDK_INT < 26 || z3 || i2 < (i4 = this.f16860c) || i3 < i4 || !b()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean e(int i2, int i3, BitmapFactory.Options options, boolean z2, boolean z3) {
        boolean c2 = c(i2, i3, z2, z3);
        if (c2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c2;
    }
}
