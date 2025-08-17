package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final String f41045a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final GeneratedSerializer<?> f41046b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41047c;

    /* renamed from: d  reason: collision with root package name */
    private int f41048d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f41049e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Annotation>[] f41050f;

    /* renamed from: g  reason: collision with root package name */
    private List<Annotation> f41051g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f41052h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Integer> f41053i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f41054j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f41055k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f41056l;

    public PluginGeneratedSerialDescriptor(String str, GeneratedSerializer<?> generatedSerializer, int i2) {
        Intrinsics.f(str, "serialName");
        this.f41045a = str;
        this.f41046b = generatedSerializer;
        this.f41047c = i2;
        this.f41048d = -1;
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = "[UNINITIALIZED]";
        }
        this.f41049e = strArr;
        int i4 = this.f41047c;
        this.f41050f = new List[i4];
        this.f41052h = new boolean[i4];
        this.f41053i = MapsKt__MapsKt.g();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f41054j = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.f41055k = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this.f41056l = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    public static /* synthetic */ void m(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            pluginGeneratedSerialDescriptor.l(str, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final Map<String, Integer> n() {
        HashMap hashMap = new HashMap();
        int length = this.f41049e.length;
        for (int i2 = 0; i2 < length; i2++) {
            hashMap.put(this.f41049e[i2], Integer.valueOf(i2));
        }
        return hashMap;
    }

    private final KSerializer<?>[] o() {
        return (KSerializer[]) this.f41054j.getValue();
    }

    private final int q() {
        return ((Number) this.f41056l.getValue()).intValue();
    }

    public Set<String> a() {
        return this.f41053i.keySet();
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        Integer num = this.f41053i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public SerialKind d() {
        return StructureKind.CLASS.f40939a;
    }

    public final int e() {
        return this.f41047c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.a(i(), serialDescriptor.i()) && Arrays.equals(p(), ((PluginGeneratedSerialDescriptor) obj).p()) && e() == serialDescriptor.e()) {
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
        return this.f41049e[i2];
    }

    public List<Annotation> g(int i2) {
        List<Annotation> list = this.f41050f[i2];
        if (list == null) {
            return CollectionsKt__CollectionsKt.f();
        }
        return list;
    }

    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.f41051g;
        return list == null ? CollectionsKt__CollectionsKt.f() : list;
    }

    public SerialDescriptor h(int i2) {
        return o()[i2].getDescriptor();
    }

    public int hashCode() {
        return q();
    }

    public String i() {
        return this.f41045a;
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public boolean j(int i2) {
        return this.f41052h[i2];
    }

    public final void l(String str, boolean z2) {
        Intrinsics.f(str, "name");
        String[] strArr = this.f41049e;
        int i2 = this.f41048d + 1;
        this.f41048d = i2;
        strArr[i2] = str;
        this.f41052h[i2] = z2;
        this.f41050f[i2] = null;
        if (i2 == this.f41047c - 1) {
            this.f41053i = n();
        }
    }

    public final SerialDescriptor[] p() {
        return (SerialDescriptor[]) this.f41055k.getValue();
    }

    public String toString() {
        IntRange j2 = RangesKt___RangesKt.j(0, this.f41047c);
        return CollectionsKt___CollectionsKt.J(j2, ", ", i() + '(', ")", 0, (CharSequence) null, new PluginGeneratedSerialDescriptor$toString$1(this), 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : generatedSerializer, i2);
    }
}
