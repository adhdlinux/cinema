package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() {
            public T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return TypeAdapter.this.read(jsonReader);
                }
                jsonReader.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t2) throws IOException {
                if (t2 == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t2);
                }
            }
        };
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final void toJson(Writer writer, T t2) throws IOException {
        write(new JsonWriter(writer), t2);
    }

    public final JsonElement toJsonTree(T t2) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t2);
            return jsonTreeWriter.a();
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t2) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson((Reader) new StringReader(str));
    }

    public final String toJson(T t2) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t2);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }
}
