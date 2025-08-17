package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class MultimapBuilder<K0, V0> {

    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {

        /* renamed from: b  reason: collision with root package name */
        private final int f30634b;

        ArrayListSupplier(int i2) {
            this.f30634b = CollectPreconditions.b(i2, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public List<V> get() {
            return new ArrayList(this.f30634b);
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        ListMultimapBuilder() {
            super();
        }

        public abstract <K extends K0, V extends V0> ListMultimap<K, V> e();
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> a() {
            return b(2);
        }

        public ListMultimapBuilder<K0, Object> b(final int i2) {
            CollectPreconditions.b(i2, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>() {
                public <K extends K0, V> ListMultimap<K, V> e() {
                    return Multimaps.b(MultimapBuilderWithKeys.this.c(), new ArrayListSupplier(i2));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    public static MultimapBuilderWithKeys<Object> a() {
        return b(8);
    }

    public static MultimapBuilderWithKeys<Object> b(final int i2) {
        CollectPreconditions.b(i2, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() {
            /* access modifiers changed from: package-private */
            public <K, V> Map<K, Collection<V>> c() {
                return Platform.c(i2);
            }
        };
    }

    public static MultimapBuilderWithKeys<Comparable> c() {
        return d(Ordering.d());
    }

    public static <K0> MultimapBuilderWithKeys<K0> d(final Comparator<K0> comparator) {
        Preconditions.l(comparator);
        return new MultimapBuilderWithKeys<K0>() {
            /* access modifiers changed from: package-private */
            public <K extends K0, V> Map<K, Collection<V>> c() {
                return new TreeMap(comparator);
            }
        };
    }

    private MultimapBuilder() {
    }
}
