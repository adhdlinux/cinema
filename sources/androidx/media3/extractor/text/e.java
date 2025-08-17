package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f8959a;

    public /* synthetic */ e(ImmutableList.Builder builder) {
        this.f8959a = builder;
    }

    public final void accept(Object obj) {
        this.f8959a.d((CuesWithTiming) obj);
    }
}
