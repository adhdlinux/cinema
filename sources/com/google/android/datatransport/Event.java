package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> d(int i2, T t2) {
        return new AutoValue_Event(Integer.valueOf(i2), t2, Priority.DEFAULT);
    }

    public static <T> Event<T> e(int i2, T t2) {
        return new AutoValue_Event(Integer.valueOf(i2), t2, Priority.VERY_LOW);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
