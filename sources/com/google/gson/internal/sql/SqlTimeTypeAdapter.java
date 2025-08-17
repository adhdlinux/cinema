package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

final class SqlTimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f31131b = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.c() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f31132a;

    /* renamed from: a */
    public Time read(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this) {
            TimeZone timeZone = this.f31132a.getTimeZone();
            try {
                time = new Time(this.f31132a.parse(nextString).getTime());
                this.f31132a.setTimeZone(timeZone);
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Time; at path " + jsonReader.getPreviousPath(), e2);
            } catch (Throwable th) {
                this.f31132a.setTimeZone(timeZone);
                throw th;
            }
        }
        return time;
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        String format;
        if (time == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f31132a.format(time);
        }
        jsonWriter.value(format);
    }

    private SqlTimeTypeAdapter() {
        this.f31132a = new SimpleDateFormat("hh:mm:ss a");
    }
}
