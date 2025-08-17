package androidx.media3.exoplayer.source;

import androidx.media3.extractor.Extractor;
import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return ((Extractor) obj).c().getClass().getSimpleName();
    }
}
