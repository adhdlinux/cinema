package com.startapp;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class m2<V> implements Callable<V> {

    /* renamed from: a  reason: collision with root package name */
    private final Callable<V> f34894a;

    public m2(Callable<V> callable) {
        this.f34894a = callable;
    }

    public static <T> Collection<? extends Callable<T>> a(Collection<? extends Callable<T>> collection) {
        LinkedList linkedList = new LinkedList();
        for (Callable m2Var : collection) {
            linkedList.add(new m2(m2Var));
        }
        return linkedList;
    }

    public V call() {
        try {
            return this.f34894a.call();
        } catch (Throwable th) {
            l2.c(th);
            return null;
        }
    }
}
