package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import b0.c0;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.security.ProviderInstaller;
import kotlin.jvm.internal.Intrinsics;

public final class o9 implements ProviderInstaller.ProviderInstallListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18296a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f18297b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18298c = o9.class.getSimpleName();

    public o9(Context context, Handler handler) {
        Intrinsics.f(context, "context");
        Intrinsics.f(handler, "uiHandler");
        this.f18296a = context;
        this.f18297b = handler;
    }

    public final void a() {
        if (b()) {
            this.f18297b.post(new c0(this));
        }
    }

    public final boolean b() {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.f18296a) != 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            String str = this.f18298c;
            Intrinsics.e(str, "TAG");
            w7.e(str, "GoogleApiAvailability error " + e2);
            return false;
        }
    }

    public void onProviderInstallFailed(int i2, Intent intent) {
        String str = this.f18298c;
        Intrinsics.e(str, "TAG");
        w7.e(str, "ProviderInstaller onProviderInstallFailed: " + i2 + " ProviderInstaller is unable to install an updated Provider, your device's security provider might be vulnerable to known exploits. Your app should behave as if all HTTP communication is unencrypted.");
    }

    public void onProviderInstalled() {
        String str = this.f18298c;
        Intrinsics.e(str, "TAG");
        w7.c(str, "ProviderInstaller onProviderInstalled");
    }

    public static final void a(o9 o9Var) {
        Intrinsics.f(o9Var, "this$0");
        try {
            ProviderInstaller.installIfNeededAsync(o9Var.f18296a, o9Var);
        } catch (Exception e2) {
            String str = o9Var.f18298c;
            Intrinsics.e(str, "TAG");
            w7.e(str, "ProviderInstaller " + e2);
        }
    }
}
