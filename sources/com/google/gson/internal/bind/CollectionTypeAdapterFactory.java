package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b  reason: collision with root package name */
    private final ConstructorConstructor f30996b;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter<E> f30997a;

        /* renamed from: b  reason: collision with root package name */
        private final ObjectConstructor<? extends Collection<E>> f30998b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f30997a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f30998b = objectConstructor;
        }

        /* renamed from: a */
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f30998b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f30997a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E write : collection) {
                this.f30997a.write(jsonWriter, write);
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f30996b = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type d2 = typeToken.d();
        Class<? super T> c2 = typeToken.c();
        if (!Collection.class.isAssignableFrom(c2)) {
            return null;
        }
        Type h2 = C$Gson$Types.h(d2, c2);
        return new Adapter(gson, h2, gson.n(TypeToken.b(h2)), this.f30996b.b(typeToken));
    }
}
