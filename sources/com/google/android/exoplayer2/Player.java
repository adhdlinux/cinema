package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public interface Player {

    public static final class Commands implements Bundleable {

        /* renamed from: c  reason: collision with root package name */
        public static final Commands f23402c = new Builder().e();

        /* renamed from: d  reason: collision with root package name */
        private static final String f23403d = Util.u0(0);

        /* renamed from: e  reason: collision with root package name */
        public static final Bundleable.Creator<Commands> f23404e = new w1();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final FlagSet f23405b;

        public static final class Builder {

            /* renamed from: b  reason: collision with root package name */
            private static final int[] f23406b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* renamed from: a  reason: collision with root package name */
            private final FlagSet.Builder f23407a = new FlagSet.Builder();

            public Builder a(int i2) {
                this.f23407a.a(i2);
                return this;
            }

            public Builder b(Commands commands) {
                this.f23407a.b(commands.f23405b);
                return this;
            }

            public Builder c(int... iArr) {
                this.f23407a.c(iArr);
                return this;
            }

            public Builder d(int i2, boolean z2) {
                this.f23407a.d(i2, z2);
                return this;
            }

            public Commands e() {
                return new Commands(this.f23407a.e());
            }
        }

        /* access modifiers changed from: private */
        public static Commands d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f23403d);
            if (integerArrayList == null) {
                return f23402c;
            }
            Builder builder = new Builder();
            for (int i2 = 0; i2 < integerArrayList.size(); i2++) {
                builder.a(integerArrayList.get(i2).intValue());
            }
            return builder.e();
        }

        public boolean c(int i2) {
            return this.f23405b.a(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Commands)) {
                return false;
            }
            return this.f23405b.equals(((Commands) obj).f23405b);
        }

        public int hashCode() {
            return this.f23405b.hashCode();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f23405b.d(); i2++) {
                arrayList.add(Integer.valueOf(this.f23405b.c(i2)));
            }
            bundle.putIntegerArrayList(f23403d, arrayList);
            return bundle;
        }

        private Commands(FlagSet flagSet) {
            this.f23405b = flagSet;
        }
    }

    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f23408a;

        public Events(FlagSet flagSet) {
            this.f23408a = flagSet;
        }

        public boolean a(int i2) {
            return this.f23408a.a(i2);
        }

        public boolean b(int... iArr) {
            return this.f23408a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Events)) {
                return false;
            }
            return this.f23408a.equals(((Events) obj).f23408a);
        }

        public int hashCode() {
            return this.f23408a.hashCode();
        }
    }

    public interface Listener {
        void onAvailableCommandsChanged(Commands commands);

        void onCues(CueGroup cueGroup);

        @Deprecated
        void onCues(List<Cue> list);

        void onDeviceInfoChanged(DeviceInfo deviceInfo);

        void onDeviceVolumeChanged(int i2, boolean z2);

        void onEvents(Player player, Events events);

        void onIsLoadingChanged(boolean z2);

        void onIsPlayingChanged(boolean z2);

        @Deprecated
        void onLoadingChanged(boolean z2);

        void onMediaItemTransition(MediaItem mediaItem, int i2);

        void onMediaMetadataChanged(MediaMetadata mediaMetadata);

        void onMetadata(Metadata metadata);

        void onPlayWhenReadyChanged(boolean z2, int i2);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlaybackStateChanged(int i2);

        void onPlaybackSuppressionReasonChanged(int i2);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(PlaybackException playbackException);

        @Deprecated
        void onPlayerStateChanged(boolean z2, int i2);

        @Deprecated
        void onPositionDiscontinuity(int i2);

        void onPositionDiscontinuity(PositionInfo positionInfo, PositionInfo positionInfo2, int i2);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i2);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z2);

        void onSkipSilenceEnabledChanged(boolean z2);

        void onSurfaceSizeChanged(int i2, int i3);

        void onTimelineChanged(Timeline timeline, int i2);

        void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters);

        void onTracksChanged(Tracks tracks);

        void onVideoSizeChanged(VideoSize videoSize);

        void onVolumeChanged(float f2);
    }

    public static final class PositionInfo implements Bundleable {

        /* renamed from: l  reason: collision with root package name */
        private static final String f23409l = Util.u0(0);

        /* renamed from: m  reason: collision with root package name */
        private static final String f23410m = Util.u0(1);

        /* renamed from: n  reason: collision with root package name */
        private static final String f23411n = Util.u0(2);

        /* renamed from: o  reason: collision with root package name */
        private static final String f23412o = Util.u0(3);

        /* renamed from: p  reason: collision with root package name */
        private static final String f23413p = Util.u0(4);

        /* renamed from: q  reason: collision with root package name */
        private static final String f23414q = Util.u0(5);

        /* renamed from: r  reason: collision with root package name */
        private static final String f23415r = Util.u0(6);

        /* renamed from: s  reason: collision with root package name */
        public static final Bundleable.Creator<PositionInfo> f23416s = new y1();

        /* renamed from: b  reason: collision with root package name */
        public final Object f23417b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public final int f23418c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23419d;

        /* renamed from: e  reason: collision with root package name */
        public final MediaItem f23420e;

        /* renamed from: f  reason: collision with root package name */
        public final Object f23421f;

        /* renamed from: g  reason: collision with root package name */
        public final int f23422g;

        /* renamed from: h  reason: collision with root package name */
        public final long f23423h;

        /* renamed from: i  reason: collision with root package name */
        public final long f23424i;

        /* renamed from: j  reason: collision with root package name */
        public final int f23425j;

        /* renamed from: k  reason: collision with root package name */
        public final int f23426k;

        public PositionInfo(Object obj, int i2, MediaItem mediaItem, Object obj2, int i3, long j2, long j3, int i4, int i5) {
            this.f23417b = obj;
            this.f23418c = i2;
            this.f23419d = i2;
            this.f23420e = mediaItem;
            this.f23421f = obj2;
            this.f23422g = i3;
            this.f23423h = j2;
            this.f23424i = j3;
            this.f23425j = i4;
            this.f23426k = i5;
        }

        /* access modifiers changed from: private */
        public static PositionInfo b(Bundle bundle) {
            MediaItem mediaItem;
            int i2 = bundle.getInt(f23409l, 0);
            Bundle bundle2 = bundle.getBundle(f23410m);
            if (bundle2 == null) {
                mediaItem = null;
            } else {
                mediaItem = MediaItem.f23127p.a(bundle2);
            }
            return new PositionInfo((Object) null, i2, mediaItem, (Object) null, bundle.getInt(f23411n, 0), bundle.getLong(f23412o, 0), bundle.getLong(f23413p, 0), bundle.getInt(f23414q, -1), bundle.getInt(f23415r, -1));
        }

        public Bundle c(boolean z2, boolean z3) {
            int i2;
            long j2;
            int i3;
            Bundle bundle = new Bundle();
            String str = f23409l;
            int i4 = 0;
            if (z3) {
                i2 = this.f23419d;
            } else {
                i2 = 0;
            }
            bundle.putInt(str, i2);
            MediaItem mediaItem = this.f23420e;
            if (mediaItem != null && z2) {
                bundle.putBundle(f23410m, mediaItem.toBundle());
            }
            String str2 = f23411n;
            if (z3) {
                i4 = this.f23422g;
            }
            bundle.putInt(str2, i4);
            String str3 = f23412o;
            long j3 = 0;
            if (z2) {
                j2 = this.f23423h;
            } else {
                j2 = 0;
            }
            bundle.putLong(str3, j2);
            String str4 = f23413p;
            if (z2) {
                j3 = this.f23424i;
            }
            bundle.putLong(str4, j3);
            String str5 = f23414q;
            int i5 = -1;
            if (z2) {
                i3 = this.f23425j;
            } else {
                i3 = -1;
            }
            bundle.putInt(str5, i3);
            String str6 = f23415r;
            if (z2) {
                i5 = this.f23426k;
            }
            bundle.putInt(str6, i5);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PositionInfo.class != obj.getClass()) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) obj;
            if (this.f23419d == positionInfo.f23419d && this.f23422g == positionInfo.f23422g && this.f23423h == positionInfo.f23423h && this.f23424i == positionInfo.f23424i && this.f23425j == positionInfo.f23425j && this.f23426k == positionInfo.f23426k && Objects.a(this.f23417b, positionInfo.f23417b) && Objects.a(this.f23421f, positionInfo.f23421f) && Objects.a(this.f23420e, positionInfo.f23420e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f23417b, Integer.valueOf(this.f23419d), this.f23420e, this.f23421f, Integer.valueOf(this.f23422g), Long.valueOf(this.f23423h), Long.valueOf(this.f23424i), Integer.valueOf(this.f23425j), Integer.valueOf(this.f23426k));
        }

        public Bundle toBundle() {
            return c(true, true);
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

    void V(Listener listener);

    void W(MediaItem mediaItem);

    void X(Listener listener);

    void Y(int i2, List<MediaItem> list);

    long Z();

    void a0(TrackSelectionParameters trackSelectionParameters);

    PlaybackParameters b();

    void d(float f2);

    void e(PlaybackParameters playbackParameters);

    boolean f();

    long g();

    long getCurrentPosition();

    long getDuration();

    int getPlaybackState();

    int getRepeatMode();

    float getVolume();

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

    void release();

    int s();

    void seekTo(long j2);

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
