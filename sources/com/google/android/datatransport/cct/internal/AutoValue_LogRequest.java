package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;

final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f22369a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22370b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f22371c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f22372d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22373e;

    /* renamed from: f  reason: collision with root package name */
    private final List<LogEvent> f22374f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f22375g;

    static final class Builder extends LogRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f22376a;

        /* renamed from: b  reason: collision with root package name */
        private Long f22377b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f22378c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f22379d;

        /* renamed from: e  reason: collision with root package name */
        private String f22380e;

        /* renamed from: f  reason: collision with root package name */
        private List<LogEvent> f22381f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f22382g;

        Builder() {
        }

        public LogRequest a() {
            String str = "";
            if (this.f22376a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f22377b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.f22376a.longValue(), this.f22377b.longValue(), this.f22378c, this.f22379d, this.f22380e, this.f22381f, this.f22382g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogRequest.Builder b(ClientInfo clientInfo) {
            this.f22378c = clientInfo;
            return this;
        }

        public LogRequest.Builder c(List<LogEvent> list) {
            this.f22381f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder d(Integer num) {
            this.f22379d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder e(String str) {
            this.f22380e = str;
            return this;
        }

        public LogRequest.Builder f(QosTier qosTier) {
            this.f22382g = qosTier;
            return this;
        }

        public LogRequest.Builder g(long j2) {
            this.f22376a = Long.valueOf(j2);
            return this;
        }

        public LogRequest.Builder h(long j2) {
            this.f22377b = Long.valueOf(j2);
            return this;
        }
    }

    public ClientInfo b() {
        return this.f22371c;
    }

    public List<LogEvent> c() {
        return this.f22374f;
    }

    public Integer d() {
        return this.f22372d;
    }

    public String e() {
        return this.f22373e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f22369a == logRequest.g() && this.f22370b == logRequest.h() && ((clientInfo = this.f22371c) != null ? clientInfo.equals(logRequest.b()) : logRequest.b() == null) && ((num = this.f22372d) != null ? num.equals(logRequest.d()) : logRequest.d() == null) && ((str = this.f22373e) != null ? str.equals(logRequest.e()) : logRequest.e() == null) && ((list = this.f22374f) != null ? list.equals(logRequest.c()) : logRequest.c() == null)) {
            QosTier qosTier = this.f22375g;
            if (qosTier == null) {
                if (logRequest.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.f())) {
                return true;
            }
        }
        return false;
    }

    public QosTier f() {
        return this.f22375g;
    }

    public long g() {
        return this.f22369a;
    }

    public long h() {
        return this.f22370b;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        long j2 = this.f22369a;
        long j3 = this.f22370b;
        int i6 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        ClientInfo clientInfo = this.f22371c;
        int i7 = 0;
        if (clientInfo == null) {
            i2 = 0;
        } else {
            i2 = clientInfo.hashCode();
        }
        int i8 = (i6 ^ i2) * 1000003;
        Integer num = this.f22372d;
        if (num == null) {
            i3 = 0;
        } else {
            i3 = num.hashCode();
        }
        int i9 = (i8 ^ i3) * 1000003;
        String str = this.f22373e;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i10 = (i9 ^ i4) * 1000003;
        List<LogEvent> list = this.f22374f;
        if (list == null) {
            i5 = 0;
        } else {
            i5 = list.hashCode();
        }
        int i11 = (i10 ^ i5) * 1000003;
        QosTier qosTier = this.f22375g;
        if (qosTier != null) {
            i7 = qosTier.hashCode();
        }
        return i11 ^ i7;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f22369a + ", requestUptimeMs=" + this.f22370b + ", clientInfo=" + this.f22371c + ", logSource=" + this.f22372d + ", logSourceName=" + this.f22373e + ", logEvents=" + this.f22374f + ", qosTier=" + this.f22375g + "}";
    }

    private AutoValue_LogRequest(long j2, long j3, ClientInfo clientInfo, Integer num, String str, List<LogEvent> list, QosTier qosTier) {
        this.f22369a = j2;
        this.f22370b = j3;
        this.f22371c = clientInfo;
        this.f22372d = num;
        this.f22373e = str;
        this.f22374f = list;
        this.f22375g = qosTier;
    }
}
