package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MetricsContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String METRICS_CONTAINER = "m";
    private static final String METRICS_CONTAINER_TAGS = "t";
    private static final String METRIC_CONTAINER_API_LEVEL = "apil";
    private static final String METRIC_CONTAINER_DEVICE_MAKE = "deviceMake";
    private static final String METRIC_CONTAINER_DEVICE_MODEL = "deviceModel";
    private static final String METRIC_CONTAINER_DEVICE_NAME = "deviceName";
    private static final String METRIC_CONTAINER_GAME_ID = "gameId";
    private static final String METRIC_CONTAINER_SAMPLE_RATE = "msr";
    private static final String METRIC_CONTAINER_SESSION_TOKEN = "sTkn";
    private static final String METRIC_CONTAINER_SHARED_SESSION_ID = "shSid";
    private final String apiLevel = String.valueOf(Device.getApiLevel());
    private final MetricCommonTags commonTags;
    private final String deviceManufacturer = Device.getManufacturer();
    private final String deviceModel = Device.getModel();
    private final String deviceName = Device.getDevice();
    private final String gameId = ClientProperties.getGameId();
    private final String metricSampleRate;
    private final List<Metric> metrics;
    private final String sTkn;
    private final String shSid = Session.Default.getId();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MetricsContainer(String str, MetricCommonTags metricCommonTags, List<Metric> list, String str2) {
        Intrinsics.f(str, "metricSampleRate");
        Intrinsics.f(metricCommonTags, "commonTags");
        Intrinsics.f(list, "metrics");
        this.metricSampleRate = str;
        this.commonTags = metricCommonTags;
        this.metrics = list;
        this.sTkn = str2;
    }

    public final Map<String, Object> toMap() {
        Iterable<Metric> iterable = this.metrics;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
        for (Metric map : iterable) {
            arrayList.add(map.toMap());
        }
        Map c2 = MapsKt__MapsJVMKt.c();
        c2.put(METRIC_CONTAINER_SAMPLE_RATE, this.metricSampleRate);
        c2.put(METRICS_CONTAINER, arrayList);
        c2.put(METRICS_CONTAINER_TAGS, this.commonTags.toMap());
        c2.put(METRIC_CONTAINER_SHARED_SESSION_ID, this.shSid);
        c2.put(METRIC_CONTAINER_API_LEVEL, this.apiLevel);
        String str = this.sTkn;
        if (str != null) {
            c2.put(METRIC_CONTAINER_SESSION_TOKEN, str);
        }
        String str2 = this.deviceModel;
        if (str2 != null) {
            Intrinsics.e(str2, METRIC_CONTAINER_DEVICE_MODEL);
            c2.put(METRIC_CONTAINER_DEVICE_MODEL, str2);
        }
        String str3 = this.deviceName;
        if (str3 != null) {
            Intrinsics.e(str3, METRIC_CONTAINER_DEVICE_NAME);
            c2.put(METRIC_CONTAINER_DEVICE_NAME, str3);
        }
        String str4 = this.deviceManufacturer;
        if (str4 != null) {
            Intrinsics.e(str4, "deviceManufacturer");
            c2.put(METRIC_CONTAINER_DEVICE_MAKE, str4);
        }
        String str5 = this.gameId;
        if (str5 != null) {
            Intrinsics.e(str5, METRIC_CONTAINER_GAME_ID);
            c2.put(METRIC_CONTAINER_GAME_ID, str5);
        }
        return MapsKt__MapsJVMKt.b(c2);
    }
}
