package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;

public final class TrackGroup {

    /* renamed from: f  reason: collision with root package name */
    private static final String f4388f = Util.B0(0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f4389g = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final int f4390a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4391b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4392c;

    /* renamed from: d  reason: collision with root package name */
    private final Format[] f4393d;

    /* renamed from: e  reason: collision with root package name */
    private int f4394e;

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    private static void c(String str, String str2, String str3, int i2) {
        Log.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i2 + ")"));
    }

    private static String d(String str) {
        if (str == null || str.equals("und")) {
            return "";
        }
        return str;
    }

    private static int e(int i2) {
        return i2 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    private void f() {
        String d2 = d(this.f4393d[0].f4005d);
        int e2 = e(this.f4393d[0].f4007f);
        int i2 = 1;
        while (true) {
            Format[] formatArr = this.f4393d;
            if (i2 >= formatArr.length) {
                return;
            }
            if (!d2.equals(d(formatArr[i2].f4005d))) {
                Format[] formatArr2 = this.f4393d;
                c("languages", formatArr2[0].f4005d, formatArr2[i2].f4005d, i2);
                return;
            } else if (e2 != e(this.f4393d[i2].f4007f)) {
                c("role flags", Integer.toBinaryString(this.f4393d[0].f4007f), Integer.toBinaryString(this.f4393d[i2].f4007f), i2);
                return;
            } else {
                i2++;
            }
        }
    }

    public Format a(int i2) {
        return this.f4393d[i2];
    }

    public int b(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f4393d;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (!this.f4391b.equals(trackGroup.f4391b) || !Arrays.equals(this.f4393d, trackGroup.f4393d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f4394e == 0) {
            this.f4394e = ((527 + this.f4391b.hashCode()) * 31) + Arrays.hashCode(this.f4393d);
        }
        return this.f4394e;
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.a(formatArr.length > 0);
        this.f4391b = str;
        this.f4393d = formatArr;
        this.f4390a = formatArr.length;
        int k2 = MimeTypes.k(formatArr[0].f4015n);
        this.f4392c = k2 == -1 ? MimeTypes.k(formatArr[0].f4014m) : k2;
        f();
    }
}
