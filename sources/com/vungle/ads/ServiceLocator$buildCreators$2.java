package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.task.JobCreator;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.task.JobRunnerThreadPriorityHelper;
import com.vungle.ads.internal.task.VungleJobRunner;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$2 extends ServiceLocator.Creator<JobRunner> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$2(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public JobRunner create() {
        return new VungleJobRunner((JobCreator) this.this$0.getOrBuild(JobCreator.class), ((Executors) this.this$0.getOrBuild(Executors.class)).getJobExecutor(), new JobRunnerThreadPriorityHelper());
    }
}
