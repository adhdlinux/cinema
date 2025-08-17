package com.extension;

import androidx.work.ListenableWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CinemaWorker$createWork$4 extends Lambda implements Function1<ListenableWorker.Result, Unit> {

    /* renamed from: f  reason: collision with root package name */
    public static final CinemaWorker$createWork$4 f19375f = new CinemaWorker$createWork$4();

    CinemaWorker$createWork$4() {
        super(1);
    }

    public final void a(ListenableWorker.Result result) {
        ListenableWorker.Result.c();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ListenableWorker.Result) obj);
        return Unit.f40298a;
    }
}
