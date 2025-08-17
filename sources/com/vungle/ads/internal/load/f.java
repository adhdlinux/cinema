package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.util.PathProvider;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MraidJsLoader.DownloadResultListener f37874b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdPayload f37875c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PathProvider f37876d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Downloader f37877e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ VungleThreadPoolExecutor f37878f;

    public /* synthetic */ f(MraidJsLoader.DownloadResultListener downloadResultListener, AdPayload adPayload, PathProvider pathProvider, Downloader downloader, VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        this.f37874b = downloadResultListener;
        this.f37875c = adPayload;
        this.f37876d = pathProvider;
        this.f37877e = downloader;
        this.f37878f = vungleThreadPoolExecutor;
    }

    public final void run() {
        MraidJsLoader.m184downloadJs$lambda1(this.f37874b, this.f37875c, this.f37876d, this.f37877e, this.f37878f);
    }
}
