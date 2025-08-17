package com.vungle.ads.internal.downloader;

import com.vungle.ads.internal.task.PriorityRunnable;

public final class AssetDownloader$download$1 extends PriorityRunnable {
    final /* synthetic */ AssetDownloadListener $downloadListener;
    final /* synthetic */ DownloadRequest $downloadRequest;
    final /* synthetic */ AssetDownloader this$0;

    AssetDownloader$download$1(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.this$0 = assetDownloader;
        this.$downloadRequest = downloadRequest;
        this.$downloadListener = assetDownloadListener;
    }

    public int getPriority() {
        return this.$downloadRequest.getPriority();
    }

    public void run() {
        this.this$0.launchRequest(this.$downloadRequest, this.$downloadListener);
    }
}
