package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;

public final class zzfhv implements zzfht {
    private final zzfht zza;

    public zzfhv(zzfht zzfht) {
        this.zza = zzfht;
    }

    public final JSONObject zza(View view) {
        throw null;
    }

    public final void zzb(View view, JSONObject jSONObject, zzfhs zzfhs, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        zzfhl zza2 = zzfhl.zza();
        if (zza2 != null) {
            Collection<zzfha> zzb = zza2.zzb();
            int size = zzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            for (zzfha zzf : zzb) {
                View zzf2 = zzf.zzf();
                if (zzf2 != null && zzf2.isAttachedToWindow() && zzf2.isShown()) {
                    View view2 = zzf2;
                    while (true) {
                        if (view2 != null) {
                            if (view2.getAlpha() == 0.0f) {
                                break;
                            }
                            ViewParent parent = view2.getParent();
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            } else {
                                view2 = null;
                            }
                        } else {
                            View rootView = zzf2.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float zza3 = zzfie.zza(rootView);
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i2 = size2 - 1;
                                    if (zzfie.zza((View) arrayList.get(i2)) <= zza3) {
                                        break;
                                    }
                                    size2 = i2;
                                }
                                arrayList.add(size2, rootView);
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzfhs.zza((View) arrayList.get(i3), this.zza, jSONObject, z3);
        }
    }
}
