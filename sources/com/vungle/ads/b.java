package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.LogEntry;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Sdk$SDKError.Reason f37825b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37826c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LogEntry f37827d;

    public /* synthetic */ b(Sdk$SDKError.Reason reason, String str, LogEntry logEntry) {
        this.f37825b = reason;
        this.f37826c = str;
        this.f37827d = logEntry;
    }

    public final void run() {
        AnalyticsClient.m115logError$lambda2(this.f37825b, this.f37826c, this.f37827d);
    }
}
