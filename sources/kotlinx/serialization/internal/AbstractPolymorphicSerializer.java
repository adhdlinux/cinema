package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    /* access modifiers changed from: private */
    public final T b(CompositeDecoder compositeDecoder) {
        return CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.a(this, compositeDecoder, compositeDecoder.m(getDescriptor(), 0)), (Object) null, 8, (Object) null);
    }

    public DeserializationStrategy<? extends T> c(CompositeDecoder compositeDecoder, String str) {
        Intrinsics.f(compositeDecoder, "decoder");
        return compositeDecoder.a().d(e(), str);
    }

    public SerializationStrategy<T> d(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return encoder.a().e(e(), t2);
    }

    public final T deserialize(Decoder decoder) {
        T t2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (b2.p()) {
            t2 = b(b2);
        } else {
            t2 = null;
            while (true) {
                int o2 = b2.o(getDescriptor());
                if (o2 != -1) {
                    if (o2 == 0) {
                        ref$ObjectRef.f40429b = b2.m(getDescriptor(), o2);
                    } else if (o2 != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid index in polymorphic deserialization of ");
                        String str = (String) ref$ObjectRef.f40429b;
                        if (str == null) {
                            str = "unknown class";
                        }
                        sb.append(str);
                        sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb.append(o2);
                        throw new SerializationException(sb.toString());
                    } else {
                        T t3 = ref$ObjectRef.f40429b;
                        if (t3 != null) {
                            ref$ObjectRef.f40429b = t3;
                            DeserializationStrategy a2 = PolymorphicSerializerKt.a(this, b2, (String) t3);
                            t2 = CompositeDecoder.DefaultImpls.c(b2, getDescriptor(), o2, a2, (Object) null, 8, (Object) null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                    }
                } else if (t2 != null) {
                    Intrinsics.d(t2, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                } else {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.f40429b)).toString());
                }
            }
        }
        b2.c(descriptor);
        return t2;
    }

    public abstract KClass<T> e();

    public final void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerializationStrategy b2 = PolymorphicSerializerKt.b(this, encoder, t2);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder b3 = encoder.b(descriptor);
        b3.y(getDescriptor(), 0, b2.getDescriptor().i());
        SerialDescriptor descriptor2 = getDescriptor();
        Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        b3.C(descriptor2, 1, b2, t2);
        b3.c(descriptor);
    }
}
