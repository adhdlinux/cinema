package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;

public final class MapBuilderValues<V> extends AbstractMutableCollection<V> {

    /* renamed from: b  reason: collision with root package name */
    private final MapBuilder<?, V> f40348b;

    public MapBuilderValues(MapBuilder<?, V> mapBuilder) {
        Intrinsics.f(mapBuilder, "backing");
        this.f40348b = mapBuilder;
    }

    public int a() {
        return this.f40348b.size();
    }

    public boolean add(V v2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        Intrinsics.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f40348b.clear();
    }

    public boolean contains(Object obj) {
        return this.f40348b.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f40348b.isEmpty();
    }

    public Iterator<V> iterator() {
        return this.f40348b.M();
    }

    public boolean remove(Object obj) {
        return this.f40348b.K(obj);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40348b.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40348b.k();
        return super.retainAll(collection);
    }
}
