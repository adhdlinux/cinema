package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {

    /* renamed from: d  reason: collision with root package name */
    private static final String f12411d = Logger.f("SystemJobService");

    /* renamed from: b  reason: collision with root package name */
    private WorkManagerImpl f12412b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, JobParameters> f12413c = new HashMap();

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void e(String str, boolean z2) {
        JobParameters remove;
        Logger.c().a(f12411d, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.f12413c) {
            remove = this.f12413c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z2);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl k2 = WorkManagerImpl.k(getApplicationContext());
            this.f12412b = k2;
            k2.m().c(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.c().h(f12411d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f12412b;
        if (workManagerImpl != null) {
            workManagerImpl.m().i(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (r2 < 24) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r3 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        if (t.j.a(r9) == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        r3.f12240b = java.util.Arrays.asList(t.j.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        if (t.k.a(r9) == null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        r3.f12239a = java.util.Arrays.asList(t.k.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r2 < 28) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r3.f12241c = t.l.a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        r8.f12412b.v(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.WorkManagerImpl r0 = r8.f12412b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            androidx.work.Logger r0 = androidx.work.Logger.c()
            java.lang.String r3 = f12411d
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.a(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = a(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            androidx.work.Logger r9 = androidx.work.Logger.c()
            java.lang.String r0 = f12411d
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.b(r0, r1, r3)
            return r2
        L_0x002f:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.f12413c
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.f12413c     // Catch:{ all -> 0x00a9 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00a9 }
            if (r4 == 0) goto L_0x0051
            androidx.work.Logger r9 = androidx.work.Logger.c()     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = f12411d     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a9 }
            r1[r2] = r0     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00a9 }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a9 }
            r9.a(r4, r0, r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            return r2
        L_0x0051:
            androidx.work.Logger r4 = androidx.work.Logger.c()     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = f12411d     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a9 }
            r7[r2] = r0     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00a9 }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a9 }
            r4.a(r5, r6, r2)     // Catch:{ all -> 0x00a9 }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.f12413c     // Catch:{ all -> 0x00a9 }
            r2.put(r0, r9)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x00a2
            androidx.work.WorkerParameters$RuntimeExtras r3 = new androidx.work.WorkerParameters$RuntimeExtras
            r3.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L_0x0087
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f12240b = r4
        L_0x0087:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x0097
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f12239a = r4
        L_0x0097:
            r4 = 28
            if (r2 < r4) goto L_0x00a3
            android.net.Network r9 = r9.getNetwork()
            r3.f12241c = r9
            goto L_0x00a3
        L_0x00a2:
            r3 = 0
        L_0x00a3:
            androidx.work.impl.WorkManagerImpl r9 = r8.f12412b
            r9.v(r0, r3)
            return r1
        L_0x00a9:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f12412b == null) {
            Logger.c().a(f12411d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a2 = a(jobParameters);
        if (TextUtils.isEmpty(a2)) {
            Logger.c().b(f12411d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.c().a(f12411d, String.format("onStopJob for %s", new Object[]{a2}), new Throwable[0]);
        synchronized (this.f12413c) {
            this.f12413c.remove(a2);
        }
        this.f12412b.x(a2);
        return !this.f12412b.m().f(a2);
    }
}
