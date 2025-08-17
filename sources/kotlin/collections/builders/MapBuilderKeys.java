package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

public final class MapBuilderKeys<E> extends AbstractMutableSet<E> {

    /* renamed from: b  reason: collision with root package name */
    private final MapBuilder<E, ?> f40347b;

    public MapBuilderKeys(MapBuilder<E, ?> mapBuilder) {
        Intrinsics.f(mapBuilder, "backing");
        this.f40347b = mapBuilder;
    }

    public int a() {
        return this.f40347b.size();
    }

    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f40347b.clear();
    }

    public boolean contains(Object obj) {
        return this.f40347b.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f40347b.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f40347b.B();
    }

    public boolean remove(Object obj) {
        return this.f40347b.I(obj) >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40347b.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40347b.k();
        return super.retainAll(collection);
    }
}
