package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f22469a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f22470b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedPayload f22471c;

    /* renamed from: d  reason: collision with root package name */
    private final long f22472d;

    /* renamed from: e  reason: collision with root package name */
    private final long f22473e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f22474f;

    static final class Builder extends EventInternal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f22475a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f22476b;

        /* renamed from: c  reason: collision with root package name */
        private EncodedPayload f22477c;

        /* renamed from: d  reason: collision with root package name */
        private Long f22478d;

        /* renamed from: e  reason: collision with root package name */
        private Long f22479e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f22480f;

        Builder() {
        }

        public EventInternal d() {
            String str = "";
            if (this.f22475a == null) {
                str = str + " transportName";
            }
            if (this.f22477c == null) {
                str = str + " encodedPayload";
            }
            if (this.f22478d == null) {
                str = str + " eventMillis";
            }
            if (this.f22479e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f22480f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.f22475a, this.f22476b, this.f22477c, this.f22478d.longValue(), this.f22479e.longValue(), this.f22480f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> e() {
            Map<String, String> map = this.f22480f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public EventInternal.Builder f(Map<String, String> map) {
            if (map != null) {
                this.f22480f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public EventInternal.Builder g(Integer num) {
            this.f22476b = num;
            return this;
        }

        public EventInternal.Builder h(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f22477c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public EventInternal.Builder i(long j2) {
            this.f22478d = Long.valueOf(j2);
            return this;
        }

        public EventInternal.Builder j(String str) {
            if (str != null) {
                this.f22475a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public EventInternal.Builder k(long j2) {
            this.f22479e = Long.valueOf(j2);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        return this.f22474f;
    }

    public Integer d() {
        return this.f22470b;
    }

    public EncodedPayload e() {
        return this.f22471c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (!this.f22469a.equals(eventInternal.j()) || ((num = this.f22470b) != null ? !num.equals(eventInternal.d()) : eventInternal.d() != null) || !this.f22471c.equals(eventInternal.e()) || this.f22472d != eventInternal.f() || this.f22473e != eventInternal.k() || !this.f22474f.equals(eventInternal.c())) {
            return false;
        }
        return true;
    }

    public long f() {
        return this.f22472d;
    }

    public int hashCode() {
        int i2;
        int hashCode = (this.f22469a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f22470b;
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.hashCode();
        }
        long j2 = this.f22472d;
        long j3 = this.f22473e;
        return ((((((((hashCode ^ i2) * 1000003) ^ this.f22471c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f22474f.hashCode();
    }

    public String j() {
        return this.f22469a;
    }

    public long k() {
        return this.f22473e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f22469a + ", code=" + this.f22470b + ", encodedPayload=" + this.f22471c + ", eventMillis=" + this.f22472d + ", uptimeMillis=" + this.f22473e + ", autoMetadata=" + this.f22474f + "}";
    }

    private AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j2, long j3, Map<String, String> map) {
        this.f22469a = str;
        this.f22470b = num;
        this.f22471c = encodedPayload;
        this.f22472d = j2;
        this.f22473e = j3;
        this.f22474f = map;
    }
}
