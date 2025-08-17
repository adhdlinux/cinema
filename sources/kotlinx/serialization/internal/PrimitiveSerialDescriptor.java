package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class PrimitiveSerialDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f41064a;

    /* renamed from: b  reason: collision with root package name */
    private final PrimitiveKind f41065b;

    public PrimitiveSerialDescriptor(String str, PrimitiveKind primitiveKind) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(primitiveKind, "kind");
        this.f41064a = str;
        this.f41065b = primitiveKind;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        a();
        throw new KotlinNothingValueException();
    }

    public int e() {
        return 0;
    }

    public String f(int i2) {
        a();
        throw new KotlinNothingValueException();
    }

    public List<Annotation> g(int i2) {
        a();
        throw new KotlinNothingValueException();
    }

    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    public SerialDescriptor h(int i2) {
        a();
        throw new KotlinNothingValueException();
    }

    public String i() {
        return this.f41064a;
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public boolean j(int i2) {
        a();
        throw new KotlinNothingValueException();
    }

    /* renamed from: k */
    public PrimitiveKind d() {
        return this.f41065b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + i() + ')';
    }
}
