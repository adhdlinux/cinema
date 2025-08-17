package com.startapp;

import android.content.Context;
import com.startapp.sdk.components.ComponentLocator;

public final class m6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34902b;

    public m6(Context context, String str) {
        this.f34901a = context;
        this.f34902b = str;
    }

    public void run() {
        w8 j2;
        h7 h7Var = new h7();
        try {
            h7Var.K = ComponentLocator.a(this.f34901a).p().a((Object) h7Var);
        } catch (Throwable th) {
            y8.a(this.f34901a, th);
        }
        try {
            j2 = ComponentLocator.a(this.f34901a).j();
            String str = this.f34902b;
            j2.getClass();
            j2.a(str, h7Var, (sa<String, Void>) null);
        } catch (Throwable th2) {
            y8.a(this.f34901a, th2);
        }
    }
}
