package com.facebook.ads.internal.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.ads.internal.m.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

public class e {

    public interface a {
        d a();

        Collection<String> b();

        String c();
    }

    public static Collection<String> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.optString(i2));
        }
        return hashSet;
    }

    public static boolean a(Context context, a aVar, c cVar) {
        Collection<String> b2;
        boolean z2;
        d a2 = aVar.a();
        if (!(a2 == null || a2 == d.NONE || (b2 = aVar.b()) == null || b2.isEmpty())) {
            Iterator<String> it2 = b2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (a(context, it2.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2 == (a2 == d.INSTALLED)) {
                String c2 = aVar.c();
                if (!TextUtils.isEmpty(c2)) {
                    cVar.b(c2, (Map<String, String>) null);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }
}
