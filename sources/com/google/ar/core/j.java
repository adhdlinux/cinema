package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.function.Consumer;

final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Consumer f30326a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f30327b;

    j(k kVar, Consumer consumer) {
        this.f30327b = kVar;
        this.f30326a = consumer;
    }

    public final void a(ArCoreApk.Availability availability) {
        this.f30327b.e().post(new al(this.f30326a, availability, 1));
    }
}
