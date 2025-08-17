package com.startapp;

import com.startapp.rd;

public class qd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ rd f35722a;

    public qd(rd rdVar) {
        this.f35722a = rdVar;
    }

    public void run() {
        rd rdVar = this.f35722a;
        rdVar.getClass();
        try {
            rd.c cVar = rdVar.f35799e;
            if (cVar != null) {
                cVar.b();
                rdVar.f35799e = null;
            }
        } catch (Throwable th) {
            if (rdVar.a(4)) {
                y8.a(rdVar.f35795a, th);
            }
        }
    }
}
