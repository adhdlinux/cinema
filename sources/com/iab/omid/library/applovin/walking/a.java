package com.iab.omid.library.applovin.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.applovin.b.c;
import com.iab.omid.library.applovin.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<View, String> f31554a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<View, C0046a> f31555b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, View> f31556c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f31557d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f31558e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f31559f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f31560g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<View, Boolean> f31561h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    private boolean f31562i;

    /* renamed from: com.iab.omid.library.applovin.walking.a$a  reason: collision with other inner class name */
    public static class C0046a {

        /* renamed from: a  reason: collision with root package name */
        private final c f31563a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f31564b = new ArrayList<>();

        public C0046a(c cVar, String str) {
            this.f31563a = cVar;
            a(str);
        }

        public c a() {
            return this.f31563a;
        }

        public void a(String str) {
            this.f31564b.add(str);
        }

        public ArrayList<String> b() {
            return this.f31564b;
        }
    }

    private void a(com.iab.omid.library.applovin.adsession.a aVar) {
        for (c a2 : aVar.a()) {
            a(a2, aVar);
        }
    }

    private void a(c cVar, com.iab.omid.library.applovin.adsession.a aVar) {
        View view = (View) cVar.a().get();
        if (view != null) {
            C0046a aVar2 = this.f31555b.get(view);
            if (aVar2 != null) {
                aVar2.a(aVar.getAdSessionId());
            } else {
                this.f31555b.put(view, new C0046a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    private String e(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (f(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e2 = f.e(view);
            if (e2 != null) {
                return e2;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f31557d.addAll(hashSet);
        return null;
    }

    private Boolean f(View view) {
        if (view.hasWindowFocus()) {
            this.f31561h.remove(view);
            return Boolean.FALSE;
        } else if (this.f31561h.containsKey(view)) {
            return this.f31561h.get(view);
        } else {
            Map<View, Boolean> map = this.f31561h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    public String a(View view) {
        if (this.f31554a.size() == 0) {
            return null;
        }
        String str = this.f31554a.get(view);
        if (str != null) {
            this.f31554a.remove(view);
        }
        return str;
    }

    public String a(String str) {
        return this.f31560g.get(str);
    }

    public HashSet<String> a() {
        return this.f31558e;
    }

    public View b(String str) {
        return this.f31556c.get(str);
    }

    public C0046a b(View view) {
        C0046a aVar = this.f31555b.get(view);
        if (aVar != null) {
            this.f31555b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> b() {
        return this.f31559f;
    }

    public c c(View view) {
        return this.f31557d.contains(view) ? c.PARENT_VIEW : this.f31562i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void c() {
        com.iab.omid.library.applovin.b.a a2 = com.iab.omid.library.applovin.b.a.a();
        if (a2 != null) {
            for (com.iab.omid.library.applovin.adsession.a next : a2.c()) {
                View e2 = next.e();
                if (next.f()) {
                    String adSessionId = next.getAdSessionId();
                    if (e2 != null) {
                        String e3 = e(e2);
                        if (e3 == null) {
                            this.f31558e.add(adSessionId);
                            this.f31554a.put(e2, adSessionId);
                            a(next);
                        } else if (e3 != "noWindowFocus") {
                            this.f31559f.add(adSessionId);
                            this.f31556c.put(adSessionId, e2);
                            this.f31560g.put(adSessionId, e3);
                        }
                    } else {
                        this.f31559f.add(adSessionId);
                        this.f31560g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.f31554a.clear();
        this.f31555b.clear();
        this.f31556c.clear();
        this.f31557d.clear();
        this.f31558e.clear();
        this.f31559f.clear();
        this.f31560g.clear();
        this.f31562i = false;
    }

    public boolean d(View view) {
        if (!this.f31561h.containsKey(view)) {
            return true;
        }
        this.f31561h.put(view, Boolean.TRUE);
        return false;
    }

    public void e() {
        this.f31562i = true;
    }
}
