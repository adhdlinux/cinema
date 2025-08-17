package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer {

    /* renamed from: b  reason: collision with root package name */
    private final ExoPlayerImpl f23459b;

    /* renamed from: c  reason: collision with root package name */
    private final ConditionVariable f23460c;

    @Deprecated
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ExoPlayer.Builder f23461a;

        @Deprecated
        public Builder(Context context) {
            this.f23461a = new ExoPlayer.Builder(context);
        }

        @Deprecated
        public SimpleExoPlayer a() {
            return this.f23461a.h();
        }
    }

    SimpleExoPlayer(ExoPlayer.Builder builder) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f23460c = conditionVariable;
        try {
            this.f23459b = new ExoPlayerImpl(builder, this);
            conditionVariable.f();
        } catch (Throwable th) {
            this.f23460c.f();
            throw th;
        }
    }

    private void m0() {
        this.f23460c.c();
    }

    public boolean A() {
        m0();
        return this.f23459b.A();
    }

    public void B(boolean z2) {
        m0();
        this.f23459b.B(z2);
    }

    public long C() {
        m0();
        return this.f23459b.C();
    }

    public int E() {
        m0();
        return this.f23459b.E();
    }

    public void F(TextureView textureView) {
        m0();
        this.f23459b.F(textureView);
    }

    public VideoSize G() {
        m0();
        return this.f23459b.G();
    }

    public int I() {
        m0();
        return this.f23459b.I();
    }

    public long J() {
        m0();
        return this.f23459b.J();
    }

    public long K() {
        m0();
        return this.f23459b.K();
    }

    public int M() {
        m0();
        return this.f23459b.M();
    }

    public void N(SurfaceView surfaceView) {
        m0();
        this.f23459b.N(surfaceView);
    }

    public boolean O() {
        m0();
        return this.f23459b.O();
    }

    public long P() {
        m0();
        return this.f23459b.P();
    }

    public MediaMetadata S() {
        m0();
        return this.f23459b.S();
    }

    public long T() {
        m0();
        return this.f23459b.T();
    }

    public void V(Player.Listener listener) {
        m0();
        this.f23459b.V(listener);
    }

    public void X(Player.Listener listener) {
        m0();
        this.f23459b.X(listener);
    }

    public void Y(int i2, List<MediaItem> list) {
        m0();
        this.f23459b.Y(i2, list);
    }

    public long Z() {
        m0();
        return this.f23459b.Z();
    }

    public Format a() {
        m0();
        return this.f23459b.a();
    }

    public void a0(TrackSelectionParameters trackSelectionParameters) {
        m0();
        this.f23459b.a0(trackSelectionParameters);
    }

    public PlaybackParameters b() {
        m0();
        return this.f23459b.b();
    }

    public void d(float f2) {
        m0();
        this.f23459b.d(f2);
    }

    public void e(PlaybackParameters playbackParameters) {
        m0();
        this.f23459b.e(playbackParameters);
    }

    public boolean f() {
        m0();
        return this.f23459b.f();
    }

    public long g() {
        m0();
        return this.f23459b.g();
    }

    public void g0(int i2, long j2, int i3, boolean z2) {
        m0();
        this.f23459b.g0(i2, j2, i3, z2);
    }

    public long getCurrentPosition() {
        m0();
        return this.f23459b.getCurrentPosition();
    }

    public long getDuration() {
        m0();
        return this.f23459b.getDuration();
    }

    public int getPlaybackState() {
        m0();
        return this.f23459b.getPlaybackState();
    }

    public int getRepeatMode() {
        m0();
        return this.f23459b.getRepeatMode();
    }

    public float getVolume() {
        m0();
        return this.f23459b.getVolume();
    }

    public void i(SurfaceView surfaceView) {
        m0();
        this.f23459b.i(surfaceView);
    }

    public void l(boolean z2) {
        m0();
        this.f23459b.l(z2);
    }

    public Tracks m() {
        m0();
        return this.f23459b.m();
    }

    public Format n0() {
        m0();
        return this.f23459b.z1();
    }

    public CueGroup o() {
        m0();
        return this.f23459b.o();
    }

    public int o0() {
        m0();
        return this.f23459b.A1();
    }

    public int p() {
        m0();
        return this.f23459b.p();
    }

    /* renamed from: p0 */
    public ExoPlaybackException k() {
        m0();
        return this.f23459b.k();
    }

    public void prepare() {
        m0();
        this.f23459b.prepare();
    }

    @Deprecated
    public void q0(MediaSource mediaSource) {
        m0();
        this.f23459b.o2(mediaSource);
    }

    public void r0(MediaSource mediaSource) {
        m0();
        this.f23459b.u2(mediaSource);
    }

    public void release() {
        m0();
        this.f23459b.release();
    }

    public int s() {
        m0();
        return this.f23459b.s();
    }

    public void s0(Surface surface) {
        m0();
        this.f23459b.B2(surface);
    }

    public void setRepeatMode(int i2) {
        m0();
        this.f23459b.setRepeatMode(i2);
    }

    public void stop() {
        m0();
        this.f23459b.stop();
    }

    public Timeline t() {
        m0();
        return this.f23459b.t();
    }

    public Looper u() {
        m0();
        return this.f23459b.u();
    }

    public TrackSelectionParameters v() {
        m0();
        return this.f23459b.v();
    }

    public void x(TextureView textureView) {
        m0();
        this.f23459b.x(textureView);
    }

    public Player.Commands z() {
        m0();
        return this.f23459b.z();
    }
}
