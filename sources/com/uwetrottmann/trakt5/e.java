package com.uwetrottmann.trakt5;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.trakt5.enums.ProgressLastActivity;
import java.lang.reflect.Type;

public final /* synthetic */ class e implements JsonDeserializer {
    public final Object a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return ProgressLastActivity.fromValue(jsonElement.e());
    }
}
