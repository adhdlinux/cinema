package com.google.android.exoplayer2.offline;

public interface DownloaderFactory {
    Downloader a(DownloadRequest downloadRequest);
}
