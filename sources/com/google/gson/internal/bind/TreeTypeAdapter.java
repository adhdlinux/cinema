package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonSerializer<T> f31060a;

    /* renamed from: b  reason: collision with root package name */
    private final JsonDeserializer<T> f31061b;

    /* renamed from: c  reason: collision with root package name */
    final Gson f31062c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeToken<T> f31063d;

    /* renamed from: e  reason: collision with root package name */
    private final TypeAdapterFactory f31064e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeTypeAdapter<T>.GsonContextImpl f31065f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f31066g;

    /* renamed from: h  reason: collision with root package name */
    private volatile TypeAdapter<T> f31067h;

    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: b  reason: collision with root package name */
        private final TypeToken<?> f31069b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f31070c;

        /* renamed from: d  reason: collision with root package name */
        private final Class<?> f31071d;

        /* renamed from: e  reason: collision with root package name */
        private final JsonSerializer<?> f31072e;

        /* renamed from: f  reason: collision with root package name */
        private final JsonDeserializer<?> f31073f;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            JsonSerializer<?> jsonSerializer;
            boolean z3;
            JsonDeserializer<?> jsonDeserializer = null;
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.f31072e = jsonSerializer;
            jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            this.f31073f = jsonDeserializer;
            if (jsonSerializer == null && jsonDeserializer == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            C$Gson$Preconditions.a(z3);
            this.f31069b = typeToken;
            this.f31070c = z2;
            this.f31071d = cls;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z2;
            TypeToken<?> typeToken2 = this.f31069b;
            if (typeToken2 == null) {
                z2 = this.f31071d.isAssignableFrom(typeToken.c());
            } else if (typeToken2.equals(typeToken) || (this.f31070c && this.f31069b.d() == typeToken.c())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return new TreeTypeAdapter(this.f31072e, this.f31073f, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory, boolean z2) {
        this.f31065f = new GsonContextImpl();
        this.f31060a = jsonSerializer;
        this.f31061b = jsonDeserializer;
        this.f31062c = gson;
        this.f31063d = typeToken;
        this.f31064e = typeAdapterFactory;
        this.f31066g = z2;
    }

    private TypeAdapter<T> b() {
        TypeAdapter<T> typeAdapter = this.f31067h;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> p2 = this.f31062c.p(this.f31064e, this.f31063d);
        this.f31067h = p2;
        return p2;
    }

    public static TypeAdapterFactory c(TypeToken<?> typeToken, Object obj) {
        boolean z2;
        if (typeToken.d() == typeToken.c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new SingleTypeFactory(obj, typeToken, z2, (Class<?>) null);
    }

    public TypeAdapter<T> a() {
        return this.f31060a != null ? this : b();
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (this.f31061b == null) {
            return b().read(jsonReader);
        }
        JsonElement a2 = Streams.a(jsonReader);
        if (!this.f31066g || !a2.h()) {
            return this.f31061b.a(a2, this.f31063d.d(), this.f31065f);
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, T t2) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f31060a;
        if (jsonSerializer == null) {
            b().write(jsonWriter, t2);
        } else if (!this.f31066g || t2 != null) {
            Streams.b(jsonSerializer.a(t2, this.f31063d.d(), this.f31065f), jsonWriter);
        } else {
            jsonWriter.nullValue();
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }
}
