package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    private static final TypeAdapterFactory f31030c = b(ToNumberPolicy.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final Gson f31031a;

    /* renamed from: b  reason: collision with root package name */
    private final ToNumberStrategy f31032b;

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31034a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31034a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31034a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31034a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31034a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31034a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31034a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ObjectTypeAdapter.AnonymousClass2.<clinit>():void");
        }
    }

    public static TypeAdapterFactory a(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.DOUBLE) {
            return f31030c;
        }
        return b(toNumberStrategy);
    }

    private static TypeAdapterFactory b(final ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.c() == Object.class) {
                    return new ObjectTypeAdapter(gson, ToNumberStrategy.this);
                }
                return null;
            }
        };
    }

    private Object c(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i2 = AnonymousClass2.f31034a[jsonToken.ordinal()];
        if (i2 == 3) {
            return jsonReader.nextString();
        }
        if (i2 == 4) {
            return this.f31032b.a(jsonReader);
        }
        if (i2 == 5) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i2 == 6) {
            jsonReader.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    private Object d(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i2 = AnonymousClass2.f31034a[jsonToken.ordinal()];
        if (i2 == 1) {
            jsonReader.beginArray();
            return new ArrayList();
        } else if (i2 != 2) {
            return null;
        } else {
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
    }

    public Object read(JsonReader jsonReader) throws IOException {
        String str;
        boolean z2;
        JsonToken peek = jsonReader.peek();
        Object d2 = d(jsonReader, peek);
        if (d2 == null) {
            return c(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (d2 instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Object d3 = d(jsonReader, peek2);
                if (d3 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (d3 == null) {
                    d3 = c(jsonReader, peek2);
                }
                if (d2 instanceof List) {
                    ((List) d2).add(d3);
                } else {
                    ((Map) d2).put(str, d3);
                }
                if (z2) {
                    arrayDeque.addLast(d2);
                    d2 = d3;
                }
            } else {
                if (d2 instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return d2;
                }
                d2 = arrayDeque.removeLast();
            }
        }
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter<?> o2 = this.f31031a.o(obj.getClass());
        if (o2 instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        o2.write(jsonWriter, obj);
    }

    private ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.f31031a = gson;
        this.f31032b = toNumberStrategy;
    }
}
