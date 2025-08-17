package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b  reason: collision with root package name */
    private final ConstructorConstructor f31020b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f31021c;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter<K> f31022a;

        /* renamed from: b  reason: collision with root package name */
        private final TypeAdapter<V> f31023b;

        /* renamed from: c  reason: collision with root package name */
        private final ObjectConstructor<? extends Map<K, V>> f31024c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f31022a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f31023b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f31024c = objectConstructor;
        }

        private String a(JsonElement jsonElement) {
            if (jsonElement.j()) {
                JsonPrimitive d2 = jsonElement.d();
                if (d2.s()) {
                    return String.valueOf(d2.p());
                }
                if (d2.q()) {
                    return Boolean.toString(d2.m());
                }
                if (d2.t()) {
                    return d2.e();
                }
                throw new AssertionError();
            } else if (jsonElement.h()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: b */
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f31024c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read = this.f31022a.read(jsonReader);
                    if (map.put(read, this.f31023b.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    K read2 = this.f31022a.read(jsonReader);
                    if (map.put(read2, this.f31023b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        /* renamed from: c */
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            boolean z2;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!MapTypeAdapterFactory.this.f31021c) {
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name(String.valueOf(next.getKey()));
                    this.f31023b.write(jsonWriter, next.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z3 = false;
                for (Map.Entry next2 : map.entrySet()) {
                    JsonElement jsonTree = this.f31022a.toJsonTree(next2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(next2.getValue());
                    if (jsonTree.g() || jsonTree.i()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 |= z2;
                }
                if (z3) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i2 < size) {
                        jsonWriter.beginArray();
                        Streams.b((JsonElement) arrayList.get(i2), jsonWriter);
                        this.f31023b.write(jsonWriter, arrayList2.get(i2));
                        jsonWriter.endArray();
                        i2++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    jsonWriter.name(a((JsonElement) arrayList.get(i2)));
                    this.f31023b.write(jsonWriter, arrayList2.get(i2));
                    i2++;
                }
                jsonWriter.endObject();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z2) {
        this.f31020b = constructorConstructor;
        this.f31021c = z2;
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.f31082f;
        }
        return gson.n(TypeToken.b(type));
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type d2 = typeToken.d();
        Class<? super T> c2 = typeToken.c();
        if (!Map.class.isAssignableFrom(c2)) {
            return null;
        }
        Type[] j2 = C$Gson$Types.j(d2, c2);
        return new Adapter(gson, j2[0], a(gson, j2[0]), j2[1], gson.n(TypeToken.b(j2[1])), this.f31020b.b(typeToken));
    }
}
