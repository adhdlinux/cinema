package com.vungle.ads.internal.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.vungle.ads.internal.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VungleJobRunner implements JobRunner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = VungleJobRunner.class.getSimpleName();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private final JobCreator creator;
    private final Executor executor;
    private long nextCheck = Clock.MAX_TIME;
    private final List<PendingJob> pendingJobs = new CopyOnWriteArrayList();
    private final Runnable pendingRunnable = new PendingRunnable(new WeakReference(this));
    private final ThreadPriorityHelper threadPriorityHelper;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class PendingJob {
        private JobInfo info;
        private final long uptimeMillis;

        public PendingJob(long j2, JobInfo jobInfo) {
            this.uptimeMillis = j2;
            this.info = jobInfo;
        }

        public final JobInfo getInfo() {
            return this.info;
        }

        public final long getUptimeMillis() {
            return this.uptimeMillis;
        }

        public final void setInfo(JobInfo jobInfo) {
            this.info = jobInfo;
        }
    }

    private static final class PendingRunnable implements Runnable {
        private WeakReference<VungleJobRunner> runner;

        public PendingRunnable(WeakReference<VungleJobRunner> weakReference) {
            Intrinsics.f(weakReference, "runner");
            this.runner = weakReference;
        }

        public final WeakReference<VungleJobRunner> getRunner() {
            return this.runner;
        }

        public void run() {
            VungleJobRunner vungleJobRunner = this.runner.get();
            if (vungleJobRunner != null) {
                vungleJobRunner.executePendingJobs();
            }
        }

        public final void setRunner(WeakReference<VungleJobRunner> weakReference) {
            Intrinsics.f(weakReference, "<set-?>");
            this.runner = weakReference;
        }
    }

    public VungleJobRunner(JobCreator jobCreator, Executor executor2, ThreadPriorityHelper threadPriorityHelper2) {
        Intrinsics.f(jobCreator, "creator");
        Intrinsics.f(executor2, "executor");
        this.creator = jobCreator;
        this.executor = executor2;
        this.threadPriorityHelper = threadPriorityHelper2;
    }

    /* access modifiers changed from: private */
    public final synchronized void executePendingJobs() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = Long.MAX_VALUE;
        for (PendingJob next : this.pendingJobs) {
            if (uptimeMillis >= next.getUptimeMillis()) {
                this.pendingJobs.remove(next);
                JobInfo info = next.getInfo();
                if (info != null) {
                    this.executor.execute(new JobRunnable(info, this.creator, this, this.threadPriorityHelper));
                }
            } else {
                j2 = Math.min(j2, next.getUptimeMillis());
            }
        }
        if (!(j2 == Clock.MAX_TIME || j2 == this.nextCheck)) {
            Handler handler2 = handler;
            handler2.removeCallbacks(this.pendingRunnable);
            handler2.postAtTime(this.pendingRunnable, TAG, j2);
        }
        this.nextCheck = j2;
    }

    public synchronized void cancelPendingJob(String str) {
        String str2;
        Intrinsics.f(str, "tag");
        ArrayList arrayList = new ArrayList();
        for (PendingJob next : this.pendingJobs) {
            JobInfo info = next.getInfo();
            if (info != null) {
                str2 = info.getJobTag();
            } else {
                str2 = null;
            }
            if (Intrinsics.a(str2, str)) {
                arrayList.add(next);
            }
        }
        this.pendingJobs.removeAll(arrayList);
    }

    public synchronized void execute(JobInfo jobInfo) {
        String str;
        Intrinsics.f(jobInfo, "jobInfo");
        JobInfo copy = jobInfo.copy();
        if (copy != null) {
            String jobTag = copy.getJobTag();
            long delay = copy.getDelay();
            copy.setDelay(0);
            if (copy.getUpdateCurrent()) {
                for (PendingJob next : this.pendingJobs) {
                    JobInfo info = next.getInfo();
                    if (info != null) {
                        str = info.getJobTag();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.a(str, jobTag)) {
                        Logger.Companion companion = Logger.Companion;
                        String str2 = TAG;
                        Intrinsics.e(str2, "TAG");
                        companion.d(str2, "replacing pending job with new " + jobTag);
                        this.pendingJobs.remove(next);
                    }
                }
            }
            this.pendingJobs.add(new PendingJob(SystemClock.uptimeMillis() + delay, copy));
            executePendingJobs();
        }
    }

    public final int getPendingJobSize$vungle_ads_release() {
        return this.pendingJobs.size();
    }
}
