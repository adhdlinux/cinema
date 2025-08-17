package com.google.android.exoplayer2.source;

import android.content.Context;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class DefaultMediaSourceFactory implements MediaSource.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final DelegateFactoryLoader f25733a;

    /* renamed from: b  reason: collision with root package name */
    private DataSource.Factory f25734b;

    /* renamed from: c  reason: collision with root package name */
    private MediaSource.Factory f25735c;

    /* renamed from: d  reason: collision with root package name */
    private LoadErrorHandlingPolicy f25736d;

    /* renamed from: e  reason: collision with root package name */
    private long f25737e;

    /* renamed from: f  reason: collision with root package name */
    private long f25738f;

    /* renamed from: g  reason: collision with root package name */
    private long f25739g;

    /* renamed from: h  reason: collision with root package name */
    private float f25740h;

    /* renamed from: i  reason: collision with root package name */
    private float f25741i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25742j;

    private static final class DelegateFactoryLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorsFactory f25743a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Integer, Supplier<MediaSource.Factory>> f25744b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Set<Integer> f25745c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private final Map<Integer, MediaSource.Factory> f25746d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private DataSource.Factory f25747e;

        /* renamed from: f  reason: collision with root package name */
        private DrmSessionManagerProvider f25748f;

        /* renamed from: g  reason: collision with root package name */
        private LoadErrorHandlingPolicy f25749g;

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory) {
            this.f25743a = extractorsFactory;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory k(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.f25743a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource.Factory> l(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.f25744b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L_0x0019
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.f25744b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                com.google.common.base.Supplier r5 = (com.google.common.base.Supplier) r5
                return r5
            L_0x0019:
                com.google.android.exoplayer2.upstream.DataSource$Factory r0 = r4.f25747e
                java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)
                com.google.android.exoplayer2.upstream.DataSource$Factory r0 = (com.google.android.exoplayer2.upstream.DataSource.Factory) r0
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r1 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                r2 = 0
                if (r5 == 0) goto L_0x0060
                r3 = 1
                if (r5 == r3) goto L_0x0054
                r3 = 2
                if (r5 == r3) goto L_0x0048
                r3 = 3
                if (r5 == r3) goto L_0x003c
                r1 = 4
                if (r5 == r1) goto L_0x0033
                goto L_0x006c
            L_0x0033:
                com.google.android.exoplayer2.source.g r1 = new com.google.android.exoplayer2.source.g     // Catch:{ ClassNotFoundException -> 0x003a }
                r1.<init>(r4, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
            L_0x0038:
                r2 = r1
                goto L_0x006c
            L_0x003a:
                goto L_0x006c
            L_0x003c:
                java.lang.Class<com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory> r0 = com.google.android.exoplayer2.source.rtsp.RtspMediaSource.Factory.class
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                com.google.android.exoplayer2.source.f r1 = new com.google.android.exoplayer2.source.f     // Catch:{ ClassNotFoundException -> 0x003a }
                r1.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x0038
            L_0x0048:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                com.google.android.exoplayer2.source.e r3 = new com.google.android.exoplayer2.source.e     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x006b
            L_0x0054:
                java.lang.Class<com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                com.google.android.exoplayer2.source.d r3 = new com.google.android.exoplayer2.source.d     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x006b
            L_0x0060:
                java.lang.Class<com.google.android.exoplayer2.source.dash.DashMediaSource$Factory> r3 = com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                com.google.android.exoplayer2.source.c r3 = new com.google.android.exoplayer2.source.c     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
            L_0x006b:
                r2 = r3
            L_0x006c:
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory>> r0 = r4.f25744b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L_0x0080
                java.util.Set<java.lang.Integer> r0 = r4.f25745c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L_0x0080:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.DefaultMediaSourceFactory.DelegateFactoryLoader.l(int):com.google.common.base.Supplier");
        }

        public MediaSource.Factory f(int i2) {
            MediaSource.Factory factory = this.f25746d.get(Integer.valueOf(i2));
            if (factory != null) {
                return factory;
            }
            Supplier<MediaSource.Factory> l2 = l(i2);
            if (l2 == null) {
                return null;
            }
            MediaSource.Factory factory2 = l2.get();
            DrmSessionManagerProvider drmSessionManagerProvider = this.f25748f;
            if (drmSessionManagerProvider != null) {
                factory2.b(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f25749g;
            if (loadErrorHandlingPolicy != null) {
                factory2.c(loadErrorHandlingPolicy);
            }
            this.f25746d.put(Integer.valueOf(i2), factory2);
            return factory2;
        }

        public void m(DataSource.Factory factory) {
            if (factory != this.f25747e) {
                this.f25747e = factory;
                this.f25744b.clear();
                this.f25746d.clear();
            }
        }

        public void n(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f25748f = drmSessionManagerProvider;
            for (MediaSource.Factory b2 : this.f25746d.values()) {
                b2.b(drmSessionManagerProvider);
            }
        }

        public void o(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f25749g = loadErrorHandlingPolicy;
            for (MediaSource.Factory c2 : this.f25746d.values()) {
                c2.c(loadErrorHandlingPolicy);
            }
        }
    }

    private static final class UnknownSubtitlesExtractor implements Extractor {

        /* renamed from: a  reason: collision with root package name */
        private final Format f25750a;

        public UnknownSubtitlesExtractor(Format format) {
            this.f25750a = format;
        }

        public void a(long j2, long j3) {
        }

        public void c(ExtractorOutput extractorOutput) {
            TrackOutput d2 = extractorOutput.d(0, 3);
            extractorOutput.u(new SeekMap.Unseekable(-9223372036854775807L));
            extractorOutput.m();
            d2.d(this.f25750a.b().g0("text/x-unknown").K(this.f25750a.f23071m).G());
        }

        public boolean g(ExtractorInput extractorInput) {
            return true;
        }

        public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.a(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        public void release() {
        }
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context), extractorsFactory);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] g(Format format) {
        Extractor extractor;
        Extractor[] extractorArr = new Extractor[1];
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.f27252a;
        if (subtitleDecoderFactory.c(format)) {
            extractor = new SubtitleExtractor(subtitleDecoderFactory.a(format), format);
        } else {
            extractor = new UnknownSubtitlesExtractor(format);
        }
        extractorArr[0] = extractor;
        return extractorArr;
    }

    private static MediaSource h(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.f23133g;
        if (clippingConfiguration.f23155b == 0 && clippingConfiguration.f23156c == Long.MIN_VALUE && !clippingConfiguration.f23158e) {
            return mediaSource;
        }
        long F0 = Util.F0(mediaItem.f23133g.f23155b);
        long F02 = Util.F0(mediaItem.f23133g.f23156c);
        MediaItem.ClippingConfiguration clippingConfiguration2 = mediaItem.f23133g;
        return new ClippingMediaSource(mediaSource, F0, F02, !clippingConfiguration2.f23159f, clippingConfiguration2.f23157d, clippingConfiguration2.f23158e);
    }

    private MediaSource i(MediaItem mediaItem, MediaSource mediaSource) {
        Assertions.e(mediaItem.f23129c);
        mediaItem.f23129c.getClass();
        return mediaSource;
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory j(Class<? extends MediaSource.Factory> cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory k(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory});
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public MediaSource a(MediaItem mediaItem) {
        Assertions.e(mediaItem.f23129c);
        String scheme = mediaItem.f23129c.f23202a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((MediaSource.Factory) Assertions.e(this.f25735c)).a(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f23129c;
        int s02 = Util.s0(localConfiguration.f23202a, localConfiguration.f23203b);
        MediaSource.Factory f2 = this.f25733a.f(s02);
        Assertions.j(f2, "No suitable media source factory found for content type: " + s02);
        MediaItem.LiveConfiguration.Builder b2 = mediaItem.f23131e.b();
        if (mediaItem.f23131e.f23192b == -9223372036854775807L) {
            b2.k(this.f25737e);
        }
        if (mediaItem.f23131e.f23195e == -3.4028235E38f) {
            b2.j(this.f25740h);
        }
        if (mediaItem.f23131e.f23196f == -3.4028235E38f) {
            b2.h(this.f25741i);
        }
        if (mediaItem.f23131e.f23193c == -9223372036854775807L) {
            b2.i(this.f25738f);
        }
        if (mediaItem.f23131e.f23194d == -9223372036854775807L) {
            b2.g(this.f25739g);
        }
        MediaItem.LiveConfiguration f3 = b2.f();
        if (!f3.equals(mediaItem.f23131e)) {
            mediaItem = mediaItem.b().c(f3).a();
        }
        MediaSource a2 = f2.a(mediaItem);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.j(mediaItem.f23129c)).f23207f;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(immutableList.size() + 1)];
            mediaSourceArr[0] = a2;
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                if (this.f25742j) {
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.f25734b, (ExtractorsFactory) new b(new Format.Builder().g0(immutableList.get(i2).f23222b).X(immutableList.get(i2).f23223c).i0(immutableList.get(i2).f23224d).e0(immutableList.get(i2).f23225e).W(immutableList.get(i2).f23226f).U(immutableList.get(i2).f23227g).G()));
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f25736d;
                    if (loadErrorHandlingPolicy != null) {
                        factory.c(loadErrorHandlingPolicy);
                    }
                    mediaSourceArr[i2 + 1] = factory.a(MediaItem.e(immutableList.get(i2).f23221a.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.f25734b);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f25736d;
                    if (loadErrorHandlingPolicy2 != null) {
                        factory2.b(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i2 + 1] = factory2.a(immutableList.get(i2), -9223372036854775807L);
                }
            }
            a2 = new MergingMediaSource(mediaSourceArr);
        }
        return i(mediaItem, h(mediaItem, a2));
    }

    /* renamed from: l */
    public DefaultMediaSourceFactory b(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.f25733a.n((DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    /* renamed from: m */
    public DefaultMediaSourceFactory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f25736d = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f25733a.o(loadErrorHandlingPolicy);
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f25734b = factory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(extractorsFactory);
        this.f25733a = delegateFactoryLoader;
        delegateFactoryLoader.m(factory);
        this.f25737e = -9223372036854775807L;
        this.f25738f = -9223372036854775807L;
        this.f25739g = -9223372036854775807L;
        this.f25740h = -3.4028235E38f;
        this.f25741i = -3.4028235E38f;
    }
}
