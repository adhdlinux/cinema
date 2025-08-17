package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final FormattingStyle A = FormattingStyle.f30833d;
    static final String B = null;
    static final FieldNamingStrategy C = FieldNamingPolicy.IDENTITY;
    static final ToNumberStrategy D = ToNumberPolicy.DOUBLE;
    static final ToNumberStrategy E = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* renamed from: z  reason: collision with root package name */
    static final Strictness f30838z = null;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> f30839a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> f30840b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstructorConstructor f30841c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f30842d;

    /* renamed from: e  reason: collision with root package name */
    final List<TypeAdapterFactory> f30843e;

    /* renamed from: f  reason: collision with root package name */
    final Excluder f30844f;

    /* renamed from: g  reason: collision with root package name */
    final FieldNamingStrategy f30845g;

    /* renamed from: h  reason: collision with root package name */
    final Map<Type, InstanceCreator<?>> f30846h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f30847i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f30848j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f30849k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f30850l;

    /* renamed from: m  reason: collision with root package name */
    final FormattingStyle f30851m;

    /* renamed from: n  reason: collision with root package name */
    final Strictness f30852n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f30853o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f30854p;

    /* renamed from: q  reason: collision with root package name */
    final String f30855q;

    /* renamed from: r  reason: collision with root package name */
    final int f30856r;

    /* renamed from: s  reason: collision with root package name */
    final int f30857s;

    /* renamed from: t  reason: collision with root package name */
    final LongSerializationPolicy f30858t;

    /* renamed from: u  reason: collision with root package name */
    final List<TypeAdapterFactory> f30859u;

    /* renamed from: v  reason: collision with root package name */
    final List<TypeAdapterFactory> f30860v;

    /* renamed from: w  reason: collision with root package name */
    final ToNumberStrategy f30861w;

    /* renamed from: x  reason: collision with root package name */
    final ToNumberStrategy f30862x;

    /* renamed from: y  reason: collision with root package name */
    final List<ReflectionAccessFilter> f30863y;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        private TypeAdapter<T> f30868a = null;

        FutureTypeAdapter() {
        }

        private TypeAdapter<T> b() {
            TypeAdapter<T> typeAdapter = this.f30868a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public TypeAdapter<T> a() {
            return b();
        }

        public void c(TypeAdapter<T> typeAdapter) {
            if (this.f30868a == null) {
                this.f30868a = typeAdapter;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }

        public T read(JsonReader jsonReader) throws IOException {
            return b().read(jsonReader);
        }

        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            b().write(jsonWriter, t2);
        }
    }

    public Gson() {
        this(Excluder.f30940h, C, Collections.emptyMap(), false, false, false, true, A, f30838z, false, true, LongSerializationPolicy.DEFAULT, B, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), D, E, Collections.emptyList());
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IOException e3) {
                throw new JsonIOException((Throwable) e3);
            }
        }
    }

    private static TypeAdapter<AtomicLong> b(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() {
            /* renamed from: a */
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(jsonReader)).longValue());
            }

            /* renamed from: b */
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> c(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() {
            /* renamed from: a */
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            /* renamed from: b */
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLongArray.get(i2)));
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> e(boolean z2) {
        if (z2) {
            return TypeAdapters.f31098v;
        }
        return new TypeAdapter<Number>() {
            /* renamed from: a */
            public Double read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            /* renamed from: b */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                double doubleValue = number.doubleValue();
                Gson.d(doubleValue);
                jsonWriter.value(doubleValue);
            }
        };
    }

    private TypeAdapter<Number> f(boolean z2) {
        if (z2) {
            return TypeAdapters.f31097u;
        }
        return new TypeAdapter<Number>() {
            /* renamed from: a */
            public Float read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            /* renamed from: b */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                float floatValue = number.floatValue();
                Gson.d((double) floatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(floatValue);
                }
                jsonWriter.value(number);
            }
        };
    }

    private static TypeAdapter<Number> q(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.f31096t;
        }
        return new TypeAdapter<Number>() {
            /* renamed from: a */
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader.nextLong());
                }
                jsonReader.nextNull();
                return null;
            }

            /* renamed from: b */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    public <T> T g(JsonElement jsonElement, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return i(new JsonTreeReader(jsonElement), typeToken);
    }

    public <T> T h(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return Primitives.b(cls).cast(g(jsonElement, TypeToken.a(cls)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        throw new java.lang.AssertionError("AssertionError (GSON 2.11.0): " + r6.getMessage(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        r5.setStrictness(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[ExcHandler: AssertionError (r6v5 'e' java.lang.AssertionError A[CUSTOM_DECLARE]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ EOFException -> 0x0029, IllegalStateException -> 0x0050, IOException -> 0x0049, AssertionError -> 0x002d, all -> 0x002b }, ExcHandler: IOException (r6v4 'e' java.io.IOException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[Catch:{ EOFException -> 0x0029, IllegalStateException -> 0x0050, IOException -> 0x0049, AssertionError -> 0x002d, all -> 0x002b }, ExcHandler: IllegalStateException (r6v3 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060 A[SYNTHETIC, Splitter:B:30:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T i(com.google.gson.stream.JsonReader r5, com.google.gson.reflect.TypeToken<T> r6) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        /*
            r4 = this;
            com.google.gson.Strictness r0 = r5.getStrictness()
            com.google.gson.Strictness r1 = r4.f30852n
            if (r1 == 0) goto L_0x000c
            r5.setStrictness(r1)
            goto L_0x0019
        L_0x000c:
            com.google.gson.Strictness r1 = r5.getStrictness()
            com.google.gson.Strictness r2 = com.google.gson.Strictness.LEGACY_STRICT
            if (r1 != r2) goto L_0x0019
            com.google.gson.Strictness r1 = com.google.gson.Strictness.LENIENT
            r5.setStrictness(r1)
        L_0x0019:
            r5.peek()     // Catch:{ EOFException -> 0x0057, IllegalStateException -> 0x0050, IOException -> 0x0049, AssertionError -> 0x002d }
            r1 = 0
            com.google.gson.TypeAdapter r6 = r4.n(r6)     // Catch:{ EOFException -> 0x0029, IllegalStateException -> 0x0050, IOException -> 0x0049, AssertionError -> 0x002d }
            java.lang.Object r6 = r6.read(r5)     // Catch:{ EOFException -> 0x0029, IllegalStateException -> 0x0050, IOException -> 0x0049, AssertionError -> 0x002d }
            r5.setStrictness(r0)
            return r6
        L_0x0029:
            r6 = move-exception
            goto L_0x0059
        L_0x002b:
            r6 = move-exception
            goto L_0x0066
        L_0x002d:
            r6 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "AssertionError (GSON 2.11.0): "
            r2.append(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x002b }
            r2.append(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002b }
            r1.<init>(r2, r6)     // Catch:{ all -> 0x002b }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0049:
            r6 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch:{ all -> 0x002b }
            r1.<init>((java.lang.Throwable) r6)     // Catch:{ all -> 0x002b }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0050:
            r6 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch:{ all -> 0x002b }
            r1.<init>((java.lang.Throwable) r6)     // Catch:{ all -> 0x002b }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0057:
            r6 = move-exception
            r1 = 1
        L_0x0059:
            if (r1 == 0) goto L_0x0060
            r5.setStrictness(r0)
            r5 = 0
            return r5
        L_0x0060:
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch:{ all -> 0x002b }
            r1.<init>((java.lang.Throwable) r6)     // Catch:{ all -> 0x002b }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0066:
            r5.setStrictness(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.i(com.google.gson.stream.JsonReader, com.google.gson.reflect.TypeToken):java.lang.Object");
    }

    public <T> T j(Reader reader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        JsonReader r2 = r(reader);
        T i2 = i(r2, typeToken);
        a(i2, r2);
        return i2;
    }

    public <T> T k(String str, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return j(new StringReader(str), typeToken);
    }

    public <T> T l(String str, Class<T> cls) throws JsonSyntaxException {
        return Primitives.b(cls).cast(k(str, TypeToken.a(cls)));
    }

    public <T> T m(String str, Type type) throws JsonSyntaxException {
        return k(str, TypeToken.b(type));
    }

    public <T> TypeAdapter<T> n(TypeToken<T> typeToken) {
        boolean z2;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter<T> typeAdapter = this.f30840b.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = this.f30839a.get();
        if (map == null) {
            map = new HashMap();
            this.f30839a.set(map);
            z2 = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z2 = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator<TypeAdapterFactory> it2 = this.f30843e.iterator();
            TypeAdapter<T> typeAdapter3 = null;
            while (true) {
                if (it2.hasNext()) {
                    typeAdapter3 = it2.next().create(this, typeToken);
                    if (typeAdapter3 != null) {
                        futureTypeAdapter.c(typeAdapter3);
                        map.put(typeToken, typeAdapter3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (typeAdapter3 != null) {
                if (z2) {
                    this.f30840b.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.11.0) cannot handle " + typeToken);
        } finally {
            if (z2) {
                this.f30839a.remove();
            }
        }
    }

    public <T> TypeAdapter<T> o(Class<T> cls) {
        return n(TypeToken.a(cls));
    }

    public <T> TypeAdapter<T> p(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        Objects.requireNonNull(typeAdapterFactory, "skipPast must not be null");
        Objects.requireNonNull(typeToken, "type must not be null");
        if (this.f30842d.d(typeToken, typeAdapterFactory)) {
            typeAdapterFactory = this.f30842d;
        }
        boolean z2 = false;
        for (TypeAdapterFactory next : this.f30843e) {
            if (z2) {
                TypeAdapter<T> create = next.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (next == typeAdapterFactory) {
                z2 = true;
            }
        }
        if (!z2) {
            return n(typeToken);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken);
    }

    public JsonReader r(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        Strictness strictness = this.f30852n;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonReader.setStrictness(strictness);
        return jsonReader;
    }

    public JsonWriter s(Writer writer) throws IOException {
        if (this.f30849k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setFormattingStyle(this.f30851m);
        jsonWriter.setHtmlSafe(this.f30850l);
        Strictness strictness = this.f30852n;
        if (strictness == null) {
            strictness = Strictness.LEGACY_STRICT;
        }
        jsonWriter.setStrictness(strictness);
        jsonWriter.setSerializeNulls(this.f30847i);
        return jsonWriter;
    }

    public String t(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        x(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f30847i + ",factories:" + this.f30843e + ",instanceCreators:" + this.f30841c + "}";
    }

    public String u(Object obj) {
        if (obj == null) {
            return t(JsonNull.f30890b);
        }
        return v(obj, obj.getClass());
    }

    public String v(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        z(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void w(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        Strictness strictness = jsonWriter.getStrictness();
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.f30850l);
        jsonWriter.setSerializeNulls(this.f30847i);
        Strictness strictness2 = this.f30852n;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        try {
            Streams.b(jsonElement, jsonWriter);
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        } catch (AssertionError e3) {
            throw new AssertionError("AssertionError (GSON 2.11.0): " + e3.getMessage(), e3);
        } catch (Throwable th) {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public void x(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            w(jsonElement, s(Streams.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public void y(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter<?> n2 = n(TypeToken.b(type));
        Strictness strictness = jsonWriter.getStrictness();
        Strictness strictness2 = this.f30852n;
        if (strictness2 != null) {
            jsonWriter.setStrictness(strictness2);
        } else if (jsonWriter.getStrictness() == Strictness.LEGACY_STRICT) {
            jsonWriter.setStrictness(Strictness.LENIENT);
        }
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setHtmlSafe(this.f30850l);
        jsonWriter.setSerializeNulls(this.f30847i);
        try {
            n2.write(jsonWriter, obj);
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        } catch (AssertionError e3) {
            throw new AssertionError("AssertionError (GSON 2.11.0): " + e3.getMessage(), e3);
        } catch (Throwable th) {
            jsonWriter.setStrictness(strictness);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public void z(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            y(obj, type, s(Streams.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, FormattingStyle formattingStyle, Strictness strictness, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i2, int i3, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2, List<ReflectionAccessFilter> list4) {
        Map<Type, InstanceCreator<?>> map2 = map;
        boolean z8 = z3;
        boolean z9 = z6;
        boolean z10 = z7;
        List<ReflectionAccessFilter> list5 = list4;
        this.f30839a = new ThreadLocal<>();
        this.f30840b = new ConcurrentHashMap();
        this.f30844f = excluder;
        this.f30845g = fieldNamingStrategy;
        this.f30846h = map2;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map2, z10, list5);
        this.f30841c = constructorConstructor;
        this.f30847i = z2;
        this.f30848j = z8;
        this.f30849k = z4;
        this.f30850l = z5;
        this.f30851m = formattingStyle;
        this.f30852n = strictness;
        this.f30853o = z9;
        this.f30854p = z10;
        this.f30858t = longSerializationPolicy;
        this.f30855q = str;
        this.f30856r = i2;
        this.f30857s = i3;
        this.f30859u = list;
        this.f30860v = list2;
        this.f30861w = toNumberStrategy;
        this.f30862x = toNumberStrategy2;
        this.f30863y = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.a(toNumberStrategy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.f31089m);
        arrayList.add(TypeAdapters.f31083g);
        arrayList.add(TypeAdapters.f31085i);
        arrayList.add(TypeAdapters.f31087k);
        TypeAdapter<Number> q2 = q(longSerializationPolicy);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, q2));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, e(z9)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, f(z9)));
        arrayList.add(NumberTypeAdapter.a(toNumberStrategy2));
        arrayList.add(TypeAdapters.f31091o);
        arrayList.add(TypeAdapters.f31093q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, b(q2)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, c(q2)));
        arrayList.add(TypeAdapters.f31095s);
        arrayList.add(TypeAdapters.f31100x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.f31102z));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.b(LazilyParsedNumber.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.f31080d);
        arrayList.add(DefaultDateTypeAdapter.f30999c);
        arrayList.add(TypeAdapters.S);
        if (SqlTypesSupport.f31135a) {
            arrayList.add(SqlTypesSupport.f31139e);
            arrayList.add(SqlTypesSupport.f31138d);
            arrayList.add(SqlTypesSupport.f31140f);
        }
        arrayList.add(ArrayTypeAdapter.f30993c);
        arrayList.add(TypeAdapters.f31078b);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, z8));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.f30842d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f30843e = Collections.unmodifiableList(arrayList);
    }
}
