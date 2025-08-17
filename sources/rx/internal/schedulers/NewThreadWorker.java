package rx.internal.schedulers;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;

public class NewThreadWorker extends Scheduler.Worker {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f42082e = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");

    /* renamed from: f  reason: collision with root package name */
    public static final int f42083f = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* renamed from: g  reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f42084g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f42085h = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f42086b;

    /* renamed from: c  reason: collision with root package name */
    private final RxJavaSchedulersHook f42087c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f42088d;

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!d(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            c((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f42087c = RxJavaPlugins.b().e();
        this.f42086b = newScheduledThreadPool;
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        f42084g.remove(scheduledExecutorService);
    }

    static void b() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it2 = f42084g.keySet().iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor next = it2.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.b().a().a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.util.concurrent.ScheduledThreadPoolExecutor r10) {
        /*
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r0 = f42085h
            java.lang.Object r1 = r0.get()
            java.util.concurrent.ScheduledExecutorService r1 = (java.util.concurrent.ScheduledExecutorService) r1
            if (r1 == 0) goto L_0x000b
            goto L_0x002c
        L_0x000b:
            rx.internal.util.RxThreadFactory r1 = new rx.internal.util.RxThreadFactory
            java.lang.String r2 = "RxSchedulerPurge-"
            r1.<init>(r2)
            r2 = 1
            java.util.concurrent.ScheduledExecutorService r3 = java.util.concurrent.Executors.newScheduledThreadPool(r2, r1)
            r1 = 0
            boolean r0 = androidx.media3.exoplayer.mediacodec.f.a(r0, r1, r3)
            if (r0 == 0) goto L_0x0000
            rx.internal.schedulers.NewThreadWorker$1 r4 = new rx.internal.schedulers.NewThreadWorker$1
            r4.<init>()
            int r0 = f42083f
            long r5 = (long) r0
            long r7 = (long) r0
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3.scheduleAtFixedRate(r4, r5, r7, r9)
        L_0x002c:
            java.util.concurrent.ConcurrentHashMap<java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor> r0 = f42084g
            r0.putIfAbsent(r10, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.schedulers.NewThreadWorker.c(java.util.concurrent.ScheduledThreadPoolExecutor):void");
    }

    public static boolean d(ScheduledExecutorService scheduledExecutorService) {
        if (!f42082e) {
            for (Method method : scheduledExecutorService.getClass().getMethods()) {
                if (method.getName().equals("setRemoveOnCancelPolicy") && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == Boolean.TYPE) {
                    try {
                        method.invoke(scheduledExecutorService, new Object[]{Boolean.TRUE});
                        return true;
                    } catch (Exception e2) {
                        RxJavaPlugins.b().a().a(e2);
                    }
                }
            }
        }
        return false;
    }

    public boolean isUnsubscribed() {
        return this.f42088d;
    }

    public void unsubscribe() {
        this.f42088d = true;
        this.f42086b.shutdownNow();
        a(this.f42086b);
    }
}
