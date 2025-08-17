package androidx.work;

import android.os.Build;

public final class Constraints {

    /* renamed from: i  reason: collision with root package name */
    public static final Constraints f12136i = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private NetworkType f12137a = NetworkType.NOT_REQUIRED;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12138b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12139c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12140d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12141e;

    /* renamed from: f  reason: collision with root package name */
    private long f12142f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f12143g = -1;

    /* renamed from: h  reason: collision with root package name */
    private ContentUriTriggers f12144h = new ContentUriTriggers();

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f12145a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f12146b = false;

        /* renamed from: c  reason: collision with root package name */
        NetworkType f12147c = NetworkType.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f12148d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f12149e = false;

        /* renamed from: f  reason: collision with root package name */
        long f12150f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f12151g = -1;

        /* renamed from: h  reason: collision with root package name */
        ContentUriTriggers f12152h = new ContentUriTriggers();

        public Constraints a() {
            return new Constraints(this);
        }

        public Builder b(NetworkType networkType) {
            this.f12147c = networkType;
            return this;
        }
    }

    public Constraints() {
    }

    public ContentUriTriggers a() {
        return this.f12144h;
    }

    public NetworkType b() {
        return this.f12137a;
    }

    public long c() {
        return this.f12142f;
    }

    public long d() {
        return this.f12143g;
    }

    public boolean e() {
        return this.f12144h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.f12138b == constraints.f12138b && this.f12139c == constraints.f12139c && this.f12140d == constraints.f12140d && this.f12141e == constraints.f12141e && this.f12142f == constraints.f12142f && this.f12143g == constraints.f12143g && this.f12137a == constraints.f12137a) {
            return this.f12144h.equals(constraints.f12144h);
        }
        return false;
    }

    public boolean f() {
        return this.f12140d;
    }

    public boolean g() {
        return this.f12138b;
    }

    public boolean h() {
        return this.f12139c;
    }

    public int hashCode() {
        long j2 = this.f12142f;
        long j3 = this.f12143g;
        return (((((((((((((this.f12137a.hashCode() * 31) + (this.f12138b ? 1 : 0)) * 31) + (this.f12139c ? 1 : 0)) * 31) + (this.f12140d ? 1 : 0)) * 31) + (this.f12141e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f12144h.hashCode();
    }

    public boolean i() {
        return this.f12141e;
    }

    public void j(ContentUriTriggers contentUriTriggers) {
        this.f12144h = contentUriTriggers;
    }

    public void k(NetworkType networkType) {
        this.f12137a = networkType;
    }

    public void l(boolean z2) {
        this.f12140d = z2;
    }

    public void m(boolean z2) {
        this.f12138b = z2;
    }

    public void n(boolean z2) {
        this.f12139c = z2;
    }

    public void o(boolean z2) {
        this.f12141e = z2;
    }

    public void p(long j2) {
        this.f12142f = j2;
    }

    public void q(long j2) {
        this.f12143g = j2;
    }

    Constraints(Builder builder) {
        this.f12138b = builder.f12145a;
        int i2 = Build.VERSION.SDK_INT;
        this.f12139c = i2 >= 23 && builder.f12146b;
        this.f12137a = builder.f12147c;
        this.f12140d = builder.f12148d;
        this.f12141e = builder.f12149e;
        if (i2 >= 24) {
            this.f12144h = builder.f12152h;
            this.f12142f = builder.f12150f;
            this.f12143g = builder.f12151g;
        }
    }

    public Constraints(Constraints constraints) {
        this.f12138b = constraints.f12138b;
        this.f12139c = constraints.f12139c;
        this.f12137a = constraints.f12137a;
        this.f12140d = constraints.f12140d;
        this.f12141e = constraints.f12141e;
        this.f12144h = constraints.f12144h;
    }
}
