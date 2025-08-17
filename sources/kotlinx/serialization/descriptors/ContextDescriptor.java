package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

final class ContextDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f40902a;

    /* renamed from: b  reason: collision with root package name */
    public final KClass<?> f40903b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40904c;

    public ContextDescriptor(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        Intrinsics.f(serialDescriptor, "original");
        Intrinsics.f(kClass, "kClass");
        this.f40902a = serialDescriptor;
        this.f40903b = kClass;
        this.f40904c = serialDescriptor.i() + '<' + kClass.e() + '>';
    }

    public boolean b() {
        return this.f40902a.b();
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        return this.f40902a.c(str);
    }

    public SerialKind d() {
        return this.f40902a.d();
    }

    public int e() {
        return this.f40902a.e();
    }

    public boolean equals(Object obj) {
        ContextDescriptor contextDescriptor;
        if (obj instanceof ContextDescriptor) {
            contextDescriptor = (ContextDescriptor) obj;
        } else {
            contextDescriptor = null;
        }
        if (contextDescriptor != null && Intrinsics.a(this.f40902a, contextDescriptor.f40902a) && Intrinsics.a(contextDescriptor.f40903b, this.f40903b)) {
            return true;
        }
        return false;
    }

    public String f(int i2) {
        return this.f40902a.f(i2);
    }

    public List<Annotation> g(int i2) {
        return this.f40902a.g(i2);
    }

    public List<Annotation> getAnnotations() {
        return this.f40902a.getAnnotations();
    }

    public SerialDescriptor h(int i2) {
        return this.f40902a.h(i2);
    }

    public int hashCode() {
        return (this.f40903b.hashCode() * 31) + i().hashCode();
    }

    public String i() {
        return this.f40904c;
    }

    public boolean isInline() {
        return this.f40902a.isInline();
    }

    public boolean j(int i2) {
        return this.f40902a.j(i2);
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f40903b + ", original: " + this.f40902a + ')';
    }
}
