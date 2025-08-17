package com.chartboost.sdk.impl;

import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class wd {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f18907a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f18908b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f18909c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet f18910d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet f18911e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final HashSet f18912f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f18913g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Map f18914h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    public boolean f18915i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final we f18916a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f18917b = new ArrayList();

        public a(we weVar, String str) {
            this.f18916a = weVar;
            a(str);
        }

        public we a() {
            return this.f18916a;
        }

        public ArrayList b() {
            return this.f18917b;
        }

        public void a(String str) {
            this.f18917b.add(str);
        }
    }

    public View a(String str) {
        return (View) this.f18909c.get(str);
    }

    public final Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f18914h.remove(view);
            return Boolean.FALSE;
        } else if (this.f18914h.containsKey(view)) {
            return (Boolean) this.f18914h.get(view);
        } else {
            Map map = this.f18914h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    public a c(View view) {
        a aVar = (a) this.f18908b.get(view);
        if (aVar != null) {
            this.f18908b.remove(view);
        }
        return aVar;
    }

    public String d(View view) {
        if (this.f18907a.size() == 0) {
            return null;
        }
        String str = (String) this.f18907a.get(view);
        if (str != null) {
            this.f18907a.remove(view);
        }
        return str;
    }

    public ne e(View view) {
        if (this.f18910d.contains(view)) {
            return ne.PARENT_VIEW;
        }
        return this.f18915i ? ne.OBSTRUCTION_VIEW : ne.UNDERLYING_VIEW;
    }

    public boolean f(View view) {
        if (!this.f18914h.containsKey(view)) {
            return true;
        }
        this.f18914h.put(view, Boolean.TRUE);
        return false;
    }

    public final String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a2 = ef.a(view);
            if (a2 != null) {
                return a2;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f18910d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return (String) this.f18913g.get(str);
    }

    public HashSet c() {
        return this.f18911e;
    }

    public void d() {
        this.f18915i = true;
    }

    public void e() {
        ke c2 = ke.c();
        if (c2 != null) {
            for (qd qdVar : c2.a()) {
                View e2 = qdVar.e();
                if (qdVar.h()) {
                    String j2 = qdVar.j();
                    if (e2 != null) {
                        String a2 = a(e2);
                        if (a2 == null) {
                            this.f18911e.add(j2);
                            this.f18907a.put(e2, j2);
                            a(qdVar);
                        } else if (a2 != "noWindowFocus") {
                            this.f18912f.add(j2);
                            this.f18909c.put(j2, e2);
                            this.f18913g.put(j2, a2);
                        }
                    } else {
                        this.f18912f.add(j2);
                        this.f18913g.put(j2, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f18907a.clear();
        this.f18908b.clear();
        this.f18909c.clear();
        this.f18910d.clear();
        this.f18911e.clear();
        this.f18912f.clear();
        this.f18913g.clear();
        this.f18915i = false;
    }

    public HashSet b() {
        return this.f18912f;
    }

    public final void a(qd qdVar) {
        for (we a2 : qdVar.f()) {
            a(a2, qdVar);
        }
    }

    public final void a(we weVar, qd qdVar) {
        View view = (View) weVar.c().get();
        if (view != null) {
            a aVar = (a) this.f18908b.get(view);
            if (aVar != null) {
                aVar.a(qdVar.j());
            } else {
                this.f18908b.put(view, new a(weVar, qdVar.j()));
            }
        }
    }
}
