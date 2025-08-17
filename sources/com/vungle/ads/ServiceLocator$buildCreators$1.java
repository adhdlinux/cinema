package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.task.JobCreator;
import com.vungle.ads.internal.task.VungleJobCreator;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$1 extends ServiceLocator.Creator<JobCreator> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$1(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public JobCreator create() {
        return new VungleJobCreator(this.this$0.ctx, (PathProvider) this.this$0.getOrBuild(PathProvider.class));
    }
}
