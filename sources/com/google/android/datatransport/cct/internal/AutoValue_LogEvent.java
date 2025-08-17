package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

final class AutoValue_LogEvent extends LogEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f22355a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f22356b;

    /* renamed from: c  reason: collision with root package name */
    private final long f22357c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f22358d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22359e;

    /* renamed from: f  reason: collision with root package name */
    private final long f22360f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f22361g;

    static final class Builder extends LogEvent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f22362a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f22363b;

        /* renamed from: c  reason: collision with root package name */
        private Long f22364c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f22365d;

        /* renamed from: e  reason: collision with root package name */
        private String f22366e;

        /* renamed from: f  reason: collision with root package name */
        private Long f22367f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f22368g;

        Builder() {
        }

        public LogEvent a() {
            String str = "";
            if (this.f22362a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f22364c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f22367f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.f22362a.longValue(), this.f22363b, this.f22364c.longValue(), this.f22365d, this.f22366e, this.f22367f.longValue(), this.f22368g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogEvent.Builder b(Integer num) {
            this.f22363b = num;
            return this;
        }

        public LogEvent.Builder c(long j2) {
            this.f22362a = Long.valueOf(j2);
            return this;
        }

        public LogEvent.Builder d(long j2) {
            this.f22364c = Long.valueOf(j2);
            return this;
        }

        public LogEvent.Builder e(NetworkConnectionInfo networkConnectionInfo) {
            this.f22368g = networkConnectionInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder f(byte[] bArr) {
            this.f22365d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder g(String str) {
            this.f22366e = str;
            return this;
        }

        public LogEvent.Builder h(long j2) {
            this.f22367f = Long.valueOf(j2);
            return this;
        }
    }

    public Integer b() {
        return this.f22356b;
    }

    public long c() {
        return this.f22355a;
    }

    public long d() {
        return this.f22357c;
    }

    public NetworkConnectionInfo e() {
        return this.f22361g;
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f22355a == logEvent.c() && ((num = this.f22356b) != null ? num.equals(logEvent.b()) : logEvent.b() == null) && this.f22357c == logEvent.d()) {
            byte[] bArr2 = this.f22358d;
            if (logEvent instanceof AutoValue_LogEvent) {
                bArr = ((AutoValue_LogEvent) logEvent).f22358d;
            } else {
                bArr = logEvent.f();
            }
            if (Arrays.equals(bArr2, bArr) && ((str = this.f22359e) != null ? str.equals(logEvent.g()) : logEvent.g() == null) && this.f22360f == logEvent.h()) {
                NetworkConnectionInfo networkConnectionInfo = this.f22361g;
                if (networkConnectionInfo == null) {
                    if (logEvent.e() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    public byte[] f() {
        return this.f22358d;
    }

    public String g() {
        return this.f22359e;
    }

    public long h() {
        return this.f22360f;
    }

    public int hashCode() {
        int i2;
        int i3;
        long j2 = this.f22355a;
        int i4 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f22356b;
        int i5 = 0;
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.hashCode();
        }
        long j3 = this.f22357c;
        int hashCode = (((((i4 ^ i2) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f22358d)) * 1000003;
        String str = this.f22359e;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        long j4 = this.f22360f;
        int i6 = (((hashCode ^ i3) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f22361g;
        if (networkConnectionInfo != null) {
            i5 = networkConnectionInfo.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f22355a + ", eventCode=" + this.f22356b + ", eventUptimeMs=" + this.f22357c + ", sourceExtension=" + Arrays.toString(this.f22358d) + ", sourceExtensionJsonProto3=" + this.f22359e + ", timezoneOffsetSeconds=" + this.f22360f + ", networkConnectionInfo=" + this.f22361g + "}";
    }

    private AutoValue_LogEvent(long j2, Integer num, long j3, byte[] bArr, String str, long j4, NetworkConnectionInfo networkConnectionInfo) {
        this.f22355a = j2;
        this.f22356b = num;
        this.f22357c = j3;
        this.f22358d = bArr;
        this.f22359e = str;
        this.f22360f = j4;
        this.f22361g = networkConnectionInfo;
    }
}
