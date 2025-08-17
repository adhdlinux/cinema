package com.startapp;

public class ke implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ je f34846a;

    public ke(je jeVar) {
        this.f34846a = jeVar;
    }

    public void run() {
        je jeVar = this.f34846a;
        jeVar.getClass();
        try {
            jeVar.d();
        } catch (Throwable th) {
            y8.a(jeVar.f34776b, th);
        }
    }
}
