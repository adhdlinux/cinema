package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater f25644b;

    public /* synthetic */ g(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.f25644b = foregroundNotificationUpdater;
    }

    public final void run() {
        this.f25644b.f();
    }
}
