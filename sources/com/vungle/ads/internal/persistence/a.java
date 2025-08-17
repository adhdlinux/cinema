package com.vungle.ads.internal.persistence;

import java.io.Serializable;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilePreferences f37900b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Serializable f37901c;

    public /* synthetic */ a(FilePreferences filePreferences, Serializable serializable) {
        this.f37900b = filePreferences;
        this.f37901c = serializable;
    }

    public final void run() {
        FilePreferences.m194apply$lambda0(this.f37900b, this.f37901c);
    }
}
