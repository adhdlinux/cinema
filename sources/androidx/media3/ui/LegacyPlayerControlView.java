package androidx.media3.ui;

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
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.e;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p.c;
import p.d;

public class LegacyPlayerControlView extends FrameLayout {
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
    private boolean L;
    /* access modifiers changed from: private */
    public boolean M;
    private int N;
    private int O;
    /* access modifiers changed from: private */
    public int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private long[] W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean[] f9799a0;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentListener f9800b;

    /* renamed from: b0  reason: collision with root package name */
    private long[] f9801b0;

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<VisibilityListener> f9802c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean[] f9803c0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f9804d;

    /* renamed from: d0  reason: collision with root package name */
    private long f9805d0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f9806e;

    /* renamed from: e0  reason: collision with root package name */
    private long f9807e0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View f9808f;

    /* renamed from: f0  reason: collision with root package name */
    private long f9809f0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final View f9810g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final View f9811h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final View f9812i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f9813j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final ImageView f9814k;

    /* renamed from: l  reason: collision with root package name */
    private final View f9815l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f9816m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final TextView f9817n;

    /* renamed from: o  reason: collision with root package name */
    private final TimeBar f9818o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final StringBuilder f9819p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Formatter f9820q;

    /* renamed from: r  reason: collision with root package name */
    private final Timeline.Period f9821r;

    /* renamed from: s  reason: collision with root package name */
    private final Timeline.Window f9822s;

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f9823t;

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f9824u;

    /* renamed from: v  reason: collision with root package name */
    private final Drawable f9825v;

    /* renamed from: w  reason: collision with root package name */
    private final Drawable f9826w;

    /* renamed from: x  reason: collision with root package name */
    private final Drawable f9827x;

    /* renamed from: y  reason: collision with root package name */
    private final String f9828y;

    /* renamed from: z  reason: collision with root package name */
    private final String f9829z;

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

        public /* synthetic */ void A(CueGroup cueGroup) {
            e.b(this, cueGroup);
        }

        public /* synthetic */ void B(Metadata metadata) {
            e.l(this, metadata);
        }

        public /* synthetic */ void F(MediaMetadata mediaMetadata) {
            e.k(this, mediaMetadata);
        }

        public /* synthetic */ void G(TrackSelectionParameters trackSelectionParameters) {
            e.B(this, trackSelectionParameters);
        }

        public /* synthetic */ void H(MediaItem mediaItem, int i2) {
            e.j(this, mediaItem, i2);
        }

        public /* synthetic */ void I(PlaybackException playbackException) {
            e.q(this, playbackException);
        }

        public /* synthetic */ void L(Player.Commands commands) {
            e.a(this, commands);
        }

        public void P(Player player, Player.Events events) {
            if (events.b(4, 5)) {
                LegacyPlayerControlView.this.K();
            }
            if (events.b(4, 5, 7)) {
                LegacyPlayerControlView.this.L();
            }
            if (events.a(8)) {
                LegacyPlayerControlView.this.M();
            }
            if (events.a(9)) {
                LegacyPlayerControlView.this.N();
            }
            if (events.b(8, 9, 11, 0, 13)) {
                LegacyPlayerControlView.this.J();
            }
            if (events.b(11, 0)) {
                LegacyPlayerControlView.this.O();
            }
        }

        public /* synthetic */ void U(Timeline timeline, int i2) {
            e.A(this, timeline, i2);
        }

        public /* synthetic */ void V(Tracks tracks) {
            e.C(this, tracks);
        }

        public /* synthetic */ void W(DeviceInfo deviceInfo) {
            e.d(this, deviceInfo);
        }

        public /* synthetic */ void X(PlaybackException playbackException) {
            e.r(this, playbackException);
        }

        public /* synthetic */ void a0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            e.u(this, positionInfo, positionInfo2, i2);
        }

        public /* synthetic */ void n(VideoSize videoSize) {
            e.D(this, videoSize);
        }

        public void onClick(View view) {
            Player d2 = LegacyPlayerControlView.this.H;
            if (d2 != null) {
                if (LegacyPlayerControlView.this.f9806e == view) {
                    d2.w();
                } else if (LegacyPlayerControlView.this.f9804d == view) {
                    d2.j();
                } else if (LegacyPlayerControlView.this.f9811h == view) {
                    if (d2.getPlaybackState() != 4) {
                        d2.Q();
                    }
                } else if (LegacyPlayerControlView.this.f9812i == view) {
                    d2.R();
                } else if (LegacyPlayerControlView.this.f9808f == view) {
                    Util.v0(d2);
                } else if (LegacyPlayerControlView.this.f9810g == view) {
                    Util.u0(d2);
                } else if (LegacyPlayerControlView.this.f9813j == view) {
                    d2.setRepeatMode(RepeatModeUtil.a(d2.getRepeatMode(), LegacyPlayerControlView.this.P));
                } else if (LegacyPlayerControlView.this.f9814k == view) {
                    d2.B(!d2.O());
                }
            }
        }

        public /* synthetic */ void onCues(List list) {
            e.c(this, list);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            e.e(this, i2, z2);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            e.g(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            e.h(this, z2);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            e.i(this, z2);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
            e.m(this, z2, i2);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i2) {
            e.o(this, i2);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            e.p(this, i2);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            e.s(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            e.t(this, i2);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            e.v(this);
        }

        public /* synthetic */ void onRepeatModeChanged(int i2) {
            e.w(this, i2);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            e.x(this, z2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            e.y(this, z2);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
            e.z(this, i2, i3);
        }

        public void p(TimeBar timeBar, long j2) {
            boolean unused = LegacyPlayerControlView.this.M = true;
            if (LegacyPlayerControlView.this.f9817n != null) {
                LegacyPlayerControlView.this.f9817n.setText(Util.n0(LegacyPlayerControlView.this.f9819p, LegacyPlayerControlView.this.f9820q, j2));
            }
        }

        public /* synthetic */ void r(PlaybackParameters playbackParameters) {
            e.n(this, playbackParameters);
        }

        public void u(TimeBar timeBar, long j2) {
            if (LegacyPlayerControlView.this.f9817n != null) {
                LegacyPlayerControlView.this.f9817n.setText(Util.n0(LegacyPlayerControlView.this.f9819p, LegacyPlayerControlView.this.f9820q, j2));
            }
        }

        public void v(TimeBar timeBar, long j2, boolean z2) {
            boolean unused = LegacyPlayerControlView.this.M = false;
            if (!z2 && LegacyPlayerControlView.this.H != null) {
                LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
                legacyPlayerControlView.G(legacyPlayerControlView.H, j2);
            }
        }
    }

    public interface ProgressUpdateListener {
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
    }

    public LegacyPlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    private void A() {
        removeCallbacks(this.f9824u);
        if (this.N > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.N;
            this.V = uptimeMillis + ((long) i2);
            if (this.I) {
                postDelayed(this.f9824u, (long) i2);
                return;
            }
            return;
        }
        this.V = -9223372036854775807L;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean B(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    private void D() {
        View view;
        View view2;
        boolean h12 = Util.h1(this.H, this.K);
        if (h12 && (view2 = this.f9808f) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (!h12 && (view = this.f9810g) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    private void E() {
        View view;
        View view2;
        boolean h12 = Util.h1(this.H, this.K);
        if (h12 && (view2 = this.f9808f) != null) {
            view2.requestFocus();
        } else if (!h12 && (view = this.f9810g) != null) {
            view.requestFocus();
        }
    }

    private void F(Player player, int i2, long j2) {
        player.y(i2, j2);
    }

    /* access modifiers changed from: private */
    public void G(Player player, long j2) {
        int i2;
        Timeline t2 = player.t();
        if (this.L && !t2.q()) {
            int p2 = t2.p();
            i2 = 0;
            while (true) {
                long d2 = t2.n(i2, this.f9822s).d();
                if (j2 < d2) {
                    break;
                } else if (i2 == p2 - 1) {
                    j2 = d2;
                    break;
                } else {
                    j2 -= d2;
                    i2++;
                }
            }
        } else {
            i2 = player.M();
        }
        F(player, i2, j2);
        L();
    }

    private void H() {
        K();
        J();
        M();
        N();
        O();
    }

    private void I(boolean z2, boolean z3, View view) {
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
    public void J() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (C() && this.I) {
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
            I(this.S, z4, this.f9804d);
            I(this.Q, z3, this.f9812i);
            I(this.R, z2, this.f9811h);
            I(this.T, z6, this.f9806e);
            TimeBar timeBar = this.f9818o;
            if (timeBar != null) {
                timeBar.setEnabled(z5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        if (C() && this.I) {
            boolean h12 = Util.h1(this.H, this.K);
            View view = this.f9808f;
            int i3 = 8;
            boolean z7 = true;
            if (view != null) {
                if (h12 || !view.isFocused()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                z3 = z5 | false;
                if (Util.f4714a < 21) {
                    z6 = z3;
                } else if (h12 || !Api21.a(this.f9808f)) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                z2 = z6 | false;
                View view2 = this.f9808f;
                if (h12) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            } else {
                z3 = false;
                z2 = false;
            }
            View view3 = this.f9810g;
            if (view3 != null) {
                if (!h12 || !view3.isFocused()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                z3 |= z4;
                if (Util.f4714a < 21) {
                    z7 = z3;
                } else if (!h12 || !Api21.a(this.f9810g)) {
                    z7 = false;
                }
                z2 |= z7;
                View view4 = this.f9810g;
                if (!h12) {
                    i3 = 0;
                }
                view4.setVisibility(i3);
            }
            if (z3) {
                E();
            }
            if (z2) {
                D();
            }
        }
    }

    /* access modifiers changed from: private */
    public void L() {
        long j2;
        long j3;
        boolean z2;
        int i2;
        long j4;
        if (C() && this.I) {
            Player player = this.H;
            if (player != null) {
                j3 = this.f9805d0 + player.K();
                j2 = this.f9805d0 + player.P();
            } else {
                j3 = 0;
                j2 = 0;
            }
            if (j3 != this.f9807e0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f9807e0 = j3;
            this.f9809f0 = j2;
            TextView textView = this.f9817n;
            if (textView != null && !this.M && z2) {
                textView.setText(Util.n0(this.f9819p, this.f9820q, j3));
            }
            TimeBar timeBar = this.f9818o;
            if (timeBar != null) {
                timeBar.setPosition(j3);
                this.f9818o.setBufferedPosition(j2);
            }
            removeCallbacks(this.f9823t);
            if (player == null) {
                i2 = 1;
            } else {
                i2 = player.getPlaybackState();
            }
            long j5 = 1000;
            if (player != null && player.isPlaying()) {
                TimeBar timeBar2 = this.f9818o;
                if (timeBar2 != null) {
                    j4 = timeBar2.getPreferredUpdateDelay();
                } else {
                    j4 = 1000;
                }
                long min = Math.min(j4, 1000 - (j3 % 1000));
                float f2 = player.b().f4306a;
                if (f2 > 0.0f) {
                    j5 = (long) (((float) min) / f2);
                }
                postDelayed(this.f9823t, Util.q(j5, (long) this.O, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.f9823t, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void M() {
        ImageView imageView;
        if (C() && this.I && (imageView = this.f9813j) != null) {
            if (this.P == 0) {
                I(false, false, imageView);
                return;
            }
            Player player = this.H;
            if (player == null) {
                I(true, false, imageView);
                this.f9813j.setImageDrawable(this.f9825v);
                this.f9813j.setContentDescription(this.f9828y);
                return;
            }
            I(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f9813j.setImageDrawable(this.f9825v);
                this.f9813j.setContentDescription(this.f9828y);
            } else if (repeatMode == 1) {
                this.f9813j.setImageDrawable(this.f9826w);
                this.f9813j.setContentDescription(this.f9829z);
            } else if (repeatMode == 2) {
                this.f9813j.setImageDrawable(this.f9827x);
                this.f9813j.setContentDescription(this.A);
            }
            this.f9813j.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void N() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (C() && this.I && (imageView = this.f9814k) != null) {
            Player player = this.H;
            if (!this.U) {
                I(false, false, imageView);
            } else if (player == null) {
                I(true, false, imageView);
                this.f9814k.setImageDrawable(this.C);
                this.f9814k.setContentDescription(this.G);
            } else {
                I(true, true, imageView);
                ImageView imageView2 = this.f9814k;
                if (player.O()) {
                    drawable = this.B;
                } else {
                    drawable = this.C;
                }
                imageView2.setImageDrawable(drawable);
                ImageView imageView3 = this.f9814k;
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
    public void O() {
        boolean z2;
        int i2;
        int i3;
        int i4;
        Timeline.Window window;
        int i5;
        Player player = this.H;
        if (player != null) {
            boolean z3 = true;
            if (!this.J || !w(player.t(), this.f9822s)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.L = z2;
            long j2 = 0;
            this.f9805d0 = 0;
            Timeline t2 = player.t();
            if (!t2.q()) {
                int M2 = player.M();
                boolean z4 = this.L;
                if (z4) {
                    i3 = 0;
                } else {
                    i3 = M2;
                }
                if (z4) {
                    i4 = t2.p() - 1;
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
                        this.f9805d0 = Util.t1(j3);
                    }
                    t2.n(i3, this.f9822s);
                    Timeline.Window window2 = this.f9822s;
                    if (window2.f4384m == -9223372036854775807L) {
                        Assertions.h(this.L ^ z3);
                        break;
                    }
                    int i6 = window2.f4385n;
                    while (true) {
                        window = this.f9822s;
                        if (i6 > window.f4386o) {
                            break;
                        }
                        t2.f(i6, this.f9821r);
                        int c2 = this.f9821r.c();
                        for (int o2 = this.f9821r.o(); o2 < c2; o2++) {
                            long f2 = this.f9821r.f(o2);
                            if (f2 == Long.MIN_VALUE) {
                                long j4 = this.f9821r.f4358d;
                                if (j4 == -9223372036854775807L) {
                                } else {
                                    f2 = j4;
                                }
                            }
                            long n2 = f2 + this.f9821r.n();
                            if (n2 >= 0) {
                                long[] jArr = this.W;
                                if (i2 == jArr.length) {
                                    if (jArr.length == 0) {
                                        i5 = 1;
                                    } else {
                                        i5 = jArr.length * 2;
                                    }
                                    this.W = Arrays.copyOf(jArr, i5);
                                    this.f9799a0 = Arrays.copyOf(this.f9799a0, i5);
                                }
                                this.W[i2] = Util.t1(j3 + n2);
                                this.f9799a0[i2] = this.f9821r.p(o2);
                                i2++;
                            }
                        }
                        i6++;
                    }
                    j3 += window.f4384m;
                    i3++;
                    z3 = true;
                }
                j2 = j3;
            } else {
                i2 = 0;
            }
            long t1 = Util.t1(j2);
            TextView textView = this.f9816m;
            if (textView != null) {
                textView.setText(Util.n0(this.f9819p, this.f9820q, t1));
            }
            TimeBar timeBar = this.f9818o;
            if (timeBar != null) {
                timeBar.setDuration(t1);
                int length = this.f9801b0.length;
                int i7 = i2 + length;
                long[] jArr2 = this.W;
                if (i7 > jArr2.length) {
                    this.W = Arrays.copyOf(jArr2, i7);
                    this.f9799a0 = Arrays.copyOf(this.f9799a0, i7);
                }
                System.arraycopy(this.f9801b0, 0, this.W, i2, length);
                System.arraycopy(this.f9803c0, 0, this.f9799a0, i2, length);
                this.f9818o.a(this.W, this.f9799a0, i7);
            }
            L();
        }
    }

    private static boolean w(Timeline timeline, Timeline.Window window) {
        if (timeline.p() > 100) {
            return false;
        }
        int p2 = timeline.p();
        for (int i2 = 0; i2 < p2; i2++) {
            if (timeline.n(i2, window).f4384m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private static int y(TypedArray typedArray, int i2) {
        return typedArray.getInt(R$styleable.f10105z, i2);
    }

    public boolean C() {
        return getVisibility() == 0;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return x(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f9824u);
        } else if (motionEvent.getAction() == 1) {
            A();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Player getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.P;
    }

    public boolean getShowShuffleButton() {
        return this.U;
    }

    public int getShowTimeoutMs() {
        return this.N;
    }

    public boolean getShowVrButton() {
        View view = this.f9815l;
        return view != null && view.getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j2 = this.V;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                z();
            } else {
                postDelayed(this.f9824u, uptimeMillis);
            }
        } else if (C()) {
            A();
        }
        H();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.f9823t);
        removeCallbacks(this.f9824u);
    }

    public void setPlayer(Player player) {
        boolean z2;
        boolean z3 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (!(player == null || player.u() == Looper.getMainLooper())) {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.H;
        if (player2 != player) {
            if (player2 != null) {
                player2.W(this.f9800b);
            }
            this.H = player;
            if (player != null) {
                player.Y(this.f9800b);
            }
            H();
        }
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
    }

    public void setRepeatToggleModes(int i2) {
        this.P = i2;
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
        M();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.R = z2;
        J();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z2) {
        this.J = z2;
        O();
    }

    public void setShowNextButton(boolean z2) {
        this.T = z2;
        J();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z2) {
        this.K = z2;
        K();
    }

    public void setShowPreviousButton(boolean z2) {
        this.S = z2;
        J();
    }

    public void setShowRewindButton(boolean z2) {
        this.Q = z2;
        J();
    }

    public void setShowShuffleButton(boolean z2) {
        this.U = z2;
        N();
    }

    public void setShowTimeoutMs(int i2) {
        this.N = i2;
        if (C()) {
            A();
        }
    }

    public void setShowVrButton(boolean z2) {
        int i2;
        View view = this.f9815l;
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
        this.O = Util.p(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        boolean z2;
        View view = this.f9815l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            boolean showVrButton = getShowVrButton();
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            I(showVrButton, z2, this.f9815l);
        }
    }

    public boolean x(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.H;
        if (player == null || !B(keyCode)) {
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
                Util.w0(player, this.K);
                return true;
            } else if (keyCode == 87) {
                player.w();
                return true;
            } else if (keyCode == 88) {
                player.j();
                return true;
            } else if (keyCode == 126) {
                Util.v0(player);
                return true;
            } else if (keyCode != 127) {
                return true;
            } else {
                Util.u0(player);
                return true;
            }
        }
    }

    public void z() {
        if (C()) {
            setVisibility(8);
            Iterator<VisibilityListener> it2 = this.f9802c.iterator();
            while (it2.hasNext()) {
                it2.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.f9823t);
            removeCallbacks(this.f9824u);
            this.V = -9223372036854775807L;
        }
    }

    public LegacyPlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3 = R$layout.exo_legacy_player_control_view;
        this.K = true;
        this.N = 5000;
        this.P = 0;
        this.O = 200;
        this.V = -9223372036854775807L;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f10101x, i2, 0);
            try {
                this.N = obtainStyledAttributes.getInt(R$styleable.F, this.N);
                i3 = obtainStyledAttributes.getResourceId(R$styleable.f10103y, i3);
                this.P = y(obtainStyledAttributes, this.P);
                this.Q = obtainStyledAttributes.getBoolean(R$styleable.D, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.A, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.C, this.S);
                this.T = obtainStyledAttributes.getBoolean(R$styleable.B, this.T);
                this.U = obtainStyledAttributes.getBoolean(R$styleable.E, this.U);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.G, this.O));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f9802c = new CopyOnWriteArrayList<>();
        this.f9821r = new Timeline.Period();
        this.f9822s = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.f9819p = sb;
        this.f9820q = new Formatter(sb, Locale.getDefault());
        this.W = new long[0];
        this.f9799a0 = new boolean[0];
        this.f9801b0 = new long[0];
        this.f9803c0 = new boolean[0];
        ComponentListener componentListener = new ComponentListener();
        this.f9800b = componentListener;
        this.f9823t = new c(this);
        this.f9824u = new d(this);
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        int i4 = R$id.I;
        TimeBar timeBar = (TimeBar) findViewById(i4);
        View findViewById = findViewById(R$id.J);
        if (timeBar != null) {
            this.f9818o = timeBar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2);
            defaultTimeBar.setId(i4);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f9818o = defaultTimeBar;
        } else {
            this.f9818o = null;
        }
        this.f9816m = (TextView) findViewById(R$id.f10005m);
        this.f9817n = (TextView) findViewById(R$id.G);
        TimeBar timeBar2 = this.f9818o;
        if (timeBar2 != null) {
            timeBar2.b(componentListener);
        }
        View findViewById2 = findViewById(R$id.D);
        this.f9808f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener);
        }
        View findViewById3 = findViewById(R$id.C);
        this.f9810g = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener);
        }
        View findViewById4 = findViewById(R$id.H);
        this.f9804d = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(componentListener);
        }
        View findViewById5 = findViewById(R$id.f10016y);
        this.f9806e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener);
        }
        View findViewById6 = findViewById(R$id.L);
        this.f9812i = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener);
        }
        View findViewById7 = findViewById(R$id.f10009q);
        this.f9811h = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R$id.K);
        this.f9813j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.O);
        this.f9814k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        View findViewById8 = findViewById(R$id.V);
        this.f9815l = findViewById8;
        setShowVrButton(false);
        I(false, false, findViewById8);
        Resources resources = context.getResources();
        this.D = ((float) resources.getInteger(R$integer.f10019b)) / 100.0f;
        this.E = ((float) resources.getInteger(R$integer.f10018a)) / 100.0f;
        this.f9825v = Util.X(context, resources, R$drawable.exo_legacy_controls_repeat_off);
        this.f9826w = Util.X(context, resources, R$drawable.exo_legacy_controls_repeat_one);
        this.f9827x = Util.X(context, resources, R$drawable.exo_legacy_controls_repeat_all);
        this.B = Util.X(context, resources, R$drawable.exo_legacy_controls_shuffle_on);
        this.C = Util.X(context, resources, R$drawable.exo_legacy_controls_shuffle_off);
        this.f9828y = resources.getString(R$string.f10037j);
        this.f9829z = resources.getString(R$string.f10038k);
        this.A = resources.getString(R$string.f10036i);
        this.F = resources.getString(R$string.f10041n);
        this.G = resources.getString(R$string.f10040m);
        this.f9807e0 = -9223372036854775807L;
        this.f9809f0 = -9223372036854775807L;
    }
}
