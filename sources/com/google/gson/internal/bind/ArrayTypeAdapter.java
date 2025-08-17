package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapterFactory f30993c = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type d2 = typeToken.d();
            if (!(d2 instanceof GenericArrayType) && (!(d2 instanceof Class) || !((Class) d2).isArray())) {
                return null;
            }
            Type g2 = C$Gson$Types.g(d2);
            return new ArrayTypeAdapter(gson, gson.n(TypeToken.b(g2)), C$Gson$Types.k(g2));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Class<E> f30994a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<E> f30995b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f30995b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f30994a = cls;
    }

    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f30995b.read(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        if (!this.f30994a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.f30994a, size));
        }
        Object newInstance = Array.newInstance(this.f30994a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f30995b.write(jsonWriter, Array.get(obj, i2));
        }
        jsonWriter.endArray();
    }
}
