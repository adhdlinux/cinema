package com.chartboost.sdk.impl;

import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

public final class fa {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f17703a;

    public fa(Resources resources) {
        Intrinsics.f(resources, "resources");
        this.f17703a = resources;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.a(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.CloseableKt.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(int r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.res.Resources r1 = r4.f17703a     // Catch:{ Exception -> 0x003c }
            java.io.InputStream r5 = r1.openRawResource(r5)     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = "inputStream"
            kotlin.jvm.internal.Intrinsics.e(r5, r1)     // Catch:{ all -> 0x0035 }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.f40513b     // Catch:{ all -> 0x0035 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0035 }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x0035 }
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x001a
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x0035 }
            goto L_0x0022
        L_0x001a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0035 }
            r2 = r1
        L_0x0022:
            java.lang.String r1 = kotlin.io.TextStreamsKt.e(r2)     // Catch:{ all -> 0x002e }
            kotlin.io.CloseableKt.a(r2, r0)     // Catch:{ all -> 0x0035 }
            kotlin.io.CloseableKt.a(r5, r0)     // Catch:{ Exception -> 0x003c }
            r0 = r1
            goto L_0x005a
        L_0x002e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r2, r1)     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r5, r1)     // Catch:{ Exception -> 0x003c }
            throw r2     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            r5 = move-exception
            java.lang.String r1 = com.chartboost.sdk.impl.ga.f17768a
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Raw resource file exception: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.chartboost.sdk.impl.w7.b(r1, r5)
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.fa.a(int):java.lang.String");
    }
}
