package com.iab.omid.library.vungle.processor;

import android.view.View;
import com.iab.omid.library.vungle.processor.a;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f31734a;

    public c(a aVar) {
        this.f31734a = aVar;
    }

    public JSONObject a(View view) {
        JSONObject c2 = com.iab.omid.library.vungle.utils.c.c(0, 0, 0, 0);
        com.iab.omid.library.vungle.utils.c.e(c2, e.a());
        return c2;
    }

    public void a(View view, JSONObject jSONObject, a.C0048a aVar, boolean z2, boolean z3) {
        Iterator<View> it2 = b().iterator();
        while (it2.hasNext()) {
            aVar.a(it2.next(), this.f31734a, jSONObject, z3);
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.vungle.internal.c e2 = com.iab.omid.library.vungle.internal.c.e();
        if (e2 != null) {
            Collection<com.iab.omid.library.vungle.adsession.a> a2 = e2.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            for (com.iab.omid.library.vungle.adsession.a h2 : a2) {
                View h3 = h2.h();
                if (h3 != null && h.g(h3) && (rootView = h3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d2 = h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.d(arrayList.get(size - 1)) > d2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
