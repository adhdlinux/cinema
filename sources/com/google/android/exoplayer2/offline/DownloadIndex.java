package com.google.android.exoplayer2.offline;

import java.io.IOException;

public interface DownloadIndex {
    DownloadCursor d(int... iArr) throws IOException;

    Download g(String str) throws IOException;
}
