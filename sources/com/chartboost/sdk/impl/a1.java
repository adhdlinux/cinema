package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.os.HandlerCompat;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class a1 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17167a;

    /* renamed from: b  reason: collision with root package name */
    public final Application f17168b;

    /* renamed from: c  reason: collision with root package name */
    public final Lazy f17169c = LazyKt__LazyJVMKt.b(new h(this));

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f17170d = LazyKt__LazyJVMKt.b(new j(this));

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f17171e = LazyKt__LazyJVMKt.b(a.f17182b);

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f17172f = LazyKt__LazyJVMKt.b(k.f17192b);

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f17173g = LazyKt__LazyJVMKt.b(new l(this));

    /* renamed from: h  reason: collision with root package name */
    public final Lazy f17174h = LazyKt__LazyJVMKt.b(b.f17183b);

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f17175i = LazyKt__LazyJVMKt.b(new g(this));

    /* renamed from: j  reason: collision with root package name */
    public final Lazy f17176j = LazyKt__LazyJVMKt.b(new i(this));

    /* renamed from: k  reason: collision with root package name */
    public final Lazy f17177k = LazyKt__LazyJVMKt.b(new m(this));

    /* renamed from: l  reason: collision with root package name */
    public final Lazy f17178l = LazyKt__LazyJVMKt.b(new f(this));

    /* renamed from: m  reason: collision with root package name */
    public final Lazy f17179m = LazyKt__LazyJVMKt.b(new e(this));

    /* renamed from: n  reason: collision with root package name */
    public final Lazy f17180n = LazyKt__LazyJVMKt.b(new d(this));

    /* renamed from: o  reason: collision with root package name */
    public final Lazy f17181o = LazyKt__LazyJVMKt.b(new c(this));

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17182b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final y0 invoke() {
            return y0.b();
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17183b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final q1 invoke() {
            return new q1();
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17184b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a1 a1Var) {
            super(0);
            this.f17184b = a1Var;
        }

        /* renamed from: a */
        public final ContentResolver invoke() {
            return this.f17184b.getContext().getContentResolver();
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17185b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a1 a1Var) {
            super(0);
            this.f17185b = a1Var;
        }

        /* renamed from: a */
        public final l4 invoke() {
            return new l4(this.f17185b.getContext());
        }
    }

    public static final class e extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17186b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a1 a1Var) {
            super(0);
            this.f17186b = a1Var;
        }

        /* renamed from: a */
        public final n4 invoke() {
            return new n4(this.f17186b.n(), this.f17186b.m(), (Function0) null, (DisplayMetrics) null, 12, (DefaultConstructorMarker) null);
        }
    }

    public static final class f extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17187b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a1 a1Var) {
            super(0);
            this.f17187b = a1Var;
        }

        /* renamed from: a */
        public final DisplayMetrics invoke() {
            return this.f17187b.getContext().getResources().getDisplayMetrics();
        }
    }

    public static final class g extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17188b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a1 a1Var) {
            super(0);
            this.f17188b = a1Var;
        }

        /* renamed from: a */
        public final fa invoke() {
            Resources resources = this.f17188b.getContext().getResources();
            Intrinsics.e(resources, "context.resources");
            return new fa(resources);
        }
    }

    public static final class h extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17189b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a1 a1Var) {
            super(0);
            this.f17189b = a1Var;
        }

        /* renamed from: a */
        public final SharedPreferences invoke() {
            return this.f17189b.getContext().getSharedPreferences("cbPrefs", 0);
        }
    }

    public static final class i extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17190b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a1 a1Var) {
            super(0);
            this.f17190b = a1Var;
        }

        /* renamed from: a */
        public final va invoke() {
            return new va(this.f17190b.f());
        }
    }

    public static final class j extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17191b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a1 a1Var) {
            super(0);
            this.f17191b = a1Var;
        }

        /* renamed from: a */
        public final SharedPreferences invoke() {
            return this.f17191b.getContext().getSharedPreferences("cbPrefsTracking", 0);
        }
    }

    public static final class k extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final k f17192b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            Handler a2 = HandlerCompat.a(Looper.getMainLooper());
            Intrinsics.e(a2, "createAsync(Looper.getMainLooper())");
            return a2;
        }
    }

    public static final class l extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17193b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(a1 a1Var) {
            super(0);
            this.f17193b = a1Var;
        }

        /* renamed from: a */
        public final cc invoke() {
            return new cc(this.f17193b.h());
        }
    }

    public static final class m extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f17194b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(a1 a1Var) {
            super(0);
            this.f17194b = a1Var;
        }

        /* renamed from: a */
        public final WindowManager invoke() {
            Object systemService = this.f17194b.getContext().getSystemService("window");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }
    }

    public a1(Context context, Application application) {
        Intrinsics.f(context, "context");
        Intrinsics.f(application, "app");
        this.f17167a = context;
        this.f17168b = application;
    }

    public q1 a() {
        return (q1) this.f17174h.getValue();
    }

    public Application b() {
        return this.f17168b;
    }

    public ContentResolver c() {
        Object value = this.f17181o.getValue();
        Intrinsics.e(value, "<get-contentResolver>(...)");
        return (ContentResolver) value;
    }

    public SharedPreferences d() {
        Object value = this.f17170d.getValue();
        Intrinsics.e(value, "<get-trackingSharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    public bc e() {
        return (bc) this.f17173g.getValue();
    }

    public SharedPreferences f() {
        Object value = this.f17169c.getValue();
        Intrinsics.e(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    public va g() {
        return (va) this.f17176j.getValue();
    }

    public Context getContext() {
        return this.f17167a;
    }

    public Handler h() {
        return (Handler) this.f17172f.getValue();
    }

    public n4 i() {
        return (n4) this.f17179m.getValue();
    }

    public fa j() {
        return (fa) this.f17175i.getValue();
    }

    public y0 k() {
        Object value = this.f17171e.getValue();
        Intrinsics.e(value, "<get-android>(...)");
        return (y0) value;
    }

    public l4 l() {
        return (l4) this.f17180n.getValue();
    }

    public DisplayMetrics m() {
        Object value = this.f17178l.getValue();
        Intrinsics.e(value, "<get-displayMetrics>(...)");
        return (DisplayMetrics) value;
    }

    public WindowManager n() {
        return (WindowManager) this.f17177k.getValue();
    }
}
