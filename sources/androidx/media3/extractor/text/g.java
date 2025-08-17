package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleTranscodingTrackOutput f8960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f8961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f8962c;

    public /* synthetic */ g(SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput, long j2, int i2) {
        this.f8960a = subtitleTranscodingTrackOutput;
        this.f8961b = j2;
        this.f8962c = i2;
    }

    public final void accept(Object obj) {
        this.f8960a.i(this.f8961b, this.f8962c, (CuesWithTiming) obj);
    }
}
