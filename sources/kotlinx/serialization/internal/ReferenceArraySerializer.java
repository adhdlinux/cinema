package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {

    /* renamed from: b  reason: collision with root package name */
    private final KClass<ElementKlass> f41067b;

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f41068c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferenceArraySerializer(KClass<ElementKlass> kClass, KSerializer<Element> kSerializer) {
        super(kSerializer, (DefaultConstructorMarker) null);
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(kSerializer, "eSerializer");
        this.f41067b = kClass;
        this.f41068c = new ArrayClassDesc(kSerializer.getDescriptor());
    }

    public SerialDescriptor getDescriptor() {
        return this.f41068c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public ArrayList<Element> a() {
        return new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public int b(ArrayList<Element> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void c(ArrayList<Element> arrayList, int i2) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.ensureCapacity(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public Iterator<Element> d(Element[] elementArr) {
        Intrinsics.f(elementArr, "<this>");
        return ArrayIteratorKt.a(elementArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public int e(Element[] elementArr) {
        Intrinsics.f(elementArr, "<this>");
        return elementArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(ArrayList<Element> arrayList, int i2, Element element) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.add(i2, element);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public ArrayList<Element> k(Element[] elementArr) {
        Intrinsics.f(elementArr, "<this>");
        return new ArrayList<>(ArraysKt___ArraysJvmKt.d(elementArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Element[] l(ArrayList<Element> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return PlatformKt.n(arrayList, this.f41067b);
    }
}
