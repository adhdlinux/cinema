package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.StringOpsKt;

public final class JsonElementKt {
    public static final JsonPrimitive a(Boolean bool) {
        if (bool == null) {
            return JsonNull.f41166d;
        }
        return new JsonLiteral(bool, false);
    }

    public static final JsonPrimitive b(Number number) {
        if (number == null) {
            return JsonNull.f41166d;
        }
        return new JsonLiteral(number, false);
    }

    public static final JsonPrimitive c(String str) {
        if (str == null) {
            return JsonNull.f41166d;
        }
        return new JsonLiteral(str, true);
    }

    private static final Void d(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + Reflection.b(jsonElement.getClass()) + " is not a " + str);
    }

    public static final Boolean e(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return StringOpsKt.d(jsonPrimitive.a());
    }

    public static final String f(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.a();
    }

    public static final double g(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.a());
    }

    public static final Double h(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return StringsKt__StringNumberConversionsJVMKt.i(jsonPrimitive.a());
    }

    public static final float i(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.a());
    }

    public static final int j(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Integer.parseInt(jsonPrimitive.a());
    }

    public static final JsonObject k(JsonElement jsonElement) {
        JsonObject jsonObject;
        Intrinsics.f(jsonElement, "<this>");
        if (jsonElement instanceof JsonObject) {
            jsonObject = (JsonObject) jsonElement;
        } else {
            jsonObject = null;
        }
        if (jsonObject != null) {
            return jsonObject;
        }
        d(jsonElement, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonPrimitive l(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.f(jsonElement, "<this>");
        if (jsonElement instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) jsonElement;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        d(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final long m(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return Long.parseLong(jsonPrimitive.a());
    }

    public static final Long n(JsonPrimitive jsonPrimitive) {
        Intrinsics.f(jsonPrimitive, "<this>");
        return StringsKt__StringNumberConversionsKt.m(jsonPrimitive.a());
    }
}
