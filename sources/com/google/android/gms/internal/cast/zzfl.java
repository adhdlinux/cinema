package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public abstract class zzfl extends zzfd implements Set {
    private transient zzfh zza;

    zzfl() {
    }

    static int zzh(int i2) {
        int max = Math.max(i2, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    public static zzfl zzj(Collection collection) {
        Object[] array = collection.toArray();
        return zzm(array.length, array);
    }

    public static zzfl zzk() {
        return zzfu.zza;
    }

    private static zzfl zzm(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzfu.zza;
        }
        if (i2 != 1) {
            int zzh = zzh(i2);
            Object[] objArr2 = new Object[zzh];
            int i3 = zzh - 1;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                Object obj = objArr[i6];
                zzfn.zza(obj, i6);
                int hashCode = obj.hashCode();
                int zza2 = zzfa.zza(hashCode);
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
                return new zzfw(obj3);
            }
            if (zzh(i5) < zzh / 2) {
                return zzm(i5, objArr);
            }
            int length = objArr.length;
            if (i5 < (length >> 1) + (length >> 2)) {
                objArr = Arrays.copyOf(objArr, i5);
            }
            return new zzfu(objArr, i4, objArr2, i3, i5);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzfw(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfl) && zzl() && ((zzfl) obj).zzl() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzfv.zza(this);
    }

    public zzfh zzd() {
        zzfh zzfh = this.zza;
        if (zzfh != null) {
            return zzfh;
        }
        zzfh zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    /* renamed from: zze */
    public abstract zzfx iterator();

    /* access modifiers changed from: package-private */
    public zzfh zzi() {
        Object[] array = toArray();
        int i2 = zzfh.zzd;
        return zzfh.zzi(array, array.length);
    }

    /* access modifiers changed from: package-private */
    public boolean zzl() {
        return false;
    }
}
