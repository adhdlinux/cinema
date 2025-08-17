package com.vungle.ads.internal.network;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TpatSender f37894b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37895c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37896d;

    public /* synthetic */ b(TpatSender tpatSender, String str, String str2) {
        this.f37894b = tpatSender;
        this.f37895c = str;
        this.f37896d = str2;
    }

    public final void run() {
        TpatSender.m190sendTpat$lambda2(this.f37894b, this.f37895c, this.f37896d);
    }
}
