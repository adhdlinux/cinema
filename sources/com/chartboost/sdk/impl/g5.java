package com.chartboost.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class g5 implements f5 {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f17741a = LazyKt__LazyJVMKt.b(b.f17744b);

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f17742b = LazyKt__LazyJVMKt.b(a.f17743b);

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17743b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final ScheduledExecutorService invoke() {
            return t1.a();
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17744b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final ExecutorService invoke() {
            return t1.a(4);
        }
    }

    public ScheduledExecutorService a() {
        Object value = this.f17742b.getValue();
        Intrinsics.e(value, "<get-backgroundExecutor>(...)");
        return (ScheduledExecutorService) value;
    }

    public ExecutorService b() {
        Object value = this.f17741a.getValue();
        Intrinsics.e(value, "<get-networkExecutor>(...)");
        return (ExecutorService) value;
    }
}
