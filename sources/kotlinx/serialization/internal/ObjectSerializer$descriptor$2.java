package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;

final class ObjectSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f41037f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ObjectSerializer<T> f41038g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ObjectSerializer$descriptor$2(String str, ObjectSerializer<T> objectSerializer) {
        super(0);
        this.f41037f = str;
        this.f41038g = objectSerializer;
    }

    /* renamed from: b */
    public final SerialDescriptor invoke() {
        final ObjectSerializer<T> objectSerializer = this.f41038g;
        return SerialDescriptorsKt.c(this.f41037f, StructureKind.OBJECT.f40942a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                Intrinsics.f(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                classSerialDescriptorBuilder.h(objectSerializer.f41035b);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((ClassSerialDescriptorBuilder) obj);
                return Unit.f40298a;
            }
        });
    }
}
