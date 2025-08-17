package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Printer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class u8 extends Thread implements Handler.Callback, Printer {

    /* renamed from: a  reason: collision with root package name */
    public d f36651a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public e f36652b = new b(this);

    /* renamed from: c  reason: collision with root package name */
    public g f36653c = new c(this);

    /* renamed from: d  reason: collision with root package name */
    public f f36654d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f36655e = new Handler(Looper.getMainLooper(), this);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f36656f = new AtomicLong(0);

    /* renamed from: g  reason: collision with root package name */
    public final long f36657g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<String> f36658h = new AtomicReference<>("");

    /* renamed from: i  reason: collision with root package name */
    public final boolean f36659i;

    public class a implements d {
        public a(u8 u8Var) {
        }

        public void a() {
        }

        public boolean a(long j2, String str) {
            return false;
        }

        public void remove() {
        }
    }

    public class b implements e {
        public b(u8 u8Var) {
        }

        public long a(long j2) {
            return 0;
        }
    }

    public class c implements g {
        public c(u8 u8Var) {
        }
    }

    public interface d {
        void a();

        boolean a(long j2, String str);

        void remove();
    }

    public interface e {
        long a(long j2);
    }

    public interface f {
    }

    public interface g {
    }

    public u8(long j2, boolean z2) {
        super("startapp-anr");
        this.f36657g = j2;
        this.f36659i = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r12 = this;
            long r0 = r12.f36657g
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
        L_0x0006:
            boolean r6 = r12.isInterrupted()
            if (r6 != 0) goto L_0x008f
            java.util.concurrent.atomic.AtomicLong r6 = r12.f36656f
            long r6 = r6.getAndAdd(r0)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0036
            if (r4 == 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r5 = r12.f36658h
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = r12.a(r5)
            if (r5 != 0) goto L_0x002e
            com.startapp.u8$d r4 = r12.f36651a
            r4.remove()
            r4 = 0
        L_0x002e:
            android.os.Handler r5 = r12.f36655e
            r6 = 101(0x65, float:1.42E-43)
            r5.sendEmptyMessage(r6)
            r5 = 1
        L_0x0036:
            monitor-enter(r12)     // Catch:{ InterruptedException -> 0x0042, all -> 0x0040 }
            r12.wait(r0)     // Catch:{ all -> 0x003d }
            monitor-exit(r12)     // Catch:{ all -> 0x003d }
            r6 = 0
            goto L_0x004a
        L_0x003d:
            r6 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x003d }
            throw r6     // Catch:{ InterruptedException -> 0x0042, all -> 0x0040 }
        L_0x0040:
            goto L_0x0049
        L_0x0042:
            com.startapp.u8$g r6 = r12.f36653c
            com.startapp.u8$c r6 = (com.startapp.u8.c) r6
            r6.getClass()
        L_0x0049:
            r6 = 1
        L_0x004a:
            if (r6 == 0) goto L_0x004d
            return
        L_0x004d:
            java.util.concurrent.atomic.AtomicLong r6 = r12.f36656f
            long r6 = r6.get()
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r10 = r12.f36658h
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0006
            if (r4 != 0) goto L_0x0006
            if (r5 != 0) goto L_0x0069
            boolean r11 = r12.a(r10)
            if (r11 == 0) goto L_0x0006
        L_0x0069:
            boolean r11 = android.os.Debug.isDebuggerConnected()
            if (r11 != 0) goto L_0x008c
            boolean r11 = android.os.Debug.waitingForDebugger()
            if (r11 == 0) goto L_0x0076
            goto L_0x008c
        L_0x0076:
            com.startapp.u8$e r0 = r12.f36652b
            long r0 = r0.a(r6)
            int r11 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0082
            r5 = 0
            goto L_0x0006
        L_0x0082:
            com.startapp.u8$d r0 = r12.f36651a
            boolean r4 = r0.a(r6, r10)
            long r0 = r12.f36657g
            goto L_0x0006
        L_0x008c:
            r4 = 1
            goto L_0x0006
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.u8.a():void");
    }

    public boolean handleMessage(Message message) {
        this.f36656f.set(0);
        return true;
    }

    public void println(String str) {
        if (str.startsWith(">>>>>")) {
            this.f36658h.set(str);
        } else if (str.startsWith("<<<<<")) {
            this.f36658h.set("");
            this.f36656f.set(0);
        }
    }

    public void run() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }

    public void start() {
        this.f36651a.a();
        this.f36651a.remove();
        if (this.f36659i) {
            Looper.getMainLooper().setMessageLogging(this);
        }
        super.start();
    }

    public final boolean a(String str) {
        boolean z2 = !this.f36659i || !TextUtils.isEmpty(str);
        f fVar = this.f36654d;
        boolean z3 = fVar == null || (lb.e(((rc) fVar).f35794a.f36495b) ^ true);
        if (!z2 || !z3) {
            return false;
        }
        return true;
    }
}
