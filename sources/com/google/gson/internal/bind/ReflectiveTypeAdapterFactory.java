package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: b  reason: collision with root package name */
    private final ConstructorConstructor f31035b;

    /* renamed from: c  reason: collision with root package name */
    private final FieldNamingStrategy f31036c;

    /* renamed from: d  reason: collision with root package name */
    private final Excluder f31037d;

    /* renamed from: e  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f31038e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ReflectionAccessFilter> f31039f;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        private final FieldsData f31048a;

        Adapter(FieldsData fieldsData) {
            this.f31048a = fieldsData;
        }

        /* access modifiers changed from: package-private */
        public abstract A a();

        /* access modifiers changed from: package-private */
        public abstract T b(A a2);

        /* access modifiers changed from: package-private */
        public abstract void c(A a2, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object a2 = a();
            Map<String, BoundField> map = this.f31048a.f31054a;
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = map.get(jsonReader.nextName());
                    if (boundField == null) {
                        jsonReader.skipValue();
                    } else {
                        c(a2, jsonReader, boundField);
                    }
                }
                jsonReader.endObject();
                return b(a2);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw ReflectionHelper.e(e3);
            }
        }

        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (t2 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField c2 : this.f31048a.f31055b) {
                    c2.c(jsonWriter, t2);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw ReflectionHelper.e(e2);
            }
        }
    }

    static abstract class BoundField {

        /* renamed from: a  reason: collision with root package name */
        final String f31049a;

        /* renamed from: b  reason: collision with root package name */
        final Field f31050b;

        /* renamed from: c  reason: collision with root package name */
        final String f31051c;

        protected BoundField(String str, Field field) {
            this.f31049a = str;
            this.f31050b = field;
            this.f31051c = field.getName();
        }

        /* access modifiers changed from: package-private */
        public abstract void a(JsonReader jsonReader, int i2, Object[] objArr) throws IOException, JsonParseException;

        /* access modifiers changed from: package-private */
        public abstract void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b  reason: collision with root package name */
        private final ObjectConstructor<T> f31052b;

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, FieldsData fieldsData) {
            super(fieldsData);
            this.f31052b = objectConstructor;
        }

        /* access modifiers changed from: package-private */
        public T a() {
            return this.f31052b.a();
        }

        /* access modifiers changed from: package-private */
        public T b(T t2) {
            return t2;
        }

        /* access modifiers changed from: package-private */
        public void c(T t2, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.b(jsonReader, t2);
        }
    }

    private static class FieldsData {

        /* renamed from: c  reason: collision with root package name */
        public static final FieldsData f31053c = new FieldsData(Collections.emptyMap(), Collections.emptyList());

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, BoundField> f31054a;

        /* renamed from: b  reason: collision with root package name */
        public final List<BoundField> f31055b;

        public FieldsData(Map<String, BoundField> map, List<BoundField> list) {
            this.f31054a = map;
            this.f31055b = list;
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e  reason: collision with root package name */
        static final Map<Class<?>, Object> f31056e = f();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor<T> f31057b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f31058c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Integer> f31059d = new HashMap();

        RecordAdapter(Class<T> cls, FieldsData fieldsData, boolean z2) {
            super(fieldsData);
            Constructor<T> i2 = ReflectionHelper.i(cls);
            this.f31057b = i2;
            if (z2) {
                ReflectiveTypeAdapterFactory.b((Object) null, i2);
            } else {
                ReflectionHelper.o(i2);
            }
            String[] k2 = ReflectionHelper.k(cls);
            for (int i3 = 0; i3 < k2.length; i3++) {
                this.f31059d.put(k2[i3], Integer.valueOf(i3));
            }
            Class[] parameterTypes = this.f31057b.getParameterTypes();
            this.f31058c = new Object[parameterTypes.length];
            for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                this.f31058c[i4] = f31056e.get(parameterTypes[i4]);
            }
        }

        private static Map<Class<?>, Object> f() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Object[] a() {
            return (Object[]) this.f31058c.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public T b(Object[] objArr) {
            try {
                return this.f31057b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw ReflectionHelper.e(e2);
            } catch (IllegalArgumentException | InstantiationException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(this.f31057b) + "' with args " + Arrays.toString(objArr), e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(this.f31057b) + "' with args " + Arrays.toString(objArr), e4.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void c(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer num = this.f31059d.get(boundField.f31051c);
            if (num != null) {
                boundField.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.c(this.f31057b) + "' for field with name '" + boundField.f31051c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.f31035b = constructorConstructor;
        this.f31036c = fieldNamingStrategy;
        this.f31037d = excluder;
        this.f31038e = jsonAdapterAnnotationTypeAdapterFactory;
        this.f31039f = list;
    }

    /* access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void b(Object obj, M m2) {
        if (Modifier.isStatic(((Member) m2).getModifiers())) {
            obj = null;
        }
        if (!ReflectionAccessFilterHelper.a(m2, obj)) {
            String g2 = ReflectionHelper.g(m2, true);
            throw new JsonIOException(g2 + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private BoundField c(Gson gson, Field field, Method method, String str, TypeToken<?> typeToken, boolean z2, boolean z3) {
        boolean z4;
        TypeAdapter<?> typeAdapter;
        final TypeAdapter<?> typeAdapter2;
        TypeAdapter<?> typeAdapter3;
        Gson gson2 = gson;
        final boolean a2 = Primitives.a(typeToken.c());
        int modifiers = field.getModifiers();
        boolean z5 = true;
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z4 = false;
        } else {
            z4 = true;
        }
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) {
            typeAdapter = this.f31038e.c(this.f31035b, gson, typeToken, jsonAdapter, false);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter == null) {
            z5 = false;
        }
        TypeToken<?> typeToken2 = typeToken;
        if (typeAdapter == null) {
            typeAdapter = gson.n(typeToken2);
        }
        TypeAdapter<?> typeAdapter4 = typeAdapter;
        if (z2) {
            if (z5) {
                typeAdapter3 = typeAdapter4;
            } else {
                typeAdapter3 = new TypeAdapterRuntimeTypeWrapper<>(gson, typeAdapter4, typeToken.d());
            }
            typeAdapter2 = typeAdapter3;
        } else {
            typeAdapter2 = typeAdapter4;
        }
        final boolean z6 = z3;
        final Method method2 = method;
        final TypeAdapter<?> typeAdapter5 = typeAdapter4;
        final boolean z7 = z4;
        return new BoundField(str, field) {
            /* access modifiers changed from: package-private */
            public void a(JsonReader jsonReader, int i2, Object[] objArr) throws IOException, JsonParseException {
                Object read = typeAdapter5.read(jsonReader);
                if (read != null || !a2) {
                    objArr[i2] = read;
                    return;
                }
                throw new JsonParseException("null is not allowed as value for record component '" + this.f31051c + "' of primitive type; at path " + jsonReader.getPath());
            }

            /* access modifiers changed from: package-private */
            public void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter5.read(jsonReader);
                if (read != null || !a2) {
                    if (z6) {
                        ReflectiveTypeAdapterFactory.b(obj, this.f31050b);
                    } else if (z7) {
                        String g2 = ReflectionHelper.g(this.f31050b, false);
                        throw new JsonIOException("Cannot set value of 'static final' " + g2);
                    }
                    this.f31050b.set(obj, read);
                }
            }

            /* access modifiers changed from: package-private */
            public void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                Object obj2;
                if (z6) {
                    Method method = method2;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.b(obj, this.f31050b);
                    } else {
                        ReflectiveTypeAdapterFactory.b(obj, method);
                    }
                }
                Method method2 = method2;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e2) {
                        String g2 = ReflectionHelper.g(method2, false);
                        throw new JsonIOException("Accessor " + g2 + " threw exception", e2.getCause());
                    }
                } else {
                    obj2 = this.f31050b.get(obj);
                }
                if (obj2 != obj) {
                    jsonWriter.name(this.f31049a);
                    typeAdapter2.write(jsonWriter, obj2);
                }
            }
        };
    }

    private static IllegalArgumentException d(Class<?> cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + ReflectionHelper.f(field) + " and " + ReflectionHelper.f(field2) + "\nSee " + TroubleshootingGuide.a("duplicate-fields"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.FieldsData e(com.google.gson.Gson r24, com.google.gson.reflect.TypeToken<?> r25, java.lang.Class<?> r26, boolean r27, boolean r28) {
        /*
            r23 = this;
            r8 = r23
            r9 = r26
            boolean r0 = r26.isInterface()
            if (r0 == 0) goto L_0x000d
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$FieldsData r0 = com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.FieldsData.f31053c
            return r0
        L_0x000d:
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            r12 = r25
            r0 = r27
            r13 = r9
        L_0x001c:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r13 == r1) goto L_0x015c
            java.lang.reflect.Field[] r14 = r13.getDeclaredFields()
            r15 = 1
            r7 = 0
            if (r13 == r9) goto L_0x0061
            int r1 = r14.length
            if (r1 <= 0) goto L_0x0061
            java.util.List<com.google.gson.ReflectionAccessFilter> r0 = r8.f31039f
            com.google.gson.ReflectionAccessFilter$FilterResult r0 = com.google.gson.internal.ReflectionAccessFilterHelper.b(r0, r13)
            com.google.gson.ReflectionAccessFilter$FilterResult r1 = com.google.gson.ReflectionAccessFilter.FilterResult.BLOCK_ALL
            if (r0 == r1) goto L_0x003d
            com.google.gson.ReflectionAccessFilter$FilterResult r1 = com.google.gson.ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE
            if (r0 != r1) goto L_0x003b
            r0 = 1
            goto L_0x0061
        L_0x003b:
            r0 = 0
            goto L_0x0061
        L_0x003d:
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ReflectionAccessFilter does not permit using reflection for "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = " (supertype of "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "). Register a TypeAdapter for this type or adjust the access filter."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0061:
            r16 = r0
            int r6 = r14.length
            r5 = 0
        L_0x0065:
            if (r5 >= r6) goto L_0x0144
            r4 = r14[r5]
            boolean r17 = r8.g(r4, r15)
            boolean r0 = r8.g(r4, r7)
            if (r17 != 0) goto L_0x007d
            if (r0 != 0) goto L_0x007d
            r21 = r5
            r19 = r6
            r22 = 0
            goto L_0x013c
        L_0x007d:
            r1 = 0
            if (r28 == 0) goto L_0x00c6
            int r2 = r4.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
            if (r2 == 0) goto L_0x008e
            r3 = r1
            r18 = 0
            goto L_0x00c9
        L_0x008e:
            java.lang.reflect.Method r1 = com.google.gson.internal.reflect.ReflectionHelper.h(r13, r4)
            if (r16 != 0) goto L_0x0097
            com.google.gson.internal.reflect.ReflectionHelper.o(r1)
        L_0x0097:
            java.lang.Class<com.google.gson.annotations.SerializedName> r2 = com.google.gson.annotations.SerializedName.class
            java.lang.annotation.Annotation r3 = r1.getAnnotation(r2)
            if (r3 == 0) goto L_0x00c6
            java.lang.annotation.Annotation r2 = r4.getAnnotation(r2)
            if (r2 == 0) goto L_0x00a6
            goto L_0x00c6
        L_0x00a6:
            java.lang.String r0 = com.google.gson.internal.reflect.ReflectionHelper.g(r1, r7)
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "@SerializedName on "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " is not supported"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x00c6:
            r18 = r0
            r3 = r1
        L_0x00c9:
            if (r16 != 0) goto L_0x00d0
            if (r3 != 0) goto L_0x00d0
            com.google.gson.internal.reflect.ReflectionHelper.o(r4)
        L_0x00d0:
            java.lang.reflect.Type r0 = r12.d()
            java.lang.reflect.Type r1 = r4.getGenericType()
            java.lang.reflect.Type r0 = com.google.gson.internal.C$Gson$Types.p(r0, r13, r1)
            java.util.List r2 = r8.f(r4)
            java.lang.Object r1 = r2.get(r7)
            java.lang.String r1 = (java.lang.String) r1
            com.google.gson.reflect.TypeToken r19 = com.google.gson.reflect.TypeToken.b(r0)
            r0 = r23
            r25 = r1
            r1 = r24
            r20 = r2
            r2 = r4
            r15 = r4
            r4 = r25
            r21 = r5
            r5 = r19
            r19 = r6
            r6 = r17
            r22 = 0
            r7 = r16
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField r0 = r0.c(r1, r2, r3, r4, r5, r6, r7)
            if (r18 == 0) goto L_0x0128
            java.util.Iterator r1 = r20.iterator()
        L_0x010c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0128
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r10.put(r2, r0)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField r3 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) r3
            if (r3 != 0) goto L_0x0121
            goto L_0x010c
        L_0x0121:
            java.lang.reflect.Field r0 = r3.f31050b
            java.lang.IllegalArgumentException r0 = d(r9, r2, r0, r15)
            throw r0
        L_0x0128:
            if (r17 == 0) goto L_0x013c
            r1 = r25
            java.lang.Object r0 = r11.put(r1, r0)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField r0 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) r0
            if (r0 != 0) goto L_0x0135
            goto L_0x013c
        L_0x0135:
            java.lang.reflect.Field r0 = r0.f31050b
            java.lang.IllegalArgumentException r0 = d(r9, r1, r0, r15)
            throw r0
        L_0x013c:
            int r5 = r21 + 1
            r6 = r19
            r7 = 0
            r15 = 1
            goto L_0x0065
        L_0x0144:
            java.lang.reflect.Type r0 = r12.d()
            java.lang.reflect.Type r1 = r13.getGenericSuperclass()
            java.lang.reflect.Type r0 = com.google.gson.internal.C$Gson$Types.p(r0, r13, r1)
            com.google.gson.reflect.TypeToken r12 = com.google.gson.reflect.TypeToken.b(r0)
            java.lang.Class r13 = r12.c()
            r0 = r16
            goto L_0x001c
        L_0x015c:
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$FieldsData r0 = new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$FieldsData
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Collection r2 = r11.values()
            r1.<init>(r2)
            r0.<init>(r10, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.e(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$FieldsData");
    }

    private List<String> f(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f31036c.a(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z2) {
        return !this.f31037d.c(field, z2);
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z2;
        Class<? super T> c2 = typeToken.c();
        if (!Object.class.isAssignableFrom(c2)) {
            return null;
        }
        if (ReflectionHelper.l(c2)) {
            return new TypeAdapter<T>() {
                public T read(JsonReader jsonReader) throws IOException {
                    jsonReader.skipValue();
                    return null;
                }

                public String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }

                public void write(JsonWriter jsonWriter, T t2) throws IOException {
                    jsonWriter.nullValue();
                }
            };
        }
        ReflectionAccessFilter.FilterResult b2 = ReflectionAccessFilterHelper.b(this.f31039f, c2);
        if (b2 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (b2 == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ReflectionHelper.m(c2)) {
                return new RecordAdapter(c2, e(gson, typeToken, c2, z2, true), z2);
            }
            return new FieldReflectionAdapter(this.f31035b.b(typeToken), e(gson, typeToken, c2, z2, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + c2 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
