package com.vungle.ads.internal.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class SDKExecutors implements Executors {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    private static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    private static final int SINGLE_CORE_POOL_SIZE = 1;
    private static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;
    private VungleThreadPoolExecutor API_EXECUTOR;
    private VungleThreadPoolExecutor BACKGROUND_EXECUTOR;
    private VungleThreadPoolExecutor DOWNLOADER_EXECUTOR;
    private VungleThreadPoolExecutor IO_EXECUTOR;
    private VungleThreadPoolExecutor JOB_EXECUTOR;
    private VungleThreadPoolExecutor LOGGER_EXECUTOR;
    private final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private VungleThreadPoolExecutor OFFLOAD_EXECUTOR;
    private VungleThreadPoolExecutor UA_EXECUTOR;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SDKExecutors() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.JOB_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 1, timeUnit, new LinkedBlockingQueue(), new NamedThreadFactory("vng_jr"));
        TimeUnit timeUnit2 = timeUnit;
        this.IO_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 5, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
        this.API_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_api"));
        this.LOGGER_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_logger"));
        this.BACKGROUND_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
        this.UA_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ua"));
        this.DOWNLOADER_EXECUTOR = new VungleThreadPoolExecutor(4, 4, 1, timeUnit2, new PriorityBlockingQueue(), new NamedThreadFactory("vng_down"));
        this.OFFLOAD_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, timeUnit2, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ol"));
    }

    public VungleThreadPoolExecutor getApiExecutor() {
        return this.API_EXECUTOR;
    }

    public VungleThreadPoolExecutor getBackgroundExecutor() {
        return this.BACKGROUND_EXECUTOR;
    }

    public VungleThreadPoolExecutor getDownloaderExecutor() {
        return this.DOWNLOADER_EXECUTOR;
    }

    public VungleThreadPoolExecutor getIoExecutor() {
        return this.IO_EXECUTOR;
    }

    public VungleThreadPoolExecutor getJobExecutor() {
        return this.JOB_EXECUTOR;
    }

    public VungleThreadPoolExecutor getLoggerExecutor() {
        return this.LOGGER_EXECUTOR;
    }

    public VungleThreadPoolExecutor getOffloadExecutor() {
        return this.OFFLOAD_EXECUTOR;
    }

    public VungleThreadPoolExecutor getUaExecutor() {
        return this.UA_EXECUTOR;
    }
}
