package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {

    /* renamed from: l  reason: collision with root package name */
    private static final Void f7183l = null;

    /* renamed from: k  reason: collision with root package name */
    protected final MediaSource f7184k;

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.f7184k = mediaSource;
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId M(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public final MediaSource.MediaPeriodId F(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return M(mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public long O(long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: P */
    public final long G(Void voidR, long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        return O(j2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public int Q(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: R */
    public final int H(Void voidR, int i2) {
        return Q(i2);
    }

    /* access modifiers changed from: protected */
    public void S(Timeline timeline) {
        A(timeline);
    }

    /* access modifiers changed from: protected */
    /* renamed from: T */
    public final void J(Void voidR, MediaSource mediaSource, Timeline timeline) {
        S(timeline);
    }

    /* access modifiers changed from: protected */
    public final void U() {
        K(f7183l, this.f7184k);
    }

    /* access modifiers changed from: protected */
    public void V() {
        U();
    }

    public MediaItem a() {
        return this.f7184k.a();
    }

    public boolean d() {
        return this.f7184k.d();
    }

    public Timeline e() {
        return this.f7184k.e();
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return this.f7184k.i(mediaPeriodId, allocator, j2);
    }

    public void l(MediaPeriod mediaPeriod) {
        this.f7184k.l(mediaPeriod);
    }

    public void o(MediaItem mediaItem) {
        this.f7184k.o(mediaItem);
    }

    /* access modifiers changed from: protected */
    public final void z(TransferListener transferListener) {
        super.z(transferListener);
        V();
    }
}
