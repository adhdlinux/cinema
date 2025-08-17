package com.startapp;

import com.startapp.be;

public class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ be.a f34306a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ be f34307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ bf f34308c;

    public cf(bf bfVar, be.a aVar, be beVar) {
        this.f34308c = bfVar;
        this.f34306a = aVar;
        this.f34307b = beVar;
    }

    public void run() {
        try {
            this.f34308c.f34271h.run();
        } finally {
            this.f34306a.a(this.f34307b, false);
        }
    }
}
