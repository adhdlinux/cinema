package com.uwetrottmann.trakt5;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.trakt5.enums.Status;
import java.lang.reflect.Type;

public final /* synthetic */ class d implements JsonDeserializer {
    public final Object a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Status.fromValue(jsonElement.e());
    }
}
