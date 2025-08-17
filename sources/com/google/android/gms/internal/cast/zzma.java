package com.google.android.gms.internal.cast;

import java.util.Iterator;

public final class zzma extends zzsh implements zztq {
    private static final zzsn zzb = new zzly();
    /* access modifiers changed from: private */
    public static final zzma zzd;
    private int zze;
    private zzmg zzf;
    private zzob zzg;
    private zzsp zzh = zzsh.zzz();
    private zzsm zzi = zzsh.zzx();

    static {
        zzma zzma = new zzma();
        zzd = zzma;
        zzsh.zzG(zzma.class, zzma);
    }

    private zzma() {
    }

    public static zzlz zza() {
        return (zzlz) zzd.zzu();
    }

    static /* synthetic */ void zzd(zzma zzma, zzmg zzmg) {
        zzmg.getClass();
        zzma.zzf = zzmg;
        zzma.zze |= 1;
    }

    static /* synthetic */ void zze(zzma zzma, Iterable iterable) {
        int i2;
        zzsm zzsm = zzma.zzi;
        if (!zzsm.zzc()) {
            int size = zzsm.size();
            if (size == 0) {
                i2 = 10;
            } else {
                i2 = size + size;
            }
            zzma.zzi = zzsm.zzf(i2);
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            zzma.zzi.zzh(((zzln) it2.next()).zza());
        }
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zze", "zzf", "zzg", "zzh", zznx.class, "zzi", zzln.zzb()});
        } else if (i3 == 3) {
            return new zzma();
        } else {
            if (i3 == 4) {
                return new zzlz((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
