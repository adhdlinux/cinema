package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class tc {

    /* renamed from: a  reason: collision with root package name */
    public final b f18715a;

    /* renamed from: b  reason: collision with root package name */
    public float f18716b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f18717c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f18718d;

    /* renamed from: e  reason: collision with root package name */
    public long f18719e;

    /* renamed from: f  reason: collision with root package name */
    public long f18720f;

    /* renamed from: g  reason: collision with root package name */
    public Job f18721g;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18722b = new a();

        public a() {
            super(3, uc.class, "createRandomAccessFile", "createRandomAccessFile(Lcom/chartboost/sdk/internal/video/VideoAsset;Lcom/chartboost/sdk/internal/video/TempFileDownloadHelper;Lcom/chartboost/sdk/internal/Libraries/FileCache;)Lcom/chartboost/sdk/internal/utils/RandomAccessFileWrapper;", 1);
        }

        /* renamed from: a */
        public final s9 invoke(rc rcVar, cb cbVar, v5 v5Var) {
            Intrinsics.f(rcVar, "p0");
            Intrinsics.f(cbVar, "p1");
            return uc.b(rcVar, cbVar, v5Var);
        }
    }

    public interface b {
        void c();
    }

    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ tc f18724c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(tc tcVar, Continuation continuation) {
            super(2, continuation);
            this.f18724c = tcVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f18724c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18723b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f18723b = 1;
                if (DelayKt.a(1500, this) == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f18724c.b();
            return Unit.f40298a;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Function3 f18725b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ rc f18726c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ cb f18727d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v5 f18728e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function3 function3, rc rcVar, cb cbVar, v5 v5Var) {
            super(0);
            this.f18725b = function3;
            this.f18726c = rcVar;
            this.f18727d = cbVar;
            this.f18728e = v5Var;
        }

        /* renamed from: a */
        public final s9 invoke() {
            return (s9) this.f18725b.invoke(this.f18726c, this.f18727d, this.f18728e);
        }
    }

    public tc(rc rcVar, b bVar, float f2, cb cbVar, v5 v5Var, CoroutineDispatcher coroutineDispatcher, Function3 function3) {
        Intrinsics.f(rcVar, "videoAsset");
        Intrinsics.f(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.f(cbVar, "tempHelper");
        Intrinsics.f(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.f(function3, "randomAccessFileFactory");
        this.f18715a = bVar;
        this.f18716b = f2;
        this.f18717c = coroutineDispatcher;
        this.f18718d = LazyKt__LazyJVMKt.b(new d(function3, rcVar, cbVar, v5Var));
        this.f18719e = rcVar.c();
    }

    public final void b() {
        long j2;
        s9 d2 = d();
        if (d2 != null) {
            j2 = d2.c();
        } else {
            j2 = 0;
        }
        long j3 = this.f18719e;
        if (j2 == j3) {
            f();
        } else if (((float) (j2 - this.f18720f)) / ((float) j3) > this.f18716b) {
            f();
        } else {
            c();
        }
    }

    public final void c() {
        this.f18721g = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f18717c), (CoroutineContext) null, (CoroutineStart) null, new c(this, (Continuation) null), 3, (Object) null);
    }

    public final s9 d() {
        return (s9) this.f18718d.getValue();
    }

    public final void e() {
        Job job = this.f18721g;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f18721g = null;
    }

    public final void f() {
        this.f18720f = 0;
        e();
        this.f18715a.c();
    }

    public final void a() {
        long j2 = 0;
        if (this.f18720f == 0) {
            s9 d2 = d();
            if (d2 != null) {
                j2 = d2.c();
            }
            this.f18720f = j2;
        }
    }

    public final void a(int i2) {
        long j2 = this.f18719e;
        if (j2 > 0 && i2 > 0) {
            float f2 = ((float) j2) / 1000000.0f;
            this.f18716b = ((f2 / 1000.0f) / ((((float) i2) / 60000.0f) * 0.0075f)) / (f2 * ((float) 8));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tc(rc rcVar, b bVar, float f2, cb cbVar, v5 v5Var, CoroutineDispatcher coroutineDispatcher, Function3 function3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(rcVar, bVar, (i2 & 4) != 0 ? 0.01f : f2, (i2 & 8) != 0 ? new cb() : cbVar, v5Var, (i2 & 32) != 0 ? Dispatchers.c() : coroutineDispatcher, (i2 & 64) != 0 ? a.f18722b : function3);
    }
}
