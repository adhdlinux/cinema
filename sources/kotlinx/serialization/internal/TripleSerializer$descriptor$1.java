package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

final class TripleSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ TripleSerializer<A, B, C> f41092f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TripleSerializer$descriptor$1(TripleSerializer<A, B, C> tripleSerializer) {
        super(1);
        this.f41092f = tripleSerializer;
    }

    public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.f(classSerialDescriptorBuilder, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "first", this.f41092f.f41088a.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "second", this.f41092f.f41089b.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "third", this.f41092f.f41090c.getDescriptor(), (List) null, false, 12, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ClassSerialDescriptorBuilder) obj);
        return Unit.f40298a;
    }
}
