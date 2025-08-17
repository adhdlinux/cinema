package com.vungle.ads.internal.util;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();

    private JsonUtil() {
    }

    public final String getContentStringValue(JsonObject jsonObject, String str) {
        Intrinsics.f(jsonObject, "json");
        Intrinsics.f(str, "key");
        try {
            return JsonElementKt.l((JsonElement) MapsKt__MapsKt.h(jsonObject, str)).a();
        } catch (Exception unused) {
            return null;
        }
    }
}
