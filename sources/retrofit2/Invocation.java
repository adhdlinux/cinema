package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Invocation {
    private final List<?> arguments;
    private final Object instance;
    private final Method method;
    private final Class<?> service;

    Invocation(Class<?> cls, Object obj, Method method2, List<?> list) {
        this.service = cls;
        this.instance = obj;
        this.method = method2;
        this.arguments = Collections.unmodifiableList(list);
    }

    public static <T> Invocation of(Class<T> cls, T t2, Method method2, List<?> list) {
        Objects.requireNonNull(cls, "service == null");
        Objects.requireNonNull(t2, "instance == null");
        Objects.requireNonNull(method2, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new Invocation(cls, t2, method2, new ArrayList(list));
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Object instance() {
        return this.instance;
    }

    public Method method() {
        return this.method;
    }

    public Class<?> service() {
        return this.service;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.service.getName(), this.method.getName(), this.arguments});
    }

    @Deprecated
    public static Invocation of(Method method2, List<?> list) {
        Objects.requireNonNull(method2, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new Invocation(method2.getDeclaringClass(), (Object) null, method2, new ArrayList(list));
    }
}
