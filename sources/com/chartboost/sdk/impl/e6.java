package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b0.p;
import com.chartboost.sdk.R;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class e6 extends s3 {

    /* renamed from: f  reason: collision with root package name */
    public final n7 f17596f;

    /* renamed from: g  reason: collision with root package name */
    public final f4 f17597g;

    /* renamed from: h  reason: collision with root package name */
    public final d7 f17598h;

    /* renamed from: i  reason: collision with root package name */
    public final CoroutineDispatcher f17599i;

    /* renamed from: j  reason: collision with root package name */
    public final d2 f17600j;

    /* renamed from: k  reason: collision with root package name */
    public Job f17601k;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17602b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final x1 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new x1(context);
        }
    }

    public static final class b extends Lambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d7 f17603b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f17604c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d7 d7Var, Context context) {
            super(2);
            this.f17603b = d7Var;
            this.f17604c = context;
        }

        /* renamed from: a */
        public final e4 invoke(f4 f4Var, z4 z4Var) {
            Intrinsics.f(f4Var, "cb");
            Intrinsics.f(z4Var, "et");
            return new y1(this.f17603b, new ya(this.f17604c), f4Var, z4Var);
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17605a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.chartboost.sdk.impl.n7$b[] r0 = com.chartboost.sdk.impl.n7.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.n7$b r1 = com.chartboost.sdk.impl.n7.b.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.n7$b r1 = com.chartboost.sdk.impl.n7.b.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.n7$b r1 = com.chartboost.sdk.impl.n7.b.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.impl.n7$b r1 = com.chartboost.sdk.impl.n7.b.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f17605a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.e6.c.<clinit>():void");
        }
    }

    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f17606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e6 f17607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImageView f17608d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e6 e6Var, ImageView imageView, Continuation continuation) {
            super(2, continuation);
            this.f17607c = e6Var;
            this.f17608d = imageView;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f17607c, this.f17608d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f17606b;
            if (i2 == 0) {
                ResultKt.b(obj);
                d2 a2 = this.f17607c.f17600j;
                String b2 = this.f17607c.f17596f.b();
                this.f17606b = 1;
                obj = a2.a(b2, this);
                if (obj == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.f17608d.setImageBitmap(bitmap);
            }
            this.f17608d.setVisibility(0);
            return Unit.f40298a;
        }
    }

    public static final class e extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e6 f17609b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(e6 e6Var) {
            super(1);
            this.f17609b = e6Var;
        }

        public final void a(Throwable th) {
            this.f17609b.setInfoIconDownloadJob((Job) null);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f40298a;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e6(android.content.Context r14, java.lang.String r15, java.lang.String r16, com.chartboost.sdk.impl.n7 r17, com.chartboost.sdk.impl.z4 r18, com.chartboost.sdk.impl.f4 r19, com.chartboost.sdk.impl.d7 r20, kotlinx.coroutines.CoroutineDispatcher r21, kotlin.jvm.functions.Function1 r22, com.chartboost.sdk.impl.d2 r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000c
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            r10 = r1
            goto L_0x000e
        L_0x000c:
            r10 = r21
        L_0x000e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0016
            com.chartboost.sdk.impl.e6$a r1 = com.chartboost.sdk.impl.e6.a.f17602b
            r11 = r1
            goto L_0x0018
        L_0x0016:
            r11 = r22
        L_0x0018:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0029
            com.chartboost.sdk.impl.d2 r0 = new com.chartboost.sdk.impl.d2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            r12 = r0
            goto L_0x002b
        L_0x0029:
            r12 = r23
        L_0x002b:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.e6.<init>(android.content.Context, java.lang.String, java.lang.String, com.chartboost.sdk.impl.n7, com.chartboost.sdk.impl.z4, com.chartboost.sdk.impl.f4, com.chartboost.sdk.impl.d7, kotlinx.coroutines.CoroutineDispatcher, kotlin.jvm.functions.Function1, com.chartboost.sdk.impl.d2, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Job getInfoIconDownloadJob() {
        return this.f17601k;
    }

    public final void setInfoIconDownloadJob(Job job) {
        this.f17601k = job;
    }

    public final void a(RelativeLayout relativeLayout) {
        Intrinsics.f(relativeLayout, "container");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(this.f17596f.e().b()), a(this.f17596f.e().a()));
        int i2 = c.f17605a[this.f17596f.d().ordinal()];
        if (i2 == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else if (i2 == 3) {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        } else if (i2 == 4) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        }
        layoutParams.setMargins(a(this.f17596f.c().b()), a(this.f17596f.c().a()), a(this.f17596f.c().b()), a(this.f17596f.c().a()));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.cb_info_icon);
        imageView.setOnClickListener(new p(this));
        imageView.setVisibility(8);
        Job b2 = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f17599i), (CoroutineContext) null, (CoroutineStart) null, new d(this, imageView, (Continuation) null), 3, (Object) null);
        b2.z(new e(this));
        this.f17601k = b2;
        relativeLayout.addView(imageView, layoutParams);
        this.f17597g.a((View) imageView);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e6(android.content.Context r18, java.lang.String r19, java.lang.String r20, com.chartboost.sdk.impl.n7 r21, com.chartboost.sdk.impl.z4 r22, com.chartboost.sdk.impl.f4 r23, com.chartboost.sdk.impl.d7 r24, kotlinx.coroutines.CoroutineDispatcher r25, kotlin.jvm.functions.Function1 r26, com.chartboost.sdk.impl.d2 r27) {
        /*
            r17 = this;
            r11 = r17
            r1 = r18
            r12 = r21
            r13 = r23
            r14 = r24
            r15 = r25
            r10 = r27
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "baseUrl"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "html"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "infoIcon"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "eventTracker"
            r5 = r22
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "impressionInterface"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "dispatcher"
            kotlin.jvm.internal.Intrinsics.f(r15, r0)
            java.lang.String r0 = "cbWebViewFactory"
            r6 = r26
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "cbImageDownloader"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            com.chartboost.sdk.impl.e6$b r8 = new com.chartboost.sdk.impl.e6$b
            r8.<init>(r14, r1)
            r7 = 0
            r9 = 64
            r16 = 0
            r0 = r17
            r3 = r23
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.f17596f = r12
            r11.f17597g = r13
            r11.f17598h = r14
            r11.f17599i = r15
            r0 = r27
            r11.f17600j = r0
            android.widget.RelativeLayout r0 = r17.getWebViewContainer()
            r11.addView(r0)
            r23.a()
            r23.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.e6.<init>(android.content.Context, java.lang.String, java.lang.String, com.chartboost.sdk.impl.n7, com.chartboost.sdk.impl.z4, com.chartboost.sdk.impl.f4, com.chartboost.sdk.impl.d7, kotlinx.coroutines.CoroutineDispatcher, kotlin.jvm.functions.Function1, com.chartboost.sdk.impl.d2):void");
    }

    public static final void a(e6 e6Var, View view) {
        Intrinsics.f(e6Var, "this$0");
        e6Var.f17598h.a(new x2(e6Var.f17596f.a(), Boolean.FALSE));
    }

    public void a() {
        Job job = this.f17601k;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f17601k = null;
        super.a();
    }

    public final int a(double d2) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Context context = getContext();
        if (!(context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            d2 *= (double) displayMetrics.density;
        }
        return MathKt__MathJVMKt.a(d2);
    }
}
