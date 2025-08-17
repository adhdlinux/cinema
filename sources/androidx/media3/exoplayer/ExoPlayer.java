package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import com.applovin.mediation.MaxErrorCode;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import e.h;
import e.i;
import e.j;
import e.k;
import e.l;
import e.m;
import e.n;
import e.o;
import e.p;

public interface ExoPlayer extends Player {

    public interface AudioOffloadListener {
        void E(boolean z2);

        void F(boolean z2);
    }

    public static final class Builder {
        long A;
        long B;
        boolean C;
        boolean D;
        Looper E;
        boolean F;
        boolean G;
        String H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final Context f5243a;

        /* renamed from: b  reason: collision with root package name */
        Clock f5244b;

        /* renamed from: c  reason: collision with root package name */
        long f5245c;

        /* renamed from: d  reason: collision with root package name */
        Supplier<RenderersFactory> f5246d;

        /* renamed from: e  reason: collision with root package name */
        Supplier<MediaSource.Factory> f5247e;

        /* renamed from: f  reason: collision with root package name */
        Supplier<TrackSelector> f5248f;

        /* renamed from: g  reason: collision with root package name */
        Supplier<LoadControl> f5249g;

        /* renamed from: h  reason: collision with root package name */
        Supplier<BandwidthMeter> f5250h;

        /* renamed from: i  reason: collision with root package name */
        Function<Clock, AnalyticsCollector> f5251i;

        /* renamed from: j  reason: collision with root package name */
        Looper f5252j;

        /* renamed from: k  reason: collision with root package name */
        int f5253k;

        /* renamed from: l  reason: collision with root package name */
        PriorityTaskManager f5254l;

        /* renamed from: m  reason: collision with root package name */
        AudioAttributes f5255m;

        /* renamed from: n  reason: collision with root package name */
        boolean f5256n;

        /* renamed from: o  reason: collision with root package name */
        int f5257o;

        /* renamed from: p  reason: collision with root package name */
        boolean f5258p;

        /* renamed from: q  reason: collision with root package name */
        boolean f5259q;

        /* renamed from: r  reason: collision with root package name */
        boolean f5260r;

        /* renamed from: s  reason: collision with root package name */
        int f5261s;

        /* renamed from: t  reason: collision with root package name */
        int f5262t;

        /* renamed from: u  reason: collision with root package name */
        boolean f5263u;

        /* renamed from: v  reason: collision with root package name */
        SeekParameters f5264v;

        /* renamed from: w  reason: collision with root package name */
        long f5265w;

        /* renamed from: x  reason: collision with root package name */
        long f5266x;

        /* renamed from: y  reason: collision with root package name */
        long f5267y;

        /* renamed from: z  reason: collision with root package name */
        LivePlaybackSpeedControl f5268z;

        public Builder(Context context) {
            this(context, new i(context), new j(context));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory i(Context context) {
            return new DefaultRenderersFactory(context);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory j(Context context) {
            return new DefaultMediaSourceFactory(context, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector k(Context context) {
            return new DefaultTrackSelector(context);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LoadControl m(LoadControl loadControl) {
            return loadControl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory n(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector o(TrackSelector trackSelector) {
            return trackSelector;
        }

        public ExoPlayer h() {
            Assertions.h(!this.F);
            this.F = true;
            return new ExoPlayerImpl(this, (Player) null);
        }

        public Builder p(LoadControl loadControl) {
            Assertions.h(!this.F);
            Assertions.f(loadControl);
            this.f5249g = new h(loadControl);
            return this;
        }

        public Builder q(RenderersFactory renderersFactory) {
            Assertions.h(!this.F);
            Assertions.f(renderersFactory);
            this.f5246d = new k(renderersFactory);
            return this;
        }

        public Builder r(SeekParameters seekParameters) {
            Assertions.h(!this.F);
            this.f5264v = (SeekParameters) Assertions.f(seekParameters);
            return this;
        }

        public Builder s(TrackSelector trackSelector) {
            Assertions.h(!this.F);
            Assertions.f(trackSelector);
            this.f5248f = new l(trackSelector);
            return this;
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2) {
            this(context, supplier, supplier2, new m(context), new n(), new o(context), new p());
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Function<Clock, AnalyticsCollector> function) {
            this.f5243a = (Context) Assertions.f(context);
            this.f5246d = supplier;
            this.f5247e = supplier2;
            this.f5248f = supplier3;
            this.f5249g = supplier4;
            this.f5250h = supplier5;
            this.f5251i = function;
            this.f5252j = Util.U();
            this.f5255m = AudioAttributes.f3909g;
            this.f5257o = 0;
            this.f5261s = 1;
            this.f5262t = 0;
            this.f5263u = true;
            this.f5264v = SeekParameters.f5514g;
            this.f5265w = 5000;
            this.f5266x = 15000;
            this.f5267y = 3000;
            this.f5268z = new DefaultLivePlaybackSpeedControl.Builder().a();
            this.f5244b = Clock.f4616a;
            this.A = 500;
            this.B = 2000;
            this.D = true;
            this.H = "";
            this.f5253k = MaxErrorCode.NETWORK_ERROR;
        }
    }

    public static class PreloadConfiguration {

        /* renamed from: b  reason: collision with root package name */
        public static final PreloadConfiguration f5269b = new PreloadConfiguration(-9223372036854775807L);

        /* renamed from: a  reason: collision with root package name */
        public final long f5270a;

        public PreloadConfiguration(long j2) {
            this.f5270a = j2;
        }
    }

    void X(boolean z2);

    Format Z();

    Format a();

    TrackSelector c();

    void d(MediaSource mediaSource, long j2);

    void release();

    void setImageOutput(ImageOutput imageOutput);
}
