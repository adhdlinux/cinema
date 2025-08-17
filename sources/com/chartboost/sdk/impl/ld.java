package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import b0.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class ld {

    /* renamed from: o  reason: collision with root package name */
    public static final a f18145o = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final View f18146a;

    /* renamed from: b  reason: collision with root package name */
    public final View f18147b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18148c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18149d;

    /* renamed from: e  reason: collision with root package name */
    public final long f18150e;

    /* renamed from: f  reason: collision with root package name */
    public final int f18151f;

    /* renamed from: g  reason: collision with root package name */
    public b f18152g;

    /* renamed from: h  reason: collision with root package name */
    public final WeakReference f18153h;

    /* renamed from: i  reason: collision with root package name */
    public Job f18154i;

    /* renamed from: j  reason: collision with root package name */
    public WeakReference f18155j;

    /* renamed from: k  reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f18156k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f18157l;

    /* renamed from: m  reason: collision with root package name */
    public Long f18158m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f18159n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final View a(Context context, View view) {
            Activity activity;
            View view2;
            View rootView;
            Window window;
            View decorView;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (view2 = decorView.findViewById(16908290)) == null) {
                if (view == null || (rootView = view.getRootView()) == null) {
                    view2 = null;
                } else {
                    view2 = rootView.findViewById(16908290);
                }
                if (view2 == null) {
                    if (view != null) {
                        return view.getRootView();
                    }
                    return null;
                }
            }
            return view2;
        }

        public a() {
        }
    }

    public interface b {
        void a();
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            String a2 = md.f18201a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Visibility check ran into a problem: " + th);
        }
    }

    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18160b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f18161c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ld f18162d;

        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: b  reason: collision with root package name */
            public int f18163b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ld f18164c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ld ldVar, Continuation continuation) {
                super(2, continuation);
                this.f18164c = ldVar;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f18164c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object e2 = IntrinsicsKt__IntrinsicsKt.e();
                int i2 = this.f18163b;
                if (i2 == 0) {
                    ResultKt.b(obj);
                    long b2 = this.f18164c.f18150e;
                    this.f18163b = 1;
                    if (DelayKt.a(b2, this) == e2) {
                        return e2;
                    }
                } else if (i2 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f40298a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ld ldVar, Continuation continuation) {
            super(2, continuation);
            this.f18162d = ldVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            d dVar = new d(this.f18162d, continuation);
            dVar.f18161c = obj;
            return dVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
                int r1 = r6.f18160b
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r6.f18161c
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.b(r7)
                goto L_0x0023
            L_0x0013:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001b:
                kotlin.ResultKt.b(r7)
                java.lang.Object r7 = r6.f18161c
                r1 = r7
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            L_0x0023:
                boolean r7 = kotlinx.coroutines.CoroutineScopeKt.b(r1)
                if (r7 == 0) goto L_0x007d
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                boolean r7 = r7.f18157l
                if (r7 == 0) goto L_0x0032
                goto L_0x007d
            L_0x0032:
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                boolean r7 = r7.e()
                if (r7 == 0) goto L_0x0066
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                java.lang.Long r3 = r7.f18158m
                if (r3 != 0) goto L_0x004a
                long r3 = android.os.SystemClock.uptimeMillis()
                java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.c(r3)
            L_0x004a:
                r7.f18158m = r3
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                boolean r7 = r7.d()
                if (r7 == 0) goto L_0x0066
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                com.chartboost.sdk.impl.ld$b r7 = r7.c()
                if (r7 == 0) goto L_0x0060
                r7.a()
            L_0x0060:
                com.chartboost.sdk.impl.ld r7 = r6.f18162d
                r7.f18157l = r2
                goto L_0x007d
            L_0x0066:
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.b()
                com.chartboost.sdk.impl.ld$d$a r3 = new com.chartboost.sdk.impl.ld$d$a
                com.chartboost.sdk.impl.ld r4 = r6.f18162d
                r5 = 0
                r3.<init>(r4, r5)
                r6.f18161c = r1
                r6.f18160b = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.e(r7, r3, r6)
                if (r7 != r0) goto L_0x0023
                return r0
            L_0x007d:
                kotlin.Unit r7 = kotlin.Unit.f40298a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ld.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ld(Context context, View view, View view2, int i2, int i3, long j2, int i4) {
        Activity activity;
        Intrinsics.f(context, "context");
        Intrinsics.f(view, "trackedView");
        Intrinsics.f(view2, "rootView");
        this.f18146a = view;
        this.f18147b = view2;
        this.f18148c = i2;
        this.f18149d = i3;
        this.f18150e = j2;
        this.f18151f = i4;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        this.f18153h = new WeakReference(activity);
        this.f18155j = new WeakReference((Object) null);
        this.f18156k = new z(this);
        this.f18159n = new Rect();
    }

    public static final boolean f(ld ldVar) {
        Intrinsics.f(ldVar, "this$0");
        ldVar.f();
        return true;
    }

    public final void g() {
        ViewTreeObserver viewTreeObserver;
        try {
            ViewTreeObserver viewTreeObserver2 = (ViewTreeObserver) this.f18155j.get();
            if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                return;
            }
        } catch (Exception unused) {
            String a2 = md.f18201a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Exception when accessing view tree observer.");
        }
        View a3 = f18145o.a((Context) this.f18153h.get(), this.f18146a);
        if (a3 != null) {
            viewTreeObserver = a3.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                String a4 = md.f18201a;
                Intrinsics.e(a4, "TAG");
                w7.c(a4, "Unable to set ViewTreeObserver since it is not alive");
                return;
            }
            this.f18155j = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f18156k);
        }
    }

    public final void h() {
        g();
    }

    public final void b() {
        a();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f18155j.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f18156k);
        }
        this.f18155j.clear();
        this.f18152g = null;
    }

    public final b c() {
        return this.f18152g;
    }

    public final boolean d() {
        Long l2 = this.f18158m;
        if (l2 != null) {
            if (SystemClock.uptimeMillis() - l2.longValue() >= ((long) this.f18149d)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        if (this.f18146a.getVisibility() != 0 || this.f18147b.getParent() == null || this.f18146a.getWidth() <= 0 || this.f18146a.getHeight() <= 0) {
            return false;
        }
        int i2 = 0;
        for (ViewParent parent = this.f18146a.getParent(); parent != null && i2 < this.f18151f; parent = parent.getParent()) {
            if ((parent instanceof View) && ((View) parent).getVisibility() != 0) {
                return false;
            }
            i2++;
        }
        if (!this.f18146a.getGlobalVisibleRect(this.f18159n)) {
            return false;
        }
        int width = this.f18159n.width();
        Context context = this.f18146a.getContext();
        Intrinsics.e(context, "trackedView.context");
        int a2 = a(width, context);
        int height = this.f18159n.height();
        Context context2 = this.f18146a.getContext();
        Intrinsics.e(context2, "trackedView.context");
        if (a2 * a(height, context2) >= this.f18148c) {
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f18154i == null) {
            this.f18154i = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(Dispatchers.c()), new c(CoroutineExceptionHandler.D0), (CoroutineStart) null, new d(this, (Continuation) null), 2, (Object) null);
        }
    }

    public final void a(b bVar) {
        this.f18152g = bVar;
    }

    public final void a() {
        Job job = this.f18154i;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f18154i = null;
    }

    public final int a(int i2, Context context) {
        return MathKt__MathJVMKt.b(((float) i2) * context.getResources().getDisplayMetrics().density);
    }
}
