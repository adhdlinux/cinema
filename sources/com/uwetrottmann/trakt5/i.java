package com.uwetrottmann.trakt5;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.trakt5.enums.Resolution;
import java.lang.reflect.Type;

public final /* synthetic */ class i implements JsonDeserializer {
    public final Object a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Resolution.fromValue(jsonElement.e());
    }
}
