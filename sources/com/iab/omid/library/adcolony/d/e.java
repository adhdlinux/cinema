package com.iab.omid.library.adcolony.d;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.CreativeType;
import com.iab.omid.library.adcolony.adsession.ImpressionType;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.a;

public class e {
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

    public static void c(a aVar) {
        if (aVar.u()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void e(String str, int i2, String str2) {
        if (str.length() > i2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void g(a aVar) {
        if (aVar.w()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void h(a aVar) {
        m(aVar);
        g(aVar);
    }

    public static void i(a aVar) {
        if (aVar.v().q() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void j(a aVar) {
        if (aVar.v().r() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    public static void k(a aVar) {
        if (!aVar.x()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void l(a aVar) {
        if (!aVar.y()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    private static void m(a aVar) {
        if (!aVar.u()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
