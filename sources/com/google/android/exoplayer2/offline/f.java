package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.DownloadManagerHelper f25642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadService f25643c;

    public /* synthetic */ f(DownloadService.DownloadManagerHelper downloadManagerHelper, DownloadService downloadService) {
        this.f25642b = downloadManagerHelper;
        this.f25643c = downloadService;
    }

    public final void run() {
        this.f25642b.f(this.f25643c);
    }
}
