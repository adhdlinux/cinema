package kotlinx.serialization.json;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

final class JsonElementSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: f  reason: collision with root package name */
    public static final JsonElementSerializer$descriptor$1 f41155f = new JsonElementSerializer$descriptor$1();

    JsonElementSerializer$descriptor$1() {
        super(1);
    }

    public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.f(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "JsonPrimitive", JsonElementSerializersKt.f(AnonymousClass1.f41156f), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "JsonNull", JsonElementSerializersKt.f(AnonymousClass2.f41157f), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "JsonLiteral", JsonElementSerializersKt.f(AnonymousClass3.f41158f), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "JsonObject", JsonElementSerializersKt.f(AnonymousClass4.f41159f), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "JsonArray", JsonElementSerializersKt.f(AnonymousClass5.f41160f), (List) null, false, 12, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ClassSerialDescriptorBuilder) obj);
        return Unit.f40298a;
    }
}
