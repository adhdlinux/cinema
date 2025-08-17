package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;
import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public abstract class nc {
    public static final List a(DownloadCursor downloadCursor) {
        Intrinsics.f(downloadCursor, "<this>");
        ArrayList arrayList = new ArrayList();
        while (downloadCursor.moveToNext()) {
            Download I = downloadCursor.I();
            Intrinsics.e(I, "download");
            arrayList.add(r4.a(I));
        }
        return arrayList;
    }

    public static final List a(DownloadManager downloadManager) {
        Intrinsics.f(downloadManager, "<this>");
        DownloadCursor d2 = downloadManager.f().d(new int[0]);
        Intrinsics.e(d2, "downloadIndex.getDownloads()");
        return a(d2);
    }

    public static final q4 a(DownloadManager downloadManager, String str) {
        Intrinsics.f(downloadManager, "<this>");
        Intrinsics.f(str, "id");
        Download g2 = downloadManager.f().g(str);
        if (g2 != null) {
            return r4.a(g2);
        }
        return null;
    }
}
