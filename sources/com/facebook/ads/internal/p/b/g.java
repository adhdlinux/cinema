package com.facebook.ads.internal.p.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.p.b.a.b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f20515a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final String f20516b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f20517c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f20518d;

    /* renamed from: e  reason: collision with root package name */
    private final b f20519e;

    /* renamed from: f  reason: collision with root package name */
    private final c f20520f;

    private static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f20521a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f20522b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f20521a = str;
            this.f20522b = list;
        }

        public void a(File file, String str, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (b a2 : this.f20522b) {
                a2.a((File) message.obj, this.f20521a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f20518d = copyOnWriteArrayList;
        this.f20516b = (String) j.a(str);
        this.f20520f = (c) j.a(cVar);
        this.f20519e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void c() {
        this.f20517c = this.f20517c == null ? e() : this.f20517c;
    }

    private synchronized void d() {
        if (this.f20515a.decrementAndGet() <= 0) {
            this.f20517c.a();
            this.f20517c = null;
        }
    }

    private e e() {
        e eVar = new e(new h(this.f20516b), new b(this.f20520f.a(this.f20516b), this.f20520f.f20488c));
        eVar.a(this.f20519e);
        return eVar;
    }

    public void a() {
        this.f20518d.clear();
        if (this.f20517c != null) {
            this.f20517c.a((b) null);
            this.f20517c.a();
            this.f20517c = null;
        }
        this.f20515a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f20515a.incrementAndGet();
            this.f20517c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f20515a.get();
    }
}
