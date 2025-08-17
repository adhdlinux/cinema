package kotlin.reflect;

import kotlin.jvm.functions.Function0;

public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    public interface Getter<V> extends KFunction, Function0<V> {
    }

    Getter<V> c();

    V get();
}
