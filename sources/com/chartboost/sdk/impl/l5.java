package com.chartboost.sdk.impl;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.source.MediaSource;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class l5 {

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f18104a;

    /* renamed from: b  reason: collision with root package name */
    public final Function0 f18105b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f18106c;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h5 f18107b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h5 h5Var) {
            super(0);
            this.f18107b = h5Var;
        }

        /* renamed from: a */
        public final MediaSource.Factory invoke() {
            return h4.a(this.f18107b.c());
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f18108b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final LoadControl invoke() {
            return h4.a(0, 0, 3, (Object) null);
        }
    }

    public l5(Context context, h5 h5Var, Function0 function0, Function0 function02) {
        Intrinsics.f(context, "context");
        Intrinsics.f(h5Var, "downloadManager");
        Intrinsics.f(function0, "mediaSourceFactory");
        Intrinsics.f(function02, "loadControlFactory");
        this.f18104a = function0;
        this.f18105b = function02;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.e(applicationContext, "context.applicationContext");
        this.f18106c = applicationContext;
    }

    public final ExoPlayer a() {
        ExoPlayer g2 = new ExoPlayer.Builder(this.f18106c).p((MediaSource.Factory) this.f18104a.invoke()).o((LoadControl) this.f18105b.invoke()).g();
        Intrinsics.e(g2, "Builder(context)\n       …y())\n            .build()");
        return g2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ l5(android.content.Context r1, com.chartboost.sdk.impl.h5 r2, kotlin.jvm.functions.Function0 r3, kotlin.jvm.functions.Function0 r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000e
            com.chartboost.sdk.impl.i3 r2 = com.chartboost.sdk.impl.i3.f17882b
            com.chartboost.sdk.impl.c1 r2 = r2.d()
            com.chartboost.sdk.impl.h5 r2 = r2.d()
        L_0x000e:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0017
            com.chartboost.sdk.impl.l5$a r3 = new com.chartboost.sdk.impl.l5$a
            r3.<init>(r2)
        L_0x0017:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x001d
            com.chartboost.sdk.impl.l5$b r4 = com.chartboost.sdk.impl.l5.b.f18108b
        L_0x001d:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.l5.<init>(android.content.Context, com.chartboost.sdk.impl.h5, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
