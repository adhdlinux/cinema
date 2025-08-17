package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

final class JsonPrimitiveEncoder extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    private JsonElement f41222f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(function1, "nodeConsumer");
        c0("primitive");
    }

    public JsonElement v0() {
        JsonElement jsonElement = this.f41222f;
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?".toString());
    }

    public void w0(String str, JsonElement jsonElement) {
        boolean z2;
        Intrinsics.f(str, "key");
        Intrinsics.f(jsonElement, "element");
        boolean z3 = true;
        if (str == "primitive") {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.f41222f != null) {
                z3 = false;
            }
            if (z3) {
                this.f41222f = jsonElement;
                return;
            }
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?".toString());
        }
        throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag".toString());
    }
}
