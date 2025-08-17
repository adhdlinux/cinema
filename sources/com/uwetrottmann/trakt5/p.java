package com.uwetrottmann.trakt5;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.threeten.bp.OffsetDateTime;

public final /* synthetic */ class p implements JsonSerializer {
    public final JsonElement a(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, jsonSerializationContext);
    }
}
