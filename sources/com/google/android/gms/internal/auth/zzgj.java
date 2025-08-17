package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgj {
    private static final Class zza;
    private static final zzgy zzb = zzj(false);
    private static final zzgy zzc = zzj(true);
    private static final zzgy zzd = new zzha();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgy zza() {
        return zzb;
    }

    public static zzgy zzb() {
        return zzc;
    }

    public static zzgy zzc() {
        return zzd;
    }

    static Object zzd(int i2, List list, zzex zzex, Object obj, zzgy zzgy) {
        if (zzex == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = ((Integer) list.get(i4)).intValue();
                if (zzex.zza()) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    obj = zze(i2, intValue, obj, zzgy);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
                return obj;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Integer) it2.next()).intValue();
                if (!zzex.zza()) {
                    obj = zze(i2, intValue2, obj, zzgy);
                    it2.remove();
                }
            }
        }
        return obj;
    }

    static Object zze(int i2, int i3, Object obj, zzgy zzgy) {
        if (obj == null) {
            obj = zzgy.zzc();
        }
        zzgy.zzd(obj, i2, (long) i3);
        return obj;
    }

    static void zzf(zzgy zzgy, Object obj, Object obj2) {
        zzgy.zzf(obj, zzgy.zzb(zzgy.zza(obj), zzgy.zza(obj2)));
    }

    public static void zzg(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzi(zzfr zzfr, Object obj, Object obj2, long j2) {
        zzhi.zzp(obj, j2, zzfr.zza(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2)));
    }

    private static zzgy zzj(boolean z2) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgy) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z2)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
