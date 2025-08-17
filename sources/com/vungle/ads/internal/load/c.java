package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.DownloadRequest;
import java.io.File;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f37865b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAdLoader$assetDownloadListener$1 f37866c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DownloadRequest f37867d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BaseAdLoader f37868e;

    public /* synthetic */ c(File file, BaseAdLoader$assetDownloadListener$1 baseAdLoader$assetDownloadListener$1, DownloadRequest downloadRequest, BaseAdLoader baseAdLoader) {
        this.f37865b = file;
        this.f37866c = baseAdLoader$assetDownloadListener$1;
        this.f37867d = downloadRequest;
        this.f37868e = baseAdLoader;
    }

    public final void run() {
        BaseAdLoader$assetDownloadListener$1.m181onSuccess$lambda1(this.f37865b, this.f37866c, this.f37867d, this.f37868e);
    }
}
