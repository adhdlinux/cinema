package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientMetrics {

    /* renamed from: e  reason: collision with root package name */
    private static final ClientMetrics f22568e = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    private final TimeWindow f22569a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogSourceMetrics> f22570b;

    /* renamed from: c  reason: collision with root package name */
    private final GlobalMetrics f22571c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22572d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private TimeWindow f22573a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<LogSourceMetrics> f22574b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private GlobalMetrics f22575c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f22576d = "";

        Builder() {
        }

        public Builder a(LogSourceMetrics logSourceMetrics) {
            this.f22574b.add(logSourceMetrics);
            return this;
        }

        public ClientMetrics b() {
            return new ClientMetrics(this.f22573a, Collections.unmodifiableList(this.f22574b), this.f22575c, this.f22576d);
        }

        public Builder c(String str) {
            this.f22576d = str;
            return this;
        }

        public Builder d(GlobalMetrics globalMetrics) {
            this.f22575c = globalMetrics;
            return this;
        }

        public Builder e(TimeWindow timeWindow) {
            this.f22573a = timeWindow;
            return this;
        }
    }

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.f22569a = timeWindow;
        this.f22570b = list;
        this.f22571c = globalMetrics;
        this.f22572d = str;
    }

    public static Builder e() {
        return new Builder();
    }

    @Protobuf(tag = 4)
    public String a() {
        return this.f22572d;
    }

    @Protobuf(tag = 3)
    public GlobalMetrics b() {
        return this.f22571c;
    }

    @Protobuf(tag = 2)
    public List<LogSourceMetrics> c() {
        return this.f22570b;
    }

    @Protobuf(tag = 1)
    public TimeWindow d() {
        return this.f22569a;
    }

    public byte[] f() {
        return ProtoEncoderDoNotUse.a(this);
    }
}
