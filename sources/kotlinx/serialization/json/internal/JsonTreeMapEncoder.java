package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;

final class JsonTreeMapEncoder extends JsonTreeEncoder {

    /* renamed from: g  reason: collision with root package name */
    private String f41239g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f41240h = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeMapEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1);
        Intrinsics.f(json, "json");
        Intrinsics.f(function1, "nodeConsumer");
    }

    public JsonElement v0() {
        return new JsonObject(x0());
    }

    public void w0(String str, JsonElement jsonElement) {
        Intrinsics.f(str, "key");
        Intrinsics.f(jsonElement, "element");
        if (!this.f41240h) {
            Map<String, JsonElement> x02 = x0();
            String str2 = this.f41239g;
            if (str2 == null) {
                Intrinsics.x("tag");
                str2 = null;
            }
            x02.put(str2, jsonElement);
            this.f41240h = true;
        } else if (jsonElement instanceof JsonPrimitive) {
            this.f41239g = ((JsonPrimitive) jsonElement).a();
            this.f41240h = false;
        } else if (jsonElement instanceof JsonObject) {
            throw JsonExceptionsKt.d(JsonObjectSerializer.f41176a.getDescriptor());
        } else if (jsonElement instanceof JsonArray) {
            throw JsonExceptionsKt.d(JsonArraySerializer.f41122a.getDescriptor());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
