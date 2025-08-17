package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class ClassSerialDescriptorBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final String f40895a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Annotation> f40896b = CollectionsKt__CollectionsKt.f();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f40897c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Set<String> f40898d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private final List<SerialDescriptor> f40899e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<List<Annotation>> f40900f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final List<Boolean> f40901g = new ArrayList();

    public ClassSerialDescriptorBuilder(String str) {
        Intrinsics.f(str, "serialName");
        this.f40895a = str;
    }

    public static /* synthetic */ void b(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.f();
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        classSerialDescriptorBuilder.a(str, serialDescriptor, list, z2);
    }

    public final void a(String str, SerialDescriptor serialDescriptor, List<? extends Annotation> list, boolean z2) {
        Intrinsics.f(str, "elementName");
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(list, "annotations");
        if (this.f40898d.add(str)) {
            this.f40897c.add(str);
            this.f40899e.add(serialDescriptor);
            this.f40900f.add(list);
            this.f40901g.add(Boolean.valueOf(z2));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered").toString());
    }

    public final List<Annotation> c() {
        return this.f40896b;
    }

    public final List<List<Annotation>> d() {
        return this.f40900f;
    }

    public final List<SerialDescriptor> e() {
        return this.f40899e;
    }

    public final List<String> f() {
        return this.f40897c;
    }

    public final List<Boolean> g() {
        return this.f40901g;
    }

    public final void h(List<? extends Annotation> list) {
        Intrinsics.f(list, "<set-?>");
        this.f40896b = list;
    }
}
