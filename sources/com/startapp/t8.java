package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.startapp.sdk.adsbase.crashreport.ThreadsState;
import com.startapp.u8;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class t8 implements u8.d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36575a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36576b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36577c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f36578d;

    public t8(Context context, String str, boolean z2, boolean z3, boolean z4) {
        this.f36575a = context;
        this.f36576b = z2;
        this.f36577c = z3;
        this.f36578d = z4;
    }

    public boolean a(long j2, String str) {
        HashSet hashSet;
        ThreadsState.a aVar = new ThreadsState.a();
        aVar.f36318a = "com.startapp.";
        aVar.f36322e = this.f36576b;
        aVar.f36323f = this.f36577c;
        aVar.f36321d = j2;
        aVar.f36319b = str;
        if (this.f36578d) {
            hashSet = new HashSet();
            hashSet.add("android.webkit.WebView.loadDataWithBaseURL");
            hashSet.add("android.webkit.WebView.<init>");
            hashSet.add("android.webkit.WebView.stopLoading");
            hashSet.add("android.webkit.WebView.loadUrl");
            hashSet.add("libcore.icu.LocaleData.initLocaleData");
            hashSet.add("android.os.BinderProxy.transact");
            hashSet.add("android.hardware.SystemSensorManager.registerListenerImpl");
            hashSet.add("android.hardware.SystemSensorManager.<init>");
            hashSet.add("java.lang.Thread.<init>");
            hashSet.add("android.content.ContextWrapper.checkSelfPermission");
        } else {
            hashSet = null;
        }
        aVar.f36320c = hashSet;
        ThreadsState threadsState = new ThreadsState(aVar);
        if (threadsState.d() == null) {
            return false;
        }
        ra.a(this.f36575a, "StartappAnrTrace", (Serializable) threadsState);
        return true;
    }

    public void remove() {
        if (new File(ra.c(this.f36575a, "StartappAnrTrace")).exists()) {
            ra.a(this.f36575a, "StartappAnrTrace");
        }
    }

    public void a() {
        ThreadsState threadsState;
        ThreadsState.ShrunkStackTraceElement[] shrunkStackTraceElementArr;
        if (new File(ra.c(this.f36575a, "StartappAnrTrace")).exists() && (threadsState = (ThreadsState) ra.a(this.f36575a, "StartappAnrTrace", ThreadsState.class)) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Map<Activity, Integer> map = lb.f34876a;
            PrintWriter printWriter = new PrintWriter(new DeflaterOutputStream(new Base64OutputStream(byteArrayOutputStream, 10), new Deflater(9, true)));
            printWriter.print("\"delay: ");
            printWriter.print(threadsState.b());
            printWriter.println('\"');
            if (!TextUtils.isEmpty(threadsState.c())) {
                printWriter.print("\"handler: ");
                printWriter.print(threadsState.c());
                printWriter.println('\"');
            }
            Map<String, ThreadsState.ShrunkStackTraceElement[]> d2 = threadsState.d();
            int i2 = 0;
            StackTraceElement stackTraceElement = null;
            if (d2 == null) {
                shrunkStackTraceElementArr = null;
            } else {
                shrunkStackTraceElementArr = null;
                for (Map.Entry next : d2.entrySet()) {
                    if (shrunkStackTraceElementArr == null) {
                        shrunkStackTraceElementArr = (ThreadsState.ShrunkStackTraceElement[]) next.getValue();
                    }
                    ThreadsState.ShrunkStackTraceElement[] shrunkStackTraceElementArr2 = (ThreadsState.ShrunkStackTraceElement[]) next.getValue();
                    printWriter.print('\"');
                    printWriter.print((String) next.getKey());
                    printWriter.println('\"');
                    for (ThreadsState.ShrunkStackTraceElement shrunkStackTraceElement : shrunkStackTraceElementArr2) {
                        if (shrunkStackTraceElement.a() != 0) {
                            printWriter.print(9);
                            printWriter.println(shrunkStackTraceElement.a());
                        }
                        StackTraceElement b2 = shrunkStackTraceElement.b();
                        if (b2 != null) {
                            printWriter.print(9);
                            printWriter.print("at ");
                            printWriter.print(b2.getClassName());
                            printWriter.print('.');
                            printWriter.print(b2.getMethodName());
                            printWriter.print('(');
                            printWriter.print(b2.getFileName());
                            printWriter.print(':');
                            printWriter.print(b2.getLineNumber());
                            printWriter.println(')');
                        }
                    }
                }
            }
            printWriter.close();
            if (shrunkStackTraceElementArr != null) {
                int length = shrunkStackTraceElementArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement b3 = shrunkStackTraceElementArr[i2].b();
                    if (b3 != null && b3.getClassName().startsWith("com.startapp.")) {
                        stackTraceElement = b3;
                        break;
                    }
                    i2++;
                }
                if (stackTraceElement != null) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    y8 y8Var = new y8(z8.f37000g);
                    y8Var.f36954d = stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName();
                    y8Var.f36955e = byteArrayOutputStream2;
                    y8Var.a(this.f36575a);
                }
            }
        }
    }
}
