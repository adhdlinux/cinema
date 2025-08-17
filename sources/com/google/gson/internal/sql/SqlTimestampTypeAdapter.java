package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f31133b = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.c() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.o(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final TypeAdapter<Date> f31134a;

    /* renamed from: a */
    public Timestamp read(JsonReader jsonReader) throws IOException {
        Date read = this.f31134a.read(jsonReader);
        if (read != null) {
            return new Timestamp(read.getTime());
        }
        return null;
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.f31134a.write(jsonWriter, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.f31134a = typeAdapter;
    }
}
