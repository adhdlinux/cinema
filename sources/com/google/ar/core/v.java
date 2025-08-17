package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;

final class v {

    /* renamed from: a  reason: collision with root package name */
    boolean f30359a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ InstallActivity f30360b;

    v(InstallActivity installActivity) {
        this.f30360b = installActivity;
    }

    public final void a(w wVar) {
        synchronized (this.f30360b) {
            if (!this.f30359a) {
                this.f30360b.f(wVar);
                w wVar2 = w.ACCEPTED;
                ArCoreApk.UserMessageType userMessageType = ArCoreApk.UserMessageType.APPLICATION;
                ArCoreApk.Availability availability = ArCoreApk.Availability.UNKNOWN_ERROR;
                int ordinal = wVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        this.f30360b.c(new UnavailableUserDeclinedInstallationException());
                    } else if (ordinal == 2) {
                        if (!this.f30360b.g() && k.a().f30332d) {
                            this.f30360b.e();
                        }
                        this.f30360b.c((Exception) null);
                    }
                    this.f30359a = true;
                }
            }
        }
    }

    public final void b(Exception exc) {
        synchronized (this.f30360b) {
            if (!this.f30359a) {
                this.f30359a = true;
                this.f30360b.f(w.CANCELLED);
                this.f30360b.c(exc);
            }
        }
    }
}
