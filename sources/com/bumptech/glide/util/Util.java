package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class Util {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f17154a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f17155b = new char[64];

    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17156a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17156a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17156a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17156a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f17156a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f17156a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.Util.AnonymousClass1.<clinit>():void");
        }
    }

    private Util() {
    }

    public static void a() {
        if (!p()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj instanceof Model) {
            return ((Model) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String d(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = f17154a;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> e(int i2) {
        return new ArrayDeque(i2);
    }

    public static int f(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * h(config);
    }

    @TargetApi(19)
    public static int g(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        } else {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
    }

    private static int h(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = AnonymousClass1.f17156a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        if (i2 != 4) {
            return 4;
        }
        return 8;
    }

    public static <T> List<T> i(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static int j(float f2) {
        return k(f2, 17);
    }

    public static int k(float f2, int i2) {
        return l(Float.floatToIntBits(f2), i2);
    }

    public static int l(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int m(Object obj, int i2) {
        return l(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int n(boolean z2, int i2) {
        return l(z2 ? 1 : 0, i2);
    }

    public static boolean o() {
        return !p();
    }

    public static boolean p() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean q(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean r(int i2, int i3) {
        return q(i2) && q(i3);
    }

    public static String s(byte[] bArr) {
        String d2;
        char[] cArr = f17155b;
        synchronized (cArr) {
            d2 = d(bArr, cArr);
        }
        return d2;
    }
}
