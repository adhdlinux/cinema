package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class LinkedHashSetSerializer<E> extends CollectionSerializer<E, Set<? extends E>, LinkedHashSet<E>> {

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f41011b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkedHashSetSerializer(KSerializer<E> kSerializer) {
        super(kSerializer);
        Intrinsics.f(kSerializer, "eSerializer");
        this.f41011b = new LinkedHashSetClassDesc(kSerializer.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f41011b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LinkedHashSet<E> a() {
        return new LinkedHashSet<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(LinkedHashSet<E> linkedHashSet) {
        Intrinsics.f(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(LinkedHashSet<E> linkedHashSet, int i2) {
        Intrinsics.f(linkedHashSet, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(LinkedHashSet<E> linkedHashSet, int i2, E e2) {
        Intrinsics.f(linkedHashSet, "<this>");
        linkedHashSet.add(e2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public LinkedHashSet<E> k(Set<? extends E> set) {
        LinkedHashSet<E> linkedHashSet;
        Intrinsics.f(set, "<this>");
        if (set instanceof LinkedHashSet) {
            linkedHashSet = (LinkedHashSet) set;
        } else {
            linkedHashSet = null;
        }
        if (linkedHashSet == null) {
            return new LinkedHashSet<>(set);
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Set<E> l(LinkedHashSet<E> linkedHashSet) {
        Intrinsics.f(linkedHashSet, "<this>");
        return linkedHashSet;
    }
}
