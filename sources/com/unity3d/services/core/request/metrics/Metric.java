package com.unity3d.services.core.request.metrics;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Metric {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String METRIC_NAME = "n";
    private static final String METRIC_TAGS = "t";
    private static final String METRIC_VALUE = "v";
    private final String name;
    private final Map<String, String> tags;
    private final Object value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Metric(String str) {
        this(str, (Object) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }

    public Metric(String str, Object obj) {
        this(str, obj, (Map) null, 4, (DefaultConstructorMarker) null);
    }

    public Metric(String str, Object obj, Map<String, String> map) {
        Intrinsics.f(map, "tags");
        this.name = str;
        this.value = obj;
        this.tags = map;
    }

    public static /* synthetic */ Metric copy$default(Metric metric, String str, Object obj, Map<String, String> map, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = metric.name;
        }
        if ((i2 & 2) != 0) {
            obj = metric.value;
        }
        if ((i2 & 4) != 0) {
            map = metric.tags;
        }
        return metric.copy(str, obj, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final Metric copy(String str, Object obj, Map<String, String> map) {
        Intrinsics.f(map, "tags");
        return new Metric(str, obj, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        return Intrinsics.a(this.name, metric.name) && Intrinsics.a(this.value, metric.value) && Intrinsics.a(this.tags, metric.tags);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.value;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return ((hashCode + i2) * 31) + this.tags.hashCode();
    }

    public final Map<String, Object> toMap() {
        Map c2 = MapsKt__MapsJVMKt.c();
        String str = this.name;
        if (str != null) {
            c2.put(METRIC_NAME, str);
        }
        Object obj = this.value;
        if (obj != null) {
            c2.put(METRIC_VALUE, obj);
        }
        if (!this.tags.isEmpty()) {
            c2.put(METRIC_TAGS, this.tags);
        }
        return MapsKt__MapsJVMKt.b(c2);
    }

    public String toString() {
        return "Metric(name=" + this.name + ", value=" + this.value + ", tags=" + this.tags + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Metric(String str, Object obj, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? MapsKt__MapsKt.g() : map);
    }
}
