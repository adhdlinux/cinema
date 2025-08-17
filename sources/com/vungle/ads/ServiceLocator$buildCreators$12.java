package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.downloader.AssetDownloader;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.util.PathProvider;

public final class ServiceLocator$buildCreators$12 extends ServiceLocator.Creator<Downloader> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$12(ServiceLocator serviceLocator) {
        super(false);
        this.this$0 = serviceLocator;
    }

    public Downloader create() {
        return new AssetDownloader(((Executors) this.this$0.getOrBuild(Executors.class)).getDownloaderExecutor(), (PathProvider) this.this$0.getOrBuild(PathProvider.class));
    }
}
