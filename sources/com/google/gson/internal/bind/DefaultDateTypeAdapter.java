package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapterFactory f30999c = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.c() == Date.class) {
                return new DefaultDateTypeAdapter(DateType.f31002b, 2, 2);
            }
            return null;
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateType<T> f31000a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f31001b;

    public static abstract class DateType<T extends Date> {

        /* renamed from: b  reason: collision with root package name */
        public static final DateType<Date> f31002b = new DateType<Date>(Date.class) {
            /* access modifiers changed from: protected */
            public Date d(Date date) {
                return date;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f31003a;

        protected DateType(Class<T> cls) {
            this.f31003a = cls;
        }

        private TypeAdapterFactory c(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.b(this.f31003a, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory a(int i2, int i3) {
            return c(new DefaultDateTypeAdapter(this, i2, i3));
        }

        public final TypeAdapterFactory b(String str) {
            return c(new DefaultDateTypeAdapter(this, str));
        }

        /* access modifiers changed from: protected */
        public abstract T d(Date date);
    }

    /* JADX INFO: finally extract failed */
    private Date a(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.f31001b) {
            for (DateFormat next : this.f31001b) {
                TimeZone timeZone = next.getTimeZone();
                try {
                    Date parse = next.parse(nextString);
                    next.setTimeZone(timeZone);
                    return parse;
                } catch (ParseException unused) {
                    next.setTimeZone(timeZone);
                } catch (Throwable th) {
                    next.setTimeZone(timeZone);
                    throw th;
                }
            }
            try {
                return ISO8601Utils.c(nextString, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e2);
            }
        }
    }

    /* renamed from: b */
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.f31000a.d(a(jsonReader));
    }

    /* renamed from: c */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.f31001b.get(0);
        synchronized (this.f31001b) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    public String toString() {
        DateFormat dateFormat = this.f31001b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.f31001b = arrayList;
        Objects.requireNonNull(dateType);
        this.f31000a = dateType;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f31001b = arrayList;
        Objects.requireNonNull(dateType);
        this.f31000a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (JavaVersion.c()) {
            arrayList.add(PreJava9DateFormatProvider.c(i2, i3));
        }
    }
}
