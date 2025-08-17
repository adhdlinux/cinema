package com.google.android.exoplayer2.offline;

import java.io.Closeable;

public interface DownloadCursor extends Closeable {
    Download I();

    void close();

    int getPosition();

    boolean moveToNext();

    boolean moveToPosition(int i2);
}
