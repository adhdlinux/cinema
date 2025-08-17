package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

public abstract class ListLikeDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f41012a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41013b;

    private ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.f41012a = serialDescriptor;
        this.f41013b = 1;
    }

    public /* synthetic */ ListLikeDescriptor(SerialDescriptor serialDescriptor, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialDescriptor);
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        Integer k2 = StringsKt__StringNumberConversionsKt.k(str);
        if (k2 != null) {
            return k2.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid list index");
    }

    public SerialKind d() {
        return StructureKind.LIST.f40940a;
    }

    public int e() {
        return this.f41013b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        if (!Intrinsics.a(this.f41012a, listLikeDescriptor.f41012a) || !Intrinsics.a(i(), listLikeDescriptor.i())) {
            return false;
        }
        return true;
    }

    public String f(int i2) {
        return String.valueOf(i2);
    }

    public List<Annotation> g(int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return CollectionsKt__CollectionsKt.f();
        }
        throw new IllegalArgumentException(("Illegal index " + i2 + ", " + i() + " expects only non-negative indices").toString());
    }

    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    public SerialDescriptor h(int i2) {
        boolean z2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return this.f41012a;
        }
        throw new IllegalArgumentException(("Illegal index " + i2 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f41012a.hashCode() * 31) + i().hashCode();
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public boolean j(int i2) {
        if (i2 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i2 + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.f41012a + ')';
    }
}
