package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class LinkedHashMapSerializer<K, V> extends MapLikeSerializer<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f41010c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkedHashMapSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "kSerializer");
        Intrinsics.f(kSerializer2, "vSerializer");
        this.f41010c = new LinkedHashMapClassDesc(kSerializer.getDescriptor(), kSerializer2.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f41010c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LinkedHashMap<K, V> a() {
        return new LinkedHashMap<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(LinkedHashMap<K, V> linkedHashMap) {
        Intrinsics.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(LinkedHashMap<K, V> linkedHashMap, int i2) {
        Intrinsics.f(linkedHashMap, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public Iterator<Map.Entry<K, V>> d(Map<K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        return map.entrySet().iterator();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public int e(Map<K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        return map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public LinkedHashMap<K, V> k(Map<K, ? extends V> map) {
        LinkedHashMap<K, V> linkedHashMap;
        Intrinsics.f(map, "<this>");
        if (map instanceof LinkedHashMap) {
            linkedHashMap = (LinkedHashMap) map;
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return new LinkedHashMap<>(map);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public Map<K, V> l(LinkedHashMap<K, V> linkedHashMap) {
        Intrinsics.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
