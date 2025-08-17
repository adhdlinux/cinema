package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;

public final class ExternallyLoadedMediaSource extends BaseMediaSource {

    /* renamed from: h  reason: collision with root package name */
    private final ExternalLoader f6924h;

    /* renamed from: i  reason: collision with root package name */
    private final long f6925i;

    /* renamed from: j  reason: collision with root package name */
    private MediaItem f6926j;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final long f6927a;

        /* renamed from: b  reason: collision with root package name */
        private final ExternalLoader f6928b;

        public Factory(long j2, ExternalLoader externalLoader) {
            this.f6927a = j2;
            this.f6928b = externalLoader;
        }

        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return k.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z2) {
            return k.a(this, z2);
        }

        public MediaSource.Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public MediaSource.Factory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public /* synthetic */ MediaSource.Factory f(CmcdConfiguration.Factory factory) {
            return k.b(this, factory);
        }

        /* renamed from: g */
        public ExternallyLoadedMediaSource c(MediaItem mediaItem) {
            return new ExternallyLoadedMediaSource(mediaItem, this.f6927a, this.f6928b);
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
    }

    public synchronized MediaItem a() {
        return this.f6926j;
    }

    public void c() {
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaItem a2 = a();
        Assertions.f(a2.f4079b);
        Assertions.g(a2.f4079b.f4172b, "Externally loaded mediaItems require a MIME type.");
        MediaItem.LocalConfiguration localConfiguration = a2.f4079b;
        return new ExternallyLoadedMediaPeriod(localConfiguration.f4171a, localConfiguration.f4172b, this.f6924h);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((ExternallyLoadedMediaPeriod) mediaPeriod).p();
    }

    public synchronized void o(MediaItem mediaItem) {
        this.f6926j = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        A(new SinglePeriodTimeline(this.f6925i, true, false, false, (Object) null, a()));
    }

    private ExternallyLoadedMediaSource(MediaItem mediaItem, long j2, ExternalLoader externalLoader) {
        this.f6926j = mediaItem;
        this.f6925i = j2;
        this.f6924h = externalLoader;
    }
}
