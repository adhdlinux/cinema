package androidx.media3.exoplayer.source;

import androidx.media3.extractor.SeekMap;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f7313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SeekMap f7314c;

    public /* synthetic */ v(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.f7313b = progressiveMediaPeriod;
        this.f7314c = seekMap;
    }

    public final void run() {
        this.f7313b.U(this.f7314c);
    }
}
