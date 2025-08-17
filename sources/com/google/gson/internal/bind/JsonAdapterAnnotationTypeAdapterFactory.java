package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: d  reason: collision with root package name */
    private static final TypeAdapterFactory f31004d = new DummyTypeAdapterFactory();

    /* renamed from: e  reason: collision with root package name */
    private static final TypeAdapterFactory f31005e = new DummyTypeAdapterFactory();

    /* renamed from: b  reason: collision with root package name */
    private final ConstructorConstructor f31006b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, TypeAdapterFactory> f31007c = new ConcurrentHashMap();

    private static class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            throw new AssertionError("Factory should not be used");
        }
    }

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f31006b = constructorConstructor;
    }

    private static Object a(ConstructorConstructor constructorConstructor, Class<?> cls) {
        return constructorConstructor.b(TypeToken.a(cls)).a();
    }

    private static JsonAdapter b(Class<?> cls) {
        return (JsonAdapter) cls.getAnnotation(JsonAdapter.class);
    }

    private TypeAdapterFactory e(Class<?> cls, TypeAdapterFactory typeAdapterFactory) {
        TypeAdapterFactory putIfAbsent = this.f31007c.putIfAbsent(cls, typeAdapterFactory);
        return putIfAbsent != null ? putIfAbsent : typeAdapterFactory;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.google.gson.TypeAdapter<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.google.gson.TypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.TypeAdapter<?> c(com.google.gson.internal.ConstructorConstructor r8, com.google.gson.Gson r9, com.google.gson.reflect.TypeToken<?> r10, com.google.gson.annotations.JsonAdapter r11, boolean r12) {
        /*
            r7 = this;
            java.lang.Class r0 = r11.value()
            java.lang.Object r8 = a(r8, r0)
            boolean r6 = r11.nullSafe()
            boolean r11 = r8 instanceof com.google.gson.TypeAdapter
            if (r11 == 0) goto L_0x0014
            com.google.gson.TypeAdapter r8 = (com.google.gson.TypeAdapter) r8
            goto L_0x0085
        L_0x0014:
            boolean r11 = r8 instanceof com.google.gson.TypeAdapterFactory
            if (r11 == 0) goto L_0x0029
            com.google.gson.TypeAdapterFactory r8 = (com.google.gson.TypeAdapterFactory) r8
            if (r12 == 0) goto L_0x0024
            java.lang.Class r11 = r10.c()
            com.google.gson.TypeAdapterFactory r8 = r7.e(r11, r8)
        L_0x0024:
            com.google.gson.TypeAdapter r8 = r8.create(r9, r10)
            goto L_0x0085
        L_0x0029:
            boolean r11 = r8 instanceof com.google.gson.JsonSerializer
            if (r11 != 0) goto L_0x0062
            boolean r0 = r8 instanceof com.google.gson.JsonDeserializer
            if (r0 == 0) goto L_0x0032
            goto L_0x0062
        L_0x0032:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Invalid attempt to bind an instance of "
            r11.append(r12)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r11.append(r8)
            java.lang.String r8 = " as a @JsonAdapter for "
            r11.append(r8)
            java.lang.String r8 = r10.toString()
            r11.append(r8)
            java.lang.String r8 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.<init>(r8)
            throw r9
        L_0x0062:
            r0 = 0
            if (r11 == 0) goto L_0x006a
            r11 = r8
            com.google.gson.JsonSerializer r11 = (com.google.gson.JsonSerializer) r11
            r1 = r11
            goto L_0x006b
        L_0x006a:
            r1 = r0
        L_0x006b:
            boolean r11 = r8 instanceof com.google.gson.JsonDeserializer
            if (r11 == 0) goto L_0x0073
            com.google.gson.JsonDeserializer r8 = (com.google.gson.JsonDeserializer) r8
            r2 = r8
            goto L_0x0074
        L_0x0073:
            r2 = r0
        L_0x0074:
            if (r12 == 0) goto L_0x0079
            com.google.gson.TypeAdapterFactory r8 = f31004d
            goto L_0x007b
        L_0x0079:
            com.google.gson.TypeAdapterFactory r8 = f31005e
        L_0x007b:
            r5 = r8
            com.google.gson.internal.bind.TreeTypeAdapter r8 = new com.google.gson.internal.bind.TreeTypeAdapter
            r0 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
        L_0x0085:
            if (r8 == 0) goto L_0x008d
            if (r6 == 0) goto L_0x008d
            com.google.gson.TypeAdapter r8 = r8.nullSafe()
        L_0x008d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.c(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken, com.google.gson.annotations.JsonAdapter, boolean):com.google.gson.TypeAdapter");
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter b2 = b(typeToken.c());
        if (b2 == null) {
            return null;
        }
        return c(this.f31006b, gson, typeToken, b2, true);
    }

    public boolean d(TypeToken<?> typeToken, TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeToken);
        Objects.requireNonNull(typeAdapterFactory);
        if (typeAdapterFactory == f31004d) {
            return true;
        }
        Class<? super Object> c2 = typeToken.c();
        TypeAdapterFactory typeAdapterFactory2 = this.f31007c.get(c2);
        if (typeAdapterFactory2 == null) {
            JsonAdapter b2 = b(c2);
            if (b2 == null) {
                return false;
            }
            Class<?> value = b2.value();
            if (TypeAdapterFactory.class.isAssignableFrom(value) && e(c2, (TypeAdapterFactory) a(this.f31006b, value)) == typeAdapterFactory) {
                return true;
            }
            return false;
        } else if (typeAdapterFactory2 == typeAdapterFactory) {
            return true;
        } else {
            return false;
        }
    }
}
