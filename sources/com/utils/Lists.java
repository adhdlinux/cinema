package com.utils;

import java.util.Collection;

public final class Lists {
    public static <E> boolean a(Collection<E> collection) {
        return collection == null || collection.size() == 0;
    }
}
