package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class ObjectSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f41034a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f41035b = CollectionsKt__CollectionsKt.f();

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f41036c;

    public ObjectSerializer(String str, T t2) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(t2, "objectInstance");
        this.f41034a = t2;
        this.f41036c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new ObjectSerializer$descriptor$2(str, this));
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor);
        int o2 = b2.o(getDescriptor());
        if (o2 == -1) {
            Unit unit = Unit.f40298a;
            b2.c(descriptor);
            return this.f41034a;
        }
        throw new SerializationException("Unexpected index " + o2);
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f41036c.getValue();
    }

    public void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        encoder.b(getDescriptor()).c(getDescriptor());
    }
}
