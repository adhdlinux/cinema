package kotlinx.serialization.descriptors;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class SerialDescriptorsKt$buildSerialDescriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: f  reason: collision with root package name */
    public static final SerialDescriptorsKt$buildSerialDescriptor$1 f40936f = new SerialDescriptorsKt$buildSerialDescriptor$1();

    SerialDescriptorsKt$buildSerialDescriptor$1() {
        super(1);
    }

    public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.f(classSerialDescriptorBuilder, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ClassSerialDescriptorBuilder) obj);
        return Unit.f40298a;
    }
}
