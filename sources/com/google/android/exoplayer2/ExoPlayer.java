package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

public interface ExoPlayer extends Player {

    public interface AudioOffloadListener {
        void A(boolean z2);

        void B(boolean z2);
    }

    public static final class Builder {
        boolean A;
        Looper B;
        boolean C;

        /* renamed from: a  reason: collision with root package name */
        final Context f22905a;

        /* renamed from: b  reason: collision with root package name */
        Clock f22906b;

        /* renamed from: c  reason: collision with root package name */
        long f22907c;

        /* renamed from: d  reason: collision with root package name */
        Supplier<RenderersFactory> f22908d;

        /* renamed from: e  reason: collision with root package name */
        Supplier<MediaSource.Factory> f22909e;

        /* renamed from: f  reason: collision with root package name */
        Supplier<TrackSelector> f22910f;

        /* renamed from: g  reason: collision with root package name */
        Supplier<LoadControl> f22911g;

        /* renamed from: h  reason: collision with root package name */
        Supplier<BandwidthMeter> f22912h;

        /* renamed from: i  reason: collision with root package name */
        Function<Clock, AnalyticsCollector> f22913i;

        /* renamed from: j  reason: collision with root package name */
        Looper f22914j;

        /* renamed from: k  reason: collision with root package name */
        PriorityTaskManager f22915k;

        /* renamed from: l  reason: collision with root package name */
        AudioAttributes f22916l;

        /* renamed from: m  reason: collision with root package name */
        boolean f22917m;

        /* renamed from: n  reason: collision with root package name */
        int f22918n;

        /* renamed from: o  reason: collision with root package name */
        boolean f22919o;

        /* renamed from: p  reason: collision with root package name */
        boolean f22920p;

        /* renamed from: q  reason: collision with root package name */
        int f22921q;

        /* renamed from: r  reason: collision with root package name */
        int f22922r;

        /* renamed from: s  reason: collision with root package name */
        boolean f22923s;

        /* renamed from: t  reason: collision with root package name */
        SeekParameters f22924t;

        /* renamed from: u  reason: collision with root package name */
        long f22925u;

        /* renamed from: v  reason: collision with root package name */
        long f22926v;

        /* renamed from: w  reason: collision with root package name */
        LivePlaybackSpeedControl f22927w;

        /* renamed from: x  reason: collision with root package name */
        long f22928x;

        /* renamed from: y  reason: collision with root package name */
        long f22929y;

        /* renamed from: z  reason: collision with root package name */
        boolean f22930z;

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
        public static /* synthetic */ MediaSource.Factory n(MediaSource.Factory factory) {
            return factory;
        }

        public ExoPlayer g() {
            Assertions.g(!this.C);
            this.C = true;
            return new ExoPlayerImpl(this, (Player) null);
        }

        /* access modifiers changed from: package-private */
        public SimpleExoPlayer h() {
            Assertions.g(!this.C);
            this.C = true;
            return new SimpleExoPlayer(this);
        }

        public Builder o(LoadControl loadControl) {
            Assertions.g(!this.C);
            Assertions.e(loadControl);
            this.f22911g = new h(loadControl);
            return this;
        }

        public Builder p(MediaSource.Factory factory) {
            Assertions.g(!this.C);
            Assertions.e(factory);
            this.f22909e = new g(factory);
            return this;
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2) {
            this(context, supplier, supplier2, new k(context), new l(), new m(context), new n());
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Function<Clock, AnalyticsCollector> function) {
            this.f22905a = (Context) Assertions.e(context);
            this.f22908d = supplier;
            this.f22909e = supplier2;
            this.f22910f = supplier3;
            this.f22911g = supplier4;
            this.f22912h = supplier5;
            this.f22913i = function;
            this.f22914j = Util.Q();
            this.f22916l = AudioAttributes.f23655h;
            this.f22918n = 0;
            this.f22921q = 1;
            this.f22922r = 0;
            this.f22923s = true;
            this.f22924t = SeekParameters.f23456g;
            this.f22925u = 5000;
            this.f22926v = 15000;
            this.f22927w = new DefaultLivePlaybackSpeedControl.Builder().a();
            this.f22906b = Clock.f28651a;
            this.f22928x = 500;
            this.f22929y = 2000;
            this.A = true;
        }
    }

    Format a();
}
