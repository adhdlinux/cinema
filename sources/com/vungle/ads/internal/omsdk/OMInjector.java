package com.vungle.ads.internal.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.iab.omid.library.vungle.Omid;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m1.a;

public final class OMInjector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OM_SDK_JS = "omsdk.js";
    private static final String OM_SESSION_JS = "omsdk-session.js";
    private final AtomicReference<Context> contextRef;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OMInjector(Context context) {
        Intrinsics.f(context, "context");
        this.contextRef = new AtomicReference<>(context.getApplicationContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-2  reason: not valid java name */
    public static final void m193init$lambda2(OMInjector oMInjector) {
        Object obj;
        Intrinsics.f(oMInjector, "this$0");
        try {
            Result.Companion companion = Result.f40263c;
            if (!Omid.b()) {
                Omid.a(oMInjector.contextRef.get());
            }
            obj = Result.b(Unit.f40298a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            Logger.Companion companion3 = Logger.Companion;
            companion3.e("OMSDK", "error: " + e2.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        kotlin.io.CloseableKt.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.io.File writeToFile(java.lang.String r2, java.io.File r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0019
            java.io.FileWriter r0 = new java.io.FileWriter
            r0.<init>(r3)
            r0.write(r2)     // Catch:{ all -> 0x0012 }
            r0.flush()     // Catch:{ all -> 0x0012 }
            r2 = 0
            kotlin.io.CloseableKt.a(r0, r2)
            return r3
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r0, r2)
            throw r3
        L_0x0019:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "omsdk js must not be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.omsdk.OMInjector.writeToFile(java.lang.String, java.io.File):java.io.File");
    }

    public final void init() {
        this.uiHandler.post(new a(this));
    }

    public final List<File> injectJsFiles$vungle_ads_release(File file) {
        Intrinsics.f(file, "dir");
        ArrayList arrayList = new ArrayList();
        Res res = Res.INSTANCE;
        arrayList.add(writeToFile(res.getOM_JS$vungle_ads_release(), new File(file, OM_SDK_JS)));
        arrayList.add(writeToFile(res.getOM_SESSION_JS$vungle_ads_release(), new File(file, OM_SESSION_JS)));
        return arrayList;
    }
}
