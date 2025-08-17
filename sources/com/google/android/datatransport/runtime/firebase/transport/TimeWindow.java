package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class TimeWindow {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeWindow f22604c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f22605a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22606b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f22607a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f22608b = 0;

        Builder() {
        }

        public TimeWindow a() {
            return new TimeWindow(this.f22607a, this.f22608b);
        }

        public Builder b(long j2) {
            this.f22608b = j2;
            return this;
        }

        public Builder c(long j2) {
            this.f22607a = j2;
            return this;
        }
    }

    TimeWindow(long j2, long j3) {
        this.f22605a = j2;
        this.f22606b = j3;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long a() {
        return this.f22606b;
    }

    @Protobuf(tag = 1)
    public long b() {
        return this.f22605a;
    }
}
