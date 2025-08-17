package com.google.android.exoplayer2.source;

public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void d(T t2);
    }

    long b();

    boolean c();

    long e();

    void f(long j2);

    boolean h(long j2);
}
