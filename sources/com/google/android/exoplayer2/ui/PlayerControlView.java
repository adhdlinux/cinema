package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.x1;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import t0.c;
import t0.d;

public class PlayerControlView extends FrameLayout {
    private final String A;
    private final Drawable B;
    private final Drawable C;
    private final float D;
    private final float E;
    private final String F;
    private final String G;
    /* access modifiers changed from: private */
    public Player H;
    private boolean I;
    private boolean J;
    private boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    private int M;
    private int N;
    /* access modifiers changed from: private */
    public int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private long U;
    private long[] V;
    private boolean[] W;

    /* renamed from: a0  reason: collision with root package name */
    private long[] f27878a0;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentListener f27879b;

    /* renamed from: b0  reason: collision with root package name */
    private boolean[] f27880b0;

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<VisibilityListener> f27881c;

    /* renamed from: c0  reason: collision with root package name */
    private long f27882c0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f27883d;

    /* renamed from: d0  reason: collision with root package name */
    private long f27884d0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f27885e;

    /* renamed from: e0  reason: collision with root package name */
    private long f27886e0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View f27887f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final View f27888g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final View f27889h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final View f27890i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f27891j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final ImageView f27892k;

    /* renamed from: l  reason: collision with root package name */
    private final View f27893l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f27894m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final TextView f27895n;

    /* renamed from: o  reason: collision with root package name */
    private final TimeBar f27896o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final StringBuilder f27897p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Formatter f27898q;

    /* renamed from: r  reason: collision with root package name */
    private final Timeline.Period f27899r;

    /* renamed from: s  reason: collision with root package name */
    private final Timeline.Window f27900s;

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f27901t;

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f27902u;

    /* renamed from: v  reason: collision with root package name */
    private final Drawable f27903v;

    /* renamed from: w  reason: collision with root package name */
    private final Drawable f27904w;

    /* renamed from: x  reason: collision with root package name */
    private final Drawable f27905x;

    /* renamed from: y  reason: collision with root package name */
    private final String f27906y;

    /* renamed from: z  reason: collision with root package name */
    private final String f27907z;

    private static final class Api21 {
        private Api21() {
        }

        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener {
        private ComponentListener() {
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            x1.c(this, commands);
        }

        public void onClick(View view) {
            Player d2 = PlayerControlView.this.H;
            if (d2 != null) {
                if (PlayerControlView.this.f27885e == view) {
                    d2.w();
                } else if (PlayerControlView.this.f27883d == view) {
                    d2.j();
                } else if (PlayerControlView.this.f27889h == view) {
                    if (d2.getPlaybackState() != 4) {
                        d2.Q();
                    }
                } else if (PlayerControlView.this.f27890i == view) {
                    d2.R();
                } else if (PlayerControlView.this.f27887f == view) {
                    PlayerControlView.this.C(d2);
                } else if (PlayerControlView.this.f27888g == view) {
                    PlayerControlView.this.B(d2);
                } else if (PlayerControlView.this.f27891j == view) {
                    d2.setRepeatMode(RepeatModeUtil.a(d2.getRepeatMode(), PlayerControlView.this.O));
                } else if (PlayerControlView.this.f27892k == view) {
                    d2.B(!d2.O());
                }
            }
        }

        public /* synthetic */ void onCues(CueGroup cueGroup) {
            x1.d(this, cueGroup);
        }

        public /* synthetic */ void onCues(List list) {
            x1.e(this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            x1.f(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            x1.g(this, i2, z2);
        }

        public void onEvents(Player player, Player.Events events) {
            if (events.b(4, 5)) {
                PlayerControlView.this.T();
            }
            if (events.b(4, 5, 7)) {
                PlayerControlView.this.U();
            }
            if (events.a(8)) {
                PlayerControlView.this.V();
            }
            if (events.a(9)) {
                PlayerControlView.this.W();
            }
            if (events.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.S();
            }
            if (events.b(11, 0)) {
                PlayerControlView.this.X();
            }
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            x1.i(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            x1.j(this, z2);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            x1.k(this, z2);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i2) {
            x1.m(this, mediaItem, i2);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            x1.n(this, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(Metadata metadata) {
            x1.o(this, metadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
            x1.p(this, z2, i2);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            x1.q(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i2) {
            x1.r(this, i2);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            x1.s(this, i2);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            x1.t(this, playbackException);
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            x1.u(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            x1.v(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            x1.x(this, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            x1.y(this, positionInfo, positionInfo2, i2);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            x1.z(this);
        }

        public /* synthetic */ void onRepeatModeChanged(int i2) {
            x1.A(this, i2);
        }

        public /* synthetic */ void onSeekProcessed() {
            x1.D(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            x1.E(this, z2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            x1.F(this, z2);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
            x1.G(this, i2, i3);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i2) {
            x1.H(this, timeline, i2);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            x1.I(this, trackSelectionParameters);
        }

        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            x1.J(this, tracks);
        }

        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            x1.K(this, videoSize);
        }

        public /* synthetic */ void onVolumeChanged(float f2) {
            x1.L(this, f2);
        }

        public void p(TimeBar timeBar, long j2) {
            if (PlayerControlView.this.f27895n != null) {
                PlayerControlView.this.f27895n.setText(Util.i0(PlayerControlView.this.f27897p, PlayerControlView.this.f27898q, j2));
            }
        }

        public void r(TimeBar timeBar, long j2, boolean z2) {
            boolean unused = PlayerControlView.this.L = false;
            if (!z2 && PlayerControlView.this.H != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.N(playerControlView.H, j2);
            }
        }

        public void u(TimeBar timeBar, long j2) {
            boolean unused = PlayerControlView.this.L = true;
            if (PlayerControlView.this.f27895n != null) {
                PlayerControlView.this.f27895n.setText(Util.i0(PlayerControlView.this.f27897p, PlayerControlView.this.f27898q, j2));
            }
        }
    }

    public interface ProgressUpdateListener {
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i2);
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.ui");
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* access modifiers changed from: private */
    public void B(Player player) {
        player.pause();
    }

    /* access modifiers changed from: private */
    public void C(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            player.prepare();
        } else if (playbackState == 4) {
            M(player, player.M(), -9223372036854775807L);
        }
        player.play();
    }

    private void D(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.A()) {
            C(player);
        } else {
            B(player);
        }
    }

    private static int E(TypedArray typedArray, int i2) {
        return typedArray.getInt(R$styleable.f28076z, i2);
    }

    private void G() {
        removeCallbacks(this.f27902u);
        if (this.M > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.M;
            this.U = uptimeMillis + ((long) i2);
            if (this.I) {
                postDelayed(this.f27902u, (long) i2);
                return;
            }
            return;
        }
        this.U = -9223372036854775807L;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean H(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    private void K() {
        View view;
        View view2;
        boolean O2 = O();
        if (!O2 && (view2 = this.f27887f) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (O2 && (view = this.f27888g) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    private void L() {
        View view;
        View view2;
        boolean O2 = O();
        if (!O2 && (view2 = this.f27887f) != null) {
            view2.requestFocus();
        } else if (O2 && (view = this.f27888g) != null) {
            view.requestFocus();
        }
    }

    private void M(Player player, int i2, long j2) {
        player.y(i2, j2);
    }

    /* access modifiers changed from: private */
    public void N(Player player, long j2) {
        int i2;
        Timeline t2 = player.t();
        if (this.K && !t2.u()) {
            int t3 = t2.t();
            i2 = 0;
            while (true) {
                long f2 = t2.r(i2, this.f27900s).f();
                if (j2 < f2) {
                    break;
                } else if (i2 == t3 - 1) {
                    j2 = f2;
                    break;
                } else {
                    j2 -= f2;
                    i2++;
                }
            }
        } else {
            i2 = player.M();
        }
        M(player, i2, j2);
        U();
    }

    private boolean O() {
        Player player = this.H;
        if (player == null || player.getPlaybackState() == 4 || this.H.getPlaybackState() == 1 || !this.H.A()) {
            return false;
        }
        return true;
    }

    private void Q() {
        T();
        S();
        V();
        W();
        X();
    }

    private void R(boolean z2, boolean z3, View view) {
        float f2;
        int i2;
        if (view != null) {
            view.setEnabled(z3);
            if (z3) {
                f2 = this.D;
            } else {
                f2 = this.E;
            }
            view.setAlpha(f2);
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (I() && this.I) {
            Player player = this.H;
            if (player != null) {
                z5 = player.q(5);
                z4 = player.q(7);
                z3 = player.q(11);
                z2 = player.q(12);
                z6 = player.q(9);
            } else {
                z5 = false;
                z6 = false;
                z4 = false;
                z3 = false;
                z2 = false;
            }
            R(this.R, z4, this.f27883d);
            R(this.P, z3, this.f27890i);
            R(this.Q, z2, this.f27889h);
            R(this.S, z6, this.f27885e);
            TimeBar timeBar = this.f27896o;
            if (timeBar != null) {
                timeBar.setEnabled(z5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void T() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        if (I() && this.I) {
            boolean O2 = O();
            View view = this.f27887f;
            int i3 = 8;
            boolean z7 = true;
            if (view != null) {
                if (!O2 || !view.isFocused()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                z3 = z5 | false;
                if (Util.f28808a < 21) {
                    z6 = z3;
                } else if (!O2 || !Api21.a(this.f27887f)) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                z2 = z6 | false;
                View view2 = this.f27887f;
                if (O2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            } else {
                z3 = false;
                z2 = false;
            }
            View view3 = this.f27888g;
            if (view3 != null) {
                if (O2 || !view3.isFocused()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                z3 |= z4;
                if (Util.f28808a < 21) {
                    z7 = z3;
                } else if (O2 || !Api21.a(this.f27888g)) {
                    z7 = false;
                }
                z2 |= z7;
                View view4 = this.f27888g;
                if (O2) {
                    i3 = 0;
                }
                view4.setVisibility(i3);
            }
            if (z3) {
                L();
            }
            if (z2) {
                K();
            }
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        long j2;
        long j3;
        boolean z2;
        int i2;
        long j4;
        if (I() && this.I) {
            Player player = this.H;
            if (player != null) {
                j3 = this.f27882c0 + player.K();
                j2 = this.f27882c0 + player.P();
            } else {
                j3 = 0;
                j2 = 0;
            }
            if (j3 != this.f27884d0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f27884d0 = j3;
            this.f27886e0 = j2;
            TextView textView = this.f27895n;
            if (textView != null && !this.L && z2) {
                textView.setText(Util.i0(this.f27897p, this.f27898q, j3));
            }
            TimeBar timeBar = this.f27896o;
            if (timeBar != null) {
                timeBar.setPosition(j3);
                this.f27896o.setBufferedPosition(j2);
            }
            removeCallbacks(this.f27901t);
            if (player == null) {
                i2 = 1;
            } else {
                i2 = player.getPlaybackState();
            }
            long j5 = 1000;
            if (player != null && player.isPlaying()) {
                TimeBar timeBar2 = this.f27896o;
                if (timeBar2 != null) {
                    j4 = timeBar2.getPreferredUpdateDelay();
                } else {
                    j4 = 1000;
                }
                long min = Math.min(j4, 1000 - (j3 % 1000));
                float f2 = player.b().f23399b;
                if (f2 > 0.0f) {
                    j5 = (long) (((float) min) / f2);
                }
                postDelayed(this.f27901t, Util.r(j5, (long) this.N, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.f27901t, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void V() {
        ImageView imageView;
        if (I() && this.I && (imageView = this.f27891j) != null) {
            if (this.O == 0) {
                R(false, false, imageView);
                return;
            }
            Player player = this.H;
            if (player == null) {
                R(true, false, imageView);
                this.f27891j.setImageDrawable(this.f27903v);
                this.f27891j.setContentDescription(this.f27906y);
                return;
            }
            R(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f27891j.setImageDrawable(this.f27903v);
                this.f27891j.setContentDescription(this.f27906y);
            } else if (repeatMode == 1) {
                this.f27891j.setImageDrawable(this.f27904w);
                this.f27891j.setContentDescription(this.f27907z);
            } else if (repeatMode == 2) {
                this.f27891j.setImageDrawable(this.f27905x);
                this.f27891j.setContentDescription(this.A);
            }
            this.f27891j.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void W() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (I() && this.I && (imageView = this.f27892k) != null) {
            Player player = this.H;
            if (!this.T) {
                R(false, false, imageView);
            } else if (player == null) {
                R(true, false, imageView);
                this.f27892k.setImageDrawable(this.C);
                this.f27892k.setContentDescription(this.G);
            } else {
                R(true, true, imageView);
                ImageView imageView2 = this.f27892k;
                if (player.O()) {
                    drawable = this.B;
                } else {
                    drawable = this.C;
                }
                imageView2.setImageDrawable(drawable);
                ImageView imageView3 = this.f27892k;
                if (player.O()) {
                    str = this.F;
                } else {
                    str = this.G;
                }
                imageView3.setContentDescription(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void X() {
        boolean z2;
        int i2;
        int i3;
        int i4;
        Timeline.Window window;
        int i5;
        Player player = this.H;
        if (player != null) {
            boolean z3 = true;
            if (!this.J || !z(player.t(), this.f27900s)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.K = z2;
            long j2 = 0;
            this.f27882c0 = 0;
            Timeline t2 = player.t();
            if (!t2.u()) {
                int M2 = player.M();
                boolean z4 = this.K;
                if (z4) {
                    i3 = 0;
                } else {
                    i3 = M2;
                }
                if (z4) {
                    i4 = t2.t() - 1;
                } else {
                    i4 = M2;
                }
                long j3 = 0;
                i2 = 0;
                while (true) {
                    if (i3 > i4) {
                        break;
                    }
                    if (i3 == M2) {
                        this.f27882c0 = Util.i1(j3);
                    }
                    t2.r(i3, this.f27900s);
                    Timeline.Window window2 = this.f27900s;
                    if (window2.f23524o == -9223372036854775807L) {
                        Assertions.g(this.K ^ z3);
                        break;
                    }
                    int i6 = window2.f23525p;
                    while (true) {
                        window = this.f27900s;
                        if (i6 > window.f23526q) {
                            break;
                        }
                        t2.j(i6, this.f27899r);
                        int f2 = this.f27899r.f();
                        for (int r2 = this.f27899r.r(); r2 < f2; r2++) {
                            long i7 = this.f27899r.i(r2);
                            if (i7 == Long.MIN_VALUE) {
                                long j4 = this.f27899r.f23495e;
                                if (j4 == -9223372036854775807L) {
                                } else {
                                    i7 = j4;
                                }
                            }
                            long q2 = i7 + this.f27899r.q();
                            if (q2 >= 0) {
                                long[] jArr = this.V;
                                if (i2 == jArr.length) {
                                    if (jArr.length == 0) {
                                        i5 = 1;
                                    } else {
                                        i5 = jArr.length * 2;
                                    }
                                    this.V = Arrays.copyOf(jArr, i5);
                                    this.W = Arrays.copyOf(this.W, i5);
                                }
                                this.V[i2] = Util.i1(j3 + q2);
                                this.W[i2] = this.f27899r.s(r2);
                                i2++;
                            }
                        }
                        i6++;
                    }
                    j3 += window.f23524o;
                    i3++;
                    z3 = true;
                }
                j2 = j3;
            } else {
                i2 = 0;
            }
            long i12 = Util.i1(j2);
            TextView textView = this.f27894m;
            if (textView != null) {
                textView.setText(Util.i0(this.f27897p, this.f27898q, i12));
            }
            TimeBar timeBar = this.f27896o;
            if (timeBar != null) {
                timeBar.setDuration(i12);
                int length = this.f27878a0.length;
                int i8 = i2 + length;
                long[] jArr2 = this.V;
                if (i8 > jArr2.length) {
                    this.V = Arrays.copyOf(jArr2, i8);
                    this.W = Arrays.copyOf(this.W, i8);
                }
                System.arraycopy(this.f27878a0, 0, this.V, i2, length);
                System.arraycopy(this.f27880b0, 0, this.W, i2, length);
                this.f27896o.a(this.V, this.W, i8);
            }
            U();
        }
    }

    private static boolean z(Timeline timeline, Timeline.Window window) {
        if (timeline.t() > 100) {
            return false;
        }
        int t2 = timeline.t();
        for (int i2 = 0; i2 < t2; i2++) {
            if (timeline.r(i2, window).f23524o == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public boolean A(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.H;
        if (player == null || !H(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            player.Q();
            return true;
        } else if (keyCode == 89) {
            player.R();
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                D(player);
                return true;
            } else if (keyCode == 87) {
                player.w();
                return true;
            } else if (keyCode == 88) {
                player.j();
                return true;
            } else if (keyCode == 126) {
                C(player);
                return true;
            } else if (keyCode != 127) {
                return true;
            } else {
                B(player);
                return true;
            }
        }
    }

    public void F() {
        if (I()) {
            setVisibility(8);
            Iterator<VisibilityListener> it2 = this.f27881c.iterator();
            while (it2.hasNext()) {
                it2.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.f27901t);
            removeCallbacks(this.f27902u);
            this.U = -9223372036854775807L;
        }
    }

    public boolean I() {
        return getVisibility() == 0;
    }

    public void J(VisibilityListener visibilityListener) {
        this.f27881c.remove(visibilityListener);
    }

    public void P() {
        if (!I()) {
            setVisibility(0);
            Iterator<VisibilityListener> it2 = this.f27881c.iterator();
            while (it2.hasNext()) {
                it2.next().onVisibilityChange(getVisibility());
            }
            Q();
            L();
            K();
        }
        G();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return A(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f27902u);
        } else if (motionEvent.getAction() == 1) {
            G();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Player getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.O;
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public int getShowTimeoutMs() {
        return this.M;
    }

    public boolean getShowVrButton() {
        View view = this.f27893l;
        return view != null && view.getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j2 = this.U;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                F();
            } else {
                postDelayed(this.f27902u, uptimeMillis);
            }
        } else if (I()) {
            G();
        }
        Q();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.f27901t);
        removeCallbacks(this.f27902u);
    }

    public void setPlayer(Player player) {
        boolean z2;
        boolean z3 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (!(player == null || player.u() == Looper.getMainLooper())) {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.H;
        if (player2 != player) {
            if (player2 != null) {
                player2.V(this.f27879b);
            }
            this.H = player;
            if (player != null) {
                player.X(this.f27879b);
            }
            Q();
        }
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
    }

    public void setRepeatToggleModes(int i2) {
        this.O = i2;
        Player player = this.H;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.H.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.H.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.H.setRepeatMode(2);
            }
        }
        V();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.Q = z2;
        S();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.J = z2;
        X();
    }

    public void setShowNextButton(boolean z2) {
        this.S = z2;
        S();
    }

    public void setShowPreviousButton(boolean z2) {
        this.R = z2;
        S();
    }

    public void setShowRewindButton(boolean z2) {
        this.P = z2;
        S();
    }

    public void setShowShuffleButton(boolean z2) {
        this.T = z2;
        W();
    }

    public void setShowTimeoutMs(int i2) {
        this.M = i2;
        if (I()) {
            G();
        }
    }

    public void setShowVrButton(boolean z2) {
        int i2;
        View view = this.f27893l;
        if (view != null) {
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.N = Util.q(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        boolean z2;
        View view = this.f27893l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            boolean showVrButton = getShowVrButton();
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            R(showVrButton, z2, this.f27893l);
        }
    }

    public void y(VisibilityListener visibilityListener) {
        Assertions.e(visibilityListener);
        this.f27881c.add(visibilityListener);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3 = R$layout.f27992b;
        this.M = 5000;
        this.O = 0;
        this.N = 200;
        this.U = -9223372036854775807L;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f28074x, i2, 0);
            try {
                this.M = obtainStyledAttributes.getInt(R$styleable.F, this.M);
                i3 = obtainStyledAttributes.getResourceId(R$styleable.f28075y, i3);
                this.O = E(obtainStyledAttributes, this.O);
                this.P = obtainStyledAttributes.getBoolean(R$styleable.D, this.P);
                this.Q = obtainStyledAttributes.getBoolean(R$styleable.A, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.C, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.B, this.S);
                this.T = obtainStyledAttributes.getBoolean(R$styleable.E, this.T);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.G, this.N));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f27881c = new CopyOnWriteArrayList<>();
        this.f27899r = new Timeline.Period();
        this.f27900s = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.f27897p = sb;
        this.f27898q = new Formatter(sb, Locale.getDefault());
        this.V = new long[0];
        this.W = new boolean[0];
        this.f27878a0 = new long[0];
        this.f27880b0 = new boolean[0];
        ComponentListener componentListener = new ComponentListener();
        this.f27879b = componentListener;
        this.f27901t = new c(this);
        this.f27902u = new d(this);
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        int i4 = R$id.H;
        TimeBar timeBar = (TimeBar) findViewById(i4);
        View findViewById = findViewById(R$id.I);
        if (timeBar != null) {
            this.f27896o = timeBar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2);
            defaultTimeBar.setId(i4);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f27896o = defaultTimeBar;
        } else {
            this.f27896o = null;
        }
        this.f27894m = (TextView) findViewById(R$id.f27975m);
        this.f27895n = (TextView) findViewById(R$id.F);
        TimeBar timeBar2 = this.f27896o;
        if (timeBar2 != null) {
            timeBar2.b(componentListener);
        }
        View findViewById2 = findViewById(R$id.C);
        this.f27887f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener);
        }
        View findViewById3 = findViewById(R$id.B);
        this.f27888g = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener);
        }
        View findViewById4 = findViewById(R$id.G);
        this.f27883d = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(componentListener);
        }
        View findViewById5 = findViewById(R$id.f27986x);
        this.f27885e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener);
        }
        View findViewById6 = findViewById(R$id.K);
        this.f27890i = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener);
        }
        View findViewById7 = findViewById(R$id.f27979q);
        this.f27889h = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R$id.J);
        this.f27891j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.N);
        this.f27892k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        View findViewById8 = findViewById(R$id.U);
        this.f27893l = findViewById8;
        setShowVrButton(false);
        R(false, false, findViewById8);
        Resources resources = context.getResources();
        this.D = ((float) resources.getInteger(R$integer.f27990b)) / 100.0f;
        this.E = ((float) resources.getInteger(R$integer.f27989a)) / 100.0f;
        this.f27903v = Util.V(context, resources, R$drawable.f27944b);
        this.f27904w = Util.V(context, resources, R$drawable.f27945c);
        this.f27905x = Util.V(context, resources, R$drawable.f27943a);
        this.B = Util.V(context, resources, R$drawable.f27947e);
        this.C = Util.V(context, resources, R$drawable.f27946d);
        this.f27906y = resources.getString(R$string.f28010j);
        this.f27907z = resources.getString(R$string.f28011k);
        this.A = resources.getString(R$string.f28009i);
        this.F = resources.getString(R$string.f28014n);
        this.G = resources.getString(R$string.f28013m);
        this.f27884d0 = -9223372036854775807L;
        this.f27886e0 = -9223372036854775807L;
    }
}
