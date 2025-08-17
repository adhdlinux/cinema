package com.chartboost.sdk.impl;

import android.view.View;
import com.chartboost.sdk.impl.td;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class le implements td {

    /* renamed from: a  reason: collision with root package name */
    public final td f18165a;

    public le(td tdVar) {
        this.f18165a = tdVar;
    }

    public ArrayList a() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        ke c2 = ke.c();
        if (c2 != null) {
            Collection<qd> a2 = c2.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            for (qd e2 : a2) {
                View e3 = e2.e();
                if (e3 != null && ef.e(e3) && (rootView = e3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float c3 = ef.c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && ef.c((View) arrayList.get(size - 1)) > c3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public JSONObject a(View view) {
        JSONObject a2 = me.a(0, 0, 0, 0);
        me.a(a2, ve.a());
        return a2;
    }

    public void a(View view, JSONObject jSONObject, td.a aVar, boolean z2, boolean z3) {
        Iterator it2 = a().iterator();
        while (it2.hasNext()) {
            aVar.a((View) it2.next(), this.f18165a, jSONObject, z3);
        }
    }
}
