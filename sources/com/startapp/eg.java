package com.startapp;

import android.view.View;
import android.view.ViewGroup;
import com.startapp.bg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class eg implements bg {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f34493a = new int[2];

    public JSONObject a(View view) {
        if (view == null) {
            return fg.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f34493a);
        int[] iArr = this.f34493a;
        return fg.a(iArr[0], iArr[1], width, height);
    }

    public void a(View view, JSONObject jSONObject, bg.a aVar, boolean z2, boolean z3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            if (z2) {
                HashMap hashMap = new HashMap();
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                    }
                    arrayList.add(childAt);
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(hashMap.keySet());
                Collections.sort(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Iterator it3 = ((ArrayList) hashMap.get((Float) it2.next())).iterator();
                    while (it3.hasNext()) {
                        ((d0) aVar).a((View) it3.next(), this, jSONObject, z3);
                    }
                }
                return;
            }
            while (i2 < viewGroup.getChildCount()) {
                ((d0) aVar).a(viewGroup.getChildAt(i2), this, jSONObject, z3);
                i2++;
            }
        }
    }
}
