package com.startapp;

import com.startapp.j8;
import java.util.Iterator;

public class c8 implements j8.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d8 f34288a;

    public c8(d8 d8Var) {
        this.f34288a = d8Var;
    }

    public void a(j8 j8Var) {
        synchronized (this.f34288a.f34355b) {
            Iterator<j8> it2 = this.f34288a.f34355b.values().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next() == j8Var) {
                        it2.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
