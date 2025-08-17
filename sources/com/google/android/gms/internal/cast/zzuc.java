package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

final class zzuc {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzur zzc = zzW(false);
    private static final zzur zzd = zzW(true);
    private static final zzur zze = new zzut();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
    }

    public static zzur zzA() {
        return zze;
    }

    static void zzB(zzur zzur, Object obj, Object obj2) {
        zzur.zzf(obj, zzur.zzd(zzur.zzc(obj), zzur.zzc(obj2)));
    }

    public static void zzC(Class cls) {
        Class cls2;
        if (!zzsh.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzD(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzc(i2, list, z2);
        }
    }

    public static void zzE(int i2, List list, zzvi zzvi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zze(i2, list);
        }
    }

    public static void zzF(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzg(i2, list, z2);
        }
    }

    public static void zzG(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzi(i2, list, z2);
        }
    }

    public static void zzH(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzk(i2, list, z2);
        }
    }

    public static void zzI(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzm(i2, list, z2);
        }
    }

    public static void zzJ(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzo(i2, list, z2);
        }
    }

    public static void zzK(int i2, List list, zzvi zzvi, zzua zzua) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((zzrv) zzvi).zzp(i2, list.get(i3), zzua);
            }
        }
    }

    public static void zzL(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzr(i2, list, z2);
        }
    }

    public static void zzM(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzt(i2, list, z2);
        }
    }

    public static void zzN(int i2, List list, zzvi zzvi, zzua zzua) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((zzrv) zzvi).zzu(i2, list.get(i3), zzua);
            }
        }
    }

    public static void zzO(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzw(i2, list, z2);
        }
    }

    public static void zzP(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzy(i2, list, z2);
        }
    }

    public static void zzQ(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzA(i2, list, z2);
        }
    }

    public static void zzR(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzC(i2, list, z2);
        }
    }

    public static void zzS(int i2, List list, zzvi zzvi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzE(i2, list);
        }
    }

    public static void zzT(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzG(i2, list, z2);
        }
    }

    public static void zzU(int i2, List list, zzvi zzvi, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzI(i2, list, z2);
        }
    }

    static boolean zzV(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzur zzW(boolean z2) {
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
            return (zzur) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z2)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i2 << 3) + 1);
    }

    static int zzb(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzru.zzx(i2 << 3);
        for (int i3 = 0; i3 < list.size(); i3++) {
            int zzd2 = ((zzrm) list.get(i3)).zzd();
            zzx += zzru.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    static int zzc(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzd(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzru.zzu(zzsi.zzd(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzru.zzu(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zze(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i2 << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i2 << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i2, List list, zzua zzua) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzru.zzt(i2, (zztp) list.get(i4), zzua);
        }
        return i3;
    }

    static int zzj(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzk(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzru.zzu(zzsi.zzd(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzru.zzu(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzl(int i2, List list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzru.zzx(i2 << 3));
    }

    static int zzm(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzru.zzy(zzte.zzd(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzru.zzy(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzn(int i2, Object obj, zzua zzua) {
        if (obj instanceof zzsv) {
            int i3 = zzru.zzb;
            int zza2 = ((zzsv) obj).zza();
            return zzru.zzx(i2 << 3) + zzru.zzx(zza2) + zza2;
        }
        return zzru.zzx(i2 << 3) + zzru.zzv((zztp) obj, zzua);
    }

    static int zzo(int i2, List list, zzua zzua) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzru.zzx(i2 << 3) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzsv) {
                int zza2 = ((zzsv) obj).zza();
                zzx += zzru.zzx(zza2) + zza2;
            } else {
                zzx += zzru.zzv((zztp) obj, zzua);
            }
        }
        return zzx;
    }

    static int zzp(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzq(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i2 = 0;
            while (i3 < size) {
                int zzd2 = zzsi.zzd(i3);
                i2 += zzru.zzx((zzd2 >> 31) ^ (zzd2 + zzd2));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                int intValue = ((Integer) list.get(i3)).intValue();
                i4 = i2 + zzru.zzx((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzr(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzs(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i2 = 0;
            while (i3 < size) {
                long zzd2 = zzte.zzd(i3);
                i2 += zzru.zzy((zzd2 >> 63) ^ (zzd2 + zzd2));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                long longValue = ((Long) list.get(i3)).longValue();
                i4 = i2 + zzru.zzy((longValue >> 63) ^ (longValue + longValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzt(int i2, List list) {
        int zzw;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int i4 = zzru.zzb;
        boolean z2 = list instanceof zzsx;
        int zzx = zzru.zzx(i2 << 3) * size;
        if (z2) {
            zzsx zzsx = (zzsx) list;
            while (i3 < size) {
                Object zze2 = zzsx.zze(i3);
                if (zze2 instanceof zzrm) {
                    int zzd2 = ((zzrm) zze2).zzd();
                    zzx += zzru.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzru.zzw((String) zze2);
                }
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzrm) {
                    int zzd3 = ((zzrm) obj).zzd();
                    zzw = zzx + zzru.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzru.zzw((String) obj);
                }
                i3++;
            }
        }
        return zzx;
    }

    static int zzu(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzv(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzru.zzx(zzsi.zzd(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzru.zzx(((Integer) list.get(i3)).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzw(int i2, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzru.zzx(i2 << 3));
    }

    static int zzx(List list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzru.zzy(zzte.zzd(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzru.zzy(((Long) list.get(i3)).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static zzur zzy() {
        return zzc;
    }

    public static zzur zzz() {
        return zzd;
    }
}
