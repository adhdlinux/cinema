package com.google.ar.core;

import android.view.View;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

final class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ InstallActivity f30352b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f30353c;

    s(InstallActivity installActivity, int i2) {
        this.f30353c = i2;
        this.f30352b = installActivity;
    }

    public final void onClick(View view) {
        if (this.f30353c != 0) {
            this.f30352b.c(new UnavailableUserDeclinedInstallationException());
            return;
        }
        this.f30352b.b();
        this.f30352b.d();
    }
}
