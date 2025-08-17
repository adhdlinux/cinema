package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;

public abstract class JsonTransformingSerializer<T> implements KSerializer<T> {
    private final KSerializer<T> tSerializer;

    public JsonTransformingSerializer(KSerializer<T> kSerializer) {
        Intrinsics.f(kSerializer, "tSerializer");
        this.tSerializer = kSerializer;
    }

    public final T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonDecoder d2 = JsonElementSerializersKt.d(decoder);
        return d2.d().d(this.tSerializer, transformDeserialize(d2.g()));
    }

    public SerialDescriptor getDescriptor() {
        return this.tSerializer.getDescriptor();
    }

    public final void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonEncoder e2 = JsonElementSerializersKt.e(encoder);
        e2.A(transformSerialize(TreeJsonEncoderKt.c(e2.d(), t2, this.tSerializer)));
    }

    /* access modifiers changed from: protected */
    public JsonElement transformDeserialize(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        return jsonElement;
    }

    /* access modifiers changed from: protected */
    public JsonElement transformSerialize(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        return jsonElement;
    }
}
