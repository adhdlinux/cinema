package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonPrimitive f41221f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveDecoder(Json json, JsonPrimitive jsonPrimitive) {
        super(json, jsonPrimitive, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(jsonPrimitive, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41221f = jsonPrimitive;
        Z("primitive");
    }

    /* access modifiers changed from: protected */
    public JsonElement g0(String str) {
        boolean z2;
        Intrinsics.f(str, "tag");
        if (str == "primitive") {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return v0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    public int o(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return 0;
    }

    /* renamed from: x0 */
    public JsonPrimitive v0() {
        return this.f41221f;
    }
}
