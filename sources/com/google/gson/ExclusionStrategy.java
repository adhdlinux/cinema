package com.google.gson;

public interface ExclusionStrategy {
    boolean a(FieldAttributes fieldAttributes);

    boolean b(Class<?> cls);
}
