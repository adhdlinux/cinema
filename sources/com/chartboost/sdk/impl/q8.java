package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.Log;
import com.chartboost.sdk.R;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
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

public final class q8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18433a;

    /* renamed from: b  reason: collision with root package name */
    public final va f18434b;

    /* renamed from: c  reason: collision with root package name */
    public final fa f18435c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f18436d;

    /* renamed from: e  reason: collision with root package name */
    public final CoroutineDispatcher f18437e;

    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q8 f18439c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q8 q8Var, Continuation continuation) {
            super(2, continuation);
            this.f18439c = q8Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f18439c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.f18438b == 0) {
                ResultKt.b(obj);
                try {
                    l8.a(this.f18439c.f18433a);
                    String a2 = r8.f18515a;
                    Intrinsics.e(a2, "TAG");
                    w7.a(a2, "OMSDK is initialized successfully!");
                } catch (Exception e2) {
                    String a3 = r8.f18515a;
                    Intrinsics.e(a3, "TAG");
                    w7.b(a3, "OMSDK initialization exception: " + e2);
                }
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public q8(Context context, va vaVar, fa faVar, AtomicReference atomicReference, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(context, "context");
        Intrinsics.f(vaVar, "sharedPrefsHelper");
        Intrinsics.f(faVar, "resourcesLoader");
        Intrinsics.f(atomicReference, "sdkConfig");
        Intrinsics.f(coroutineDispatcher, "mainDispatcher");
        this.f18433a = context;
        this.f18434b = vaVar;
        this.f18435c = faVar;
        this.f18436d = atomicReference;
        this.f18437e = coroutineDispatcher;
    }

    public final j8 b() {
        pa paVar = (pa) this.f18436d.get();
        j8 b2 = paVar != null ? paVar.b() : null;
        return b2 == null ? new j8(false, false, 0, 0, 0, 0, (List) null, 127, (DefaultConstructorMarker) null) : b2;
    }

    public final e9 c() {
        try {
            return e9.a(i(), "9.7.0");
        } catch (Exception e2) {
            String a2 = r8.f18515a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Omid Partner exception: " + e2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = (r0 = r0.b()).e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List d() {
        /*
            r1 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r1.f18436d
            java.lang.Object r0 = r0.get()
            com.chartboost.sdk.impl.pa r0 = (com.chartboost.sdk.impl.pa) r0
            if (r0 == 0) goto L_0x0016
            com.chartboost.sdk.impl.j8 r0 = r0.b()
            if (r0 == 0) goto L_0x0016
            java.util.List r0 = r0.e()
            if (r0 != 0) goto L_0x001a
        L_0x0016:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.f()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.q8.d():java.util.List");
    }

    public final void e() {
        if (!g()) {
            String a2 = r8.f18515a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "OMSDK initialize is disabled by the cb config!");
        } else if (f()) {
            String a3 = r8.f18515a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "OMSDK initialize is already active!");
        } else {
            try {
                Job unused = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f18437e), (CoroutineContext) null, (CoroutineStart) null, new a(this, (Continuation) null), 3, (Object) null);
            } catch (Exception e2) {
                String a4 = r8.f18515a;
                Log.e(a4, "Error launching om activate job: " + e2);
            }
        }
    }

    public final boolean f() {
        try {
            return l8.b();
        } catch (Exception e2) {
            String a2 = r8.f18515a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "OMSDK error when checking isActive: " + e2);
            return false;
        }
    }

    public final boolean g() {
        j8 b2;
        pa paVar = (pa) this.f18436d.get();
        if (paVar == null || (b2 = paVar.b()) == null) {
            return false;
        }
        return b2.g();
    }

    public final boolean h() {
        j8 b2;
        pa paVar = (pa) this.f18436d.get();
        if (paVar == null || (b2 = paVar.b()) == null) {
            return false;
        }
        return b2.d();
    }

    public final String i() {
        return "Chartboost";
    }

    public final String a(String str) {
        Intrinsics.f(str, "html");
        if (!g()) {
            String a2 = r8.f18515a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "OMSDK injectOmidJsIntoHtml is disabled by the cb config!");
            return str;
        } else if (!l8.b()) {
            return str;
        } else {
            try {
                String a3 = na.a(a(), str);
                Intrinsics.e(a3, "{\n            ScriptInje…kJsLib(), html)\n        }");
                return a3;
            } catch (Exception e2) {
                String a4 = r8.f18515a;
                Intrinsics.e(a4, "TAG");
                w7.b(a4, "OmidJS injection exception: " + e2);
                return str;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q8(Context context, va vaVar, fa faVar, AtomicReference atomicReference, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, vaVar, faVar, atomicReference, (i2 & 16) != 0 ? Dispatchers.c() : coroutineDispatcher);
    }

    public final String a() {
        return a(R.raw.omsdk_v1, "com.chartboost.sdk.omidjs");
    }

    public final String a(int i2, String str) {
        try {
            String a2 = this.f18434b.a(str);
            if (a2 == null) {
                return a(str, i2);
            }
            return a2;
        } catch (Exception e2) {
            String a3 = r8.f18515a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "OmidJS exception: " + e2);
            return null;
        }
    }

    public final String a(String str, int i2) {
        try {
            String a2 = this.f18435c.a(i2);
            if (a2 == null) {
                return null;
            }
            this.f18434b.a(str, a2);
            return a2;
        } catch (Exception e2) {
            String a3 = r8.f18515a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "OmidJS resource file exception: " + e2);
            return null;
        }
    }
}
