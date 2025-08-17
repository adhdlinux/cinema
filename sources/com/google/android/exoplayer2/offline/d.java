package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.d((Download) obj, (Download) obj2);
    }
}
