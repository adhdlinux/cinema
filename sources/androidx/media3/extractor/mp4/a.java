package androidx.media3.extractor.mp4;

import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentedMp4Extractor f8704b;

    public /* synthetic */ a(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.f8704b = fragmentedMp4Extractor;
    }

    public final Object apply(Object obj) {
        return this.f8704b.q((Track) obj);
    }
}
