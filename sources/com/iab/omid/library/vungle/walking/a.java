package com.iab.omid.library.vungle.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<View, String> f31773a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<View, C0050a> f31774b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, View> f31775c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f31776d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f31777e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f31778f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f31779g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final HashSet<String> f31780h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private final Map<View, Boolean> f31781i = new WeakHashMap();

    /* renamed from: j  reason: collision with root package name */
    private boolean f31782j;

    /* renamed from: com.iab.omid.library.vungle.walking.a$a  reason: collision with other inner class name */
    public static class C0050a {

        /* renamed from: a  reason: collision with root package name */
        private final e f31783a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f31784b = new ArrayList<>();

        public C0050a(e eVar, String str) {
            this.f31783a = eVar;
            b(str);
        }

        public e a() {
            return this.f31783a;
        }

        public void b(String str) {
            this.f31784b.add(str);
        }

        public ArrayList<String> c() {
            return this.f31784b;
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f31781i.remove(view);
            return Boolean.FALSE;
        } else if (this.f31781i.containsKey(view)) {
            return this.f31781i.get(view);
        } else {
            Map<View, Boolean> map = this.f31781i;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    private String c(View view, boolean z2) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue() && !z2) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a2 = h.a(view);
            if (a2 != null) {
                return a2;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f31776d.addAll(hashSet);
        return null;
    }

    private void e(com.iab.omid.library.vungle.adsession.a aVar) {
        for (e f2 : aVar.i()) {
            f(f2, aVar);
        }
    }

    private void f(e eVar, com.iab.omid.library.vungle.adsession.a aVar) {
        View view = (View) eVar.c().get();
        if (view != null) {
            C0050a aVar2 = this.f31774b.get(view);
            if (aVar2 != null) {
                aVar2.b(aVar.l());
            } else {
                this.f31774b.put(view, new C0050a(eVar, aVar.l()));
            }
        }
    }

    public View a(String str) {
        return this.f31775c.get(str);
    }

    public void d() {
        this.f31773a.clear();
        this.f31774b.clear();
        this.f31775c.clear();
        this.f31776d.clear();
        this.f31777e.clear();
        this.f31778f.clear();
        this.f31779g.clear();
        this.f31782j = false;
        this.f31780h.clear();
    }

    public C0050a g(View view) {
        C0050a aVar = this.f31774b.get(view);
        if (aVar != null) {
            this.f31774b.remove(view);
        }
        return aVar;
    }

    public String h(String str) {
        return this.f31779g.get(str);
    }

    public HashSet<String> i() {
        return this.f31778f;
    }

    public String j(View view) {
        if (this.f31773a.size() == 0) {
            return null;
        }
        String str = this.f31773a.get(view);
        if (str != null) {
            this.f31773a.remove(view);
        }
        return str;
    }

    public HashSet<String> k() {
        return this.f31777e;
    }

    public boolean l(String str) {
        return this.f31780h.contains(str);
    }

    public c m(View view) {
        return this.f31776d.contains(view) ? c.PARENT_VIEW : this.f31782j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void n() {
        this.f31782j = true;
    }

    public void o() {
        c e2 = c.e();
        if (e2 != null) {
            for (com.iab.omid.library.vungle.adsession.a next : e2.a()) {
                View h2 = next.h();
                if (next.k()) {
                    String l2 = next.l();
                    if (h2 != null) {
                        boolean e3 = h.e(h2);
                        if (e3) {
                            this.f31780h.add(l2);
                        }
                        String c2 = c(h2, e3);
                        if (c2 == null) {
                            this.f31777e.add(l2);
                            this.f31773a.put(h2, l2);
                            e(next);
                        } else if (c2 != "noWindowFocus") {
                            this.f31778f.add(l2);
                            this.f31775c.put(l2, h2);
                            this.f31779g.put(l2, c2);
                        }
                    } else {
                        this.f31778f.add(l2);
                        this.f31779g.put(l2, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f31781i.containsKey(view)) {
            return true;
        }
        this.f31781i.put(view, Boolean.TRUE);
        return false;
    }
}
