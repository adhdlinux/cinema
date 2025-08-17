package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.task.JobRunner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.vungle.ads.internal.AdInternal$_set_adState_$lambda-1$$inlined$inject$1  reason: invalid class name */
public final class AdInternal$_set_adState_$lambda1$$inlined$inject$1 extends Lambda implements Function0<JobRunner> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdInternal$_set_adState_$lambda1$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.task.JobRunner] */
    public final JobRunner invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(JobRunner.class);
    }
}
