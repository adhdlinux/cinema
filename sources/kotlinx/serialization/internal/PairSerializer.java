package kotlinx.serialization.internal;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f41040c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "keySerializer");
        Intrinsics.f(kSerializer2, "valueSerializer");
        this.f41040c = SerialDescriptorsKt.b("kotlin.Pair", new SerialDescriptor[0], new PairSerializer$descriptor$1(kSerializer, kSerializer2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public K a(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "<this>");
        return pair.c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public V b(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "<this>");
        return pair.d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Pair<K, V> c(K k2, V v2) {
        return TuplesKt.a(k2, v2);
    }

    public SerialDescriptor getDescriptor() {
        return this.f41040c;
    }
}
