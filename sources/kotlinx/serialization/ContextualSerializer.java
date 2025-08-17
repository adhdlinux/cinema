package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.modules.SerializersModule;

public final class ContextualSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f40872a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final KSerializer<T> f40873b;

    /* renamed from: c  reason: collision with root package name */
    private final List<KSerializer<?>> f40874c;

    /* renamed from: d  reason: collision with root package name */
    private final SerialDescriptor f40875d;

    public ContextualSerializer(KClass<T> kClass, KSerializer<T> kSerializer, KSerializer<?>[] kSerializerArr) {
        Intrinsics.f(kClass, "serializableClass");
        Intrinsics.f(kSerializerArr, "typeArgumentsSerializers");
        this.f40872a = kClass;
        this.f40873b = kSerializer;
        this.f40874c = ArraysKt___ArraysJvmKt.d(kSerializerArr);
        this.f40875d = ContextAwareKt.c(SerialDescriptorsKt.c("kotlinx.serialization.ContextualSerializer", SerialKind.CONTEXTUAL.f40937a, new SerialDescriptor[0], new ContextualSerializer$descriptor$1(this)), kClass);
    }

    private final KSerializer<T> b(SerializersModule serializersModule) {
        KSerializer<T> b2 = serializersModule.b(this.f40872a, this.f40874c);
        if (b2 != null || (b2 = this.f40873b) != null) {
            return b2;
        }
        Platform_commonKt.d(this.f40872a);
        throw new KotlinNothingValueException();
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return decoder.G(b(decoder.a()));
    }

    public SerialDescriptor getDescriptor() {
        return this.f40875d;
    }

    public void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        encoder.e(b(encoder.a()), t2);
    }
}
