package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class ArrayListSerializer<E> extends CollectionSerializer<E, List<? extends E>, ArrayList<E>> {

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f40943b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayListSerializer(KSerializer<E> kSerializer) {
        super(kSerializer);
        Intrinsics.f(kSerializer, "element");
        this.f40943b = new ArrayListClassDesc(kSerializer.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f40943b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public ArrayList<E> a() {
        return new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(ArrayList<E> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(ArrayList<E> arrayList, int i2) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.ensureCapacity(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(ArrayList<E> arrayList, int i2, E e2) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.add(i2, e2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public ArrayList<E> k(List<? extends E> list) {
        ArrayList<E> arrayList;
        Intrinsics.f(list, "<this>");
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return new ArrayList<>(list);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public List<E> l(ArrayList<E> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return arrayList;
    }
}
