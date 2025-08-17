package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;

public final class JsonElementBuildersKt {
    public static final JsonElement a(JsonObjectBuilder jsonObjectBuilder, String str, Boolean bool) {
        Intrinsics.f(jsonObjectBuilder, "<this>");
        Intrinsics.f(str, "key");
        return jsonObjectBuilder.b(str, JsonElementKt.a(bool));
    }

    public static final JsonElement b(JsonObjectBuilder jsonObjectBuilder, String str, Number number) {
        Intrinsics.f(jsonObjectBuilder, "<this>");
        Intrinsics.f(str, "key");
        return jsonObjectBuilder.b(str, JsonElementKt.b(number));
    }

    public static final JsonElement c(JsonObjectBuilder jsonObjectBuilder, String str, String str2) {
        Intrinsics.f(jsonObjectBuilder, "<this>");
        Intrinsics.f(str, "key");
        return jsonObjectBuilder.b(str, JsonElementKt.c(str2));
    }
}
