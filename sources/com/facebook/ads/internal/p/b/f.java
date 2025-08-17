package com.facebook.ads.internal.p.b;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.p.b.a.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20497a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f20498b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, g> f20499c;

    /* renamed from: d  reason: collision with root package name */
    private final ServerSocket f20500d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20501e;

    /* renamed from: f  reason: collision with root package name */
    private final Thread f20502f;

    /* renamed from: g  reason: collision with root package name */
    private final c f20503g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20504h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private File f20505a;

        /* renamed from: b  reason: collision with root package name */
        private com.facebook.ads.internal.p.b.a.c f20506b = new com.facebook.ads.internal.p.b.a.f();

        /* renamed from: c  reason: collision with root package name */
        private com.facebook.ads.internal.p.b.a.a f20507c = new g(67108864);

        public a(Context context) {
            this.f20505a = o.a(context);
        }

        /* access modifiers changed from: private */
        public c a() {
            return new c(this.f20505a, this.f20506b, this.f20507c);
        }
    }

    private class b implements Callable<Boolean> {
        private b() {
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(f.this.c());
        }
    }

    private class c implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final String f20510b;

        public c(String str) {
            this.f20510b = str;
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(f.this.c(this.f20510b));
        }
    }

    private final class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Socket f20512b;

        public d(Socket socket) {
            this.f20512b = socket;
        }

        public void run() {
            f.this.a(this.f20512b);
        }
    }

    private final class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CountDownLatch f20514b;

        public e(CountDownLatch countDownLatch) {
            this.f20514b = countDownLatch;
        }

        public void run() {
            this.f20514b.countDown();
            f.this.e();
        }
    }

    public f(Context context) {
        this(new a(context).a());
    }

    private f(c cVar) {
        this.f20497a = new Object();
        this.f20498b = Executors.newFixedThreadPool(8);
        this.f20499c = new ConcurrentHashMap();
        this.f20503g = (c) j.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f20500d = serverSocket;
            this.f20501e = serverSocket.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new e(countDownLatch));
            this.f20502f = thread;
            thread.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            b();
        } catch (IOException | InterruptedException e2) {
            this.f20498b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    private void a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    /* access modifiers changed from: private */
    public void a(Socket socket) {
        StringBuilder sb;
        try {
            d a2 = d.a(socket.getInputStream());
            Log.i("ProxyCache", "Request to cache proxy:" + a2);
            String c2 = m.c(a2.f20491a);
            if ("ping".equals(c2)) {
                b(socket);
            } else {
                e(c2).a(a2, socket);
            }
            c(socket);
            sb = new StringBuilder();
        } catch (SocketException unused) {
            Log.d("ProxyCache", "Closing socket... Socket is closed by client.");
            c(socket);
            sb = new StringBuilder();
        } catch (l | IOException e2) {
            a((Throwable) new l("Error processing request", e2));
            c(socket);
            sb = new StringBuilder();
        } catch (Throwable th) {
            c(socket);
            Log.d("ProxyCache", "Opened connections: " + f());
            throw th;
        }
        sb.append("Opened connections: ");
        sb.append(f());
        Log.d("ProxyCache", sb.toString());
    }

    private void b() {
        int i2 = 300;
        int i3 = 0;
        while (i3 < 3) {
            try {
                long j2 = (long) i2;
                boolean booleanValue = ((Boolean) this.f20498b.submit(new b()).get(j2, TimeUnit.MILLISECONDS)).booleanValue();
                this.f20504h = booleanValue;
                if (!booleanValue) {
                    SystemClock.sleep(j2);
                    i3++;
                    i2 *= 2;
                } else {
                    return;
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.e("ProxyCache", "Error pinging server [attempt: " + i3 + ", timeout: " + i2 + "]. ", e2);
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error pinging server [attempts: " + i3 + ", max timeout: " + (i2 / 2) + "].");
        a();
    }

    private void b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private void c(Socket socket) {
        d(socket);
        e(socket);
        f(socket);
    }

    /* access modifiers changed from: private */
    public boolean c() {
        h hVar = new h(d("ping"));
        try {
            byte[] bytes = "ping ok".getBytes();
            hVar.a(0);
            byte[] bArr = new byte[bytes.length];
            hVar.a(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            Log.d("ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (l e2) {
            Log.e("ProxyCache", "Error reading ping response", e2);
            return false;
        } finally {
            hVar.b();
        }
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        h hVar = new h(d(str));
        try {
            hVar.a(0);
            do {
            } while (hVar.a(new byte[8192]) != -1);
            hVar.b();
            return true;
        } catch (l e2) {
            Log.e("ProxyCache", "Error reading url", e2);
            hVar.b();
            return false;
        } catch (Throwable th) {
            hVar.b();
            throw th;
        }
    }

    private String d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f20501e), m.b(str)});
    }

    private void d() {
        synchronized (this.f20497a) {
            for (g a2 : this.f20499c.values()) {
                a2.a();
            }
            this.f20499c.clear();
        }
    }

    private void d(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            Log.d("ProxyCache", "Releasing input stream... Socket is closed by client.");
        } catch (IOException e2) {
            a((Throwable) new l("Error closing socket input stream", e2));
        }
    }

    private g e(String str) {
        g gVar;
        synchronized (this.f20497a) {
            gVar = this.f20499c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.f20503g);
                this.f20499c.put(str, gVar);
            }
        }
        return gVar;
    }

    /* access modifiers changed from: private */
    public void e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f20500d.accept();
                Log.d("ProxyCache", "Accept new socket " + accept);
                this.f20498b.submit(new d(accept));
            } catch (IOException e2) {
                a((Throwable) new l("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e2) {
            a((Throwable) new l("Error closing socket output stream", e2));
        }
    }

    private int f() {
        int i2;
        synchronized (this.f20497a) {
            i2 = 0;
            for (g b2 : this.f20499c.values()) {
                i2 += b2.b();
            }
        }
        return i2;
    }

    private void f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e2) {
            a((Throwable) new l("Error closing socket", e2));
        }
    }

    public void a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        d();
        this.f20502f.interrupt();
        try {
            if (!this.f20500d.isClosed()) {
                this.f20500d.close();
            }
        } catch (IOException e2) {
            a((Throwable) new l("Error shutting down proxy server", e2));
        }
    }

    public boolean a(String str) {
        int i2 = 300;
        int i3 = 0;
        while (i3 < 3) {
            try {
                if (((Boolean) this.f20498b.submit(new c(str)).get()).booleanValue()) {
                    return true;
                }
                SystemClock.sleep((long) i2);
                i3++;
                i2 *= 2;
            } catch (InterruptedException | ExecutionException e2) {
                Log.e("ProxyCache", "Error precaching url [attempt: " + i3 + ", url: " + str + "]. ", e2);
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error precaching url [attempts: " + i3 + ", url: " + str + "].");
        a();
        return false;
    }

    public String b(String str) {
        if (!this.f20504h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f20504h ? d(str) : str;
    }
}
