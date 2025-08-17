package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekParameters f23452c;

    /* renamed from: d  reason: collision with root package name */
    public static final SeekParameters f23453d = new SeekParameters(Clock.MAX_TIME, Clock.MAX_TIME);

    /* renamed from: e  reason: collision with root package name */
    public static final SeekParameters f23454e = new SeekParameters(Clock.MAX_TIME, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final SeekParameters f23455f = new SeekParameters(0, Clock.MAX_TIME);

    /* renamed from: g  reason: collision with root package name */
    public static final SeekParameters f23456g;

    /* renamed from: a  reason: collision with root package name */
    public final long f23457a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23458b;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        f23452c = seekParameters;
        f23456g = seekParameters;
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
        this.f23457a = j2;
        this.f23458b = j3;
    }

    public long a(long j2, long j3, long j4) {
        boolean z2;
        long j5 = this.f23457a;
        if (j5 == 0 && this.f23458b == 0) {
            return j2;
        }
        long a12 = Util.a1(j2, j5, Long.MIN_VALUE);
        long b2 = Util.b(j2, this.f23458b, Clock.MAX_TIME);
        boolean z3 = true;
        if (a12 > j3 || j3 > b2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (a12 > j4 || j4 > b2) {
            z3 = false;
        }
        if (!z2 || !z3) {
            if (z2) {
                return j3;
            }
            if (z3) {
                return j4;
            }
            return a12;
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
        if (this.f23457a == seekParameters.f23457a && this.f23458b == seekParameters.f23458b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f23457a) * 31) + ((int) this.f23458b);
    }
}
