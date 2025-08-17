package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleExtractor f8902a;

    public /* synthetic */ d(SubtitleExtractor subtitleExtractor) {
        this.f8902a = subtitleExtractor;
    }

    public final void accept(Object obj) {
        this.f8902a.d((CuesWithTiming) obj);
    }
}
