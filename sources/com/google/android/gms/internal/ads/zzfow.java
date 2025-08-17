package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

public final class zzfow {
    static final CharSequence zza(Object obj) {
        obj.getClass();
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public static final StringBuilder zzb(StringBuilder sb, Iterable iterable, String str) {
        Iterator it2 = iterable.iterator();
        try {
            if (it2.hasNext()) {
                sb.append(zza(it2.next()));
                while (it2.hasNext()) {
                    sb.append(str);
                    sb.append(zza(it2.next()));
                }
            }
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
