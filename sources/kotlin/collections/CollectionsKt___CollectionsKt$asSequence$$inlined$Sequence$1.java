package kotlin.collections;

import java.util.Iterator;
import kotlin.sequences.Sequence;

public final class CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterable f40317a;

    public CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(Iterable iterable) {
        this.f40317a = iterable;
    }

    public Iterator<T> iterator() {
        return this.f40317a.iterator();
    }
}
