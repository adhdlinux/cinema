package com.vungle.ads.internal.network;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TpatSender f37897b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37898c;

    public /* synthetic */ c(TpatSender tpatSender, String str) {
        this.f37897b = tpatSender;
        this.f37898c = str;
    }

    public final void run() {
        TpatSender.m191sendWinNotification$lambda0(this.f37897b, this.f37898c);
    }
}
