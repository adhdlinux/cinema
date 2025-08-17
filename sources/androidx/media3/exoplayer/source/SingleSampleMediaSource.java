package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

public final class SingleSampleMediaSource extends BaseMediaSource {

    /* renamed from: h  reason: collision with root package name */
    private final DataSpec f7153h;

    /* renamed from: i  reason: collision with root package name */
    private final DataSource.Factory f7154i;

    /* renamed from: j  reason: collision with root package name */
    private final Format f7155j;

    /* renamed from: k  reason: collision with root package name */
    private final long f7156k;

    /* renamed from: l  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f7157l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f7158m;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline f7159n;

    /* renamed from: o  reason: collision with root package name */
    private final MediaItem f7160o;

    /* renamed from: p  reason: collision with root package name */
    private TransferListener f7161p;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f7162a;

        /* renamed from: b  reason: collision with root package name */
        private LoadErrorHandlingPolicy f7163b = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: c  reason: collision with root package name */
        private boolean f7164c = true;

        /* renamed from: d  reason: collision with root package name */
        private Object f7165d;

        /* renamed from: e  reason: collision with root package name */
        private String f7166e;

        public Factory(DataSource.Factory factory) {
            this.f7162a = (DataSource.Factory) Assertions.f(factory);
        }

        public SingleSampleMediaSource a(MediaItem.SubtitleConfiguration subtitleConfiguration, long j2) {
            return new SingleSampleMediaSource(this.f7166e, subtitleConfiguration, this.f7162a, j2, this.f7163b, this.f7164c, this.f7165d);
        }

        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.f7163b = loadErrorHandlingPolicy;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
    }

    public MediaItem a() {
        return this.f7160o;
    }

    public void c() {
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new SingleSampleMediaPeriod(this.f7153h, this.f7154i, this.f7161p, this.f7155j, this.f7156k, this.f7157l, u(mediaPeriodId), this.f7158m);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).r();
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        this.f7161p = transferListener;
        A(this.f7159n);
    }

    private SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z2, Object obj) {
        MediaItem.SubtitleConfiguration subtitleConfiguration2 = subtitleConfiguration;
        this.f7154i = factory;
        this.f7156k = j2;
        this.f7157l = loadErrorHandlingPolicy;
        this.f7158m = z2;
        MediaItem a2 = new MediaItem.Builder().g(Uri.EMPTY).c(subtitleConfiguration2.f4197a.toString()).e(ImmutableList.s(subtitleConfiguration)).f(obj).a();
        this.f7160o = a2;
        Format.Builder c02 = new Format.Builder().o0((String) MoreObjects.a(subtitleConfiguration2.f4198b, "text/x-unknown")).e0(subtitleConfiguration2.f4199c).q0(subtitleConfiguration2.f4200d).m0(subtitleConfiguration2.f4201e).c0(subtitleConfiguration2.f4202f);
        String str2 = subtitleConfiguration2.f4203g;
        this.f7155j = c02.a0(str2 == null ? str : str2).K();
        this.f7153h = new DataSpec.Builder().i(subtitleConfiguration2.f4197a).b(1).a();
        this.f7159n = new SinglePeriodTimeline(j2, true, false, false, (Object) null, a2);
    }
}
