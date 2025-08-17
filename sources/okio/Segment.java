package okio;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Segment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f41376h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f41377a;

    /* renamed from: b  reason: collision with root package name */
    public int f41378b;

    /* renamed from: c  reason: collision with root package name */
    public int f41379c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41380d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41381e;

    /* renamed from: f  reason: collision with root package name */
    public Segment f41382f;

    /* renamed from: g  reason: collision with root package name */
    public Segment f41383g;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.f41377a = new byte[8192];
        this.f41381e = true;
        this.f41380d = false;
    }

    public final void a() {
        boolean z2;
        Segment segment = this.f41383g;
        int i2 = 0;
        if (segment != this) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Intrinsics.c(segment);
            if (segment.f41381e) {
                int i3 = this.f41379c - this.f41378b;
                Segment segment2 = this.f41383g;
                Intrinsics.c(segment2);
                int i4 = 8192 - segment2.f41379c;
                Segment segment3 = this.f41383g;
                Intrinsics.c(segment3);
                if (!segment3.f41380d) {
                    Segment segment4 = this.f41383g;
                    Intrinsics.c(segment4);
                    i2 = segment4.f41378b;
                }
                if (i3 <= i4 + i2) {
                    Segment segment5 = this.f41383g;
                    Intrinsics.c(segment5);
                    g(segment5, i3);
                    b();
                    SegmentPool.b(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final Segment b() {
        Segment segment = this.f41382f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f41383g;
        Intrinsics.c(segment2);
        segment2.f41382f = this.f41382f;
        Segment segment3 = this.f41382f;
        Intrinsics.c(segment3);
        segment3.f41383g = this.f41383g;
        this.f41382f = null;
        this.f41383g = null;
        return segment;
    }

    public final Segment c(Segment segment) {
        Intrinsics.f(segment, "segment");
        segment.f41383g = this;
        segment.f41382f = this.f41382f;
        Segment segment2 = this.f41382f;
        Intrinsics.c(segment2);
        segment2.f41383g = segment;
        this.f41382f = segment;
        return segment;
    }

    public final Segment d() {
        this.f41380d = true;
        return new Segment(this.f41377a, this.f41378b, this.f41379c, true, false);
    }

    public final Segment e(int i2) {
        boolean z2;
        Segment segment;
        if (i2 <= 0 || i2 > this.f41379c - this.f41378b) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (i2 >= 1024) {
                segment = d();
            } else {
                segment = SegmentPool.c();
                byte[] bArr = this.f41377a;
                byte[] bArr2 = segment.f41377a;
                int i3 = this.f41378b;
                byte[] unused = ArraysKt___ArraysJvmKt.g(bArr, bArr2, 0, i3, i3 + i2, 2, (Object) null);
            }
            segment.f41379c = segment.f41378b + i2;
            this.f41378b += i2;
            Segment segment2 = this.f41383g;
            Intrinsics.c(segment2);
            segment2.c(segment);
            return segment;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final Segment f() {
        byte[] bArr = this.f41377a;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.e(copyOf, "copyOf(this, size)");
        return new Segment(copyOf, this.f41378b, this.f41379c, false, true);
    }

    public final void g(Segment segment, int i2) {
        Intrinsics.f(segment, "sink");
        if (segment.f41381e) {
            int i3 = segment.f41379c;
            if (i3 + i2 > 8192) {
                if (!segment.f41380d) {
                    int i4 = segment.f41378b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = segment.f41377a;
                        byte[] unused = ArraysKt___ArraysJvmKt.g(bArr, bArr, 0, i4, i3, 2, (Object) null);
                        segment.f41379c -= segment.f41378b;
                        segment.f41378b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f41377a;
            byte[] bArr3 = segment.f41377a;
            int i5 = segment.f41379c;
            int i6 = this.f41378b;
            byte[] unused2 = ArraysKt___ArraysJvmKt.e(bArr2, bArr3, i5, i6, i6 + i2);
            segment.f41379c += i2;
            this.f41378b += i2;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] bArr, int i2, int i3, boolean z2, boolean z3) {
        Intrinsics.f(bArr, "data");
        this.f41377a = bArr;
        this.f41378b = i2;
        this.f41379c = i3;
        this.f41380d = z2;
        this.f41381e = z3;
    }
}
