package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f40878a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f40879b = CollectionsKt__CollectionsKt.f();

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f40880c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new PolymorphicSerializer$descriptor$2(this));

    public PolymorphicSerializer(KClass<T> kClass) {
        Intrinsics.f(kClass, "baseClass");
        this.f40878a = kClass;
    }

    public KClass<T> e() {
        return this.f40878a;
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f40880c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }
}
