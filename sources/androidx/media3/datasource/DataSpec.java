package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DataSpec {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f4823a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4824b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4825c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f4826d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f4827e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public final long f4828f;

    /* renamed from: g  reason: collision with root package name */
    public final long f4829g;

    /* renamed from: h  reason: collision with root package name */
    public final long f4830h;

    /* renamed from: i  reason: collision with root package name */
    public final String f4831i;

    /* renamed from: j  reason: collision with root package name */
    public final int f4832j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f4833k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Uri f4834a;

        /* renamed from: b  reason: collision with root package name */
        private long f4835b;

        /* renamed from: c  reason: collision with root package name */
        private int f4836c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f4837d;

        /* renamed from: e  reason: collision with root package name */
        private Map<String, String> f4838e;

        /* renamed from: f  reason: collision with root package name */
        private long f4839f;

        /* renamed from: g  reason: collision with root package name */
        private long f4840g;

        /* renamed from: h  reason: collision with root package name */
        private String f4841h;

        /* renamed from: i  reason: collision with root package name */
        private int f4842i;

        /* renamed from: j  reason: collision with root package name */
        private Object f4843j;

        public DataSpec a() {
            Assertions.k(this.f4834a, "The uri must be set.");
            return new DataSpec(this.f4834a, this.f4835b, this.f4836c, this.f4837d, this.f4838e, this.f4839f, this.f4840g, this.f4841h, this.f4842i, this.f4843j);
        }

        public Builder b(int i2) {
            this.f4842i = i2;
            return this;
        }

        public Builder c(byte[] bArr) {
            this.f4837d = bArr;
            return this;
        }

        public Builder d(int i2) {
            this.f4836c = i2;
            return this;
        }

        public Builder e(Map<String, String> map) {
            this.f4838e = map;
            return this;
        }

        public Builder f(String str) {
            this.f4841h = str;
            return this;
        }

        public Builder g(long j2) {
            this.f4840g = j2;
            return this;
        }

        public Builder h(long j2) {
            this.f4839f = j2;
            return this;
        }

        public Builder i(Uri uri) {
            this.f4834a = uri;
            return this;
        }

        public Builder j(String str) {
            this.f4834a = Uri.parse(str);
            return this;
        }

        public Builder k(long j2) {
            this.f4835b = j2;
            return this;
        }

        public Builder() {
            this.f4836c = 1;
            this.f4838e = Collections.emptyMap();
            this.f4840g = -1;
        }

        private Builder(DataSpec dataSpec) {
            this.f4834a = dataSpec.f4823a;
            this.f4835b = dataSpec.f4824b;
            this.f4836c = dataSpec.f4825c;
            this.f4837d = dataSpec.f4826d;
            this.f4838e = dataSpec.f4827e;
            this.f4839f = dataSpec.f4829g;
            this.f4840g = dataSpec.f4830h;
            this.f4841h = dataSpec.f4831i;
            this.f4842i = dataSpec.f4832j;
            this.f4843j = dataSpec.f4833k;
        }
    }

    static {
        MediaLibraryInfo.a("media3.datasource");
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
        return c(this.f4825c);
    }

    public boolean d(int i2) {
        return (this.f4832j & i2) == i2;
    }

    public DataSpec e(long j2) {
        long j3 = this.f4830h;
        long j4 = -1;
        if (j3 != -1) {
            j4 = j3 - j2;
        }
        return f(j2, j4);
    }

    public DataSpec f(long j2, long j3) {
        if (j2 == 0 && this.f4830h == j3) {
            return this;
        }
        return new DataSpec(this.f4823a, this.f4824b, this.f4825c, this.f4826d, this.f4827e, this.f4829g + j2, j3, this.f4831i, this.f4832j, this.f4833k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f4823a + ", " + this.f4829g + ", " + this.f4830h + ", " + this.f4831i + ", " + this.f4832j + "]";
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
        this.f4823a = (Uri) Assertions.f(uri);
        this.f4824b = j5;
        this.f4825c = i2;
        this.f4826d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f4827e = Collections.unmodifiableMap(new HashMap(map));
        this.f4829g = j6;
        this.f4828f = j8;
        this.f4830h = j7;
        this.f4831i = str;
        this.f4832j = i3;
        this.f4833k = obj;
    }
}
