package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.R$bool;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WorkManagerImpl extends WorkManager {

    /* renamed from: j  reason: collision with root package name */
    private static final String f12292j = Logger.f("WorkManagerImpl");

    /* renamed from: k  reason: collision with root package name */
    private static WorkManagerImpl f12293k = null;

    /* renamed from: l  reason: collision with root package name */
    private static WorkManagerImpl f12294l = null;

    /* renamed from: m  reason: collision with root package name */
    private static final Object f12295m = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f12296a;

    /* renamed from: b  reason: collision with root package name */
    private Configuration f12297b;

    /* renamed from: c  reason: collision with root package name */
    private WorkDatabase f12298c;

    /* renamed from: d  reason: collision with root package name */
    private TaskExecutor f12299d;

    /* renamed from: e  reason: collision with root package name */
    private List<Scheduler> f12300e;

    /* renamed from: f  reason: collision with root package name */
    private Processor f12301f;

    /* renamed from: g  reason: collision with root package name */
    private PreferenceUtils f12302g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12303h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f12304i;

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(R$bool.f12200a));
    }

    public static void e(Context context, Configuration configuration) {
        synchronized (f12295m) {
            WorkManagerImpl workManagerImpl = f12293k;
            if (workManagerImpl != null) {
                if (f12294l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (workManagerImpl == null) {
                Context applicationContext = context.getApplicationContext();
                if (f12294l == null) {
                    f12294l = new WorkManagerImpl(applicationContext, configuration, new WorkManagerTaskExecutor(configuration.l()));
                }
                f12293k = f12294l;
            }
        }
    }

    @Deprecated
    public static WorkManagerImpl j() {
        synchronized (f12295m) {
            WorkManagerImpl workManagerImpl = f12293k;
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            WorkManagerImpl workManagerImpl2 = f12294l;
            return workManagerImpl2;
        }
    }

    public static WorkManagerImpl k(Context context) {
        WorkManagerImpl j2;
        synchronized (f12295m) {
            j2 = j();
            if (j2 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Configuration.Provider) {
                    e(applicationContext, ((Configuration.Provider) applicationContext).a());
                    j2 = k(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return j2;
    }

    private void q(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor) {
        Context applicationContext = context.getApplicationContext();
        this.f12296a = applicationContext;
        this.f12297b = configuration;
        this.f12299d = taskExecutor;
        this.f12298c = workDatabase;
        this.f12300e = list;
        this.f12301f = processor;
        this.f12302g = new PreferenceUtils(workDatabase);
        this.f12303h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext.isDeviceProtectedStorage()) {
            this.f12299d.b(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public Operation a(String str) {
        CancelWorkRunnable d2 = CancelWorkRunnable.d(str, this);
        this.f12299d.b(d2);
        return d2.e();
    }

    public Operation c(List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public Operation f(UUID uuid) {
        CancelWorkRunnable b2 = CancelWorkRunnable.b(uuid, this);
        this.f12299d.b(b2);
        return b2.e();
    }

    public List<Scheduler> g(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        return Arrays.asList(new Scheduler[]{Schedulers.a(context, this), new GreedyScheduler(context, configuration, taskExecutor, this)});
    }

    public Context h() {
        return this.f12296a;
    }

    public Configuration i() {
        return this.f12297b;
    }

    public PreferenceUtils l() {
        return this.f12302g;
    }

    public Processor m() {
        return this.f12301f;
    }

    public List<Scheduler> n() {
        return this.f12300e;
    }

    public WorkDatabase o() {
        return this.f12298c;
    }

    public TaskExecutor p() {
        return this.f12299d;
    }

    public void r() {
        synchronized (f12295m) {
            this.f12303h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f12304i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f12304i = null;
            }
        }
    }

    public void s() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.b(h());
        }
        o().D().k();
        Schedulers.b(i(), o(), n());
    }

    public void t(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f12295m) {
            this.f12304i = pendingResult;
            if (this.f12303h) {
                pendingResult.finish();
                this.f12304i = null;
            }
        }
    }

    public void u(String str) {
        v(str, (WorkerParameters.RuntimeExtras) null);
    }

    public void v(String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f12299d.b(new StartWorkRunnable(this, str, runtimeExtras));
    }

    public void w(String str) {
        this.f12299d.b(new StopWorkRunnable(this, str, true));
    }

    public void x(String str) {
        this.f12299d.b(new StopWorkRunnable(this, str, false));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, boolean z2) {
        this(context, configuration, taskExecutor, WorkDatabase.u(context.getApplicationContext(), taskExecutor.getBackgroundExecutor(), z2));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        Logger.e(new Logger.LogcatLogger(configuration.j()));
        Context context2 = context;
        Configuration configuration2 = configuration;
        TaskExecutor taskExecutor2 = taskExecutor;
        WorkDatabase workDatabase2 = workDatabase;
        List<Scheduler> g2 = g(applicationContext, configuration, taskExecutor);
        q(context2, configuration2, taskExecutor2, workDatabase2, g2, new Processor(context2, configuration2, taskExecutor2, workDatabase2, g2));
    }
}
