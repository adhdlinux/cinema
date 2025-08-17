package com.chartboost.sdk.impl;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17261a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f17262b;

    /* renamed from: c  reason: collision with root package name */
    public final g6 f17263c;

    /* renamed from: d  reason: collision with root package name */
    public final q1 f17264d;

    /* renamed from: e  reason: collision with root package name */
    public final CoroutineDispatcher f17265e;

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f17266f;

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f17267g;

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f17268h;

    /* renamed from: i  reason: collision with root package name */
    public volatile Job f17269i;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17270b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final AtomicReference invoke() {
            return new AtomicReference((Object) null);
        }
    }

    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f17271b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b2 f17272c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b2 b2Var, Continuation continuation) {
            super(2, continuation);
            this.f17272c = b2Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f17272c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.f17271b == 0) {
                ResultKt.b(obj);
                this.f17272c.b();
                this.f17272c.f17269i = null;
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b2 f17273b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b2 b2Var) {
            super(1);
            this.f17273b = b2Var;
        }

        public final void a(AppSetIdInfo appSetIdInfo) {
            this.f17273b.a(appSetIdInfo);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AppSetIdInfo) obj);
            return Unit.f40298a;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final d f17274b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final AtomicReference invoke() {
            return new AtomicReference((Object) null);
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final e f17275b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final AtomicInteger invoke() {
            return new AtomicInteger();
        }
    }

    public b2(Context context, y0 y0Var, g6 g6Var, q1 q1Var, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(context, "context");
        Intrinsics.f(y0Var, "android");
        Intrinsics.f(g6Var, "ifa");
        Intrinsics.f(q1Var, "base64Wrapper");
        Intrinsics.f(coroutineDispatcher, "ioDispatcher");
        this.f17261a = context;
        this.f17262b = y0Var;
        this.f17263c = g6Var;
        this.f17264d = q1Var;
        this.f17265e = coroutineDispatcher;
        this.f17266f = LazyKt__LazyJVMKt.b(d.f17274b);
        this.f17267g = LazyKt__LazyJVMKt.b(e.f17275b);
        this.f17268h = LazyKt__LazyJVMKt.b(a.f17270b);
        f();
    }

    public final boolean a() {
        return true;
    }

    public final void b() {
        g();
        c().set(a(this.f17261a));
    }

    public final AtomicReference c() {
        return (AtomicReference) this.f17268h.getValue();
    }

    public final AtomicReference d() {
        return (AtomicReference) this.f17266f.getValue();
    }

    public final AtomicInteger e() {
        return (AtomicInteger) this.f17267g.getValue();
    }

    public final void f() {
        try {
            this.f17269i = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f17265e), (CoroutineContext) null, (CoroutineStart) null, new b(this, (Continuation) null), 3, (Object) null);
        } catch (Throwable th) {
            String a2 = c2.f17319a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Error launching identity job: " + th);
        }
    }

    public final void g() {
        try {
            if (a()) {
                Task a2 = this.f17262b.a(this.f17261a);
                if (a2 != null) {
                    a2.addOnSuccessListener(new b0.a(new c(this)));
                    return;
                }
                return;
            }
            String a3 = c2.f17319a;
            Intrinsics.e(a3, "TAG");
            w7.e(a3, "AppSetId dependency not present");
        } catch (Exception e2) {
            String a4 = c2.f17319a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "Error requesting AppSetId: " + e2);
        }
    }

    public final i6 h() {
        if (this.f17269i == null) {
            f();
            Unit unit = Unit.f40298a;
        }
        i6 i6Var = (i6) c().get();
        if (i6Var == null) {
            return a(this.f17261a);
        }
        return i6Var;
    }

    public static final void a(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final i6 a(Context context) {
        try {
            u0 a2 = this.f17263c.a();
            String a3 = c2.f17319a;
            Intrinsics.e(a3, "TAG");
            w7.c(a3, "IFA: " + a2);
            String a4 = a2.a();
            yb b2 = a2.b();
            String a5 = this.f17263c.a(context, b2 == yb.TRACKING_LIMITED);
            if (a4 != null) {
                a5 = "000000000";
            }
            String str = a5;
            if (la.f18112a.g()) {
                la.b(a4);
                la.c(str);
            }
            return new i6(b2, a(a4, str), str, a4, (String) d().get(), Integer.valueOf(e().get()));
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null) {
                String a6 = c2.f17319a;
                Intrinsics.e(a6, "TAG");
                w7.b(a6, message);
            }
            return new i6((yb) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b2(Context context, y0 y0Var, g6 g6Var, q1 q1Var, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, y0Var, g6Var, q1Var, (i2 & 16) != 0 ? Dispatchers.b() : coroutineDispatcher);
    }

    public final String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            h2.a(jSONObject, "gaid", str);
        } else if (str2 != null) {
            h2.a(jSONObject, "uuid", str2);
        }
        String str3 = (String) d().get();
        if (str3 != null) {
            h2.a(jSONObject, "appsetid", str3);
        }
        q1 q1Var = this.f17264d;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.e(jSONObject2, "obj.toString()");
        return q1Var.c(jSONObject2);
    }

    public final void a(AppSetIdInfo appSetIdInfo) {
        if (appSetIdInfo != null) {
            d().set(appSetIdInfo.getId());
            e().set(appSetIdInfo.getScope());
        }
    }
}
