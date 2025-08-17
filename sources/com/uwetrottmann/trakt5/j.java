package com.uwetrottmann.trakt5;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.uwetrottmann.trakt5.enums.Hdr;
import java.lang.reflect.Type;

public final /* synthetic */ class j implements JsonSerializer {
    public final JsonElement a(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, jsonSerializationContext);
    }
}
