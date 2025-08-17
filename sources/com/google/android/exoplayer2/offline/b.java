package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class b implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f25640b;

    public /* synthetic */ b(DownloadManager downloadManager) {
        this.f25640b = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return this.f25640b.j(message);
    }
}
