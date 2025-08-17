package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class SystemAlarmDispatcher implements ExecutionListener {

    /* renamed from: l  reason: collision with root package name */
    static final String f12382l = Logger.f("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    final Context f12383b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskExecutor f12384c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkTimer f12385d;

    /* renamed from: e  reason: collision with root package name */
    private final Processor f12386e;

    /* renamed from: f  reason: collision with root package name */
    private final WorkManagerImpl f12387f;

    /* renamed from: g  reason: collision with root package name */
    final CommandHandler f12388g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f12389h;

    /* renamed from: i  reason: collision with root package name */
    final List<Intent> f12390i;

    /* renamed from: j  reason: collision with root package name */
    Intent f12391j;

    /* renamed from: k  reason: collision with root package name */
    private CommandsCompletedListener f12392k;

    static class AddRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final SystemAlarmDispatcher f12394b;

        /* renamed from: c  reason: collision with root package name */
        private final Intent f12395c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12396d;

        AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i2) {
            this.f12394b = systemAlarmDispatcher;
            this.f12395c = intent;
            this.f12396d = i2;
        }

        public void run() {
            this.f12394b.a(this.f12395c, this.f12396d);
        }
    }

    interface CommandsCompletedListener {
        void b();
    }

    static class DequeueAndCheckForCompletion implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final SystemAlarmDispatcher f12397b;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f12397b = systemAlarmDispatcher;
        }

        public void run() {
            this.f12397b.c();
        }
    }

    SystemAlarmDispatcher(Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null);
    }

    private void b() {
        if (this.f12389h.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        b();
        synchronized (this.f12390i) {
            for (Intent action : this.f12390i) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock b2 = WakeLocks.b(this.f12383b, "ProcessCommand");
        try {
            b2.acquire();
            this.f12387f.p().b(new Runnable() {
                public void run() {
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    synchronized (SystemAlarmDispatcher.this.f12390i) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.f12391j = systemAlarmDispatcher2.f12390i.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f12391j;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f12391j.getIntExtra("KEY_START_ID", 0);
                        Logger c2 = Logger.c();
                        String str = SystemAlarmDispatcher.f12382l;
                        c2.a(str, String.format("Processing command %s, %s", new Object[]{SystemAlarmDispatcher.this.f12391j, Integer.valueOf(intExtra)}), new Throwable[0]);
                        PowerManager.WakeLock b2 = WakeLocks.b(SystemAlarmDispatcher.this.f12383b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            Logger.c().a(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, b2}), new Throwable[0]);
                            b2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.f12388g.p(systemAlarmDispatcher3.f12391j, intExtra, systemAlarmDispatcher3);
                            Logger.c().a(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b2}), new Throwable[0]);
                            b2.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            Logger.c().a(SystemAlarmDispatcher.f12382l, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b2}), new Throwable[0]);
                            b2.release();
                            SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher4.k(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                            throw th;
                        }
                        systemAlarmDispatcher.k(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            b2.release();
        }
    }

    public boolean a(Intent intent, int i2) {
        Logger c2 = Logger.c();
        String str = f12382l;
        boolean z2 = false;
        c2.a(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i2);
            synchronized (this.f12390i) {
                if (!this.f12390i.isEmpty()) {
                    z2 = true;
                }
                this.f12390i.add(intent);
                if (!z2) {
                    l();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Logger c2 = Logger.c();
        String str = f12382l;
        c2.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f12390i) {
            if (this.f12391j != null) {
                Logger.c().a(str, String.format("Removing command %s", new Object[]{this.f12391j}), new Throwable[0]);
                if (this.f12390i.remove(0).equals(this.f12391j)) {
                    this.f12391j = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            SerialExecutor backgroundExecutor = this.f12384c.getBackgroundExecutor();
            if (!this.f12388g.o() && this.f12390i.isEmpty() && !backgroundExecutor.a()) {
                Logger.c().a(str, "No more commands & intents.", new Throwable[0]);
                CommandsCompletedListener commandsCompletedListener = this.f12392k;
                if (commandsCompletedListener != null) {
                    commandsCompletedListener.b();
                }
            } else if (!this.f12390i.isEmpty()) {
                l();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Processor d() {
        return this.f12386e;
    }

    public void e(String str, boolean z2) {
        k(new AddRunnable(this, CommandHandler.c(this.f12383b, str, z2), 0));
    }

    /* access modifiers changed from: package-private */
    public TaskExecutor f() {
        return this.f12384c;
    }

    /* access modifiers changed from: package-private */
    public WorkManagerImpl g() {
        return this.f12387f;
    }

    /* access modifiers changed from: package-private */
    public WorkTimer h() {
        return this.f12385d;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Logger.c().a(f12382l, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f12386e.i(this);
        this.f12385d.a();
        this.f12392k = null;
    }

    /* access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        this.f12389h.post(runnable);
    }

    /* access modifiers changed from: package-private */
    public void m(CommandsCompletedListener commandsCompletedListener) {
        if (this.f12392k != null) {
            Logger.c().b(f12382l, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f12392k = commandsCompletedListener;
        }
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.f12383b = applicationContext;
        this.f12388g = new CommandHandler(applicationContext);
        this.f12385d = new WorkTimer();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.k(context) : workManagerImpl;
        this.f12387f = workManagerImpl;
        processor = processor == null ? workManagerImpl.m() : processor;
        this.f12386e = processor;
        this.f12384c = workManagerImpl.p();
        processor.c(this);
        this.f12390i = new ArrayList();
        this.f12391j = null;
        this.f12389h = new Handler(Looper.getMainLooper());
    }
}
