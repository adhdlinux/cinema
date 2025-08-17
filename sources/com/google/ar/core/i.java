package com.google.ar.core;

import com.google.ar.core.ArCoreApk;

final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f30325a;

    i(k kVar) {
        this.f30325a = kVar;
    }

    public final void a(ArCoreApk.Availability availability) {
        synchronized (this.f30325a) {
            this.f30325a.f(availability);
            this.f30325a.g();
        }
    }
}
