package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public enum ArrayListSupplier implements Callable<List<Object>>, Function<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> b() {
        return INSTANCE;
    }

    public static <T, O> Function<O, List<T>> c() {
        return INSTANCE;
    }

    /* renamed from: a */
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    /* renamed from: d */
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
