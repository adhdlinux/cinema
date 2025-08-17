package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: b  reason: collision with root package name */
    private static final List<SystemMessage> f4702b = new ArrayList(50);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f4703a;

    private static final class SystemMessage implements HandlerWrapper.Message {

        /* renamed from: a  reason: collision with root package name */
        private Message f4704a;

        /* renamed from: b  reason: collision with root package name */
        private SystemHandlerWrapper f4705b;

        private SystemMessage() {
        }

        private void b() {
            this.f4704a = null;
            this.f4705b = null;
            SystemHandlerWrapper.n(this);
        }

        public void a() {
            ((Message) Assertions.f(this.f4704a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) Assertions.f(this.f4704a));
            b();
            return sendMessageAtFrontOfQueue;
        }

        public SystemMessage d(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.f4704a = message;
            this.f4705b = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f4703a = handler;
    }

    private static SystemMessage m() {
        SystemMessage systemMessage;
        List<SystemMessage> list = f4702b;
        synchronized (list) {
            if (list.isEmpty()) {
                systemMessage = new SystemMessage();
            } else {
                systemMessage = list.remove(list.size() - 1);
            }
        }
        return systemMessage;
    }

    /* access modifiers changed from: private */
    public static void n(SystemMessage systemMessage) {
        List<SystemMessage> list = f4702b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(systemMessage);
            }
        }
    }

    public HandlerWrapper.Message a(int i2) {
        return m().d(this.f4703a.obtainMessage(i2), this);
    }

    public boolean b(int i2) {
        boolean z2;
        if (i2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        return this.f4703a.hasMessages(i2);
    }

    public HandlerWrapper.Message c(int i2, Object obj) {
        return m().d(this.f4703a.obtainMessage(i2, obj), this);
    }

    public void d(Object obj) {
        this.f4703a.removeCallbacksAndMessages(obj);
    }

    public Looper e() {
        return this.f4703a.getLooper();
    }

    public HandlerWrapper.Message f(int i2, int i3, int i4) {
        return m().d(this.f4703a.obtainMessage(i2, i3, i4), this);
    }

    public boolean g(Runnable runnable) {
        return this.f4703a.post(runnable);
    }

    public boolean h(int i2) {
        return this.f4703a.sendEmptyMessage(i2);
    }

    public boolean i(int i2, long j2) {
        return this.f4703a.sendEmptyMessageAtTime(i2, j2);
    }

    public void j(int i2) {
        boolean z2;
        if (i2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f4703a.removeMessages(i2);
    }

    public boolean k(HandlerWrapper.Message message) {
        return ((SystemMessage) message).c(this.f4703a);
    }
}
