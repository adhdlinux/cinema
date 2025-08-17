package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class l2 {

    /* renamed from: j  reason: collision with root package name */
    public static final a f18088j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f18089a;

    /* renamed from: b  reason: collision with root package name */
    public String f18090b;

    /* renamed from: c  reason: collision with root package name */
    public final i9 f18091c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f18092d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public final File f18093e;

    /* renamed from: f  reason: collision with root package name */
    public long f18094f;

    /* renamed from: g  reason: collision with root package name */
    public long f18095g;

    /* renamed from: h  reason: collision with root package name */
    public long f18096h;

    /* renamed from: i  reason: collision with root package name */
    public int f18097i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public l2(String str, String str2, i9 i9Var, File file) {
        Intrinsics.f(str, "method");
        Intrinsics.f(str2, "uri");
        Intrinsics.f(i9Var, "priority");
        this.f18089a = str;
        this.f18090b = str2;
        this.f18091c = i9Var;
        this.f18093e = file;
        this.f18094f = 0;
        this.f18095g = 0;
        this.f18096h = 0;
        this.f18097i = 0;
        f();
    }

    public void a(CBError cBError, p2 p2Var) {
    }

    public void a(Object obj, p2 p2Var) {
    }

    public void a(String str, long j2) {
        Intrinsics.f(str, "uri");
    }

    public final boolean b() {
        return this.f18092d.compareAndSet(0, -1);
    }

    public final String c() {
        return this.f18089a;
    }

    public final i9 d() {
        return this.f18091c;
    }

    public final String e() {
        return this.f18090b;
    }

    public final void f() {
        Unit unit;
        la laVar = la.f18112a;
        if (laVar.g() && this.f18090b.length() > 0) {
            String d2 = laVar.d();
            if (d2 == null || d2.length() == 0) {
                String c2 = laVar.c();
                if (c2 != null && c2.length() != 0) {
                    String path = new URL(this.f18090b).getPath();
                    String str = (String) za.a().get(path);
                    if (str != null) {
                        String c3 = laVar.c();
                        Intrinsics.c(c3);
                        URL url = new URL(StringsKt__StringsJVMKt.C(str, "{BRANCH}", c3, false, 4, (Object) null));
                        this.f18090b = url.getProtocol() + "://" + url.getHost() + path;
                        String a2 = n2.f18215a;
                        Intrinsics.e(a2, "TAG");
                        w7.a(a2, "Host url was updated to staging: " + this.f18090b);
                        unit = Unit.f40298a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        String a3 = n2.f18215a;
                        Intrinsics.e(a3, "TAG");
                        w7.e(a3, "Host url was not updated to staging: didn't match path " + this.f18090b);
                        return;
                    }
                    return;
                }
                return;
            }
            String path2 = new URL(this.f18090b).getPath();
            URL url2 = new URL(laVar.d());
            this.f18090b = url2.getProtocol() + "://" + url2.getHost() + path2;
            String a4 = n2.f18215a;
            Intrinsics.e(a4, "TAG");
            w7.a(a4, "Host url was updated to custom: " + this.f18090b);
        }
    }

    public m2 a() {
        return new m2((Map) null, (byte[]) null, (String) null);
    }

    public o2 a(p2 p2Var) {
        return o2.a((Object) null);
    }
}
