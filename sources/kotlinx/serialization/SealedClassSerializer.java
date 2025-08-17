package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f40883a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f40884b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<KClass<? extends T>, KSerializer<? extends T>> f40885c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, KSerializer<? extends T>> f40886d;

    public DeserializationStrategy<? extends T> c(CompositeDecoder compositeDecoder, String str) {
        Intrinsics.f(compositeDecoder, "decoder");
        KSerializer kSerializer = this.f40886d.get(str);
        if (kSerializer != null) {
            return kSerializer;
        }
        return super.c(compositeDecoder, str);
    }

    public SerializationStrategy<T> d(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerializationStrategy<T> serializationStrategy = this.f40885c.get(Reflection.b(t2.getClass()));
        if (serializationStrategy == null) {
            serializationStrategy = super.d(encoder, t2);
        }
        if (serializationStrategy != null) {
            return serializationStrategy;
        }
        return null;
    }

    public KClass<T> e() {
        return this.f40883a;
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f40884b.getValue();
    }
}
