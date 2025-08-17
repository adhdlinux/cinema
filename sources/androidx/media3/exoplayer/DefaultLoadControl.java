package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import java.util.HashMap;

public class DefaultLoadControl implements LoadControl {

    /* renamed from: a  reason: collision with root package name */
    private final DefaultAllocator f5193a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5194b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5195c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5196d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5197e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5198f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5199g;

    /* renamed from: h  reason: collision with root package name */
    private final long f5200h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f5201i;

    /* renamed from: j  reason: collision with root package name */
    private final HashMap<PlayerId, PlayerLoadingState> f5202j;

    /* renamed from: k  reason: collision with root package name */
    private long f5203k;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private DefaultAllocator f5204a;

        /* renamed from: b  reason: collision with root package name */
        private int f5205b = 50000;

        /* renamed from: c  reason: collision with root package name */
        private int f5206c = 50000;

        /* renamed from: d  reason: collision with root package name */
        private int f5207d = 2500;

        /* renamed from: e  reason: collision with root package name */
        private int f5208e = 5000;

        /* renamed from: f  reason: collision with root package name */
        private int f5209f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5210g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f5211h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5212i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5213j;

        public DefaultLoadControl a() {
            Assertions.h(!this.f5213j);
            this.f5213j = true;
            if (this.f5204a == null) {
                this.f5204a = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.f5204a, this.f5205b, this.f5206c, this.f5207d, this.f5208e, this.f5209f, this.f5210g, this.f5211h, this.f5212i);
        }

        public Builder b(int i2, boolean z2) {
            Assertions.h(!this.f5213j);
            DefaultLoadControl.k(i2, 0, "backBufferDurationMs", "0");
            this.f5211h = i2;
            this.f5212i = z2;
            return this;
        }

        public Builder c(int i2, int i3, int i4, int i5) {
            Assertions.h(!this.f5213j);
            DefaultLoadControl.k(i4, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.k(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.k(i2, i4, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.k(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.k(i3, i2, "maxBufferMs", "minBufferMs");
            this.f5205b = i2;
            this.f5206c = i3;
            this.f5207d = i4;
            this.f5208e = i5;
            return this;
        }

        public Builder d(int i2) {
            Assertions.h(!this.f5213j);
            this.f5209f = i2;
            return this;
        }
    }

    private static class PlayerLoadingState {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5214a;

        /* renamed from: b  reason: collision with root package name */
        public int f5215b;

        private PlayerLoadingState() {
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

    private static int n(int i2) {
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

    private void o(PlayerId playerId) {
        if (this.f5202j.remove(playerId) != null) {
            q();
        }
    }

    private void p(PlayerId playerId) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.f(this.f5202j.get(playerId));
        int i2 = this.f5198f;
        if (i2 == -1) {
            i2 = 13107200;
        }
        playerLoadingState.f5215b = i2;
        playerLoadingState.f5214a = false;
    }

    private void q() {
        if (this.f5202j.isEmpty()) {
            this.f5193a.g();
        } else {
            this.f5193a.h(m());
        }
    }

    public Allocator b() {
        return this.f5193a;
    }

    public boolean c(LoadControl.Parameters parameters) {
        long j2;
        long j02 = Util.j0(parameters.f5390e, parameters.f5391f);
        if (parameters.f5393h) {
            j2 = this.f5197e;
        } else {
            j2 = this.f5196d;
        }
        long j3 = parameters.f5394i;
        if (j3 != -9223372036854775807L) {
            j2 = Math.min(j3 / 2, j2);
        }
        if (j2 <= 0 || j02 >= j2 || (!this.f5199g && this.f5193a.f() >= m())) {
            return true;
        }
        return false;
    }

    public void d(PlayerId playerId) {
        boolean z2;
        long id = Thread.currentThread().getId();
        long j2 = this.f5203k;
        if (j2 == -1 || j2 == id) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.i(z2, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.f5203k = id;
        if (!this.f5202j.containsKey(playerId)) {
            this.f5202j.put(playerId, new PlayerLoadingState());
        }
        p(playerId);
    }

    public void e(PlayerId playerId) {
        o(playerId);
        if (this.f5202j.isEmpty()) {
            this.f5203k = -1;
        }
    }

    public boolean f(LoadControl.Parameters parameters) {
        boolean z2;
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.f(this.f5202j.get(parameters.f5386a));
        boolean z3 = true;
        if (this.f5193a.f() >= m()) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = this.f5194b;
        float f2 = parameters.f5391f;
        if (f2 > 1.0f) {
            j2 = Math.min(Util.e0(j2, f2), this.f5195c);
        }
        long max = Math.max(j2, 500000);
        long j3 = parameters.f5390e;
        if (j3 < max) {
            if (!this.f5199g && z2) {
                z3 = false;
            }
            playerLoadingState.f5214a = z3;
            if (!z3 && j3 < 500000) {
                Log.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.f5195c || z2) {
            playerLoadingState.f5214a = false;
        }
        return playerLoadingState.f5214a;
    }

    public void g(PlayerId playerId) {
        o(playerId);
    }

    public void h(PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.f(this.f5202j.get(playerId));
        int i2 = this.f5198f;
        if (i2 == -1) {
            i2 = l(rendererArr, exoTrackSelectionArr);
        }
        playerLoadingState.f5215b = i2;
        q();
    }

    public boolean i(PlayerId playerId) {
        return this.f5201i;
    }

    public long j(PlayerId playerId) {
        return this.f5200h;
    }

    /* access modifiers changed from: protected */
    public int l(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < rendererArr.length; i3++) {
            if (exoTrackSelectionArr[i3] != null) {
                i2 += n(rendererArr[i3].d());
            }
        }
        return Math.max(13107200, i2);
    }

    /* access modifiers changed from: package-private */
    public int m() {
        int i2 = 0;
        for (PlayerLoadingState playerLoadingState : this.f5202j.values()) {
            i2 += playerLoadingState.f5215b;
        }
        return i2;
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, int i6, boolean z2, int i7, boolean z3) {
        k(i4, 0, "bufferForPlaybackMs", "0");
        k(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        k(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i3, i2, "maxBufferMs", "minBufferMs");
        k(i7, 0, "backBufferDurationMs", "0");
        this.f5193a = defaultAllocator;
        this.f5194b = Util.P0((long) i2);
        this.f5195c = Util.P0((long) i3);
        this.f5196d = Util.P0((long) i4);
        this.f5197e = Util.P0((long) i5);
        this.f5198f = i6;
        this.f5199g = z2;
        this.f5200h = Util.P0((long) i7);
        this.f5201i = z3;
        this.f5202j = new HashMap<>();
        this.f5203k = -1;
    }
}
