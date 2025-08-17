package com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializer<T> {
    T a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
