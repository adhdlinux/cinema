package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;

public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f41019c;

    private static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private final K f41020b;

        /* renamed from: c  reason: collision with root package name */
        private final V f41021c;

        public MapEntry(K k2, V v2) {
            this.f41020b = k2;
            this.f41021c = v2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) obj;
            return Intrinsics.a(getKey(), mapEntry.getKey()) && Intrinsics.a(getValue(), mapEntry.getValue());
        }

        public K getKey() {
            return this.f41020b;
        }

        public V getValue() {
            return this.f41021c;
        }

        public int hashCode() {
            int i2 = 0;
            int hashCode = (getKey() == null ? 0 : getKey().hashCode()) * 31;
            if (getValue() != null) {
                i2 = getValue().hashCode();
            }
            return hashCode + i2;
        }

        public V setValue(V v2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "keySerializer");
        Intrinsics.f(kSerializer2, "valueSerializer");
        this.f41019c = SerialDescriptorsKt.c("kotlin.collections.Map.Entry", StructureKind.MAP.f40941a, new SerialDescriptor[0], new MapEntrySerializer$descriptor$1(kSerializer, kSerializer2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public K a(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "<this>");
        return entry.getKey();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public V b(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "<this>");
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Map.Entry<K, V> c(K k2, V v2) {
        return new MapEntry(k2, v2);
    }

    public SerialDescriptor getDescriptor() {
        return this.f41019c;
    }
}
