package com.startapp;

import android.view.View;
import android.view.ViewParent;
import com.startapp.bg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class dg implements bg {

    /* renamed from: a  reason: collision with root package name */
    public final bg f34386a;

    public dg(bg bgVar) {
        this.f34386a = bgVar;
    }

    public JSONObject a(View view) {
        return fg.a(0, 0, 0, 0);
    }

    public void a(View view, JSONObject jSONObject, bg.a aVar, boolean z2, boolean z3) {
        boolean z4;
        View rootView;
        ArrayList arrayList = new ArrayList();
        g gVar = g.f34545a;
        if (gVar != null) {
            Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(gVar.f34547c);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (T b2 : unmodifiableCollection) {
                View b3 = b2.b();
                if (b3 != null) {
                    if (b3.isAttachedToWindow() && b3.isShown()) {
                        View view2 = b3;
                        while (true) {
                            if (view2 == null) {
                                z4 = true;
                                break;
                            } else if (view2.getAlpha() == 0.0f) {
                                break;
                            } else {
                                ViewParent parent = view2.getParent();
                                if (parent instanceof View) {
                                    view2 = (View) parent;
                                } else {
                                    view2 = null;
                                }
                            }
                        }
                    }
                    z4 = false;
                    if (z4 && (rootView = b3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float z5 = rootView.getZ();
                        int size = arrayList.size();
                        while (size > 0 && ((View) arrayList.get(size - 1)).getZ() > z5) {
                            size--;
                        }
                        arrayList.add(size, rootView);
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((d0) aVar).a((View) it2.next(), this.f34386a, jSONObject, z3);
        }
    }
}
