package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;

public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void p(T t2);
    }

    long b();

    boolean c();

    long e();

    void f(long j2);

    boolean g(LoadingInfo loadingInfo);
}
