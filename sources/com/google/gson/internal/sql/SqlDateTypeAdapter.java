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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f31129b = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f31130a;

    /* renamed from: a */
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this) {
            TimeZone timeZone = this.f31130a.getTimeZone();
            try {
                date = new Date(this.f31130a.parse(nextString).getTime());
                this.f31130a.setTimeZone(timeZone);
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e2);
            } catch (Throwable th) {
                this.f31130a.setTimeZone(timeZone);
                throw th;
            }
        }
        return date;
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f31130a.format(date);
        }
        jsonWriter.value(format);
    }

    private SqlDateTypeAdapter() {
        this.f31130a = new SimpleDateFormat("MMM d, yyyy");
    }
}
