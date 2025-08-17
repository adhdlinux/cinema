package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {

    /* renamed from: b  reason: collision with root package name */
    private final MapBuilder<K, V> f40346b;

    public MapBuilderEntries(MapBuilder<K, V> mapBuilder) {
        Intrinsics.f(mapBuilder, "backing");
        this.f40346b = mapBuilder;
    }

    public int a() {
        return this.f40346b.size();
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f40346b.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return this.f40346b.m(collection);
    }

    public boolean d(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "element");
        return this.f40346b.n(entry);
    }

    public boolean e(Map.Entry entry) {
        Intrinsics.f(entry, "element");
        return this.f40346b.G(entry);
    }

    /* renamed from: g */
    public boolean add(Map.Entry<K, V> entry) {
        Intrinsics.f(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.f40346b.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f40346b.r();
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40346b.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        this.f40346b.k();
        return super.retainAll(collection);
    }
}
