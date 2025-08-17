package com.startapp;

public class s9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f35856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35858c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ r9 f35859d;

    public s9(r9 r9Var, String str, String str2, long j2) {
        this.f35859d = r9Var;
        this.f35856a = str;
        this.f35857b = str2;
        this.f35858c = j2;
    }

    public void run() {
        r9 r9Var = this.f35859d;
        String str = this.f35856a;
        String str2 = this.f35857b;
        long j2 = this.f35858c;
        r9Var.getClass();
        try {
            r9Var.f35773c.a(str, str2, System.currentTimeMillis(), j2);
        } catch (Throwable th) {
            if (r9Var.a(1)) {
                y8.a(r9Var.f35771a, th);
            }
        }
    }
}
