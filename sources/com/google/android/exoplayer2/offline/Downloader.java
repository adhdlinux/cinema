package com.google.android.exoplayer2.offline;

import java.io.IOException;

public interface Downloader {

    public interface ProgressListener {
        void a(long j2, long j3, float f2);
    }

    void a(ProgressListener progressListener) throws IOException, InterruptedException;

    void cancel();

    void remove();
}
