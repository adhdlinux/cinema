package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.task.JobRunner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class VungleInitializer$configure$$inlined$inject$4 extends Lambda implements Function0<JobRunner> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VungleInitializer$configure$$inlined$inject$4(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.task.JobRunner] */
    public final JobRunner invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(JobRunner.class);
    }
}
