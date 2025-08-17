package androidx.media3.common;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.FlagSet;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.util.List;

public interface Player {

    public static final class Commands {

        /* renamed from: b  reason: collision with root package name */
        public static final Commands f4309b = new Builder().e();

        /* renamed from: c  reason: collision with root package name */
        private static final String f4310c = Util.B0(0);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final FlagSet f4311a;

        public static final class Builder {

            /* renamed from: b  reason: collision with root package name */
            private static final int[] f4312b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* renamed from: a  reason: collision with root package name */
            private final FlagSet.Builder f4313a = new FlagSet.Builder();

            public Builder a(int i2) {
                this.f4313a.a(i2);
                return this;
            }

            public Builder b(Commands commands) {
                this.f4313a.b(commands.f4311a);
                return this;
            }

            public Builder c(int... iArr) {
                this.f4313a.c(iArr);
                return this;
            }

            public Builder d(int i2, boolean z2) {
                this.f4313a.d(i2, z2);
                return this;
            }

            public Commands e() {
                return new Commands(this.f4313a.e());
            }
        }

        public boolean b(int i2) {
            return this.f4311a.a(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Commands)) {
                return false;
            }
            return this.f4311a.equals(((Commands) obj).f4311a);
        }

        public int hashCode() {
            return this.f4311a.hashCode();
        }

        private Commands(FlagSet flagSet) {
            this.f4311a = flagSet;
        }
    }

    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f4314a;

        public Events(FlagSet flagSet) {
            this.f4314a = flagSet;
        }

        public boolean a(int i2) {
            return this.f4314a.a(i2);
        }

        public boolean b(int... iArr) {
            return this.f4314a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Events)) {
                return false;
            }
            return this.f4314a.equals(((Events) obj).f4314a);
        }

        public int hashCode() {
            return this.f4314a.hashCode();
        }
    }

    public interface Listener {
        void A(CueGroup cueGroup);

        void B(Metadata metadata);

        void F(MediaMetadata mediaMetadata);

        void G(TrackSelectionParameters trackSelectionParameters);

        void H(MediaItem mediaItem, int i2);

        void I(PlaybackException playbackException);

        void L(Commands commands);

        void P(Player player, Events events);

        void U(Timeline timeline, int i2);

        void V(Tracks tracks);

        void W(DeviceInfo deviceInfo);

        void X(PlaybackException playbackException);

        void a0(PositionInfo positionInfo, PositionInfo positionInfo2, int i2);

        void n(VideoSize videoSize);

        @Deprecated
        void onCues(List<Cue> list);

        void onDeviceVolumeChanged(int i2, boolean z2);

        void onIsLoadingChanged(boolean z2);

        void onIsPlayingChanged(boolean z2);

        @Deprecated
        void onLoadingChanged(boolean z2);

        void onPlayWhenReadyChanged(boolean z2, int i2);

        void onPlaybackStateChanged(int i2);

        void onPlaybackSuppressionReasonChanged(int i2);

        @Deprecated
        void onPlayerStateChanged(boolean z2, int i2);

        @Deprecated
        void onPositionDiscontinuity(int i2);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i2);

        void onShuffleModeEnabledChanged(boolean z2);

        void onSkipSilenceEnabledChanged(boolean z2);

        void onSurfaceSizeChanged(int i2, int i3);

        void r(PlaybackParameters playbackParameters);
    }

    public static final class PositionInfo {

        /* renamed from: k  reason: collision with root package name */
        static final String f4315k = Util.B0(0);

        /* renamed from: l  reason: collision with root package name */
        private static final String f4316l = Util.B0(1);

        /* renamed from: m  reason: collision with root package name */
        static final String f4317m = Util.B0(2);

        /* renamed from: n  reason: collision with root package name */
        static final String f4318n = Util.B0(3);

        /* renamed from: o  reason: collision with root package name */
        static final String f4319o = Util.B0(4);

        /* renamed from: p  reason: collision with root package name */
        private static final String f4320p = Util.B0(5);

        /* renamed from: q  reason: collision with root package name */
        private static final String f4321q = Util.B0(6);

        /* renamed from: a  reason: collision with root package name */
        public final Object f4322a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public final int f4323b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4324c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaItem f4325d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f4326e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4327f;

        /* renamed from: g  reason: collision with root package name */
        public final long f4328g;

        /* renamed from: h  reason: collision with root package name */
        public final long f4329h;

        /* renamed from: i  reason: collision with root package name */
        public final int f4330i;

        /* renamed from: j  reason: collision with root package name */
        public final int f4331j;

        public PositionInfo(Object obj, int i2, MediaItem mediaItem, Object obj2, int i3, long j2, long j3, int i4, int i5) {
            this.f4322a = obj;
            this.f4323b = i2;
            this.f4324c = i2;
            this.f4325d = mediaItem;
            this.f4326e = obj2;
            this.f4327f = i3;
            this.f4328g = j2;
            this.f4329h = j3;
            this.f4330i = i4;
            this.f4331j = i5;
        }

        public boolean a(PositionInfo positionInfo) {
            if (this.f4324c == positionInfo.f4324c && this.f4327f == positionInfo.f4327f && this.f4328g == positionInfo.f4328g && this.f4329h == positionInfo.f4329h && this.f4330i == positionInfo.f4330i && this.f4331j == positionInfo.f4331j && Objects.a(this.f4325d, positionInfo.f4325d)) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PositionInfo.class != obj.getClass()) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) obj;
            if (!a(positionInfo) || !Objects.a(this.f4322a, positionInfo.f4322a) || !Objects.a(this.f4326e, positionInfo.f4326e)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.b(this.f4322a, Integer.valueOf(this.f4324c), this.f4325d, this.f4326e, Integer.valueOf(this.f4327f), Long.valueOf(this.f4328g), Long.valueOf(this.f4329h), Integer.valueOf(this.f4330i), Integer.valueOf(this.f4331j));
        }
    }

    boolean A();

    void B(boolean z2);

    long C();

    long D();

    int E();

    void F(TextureView textureView);

    VideoSize G();

    boolean H();

    int I();

    long J();

    long K();

    boolean L();

    int M();

    void N(SurfaceView surfaceView);

    boolean O();

    long P();

    void Q();

    void R();

    MediaMetadata S();

    long T();

    boolean U();

    @Deprecated
    int V();

    void W(Listener listener);

    void Y(Listener listener);

    void a0(TrackSelectionParameters trackSelectionParameters);

    PlaybackParameters b();

    void e(PlaybackParameters playbackParameters);

    boolean f();

    long g();

    long getCurrentPosition();

    long getDuration();

    int getPlaybackState();

    int getRepeatMode();

    void h();

    void i(SurfaceView surfaceView);

    boolean isPlaying();

    void j();

    PlaybackException k();

    void l(boolean z2);

    Tracks m();

    boolean n();

    CueGroup o();

    int p();

    void pause();

    void play();

    void prepare();

    boolean q(int i2);

    boolean r();

    int s();

    void seekTo(long j2);

    void setPlaybackSpeed(float f2);

    void setRepeatMode(int i2);

    void stop();

    Timeline t();

    Looper u();

    TrackSelectionParameters v();

    void w();

    void x(TextureView textureView);

    void y(int i2, long j2);

    Commands z();
}
