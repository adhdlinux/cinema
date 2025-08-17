package com.facebook.ads.internal.b;

import android.os.Bundle;
import android.view.View;
import com.facebook.ads.internal.q.a.p;
import java.util.ArrayList;
import java.util.List;

public final class a implements p<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private final View f20016a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f20017b;

    /* renamed from: c  reason: collision with root package name */
    private c f20018c;

    public a(View view, List<b> list) {
        this.f20016a = view;
        this.f20017b = new ArrayList(list.size());
        for (b dVar : list) {
            this.f20017b.add(new d(dVar));
        }
        this.f20018c = new c();
    }

    public a(View view, List<b> list, Bundle bundle) {
        this.f20016a = view;
        this.f20017b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f20017b.add(new d(list.get(i2), (Bundle) parcelableArrayList.get(i2)));
        }
        this.f20018c = (c) bundle.getSerializable("STATISTICS");
    }

    public void a() {
        this.f20018c.a();
    }

    public void a(double d2, double d3) {
        if (d3 >= 0.0d) {
            this.f20018c.b(d2, d3);
        }
        double c2 = (double) com.facebook.ads.internal.r.a.a(this.f20016a, 0).c();
        this.f20018c.a(d2, c2);
        for (d a2 : this.f20017b) {
            a2.a(d2, c2);
        }
    }

    public void b() {
        this.f20018c.b();
        for (d a2 : this.f20017b) {
            a2.a();
        }
    }

    public c c() {
        return this.f20018c;
    }

    public Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATISTICS", this.f20018c);
        ArrayList arrayList = new ArrayList(this.f20017b.size());
        for (d g2 : this.f20017b) {
            arrayList.add(g2.g());
        }
        bundle.putParcelableArrayList("TESTS", arrayList);
        return bundle;
    }
}
