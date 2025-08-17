package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
import s0.a;
import s0.j;

public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackGroup f27649a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f27650b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f27651c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27652d;

    /* renamed from: e  reason: collision with root package name */
    private final Format[] f27653e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f27654f;

    /* renamed from: g  reason: collision with root package name */
    private int f27655g;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int u(Format format, Format format2) {
        return format2.f23067i - format.f23067i;
    }

    public final Format b(int i2) {
        return this.f27653e[i2];
    }

    public final int c(int i2) {
        return this.f27651c[i2];
    }

    public void d(float f2) {
    }

    public void disable() {
    }

    public void enable() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        if (this.f27649a != baseTrackSelection.f27649a || !Arrays.equals(this.f27651c, baseTrackSelection.f27651c)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ void f() {
        j.a(this);
    }

    public final int g(int i2) {
        for (int i3 = 0; i3 < this.f27650b; i3++) {
            if (this.f27651c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final TrackGroup h() {
        return this.f27649a;
    }

    public int hashCode() {
        if (this.f27655g == 0) {
            this.f27655g = (System.identityHashCode(this.f27649a) * 31) + Arrays.hashCode(this.f27651c);
        }
        return this.f27655g;
    }

    public /* synthetic */ void i(boolean z2) {
        j.b(this, z2);
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final int k() {
        return this.f27651c[a()];
    }

    public final Format l() {
        return this.f27653e[a()];
    }

    public final int length() {
        return this.f27651c.length;
    }

    public /* synthetic */ void n() {
        j.c(this);
    }

    public boolean o(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean p2 = p(i2, elapsedRealtime);
        for (int i3 = 0; i3 < this.f27650b && !p2; i3++) {
            if (i3 == i2 || p(i3, elapsedRealtime)) {
                p2 = false;
            } else {
                p2 = true;
            }
        }
        if (!p2) {
            return false;
        }
        long[] jArr = this.f27654f;
        jArr[i2] = Math.max(jArr[i2], Util.b(elapsedRealtime, j2, Clock.MAX_TIME));
        return true;
    }

    public boolean p(int i2, long j2) {
        return this.f27654f[i2] > j2;
    }

    public /* synthetic */ boolean q(long j2, Chunk chunk, List list) {
        return j.d(this, j2, chunk, list);
    }

    public final int r(Format format) {
        for (int i2 = 0; i2 < this.f27650b; i2++) {
            if (this.f27653e[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i2) {
        int i3 = 0;
        Assertions.g(iArr.length > 0);
        this.f27652d = i2;
        this.f27649a = (TrackGroup) Assertions.e(trackGroup);
        int length = iArr.length;
        this.f27650b = length;
        this.f27653e = new Format[length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.f27653e[i4] = trackGroup.c(iArr[i4]);
        }
        Arrays.sort(this.f27653e, new a());
        this.f27651c = new int[this.f27650b];
        while (true) {
            int i5 = this.f27650b;
            if (i3 < i5) {
                this.f27651c[i3] = trackGroup.d(this.f27653e[i3]);
                i3++;
            } else {
                this.f27654f = new long[i5];
                return;
            }
        }
    }
}
