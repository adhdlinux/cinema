package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.zc;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class ad implements zc {

    /* renamed from: a  reason: collision with root package name */
    public final t0 f17239a;

    /* renamed from: b  reason: collision with root package name */
    public final zc.b f17240b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f17241c;

    /* renamed from: d  reason: collision with root package name */
    public Job f17242d;

    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f17243b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17244c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ad f17245d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(long j2, ad adVar, Continuation continuation) {
            super(2, continuation);
            this.f17244c = j2;
            this.f17245d = adVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f17244c, this.f17245d, continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[RETURN] */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
                int r1 = r5.f17243b
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                kotlin.ResultKt.b(r6)
                r6 = r5
                goto L_0x0027
            L_0x0010:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0018:
                kotlin.ResultKt.b(r6)
                r6 = r5
            L_0x001c:
                long r3 = r6.f17244c
                r6.f17243b = r2
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.a(r3, r6)
                if (r1 != r0) goto L_0x0027
                return r0
            L_0x0027:
                com.chartboost.sdk.impl.ad r1 = r6.f17245d
                com.chartboost.sdk.impl.t0 r1 = r1.f17239a
                if (r1 == 0) goto L_0x001c
                com.chartboost.sdk.impl.ad r3 = r6.f17245d
                com.chartboost.sdk.impl.zc$b r3 = r3.f17240b
                long r3 = r3.d()
                r1.a((long) r3)
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ad.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ad(t0 t0Var, zc.b bVar, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(bVar, "videoProgress");
        Intrinsics.f(coroutineDispatcher, "coroutineDispatcher");
        this.f17239a = t0Var;
        this.f17240b = bVar;
        this.f17241c = coroutineDispatcher;
    }

    public void a(long j2) {
        String a2 = bd.f17303a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "startProgressUpdate()");
        if (this.f17242d == null) {
            this.f17242d = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f17241c), (CoroutineContext) null, (CoroutineStart) null, new a(j2, this, (Continuation) null), 3, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(t0 t0Var, zc.b bVar, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : t0Var, bVar, (i2 & 4) != 0 ? Dispatchers.c() : coroutineDispatcher);
    }

    public void a() {
        String a2 = bd.f17303a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "stopProgressUpdate()");
        Job job = this.f17242d;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f17242d = null;
    }
}
