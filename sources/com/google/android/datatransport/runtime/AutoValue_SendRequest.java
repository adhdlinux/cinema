package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

final class AutoValue_SendRequest extends SendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f22481a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22482b;

    /* renamed from: c  reason: collision with root package name */
    private final Event<?> f22483c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<?, byte[]> f22484d;

    /* renamed from: e  reason: collision with root package name */
    private final Encoding f22485e;

    static final class Builder extends SendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private TransportContext f22486a;

        /* renamed from: b  reason: collision with root package name */
        private String f22487b;

        /* renamed from: c  reason: collision with root package name */
        private Event<?> f22488c;

        /* renamed from: d  reason: collision with root package name */
        private Transformer<?, byte[]> f22489d;

        /* renamed from: e  reason: collision with root package name */
        private Encoding f22490e;

        Builder() {
        }

        public SendRequest a() {
            String str = "";
            if (this.f22486a == null) {
                str = str + " transportContext";
            }
            if (this.f22487b == null) {
                str = str + " transportName";
            }
            if (this.f22488c == null) {
                str = str + " event";
            }
            if (this.f22489d == null) {
                str = str + " transformer";
            }
            if (this.f22490e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.f22486a, this.f22487b, this.f22488c, this.f22489d, this.f22490e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder b(Encoding encoding) {
            if (encoding != null) {
                this.f22490e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder c(Event<?> event) {
            if (event != null) {
                this.f22488c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder d(Transformer<?, byte[]> transformer) {
            if (transformer != null) {
                this.f22489d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public SendRequest.Builder e(TransportContext transportContext) {
            if (transportContext != null) {
                this.f22486a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public SendRequest.Builder f(String str) {
            if (str != null) {
                this.f22487b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public Encoding b() {
        return this.f22485e;
    }

    /* access modifiers changed from: package-private */
    public Event<?> c() {
        return this.f22483c;
    }

    /* access modifiers changed from: package-private */
    public Transformer<?, byte[]> e() {
        return this.f22484d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (!this.f22481a.equals(sendRequest.f()) || !this.f22482b.equals(sendRequest.g()) || !this.f22483c.equals(sendRequest.c()) || !this.f22484d.equals(sendRequest.e()) || !this.f22485e.equals(sendRequest.b())) {
            return false;
        }
        return true;
    }

    public TransportContext f() {
        return this.f22481a;
    }

    public String g() {
        return this.f22482b;
    }

    public int hashCode() {
        return ((((((((this.f22481a.hashCode() ^ 1000003) * 1000003) ^ this.f22482b.hashCode()) * 1000003) ^ this.f22483c.hashCode()) * 1000003) ^ this.f22484d.hashCode()) * 1000003) ^ this.f22485e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f22481a + ", transportName=" + this.f22482b + ", event=" + this.f22483c + ", transformer=" + this.f22484d + ", encoding=" + this.f22485e + "}";
    }

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.f22481a = transportContext;
        this.f22482b = str;
        this.f22483c = event;
        this.f22484d = transformer;
        this.f22485e = encoding;
    }
}
