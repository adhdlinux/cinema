package androidx.media3.exoplayer.source;

import java.util.List;

public interface CompositeSequenceableLoaderFactory {
    SequenceableLoader a(List<? extends SequenceableLoader> list, List<List<Integer>> list2);

    SequenceableLoader empty();
}
