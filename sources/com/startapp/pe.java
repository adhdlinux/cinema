package com.startapp;

public class pe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ oe f35622a;

    public pe(oe oeVar) {
        this.f35622a = oeVar;
    }

    public void run() {
        try {
            this.f35622a.c();
        } catch (Throwable th) {
            y8.a(this.f35622a.f35575b, th);
        }
    }
}
