package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Set;

public abstract class zzau extends zzaq implements Set {
    private transient zzat zza;

    zzau() {
    }

    static int zzf(int i2) {
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

    public static zzau zzi(Object obj, Object obj2) {
        return zzk(2, obj, obj2);
    }

    private static zzau zzk(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzax.zza;
        }
        if (i2 != 1) {
            int zzf = zzf(i2);
            Object[] objArr2 = new Object[zzf];
            int i3 = zzf - 1;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < i2) {
                Object obj = objArr[i4];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int zza2 = zzap.zza(hashCode);
                    while (true) {
                        int i7 = zza2 & i3;
                        Object obj2 = objArr2[i7];
                        if (obj2 != null) {
                            if (obj2.equals(obj)) {
                                break;
                            }
                            zza2++;
                        } else {
                            objArr[i6] = obj;
                            objArr2[i7] = obj;
                            i5 += hashCode;
                            i6++;
                            break;
                        }
                    }
                    i4++;
                } else {
                    throw new NullPointerException("at index " + i4);
                }
            }
            Arrays.fill(objArr, i6, i2, (Object) null);
            if (i6 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzay(obj3);
            }
            if (zzf(i6) < zzf / 2) {
                return zzk(i6, objArr);
            }
            if (i6 <= 0) {
                objArr = Arrays.copyOf(objArr, i6);
            }
            return new zzax(objArr, i5, objArr2, i3, i6);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzay(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzau) && zzj() && ((zzau) obj).zzj() && hashCode() != obj.hashCode()) {
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
        int i2;
        int i3 = 0;
        for (Object next : this) {
            if (next != null) {
                i2 = next.hashCode();
            } else {
                i2 = 0;
            }
            i3 += i2;
        }
        return i3;
    }

    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzat zzg() {
        zzat zzat = this.zza;
        if (zzat != null) {
            return zzat;
        }
        zzat zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzat zzh() {
        Object[] array = toArray();
        int i2 = zzat.zzd;
        return zzat.zzg(array, array.length);
    }

    /* access modifiers changed from: package-private */
    public boolean zzj() {
        return false;
    }
}
