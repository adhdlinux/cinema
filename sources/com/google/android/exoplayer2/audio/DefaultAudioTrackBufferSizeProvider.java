package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {

    /* renamed from: b  reason: collision with root package name */
    protected final int f23813b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f23814c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f23815d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f23816e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f23817f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23818g;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f23819a = 250000;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f23820b = 750000;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f23821c = 4;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f23822d = 250000;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f23823e = 50000000;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f23824f = 2;

        public DefaultAudioTrackBufferSizeProvider g() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.f23813b = builder.f23819a;
        this.f23814c = builder.f23820b;
        this.f23815d = builder.f23821c;
        this.f23816e = builder.f23822d;
        this.f23817f = builder.f23823e;
        this.f23818g = builder.f23824f;
    }

    protected static int b(int i2, int i3, int i4) {
        return Ints.d(((((long) i2) * ((long) i3)) * ((long) i4)) / 1000000);
    }

    protected static int d(int i2) {
        switch (i2) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int a(int i2, int i3, int i4, int i5, int i6, int i7, double d2) {
        return (((Math.max(i2, (int) (((double) c(i2, i3, i4, i5, i6, i7)) * d2)) + i5) - 1) / i5) * i5;
    }

    /* access modifiers changed from: protected */
    public int c(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 0) {
            return g(i2, i6, i5);
        }
        if (i4 == 1) {
            return e(i3);
        }
        if (i4 == 2) {
            return f(i3, i7);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        return Ints.d((((long) this.f23817f) * ((long) d(i2))) / 1000000);
    }

    /* access modifiers changed from: protected */
    public int f(int i2, int i3) {
        int i4;
        int i5 = this.f23816e;
        if (i2 == 5) {
            i5 *= this.f23818g;
        }
        if (i3 != -1) {
            i4 = IntMath.b(i3, 8, RoundingMode.CEILING);
        } else {
            i4 = d(i2);
        }
        return Ints.d((((long) i5) * ((long) i4)) / 1000000);
    }

    /* access modifiers changed from: protected */
    public int g(int i2, int i3, int i4) {
        return Util.q(i2 * this.f23815d, b(this.f23813b, i3, i4), b(this.f23814c, i3, i4));
    }
}
