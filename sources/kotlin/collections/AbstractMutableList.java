package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.jvm.internal.markers.KMutableList;

public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMutableList {
    protected AbstractMutableList() {
    }

    public abstract int a();

    public abstract E b(int i2);

    public final /* bridge */ E remove(int i2) {
        return b(i2);
    }

    public final /* bridge */ int size() {
        return a();
    }
}
