package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class Stats {
    private static final int BITMAP_DECODE_FINISHED = 2;
    private static final int BITMAP_TRANSFORMED_FINISHED = 3;
    private static final int CACHE_HIT = 0;
    private static final int CACHE_MISS = 1;
    private static final int DOWNLOAD_FINISHED = 4;
    private static final String STATS_THREAD_NAME = "Picasso-Stats";
    long averageDownloadSize;
    long averageOriginalBitmapSize;
    long averageTransformedBitmapSize;
    final Cache cache;
    long cacheHits;
    long cacheMisses;
    int downloadCount;
    final Handler handler;
    int originalBitmapCount;
    final HandlerThread statsThread;
    long totalDownloadSize;
    long totalOriginalBitmapSize;
    long totalTransformedBitmapSize;
    int transformedBitmapCount;

    private static class StatsHandler extends Handler {
        private final Stats stats;

        StatsHandler(Looper looper, Stats stats2) {
            super(looper);
            this.stats = stats2;
        }

        public void handleMessage(final Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.stats.performCacheHit();
            } else if (i2 == 1) {
                this.stats.performCacheMiss();
            } else if (i2 == 2) {
                this.stats.performBitmapDecoded((long) message.arg1);
            } else if (i2 == 3) {
                this.stats.performBitmapTransformed((long) message.arg1);
            } else if (i2 != 4) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
            } else {
                this.stats.performDownloadFinished((Long) message.obj);
            }
        }
    }

    Stats(Cache cache2) {
        this.cache = cache2;
        HandlerThread handlerThread = new HandlerThread(STATS_THREAD_NAME, 10);
        this.statsThread = handlerThread;
        handlerThread.start();
        Utils.flushStackLocalLeaks(handlerThread.getLooper());
        this.handler = new StatsHandler(handlerThread.getLooper(), this);
    }

    private static long getAverage(int i2, long j2) {
        return j2 / ((long) i2);
    }

    private void processBitmap(Bitmap bitmap, int i2) {
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(i2, bitmapBytes, 0));
    }

    /* access modifiers changed from: package-private */
    public StatsSnapshot createSnapshot() {
        return new StatsSnapshot(this.cache.maxSize(), this.cache.size(), this.cacheHits, this.cacheMisses, this.totalDownloadSize, this.totalOriginalBitmapSize, this.totalTransformedBitmapSize, this.averageDownloadSize, this.averageOriginalBitmapSize, this.averageTransformedBitmapSize, this.downloadCount, this.originalBitmapCount, this.transformedBitmapCount, System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public void dispatchBitmapDecoded(Bitmap bitmap) {
        processBitmap(bitmap, 2);
    }

    /* access modifiers changed from: package-private */
    public void dispatchBitmapTransformed(Bitmap bitmap) {
        processBitmap(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void dispatchCacheHit() {
        this.handler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public void dispatchCacheMiss() {
        this.handler.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchDownloadFinished(long j2) {
        Handler handler2 = this.handler;
        handler2.sendMessage(handler2.obtainMessage(4, Long.valueOf(j2)));
    }

    /* access modifiers changed from: package-private */
    public void performBitmapDecoded(long j2) {
        int i2 = this.originalBitmapCount + 1;
        this.originalBitmapCount = i2;
        long j3 = this.totalOriginalBitmapSize + j2;
        this.totalOriginalBitmapSize = j3;
        this.averageOriginalBitmapSize = getAverage(i2, j3);
    }

    /* access modifiers changed from: package-private */
    public void performBitmapTransformed(long j2) {
        this.transformedBitmapCount++;
        long j3 = this.totalTransformedBitmapSize + j2;
        this.totalTransformedBitmapSize = j3;
        this.averageTransformedBitmapSize = getAverage(this.originalBitmapCount, j3);
    }

    /* access modifiers changed from: package-private */
    public void performCacheHit() {
        this.cacheHits++;
    }

    /* access modifiers changed from: package-private */
    public void performCacheMiss() {
        this.cacheMisses++;
    }

    /* access modifiers changed from: package-private */
    public void performDownloadFinished(Long l2) {
        this.downloadCount++;
        long longValue = this.totalDownloadSize + l2.longValue();
        this.totalDownloadSize = longValue;
        this.averageDownloadSize = getAverage(this.downloadCount, longValue);
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.statsThread.quit();
    }
}
