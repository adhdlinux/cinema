package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public abstract class zzfsh extends zzfrx implements Set {
    private transient zzfsc zza;

    zzfsh() {
    }

    static int zzh(int i2) {
        boolean z2;
        int max = Math.max(i2, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        }
        if (max < 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzf(z2, "collection too large");
        return 1073741824;
    }

    public static zzfsg zzj(int i2) {
        return new zzfsg(i2);
    }

    public static zzfsh zzl(Collection collection) {
        Object[] array = collection.toArray();
        return zzs(array.length, array);
    }

    public static zzfsh zzm() {
        return zzfts.zza;
    }

    public static zzfsh zzn(Object obj) {
        return new zzftz(obj);
    }

    public static zzfsh zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzs(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfsh zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 6);
        return zzs(12, objArr2);
    }

    /* access modifiers changed from: private */
    public static zzfsh zzs(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzfts.zza;
        }
        if (i2 != 1) {
            int zzh = zzh(i2);
            Object[] objArr2 = new Object[zzh];
            int i3 = zzh - 1;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                Object obj = objArr[i6];
                zzftk.zza(obj, i6);
                int hashCode = obj.hashCode();
                int zza2 = zzfru.zza(hashCode);
                while (true) {
                    int i7 = zza2 & i3;
                    Object obj2 = objArr2[i7];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zza2++;
                    } else {
                        objArr[i5] = obj;
                        objArr2[i7] = obj;
                        i4 += hashCode;
                        i5++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i5, i2, (Object) null);
            if (i5 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzftz(obj3);
            }
            if (zzh(i5) < zzh / 2) {
                return zzs(i5, objArr);
            }
            if (zzt(i5, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i5);
            }
            return new zzfts(objArr, i4, objArr2, i3, i5);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzftz(obj4);
    }

    /* access modifiers changed from: private */
    public static boolean zzt(int i2, int i3) {
        return i2 < (i3 >> 1) + (i3 >> 2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfsh) || !zzr() || !((zzfsh) obj).zzr() || hashCode() == obj.hashCode()) {
            return zzfty.zzc(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzfty.zza(this);
    }

    public zzfsc zzd() {
        zzfsc zzfsc = this.zza;
        if (zzfsc != null) {
            return zzfsc;
        }
        zzfsc zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    /* renamed from: zze */
    public abstract zzfuc iterator();

    /* access modifiers changed from: package-private */
    public zzfsc zzi() {
        Object[] array = toArray();
        int i2 = zzfsc.zzd;
        return zzfsc.zzi(array, array.length);
    }

    /* access modifiers changed from: package-private */
    public boolean zzr() {
        return false;
    }
}
