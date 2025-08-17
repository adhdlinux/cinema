package com.vungle.ads.internal.downloader;

public interface Downloader {

    public static final class RequestException extends Exception {
        public RequestException(String str) {
            super(str);
        }
    }

    void cancel(DownloadRequest downloadRequest);

    void cancelAll();

    void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener);
}
