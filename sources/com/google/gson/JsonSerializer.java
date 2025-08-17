package com.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializer<T> {
    JsonElement a(T t2, Type type, JsonSerializationContext jsonSerializationContext);
}
