package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

public final class JsonElementSerializersKt$defer$1 implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f41161a;

    JsonElementSerializersKt$defer$1(Function0<? extends SerialDescriptor> function0) {
        this.f41161a = LazyKt__LazyJVMKt.b(function0);
    }

    private final SerialDescriptor a() {
        return (SerialDescriptor) this.f41161a.getValue();
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.f(str, "name");
        return a().c(str);
    }

    public SerialKind d() {
        return a().d();
    }

    public int e() {
        return a().e();
    }

    public String f(int i2) {
        return a().f(i2);
    }

    public List<Annotation> g(int i2) {
        return a().g(i2);
    }

    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    public SerialDescriptor h(int i2) {
        return a().h(i2);
    }

    public String i() {
        return a().i();
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public boolean j(int i2) {
        return a().j(i2);
    }
}
