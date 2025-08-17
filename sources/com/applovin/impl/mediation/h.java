package com.applovin.impl.mediation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f14932a = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(com.applovin.impl.mediation.a.a aVar);
    }

    public void a(com.applovin.impl.mediation.a.a aVar) {
        Iterator it2 = new ArrayList(this.f14932a).iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).a(aVar);
        }
    }

    public void a(a aVar) {
        this.f14932a.add(aVar);
    }

    public void b(a aVar) {
        this.f14932a.remove(aVar);
    }
}
