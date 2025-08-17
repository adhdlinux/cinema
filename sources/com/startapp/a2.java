package com.startapp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class a2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34181a = "a2";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object f34182b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public InetAddress f34183c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f34184a;

        public a(String str) {
            this.f34184a = str;
        }

        public void run() {
            try {
                InetAddress byName = InetAddress.getByName(this.f34184a);
                synchronized (a2.this.f34182b) {
                    InetAddress unused = a2.this.f34183c = byName;
                }
            } catch (Throwable th) {
                l2.a(th);
            }
        }
    }

    public String a(String str, int i2) throws UnknownHostException {
        String hostAddress;
        this.f34182b = new Object();
        Thread thread = new Thread(new a(str));
        thread.start();
        try {
            thread.join((long) i2);
        } catch (Throwable th) {
            l2.a(th);
        }
        synchronized (this.f34182b) {
            InetAddress inetAddress = this.f34183c;
            if (inetAddress != null) {
                hostAddress = inetAddress.getHostAddress();
            } else {
                throw new UnknownHostException();
            }
        }
        return hostAddress;
    }
}
