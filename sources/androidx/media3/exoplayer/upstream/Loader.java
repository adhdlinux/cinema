package androidx.media3.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {

    /* renamed from: d  reason: collision with root package name */
    public static final LoadErrorAction f7532d = h(false, -9223372036854775807L);

    /* renamed from: e  reason: collision with root package name */
    public static final LoadErrorAction f7533e = h(true, -9223372036854775807L);

    /* renamed from: f  reason: collision with root package name */
    public static final LoadErrorAction f7534f = new LoadErrorAction(2, -9223372036854775807L);

    /* renamed from: g  reason: collision with root package name */
    public static final LoadErrorAction f7535g = new LoadErrorAction(3, -9223372036854775807L);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f7536a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LoadTask<? extends Loadable> f7537b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IOException f7538c;

    public interface Callback<T extends Loadable> {
        LoadErrorAction p(T t2, long j2, long j3, IOException iOException, int i2);

        void t(T t2, long j2, long j3);

        void u(T t2, long j2, long j3, boolean z2);
    }

    public static final class LoadErrorAction {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f7539a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f7540b;

        public boolean c() {
            int i2 = this.f7539a;
            return i2 == 0 || i2 == 1;
        }

        private LoadErrorAction(int i2, long j2) {
            this.f7539a = i2;
            this.f7540b = j2;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final int f7541b;

        /* renamed from: c  reason: collision with root package name */
        private final T f7542c;

        /* renamed from: d  reason: collision with root package name */
        private final long f7543d;

        /* renamed from: e  reason: collision with root package name */
        private Callback<T> f7544e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f7545f;

        /* renamed from: g  reason: collision with root package name */
        private int f7546g;

        /* renamed from: h  reason: collision with root package name */
        private Thread f7547h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f7548i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f7549j;

        public LoadTask(Looper looper, T t2, Callback<T> callback, int i2, long j2) {
            super(looper);
            this.f7542c = t2;
            this.f7544e = callback;
            this.f7541b = i2;
            this.f7543d = j2;
        }

        private void b() {
            this.f7545f = null;
            Loader.this.f7536a.execute((Runnable) Assertions.f(Loader.this.f7537b));
        }

        private void c() {
            LoadTask unused = Loader.this.f7537b = null;
        }

        private long d() {
            return (long) Math.min((this.f7546g - 1) * 1000, 5000);
        }

        public void a(boolean z2) {
            this.f7549j = z2;
            this.f7545f = null;
            if (hasMessages(1)) {
                this.f7548i = true;
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    this.f7548i = true;
                    this.f7542c.b();
                    Thread thread = this.f7547h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.f(this.f7544e)).u(this.f7542c, elapsedRealtime, elapsedRealtime - this.f7543d, true);
                this.f7544e = null;
            }
        }

        public void e(int i2) throws IOException {
            IOException iOException = this.f7545f;
            if (iOException != null && this.f7546g > i2) {
                throw iOException;
            }
        }

        public void f(long j2) {
            boolean z2;
            if (Loader.this.f7537b == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            LoadTask unused = Loader.this.f7537b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(1, j2);
            } else {
                b();
            }
        }

        public void handleMessage(Message message) {
            long j2;
            if (!this.f7549j) {
                int i2 = message.what;
                if (i2 == 1) {
                    b();
                } else if (i2 != 4) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = elapsedRealtime - this.f7543d;
                    Callback callback = (Callback) Assertions.f(this.f7544e);
                    if (this.f7548i) {
                        callback.u(this.f7542c, elapsedRealtime, j3, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 2) {
                        try {
                            callback.t(this.f7542c, elapsedRealtime, j3);
                        } catch (RuntimeException e2) {
                            Log.d("LoadTask", "Unexpected exception handling load completed", e2);
                            IOException unused = Loader.this.f7538c = new UnexpectedLoaderException(e2);
                        }
                    } else if (i3 == 3) {
                        IOException iOException = (IOException) message.obj;
                        this.f7545f = iOException;
                        int i4 = this.f7546g + 1;
                        this.f7546g = i4;
                        LoadErrorAction p2 = callback.p(this.f7542c, elapsedRealtime, j3, iOException, i4);
                        if (p2.f7539a == 3) {
                            IOException unused2 = Loader.this.f7538c = this.f7545f;
                        } else if (p2.f7539a != 2) {
                            if (p2.f7539a == 1) {
                                this.f7546g = 1;
                            }
                            if (p2.f7540b != -9223372036854775807L) {
                                j2 = p2.f7540b;
                            } else {
                                j2 = d();
                            }
                            f(j2);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    if (!this.f7548i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f7547h = Thread.currentThread();
                }
                if (z2) {
                    TraceUtil.a("load:" + this.f7542c.getClass().getSimpleName());
                    this.f7542c.a();
                    TraceUtil.b();
                }
                synchronized (this) {
                    this.f7547h = null;
                    Thread.interrupted();
                }
                if (!this.f7549j) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.f7549j) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (Exception e3) {
                if (!this.f7549j) {
                    Log.d("LoadTask", "Unexpected exception loading stream", e3);
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                if (!this.f7549j) {
                    Log.d("LoadTask", "OutOfMemory error loading stream", e4);
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                if (!this.f7549j) {
                    Log.d("LoadTask", "Unexpected error loading stream", e5);
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                TraceUtil.b();
                throw th;
            }
        }
    }

    public interface Loadable {
        void a() throws IOException;

        void b();
    }

    public interface ReleaseCallback {
        void k();
    }

    private static final class ReleaseTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ReleaseCallback f7551b;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.f7551b = releaseCallback;
        }

        public void run() {
            this.f7551b.k();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnexpectedLoaderException(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unexpected "
                r0.append(r1)
                java.lang.Class r1 = r4.getClass()
                java.lang.String r1 = r1.getSimpleName()
                r0.append(r1)
                java.lang.String r1 = r4.getMessage()
                if (r1 == 0) goto L_0x0031
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ": "
                r1.append(r2)
                java.lang.String r2 = r4.getMessage()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                goto L_0x0033
            L_0x0031:
                java.lang.String r1 = ""
            L_0x0033:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r3.<init>(r0, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.Loader.UnexpectedLoaderException.<init>(java.lang.Throwable):void");
        }
    }

    public Loader(String str) {
        this.f7536a = Util.Q0("ExoPlayer:Loader:" + str);
    }

    public static LoadErrorAction h(boolean z2, long j2) {
        return new LoadErrorAction(z2 ? 1 : 0, j2);
    }

    public void a() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((LoadTask) Assertions.j(this.f7537b)).a(false);
    }

    public void g() {
        this.f7538c = null;
    }

    public boolean i() {
        return this.f7538c != null;
    }

    public boolean j() {
        return this.f7537b != null;
    }

    public void k(int i2) throws IOException {
        IOException iOException = this.f7538c;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.f7537b;
            if (loadTask != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = loadTask.f7541b;
                }
                loadTask.e(i2);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void l() {
        m((ReleaseCallback) null);
    }

    public void m(ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.f7537b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        if (releaseCallback != null) {
            this.f7536a.execute(new ReleaseTask(releaseCallback));
        }
        this.f7536a.shutdown();
    }

    public <T extends Loadable> long n(T t2, Callback<T> callback, int i2) {
        this.f7538c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask((Looper) Assertions.j(Looper.myLooper()), t2, callback, i2, elapsedRealtime).f(0);
        return elapsedRealtime;
    }
}
