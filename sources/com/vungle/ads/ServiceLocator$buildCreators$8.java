package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$8 extends ServiceLocator.Creator<FilePreferences> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$8(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public FilePreferences create() {
        return FilePreferences.Companion.get$default(FilePreferences.Companion, ((Executors) this.this$0.getOrBuild(Executors.class)).getIoExecutor(), (PathProvider) this.this$0.getOrBuild(PathProvider.class), (String) null, 4, (Object) null);
    }
}
