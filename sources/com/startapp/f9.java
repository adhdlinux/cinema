package com.startapp;

public class f9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y8 f34524a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34525b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f34526c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e9 f34527d;

    public f9(e9 e9Var, y8 y8Var, int i2, long j2) {
        this.f34527d = e9Var;
        this.f34524a = y8Var;
        this.f34525b = i2;
        this.f34526c = j2;
    }

    public void run() {
        try {
            this.f34527d.a(this.f34524a, this.f34525b, this.f34526c);
        } catch (Throwable unused) {
        }
    }
}
