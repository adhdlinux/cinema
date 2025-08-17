package kotlin.reflect;

import java.util.List;
import java.util.Map;

public interface KCallable<R> extends KAnnotatedElement {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    KType getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
