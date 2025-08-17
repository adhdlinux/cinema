package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: h  reason: collision with root package name */
    public static final Excluder f30940h = new Excluder();

    /* renamed from: b  reason: collision with root package name */
    private double f30941b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private int f30942c = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30943d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30944e;

    /* renamed from: f  reason: collision with root package name */
    private List<ExclusionStrategy> f30945f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<ExclusionStrategy> f30946g = Collections.emptyList();

    private static boolean d(Class<?> cls) {
        return cls.isMemberClass() && !ReflectionHelper.n(cls);
    }

    private boolean e(Since since) {
        if (since == null) {
            return true;
        }
        if (this.f30941b >= since.value()) {
            return true;
        }
        return false;
    }

    private boolean f(Until until) {
        if (until == null) {
            return true;
        }
        if (this.f30941b < until.value()) {
            return true;
        }
        return false;
    }

    private boolean g(Since since, Until until) {
        return e(since) && f(until);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean b(Class<?> cls, boolean z2) {
        List<ExclusionStrategy> list;
        if (this.f30941b != -1.0d && !g((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.f30943d && d(cls)) {
            return true;
        }
        if (!z2 && !Enum.class.isAssignableFrom(cls) && ReflectionHelper.l(cls)) {
            return true;
        }
        if (z2) {
            list = this.f30945f;
        } else {
            list = this.f30946g;
        }
        for (ExclusionStrategy b2 : list) {
            if (b2.b(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean c(Field field, boolean z2) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.f30942c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f30941b != -1.0d && !g((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.f30944e && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z2 ? !expose.deserialize() : !expose.serialize()))) || b(field.getType(), z2)) {
            return true;
        }
        if (z2) {
            list = this.f30945f;
        } else {
            list = this.f30946g;
        }
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        for (ExclusionStrategy a2 : list) {
            if (a2.a(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> c2 = typeToken.c();
        final boolean b2 = b(c2, true);
        final boolean b3 = b(c2, false);
        if (!b2 && !b3) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {

            /* renamed from: a  reason: collision with root package name */
            private volatile TypeAdapter<T> f30947a;

            private TypeAdapter<T> a() {
                TypeAdapter<T> typeAdapter = this.f30947a;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> p2 = gson2.p(Excluder.this, typeToken2);
                this.f30947a = p2;
                return p2;
            }

            public T read(JsonReader jsonReader) throws IOException {
                if (!b3) {
                    return a().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t2) throws IOException {
                if (b2) {
                    jsonWriter.nullValue();
                } else {
                    a().write(jsonWriter, t2);
                }
            }
        };
    }
}
