package com.chartboost.sdk.impl;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class n5 implements m5 {

    /* renamed from: a  reason: collision with root package name */
    public final File f18223a;

    /* renamed from: b  reason: collision with root package name */
    public final File f18224b;

    /* renamed from: c  reason: collision with root package name */
    public final File f18225c;

    public n5(Context context, File file, File file2, File file3) {
        Intrinsics.f(context, "context");
        Intrinsics.f(file, "precacheDirectory");
        Intrinsics.f(file2, "precacheQueueDirectory");
        Intrinsics.f(file3, "precachingInternalDirectory");
        this.f18223a = file;
        this.f18224b = file2;
        this.f18225c = file3;
    }

    public File a() {
        return this.f18224b;
    }

    public File b() {
        return this.f18225c;
    }

    public File c() {
        return this.f18223a;
    }

    public File a(String str) {
        Intrinsics.f(str, "id");
        return new File(c(), str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n5(android.content.Context r1, java.io.File r2, java.io.File r3, java.io.File r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0008
            java.io.File r2 = com.chartboost.sdk.impl.h4.b(r1)
        L_0x0008:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0010
            java.io.File r3 = com.chartboost.sdk.impl.h4.c(r1)
        L_0x0010:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x001b
            java.io.File r4 = new java.io.File
            java.lang.String r5 = "exoplayer-cache"
            r4.<init>(r2, r5)
        L_0x001b:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.n5.<init>(android.content.Context, java.io.File, java.io.File, java.io.File, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
