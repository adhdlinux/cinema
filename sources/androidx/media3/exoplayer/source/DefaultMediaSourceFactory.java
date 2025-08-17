package androidx.media3.exoplayer.source;

import android.content.Context;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.source.ExternallyLoadedMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.SingleSampleMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class DefaultMediaSourceFactory implements MediaSource.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final DelegateFactoryLoader f6891a;

    /* renamed from: b  reason: collision with root package name */
    private DataSource.Factory f6892b;

    /* renamed from: c  reason: collision with root package name */
    private SubtitleParser.Factory f6893c;

    /* renamed from: d  reason: collision with root package name */
    private MediaSource.Factory f6894d;

    /* renamed from: e  reason: collision with root package name */
    private ExternalLoader f6895e;

    /* renamed from: f  reason: collision with root package name */
    private LoadErrorHandlingPolicy f6896f;

    /* renamed from: g  reason: collision with root package name */
    private long f6897g;

    /* renamed from: h  reason: collision with root package name */
    private long f6898h;

    /* renamed from: i  reason: collision with root package name */
    private long f6899i;

    /* renamed from: j  reason: collision with root package name */
    private float f6900j;

    /* renamed from: k  reason: collision with root package name */
    private float f6901k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6902l;

    private static final class DelegateFactoryLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorsFactory f6903a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Integer, Supplier<MediaSource.Factory>> f6904b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map<Integer, MediaSource.Factory> f6905c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private DataSource.Factory f6906d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6907e = true;

        /* renamed from: f  reason: collision with root package name */
        private SubtitleParser.Factory f6908f;

        /* renamed from: g  reason: collision with root package name */
        private CmcdConfiguration.Factory f6909g;

        /* renamed from: h  reason: collision with root package name */
        private DrmSessionManagerProvider f6910h;

        /* renamed from: i  reason: collision with root package name */
        private LoadErrorHandlingPolicy f6911i;

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
            this.f6903a = extractorsFactory;
            this.f6908f = factory;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory k(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.f6903a);
        }

        private Supplier<MediaSource.Factory> l(int i2) throws ClassNotFoundException {
            Supplier<MediaSource.Factory> supplier;
            Supplier<MediaSource.Factory> supplier2;
            Supplier<MediaSource.Factory> supplier3 = this.f6904b.get(Integer.valueOf(i2));
            if (supplier3 != null) {
                return supplier3;
            }
            DataSource.Factory factory = (DataSource.Factory) Assertions.f(this.f6906d);
            Class<MediaSource.Factory> cls = MediaSource.Factory.class;
            if (i2 == 0) {
                supplier2 = new e(DashMediaSource.Factory.class.asSubclass(cls), factory);
            } else if (i2 == 1) {
                supplier2 = new f(Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(cls), factory);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    supplier = new h(Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(cls));
                } else if (i2 == 4) {
                    supplier = new i(this, factory);
                } else {
                    throw new IllegalArgumentException("Unrecognized contentType: " + i2);
                }
                this.f6904b.put(Integer.valueOf(i2), supplier);
                return supplier;
            } else {
                supplier2 = new g(HlsMediaSource.Factory.class.asSubclass(cls), factory);
            }
            supplier = supplier2;
            this.f6904b.put(Integer.valueOf(i2), supplier);
            return supplier;
        }

        public MediaSource.Factory f(int i2) throws ClassNotFoundException {
            MediaSource.Factory factory = this.f6905c.get(Integer.valueOf(i2));
            if (factory != null) {
                return factory;
            }
            MediaSource.Factory factory2 = l(i2).get();
            CmcdConfiguration.Factory factory3 = this.f6909g;
            if (factory3 != null) {
                factory2.f(factory3);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.f6910h;
            if (drmSessionManagerProvider != null) {
                factory2.d(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f6911i;
            if (loadErrorHandlingPolicy != null) {
                factory2.e(loadErrorHandlingPolicy);
            }
            factory2.a(this.f6908f);
            factory2.b(this.f6907e);
            this.f6905c.put(Integer.valueOf(i2), factory2);
            return factory2;
        }

        public void m(CmcdConfiguration.Factory factory) {
            this.f6909g = factory;
            for (MediaSource.Factory f2 : this.f6905c.values()) {
                f2.f(factory);
            }
        }

        public void n(DataSource.Factory factory) {
            if (factory != this.f6906d) {
                this.f6906d = factory;
                this.f6904b.clear();
                this.f6905c.clear();
            }
        }

        public void o(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f6910h = drmSessionManagerProvider;
            for (MediaSource.Factory d2 : this.f6905c.values()) {
                d2.d(drmSessionManagerProvider);
            }
        }

        public void p(int i2) {
            ExtractorsFactory extractorsFactory = this.f6903a;
            if (extractorsFactory instanceof DefaultExtractorsFactory) {
                ((DefaultExtractorsFactory) extractorsFactory).k(i2);
            }
        }

        public void q(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f6911i = loadErrorHandlingPolicy;
            for (MediaSource.Factory e2 : this.f6905c.values()) {
                e2.e(loadErrorHandlingPolicy);
            }
        }

        public void r(boolean z2) {
            this.f6907e = z2;
            this.f6903a.d(z2);
            for (MediaSource.Factory b2 : this.f6905c.values()) {
                b2.b(z2);
            }
        }

        public void s(SubtitleParser.Factory factory) {
            this.f6908f = factory;
            this.f6903a.a(factory);
            for (MediaSource.Factory a2 : this.f6905c.values()) {
                a2.a(factory);
            }
        }
    }

    private static final class UnknownSubtitlesExtractor implements Extractor {

        /* renamed from: a  reason: collision with root package name */
        private final Format f6912a;

        public UnknownSubtitlesExtractor(Format format) {
            this.f6912a = format;
        }

        public void a(long j2, long j3) {
        }

        public /* synthetic */ Extractor c() {
            return d.b(this);
        }

        public void g(ExtractorOutput extractorOutput) {
            TrackOutput d2 = extractorOutput.d(0, 3);
            extractorOutput.r(new SeekMap.Unseekable(-9223372036854775807L));
            extractorOutput.m();
            d2.c(this.f6912a.a().o0("text/x-unknown").O(this.f6912a.f4015n).K());
        }

        public boolean i(ExtractorInput extractorInput) {
            return true;
        }

        public /* synthetic */ List j() {
            return d.a(this);
        }

        public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.a(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        public void release() {
        }
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Extractor[] k(Format format) {
        Extractor extractor;
        Extractor[] extractorArr = new Extractor[1];
        if (this.f6893c.c(format)) {
            extractor = new SubtitleExtractor(this.f6893c.b(format), format);
        } else {
            extractor = new UnknownSubtitlesExtractor(format);
        }
        extractorArr[0] = extractor;
        return extractorArr;
    }

    private static MediaSource l(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.f4083f;
        if (clippingConfiguration.f4108b == 0 && clippingConfiguration.f4110d == Long.MIN_VALUE && !clippingConfiguration.f4112f) {
            return mediaSource;
        }
        MediaItem.ClippingConfiguration clippingConfiguration2 = mediaItem.f4083f;
        return new ClippingMediaSource(mediaSource, clippingConfiguration2.f4108b, clippingConfiguration2.f4110d, !clippingConfiguration2.f4113g, clippingConfiguration2.f4111e, clippingConfiguration2.f4112f);
    }

    private MediaSource m(MediaItem mediaItem, MediaSource mediaSource) {
        Assertions.f(mediaItem.f4079b);
        mediaItem.f4079b.getClass();
        return mediaSource;
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory n(Class<? extends MediaSource.Factory> cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory o(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory});
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public MediaSource c(MediaItem mediaItem) {
        Assertions.f(mediaItem.f4079b);
        String scheme = mediaItem.f4079b.f4171a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((MediaSource.Factory) Assertions.f(this.f6894d)).c(mediaItem);
        }
        if (Objects.equals(mediaItem.f4079b.f4172b, "application/x-image-uri")) {
            return new ExternallyLoadedMediaSource.Factory(Util.P0(mediaItem.f4079b.f4179i), (ExternalLoader) Assertions.f(this.f6895e)).c(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f4079b;
        int z02 = Util.z0(localConfiguration.f4171a, localConfiguration.f4172b);
        if (mediaItem.f4079b.f4179i != -9223372036854775807L) {
            this.f6891a.p(1);
        }
        try {
            MediaSource.Factory f2 = this.f6891a.f(z02);
            MediaItem.LiveConfiguration.Builder a2 = mediaItem.f4081d.a();
            if (mediaItem.f4081d.f4153a == -9223372036854775807L) {
                a2.k(this.f6897g);
            }
            if (mediaItem.f4081d.f4156d == -3.4028235E38f) {
                a2.j(this.f6900j);
            }
            if (mediaItem.f4081d.f4157e == -3.4028235E38f) {
                a2.h(this.f6901k);
            }
            if (mediaItem.f4081d.f4154b == -9223372036854775807L) {
                a2.i(this.f6898h);
            }
            if (mediaItem.f4081d.f4155c == -9223372036854775807L) {
                a2.g(this.f6899i);
            }
            MediaItem.LiveConfiguration f3 = a2.f();
            if (!f3.equals(mediaItem.f4081d)) {
                mediaItem = mediaItem.a().b(f3).a();
            }
            MediaSource c2 = f2.c(mediaItem);
            ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.i(mediaItem.f4079b)).f4176f;
            if (!immutableList.isEmpty()) {
                MediaSource[] mediaSourceArr = new MediaSource[(immutableList.size() + 1)];
                mediaSourceArr[0] = c2;
                for (int i2 = 0; i2 < immutableList.size(); i2++) {
                    if (this.f6902l) {
                        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.f6892b, (ExtractorsFactory) new d(this, new Format.Builder().o0(immutableList.get(i2).f4198b).e0(immutableList.get(i2).f4199c).q0(immutableList.get(i2).f4200d).m0(immutableList.get(i2).f4201e).c0(immutableList.get(i2).f4202f).a0(immutableList.get(i2).f4203g).K()));
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f6896f;
                        if (loadErrorHandlingPolicy != null) {
                            factory.e(loadErrorHandlingPolicy);
                        }
                        mediaSourceArr[i2 + 1] = factory.c(MediaItem.b(immutableList.get(i2).f4197a.toString()));
                    } else {
                        SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.f6892b);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f6896f;
                        if (loadErrorHandlingPolicy2 != null) {
                            factory2.b(loadErrorHandlingPolicy2);
                        }
                        mediaSourceArr[i2 + 1] = factory2.a(immutableList.get(i2), -9223372036854775807L);
                    }
                }
                c2 = new MergingMediaSource(mediaSourceArr);
            }
            return m(mediaItem, l(mediaItem, c2));
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Deprecated
    /* renamed from: j */
    public DefaultMediaSourceFactory b(boolean z2) {
        this.f6902l = z2;
        this.f6891a.r(z2);
        return this;
    }

    /* renamed from: p */
    public DefaultMediaSourceFactory f(CmcdConfiguration.Factory factory) {
        this.f6891a.m((CmcdConfiguration.Factory) Assertions.f(factory));
        return this;
    }

    /* renamed from: q */
    public DefaultMediaSourceFactory d(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.f6891a.o((DrmSessionManagerProvider) Assertions.g(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    /* renamed from: r */
    public DefaultMediaSourceFactory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f6896f = (LoadErrorHandlingPolicy) Assertions.g(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f6891a.q(loadErrorHandlingPolicy);
        return this;
    }

    /* renamed from: s */
    public DefaultMediaSourceFactory a(SubtitleParser.Factory factory) {
        this.f6893c = (SubtitleParser.Factory) Assertions.f(factory);
        this.f6891a.s(factory);
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f6892b = factory;
        DefaultSubtitleParserFactory defaultSubtitleParserFactory = new DefaultSubtitleParserFactory();
        this.f6893c = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(extractorsFactory, defaultSubtitleParserFactory);
        this.f6891a = delegateFactoryLoader;
        delegateFactoryLoader.n(factory);
        this.f6897g = -9223372036854775807L;
        this.f6898h = -9223372036854775807L;
        this.f6899i = -9223372036854775807L;
        this.f6900j = -3.4028235E38f;
        this.f6901k = -3.4028235E38f;
        this.f6902l = true;
    }
}
