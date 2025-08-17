package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

final class JsonTreeMapDecoder extends JsonTreeDecoder {

    /* renamed from: k  reason: collision with root package name */
    private final JsonObject f41235k;

    /* renamed from: l  reason: collision with root package name */
    private final List<String> f41236l;

    /* renamed from: m  reason: collision with root package name */
    private final int f41237m;

    /* renamed from: n  reason: collision with root package name */
    private int f41238n = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeMapDecoder(Json json, JsonObject jsonObject) {
        super(json, jsonObject, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(jsonObject, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41235k = jsonObject;
        List<String> a02 = CollectionsKt___CollectionsKt.a0(v0().keySet());
        this.f41236l = a02;
        this.f41237m = a02.size() * 2;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    /* access modifiers changed from: protected */
    public String c0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "desc");
        return this.f41236l.get(i2 / 2);
    }

    /* access modifiers changed from: protected */
    public JsonElement g0(String str) {
        Intrinsics.f(str, "tag");
        if (this.f41238n % 2 == 0) {
            return JsonElementKt.c(str);
        }
        return (JsonElement) MapsKt__MapsKt.h(v0(), str);
    }

    public int o(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        int i2 = this.f41238n;
        if (i2 >= this.f41237m - 1) {
            return -1;
        }
        int i3 = i2 + 1;
        this.f41238n = i3;
        return i3;
    }

    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f41235k;
    }
}
