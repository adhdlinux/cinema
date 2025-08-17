package androidx.media3.exoplayer.source;

import com.google.common.collect.ImmutableList;
import java.util.List;

public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    public SequenceableLoader a(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        return new CompositeSequenceableLoader(list, list2);
    }

    public SequenceableLoader empty() {
        return new CompositeSequenceableLoader(ImmutableList.r(), ImmutableList.r());
    }
}
