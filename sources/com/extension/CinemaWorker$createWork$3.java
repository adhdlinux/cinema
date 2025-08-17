package com.extension;

import androidx.work.ListenableWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$createWork$3 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$createWork$3 f19374f = new CinemaWorker$createWork$3();

    CinemaWorker$createWork$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        th.printStackTrace();
        ListenableWorker.Result.a();
    }
}
