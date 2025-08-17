package com.iab.omid.library.adcolony.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.adcolony.b.c;
import com.iab.omid.library.adcolony.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<View, String> f31437a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<View, C0043a> f31438b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, View> f31439c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f31440d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f31441e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f31442f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f31443g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<View, Boolean> f31444h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    private boolean f31445i;

    /* renamed from: com.iab.omid.library.adcolony.walking.a$a  reason: collision with other inner class name */
    public static class C0043a {

        /* renamed from: a  reason: collision with root package name */
        private final c f31446a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f31447b = new ArrayList<>();

        public C0043a(c cVar, String str) {
            this.f31446a = cVar;
            b(str);
        }

        public c a() {
            return this.f31446a;
        }

        public void b(String str) {
            this.f31447b.add(str);
        }

        public ArrayList<String> c() {
            return this.f31447b;
        }
    }

    private void d(com.iab.omid.library.adcolony.adsession.a aVar) {
        for (c e2 : aVar.i()) {
            e(e2, aVar);
        }
    }

    private void e(c cVar, com.iab.omid.library.adcolony.adsession.a aVar) {
        View view = (View) cVar.a().get();
        if (view != null) {
            C0043a aVar2 = this.f31438b.get(view);
            if (aVar2 != null) {
                aVar2.b(aVar.e());
            } else {
                this.f31438b.put(view, new C0043a(cVar, aVar.e()));
            }
        }
    }

    private String m(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (o(view).booleanValue()) {
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
        this.f31440d.addAll(hashSet);
        return null;
    }

    private Boolean o(View view) {
        if (view.hasWindowFocus()) {
            this.f31444h.remove(view);
            return Boolean.FALSE;
        } else if (this.f31444h.containsKey(view)) {
            return this.f31444h.get(view);
        } else {
            Map<View, Boolean> map = this.f31444h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    public String a(View view) {
        if (this.f31437a.size() == 0) {
            return null;
        }
        String str = this.f31437a.get(view);
        if (str != null) {
            this.f31437a.remove(view);
        }
        return str;
    }

    public String b(String str) {
        return this.f31443g.get(str);
    }

    public HashSet<String> c() {
        return this.f31441e;
    }

    public View f(String str) {
        return this.f31439c.get(str);
    }

    public C0043a g(View view) {
        C0043a aVar = this.f31438b.get(view);
        if (aVar != null) {
            this.f31438b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> h() {
        return this.f31442f;
    }

    public c i(View view) {
        return this.f31440d.contains(view) ? c.PARENT_VIEW : this.f31445i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void j() {
        com.iab.omid.library.adcolony.b.a a2 = com.iab.omid.library.adcolony.b.a.a();
        if (a2 != null) {
            for (com.iab.omid.library.adcolony.adsession.a next : a2.e()) {
                View s2 = next.s();
                if (next.t()) {
                    String e2 = next.e();
                    if (s2 != null) {
                        String m2 = m(s2);
                        if (m2 == null) {
                            this.f31441e.add(e2);
                            this.f31437a.put(s2, e2);
                            d(next);
                        } else if (m2 != "noWindowFocus") {
                            this.f31442f.add(e2);
                            this.f31439c.put(e2, s2);
                            this.f31443g.put(e2, m2);
                        }
                    } else {
                        this.f31442f.add(e2);
                        this.f31443g.put(e2, "noAdView");
                    }
                }
            }
        }
    }

    public void k() {
        this.f31437a.clear();
        this.f31438b.clear();
        this.f31439c.clear();
        this.f31440d.clear();
        this.f31441e.clear();
        this.f31442f.clear();
        this.f31443g.clear();
        this.f31445i = false;
    }

    public boolean l(View view) {
        if (!this.f31444h.containsKey(view)) {
            return true;
        }
        this.f31444h.put(view, Boolean.TRUE);
        return false;
    }

    public void n() {
        this.f31445i = true;
    }
}
