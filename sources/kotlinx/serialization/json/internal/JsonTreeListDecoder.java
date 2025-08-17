package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonArray f41231f;

    /* renamed from: g  reason: collision with root package name */
    private final int f41232g = v0().size();

    /* renamed from: h  reason: collision with root package name */
    private int f41233h = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(Json json, JsonArray jsonArray) {
        super(json, jsonArray, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(jsonArray, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41231f = jsonArray;
    }

    /* access modifiers changed from: protected */
    public String c0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "desc");
        return String.valueOf(i2);
    }

    /* access modifiers changed from: protected */
    public JsonElement g0(String str) {
        Intrinsics.f(str, "tag");
        return v0().get(Integer.parseInt(str));
    }

    public int o(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        int i2 = this.f41233h;
        if (i2 >= this.f41232g - 1) {
            return -1;
        }
        int i3 = i2 + 1;
        this.f41233h = i3;
        return i3;
    }

    /* renamed from: x0 */
    public JsonArray v0() {
        return this.f41231f;
    }
}
