package com.uwetrottmann.trakt5;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import java.lang.reflect.Type;

public final /* synthetic */ class o implements JsonDeserializer {
    public final Object a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return AudioChannels.fromValue(jsonElement.e());
    }
}
