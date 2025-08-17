package com.vungle.ads.internal.network;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TpatSender f37889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GenericTpatRequest f37891d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f37892e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f37893f;

    public /* synthetic */ a(TpatSender tpatSender, String str, GenericTpatRequest genericTpatRequest, String str2, boolean z2) {
        this.f37889b = tpatSender;
        this.f37890c = str;
        this.f37891d = genericTpatRequest;
        this.f37892e = str2;
        this.f37893f = z2;
    }

    public final void run() {
        TpatSender.m189sendGenericTpat$lambda3(this.f37889b, this.f37890c, this.f37891d, this.f37892e, this.f37893f);
    }
}
