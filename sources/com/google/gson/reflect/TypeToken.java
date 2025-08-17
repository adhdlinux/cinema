package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;

public class TypeToken<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? super T> f31141a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f31142b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31143c;

    protected TypeToken() {
        Type e2 = e();
        this.f31142b = e2;
        this.f31141a = C$Gson$Types.k(e2);
        this.f31143c = e2.hashCode();
    }

    public static <T> TypeToken<T> a(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    public static TypeToken<?> b(Type type) {
        return new TypeToken<>(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Class<TypeToken> cls = TypeToken.class;
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                Type b2 = C$Gson$Types.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(b2);
                }
                return b2;
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + TroubleshootingGuide.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private static boolean f() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    private static void g(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + TroubleshootingGuide.a("typetoken-type-variable"));
        } else if (type instanceof GenericArrayType) {
            g(((GenericArrayType) type).getGenericComponentType());
        } else {
            int i2 = 0;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType != null) {
                    g(ownerType);
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                while (i2 < length) {
                    g(actualTypeArguments[i2]);
                    i2++;
                }
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                for (Type g2 : wildcardType.getLowerBounds()) {
                    g(g2);
                }
                Type[] upperBounds = wildcardType.getUpperBounds();
                int length2 = upperBounds.length;
                while (i2 < length2) {
                    g(upperBounds[i2]);
                    i2++;
                }
            } else if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
        }
    }

    public final Class<? super T> c() {
        return this.f31141a;
    }

    public final Type d() {
        return this.f31142b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.f(this.f31142b, ((TypeToken) obj).f31142b);
    }

    public final int hashCode() {
        return this.f31143c;
    }

    public final String toString() {
        return C$Gson$Types.u(this.f31142b);
    }

    private TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type b2 = C$Gson$Types.b(type);
        this.f31142b = b2;
        this.f31141a = C$Gson$Types.k(b2);
        this.f31143c = b2.hashCode();
    }
}
