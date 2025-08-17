package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.common.time.Clock;

public final class SeekParameters {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekParameters f5510c;

    /* renamed from: d  reason: collision with root package name */
    public static final SeekParameters f5511d = new SeekParameters(Clock.MAX_TIME, Clock.MAX_TIME);

    /* renamed from: e  reason: collision with root package name */
    public static final SeekParameters f5512e = new SeekParameters(Clock.MAX_TIME, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final SeekParameters f5513f = new SeekParameters(0, Clock.MAX_TIME);

    /* renamed from: g  reason: collision with root package name */
    public static final SeekParameters f5514g;

    /* renamed from: a  reason: collision with root package name */
    public final long f5515a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5516b;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        f5510c = seekParameters;
        f5514g = seekParameters;
    }

    public SeekParameters(long j2, long j3) {
        boolean z2;
        boolean z3 = true;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        Assertions.a(j3 < 0 ? false : z3);
        this.f5515a = j2;
        this.f5516b = j3;
    }

    public long a(long j2, long j3, long j4) {
        boolean z2;
        long j5 = this.f5515a;
        if (j5 == 0 && this.f5516b == 0) {
            return j2;
        }
        long n12 = Util.n1(j2, j5, Long.MIN_VALUE);
        long b2 = Util.b(j2, this.f5516b, Clock.MAX_TIME);
        boolean z3 = true;
        if (n12 > j3 || j3 > b2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (n12 > j4 || j4 > b2) {
            z3 = false;
        }
        if (!z2 || !z3) {
            if (z2) {
                return j3;
            }
            if (z3) {
                return j4;
            }
            return n12;
        } else if (Math.abs(j3 - j2) <= Math.abs(j4 - j2)) {
            return j3;
        } else {
            return j4;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        if (this.f5515a == seekParameters.f5515a && this.f5516b == seekParameters.f5516b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f5515a) * 31) + ((int) this.f5516b);
    }
}
