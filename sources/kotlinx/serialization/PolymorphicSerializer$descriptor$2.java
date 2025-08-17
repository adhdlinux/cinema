package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;

final class PolymorphicSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PolymorphicSerializer<T> f40881f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PolymorphicSerializer$descriptor$2(PolymorphicSerializer<T> polymorphicSerializer) {
        super(0);
        this.f40881f = polymorphicSerializer;
    }

    /* renamed from: b */
    public final SerialDescriptor invoke() {
        final PolymorphicSerializer<T> polymorphicSerializer = this.f40881f;
        return ContextAwareKt.c(SerialDescriptorsKt.c("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.f40905a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
                Intrinsics.f(classSerialDescriptorBuilder2, "$this$buildSerialDescriptor");
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, "type", BuiltinSerializersKt.G(StringCompanionObject.f40434a).getDescriptor(), (List) null, false, 12, (Object) null);
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, AppMeasurementSdk.ConditionalUserProperty.VALUE, SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.e().e() + '>', SerialKind.CONTEXTUAL.f40937a, new SerialDescriptor[0], (Function1) null, 8, (Object) null), (List) null, false, 12, (Object) null);
                classSerialDescriptorBuilder2.h(polymorphicSerializer.f40879b);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((ClassSerialDescriptorBuilder) obj);
                return Unit.f40298a;
            }
        }), this.f40881f.e());
    }
}
