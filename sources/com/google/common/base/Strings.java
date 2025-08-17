package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Strings {
    private Strings() {
    }

    public static String a(String str) {
        return Platform.a(str);
    }

    public static String b(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i2 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i3 = 0; i3 < objArr.length; i3++) {
                objArr[i3] = c(objArr[i3]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i4 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i4)) != -1) {
            sb.append(valueOf, i4, indexOf);
            sb.append(objArr[i2]);
            int i5 = i2 + 1;
            i4 = indexOf + 2;
            i2 = i5;
        }
        sb.append(valueOf, i4, valueOf.length());
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i6 = i2 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String c(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e2) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, e2);
            return "<" + str + " threw " + e2.getClass().getName() + ">";
        }
    }

    public static String d(String str) {
        return Platform.c(str);
    }
}
