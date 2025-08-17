package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public static JsonElement b(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        Strictness strictness = jsonReader.getStrictness();
        if (strictness == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            JsonElement a2 = Streams.a(jsonReader);
            jsonReader.setStrictness(strictness);
            return a2;
        } catch (StackOverflowError e2) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
        } catch (OutOfMemoryError e3) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e3);
        } catch (Throwable th) {
            jsonReader.setStrictness(strictness);
            throw th;
        }
    }

    public static JsonElement c(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement b2 = b(jsonReader);
            if (!b2.h()) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                }
            }
            return b2;
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException((Throwable) e4);
        }
    }

    public static JsonElement d(String str) throws JsonSyntaxException {
        return c(new StringReader(str));
    }

    @Deprecated
    public JsonElement a(String str) throws JsonSyntaxException {
        return d(str);
    }
}
