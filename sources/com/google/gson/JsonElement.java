package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

public abstract class JsonElement {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public JsonArray b() {
        if (g()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public JsonObject c() {
        if (i()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public JsonPrimitive d() {
        if (j()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean g() {
        return this instanceof JsonArray;
    }

    public boolean h() {
        return this instanceof JsonNull;
    }

    public boolean i() {
        return this instanceof JsonObject;
    }

    public boolean j() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setStrictness(Strictness.LENIENT);
            Streams.b(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
