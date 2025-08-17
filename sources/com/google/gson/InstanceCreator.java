package com.google.gson;

import java.lang.reflect.Type;

public interface InstanceCreator<T> {
    T a(Type type);
}
