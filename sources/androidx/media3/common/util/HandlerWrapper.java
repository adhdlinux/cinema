package androidx.media3.common.util;

import android.os.Looper;

public interface HandlerWrapper {

    public interface Message {
        void a();
    }

    Message a(int i2);

    boolean b(int i2);

    Message c(int i2, Object obj);

    void d(Object obj);

    Looper e();

    Message f(int i2, int i3, int i4);

    boolean g(Runnable runnable);

    boolean h(int i2);

    boolean i(int i2, long j2);

    void j(int i2);

    boolean k(Message message);
}
