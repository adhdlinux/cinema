package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* renamed from: b  reason: collision with root package name */
    private static final TypeAdapterFactory f31026b = b(ToNumberPolicy.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final ToNumberStrategy f31027a;

    /* renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31029a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31029a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31029a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31029a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.NumberTypeAdapter.AnonymousClass2.<clinit>():void");
        }
    }

    private NumberTypeAdapter(ToNumberStrategy toNumberStrategy) {
        this.f31027a = toNumberStrategy;
    }

    public static TypeAdapterFactory a(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return f31026b;
        }
        return b(toNumberStrategy);
    }

    private static TypeAdapterFactory b(ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.c() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    /* renamed from: c */
    public Number read(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i2 = AnonymousClass2.f31029a[peek.ordinal()];
        if (i2 == 1) {
            jsonReader.nextNull();
            return null;
        } else if (i2 == 2 || i2 == 3) {
            return this.f31027a.a(jsonReader);
        } else {
            throw new JsonSyntaxException("Expecting number, got: " + peek + "; at path " + jsonReader.getPath());
        }
    }

    /* renamed from: d */
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
