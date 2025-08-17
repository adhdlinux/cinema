package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.startapp.bg;
import com.startapp.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d0 implements bg.a {

    /* renamed from: a  reason: collision with root package name */
    public static d0 f34311a = new d0();

    /* renamed from: b  reason: collision with root package name */
    public static Handler f34312b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public static Handler f34313c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final Runnable f34314d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final Runnable f34315e = new d();

    /* renamed from: f  reason: collision with root package name */
    public List<b> f34316f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public int f34317g;

    /* renamed from: h  reason: collision with root package name */
    public final List<ng> f34318h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public cg f34319i = new cg();

    /* renamed from: j  reason: collision with root package name */
    public f0 f34320j = new f0();

    /* renamed from: k  reason: collision with root package name */
    public gg f34321k = new gg(new jg());

    /* renamed from: l  reason: collision with root package name */
    public long f34322l;

    public interface a extends b {
        void b(int i2, long j2);
    }

    public interface b {
        void a(int i2, long j2);
    }

    public class c implements Runnable {
        public void run() {
            String str;
            Boolean bool;
            d0 d0Var = d0.f34311a;
            d0Var.f34317g = 0;
            d0Var.f34318h.clear();
            for (T t2 : Collections.unmodifiableCollection(g.f34545a.f34547c)) {
                t2.getClass();
            }
            d0Var.f34322l = System.nanoTime();
            f0 f0Var = d0Var.f34320j;
            f0Var.getClass();
            g gVar = g.f34545a;
            if (gVar != null) {
                for (T t3 : Collections.unmodifiableCollection(gVar.f34547c)) {
                    View b2 = t3.b();
                    if (t3.c()) {
                        String str2 = t3.f36853i;
                        if (b2 != null) {
                            if (!b2.isAttachedToWindow()) {
                                str = "notAttached";
                            } else {
                                if (b2.hasWindowFocus()) {
                                    f0Var.f34501h.remove(b2);
                                    bool = Boolean.FALSE;
                                } else if (f0Var.f34501h.containsKey(b2)) {
                                    bool = f0Var.f34501h.get(b2);
                                } else {
                                    Map<View, Boolean> map = f0Var.f34501h;
                                    Boolean bool2 = Boolean.FALSE;
                                    map.put(b2, bool2);
                                    bool = bool2;
                                }
                                if (bool.booleanValue()) {
                                    str = "noWindowFocus";
                                } else {
                                    HashSet hashSet = new HashSet();
                                    View view = b2;
                                    while (true) {
                                        if (view == null) {
                                            f0Var.f34497d.addAll(hashSet);
                                            str = null;
                                            break;
                                        }
                                        String a2 = p.a(view);
                                        if (a2 != null) {
                                            str = a2;
                                            break;
                                        }
                                        hashSet.add(view);
                                        ViewParent parent = view.getParent();
                                        if (parent instanceof View) {
                                            view = (View) parent;
                                        } else {
                                            view = null;
                                        }
                                    }
                                }
                            }
                            if (str == null) {
                                f0Var.f34498e.add(str2);
                                f0Var.f34494a.put(b2, str2);
                                for (i next : t3.f36848d) {
                                    View view2 = (View) next.f34674a.get();
                                    if (view2 != null) {
                                        f0.a aVar = f0Var.f34495b.get(view2);
                                        if (aVar != null) {
                                            aVar.f34504b.add(t3.f36853i);
                                        } else {
                                            f0Var.f34495b.put(view2, new f0.a(next, t3.f36853i));
                                        }
                                    }
                                }
                            } else if (str != "noWindowFocus") {
                                f0Var.f34499f.add(str2);
                                f0Var.f34496c.put(str2, b2);
                                f0Var.f34500g.put(str2, str);
                            }
                        } else {
                            f0Var.f34499f.add(str2);
                            f0Var.f34500g.put(str2, "noAdView");
                        }
                    }
                }
            }
            long nanoTime = System.nanoTime();
            dg dgVar = d0Var.f34319i.f34310b;
            if (d0Var.f34320j.f34499f.size() > 0) {
                Iterator<String> it2 = d0Var.f34320j.f34499f.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    JSONObject a3 = dgVar.a((View) null);
                    View view3 = d0Var.f34320j.f34496c.get(next2);
                    eg egVar = d0Var.f34319i.f34309a;
                    String str3 = d0Var.f34320j.f34500g.get(next2);
                    if (str3 != null) {
                        JSONObject a4 = egVar.a(view3);
                        WindowManager windowManager = fg.f34542a;
                        try {
                            a4.put("adSessionId", next2);
                        } catch (JSONException e2) {
                            p.a("Error with setting ad session id", (Exception) e2);
                        }
                        try {
                            a4.put("notVisibleReason", str3);
                        } catch (JSONException e3) {
                            p.a("Error with setting not visible reason", (Exception) e3);
                        }
                        fg.a(a3, a4);
                    }
                    fg.a(a3);
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(next2);
                    gg ggVar = d0Var.f34321k;
                    ggVar.f34603b.a(new lg(ggVar, hashSet2, a3, nanoTime));
                }
            }
            if (d0Var.f34320j.f34498e.size() > 0) {
                JSONObject a5 = dgVar.a((View) null);
                dgVar.a((View) null, a5, d0Var, true, false);
                fg.a(a5);
                gg ggVar2 = d0Var.f34321k;
                ggVar2.f34603b.a(new mg(ggVar2, d0Var.f34320j.f34498e, a5, nanoTime));
            } else {
                gg ggVar3 = d0Var.f34321k;
                ggVar3.f34603b.a(new kg(ggVar3));
            }
            f0 f0Var2 = d0Var.f34320j;
            f0Var2.f34494a.clear();
            f0Var2.f34495b.clear();
            f0Var2.f34496c.clear();
            f0Var2.f34497d.clear();
            f0Var2.f34498e.clear();
            f0Var2.f34499f.clear();
            f0Var2.f34500g.clear();
            f0Var2.f34502i = false;
            long nanoTime2 = System.nanoTime() - d0Var.f34322l;
            if (d0Var.f34316f.size() > 0) {
                for (b next3 : d0Var.f34316f) {
                    next3.a(d0Var.f34317g, TimeUnit.NANOSECONDS.toMillis(nanoTime2));
                    if (next3 instanceof a) {
                        ((a) next3).b(d0Var.f34317g, nanoTime2);
                    }
                }
            }
        }
    }

    public class d implements Runnable {
        public void run() {
            Handler handler = d0.f34313c;
            if (handler != null) {
                handler.post(d0.f34314d);
                d0.f34313c.postDelayed(d0.f34315e, 200);
            }
        }
    }

    public final void a(View view, bg bgVar, JSONObject jSONObject, com.iab.omid.library.startio.walking.b bVar, boolean z2) {
        bgVar.a(view, jSONObject, this, bVar == com.iab.omid.library.startio.walking.b.PARENT_VIEW, z2);
    }

    public void a(View view, bg bgVar, JSONObject jSONObject, boolean z2) {
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        if (p.a(view) == null) {
            f0 f0Var = this.f34320j;
            com.iab.omid.library.startio.walking.b bVar = f0Var.f34497d.contains(view) ? com.iab.omid.library.startio.walking.b.PARENT_VIEW : f0Var.f34502i ? com.iab.omid.library.startio.walking.b.OBSTRUCTION_VIEW : com.iab.omid.library.startio.walking.b.UNDERLYING_VIEW;
            if (bVar != com.iab.omid.library.startio.walking.b.UNDERLYING_VIEW) {
                JSONObject a2 = bgVar.a(view);
                fg.a(jSONObject, a2);
                f0 f0Var2 = this.f34320j;
                if (f0Var2.f34494a.size() == 0) {
                    str = null;
                } else {
                    String str2 = f0Var2.f34494a.get(view);
                    if (str2 != null) {
                        f0Var2.f34494a.remove(view);
                    }
                    str = str2;
                }
                if (str != null) {
                    try {
                        a2.put("adSessionId", str);
                    } catch (JSONException e2) {
                        p.a("Error with setting ad session id", (Exception) e2);
                    }
                    f0 f0Var3 = this.f34320j;
                    if (f0Var3.f34501h.containsKey(view)) {
                        f0Var3.f34501h.put(view, Boolean.TRUE);
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    try {
                        a2.put("hasWindowFocus", Boolean.valueOf(z5));
                    } catch (JSONException e3) {
                        p.a("Error with setting not visible reason", (Exception) e3);
                    }
                    this.f34320j.f34502i = true;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    f0 f0Var4 = this.f34320j;
                    f0.a aVar = f0Var4.f34495b.get(view);
                    if (aVar != null) {
                        f0Var4.f34495b.remove(view);
                    }
                    if (aVar != null) {
                        WindowManager windowManager = fg.f34542a;
                        i iVar = aVar.f34503a;
                        JSONArray jSONArray = new JSONArray();
                        for (String put : aVar.f34504b) {
                            jSONArray.put(put);
                        }
                        try {
                            a2.put("isFriendlyObstructionFor", jSONArray);
                            a2.put("friendlyObstructionClass", iVar.f34675b);
                            a2.put("friendlyObstructionPurpose", iVar.f34676c);
                            a2.put("friendlyObstructionReason", iVar.f34677d);
                        } catch (JSONException e4) {
                            p.a("Error with setting friendly obstruction", (Exception) e4);
                        }
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    a(view, bgVar, a2, bVar, z2 || z4);
                }
                this.f34317g++;
            }
        }
    }

    public void a() {
        if (f34313c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f34313c = handler;
            handler.post(f34314d);
            f34313c.postDelayed(f34315e, 200);
        }
    }
}
