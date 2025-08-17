package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.chartboost.sdk.impl.zc;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.x1;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class o0 implements s0, SurfaceHolder.Callback, Player.Listener, zc.b, o1 {

    /* renamed from: a  reason: collision with root package name */
    public final o5 f18272a;

    /* renamed from: b  reason: collision with root package name */
    public final SurfaceView f18273b;

    /* renamed from: c  reason: collision with root package name */
    public final t0 f18274c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f18275d;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f18276e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18277f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18278g;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l5 f18279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ o0 f18280c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l5 l5Var, o0 o0Var) {
            super(0);
            this.f18279b = l5Var;
            this.f18280c = o0Var;
        }

        /* renamed from: a */
        public final ExoPlayer invoke() {
            ExoPlayer a2 = this.f18279b.a();
            a2.X(this.f18280c);
            return a2;
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Function3 f18281b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ o0 f18282c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ bc f18283d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function3 function3, o0 o0Var, bc bcVar) {
            super(0);
            this.f18281b = function3;
            this.f18282c = o0Var;
            this.f18283d = bcVar;
        }

        /* renamed from: a */
        public final zc invoke() {
            return (zc) this.f18281b.invoke(this.f18282c.f18274c, this.f18282c, this.f18283d);
        }
    }

    public o0(Context context, l5 l5Var, o5 o5Var, SurfaceView surfaceView, t0 t0Var, bc bcVar, Function3 function3) {
        Intrinsics.f(context, "context");
        Intrinsics.f(l5Var, "exoPlayerFactory");
        Intrinsics.f(o5Var, "exoPlayerMediaItemFactory");
        Intrinsics.f(surfaceView, "surfaceView");
        Intrinsics.f(bcVar, "uiPoster");
        Intrinsics.f(function3, "videoProgressFactory");
        this.f18272a = o5Var;
        this.f18273b = surfaceView;
        this.f18274c = t0Var;
        this.f18275d = LazyKt__LazyJVMKt.b(new a(l5Var, this));
        this.f18276e = LazyKt__LazyJVMKt.b(new b(function3, this, bcVar));
    }

    public void a(int i2, int i3) {
    }

    public final MediaItem b(rc rcVar) {
        MediaItem a2 = this.f18272a.a(rcVar);
        String a3 = p0.f18322a;
        Log.d(a3, "VideoAsset.toMediaItem() - " + a2);
        return a2;
    }

    public final ExoPlayer c() {
        return (ExoPlayer) this.f18275d.getValue();
    }

    public long d() {
        return c().getCurrentPosition();
    }

    public final zc e() {
        return (zc) this.f18276e.getValue();
    }

    public void f() {
        c().d(0.0f);
    }

    public float g() {
        return c().getVolume();
    }

    public boolean h() {
        return this.f18277f;
    }

    public final void i() {
        stop();
        l();
        t0 t0Var = this.f18274c;
        if (t0Var != null) {
            t0Var.d();
        }
    }

    public final void j() {
        a(this, 0, 0, 3, (Object) null);
        t0 t0Var = this.f18274c;
        if (t0Var != null) {
            t0Var.c();
        }
        t0 t0Var2 = this.f18274c;
        if (t0Var2 != null) {
            t0Var2.b(c().getDuration());
        }
    }

    public final void k() {
        zc.a.a(e(), 0, 1, (Object) null);
    }

    public final void l() {
        e().a();
    }

    public /* bridge */ /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        x1.a(this, audioAttributes);
    }

    public /* bridge */ /* synthetic */ void onAudioSessionIdChanged(int i2) {
        x1.b(this, i2);
    }

    public /* bridge */ /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        x1.c(this, commands);
    }

    public /* bridge */ /* synthetic */ void onCues(CueGroup cueGroup) {
        x1.d(this, cueGroup);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void onCues(List list) {
        x1.e(this, list);
    }

    public /* bridge */ /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        x1.f(this, deviceInfo);
    }

    public /* bridge */ /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
        x1.g(this, i2, z2);
    }

    public /* bridge */ /* synthetic */ void onEvents(Player player, Player.Events events) {
        x1.h(this, player, events);
    }

    public /* bridge */ /* synthetic */ void onIsLoadingChanged(boolean z2) {
        x1.i(this, z2);
    }

    public void onIsPlayingChanged(boolean z2) {
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "onIsPlayingChanged() - isPlaying: " + z2);
        if (z2) {
            this.f18277f = true;
            t0 t0Var = this.f18274c;
            if (t0Var != null) {
                t0Var.b();
            }
            k();
            return;
        }
        l();
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void onLoadingChanged(boolean z2) {
        x1.k(this, z2);
    }

    public /* bridge */ /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j2) {
        x1.l(this, j2);
    }

    public /* bridge */ /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i2) {
        x1.m(this, mediaItem, i2);
    }

    public /* bridge */ /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        x1.n(this, mediaMetadata);
    }

    public /* bridge */ /* synthetic */ void onMetadata(Metadata metadata) {
        x1.o(this, metadata);
    }

    public /* bridge */ /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
        x1.p(this, z2, i2);
    }

    public /* bridge */ /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        x1.q(this, playbackParameters);
    }

    public void onPlaybackStateChanged(int i2) {
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "onPlaybackStateChanged() - playbackState: " + p0.b(i2));
        if (i2 == 2) {
            t0 t0Var = this.f18274c;
            if (t0Var != null) {
                t0Var.a();
            }
        } else if (i2 == 3) {
            j();
        } else if (i2 == 4) {
            i();
        }
    }

    public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
        x1.s(this, i2);
    }

    public void onPlayerError(PlaybackException playbackException) {
        Intrinsics.f(playbackException, MRAIDPresenter.ERROR);
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "ExoPlayer error", playbackException);
        stop();
        t0 t0Var = this.f18274c;
        if (t0Var != null) {
            String message = playbackException.getMessage();
            if (message == null) {
                message = "No error message from ExoPlayer";
            }
            t0Var.a(message);
        }
    }

    public /* bridge */ /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        x1.u(this, playbackException);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
        x1.v(this, z2, i2);
    }

    public /* bridge */ /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        x1.w(this, mediaMetadata);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void onPositionDiscontinuity(int i2) {
        x1.x(this, i2);
    }

    public /* bridge */ /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        x1.y(this, positionInfo, positionInfo2, i2);
    }

    public /* bridge */ /* synthetic */ void onRenderedFirstFrame() {
        x1.z(this);
    }

    public /* bridge */ /* synthetic */ void onRepeatModeChanged(int i2) {
        x1.A(this, i2);
    }

    public /* bridge */ /* synthetic */ void onSeekBackIncrementChanged(long j2) {
        x1.B(this, j2);
    }

    public /* bridge */ /* synthetic */ void onSeekForwardIncrementChanged(long j2) {
        x1.C(this, j2);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void onSeekProcessed() {
        x1.D(this);
    }

    public /* bridge */ /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
        x1.E(this, z2);
    }

    public /* bridge */ /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
        x1.F(this, z2);
    }

    public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
        x1.G(this, i2, i3);
    }

    public /* bridge */ /* synthetic */ void onTimelineChanged(Timeline timeline, int i2) {
        x1.H(this, timeline, i2);
    }

    public /* bridge */ /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        x1.I(this, trackSelectionParameters);
    }

    public /* bridge */ /* synthetic */ void onTracksChanged(Tracks tracks) {
        x1.J(this, tracks);
    }

    public /* bridge */ /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        x1.K(this, videoSize);
    }

    public /* bridge */ /* synthetic */ void onVolumeChanged(float f2) {
        x1.L(this, f2);
    }

    public void pause() {
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "pause()");
        c().pause();
    }

    public void play() {
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "play()");
        c().i(this.f18273b);
        c().play();
        this.f18278g = false;
    }

    public void stop() {
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "stop()");
        if (c().isPlaying()) {
            c().stop();
        }
        c().release();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Intrinsics.f(surfaceHolder, "holder");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.f(surfaceHolder, "holder");
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "surfaceCreated()");
        if (this.f18278g) {
            play();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.f(surfaceHolder, "holder");
        String a2 = p0.f18322a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "surfaceDestroyed()");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0041, code lost:
        if (r4 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.chartboost.sdk.impl.rc r4) {
        /*
            r3 = this;
            java.lang.String r0 = "asset"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = com.chartboost.sdk.impl.p0.f18322a
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "asset() - asset: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.chartboost.sdk.impl.w7.a(r0, r1)
            com.google.android.exoplayer2.MediaItem r4 = r3.b(r4)
            if (r4 == 0) goto L_0x0043
            com.google.android.exoplayer2.ExoPlayer r0 = r3.c()
            r0.W(r4)
            r0.prepare()
            android.view.SurfaceView r4 = r3.f18273b
            android.view.SurfaceHolder r4 = r4.getHolder()
            if (r4 == 0) goto L_0x0040
            r4.addCallback(r3)
            kotlin.Unit r4 = kotlin.Unit.f40298a
            goto L_0x0041
        L_0x0040:
            r4 = 0
        L_0x0041:
            if (r4 != 0) goto L_0x0053
        L_0x0043:
            com.chartboost.sdk.impl.t0 r4 = r3.f18274c
            java.lang.String r0 = "Error retrieving media item"
            if (r4 == 0) goto L_0x004c
            r4.a((java.lang.String) r0)
        L_0x004c:
            java.lang.String r4 = com.chartboost.sdk.impl.p0.f18322a
            android.util.Log.e(r4, r0)
        L_0x0053:
            r4 = 0
            r3.f18277f = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.o0.a(com.chartboost.sdk.impl.rc):void");
    }

    public void b() {
        c().d(1.0f);
    }

    public final void b(int i2, int i3) {
        jd.a(this.f18273b, q5.b(c()), q5.a(c()), i2, i3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(Context context, l5 l5Var, o5 o5Var, SurfaceView surfaceView, t0 t0Var, bc bcVar, Function3 function3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? new l5(context, (h5) null, (Function0) null, (Function0) null, 14, (DefaultConstructorMarker) null) : l5Var, o5Var, surfaceView, (i2 & 16) != 0 ? null : t0Var, bcVar, function3);
    }

    public static /* synthetic */ void a(o0 o0Var, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = o0Var.f18273b.getWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = o0Var.f18273b.getHeight();
        }
        o0Var.b(i2, i3);
    }

    public void a() {
        this.f18278g = true;
    }
}
