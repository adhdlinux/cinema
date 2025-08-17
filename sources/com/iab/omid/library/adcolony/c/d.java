package com.iab.omid.library.adcolony.c;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.adcolony.c.a;
import com.iab.omid.library.adcolony.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f31402a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.C0042a aVar, boolean z2) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            aVar.a(viewGroup.getChildAt(i2), this, jSONObject, z2);
        }
    }

    @TargetApi(21)
    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.C0042a aVar, boolean z2) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((ArrayList) hashMap.get((Float) it2.next())).iterator();
            while (it3.hasNext()) {
                aVar.a((View) it3.next(), this, jSONObject, z2);
            }
        }
    }

    public JSONObject a(View view) {
        if (view == null) {
            return b.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f31402a);
        int[] iArr = this.f31402a;
        return b.b(iArr[0], iArr[1], width, height);
    }

    public void a(View view, JSONObject jSONObject, a.C0042a aVar, boolean z2, boolean z3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z2) {
                c(viewGroup, jSONObject, aVar, z3);
            } else {
                b(viewGroup, jSONObject, aVar, z3);
            }
        }
    }
}
