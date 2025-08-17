package com.vungle.ads.internal.task;

import android.content.Context;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ResendTpatJob implements Job {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ResendTpatJob";
    private final Context context;
    private final PathProvider pathProvider;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JobInfo makeJobInfo() {
            return new JobInfo(ResendTpatJob.TAG).setPriority(0).setUpdateCurrent(true);
        }
    }

    public ResendTpatJob(Context context2, PathProvider pathProvider2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    /* renamed from: onRunJob$lambda-0  reason: not valid java name */
    private static final VungleApiClient m210onRunJob$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* renamed from: onRunJob$lambda-1  reason: not valid java name */
    private static final Executors m211onRunJob$lambda1(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        Intrinsics.f(bundle, "bundle");
        Intrinsics.f(jobRunner, "jobRunner");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context2 = this.context;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Lazy a2 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ResendTpatJob$onRunJob$$inlined$inject$1(context2));
        Lazy a3 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ResendTpatJob$onRunJob$$inlined$inject$2(this.context));
        new TpatSender(m210onRunJob$lambda0(a2), (LogEntry) null, m211onRunJob$lambda1(a3).getIoExecutor(), this.pathProvider, (SignalManager) null, 18, (DefaultConstructorMarker) null).resendStoredTpats$vungle_ads_release(m211onRunJob$lambda1(a3).getJobExecutor());
        return 0;
    }
}
