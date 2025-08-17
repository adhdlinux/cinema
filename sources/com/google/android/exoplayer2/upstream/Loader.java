package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {

    /* renamed from: d  reason: collision with root package name */
    public static final LoadErrorAction f28462d = h(false, -9223372036854775807L);

    /* renamed from: e  reason: collision with root package name */
    public static final LoadErrorAction f28463e = h(true, -9223372036854775807L);

    /* renamed from: f  reason: collision with root package name */
    public static final LoadErrorAction f28464f = new LoadErrorAction(2, -9223372036854775807L);

    /* renamed from: g  reason: collision with root package name */
    public static final LoadErrorAction f28465g = new LoadErrorAction(3, -9223372036854775807L);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f28466a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LoadTask<? extends Loadable> f28467b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IOException f28468c;

    public interface Callback<T extends Loadable> {
        void p(T t2, long j2, long j3, boolean z2);

        void q(T t2, long j2, long j3);

        LoadErrorAction t(T t2, long j2, long j3, IOException iOException, int i2);
    }

    public static final class LoadErrorAction {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f28469a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f28470b;

        public boolean c() {
            int i2 = this.f28469a;
            return i2 == 0 || i2 == 1;
        }

        private LoadErrorAction(int i2, long j2) {
            this.f28469a = i2;
            this.f28470b = j2;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final int f28471b;

        /* renamed from: c  reason: collision with root package name */
        private final T f28472c;

        /* renamed from: d  reason: collision with root package name */
        private final long f28473d;

        /* renamed from: e  reason: collision with root package name */
        private Callback<T> f28474e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f28475f;

        /* renamed from: g  reason: collision with root package name */
        private int f28476g;

        /* renamed from: h  reason: collision with root package name */
        private Thread f28477h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f28478i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f28479j;

        public LoadTask(Looper looper, T t2, Callback<T> callback, int i2, long j2) {
            super(looper);
            this.f28472c = t2;
            this.f28474e = callback;
            this.f28471b = i2;
            this.f28473d = j2;
        }

        private void b() {
            this.f28475f = null;
            Loader.this.f28466a.execute((Runnable) Assertions.e(Loader.this.f28467b));
        }

        private void c() {
            LoadTask unused = Loader.this.f28467b = null;
        }

        private long d() {
            return (long) Math.min((this.f28476g - 1) * 1000, 5000);
        }

        public void a(boolean z2) {
            this.f28479j = z2;
            this.f28475f = null;
            if (hasMessages(0)) {
                this.f28478i = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f28478i = true;
                    this.f28472c.b();
                    Thread thread = this.f28477h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.e(this.f28474e)).p(this.f28472c, elapsedRealtime, elapsedRealtime - this.f28473d, true);
                this.f28474e = null;
            }
        }

        public void e(int i2) throws IOException {
            IOException iOException = this.f28475f;
            if (iOException != null && this.f28476g > i2) {
                throw iOException;
            }
        }

        public void f(long j2) {
            boolean z2;
            if (Loader.this.f28467b == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            LoadTask unused = Loader.this.f28467b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                b();
            }
        }

        public void handleMessage(Message message) {
            long j2;
            if (!this.f28479j) {
                int i2 = message.what;
                if (i2 == 0) {
                    b();
                } else if (i2 != 3) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = elapsedRealtime - this.f28473d;
                    Callback callback = (Callback) Assertions.e(this.f28474e);
                    if (this.f28478i) {
                        callback.p(this.f28472c, elapsedRealtime, j3, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 1) {
                        try {
                            callback.q(this.f28472c, elapsedRealtime, j3);
                        } catch (RuntimeException e2) {
                            Log.d("LoadTask", "Unexpected exception handling load completed", e2);
                            IOException unused = Loader.this.f28468c = new UnexpectedLoaderException(e2);
                        }
                    } else if (i3 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.f28475f = iOException;
                        int i4 = this.f28476g + 1;
                        this.f28476g = i4;
                        LoadErrorAction t2 = callback.t(this.f28472c, elapsedRealtime, j3, iOException, i4);
                        if (t2.f28469a == 3) {
                            IOException unused2 = Loader.this.f28468c = this.f28475f;
                        } else if (t2.f28469a != 2) {
                            if (t2.f28469a == 1) {
                                this.f28476g = 1;
                            }
                            if (t2.f28470b != -9223372036854775807L) {
                                j2 = t2.f28470b;
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
                    if (!this.f28478i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f28477h = Thread.currentThread();
                }
                if (z2) {
                    TraceUtil.a("load:" + this.f28472c.getClass().getSimpleName());
                    this.f28472c.a();
                    TraceUtil.c();
                }
                synchronized (this) {
                    this.f28477h = null;
                    Thread.interrupted();
                }
                if (!this.f28479j) {
                    sendEmptyMessage(1);
                }
            } catch (IOException e2) {
                if (!this.f28479j) {
                    obtainMessage(2, e2).sendToTarget();
                }
            } catch (Exception e3) {
                if (!this.f28479j) {
                    Log.d("LoadTask", "Unexpected exception loading stream", e3);
                    obtainMessage(2, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                if (!this.f28479j) {
                    Log.d("LoadTask", "OutOfMemory error loading stream", e4);
                    obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                if (!this.f28479j) {
                    Log.d("LoadTask", "Unexpected error loading stream", e5);
                    obtainMessage(3, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                TraceUtil.c();
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
        private final ReleaseCallback f28481b;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.f28481b = releaseCallback;
        }

        public void run() {
            this.f28481b.k();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.f28466a = Util.G0("ExoPlayer:Loader:" + str);
    }

    public static LoadErrorAction h(boolean z2, long j2) {
        return new LoadErrorAction(z2 ? 1 : 0, j2);
    }

    public void a() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((LoadTask) Assertions.i(this.f28467b)).a(false);
    }

    public void g() {
        this.f28468c = null;
    }

    public boolean i() {
        return this.f28468c != null;
    }

    public boolean j() {
        return this.f28467b != null;
    }

    public void k(int i2) throws IOException {
        IOException iOException = this.f28468c;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.f28467b;
            if (loadTask != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = loadTask.f28471b;
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
        LoadTask<? extends Loadable> loadTask = this.f28467b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        if (releaseCallback != null) {
            this.f28466a.execute(new ReleaseTask(releaseCallback));
        }
        this.f28466a.shutdown();
    }

    public <T extends Loadable> long n(T t2, Callback<T> callback, int i2) {
        this.f28468c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask((Looper) Assertions.i(Looper.myLooper()), t2, callback, i2, elapsedRealtime).f(0);
        return elapsedRealtime;
    }
}
