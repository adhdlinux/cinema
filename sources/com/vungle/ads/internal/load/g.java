package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDownloadListener.DownloadError f37879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadRequest f37880c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdPayload f37881d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ File f37882e;

    public /* synthetic */ g(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest, AdPayload adPayload, File file) {
        this.f37879b = downloadError;
        this.f37880c = downloadRequest;
        this.f37881d = adPayload;
        this.f37882e = file;
    }

    public final void run() {
        MraidJsLoader$downloadJs$1$2.m185onError$lambda0(this.f37879b, this.f37880c, this.f37881d, this.f37882e);
    }
}
