package com.uwetrottmann.trakt5;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.trakt5.enums.Rating;
import java.lang.reflect.Type;

public final /* synthetic */ class b implements JsonDeserializer {
    public final Object a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Rating.fromValue(jsonElement.a());
    }
}
