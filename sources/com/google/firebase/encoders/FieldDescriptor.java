package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f30773a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Object> f30774b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f30775a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Class<?>, Object> f30776b = null;

        Builder(String str) {
            this.f30775a = str;
        }

        public FieldDescriptor a() {
            Map map;
            String str = this.f30775a;
            if (this.f30776b == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(new HashMap(this.f30776b));
            }
            return new FieldDescriptor(str, map);
        }

        public <T extends Annotation> Builder b(T t2) {
            if (this.f30776b == null) {
                this.f30776b = new HashMap();
            }
            this.f30776b.put(t2.annotationType(), t2);
            return this;
        }
    }

    public static Builder a(String str) {
        return new Builder(str);
    }

    public static FieldDescriptor d(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public String b() {
        return this.f30773a;
    }

    public <T extends Annotation> T c(Class<T> cls) {
        return (Annotation) this.f30774b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.f30773a.equals(fieldDescriptor.f30773a) || !this.f30774b.equals(fieldDescriptor.f30774b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f30773a.hashCode() * 31) + this.f30774b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f30773a + ", properties=" + this.f30774b.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f30773a = str;
        this.f30774b = map;
    }
}
