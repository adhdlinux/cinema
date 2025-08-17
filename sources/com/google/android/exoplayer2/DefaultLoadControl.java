package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {

    /* renamed from: a  reason: collision with root package name */
    private final DefaultAllocator f22847a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22848b;

    /* renamed from: c  reason: collision with root package name */
    private final long f22849c;

    /* renamed from: d  reason: collision with root package name */
    private final long f22850d;

    /* renamed from: e  reason: collision with root package name */
    private final long f22851e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22852f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f22853g;

    /* renamed from: h  reason: collision with root package name */
    private final long f22854h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f22855i;

    /* renamed from: j  reason: collision with root package name */
    private int f22856j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22857k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private DefaultAllocator f22858a;

        /* renamed from: b  reason: collision with root package name */
        private int f22859b = 50000;

        /* renamed from: c  reason: collision with root package name */
        private int f22860c = 50000;

        /* renamed from: d  reason: collision with root package name */
        private int f22861d = 2500;

        /* renamed from: e  reason: collision with root package name */
        private int f22862e = 5000;

        /* renamed from: f  reason: collision with root package name */
        private int f22863f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f22864g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f22865h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f22866i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f22867j;

        public DefaultLoadControl a() {
            Assertions.g(!this.f22867j);
            this.f22867j = true;
            if (this.f22858a == null) {
                this.f22858a = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.f22858a, this.f22859b, this.f22860c, this.f22861d, this.f22862e, this.f22863f, this.f22864g, this.f22865h, this.f22866i);
        }

        public Builder b(int i2, int i3, int i4, int i5) {
            Assertions.g(!this.f22867j);
            DefaultLoadControl.k(i4, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.k(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.k(i2, i4, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.k(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.k(i3, i2, "maxBufferMs", "minBufferMs");
            this.f22859b = i2;
            this.f22860c = i3;
            this.f22861d = i4;
            this.f22862e = i5;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    /* access modifiers changed from: private */
    public static void k(int i2, int i3, String str, String str2) {
        boolean z2 = i2 >= i3;
        Assertions.b(z2, str + " cannot be less than " + str2);
    }

    private static int m(int i2) {
        switch (i2) {
            case -2:
                return 0;
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void n(boolean z2) {
        int i2 = this.f22852f;
        if (i2 == -1) {
            i2 = 13107200;
        }
        this.f22856j = i2;
        this.f22857k = false;
        if (z2) {
            this.f22847a.g();
        }
    }

    public void a() {
        n(false);
    }

    public Allocator b() {
        return this.f22847a;
    }

    public boolean c() {
        return this.f22855i;
    }

    public long d() {
        return this.f22854h;
    }

    public void e(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = this.f22852f;
        if (i2 == -1) {
            i2 = l(rendererArr, exoTrackSelectionArr);
        }
        this.f22856j = i2;
        this.f22847a.h(i2);
    }

    public boolean f(long j2, float f2, boolean z2, long j3) {
        long j4;
        long g02 = Util.g0(j2, f2);
        if (z2) {
            j4 = this.f22851e;
        } else {
            j4 = this.f22850d;
        }
        if (j3 != -9223372036854775807L) {
            j4 = Math.min(j3 / 2, j4);
        }
        if (j4 <= 0 || g02 >= j4 || (!this.f22853g && this.f22847a.f() >= this.f22856j)) {
            return true;
        }
        return false;
    }

    public void g() {
        n(true);
    }

    public void h() {
        n(true);
    }

    public boolean i(long j2, long j3, float f2) {
        boolean z2;
        boolean z3 = true;
        if (this.f22847a.f() >= this.f22856j) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j4 = this.f22848b;
        if (f2 > 1.0f) {
            j4 = Math.min(Util.b0(j4, f2), this.f22849c);
        }
        if (j3 < Math.max(j4, 500000)) {
            if (!this.f22853g && z2) {
                z3 = false;
            }
            this.f22857k = z3;
            if (!z3 && j3 < 500000) {
                Log.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.f22849c || z2) {
            this.f22857k = false;
        }
        return this.f22857k;
    }

    /* access modifiers changed from: protected */
    public int l(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < rendererArr.length; i3++) {
            if (exoTrackSelectionArr[i3] != null) {
                i2 += m(rendererArr[i3].d());
            }
        }
        return Math.max(13107200, i2);
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, int i6, boolean z2, int i7, boolean z3) {
        k(i4, 0, "bufferForPlaybackMs", "0");
        k(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        k(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i3, i2, "maxBufferMs", "minBufferMs");
        k(i7, 0, "backBufferDurationMs", "0");
        this.f22847a = defaultAllocator;
        this.f22848b = Util.F0((long) i2);
        this.f22849c = Util.F0((long) i3);
        this.f22850d = Util.F0((long) i4);
        this.f22851e = Util.F0((long) i5);
        this.f22852f = i6;
        this.f22856j = i6 == -1 ? 13107200 : i6;
        this.f22853g = z2;
        this.f22854h = Util.F0((long) i7);
        this.f22855i = z3;
    }
}
