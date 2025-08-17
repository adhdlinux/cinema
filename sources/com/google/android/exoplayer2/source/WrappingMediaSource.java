package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: m  reason: collision with root package name */
    private static final Void f26014m = null;

    /* renamed from: l  reason: collision with root package name */
    protected final MediaSource f26015l;

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.f26015l = mediaSource;
    }

    /* access modifiers changed from: protected */
    public final void C(TransferListener transferListener) {
        super.C(transferListener);
        V();
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId M(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public final MediaSource.MediaPeriodId G(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return M(mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public long O(long j2) {
        return j2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: P */
    public final long H(Void voidR, long j2) {
        return O(j2);
    }

    /* access modifiers changed from: protected */
    public int Q(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: R */
    public final int I(Void voidR, int i2) {
        return Q(i2);
    }

    /* access modifiers changed from: protected */
    public void S(Timeline timeline) {
        D(timeline);
    }

    /* access modifiers changed from: protected */
    /* renamed from: T */
    public final void K(Void voidR, MediaSource mediaSource, Timeline timeline) {
        S(timeline);
    }

    /* access modifiers changed from: protected */
    public final void U() {
        L(f26014m, this.f26015l);
    }

    /* access modifiers changed from: protected */
    public void V() {
        U();
    }

    public MediaItem a() {
        return this.f26015l.a();
    }

    public boolean d() {
        return this.f26015l.d();
    }

    public Timeline e() {
        return this.f26015l.e();
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return this.f26015l.f(mediaPeriodId, allocator, j2);
    }

    public void l(MediaPeriod mediaPeriod) {
        this.f26015l.l(mediaPeriod);
    }
}
