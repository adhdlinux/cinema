package com.facebook.react.jstasks;

import com.facebook.react.bridge.WritableMap;

public class HeadlessJsTaskConfig {
    private final boolean mAllowedInForeground;
    private final WritableMap mData;
    private final HeadlessJsTaskRetryPolicy mRetryPolicy;
    private final String mTaskKey;
    private final long mTimeout;

    public HeadlessJsTaskConfig(String str, WritableMap writableMap) {
        this(str, writableMap, 0, false);
    }

    /* access modifiers changed from: package-private */
    public WritableMap getData() {
        return this.mData;
    }

    /* access modifiers changed from: package-private */
    public HeadlessJsTaskRetryPolicy getRetryPolicy() {
        return this.mRetryPolicy;
    }

    /* access modifiers changed from: package-private */
    public String getTaskKey() {
        return this.mTaskKey;
    }

    /* access modifiers changed from: package-private */
    public long getTimeout() {
        return this.mTimeout;
    }

    /* access modifiers changed from: package-private */
    public boolean isAllowedInForeground() {
        return this.mAllowedInForeground;
    }

    public HeadlessJsTaskConfig(String str, WritableMap writableMap, long j2) {
        this(str, writableMap, j2, false);
    }

    public HeadlessJsTaskConfig(String str, WritableMap writableMap, long j2, boolean z2) {
        this(str, writableMap, j2, z2, NoRetryPolicy.INSTANCE);
    }

    public HeadlessJsTaskConfig(String str, WritableMap writableMap, long j2, boolean z2, HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy) {
        this.mTaskKey = str;
        this.mData = writableMap;
        this.mTimeout = j2;
        this.mAllowedInForeground = z2;
        this.mRetryPolicy = headlessJsTaskRetryPolicy;
    }

    public HeadlessJsTaskConfig(HeadlessJsTaskConfig headlessJsTaskConfig) {
        this.mTaskKey = headlessJsTaskConfig.mTaskKey;
        this.mData = headlessJsTaskConfig.mData.copy();
        this.mTimeout = headlessJsTaskConfig.mTimeout;
        this.mAllowedInForeground = headlessJsTaskConfig.mAllowedInForeground;
        HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy = headlessJsTaskConfig.mRetryPolicy;
        if (headlessJsTaskRetryPolicy != null) {
            this.mRetryPolicy = headlessJsTaskRetryPolicy.copy();
        } else {
            this.mRetryPolicy = null;
        }
    }
}
