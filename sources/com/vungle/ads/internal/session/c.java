package com.vungle.ads.internal.session;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnclosedAdDetector f37919b;

    public /* synthetic */ c(UnclosedAdDetector unclosedAdDetector) {
        this.f37919b = unclosedAdDetector;
    }

    public final Object call() {
        return UnclosedAdDetector.m204readUnclosedAdFromFile$lambda2(this.f37919b);
    }
}
