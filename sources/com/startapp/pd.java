package com.startapp;

import com.startapp.rd;

public class pd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ rd f35621a;

    public pd(rd rdVar) {
        this.f35621a = rdVar;
    }

    public void run() {
        rd rdVar = this.f35621a;
        rdVar.getClass();
        try {
            if (rdVar.a() != null) {
                if (rdVar.f35799e == null) {
                    rd.c a2 = rdVar.a((Class<?>) null);
                    rdVar.f35799e = a2;
                    if (a2 != null) {
                        a2.a();
                    }
                }
            }
        } catch (Throwable th) {
            if (rdVar.a(1)) {
                y8.a(rdVar.f35795a, th);
            }
        }
    }
}
