package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

public final class SingleSampleMediaSource extends BaseMediaSource {

    /* renamed from: i  reason: collision with root package name */
    private final DataSpec f25982i;

    /* renamed from: j  reason: collision with root package name */
    private final DataSource.Factory f25983j;

    /* renamed from: k  reason: collision with root package name */
    private final Format f25984k;

    /* renamed from: l  reason: collision with root package name */
    private final long f25985l;

    /* renamed from: m  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f25986m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f25987n;

    /* renamed from: o  reason: collision with root package name */
    private final Timeline f25988o;

    /* renamed from: p  reason: collision with root package name */
    private final MediaItem f25989p;

    /* renamed from: q  reason: collision with root package name */
    private TransferListener f25990q;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f25991a;

        /* renamed from: b  reason: collision with root package name */
        private LoadErrorHandlingPolicy f25992b = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: c  reason: collision with root package name */
        private boolean f25993c = true;

        /* renamed from: d  reason: collision with root package name */
        private Object f25994d;

        /* renamed from: e  reason: collision with root package name */
        private String f25995e;

        public Factory(DataSource.Factory factory) {
            this.f25991a = (DataSource.Factory) Assertions.e(factory);
        }

        public SingleSampleMediaSource a(MediaItem.SubtitleConfiguration subtitleConfiguration, long j2) {
            return new SingleSampleMediaSource(this.f25995e, subtitleConfiguration, this.f25991a, j2, this.f25992b, this.f25993c, this.f25994d);
        }

        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.f25992b = loadErrorHandlingPolicy;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.f25990q = transferListener;
        D(this.f25988o);
    }

    /* access modifiers changed from: protected */
    public void E() {
    }

    public MediaItem a() {
        return this.f25989p;
    }

    public void c() {
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new SingleSampleMediaPeriod(this.f25982i, this.f25983j, this.f25990q, this.f25984k, this.f25985l, this.f25986m, w(mediaPeriodId), this.f25987n);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).u();
    }

    private SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z2, Object obj) {
        MediaItem.SubtitleConfiguration subtitleConfiguration2 = subtitleConfiguration;
        this.f25983j = factory;
        this.f25985l = j2;
        this.f25986m = loadErrorHandlingPolicy;
        this.f25987n = z2;
        MediaItem a2 = new MediaItem.Builder().i(Uri.EMPTY).d(subtitleConfiguration2.f23221a.toString()).g(ImmutableList.s(subtitleConfiguration)).h(obj).a();
        this.f25989p = a2;
        Format.Builder W = new Format.Builder().g0((String) MoreObjects.a(subtitleConfiguration2.f23222b, "text/x-unknown")).X(subtitleConfiguration2.f23223c).i0(subtitleConfiguration2.f23224d).e0(subtitleConfiguration2.f23225e).W(subtitleConfiguration2.f23226f);
        String str2 = subtitleConfiguration2.f23227g;
        this.f25984k = W.U(str2 == null ? str : str2).G();
        this.f25982i = new DataSpec.Builder().i(subtitleConfiguration2.f23221a).b(1).a();
        this.f25988o = new SinglePeriodTimeline(j2, true, false, false, (Object) null, a2);
    }
}
