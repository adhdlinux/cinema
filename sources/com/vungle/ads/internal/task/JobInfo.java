package com.vungle.ads.internal.task;

import android.os.Bundle;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class JobInfo implements Cloneable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "JobInfo";
    private long delay;
    private Bundle extras = new Bundle();
    private final String jobTag;
    private long nextRescheduleTimeout;
    private int priority = 2;
    private int requiredNetworkType;
    private int reschedulePolicy = 1;
    private long rescheduleTimeout;
    private boolean updateCurrent;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JobInfo(String str) {
        Intrinsics.f(str, "jobTag");
        this.jobTag = str;
    }

    public static /* synthetic */ void getPriority$annotations() {
    }

    public static /* synthetic */ void getRequiredNetworkType$annotations() {
    }

    private static /* synthetic */ void getReschedulePolicy$annotations() {
    }

    public Object clone() {
        return super.clone();
    }

    public final JobInfo copy() {
        try {
            Object clone = super.clone();
            Intrinsics.d(clone, "null cannot be cast to non-null type com.vungle.ads.internal.task.JobInfo");
            return (JobInfo) clone;
        } catch (CloneNotSupportedException e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Cannot copy JobInfo " + this, e2);
            return null;
        }
    }

    public final long getDelay() {
        return this.delay;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getJobTag() {
        return this.jobTag;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public final long makeNextRescedule() {
        long j2 = this.rescheduleTimeout;
        if (j2 == 0) {
            return 0;
        }
        long j3 = this.nextRescheduleTimeout;
        if (j3 == 0) {
            this.nextRescheduleTimeout = j2;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j3 * ((long) 2);
        }
        return this.nextRescheduleTimeout;
    }

    public final JobInfo setDelay(long j2) {
        this.delay = j2;
        return this;
    }

    public final JobInfo setExtras(Bundle bundle) {
        Intrinsics.f(bundle, "extras");
        this.extras = bundle;
        return this;
    }

    public final JobInfo setPriority(int i2) {
        this.priority = i2;
        return this;
    }

    public final JobInfo setRequiredNetworkType(int i2) {
        this.requiredNetworkType = i2;
        return this;
    }

    public final JobInfo setReschedulePolicy(long j2, int i2) {
        this.rescheduleTimeout = j2;
        this.reschedulePolicy = i2;
        return this;
    }

    public final JobInfo setUpdateCurrent(boolean z2) {
        this.updateCurrent = z2;
        return this;
    }
}
