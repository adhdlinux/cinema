package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f31074a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<T> f31075b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f31076c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f31074a = gson;
        this.f31075b = typeAdapter;
        this.f31076c = type;
    }

    private static Type a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean b(TypeAdapter<?> typeAdapter) {
        TypeAdapter<?> a2;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (a2 = ((SerializationDelegatingTypeAdapter) typeAdapter).a()) != typeAdapter) {
            typeAdapter = a2;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    public T read(JsonReader jsonReader) throws IOException {
        return this.f31075b.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t2) throws IOException {
        TypeAdapter<T> typeAdapter = this.f31075b;
        Type a2 = a(this.f31076c, t2);
        if (a2 != this.f31076c) {
            typeAdapter = this.f31074a.n(TypeToken.b(a2));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !b(this.f31075b)) {
                typeAdapter = this.f31075b;
            }
        }
        typeAdapter.write(jsonWriter, t2);
    }
}
