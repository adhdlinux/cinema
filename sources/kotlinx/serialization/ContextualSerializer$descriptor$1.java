package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;

final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ContextualSerializer<T> f40876f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextualSerializer$descriptor$1(ContextualSerializer<T> contextualSerializer) {
        super(1);
        this.f40876f = contextualSerializer;
    }

    public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        List<Annotation> list;
        SerialDescriptor descriptor;
        Intrinsics.f(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        KSerializer a2 = this.f40876f.f40873b;
        if (a2 == null || (descriptor = a2.getDescriptor()) == null) {
            list = null;
        } else {
            list = descriptor.getAnnotations();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.f();
        }
        classSerialDescriptorBuilder.h(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ClassSerialDescriptorBuilder) obj);
        return Unit.f40298a;
    }
}
