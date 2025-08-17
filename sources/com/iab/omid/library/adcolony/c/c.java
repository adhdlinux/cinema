package com.iab.omid.library.adcolony.c;

import android.view.View;
import com.iab.omid.library.adcolony.c.a;
import com.iab.omid.library.adcolony.d.b;
import com.iab.omid.library.adcolony.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f31401a;

    public c(a aVar) {
        this.f31401a = aVar;
    }

    public JSONObject a(View view) {
        return b.b(0, 0, 0, 0);
    }

    public void a(View view, JSONObject jSONObject, a.C0042a aVar, boolean z2, boolean z3) {
        Iterator<View> it2 = b().iterator();
        while (it2.hasNext()) {
            aVar.a(it2.next(), this.f31401a, jSONObject, z3);
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.adcolony.b.a a2 = com.iab.omid.library.adcolony.b.a.a();
        if (a2 != null) {
            Collection<com.iab.omid.library.adcolony.adsession.a> e2 = a2.e();
            IdentityHashMap identityHashMap = new IdentityHashMap((e2.size() * 2) + 3);
            for (com.iab.omid.library.adcolony.adsession.a s2 : e2) {
                View s3 = s2.s();
                if (s3 != null && f.c(s3) && (rootView = s3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a3 = f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && f.a(arrayList.get(size - 1)) > a3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
