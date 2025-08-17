package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class HashMapSerializer<K, V> extends MapLikeSerializer<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f40999c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashMapSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "kSerializer");
        Intrinsics.f(kSerializer2, "vSerializer");
        this.f40999c = new HashMapClassDesc(kSerializer.getDescriptor(), kSerializer2.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f40999c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public HashMap<K, V> a() {
        return new HashMap<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(HashMap<K, V> hashMap) {
        Intrinsics.f(hashMap, "<this>");
        return hashMap.size() * 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(HashMap<K, V> hashMap, int i2) {
        Intrinsics.f(hashMap, "<this>");
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
    public HashMap<K, V> k(Map<K, ? extends V> map) {
        HashMap<K, V> hashMap;
        Intrinsics.f(map, "<this>");
        if (map instanceof HashMap) {
            hashMap = (HashMap) map;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return new HashMap<>(map);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public Map<K, V> l(HashMap<K, V> hashMap) {
        Intrinsics.f(hashMap, "<this>");
        return hashMap;
    }
}
