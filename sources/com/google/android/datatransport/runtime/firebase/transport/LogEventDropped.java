package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class LogEventDropped {

    /* renamed from: c  reason: collision with root package name */
    private static final LogEventDropped f22580c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f22581a;

    /* renamed from: b  reason: collision with root package name */
    private final Reason f22582b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f22583a = 0;

        /* renamed from: b  reason: collision with root package name */
        private Reason f22584b = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f22583a, this.f22584b);
        }

        public Builder b(long j2) {
            this.f22583a = j2;
            return this;
        }

        public Builder c(Reason reason) {
            this.f22584b = reason;
            return this;
        }
    }

    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        

        /* renamed from: b  reason: collision with root package name */
        private final int f22593b;

        private Reason(int i2) {
            this.f22593b = i2;
        }

        public int getNumber() {
            return this.f22593b;
        }
    }

    LogEventDropped(long j2, Reason reason) {
        this.f22581a = j2;
        this.f22582b = reason;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f22581a;
    }

    @Protobuf(tag = 3)
    public Reason b() {
        return this.f22582b;
    }
}
