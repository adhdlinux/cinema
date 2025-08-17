package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPeriodQueue f6623b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f6624c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f6625d;

    public /* synthetic */ j0(MediaPeriodQueue mediaPeriodQueue, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f6623b = mediaPeriodQueue;
        this.f6624c = builder;
        this.f6625d = mediaPeriodId;
    }

    public final void run() {
        this.f6623b.D(this.f6624c, this.f6625d);
    }
}
