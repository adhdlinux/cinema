package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

final class JsonTreeListEncoder extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<JsonElement> f41234f = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeListEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(function1, "nodeConsumer");
    }

    /* access modifiers changed from: protected */
    public String e0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return String.valueOf(i2);
    }

    public JsonElement v0() {
        return new JsonArray(this.f41234f);
    }

    public void w0(String str, JsonElement jsonElement) {
        Intrinsics.f(str, "key");
        Intrinsics.f(jsonElement, "element");
        this.f41234f.add(Integer.parseInt(str), jsonElement);
    }
}
