package com.vungle.ads.internal.protos;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface Sdk$MetricBatchOrBuilder extends MessageLiteOrBuilder {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    Sdk$SDKMetric getMetrics(int i2);

    int getMetricsCount();

    List<Sdk$SDKMetric> getMetricsList();

    /* synthetic */ boolean isInitialized();
}
