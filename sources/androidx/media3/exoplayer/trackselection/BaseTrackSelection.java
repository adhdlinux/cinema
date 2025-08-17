package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import com.facebook.common.time.Clock;
import h.a;
import h.h;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackGroup f7362a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f7363b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f7364c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7365d;

    /* renamed from: e  reason: collision with root package name */
    private final Format[] f7366e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f7367f;

    /* renamed from: g  reason: collision with root package name */
    private int f7368g;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int u(Format format, Format format2) {
        return format2.f4010i - format.f4010i;
    }

    public final Format b(int i2) {
        return this.f7366e[i2];
    }

    public final int c(int i2) {
        return this.f7364c[i2];
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
        if (!this.f7362a.equals(baseTrackSelection.f7362a) || !Arrays.equals(this.f7364c, baseTrackSelection.f7364c)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ void f() {
        h.a(this);
    }

    public final int g(int i2) {
        for (int i3 = 0; i3 < this.f7363b; i3++) {
            if (this.f7364c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final TrackGroup h() {
        return this.f7362a;
    }

    public int hashCode() {
        if (this.f7368g == 0) {
            this.f7368g = (System.identityHashCode(this.f7362a) * 31) + Arrays.hashCode(this.f7364c);
        }
        return this.f7368g;
    }

    public /* synthetic */ void i(boolean z2) {
        h.b(this, z2);
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final int k() {
        return this.f7364c[a()];
    }

    public final Format l() {
        return this.f7366e[a()];
    }

    public final int length() {
        return this.f7364c.length;
    }

    public /* synthetic */ void n() {
        h.c(this);
    }

    public boolean o(int i2, long j2) {
        return this.f7367f[i2] > j2;
    }

    public final int p(Format format) {
        for (int i2 = 0; i2 < this.f7363b; i2++) {
            if (this.f7366e[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public boolean r(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean o2 = o(i2, elapsedRealtime);
        for (int i3 = 0; i3 < this.f7363b && !o2; i3++) {
            if (i3 == i2 || o(i3, elapsedRealtime)) {
                o2 = false;
            } else {
                o2 = true;
            }
        }
        if (!o2) {
            return false;
        }
        long[] jArr = this.f7367f;
        jArr[i2] = Math.max(jArr[i2], Util.b(elapsedRealtime, j2, Clock.MAX_TIME));
        return true;
    }

    public /* synthetic */ boolean s(long j2, Chunk chunk, List list) {
        return h.d(this, j2, chunk, list);
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i2) {
        int i3 = 0;
        Assertions.h(iArr.length > 0);
        this.f7365d = i2;
        this.f7362a = (TrackGroup) Assertions.f(trackGroup);
        int length = iArr.length;
        this.f7363b = length;
        this.f7366e = new Format[length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.f7366e[i4] = trackGroup.a(iArr[i4]);
        }
        Arrays.sort(this.f7366e, new a());
        this.f7364c = new int[this.f7363b];
        while (true) {
            int i5 = this.f7363b;
            if (i3 < i5) {
                this.f7364c[i3] = trackGroup.b(this.f7366e[i3]);
                i3++;
            } else {
                this.f7367f = new long[i5];
                return;
            }
        }
    }
}
