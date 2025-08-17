package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Processor implements ExecutionListener, ForegroundProcessor {

    /* renamed from: m  reason: collision with root package name */
    private static final String f12245m = Logger.f("Processor");

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f12246b;

    /* renamed from: c  reason: collision with root package name */
    private Context f12247c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f12248d;

    /* renamed from: e  reason: collision with root package name */
    private TaskExecutor f12249e;

    /* renamed from: f  reason: collision with root package name */
    private WorkDatabase f12250f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, WorkerWrapper> f12251g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, WorkerWrapper> f12252h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private List<Scheduler> f12253i;

    /* renamed from: j  reason: collision with root package name */
    private Set<String> f12254j;

    /* renamed from: k  reason: collision with root package name */
    private final List<ExecutionListener> f12255k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f12256l;

    private static class FutureListener implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private ExecutionListener f12257b;

        /* renamed from: c  reason: collision with root package name */
        private String f12258c;

        /* renamed from: d  reason: collision with root package name */
        private ListenableFuture<Boolean> f12259d;

        FutureListener(ExecutionListener executionListener, String str, ListenableFuture<Boolean> listenableFuture) {
            this.f12257b = executionListener;
            this.f12258c = str;
            this.f12259d = listenableFuture;
        }

        public void run() {
            boolean z2;
            try {
                z2 = this.f12259d.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z2 = true;
            }
            this.f12257b.e(this.f12258c, z2);
        }
    }

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.f12247c = context;
        this.f12248d = configuration;
        this.f12249e = taskExecutor;
        this.f12250f = workDatabase;
        this.f12253i = list;
        this.f12254j = new HashSet();
        this.f12255k = new ArrayList();
        this.f12246b = null;
        this.f12256l = new Object();
    }

    private static boolean d(String str, WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.d();
            Logger.c().a(f12245m, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        Logger.c().a(f12245m, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    private void m() {
        synchronized (this.f12256l) {
            if (!(!this.f12251g.isEmpty())) {
                try {
                    this.f12247c.startService(SystemForegroundDispatcher.d(this.f12247c));
                } catch (Throwable th) {
                    Logger.c().b(f12245m, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f12246b;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f12246b = null;
                }
            }
        }
    }

    public void a(String str) {
        synchronized (this.f12256l) {
            this.f12251g.remove(str);
            m();
        }
    }

    public void b(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.f12256l) {
            Logger.c().d(f12245m, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
            WorkerWrapper remove = this.f12252h.remove(str);
            if (remove != null) {
                if (this.f12246b == null) {
                    PowerManager.WakeLock b2 = WakeLocks.b(this.f12247c, "ProcessorForegroundLck");
                    this.f12246b = b2;
                    b2.acquire();
                }
                this.f12251g.put(str, remove);
                ContextCompat.startForegroundService(this.f12247c, SystemForegroundDispatcher.c(this.f12247c, str, foregroundInfo));
            }
        }
    }

    public void c(ExecutionListener executionListener) {
        synchronized (this.f12256l) {
            this.f12255k.add(executionListener);
        }
    }

    public void e(String str, boolean z2) {
        synchronized (this.f12256l) {
            this.f12252h.remove(str);
            Logger.c().a(f12245m, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z2)}), new Throwable[0]);
            for (ExecutionListener e2 : this.f12255k) {
                e2.e(str, z2);
            }
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f12256l) {
            contains = this.f12254j.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z2;
        synchronized (this.f12256l) {
            if (!this.f12252h.containsKey(str)) {
                if (!this.f12251g.containsKey(str)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f12256l) {
            containsKey = this.f12251g.containsKey(str);
        }
        return containsKey;
    }

    public void i(ExecutionListener executionListener) {
        synchronized (this.f12256l) {
            this.f12255k.remove(executionListener);
        }
    }

    public boolean j(String str) {
        return k(str, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean k(String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.f12256l) {
            if (g(str)) {
                Logger.c().a(f12245m, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            WorkerWrapper a2 = new WorkerWrapper.Builder(this.f12247c, this.f12248d, this.f12249e, this, this.f12250f, str).c(this.f12253i).b(runtimeExtras).a();
            ListenableFuture<Boolean> b2 = a2.b();
            b2.addListener(new FutureListener(this, str, b2), this.f12249e.a());
            this.f12252h.put(str, a2);
            this.f12249e.getBackgroundExecutor().execute(a2);
            Logger.c().a(f12245m, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean d2;
        synchronized (this.f12256l) {
            boolean z2 = true;
            Logger.c().a(f12245m, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.f12254j.add(str);
            WorkerWrapper remove = this.f12251g.remove(str);
            if (remove == null) {
                z2 = false;
            }
            if (remove == null) {
                remove = this.f12252h.remove(str);
            }
            d2 = d(str, remove);
            if (z2) {
                m();
            }
        }
        return d2;
    }

    public boolean n(String str) {
        boolean d2;
        synchronized (this.f12256l) {
            Logger.c().a(f12245m, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            d2 = d(str, this.f12251g.remove(str));
        }
        return d2;
    }

    public boolean o(String str) {
        boolean d2;
        synchronized (this.f12256l) {
            Logger.c().a(f12245m, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            d2 = d(str, this.f12252h.remove(str));
        }
        return d2;
    }
}
