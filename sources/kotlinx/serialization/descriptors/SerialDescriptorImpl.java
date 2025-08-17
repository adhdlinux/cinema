package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;

public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final String f40916a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialKind f40917b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40918c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Annotation> f40919d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f40920e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f40921f;

    /* renamed from: g  reason: collision with root package name */
    private final SerialDescriptor[] f40922g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Annotation>[] f40923h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean[] f40924i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Integer> f40925j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final SerialDescriptor[] f40926k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f40927l;

    public SerialDescriptorImpl(String str, SerialKind serialKind, int i2, List<? extends SerialDescriptor> list, ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(serialKind, "kind");
        Intrinsics.f(list, "typeParameters");
        Intrinsics.f(classSerialDescriptorBuilder, "builder");
        this.f40916a = str;
        this.f40917b = serialKind;
        this.f40918c = i2;
        this.f40919d = classSerialDescriptorBuilder.c();
        this.f40920e = CollectionsKt___CollectionsKt.Y(classSerialDescriptorBuilder.f());
        Object[] array = classSerialDescriptorBuilder.f().toArray(new String[0]);
        Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        this.f40921f = strArr;
        this.f40922g = Platform_commonKt.b(classSerialDescriptorBuilder.e());
        Object[] array2 = classSerialDescriptorBuilder.d().toArray(new List[0]);
        Intrinsics.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f40923h = (List[]) array2;
        this.f40924i = CollectionsKt___CollectionsKt.V(classSerialDescriptorBuilder.g());
        Iterable<IndexedValue> T = ArraysKt___ArraysKt.T(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(T, 10));
        for (IndexedValue indexedValue : T) {
            arrayList.add(TuplesKt.a(indexedValue.b(), Integer.valueOf(indexedValue.a())));
        }
        this.f40925j = MapsKt__MapsKt.s(arrayList);
        this.f40926k = Platform_commonKt.b(list);
        this.f40927l = LazyKt__LazyJVMKt.b(new SerialDescriptorImpl$_hashCode$2(this));
    }

    private final int l() {
        return ((Number) this.f40927l.getValue()).intValue();
    }

    public Set<String> a() {
        return this.f40920e;
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        Integer num = this.f40925j.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public SerialKind d() {
        return this.f40917b;
    }

    public int e() {
        return this.f40918c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.a(i(), serialDescriptor.i()) && Arrays.equals(this.f40926k, ((SerialDescriptorImpl) obj).f40926k) && e() == serialDescriptor.e()) {
                int e2 = e();
                int i2 = 0;
                while (i2 < e2) {
                    if (Intrinsics.a(h(i2).i(), serialDescriptor.h(i2).i()) && Intrinsics.a(h(i2).d(), serialDescriptor.h(i2).d())) {
                        i2++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String f(int i2) {
        return this.f40921f[i2];
    }

    public List<Annotation> g(int i2) {
        return this.f40923h[i2];
    }

    public List<Annotation> getAnnotations() {
        return this.f40919d;
    }

    public SerialDescriptor h(int i2) {
        return this.f40922g[i2];
    }

    public int hashCode() {
        return l();
    }

    public String i() {
        return this.f40916a;
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public boolean j(int i2) {
        return this.f40924i[i2];
    }

    public String toString() {
        IntRange j2 = RangesKt___RangesKt.j(0, e());
        return CollectionsKt___CollectionsKt.J(j2, ", ", i() + '(', ")", 0, (CharSequence) null, new SerialDescriptorImpl$toString$1(this), 24, (Object) null);
    }
}
