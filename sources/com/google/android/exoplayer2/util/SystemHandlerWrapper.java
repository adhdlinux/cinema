package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: b  reason: collision with root package name */
    private static final List<SystemMessage> f28796b = new ArrayList(50);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f28797a;

    private static final class SystemMessage implements HandlerWrapper.Message {

        /* renamed from: a  reason: collision with root package name */
        private Message f28798a;

        /* renamed from: b  reason: collision with root package name */
        private SystemHandlerWrapper f28799b;

        private SystemMessage() {
        }

        private void b() {
            this.f28798a = null;
            this.f28799b = null;
            SystemHandlerWrapper.o(this);
        }

        public void a() {
            ((Message) Assertions.e(this.f28798a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) Assertions.e(this.f28798a));
            b();
            return sendMessageAtFrontOfQueue;
        }

        public SystemMessage d(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.f28798a = message;
            this.f28799b = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f28797a = handler;
    }

    private static SystemMessage n() {
        SystemMessage systemMessage;
        List<SystemMessage> list = f28796b;
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
    public static void o(SystemMessage systemMessage) {
        List<SystemMessage> list = f28796b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(systemMessage);
            }
        }
    }

    public HandlerWrapper.Message a(int i2) {
        return n().d(this.f28797a.obtainMessage(i2), this);
    }

    public boolean b(int i2) {
        return this.f28797a.hasMessages(i2);
    }

    public HandlerWrapper.Message c(int i2, Object obj) {
        return n().d(this.f28797a.obtainMessage(i2, obj), this);
    }

    public void d(Object obj) {
        this.f28797a.removeCallbacksAndMessages(obj);
    }

    public Looper e() {
        return this.f28797a.getLooper();
    }

    public HandlerWrapper.Message f(int i2, int i3, int i4) {
        return n().d(this.f28797a.obtainMessage(i2, i3, i4), this);
    }

    public boolean g(Runnable runnable) {
        return this.f28797a.post(runnable);
    }

    public boolean h(int i2) {
        return this.f28797a.sendEmptyMessage(i2);
    }

    public boolean i(int i2, long j2) {
        return this.f28797a.sendEmptyMessageAtTime(i2, j2);
    }

    public void j(int i2) {
        this.f28797a.removeMessages(i2);
    }

    public boolean k(HandlerWrapper.Message message) {
        return ((SystemMessage) message).c(this.f28797a);
    }

    public HandlerWrapper.Message l(int i2, int i3, int i4, Object obj) {
        return n().d(this.f28797a.obtainMessage(i2, i3, i4, obj), this);
    }
}
