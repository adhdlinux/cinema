package com.startapp.common.parser;

public interface TypeParser<T> {
    T parse(Class<T> cls, Object obj);
}
