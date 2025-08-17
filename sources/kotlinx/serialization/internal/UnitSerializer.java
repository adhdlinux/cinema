package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class UnitSerializer implements KSerializer<Unit> {

    /* renamed from: b  reason: collision with root package name */
    public static final UnitSerializer f41114b = new UnitSerializer();

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ObjectSerializer<Unit> f41115a = new ObjectSerializer<>("kotlin.Unit", Unit.f40298a);

    private UnitSerializer() {
    }

    public void a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        this.f41115a.deserialize(decoder);
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, Unit unit) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(unit, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41115a.serialize(encoder, unit);
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        a(decoder);
        return Unit.f40298a;
    }

    public SerialDescriptor getDescriptor() {
        return this.f41115a.getDescriptor();
    }
}
