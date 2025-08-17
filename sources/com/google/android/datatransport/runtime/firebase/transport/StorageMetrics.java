package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class StorageMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final StorageMetrics f22599c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f22600a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22601b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f22602a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f22603b = 0;

        Builder() {
        }

        public StorageMetrics a() {
            return new StorageMetrics(this.f22602a, this.f22603b);
        }

        public Builder b(long j2) {
            this.f22602a = j2;
            return this;
        }

        public Builder c(long j2) {
            this.f22603b = j2;
            return this;
        }
    }

    StorageMetrics(long j2, long j3) {
        this.f22600a = j2;
        this.f22601b = j3;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f22600a;
    }

    @Protobuf(tag = 2)
    public long b() {
        return this.f22601b;
    }
}
