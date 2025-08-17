package io.reactivex.internal.schedulers;

import androidx.media3.exoplayer.mediacodec.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40014a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f40015b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f40016c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f40017d = new ConcurrentHashMap();

    static final class PurgeProperties {

        /* renamed from: a  reason: collision with root package name */
        boolean f40018a;

        /* renamed from: b  reason: collision with root package name */
        int f40019b;

        PurgeProperties() {
        }

        /* access modifiers changed from: package-private */
        public void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f40018a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f40018a = true;
            }
            if (!this.f40018a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f40019b = 1;
                return;
            }
            try {
                this.f40019b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f40019b = 1;
            }
        }
    }

    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        public void run() {
            Iterator it2 = new ArrayList(SchedulerPoolFactory.f40017d.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f40017d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        PurgeProperties purgeProperties = new PurgeProperties();
        purgeProperties.a(properties);
        f40014a = purgeProperties.f40018a;
        f40015b = purgeProperties.f40019b;
        b();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(f40014a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void b() {
        d(f40014a);
    }

    static void c(boolean z2, ScheduledExecutorService scheduledExecutorService) {
        if (z2 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f40017d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void d(boolean z2) {
        if (z2) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f40016c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (f.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                        ScheduledTask scheduledTask = new ScheduledTask();
                        int i2 = f40015b;
                        newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
