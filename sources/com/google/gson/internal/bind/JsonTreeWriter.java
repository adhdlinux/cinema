package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: e  reason: collision with root package name */
    private static final Writer f31015e = new Writer() {
        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final JsonPrimitive f31016f = new JsonPrimitive("closed");

    /* renamed from: b  reason: collision with root package name */
    private final List<JsonElement> f31017b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private String f31018c;

    /* renamed from: d  reason: collision with root package name */
    private JsonElement f31019d = JsonNull.f30890b;

    public JsonTreeWriter() {
        super(f31015e);
    }

    private JsonElement f() {
        List<JsonElement> list = this.f31017b;
        return list.get(list.size() - 1);
    }

    private void i(JsonElement jsonElement) {
        if (this.f31018c != null) {
            if (!jsonElement.h() || getSerializeNulls()) {
                ((JsonObject) f()).k(this.f31018c, jsonElement);
            }
            this.f31018c = null;
        } else if (this.f31017b.isEmpty()) {
            this.f31019d = jsonElement;
        } else {
            JsonElement f2 = f();
            if (f2 instanceof JsonArray) {
                ((JsonArray) f2).k(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public JsonElement a() {
        if (this.f31017b.isEmpty()) {
            return this.f31019d;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f31017b);
    }

    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        i(jsonArray);
        this.f31017b.add(jsonArray);
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        i(jsonObject);
        this.f31017b.add(jsonObject);
        return this;
    }

    public void close() throws IOException {
        if (this.f31017b.isEmpty()) {
            this.f31017b.add(f31016f);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public JsonWriter endArray() throws IOException {
        if (this.f31017b.isEmpty() || this.f31018c != null) {
            throw new IllegalStateException();
        } else if (f() instanceof JsonArray) {
            List<JsonElement> list = this.f31017b;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter endObject() throws IOException {
        if (this.f31017b.isEmpty() || this.f31018c != null) {
            throw new IllegalStateException();
        } else if (f() instanceof JsonObject) {
            List<JsonElement> list = this.f31017b;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void flush() throws IOException {
    }

    public JsonWriter jsonValue(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f31017b.isEmpty() || this.f31018c != null) {
            throw new IllegalStateException("Did not expect a name");
        } else if (f() instanceof JsonObject) {
            this.f31018c = str;
            return this;
        } else {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        i(JsonNull.f30890b);
        return this;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        i(new JsonPrimitive(str));
        return this;
    }

    public JsonWriter value(boolean z2) throws IOException {
        i(new JsonPrimitive(Boolean.valueOf(z2)));
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        i(new JsonPrimitive(bool));
        return this;
    }

    public JsonWriter value(float f2) throws IOException {
        if (isLenient() || (!Float.isNaN(f2) && !Float.isInfinite(f2))) {
            i(new JsonPrimitive((Number) Float.valueOf(f2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f2);
    }

    public JsonWriter value(double d2) throws IOException {
        if (isLenient() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            i(new JsonPrimitive((Number) Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
    }

    public JsonWriter value(long j2) throws IOException {
        i(new JsonPrimitive((Number) Long.valueOf(j2)));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        i(new JsonPrimitive(number));
        return this;
    }
}
