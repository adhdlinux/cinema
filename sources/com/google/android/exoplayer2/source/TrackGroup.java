package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;

public final class TrackGroup implements Bundleable {

    /* renamed from: g  reason: collision with root package name */
    private static final String f25999g = Util.u0(0);

    /* renamed from: h  reason: collision with root package name */
    private static final String f26000h = Util.u0(1);

    /* renamed from: i  reason: collision with root package name */
    public static final Bundleable.Creator<TrackGroup> f26001i = new v();

    /* renamed from: b  reason: collision with root package name */
    public final int f26002b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26003c;

    /* renamed from: d  reason: collision with root package name */
    public final int f26004d;

    /* renamed from: e  reason: collision with root package name */
    private final Format[] f26005e;

    /* renamed from: f  reason: collision with root package name */
    private int f26006f;

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TrackGroup e(Bundle bundle) {
        ImmutableList<Format> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f25999g);
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.r();
        } else {
            immutableList = BundleableUtil.b(Format.f23059q0, parcelableArrayList);
        }
        return new TrackGroup(bundle.getString(f26000h, ""), (Format[]) immutableList.toArray(new Format[0]));
    }

    private static void f(String str, String str2, String str3, int i2) {
        Log.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i2 + ")"));
    }

    private static String g(String str) {
        if (str == null || str.equals("und")) {
            return "";
        }
        return str;
    }

    private static int h(int i2) {
        return i2 | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    private void i() {
        String g2 = g(this.f26005e[0].f23062d);
        int h2 = h(this.f26005e[0].f23064f);
        int i2 = 1;
        while (true) {
            Format[] formatArr = this.f26005e;
            if (i2 >= formatArr.length) {
                return;
            }
            if (!g2.equals(g(formatArr[i2].f23062d))) {
                Format[] formatArr2 = this.f26005e;
                f("languages", formatArr2[0].f23062d, formatArr2[i2].f23062d, i2);
                return;
            } else if (h2 != h(this.f26005e[i2].f23064f)) {
                f("role flags", Integer.toBinaryString(this.f26005e[0].f23064f), Integer.toBinaryString(this.f26005e[i2].f23064f), i2);
                return;
            } else {
                i2++;
            }
        }
    }

    public TrackGroup b(String str) {
        return new TrackGroup(str, this.f26005e);
    }

    public Format c(int i2) {
        return this.f26005e[i2];
    }

    public int d(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f26005e;
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
        if (!this.f26003c.equals(trackGroup.f26003c) || !Arrays.equals(this.f26005e, trackGroup.f26005e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f26006f == 0) {
            this.f26006f = ((527 + this.f26003c.hashCode()) * 31) + Arrays.hashCode(this.f26005e);
        }
        return this.f26006f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList(this.f26005e.length);
        for (Format i2 : this.f26005e) {
            arrayList.add(i2.i(true));
        }
        bundle.putParcelableArrayList(f25999g, arrayList);
        bundle.putString(f26000h, this.f26003c);
        return bundle;
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.a(formatArr.length > 0);
        this.f26003c = str;
        this.f26005e = formatArr;
        this.f26002b = formatArr.length;
        int k2 = MimeTypes.k(formatArr[0].f23071m);
        this.f26004d = k2 == -1 ? MimeTypes.k(formatArr[0].f23070l) : k2;
        i();
    }
}
