package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    public final boolean b(E e2) {
        Intrinsics.f(e2, "element");
        return d(e2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return b((Map.Entry) obj);
    }

    public abstract boolean d(Map.Entry<? extends K, ? extends V> entry);

    public /* bridge */ boolean e(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return e((Map.Entry) obj);
    }
}
