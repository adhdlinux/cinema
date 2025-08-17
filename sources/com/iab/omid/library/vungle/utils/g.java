package com.iab.omid.library.vungle.utils;

import android.text.TextUtils;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;

public class g {
    public static void a() {
        if (!Omid.b()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(String str, int i2, String str2) {
        if (str.length() > i2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
