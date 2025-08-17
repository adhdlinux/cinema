package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class HashSetSerializer<E> extends CollectionSerializer<E, Set<? extends E>, HashSet<E>> {

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f41000b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashSetSerializer(KSerializer<E> kSerializer) {
        super(kSerializer);
        Intrinsics.f(kSerializer, "eSerializer");
        this.f41000b = new HashSetClassDesc(kSerializer.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f41000b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public HashSet<E> a() {
        return new HashSet<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(HashSet<E> hashSet) {
        Intrinsics.f(hashSet, "<this>");
        return hashSet.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(HashSet<E> hashSet, int i2) {
        Intrinsics.f(hashSet, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(HashSet<E> hashSet, int i2, E e2) {
        Intrinsics.f(hashSet, "<this>");
        hashSet.add(e2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public HashSet<E> k(Set<? extends E> set) {
        HashSet<E> hashSet;
        Intrinsics.f(set, "<this>");
        if (set instanceof HashSet) {
            hashSet = (HashSet) set;
        } else {
            hashSet = null;
        }
        if (hashSet == null) {
            return new HashSet<>(set);
        }
        return hashSet;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Set<E> l(HashSet<E> hashSet) {
        Intrinsics.f(hashSet, "<this>");
        return hashSet;
    }
}
