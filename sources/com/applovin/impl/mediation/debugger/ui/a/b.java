package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.b.a.e;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final com.applovin.impl.mediation.debugger.b.a.a f14590a;

    /* renamed from: b  reason: collision with root package name */
    private final com.applovin.impl.mediation.debugger.b.a.b f14591b;

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f14592d = c();

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f14593e = d();

    /* renamed from: f  reason: collision with root package name */
    private final List<c> f14594f = e();

    class a extends com.applovin.impl.mediation.debugger.ui.b.a.a {

        /* renamed from: o  reason: collision with root package name */
        private final com.applovin.impl.mediation.debugger.b.a.b f14596o;

        a(com.applovin.impl.mediation.debugger.b.a.b bVar, String str, boolean z2) {
            super(bVar.a().c(), b.this.f14736c);
            this.f14596o = bVar;
            this.f14702d = StringUtils.createSpannedString(bVar.a().b(), -16777216, 18, 1);
            this.f14703e = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f14701c = z2;
        }

        public com.applovin.impl.mediation.debugger.b.a.b a() {
            return this.f14596o;
        }

        public boolean b() {
            return this.f14701c;
        }

        public int c() {
            return -12303292;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b  reason: collision with other inner class name */
    enum C0017b {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    b(com.applovin.impl.mediation.debugger.b.a.a aVar, com.applovin.impl.mediation.debugger.b.a.b bVar, Context context) {
        super(context);
        this.f14590a = aVar;
        this.f14591b = bVar;
        notifyDataSetChanged();
    }

    private List<c> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(f());
        arrayList.add(g());
        if (this.f14591b != null) {
            arrayList.add(h());
        }
        return arrayList;
    }

    private List<c> d() {
        com.applovin.impl.mediation.debugger.b.a.b bVar = this.f14591b;
        if (bVar != null && !bVar.c()) {
            return new ArrayList();
        }
        List<com.applovin.impl.mediation.debugger.b.a.b> a2 = this.f14590a.e().a();
        ArrayList arrayList = new ArrayList(a2.size());
        for (com.applovin.impl.mediation.debugger.b.a.b next : a2) {
            com.applovin.impl.mediation.debugger.b.a.b bVar2 = this.f14591b;
            if (bVar2 == null || bVar2.a().a().equals(next.a().a())) {
                arrayList.add(new a(next, next.b() != null ? next.b().a() : "", this.f14591b == null));
            }
        }
        return arrayList;
    }

    private List<c> e() {
        com.applovin.impl.mediation.debugger.b.a.b bVar = this.f14591b;
        if (bVar != null && bVar.c()) {
            return new ArrayList();
        }
        List<com.applovin.impl.mediation.debugger.b.a.b> b2 = this.f14590a.e().b();
        ArrayList arrayList = new ArrayList(b2.size());
        for (com.applovin.impl.mediation.debugger.b.a.b next : b2) {
            com.applovin.impl.mediation.debugger.b.a.b bVar2 = this.f14591b;
            if (bVar2 == null || bVar2.a().a().equals(next.a().a())) {
                arrayList.add(new a(next, (String) null, this.f14591b == null));
                for (e next2 : next.d()) {
                    arrayList.add(c.p().a(next2.a()).b(next2.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    private c f() {
        return c.p().a("ID").b(this.f14590a.a()).a();
    }

    private c g() {
        return c.p().a("Ad Format").b(this.f14590a.c()).a();
    }

    private c h() {
        return c.p().a("Selected Network").b(this.f14591b.a().b()).a();
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return (i2 == C0017b.INFO.ordinal() ? this.f14592d : i2 == C0017b.BIDDERS.ordinal() ? this.f14593e : this.f14594f).size();
    }

    public String a() {
        return this.f14590a.b();
    }

    /* access modifiers changed from: protected */
    public int b() {
        return C0017b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i2) {
        return i2 == C0017b.INFO.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("INFO") : i2 == C0017b.BIDDERS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("BIDDERS") : new com.applovin.impl.mediation.debugger.ui.d.e("WATERFALL");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i2) {
        return i2 == C0017b.INFO.ordinal() ? this.f14592d : i2 == C0017b.BIDDERS.ordinal() ? this.f14593e : this.f14594f;
    }
}
