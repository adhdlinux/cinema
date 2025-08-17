package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import com.google.common.primitives.Ints;

public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {

    /* renamed from: b  reason: collision with root package name */
    protected final int f5807b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f5808c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f5809d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f5810e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f5811f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5812g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5813h;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f5814a = 250000;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f5815b = 750000;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f5816c = 4;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f5817d = 250000;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f5818e = 50000000;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f5819f = 2;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f5820g = 4;

        public DefaultAudioTrackBufferSizeProvider h() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.f5807b = builder.f5814a;
        this.f5808c = builder.f5815b;
        this.f5809d = builder.f5816c;
        this.f5810e = builder.f5817d;
        this.f5811f = builder.f5818e;
        this.f5812g = builder.f5819f;
        this.f5813h = builder.f5820g;
    }

    protected static int b(int i2, int i3, int i4) {
        return Ints.d(((((long) i2) * ((long) i3)) * ((long) i4)) / 1000000);
    }

    protected static int d(int i2) {
        if (i2 == 20) {
            return 63750;
        }
        if (i2 == 30) {
            return 2250000;
        }
        switch (i2) {
            case 5:
                return 80000;
            case 6:
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
            default:
                switch (i2) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        throw new IllegalArgumentException();
                }
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
        return Ints.d((((long) this.f5811f) * ((long) d(i2))) / 1000000);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.f5810e
            r1 = 5
            r2 = 8
            if (r4 != r1) goto L_0x000c
            int r1 = r3.f5812g
        L_0x0009:
            int r0 = r0 * r1
            goto L_0x0011
        L_0x000c:
            if (r4 != r2) goto L_0x0011
            int r1 = r3.f5813h
            goto L_0x0009
        L_0x0011:
            r1 = -1
            if (r5 == r1) goto L_0x001b
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            int r4 = com.google.common.math.IntMath.b(r5, r2, r4)
            goto L_0x001f
        L_0x001b:
            int r4 = d(r4)
        L_0x001f:
            long r0 = (long) r0
            long r4 = (long) r4
            long r0 = r0 * r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            int r4 = com.google.common.primitives.Ints.d(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider.f(int, int):int");
    }

    /* access modifiers changed from: protected */
    public int g(int i2, int i3, int i4) {
        return Util.p(i2 * this.f5809d, b(this.f5807b, i3, i4), b(this.f5808c, i3, i4));
    }
}
