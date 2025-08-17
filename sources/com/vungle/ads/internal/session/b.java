package com.vungle.ads.internal.session;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnclosedAdDetector f37917b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37918c;

    public /* synthetic */ b(UnclosedAdDetector unclosedAdDetector, String str) {
        this.f37917b = unclosedAdDetector;
        this.f37918c = str;
    }

    public final void run() {
        UnclosedAdDetector.m206writeUnclosedAdToFile$lambda3(this.f37917b, this.f37918c);
    }
}
