package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class c implements RequirementsWatcher.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f25641a;

    public /* synthetic */ c(DownloadManager downloadManager) {
        this.f25641a = downloadManager;
    }

    public final void a(RequirementsWatcher requirementsWatcher, int i2) {
        this.f25641a.s(requirementsWatcher, i2);
    }
}
