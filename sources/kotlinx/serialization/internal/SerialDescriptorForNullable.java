package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f41069a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41070b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f41071c;

    public SerialDescriptorForNullable(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "original");
        this.f41069a = serialDescriptor;
        this.f41070b = serialDescriptor.i() + '?';
        this.f41071c = Platform_commonKt.a(serialDescriptor);
    }

    public Set<String> a() {
        return this.f41071c;
    }

    public boolean b() {
        return true;
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        return this.f41069a.c(str);
    }

    public SerialKind d() {
        return this.f41069a.d();
    }

    public int e() {
        return this.f41069a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SerialDescriptorForNullable) && Intrinsics.a(this.f41069a, ((SerialDescriptorForNullable) obj).f41069a)) {
            return true;
        }
        return false;
    }

    public String f(int i2) {
        return this.f41069a.f(i2);
    }

    public List<Annotation> g(int i2) {
        return this.f41069a.g(i2);
    }

    public List<Annotation> getAnnotations() {
        return this.f41069a.getAnnotations();
    }

    public SerialDescriptor h(int i2) {
        return this.f41069a.h(i2);
    }

    public int hashCode() {
        return this.f41069a.hashCode() * 31;
    }

    public String i() {
        return this.f41070b;
    }

    public boolean isInline() {
        return this.f41069a.isInline();
    }

    public boolean j(int i2) {
        return this.f41069a.j(i2);
    }

    public final SerialDescriptor k() {
        return this.f41069a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f41069a);
        sb.append('?');
        return sb.toString();
    }
}
