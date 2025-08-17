package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {

    /* renamed from: i  reason: collision with root package name */
    static final Object f2345i = new Object();

    /* renamed from: j  reason: collision with root package name */
    static final HashMap<ComponentName, WorkEnqueuer> f2346j = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    CompatJobEngine f2347b;

    /* renamed from: c  reason: collision with root package name */
    WorkEnqueuer f2348c;

    /* renamed from: d  reason: collision with root package name */
    CommandProcessor f2349d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2350e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f2351f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f2352g = false;

    /* renamed from: h  reason: collision with root package name */
    final ArrayList<CompatWorkItem> f2353h;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.g(a2.getIntent());
                a2.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.i();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.i();
        }
    }

    interface CompatJobEngine {
        IBinder a();

        GenericWorkItem b();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d  reason: collision with root package name */
        private final Context f2355d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f2356e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f2357f;

        /* renamed from: g  reason: collision with root package name */
        boolean f2358g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2359h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f2355d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2356e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2357f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2370a);
            if (this.f2355d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2358g) {
                        this.f2358g = true;
                        if (!this.f2359h) {
                            this.f2356e.acquire(60000);
                        }
                    }
                }
            }
        }

        public void c() {
            synchronized (this) {
                if (this.f2359h) {
                    if (this.f2358g) {
                        this.f2356e.acquire(60000);
                    }
                    this.f2359h = false;
                    this.f2357f.release();
                }
            }
        }

        public void d() {
            synchronized (this) {
                if (!this.f2359h) {
                    this.f2359h = true;
                    this.f2357f.acquire(600000);
                    this.f2356e.release();
                }
            }
        }

        public void e() {
            synchronized (this) {
                this.f2358g = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2360a;

        /* renamed from: b  reason: collision with root package name */
        final int f2361b;

        CompatWorkItem(Intent intent, int i2) {
            this.f2360a = intent;
            this.f2361b = i2;
        }

        public void a() {
            JobIntentService.this.stopSelf(this.f2361b);
        }

        public Intent getIntent() {
            return this.f2360a;
        }
    }

    interface GenericWorkItem {
        void a();

        Intent getIntent();
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f2363a;

        /* renamed from: b  reason: collision with root package name */
        final Object f2364b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f2365c;

        final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f2366a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f2366a = jobWorkItem;
            }

            public void a() {
                synchronized (JobServiceEngineImpl.this.f2364b) {
                    JobParameters jobParameters = JobServiceEngineImpl.this.f2365c;
                    if (jobParameters != null) {
                        m.a(jobParameters, this.f2366a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f2366a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2363a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            androidx.core.app.l.a(r1).setExtrasClassLoader(r3.f2363a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            return new androidx.core.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.GenericWorkItem b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f2364b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f2365c     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000a:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0024
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f2363a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem r0 = new androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
                r0.<init>(r1)
                return r0
            L_0x0024:
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.JobServiceEngineImpl.b():androidx.core.app.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f2365c = jobParameters;
            this.f2363a.e(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f2363a.b();
            synchronized (this.f2364b) {
                this.f2365c = null;
            }
            return b2;
        }
    }

    static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f2368d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f2369e;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i2) {
            super(componentName);
            b(i2);
            this.f2368d = new JobInfo.Builder(i2, this.f2370a).setOverrideDeadline(0).build();
            this.f2369e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            int unused = this.f2369e.enqueue(this.f2368d, new JobWorkItem(intent));
        }
    }

    static abstract class WorkEnqueuer {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2370a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2371b;

        /* renamed from: c  reason: collision with root package name */
        int f2372c;

        WorkEnqueuer(ComponentName componentName) {
            this.f2370a = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (!this.f2371b) {
                this.f2371b = true;
                this.f2372c = i2;
            } else if (this.f2372c != i2) {
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f2372c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2353h = null;
        } else {
            this.f2353h = new ArrayList<>();
        }
    }

    public static void c(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent != null) {
            synchronized (f2345i) {
                WorkEnqueuer f2 = f(context, componentName, true, i2);
                f2.b(i2);
                f2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void d(Context context, Class<?> cls, int i2, Intent intent) {
        c(context, new ComponentName(context, cls), i2, intent);
    }

    static WorkEnqueuer f(Context context, ComponentName componentName, boolean z2, int i2) {
        WorkEnqueuer workEnqueuer;
        HashMap<ComponentName, WorkEnqueuer> hashMap = f2346j;
        WorkEnqueuer workEnqueuer2 = hashMap.get(componentName);
        if (workEnqueuer2 != null) {
            return workEnqueuer2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            workEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else if (z2) {
            workEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        WorkEnqueuer workEnqueuer3 = workEnqueuer;
        hashMap.put(componentName, workEnqueuer3);
        return workEnqueuer3;
    }

    /* access modifiers changed from: package-private */
    public GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.f2347b;
        if (compatJobEngine != null) {
            return compatJobEngine.b();
        }
        synchronized (this.f2353h) {
            if (this.f2353h.size() <= 0) {
                return null;
            }
            GenericWorkItem remove = this.f2353h.remove(0);
            return remove;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        CommandProcessor commandProcessor = this.f2349d;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f2350e);
        }
        this.f2351f = true;
        return h();
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        if (this.f2349d == null) {
            this.f2349d = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f2348c;
            if (workEnqueuer != null && z2) {
                workEnqueuer.d();
            }
            this.f2349d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ArrayList<CompatWorkItem> arrayList = this.f2353h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2349d = null;
                ArrayList<CompatWorkItem> arrayList2 = this.f2353h;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f2352g) {
                    this.f2348c.c();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f2347b;
        if (compatJobEngine != null) {
            return compatJobEngine.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2347b = new JobServiceEngineImpl(this);
            this.f2348c = null;
            return;
        }
        this.f2347b = null;
        this.f2348c = f(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.f2353h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2352g = true;
                this.f2348c.c();
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.f2353h == null) {
            return 2;
        }
        this.f2348c.e();
        synchronized (this.f2353h) {
            ArrayList<CompatWorkItem> arrayList = this.f2353h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            e(true);
        }
        return 3;
    }
}
