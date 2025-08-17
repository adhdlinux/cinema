package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.r  reason: case insensitive filesystem */
final class C0061r implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f30351a;

    C0061r(AtomicReference atomicReference) {
        this.f30351a = atomicReference;
    }

    public final void a(ArCoreApk.Availability availability) {
        this.f30351a.set(availability);
    }
}
