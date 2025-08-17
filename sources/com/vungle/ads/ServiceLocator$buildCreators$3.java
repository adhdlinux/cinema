package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.Platform;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$3 extends ServiceLocator.Creator<VungleApiClient> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$3(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public VungleApiClient create() {
        return new VungleApiClient(this.this$0.ctx, (Platform) this.this$0.getOrBuild(Platform.class), (FilePreferences) this.this$0.getOrBuild(FilePreferences.class));
    }
}
