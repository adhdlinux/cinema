package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

public abstract class MapLikeDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f41024a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f41025b;

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f41026c;

    /* renamed from: d  reason: collision with root package name */
    private final int f41027d;

    private MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.f41024a = str;
        this.f41025b = serialDescriptor;
        this.f41026c = serialDescriptor2;
        this.f41027d = 2;
    }

    public /* synthetic */ MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serialDescriptor, serialDescriptor2);
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
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    public SerialKind d() {
        return StructureKind.MAP.f40941a;
    }

    public int e() {
        return this.f41027d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        if (Intrinsics.a(i(), mapLikeDescriptor.i()) && Intrinsics.a(this.f41025b, mapLikeDescriptor.f41025b) && Intrinsics.a(this.f41026c, mapLikeDescriptor.f41026c)) {
            return true;
        }
        return false;
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
            int i3 = i2 % 2;
            if (i3 == 0) {
                return this.f41025b;
            }
            if (i3 == 1) {
                return this.f41026c;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i2 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.f41025b.hashCode()) * 31) + this.f41026c.hashCode();
    }

    public String i() {
        return this.f41024a;
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
        return i() + '(' + this.f41025b + ", " + this.f41026c + ')';
    }
}
