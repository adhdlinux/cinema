package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f22668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JobParameters f22669c;

    public /* synthetic */ b(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f22668b = jobInfoSchedulerService;
        this.f22669c = jobParameters;
    }

    public final void run() {
        this.f22668b.b(this.f22669c);
    }
}
