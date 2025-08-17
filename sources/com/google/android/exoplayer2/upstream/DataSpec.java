package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DataSpec {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f28339a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28340b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28341c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f28342d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f28343e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public final long f28344f;

    /* renamed from: g  reason: collision with root package name */
    public final long f28345g;

    /* renamed from: h  reason: collision with root package name */
    public final long f28346h;

    /* renamed from: i  reason: collision with root package name */
    public final String f28347i;

    /* renamed from: j  reason: collision with root package name */
    public final int f28348j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f28349k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Uri f28350a;

        /* renamed from: b  reason: collision with root package name */
        private long f28351b;

        /* renamed from: c  reason: collision with root package name */
        private int f28352c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f28353d;

        /* renamed from: e  reason: collision with root package name */
        private Map<String, String> f28354e;

        /* renamed from: f  reason: collision with root package name */
        private long f28355f;

        /* renamed from: g  reason: collision with root package name */
        private long f28356g;

        /* renamed from: h  reason: collision with root package name */
        private String f28357h;

        /* renamed from: i  reason: collision with root package name */
        private int f28358i;

        /* renamed from: j  reason: collision with root package name */
        private Object f28359j;

        public DataSpec a() {
            Assertions.j(this.f28350a, "The uri must be set.");
            return new DataSpec(this.f28350a, this.f28351b, this.f28352c, this.f28353d, this.f28354e, this.f28355f, this.f28356g, this.f28357h, this.f28358i, this.f28359j);
        }

        public Builder b(int i2) {
            this.f28358i = i2;
            return this;
        }

        public Builder c(byte[] bArr) {
            this.f28353d = bArr;
            return this;
        }

        public Builder d(int i2) {
            this.f28352c = i2;
            return this;
        }

        public Builder e(Map<String, String> map) {
            this.f28354e = map;
            return this;
        }

        public Builder f(String str) {
            this.f28357h = str;
            return this;
        }

        public Builder g(long j2) {
            this.f28356g = j2;
            return this;
        }

        public Builder h(long j2) {
            this.f28355f = j2;
            return this;
        }

        public Builder i(Uri uri) {
            this.f28350a = uri;
            return this;
        }

        public Builder j(String str) {
            this.f28350a = Uri.parse(str);
            return this;
        }

        public Builder k(long j2) {
            this.f28351b = j2;
            return this;
        }

        public Builder() {
            this.f28352c = 1;
            this.f28354e = Collections.emptyMap();
            this.f28356g = -1;
        }

        private Builder(DataSpec dataSpec) {
            this.f28350a = dataSpec.f28339a;
            this.f28351b = dataSpec.f28340b;
            this.f28352c = dataSpec.f28341c;
            this.f28353d = dataSpec.f28342d;
            this.f28354e = dataSpec.f28343e;
            this.f28355f = dataSpec.f28345g;
            this.f28356g = dataSpec.f28346h;
            this.f28357h = dataSpec.f28347i;
            this.f28358i = dataSpec.f28348j;
            this.f28359j = dataSpec.f28349k;
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.datasource");
    }

    public static String c(int i2) {
        if (i2 == 1) {
            return "GET";
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public Builder a() {
        return new Builder();
    }

    public final String b() {
        return c(this.f28341c);
    }

    public boolean d(int i2) {
        return (this.f28348j & i2) == i2;
    }

    public DataSpec e(long j2) {
        long j3 = this.f28346h;
        long j4 = -1;
        if (j3 != -1) {
            j4 = j3 - j2;
        }
        return f(j2, j4);
    }

    public DataSpec f(long j2, long j3) {
        if (j2 == 0 && this.f28346h == j3) {
            return this;
        }
        return new DataSpec(this.f28339a, this.f28340b, this.f28341c, this.f28342d, this.f28343e, this.f28345g + j2, j3, this.f28347i, this.f28348j, this.f28349k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f28339a + ", " + this.f28345g + ", " + this.f28346h + ", " + this.f28347i + ", " + this.f28348j + "]";
    }

    public DataSpec(Uri uri) {
        this(uri, 0, -1);
    }

    public DataSpec(Uri uri, long j2, long j3) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j2, j3, (String) null, 0, (Object) null);
    }

    private DataSpec(Uri uri, long j2, int i2, byte[] bArr, Map<String, String> map, long j3, long j4, String str, int i3, Object obj) {
        long j5 = j2;
        byte[] bArr2 = bArr;
        long j6 = j3;
        long j7 = j4;
        long j8 = j5 + j6;
        boolean z2 = true;
        Assertions.a(j8 >= 0);
        Assertions.a(j6 >= 0);
        if (j7 <= 0 && j7 != -1) {
            z2 = false;
        }
        Assertions.a(z2);
        this.f28339a = uri;
        this.f28340b = j5;
        this.f28341c = i2;
        this.f28342d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f28343e = Collections.unmodifiableMap(new HashMap(map));
        this.f28345g = j6;
        this.f28344f = j8;
        this.f28346h = j7;
        this.f28347i = str;
        this.f28348j = i3;
        this.f28349k = obj;
    }
}
