package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LogSourceMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final LogSourceMetrics f22594c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f22595a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogEventDropped> f22596b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f22597a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<LogEventDropped> f22598b = new ArrayList();

        Builder() {
        }

        public LogSourceMetrics a() {
            return new LogSourceMetrics(this.f22597a, Collections.unmodifiableList(this.f22598b));
        }

        public Builder b(List<LogEventDropped> list) {
            this.f22598b = list;
            return this;
        }

        public Builder c(String str) {
            this.f22597a = str;
            return this;
        }
    }

    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.f22595a = str;
        this.f22596b = list;
    }

    public static Builder c() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public List<LogEventDropped> a() {
        return this.f22596b;
    }

    @Protobuf(tag = 1)
    public String b() {
        return this.f22595a;
    }
}
