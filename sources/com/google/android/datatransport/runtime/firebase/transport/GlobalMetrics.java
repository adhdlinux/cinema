package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class GlobalMetrics {

    /* renamed from: b  reason: collision with root package name */
    private static final GlobalMetrics f22577b = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final StorageMetrics f22578a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private StorageMetrics f22579a = null;

        Builder() {
        }

        public GlobalMetrics a() {
            return new GlobalMetrics(this.f22579a);
        }

        public Builder b(StorageMetrics storageMetrics) {
            this.f22579a = storageMetrics;
            return this;
        }
    }

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.f22578a = storageMetrics;
    }

    public static Builder b() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public StorageMetrics a() {
        return this.f22578a;
    }
}
