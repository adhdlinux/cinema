package com.google.gson;

public interface ReflectionAccessFilter {

    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult a(Class<?> cls);
}
