package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.LogEntry;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Sdk$SDKMetric.SDKMetricType f37829b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f37830c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LogEntry f37831d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f37832e;

    public /* synthetic */ d(Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str) {
        this.f37829b = sDKMetricType;
        this.f37830c = j2;
        this.f37831d = logEntry;
        this.f37832e = str;
    }

    public final void run() {
        AnalyticsClient.m116logMetric$lambda3(this.f37829b, this.f37830c, this.f37831d, this.f37832e);
    }
}
