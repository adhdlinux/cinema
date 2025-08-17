package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzgqz<T> implements zzgrp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgsq.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgqw zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzgqk zzm;
    private final zzgsg zzn;
    private final zzgoz zzo;
    private final int zzp;
    private final zzgrb zzq;
    private final zzgqr zzr;

    private zzgqz(int[] iArr, Object[] objArr, int i2, int i3, zzgqw zzgqw, int i4, boolean z2, int[] iArr2, int i5, int i6, zzgrb zzgrb, zzgqk zzgqk, zzgsg zzgsg, zzgoz zzgoz, zzgqr zzgqr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i2;
        this.zzf = i3;
        this.zzi = zzgqw instanceof zzgpm;
        this.zzp = i4;
        boolean z3 = false;
        if (zzgoz != null && zzgoz.zzh(zzgqw)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i5;
        this.zzl = i6;
        this.zzq = zzgrb;
        this.zzm = zzgqk;
        this.zzn = zzgsg;
        this.zzo = zzgoz;
        this.zzg = zzgqw;
        this.zzr = zzgqr;
    }

    private static long zzA(Object obj, long j2) {
        return ((Long) zzgsq.zzh(obj, j2)).longValue();
    }

    private final zzgpq zzB(int i2) {
        int i3 = i2 / 3;
        return (zzgpq) this.zzd[i3 + i3 + 1];
    }

    private final zzgrp zzC(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        zzgrp zzgrp = (zzgrp) this.zzd[i4];
        if (zzgrp != null) {
            return zzgrp;
        }
        zzgrp zzb2 = zzgre.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i2, Object obj2, zzgsg zzgsg, Object obj3) {
        int i3 = this.zzc[i2];
        Object zzh2 = zzgsq.zzh(obj, (long) (zzz(i2) & 1048575));
        if (zzh2 == null || zzB(i2) == null) {
            return obj2;
        }
        zzgqq zzgqq = (zzgqq) zzh2;
        zzgqp zzgqp = (zzgqp) zzE(i2);
        throw null;
    }

    private final Object zzE(int i2) {
        int i3 = i2 / 3;
        return this.zzd[i3 + i3];
    }

    private final Object zzF(Object obj, int i2) {
        zzgrp zzC = zzC(i2);
        int zzz = zzz(i2) & 1048575;
        if (!zzS(obj, i2)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) zzz);
        if (zzV(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzG(Object obj, int i2, int i3) {
        zzgrp zzC = zzC(i3);
        if (!zzW(obj, i2, i3)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzz(i3) & 1048575));
        if (zzV(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzH(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzI(Object obj) {
        if (!zzV(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i2) {
        if (zzS(obj2, i2)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i2) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzgrp zzC = zzC(i2);
                if (!zzS(obj, i2)) {
                    if (!zzV(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzM(obj, i2);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzV(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i2];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzK(Object obj, Object obj2, int i2) {
        int i3 = this.zzc[i2];
        if (zzW(obj2, i3, i2)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i2) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzgrp zzC = zzC(i2);
                if (!zzW(obj, i3, i2)) {
                    if (!zzV(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzN(obj, i3, i2);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzV(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i4 = this.zzc[i2];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i4 + " is present but null: " + obj3);
        }
    }

    private final void zzL(Object obj, int i2, zzgrh zzgrh) throws IOException {
        if (zzR(i2)) {
            zzgsq.zzv(obj, (long) (i2 & 1048575), zzgrh.zzs());
        } else if (this.zzi) {
            zzgsq.zzv(obj, (long) (i2 & 1048575), zzgrh.zzr());
        } else {
            zzgsq.zzv(obj, (long) (i2 & 1048575), zzgrh.zzp());
        }
    }

    private final void zzM(Object obj, int i2) {
        int zzw = zzw(i2);
        long j2 = (long) (1048575 & zzw);
        if (j2 != 1048575) {
            zzgsq.zzt(obj, j2, (1 << (zzw >>> 20)) | zzgsq.zzd(obj, j2));
        }
    }

    private final void zzN(Object obj, int i2, int i3) {
        zzgsq.zzt(obj, (long) (zzw(i3) & 1048575), i2);
    }

    private final void zzO(Object obj, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i2) & 1048575), obj2);
        zzM(obj, i2);
    }

    private final void zzP(Object obj, int i2, int i3, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i3) & 1048575), obj2);
        zzN(obj, i2, i3);
    }

    private final boolean zzQ(Object obj, Object obj2, int i2) {
        return zzS(obj, i2) == zzS(obj2, i2);
    }

    private static boolean zzR(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final boolean zzS(Object obj, int i2) {
        int zzw = zzw(i2);
        long j2 = (long) (zzw & 1048575);
        if (j2 == 1048575) {
            int zzz = zzz(i2);
            long j3 = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzgsq.zzb(obj, j3)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzgsq.zzc(obj, j3)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzgsq.zzf(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzgsq.zzf(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzgsq.zzf(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzgsq.zzz(obj, j3);
                case 8:
                    Object zzh2 = zzgsq.zzh(obj, j3);
                    if (zzh2 instanceof String) {
                        if (!((String) zzh2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzh2 instanceof zzgoe)) {
                        throw new IllegalArgumentException();
                    } else if (!zzgoe.zzb.equals(zzh2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzgsq.zzh(obj, j3) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzgoe.zzb.equals(zzgsq.zzh(obj, j3))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzgsq.zzf(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzgsq.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzgsq.zzf(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzgsq.zzh(obj, j3) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzgsq.zzd(obj, j2) & (1 << (zzw >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean zzT(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? zzS(obj, i2) : (i4 & i5) != 0;
    }

    private static boolean zzU(Object obj, int i2, zzgrp zzgrp) {
        return zzgrp.zzk(zzgsq.zzh(obj, (long) (i2 & 1048575)));
    }

    private static boolean zzV(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgpm) {
            return ((zzgpm) obj).zzaY();
        }
        return true;
    }

    private final boolean zzW(Object obj, int i2, int i3) {
        if (zzgsq.zzd(obj, (long) (zzw(i3) & 1048575)) == i2) {
            return true;
        }
        return false;
    }

    private static boolean zzX(Object obj, long j2) {
        return ((Boolean) zzgsq.zzh(obj, j2)).booleanValue();
    }

    private final void zzY(zzgou zzgou, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            zzgqp zzgqp = (zzgqp) zzE(i3);
            throw null;
        }
    }

    private static final void zzZ(int i2, Object obj, zzgou zzgou) throws IOException {
        if (obj instanceof String) {
            zzgou.zzF(i2, (String) obj);
        } else {
            zzgou.zzd(i2, (zzgoe) obj);
        }
    }

    static zzgsh zzd(Object obj) {
        zzgpm zzgpm = (zzgpm) obj;
        zzgsh zzgsh = zzgpm.zzc;
        if (zzgsh != zzgsh.zzc()) {
            return zzgsh;
        }
        zzgsh zzf2 = zzgsh.zzf();
        zzgpm.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzgqz zzl(java.lang.Class r30, com.google.android.gms.internal.ads.zzgqt r31, com.google.android.gms.internal.ads.zzgrb r32, com.google.android.gms.internal.ads.zzgqk r33, com.google.android.gms.internal.ads.zzgsg r34, com.google.android.gms.internal.ads.zzgoz r35, com.google.android.gms.internal.ads.zzgqr r36) {
        /*
            r0 = r31
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgrg
            if (r1 == 0) goto L_0x03df
            com.google.android.gms.internal.ads.zzgrg r0 = (com.google.android.gms.internal.ads.zzgrg) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = zza
            r17 = r7
            r7 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            goto L_0x0166
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0166:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.ads.zzgqw r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r22 = r18
            r23 = r19
            r20 = 0
            r21 = 0
        L_0x0186:
            if (r4 >= r2) goto L_0x03ba
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01ae
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0196:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0196
        L_0x01a8:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b0
        L_0x01ae:
            r3 = r24
        L_0x01b0:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01be:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01be
        L_0x01d0:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d8
        L_0x01d6:
            r8 = r24
        L_0x01d8:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e2
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e2:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = 51
            if (r6 < r5) goto L_0x0284
            int r5 = r8 + 1
            char r8 = r1.charAt(r8)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0213
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r28 = 13
        L_0x01f9:
            int r29 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r2) goto L_0x020e
            r2 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r28
            r8 = r8 | r2
            int r28 = r28 + 13
            r5 = r29
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f9
        L_0x020e:
            int r2 = r5 << r28
            r8 = r8 | r2
            r5 = r29
        L_0x0213:
            int r2 = r6 + -51
            r28 = r5
            r5 = 9
            if (r2 == r5) goto L_0x023a
            r5 = 17
            if (r2 != r5) goto L_0x0220
            goto L_0x023a
        L_0x0220:
            r5 = 12
            if (r2 != r5) goto L_0x0247
            int r2 = r0.zzc()
            r5 = 1
            if (r2 == r5) goto L_0x022f
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0247
        L_0x022f:
            int r2 = r21 / 3
            int r2 = r2 + r2
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
            goto L_0x0245
        L_0x023a:
            int r2 = r21 / 3
            int r2 = r2 + r2
            r5 = 1
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
        L_0x0245:
            r16 = r5
        L_0x0247:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r5 = r2 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x0251
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0259
        L_0x0251:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzH(r15, r2)
            r10[r8] = r2
        L_0x0259:
            r5 = r13
            r29 = r14
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x026c
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x0274
        L_0x026c:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzH(r15, r13)
            r10[r8] = r13
        L_0x0274:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r27 = r5
            r24 = r8
            r25 = r28
            r8 = 0
            r28 = r1
            goto L_0x0385
        L_0x0284:
            r26 = r2
            r5 = r13
            r29 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzH(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x0306
            r14 = 17
            if (r6 != r14) goto L_0x029d
            goto L_0x0306
        L_0x029d:
            r14 = 27
            if (r6 == r14) goto L_0x02f6
            r14 = 49
            if (r6 != r14) goto L_0x02a6
            goto L_0x02f6
        L_0x02a6:
            r14 = 12
            if (r6 == r14) goto L_0x02de
            r14 = 30
            if (r6 == r14) goto L_0x02de
            r14 = 44
            if (r6 != r14) goto L_0x02b3
            goto L_0x02de
        L_0x02b3:
            r14 = 50
            if (r6 != r14) goto L_0x02da
            int r14 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            int r27 = r2 + 1
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02d6
            int r22 = r22 + 1
            int r2 = r27 + 1
            r27 = r10[r27]
            r12[r22] = r27
            r27 = r5
            r22 = r14
            goto L_0x02dc
        L_0x02d6:
            r22 = r14
            r2 = r27
        L_0x02da:
            r27 = r5
        L_0x02dc:
            r5 = 1
            goto L_0x0313
        L_0x02de:
            int r14 = r0.zzc()
            r27 = r5
            r5 = 1
            if (r14 == r5) goto L_0x02eb
            r14 = r3 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0313
        L_0x02eb:
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r24 = r2 + 1
            r2 = r10[r2]
            r12[r14] = r2
            goto L_0x0303
        L_0x02f6:
            r27 = r5
            r5 = 1
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r24 = r2 + 1
            r2 = r10[r2]
            r12[r14] = r2
        L_0x0303:
            r2 = r24
            goto L_0x0313
        L_0x0306:
            r27 = r5
            r5 = 1
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            java.lang.Class r24 = r13.getType()
            r12[r14] = r24
        L_0x0313:
            long r13 = r9.objectFieldOffset(r13)
            int r14 = (int) r13
            r13 = r3 & 4096(0x1000, float:5.74E-42)
            r24 = 1048575(0xfffff, float:1.469367E-39)
            if (r13 == 0) goto L_0x036e
            r13 = 17
            if (r6 > r13) goto L_0x036e
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r5) goto L_0x0348
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x0332:
            int r25 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0344
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r24
            r8 = r8 | r13
            int r24 = r24 + 13
            r13 = r25
            goto L_0x0332
        L_0x0344:
            int r13 = r13 << r24
            r8 = r8 | r13
            goto L_0x034a
        L_0x0348:
            r25 = r13
        L_0x034a:
            int r13 = r7 + r7
            int r24 = r8 / 32
            int r13 = r13 + r24
            r5 = r10[r13]
            r28 = r1
            boolean r1 = r5 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x035b
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x0363
        L_0x035b:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zzH(r15, r5)
            r10[r13] = r5
        L_0x0363:
            r13 = r2
            long r1 = r9.objectFieldOffset(r5)
            int r2 = (int) r1
            int r8 = r8 % 32
            r24 = r2
            goto L_0x0374
        L_0x036e:
            r28 = r1
            r13 = r2
            r25 = r8
            r8 = 0
        L_0x0374:
            r1 = 18
            if (r6 < r1) goto L_0x0382
            r1 = 49
            if (r6 > r1) goto L_0x0382
            int r1 = r23 + 1
            r17[r23] = r14
            r23 = r1
        L_0x0382:
            r16 = r13
            r2 = r14
        L_0x0385:
            int r1 = r21 + 1
            r11[r21] = r4
            int r4 = r1 + 1
            r5 = r3 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0392
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0393
        L_0x0392:
            r5 = 0
        L_0x0393:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x039a
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039b
        L_0x039a:
            r3 = 0
        L_0x039b:
            int r6 = r6 << 20
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r1] = r2
            int r21 = r4 + 1
            int r1 = r8 << 20
            r1 = r1 | r24
            r11[r4] = r1
            r4 = r25
            r2 = r26
            r13 = r27
            r1 = r28
            r14 = r29
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0186
        L_0x03ba:
            r27 = r13
            r29 = r14
            com.google.android.gms.internal.ads.zzgqz r1 = new com.google.android.gms.internal.ads.zzgqz
            com.google.android.gms.internal.ads.zzgqw r14 = r0.zza()
            int r15 = r0.zzc()
            r16 = 0
            r9 = r1
            r10 = r11
            r11 = r12
            r12 = r27
            r13 = r29
            r20 = r32
            r21 = r33
            r22 = r34
            r23 = r35
            r24 = r36
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x03df:
            com.google.android.gms.internal.ads.zzgsd r0 = (com.google.android.gms.internal.ads.zzgsd) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzl(java.lang.Class, com.google.android.gms.internal.ads.zzgqt, com.google.android.gms.internal.ads.zzgrb, com.google.android.gms.internal.ads.zzgqk, com.google.android.gms.internal.ads.zzgsg, com.google.android.gms.internal.ads.zzgoz, com.google.android.gms.internal.ads.zzgqr):com.google.android.gms.internal.ads.zzgqz");
    }

    private static double zzn(Object obj, long j2) {
        return ((Double) zzgsq.zzh(obj, j2)).doubleValue();
    }

    private static float zzo(Object obj, long j2) {
        return ((Float) zzgsq.zzh(obj, j2)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x032e, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x039f, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04ad, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0560, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x056f, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0573, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f3, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b1, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c1, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x000e:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x057a
            int r9 = r15.zzz(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzy(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0037
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            if (r13 == r7) goto L_0x0034
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
        L_0x0034:
            int r10 = r14 << r10
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0564;
                case 1: goto L_0x0555;
                case 2: goto L_0x053f;
                case 3: goto L_0x052b;
                case 4: goto L_0x0517;
                case 5: goto L_0x050b;
                case 6: goto L_0x04ff;
                case 7: goto L_0x04f1;
                case 8: goto L_0x04c3;
                case 9: goto L_0x04b0;
                case 10: goto L_0x0491;
                case 11: goto L_0x047c;
                case 12: goto L_0x0467;
                case 13: goto L_0x045a;
                case 14: goto L_0x044d;
                case 15: goto L_0x0433;
                case 16: goto L_0x0419;
                case 17: goto L_0x0405;
                case 18: goto L_0x03f7;
                case 19: goto L_0x03eb;
                case 20: goto L_0x03df;
                case 21: goto L_0x03d3;
                case 22: goto L_0x03c7;
                case 23: goto L_0x03bb;
                case 24: goto L_0x03af;
                case 25: goto L_0x03a3;
                case 26: goto L_0x0395;
                case 27: goto L_0x0386;
                case 28: goto L_0x037b;
                case 29: goto L_0x036f;
                case 30: goto L_0x0363;
                case 31: goto L_0x0357;
                case 32: goto L_0x034b;
                case 33: goto L_0x033f;
                case 34: goto L_0x0333;
                case 35: goto L_0x0318;
                case 36: goto L_0x0301;
                case 37: goto L_0x02ea;
                case 38: goto L_0x02d3;
                case 39: goto L_0x02bc;
                case 40: goto L_0x02a4;
                case 41: goto L_0x028c;
                case 42: goto L_0x0272;
                case 43: goto L_0x025a;
                case 44: goto L_0x0242;
                case 45: goto L_0x022a;
                case 46: goto L_0x0212;
                case 47: goto L_0x01fa;
                case 48: goto L_0x01e2;
                case 49: goto L_0x01d2;
                case 50: goto L_0x01c5;
                case 51: goto L_0x01b5;
                case 52: goto L_0x01a5;
                case 53: goto L_0x018f;
                case 54: goto L_0x0179;
                case 55: goto L_0x0163;
                case 56: goto L_0x0156;
                case 57: goto L_0x0149;
                case 58: goto L_0x013a;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f6;
                case 61: goto L_0x00d6;
                case 62: goto L_0x00c0;
                case 63: goto L_0x00aa;
                case 64: goto L_0x009c;
                case 65: goto L_0x008e;
                case 66: goto L_0x0073;
                case 67: goto L_0x0057;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x03a0
        L_0x0041:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgqw r3 = (com.google.android.gms.internal.ads.zzgqw) r3
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgot.zzw(r11, r3, r4)
            goto L_0x039f
        L_0x0057:
            boolean r10 = r15.zzW(r1, r11, r5)
            if (r10 == 0) goto L_0x03a0
            long r3 = zzA(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a0
        L_0x0073:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x032f
        L_0x008e:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x01c1
        L_0x009c:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x01b1
        L_0x00aa:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzx(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032f
        L_0x00c0:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032f
        L_0x00d6:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgoe r3 = (com.google.android.gms.internal.ads.zzgoe) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x00f3:
            int r3 = r3 + r9
            goto L_0x039f
        L_0x00f6:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzn(r11, r3, r4)
            goto L_0x039f
        L_0x010a:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzgoe
            if (r4 == 0) goto L_0x012c
            com.google.android.gms.internal.ads.zzgoe r3 = (com.google.android.gms.internal.ads.zzgoe) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x00f3
        L_0x012c:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzz(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032f
        L_0x013a:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r3 = r3 + r14
            goto L_0x039f
        L_0x0149:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x01b1
        L_0x0156:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x01c1
        L_0x0163:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzx(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032f
        L_0x0179:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r9)
            goto L_0x032f
        L_0x018f:
            boolean r9 = r15.zzW(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r9)
            goto L_0x032f
        L_0x01a5:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
        L_0x01b1:
            int r3 = r3 + 4
            goto L_0x039f
        L_0x01b5:
            boolean r3 = r15.zzW(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
        L_0x01c1:
            int r3 = r3 + 8
            goto L_0x039f
        L_0x01c5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzE(r5)
            com.google.android.gms.internal.ads.zzgqr.zza(r11, r3, r4)
            goto L_0x03a0
        L_0x01d2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzi(r11, r3, r4)
            goto L_0x039f
        L_0x01e2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzs(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x01fa:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzq(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x0212:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x022a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x0242:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzd(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x025a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzv(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x0272:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.gms.internal.ads.zzgrr.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x028c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x02a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x02bc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzk(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x02d3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzx(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x02ea:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzm(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x0301:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x032e
        L_0x0318:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x032e:
            int r4 = r4 + r9
        L_0x032f:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x03a0
        L_0x0333:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzr(r11, r3, r9)
            goto L_0x039f
        L_0x033f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzp(r11, r3, r9)
            goto L_0x039f
        L_0x034b:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzg(r11, r3, r9)
            goto L_0x039f
        L_0x0357:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zze(r11, r3, r9)
            goto L_0x039f
        L_0x0363:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzc(r11, r3, r9)
            goto L_0x039f
        L_0x036f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzu(r11, r3, r9)
            goto L_0x039f
        L_0x037b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzb(r11, r3)
            goto L_0x039f
        L_0x0386:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzo(r11, r3, r4)
            goto L_0x039f
        L_0x0395:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzt(r11, r3)
        L_0x039f:
            int r6 = r6 + r3
        L_0x03a0:
            r12 = 0
            goto L_0x0573
        L_0x03a3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.ads.zzgrr.zza(r11, r3, r12)
            goto L_0x0402
        L_0x03af:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zze(r11, r3, r12)
            goto L_0x0402
        L_0x03bb:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzg(r11, r3, r12)
            goto L_0x0402
        L_0x03c7:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzj(r11, r3, r12)
            goto L_0x0402
        L_0x03d3:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzw(r11, r3, r12)
            goto L_0x0402
        L_0x03df:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzl(r11, r3, r12)
            goto L_0x0402
        L_0x03eb:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zze(r11, r3, r12)
            goto L_0x0402
        L_0x03f7:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzg(r11, r3, r12)
        L_0x0402:
            int r6 = r6 + r3
            goto L_0x0573
        L_0x0405:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgqw r3 = (com.google.android.gms.internal.ads.zzgqw) r3
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgot.zzw(r11, r3, r4)
            goto L_0x0402
        L_0x0419:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r13 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r10)
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0573
        L_0x0433:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x0552
        L_0x044d:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x056f
        L_0x045a:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x0560
        L_0x0467:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzx(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0552
        L_0x047c:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0552
        L_0x0491:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgoe r3 = (com.google.android.gms.internal.ads.zzgoe) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x04ad:
            int r3 = r3 + r9
            goto L_0x0402
        L_0x04b0:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgrp r4 = r15.zzC(r5)
            int r3 = com.google.android.gms.internal.ads.zzgrr.zzn(r11, r3, r4)
            goto L_0x0402
        L_0x04c3:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzgoe
            if (r4 == 0) goto L_0x04e4
            com.google.android.gms.internal.ads.zzgoe r3 = (com.google.android.gms.internal.ads.zzgoe) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgot.zzf
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x04ad
        L_0x04e4:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzz(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0552
        L_0x04f1:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            int r3 = r3 + r14
            goto L_0x0402
        L_0x04ff:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x0560
        L_0x050b:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
            goto L_0x056f
        L_0x0517:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzx(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0552
        L_0x052b:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r9)
            goto L_0x0552
        L_0x053f:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzB(r3)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r9)
        L_0x0552:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0573
        L_0x0555:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
        L_0x0560:
            int r3 = r3 + 4
            goto L_0x0402
        L_0x0564:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgot.zzA(r3)
        L_0x056f:
            int r3 = r3 + 8
            goto L_0x0402
        L_0x0573:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x057a:
            com.google.android.gms.internal.ads.zzgsg r2 = r0.zzn
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x058a
            return r6
        L_0x058a:
            com.google.android.gms.internal.ads.zzgoz r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzp(java.lang.Object):int");
    }

    private static int zzq(Object obj, long j2) {
        return ((Integer) zzgsq.zzh(obj, j2)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, zzgnq zzgnq) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i4);
        Object object = unsafe.getObject(obj, j2);
        if (zzgqr.zzb(object)) {
            zzgqq zzb2 = zzgqq.zza().zzb();
            zzgqr.zzc(zzb2, object);
            unsafe.putObject(obj, j2, zzb2);
        }
        zzgqp zzgqp = (zzgqp) zzE;
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzgnq zzgnq) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        int i14 = i9;
        zzgnq zzgnq2 = zzgnq;
        Unsafe unsafe = zzb;
        long j4 = (long) (this.zzc[i14 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Double.valueOf(Double.longBitsToDouble(zzgnr.zzp(bArr, i2))));
                    int i15 = i10 + 8;
                    unsafe.putInt(obj2, j4, i12);
                    return i15;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Float.valueOf(Float.intBitsToFloat(zzgnr.zzb(bArr, i2))));
                    int i16 = i10 + 4;
                    unsafe.putInt(obj2, j4, i12);
                    return i16;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    int zzm2 = zzgnr.zzm(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, Long.valueOf(zzgnq2.zzb));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    int zzj2 = zzgnr.zzj(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzgnq2.zza));
                    unsafe.putInt(obj2, j4, i12);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Long.valueOf(zzgnr.zzp(bArr, i2)));
                    int i17 = i10 + 8;
                    unsafe.putInt(obj2, j4, i12);
                    return i17;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzgnr.zzb(bArr, i2)));
                    int i18 = i10 + 4;
                    unsafe.putInt(obj2, j4, i12);
                    return i18;
                }
                break;
            case 58:
                if (i13 == 0) {
                    int zzm3 = zzgnr.zzm(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, Boolean.valueOf(zzgnq2.zzb != 0));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm3;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int zzj3 = zzgnr.zzj(bArr2, i10, zzgnq2);
                    int i19 = zzgnq2.zza;
                    if (i19 == 0) {
                        unsafe.putObject(obj2, j3, "");
                    } else if ((i7 & 536870912) == 0 || zzgsv.zzj(bArr2, zzj3, zzj3 + i19)) {
                        unsafe.putObject(obj2, j3, new String(bArr2, zzj3, i19, zzgpw.zzb));
                        zzj3 += i19;
                    } else {
                        throw zzgpy.zzd();
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return zzj3;
                }
                break;
            case 60:
                if (i13 == 2) {
                    Object zzG = zzG(obj2, i12, i14);
                    int zzo2 = zzgnr.zzo(zzG, zzC(i14), bArr, i2, i3, zzgnq);
                    zzP(obj2, i12, i14, zzG);
                    return zzo2;
                }
                break;
            case 61:
                if (i13 == 2) {
                    int zza2 = zzgnr.zza(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, zzgnq2.zzc);
                    unsafe.putInt(obj2, j4, i12);
                    return zza2;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int zzj4 = zzgnr.zzj(bArr2, i10, zzgnq2);
                    int i20 = zzgnq2.zza;
                    zzgpq zzB = zzB(i14);
                    if (zzB == null || zzB.zza(i20)) {
                        unsafe.putObject(obj2, j3, Integer.valueOf(i20));
                        unsafe.putInt(obj2, j4, i12);
                    } else {
                        zzd(obj).zzj(i11, Long.valueOf((long) i20));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i13 == 0) {
                    int zzj5 = zzgnr.zzj(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzgom.zzF(zzgnq2.zza)));
                    unsafe.putInt(obj2, j4, i12);
                    return zzj5;
                }
                break;
            case 67:
                if (i13 == 0) {
                    int zzm4 = zzgnr.zzm(bArr2, i10, zzgnq2);
                    unsafe.putObject(obj2, j3, Long.valueOf(zzgom.zzG(zzgnq2.zzb)));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm4;
                }
                break;
            case 68:
                if (i13 == 3) {
                    Object zzG2 = zzG(obj2, i12, i14);
                    int zzn2 = zzgnr.zzn(zzG2, zzC(i14), bArr, i2, i3, (i11 & -8) | 4, zzgnq);
                    zzP(obj2, i12, i14, zzG2);
                    return zzn2;
                }
                break;
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:282:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:?, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x017a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0443 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0443 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzgnq r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzgpv r12 = (com.google.android.gms.internal.ads.zzgpv) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.ads.zzgpv r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03d5;
                case 19: goto L_0x0388;
                case 20: goto L_0x0345;
                case 21: goto L_0x0345;
                case 22: goto L_0x032c;
                case 23: goto L_0x02eb;
                case 24: goto L_0x02aa;
                case 25: goto L_0x0251;
                case 26: goto L_0x019e;
                case 27: goto L_0x0185;
                case 28: goto L_0x012b;
                case 29: goto L_0x032c;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02aa;
                case 32: goto L_0x02eb;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03d5;
                case 36: goto L_0x0388;
                case 37: goto L_0x0345;
                case 38: goto L_0x0345;
                case 39: goto L_0x032c;
                case 40: goto L_0x02eb;
                case 41: goto L_0x02aa;
                case 42: goto L_0x0251;
                case 43: goto L_0x032c;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02aa;
                case 46: goto L_0x02eb;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x0443
            com.google.android.gms.internal.ads.zzgrp r1 = r15.zzC(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.ads.zzgom.zzG(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0444
        L_0x007b:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgom.zzG(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgom.zzG(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.ads.zzgpn r12 = (com.google.android.gms.internal.ads.zzgpn) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgom.zzF(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0444
        L_0x00ca:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.ads.zzgpn r12 = (com.google.android.gms.internal.ads.zzgpn) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgom.zzF(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgom.zzF(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.ads.zzgnr.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x0443
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzgnr.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.ads.zzgpq r3 = r15.zzB(r8)
            r4 = 0
            com.google.android.gms.internal.ads.zzgsg r5 = r0.zzn
            r22 = r16
            r23 = r21
            r24 = r12
            r25 = r3
            r26 = r4
            r27 = r5
            com.google.android.gms.internal.ads.zzgrr.zzA(r22, r23, r24, r25, r26, r27)
        L_0x0128:
            r1 = r2
            goto L_0x0444
        L_0x012b:
            if (r6 != r14) goto L_0x0443
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0180
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x017b
            if (r4 != 0) goto L_0x0141
            com.google.android.gms.internal.ads.zzgoe r4 = com.google.android.gms.internal.ads.zzgoe.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0141:
            com.google.android.gms.internal.ads.zzgoe r6 = com.google.android.gms.internal.ads.zzgoe.zzv(r3, r1, r4)
            r12.add(r6)
        L_0x0148:
            int r1 = r1 + r4
        L_0x0149:
            if (r1 >= r5) goto L_0x017a
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0154
            goto L_0x017a
        L_0x0154:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0175
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0170
            if (r4 != 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzgoe r4 = com.google.android.gms.internal.ads.zzgoe.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0168:
            com.google.android.gms.internal.ads.zzgoe r6 = com.google.android.gms.internal.ads.zzgoe.zzv(r3, r1, r4)
            r12.add(r6)
            goto L_0x0148
        L_0x0170:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x0175:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x017a:
            return r1
        L_0x017b:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x0180:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x0185:
            if (r6 != r14) goto L_0x0443
            com.google.android.gms.internal.ads.zzgrp r1 = r15.zzC(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.ads.zzgnr.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x019e:
            if (r6 != r14) goto L_0x0443
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01f1
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01ec
            if (r6 != 0) goto L_0x01b9
            r12.add(r1)
            goto L_0x01c4
        L_0x01b9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgpw.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01c3:
            int r4 = r4 + r6
        L_0x01c4:
            if (r4 >= r5) goto L_0x0443
            int r6 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0443
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01e7
            if (r6 != 0) goto L_0x01dc
            r12.add(r1)
            goto L_0x01c4
        L_0x01dc:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgpw.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01c3
        L_0x01e7:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x01ec:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x01f1:
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024c
            if (r6 != 0) goto L_0x01ff
            r12.add(r1)
            goto L_0x0212
        L_0x01ff:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzgsv.zzj(r3, r4, r8)
            if (r9 == 0) goto L_0x0247
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgpw.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x0211:
            r4 = r8
        L_0x0212:
            if (r4 >= r5) goto L_0x0443
            int r6 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0443
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0242
            if (r6 != 0) goto L_0x022a
            r12.add(r1)
            goto L_0x0212
        L_0x022a:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzgsv.zzj(r3, r4, r8)
            if (r9 == 0) goto L_0x023d
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgpw.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x0211
        L_0x023d:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzd()
            throw r1
        L_0x0242:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x0247:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzd()
            throw r1
        L_0x024c:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzf()
            throw r1
        L_0x0251:
            r1 = 0
            if (r6 != r14) goto L_0x0279
            com.google.android.gms.internal.ads.zzgns r12 = (com.google.android.gms.internal.ads.zzgns) r12
            int r2 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x025d:
            if (r2 >= r4) goto L_0x0270
            int r2 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x026b
            r5 = 1
            goto L_0x026c
        L_0x026b:
            r5 = 0
        L_0x026c:
            r12.zze(r5)
            goto L_0x025d
        L_0x0270:
            if (r2 != r4) goto L_0x0274
            goto L_0x0128
        L_0x0274:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x0279:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.ads.zzgns r12 = (com.google.android.gms.internal.ads.zzgns) r12
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0289
            r6 = 1
            goto L_0x028a
        L_0x0289:
            r6 = 0
        L_0x028a:
            r12.zze(r6)
        L_0x028d:
            if (r4 >= r5) goto L_0x02a9
            int r6 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x0298
            goto L_0x02a9
        L_0x0298:
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02a4
            r6 = 1
            goto L_0x02a5
        L_0x02a4:
            r6 = 0
        L_0x02a5:
            r12.zze(r6)
            goto L_0x028d
        L_0x02a9:
            return r4
        L_0x02aa:
            if (r6 != r14) goto L_0x02ca
            com.google.android.gms.internal.ads.zzgpn r12 = (com.google.android.gms.internal.ads.zzgpn) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02b5:
            if (r1 >= r2) goto L_0x02c1
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02b5
        L_0x02c1:
            if (r1 != r2) goto L_0x02c5
            goto L_0x0444
        L_0x02c5:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x02ca:
            if (r6 != r9) goto L_0x0443
            com.google.android.gms.internal.ads.zzgpn r12 = (com.google.android.gms.internal.ads.zzgpn) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02d5:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02ea
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02e2
            goto L_0x02ea
        L_0x02e2:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02d5
        L_0x02ea:
            return r1
        L_0x02eb:
            if (r6 != r14) goto L_0x030b
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02f6:
            if (r1 >= r2) goto L_0x0302
            long r4 = com.google.android.gms.internal.ads.zzgnr.zzp(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x02f6
        L_0x0302:
            if (r1 != r2) goto L_0x0306
            goto L_0x0444
        L_0x0306:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x030b:
            if (r6 != r13) goto L_0x0443
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            long r8 = com.google.android.gms.internal.ads.zzgnr.zzp(r17, r18)
            r12.zzg(r8)
        L_0x0316:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x032b
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0323
            goto L_0x032b
        L_0x0323:
            long r8 = com.google.android.gms.internal.ads.zzgnr.zzp(r3, r4)
            r12.zzg(r8)
            goto L_0x0316
        L_0x032b:
            return r1
        L_0x032c:
            if (r6 != r14) goto L_0x0334
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzf(r3, r4, r12, r7)
            goto L_0x0444
        L_0x0334:
            if (r6 != 0) goto L_0x0443
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0345:
            if (r6 != r14) goto L_0x0365
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0350:
            if (r1 >= r2) goto L_0x035c
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x0350
        L_0x035c:
            if (r1 != r2) goto L_0x0360
            goto L_0x0444
        L_0x0360:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x0365:
            if (r6 != 0) goto L_0x0443
            com.google.android.gms.internal.ads.zzgql r12 = (com.google.android.gms.internal.ads.zzgql) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x0372:
            if (r1 >= r5) goto L_0x0387
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x037d
            goto L_0x0387
        L_0x037d:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x0372
        L_0x0387:
            return r1
        L_0x0388:
            if (r6 != r14) goto L_0x03ac
            com.google.android.gms.internal.ads.zzgpf r12 = (com.google.android.gms.internal.ads.zzgpf) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0393:
            if (r1 >= r2) goto L_0x03a3
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x0393
        L_0x03a3:
            if (r1 != r2) goto L_0x03a7
            goto L_0x0444
        L_0x03a7:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x03ac:
            if (r6 != r9) goto L_0x0443
            com.google.android.gms.internal.ads.zzgpf r12 = (com.google.android.gms.internal.ads.zzgpf) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03bb:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03c8
            goto L_0x03d4
        L_0x03c8:
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03bb
        L_0x03d4:
            return r1
        L_0x03d5:
            if (r6 != r14) goto L_0x03f8
            com.google.android.gms.internal.ads.zzgov r12 = (com.google.android.gms.internal.ads.zzgov) r12
            int r1 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03e0:
            if (r1 >= r2) goto L_0x03f0
            long r4 = com.google.android.gms.internal.ads.zzgnr.zzp(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03e0
        L_0x03f0:
            if (r1 != r2) goto L_0x03f3
            goto L_0x0444
        L_0x03f3:
            com.google.android.gms.internal.ads.zzgpy r1 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r1
        L_0x03f8:
            if (r6 != r13) goto L_0x0443
            com.google.android.gms.internal.ads.zzgov r12 = (com.google.android.gms.internal.ads.zzgov) r12
            long r8 = com.google.android.gms.internal.ads.zzgnr.zzp(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0407:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0414
            goto L_0x0420
        L_0x0414:
            long r8 = com.google.android.gms.internal.ads.zzgnr.zzp(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0407
        L_0x0420:
            return r1
        L_0x0421:
            if (r4 >= r5) goto L_0x0442
            int r8 = com.google.android.gms.internal.ads.zzgnr.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x042c
            goto L_0x0442
        L_0x042c:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgnr.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x0442:
            return r4
        L_0x0443:
            r1 = r4
        L_0x0444:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzgnq):int");
    }

    private final int zzu(int i2) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzx(i2, 0);
    }

    private final int zzv(int i2, int i3) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzx(i2, i3);
    }

    private final int zzw(int i2) {
        return this.zzc[i2 + 2];
    }

    private final int zzx(int i2, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int zzy(int i2) {
        return (i2 >>> 20) & JfifUtil.MARKER_FIRST_BYTE;
    }

    private final int zzz(int i2) {
        return this.zzc[i2 + 1];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x032a, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0424, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a6, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04f8, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0563, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0573, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0577, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r12) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzgsw r0 = com.google.android.gms.internal.ads.zzgsw.DOUBLE
            int r0 = r11.zzp
            int r0 = r0 + -1
            if (r0 == 0) goto L_0x0587
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x000d:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x057b
            int r4 = r11.zzz(r2)
            int r5 = zzy(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.gms.internal.ads.zzgpe r7 = com.google.android.gms.internal.ads.zzgpe.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0038
            com.google.android.gms.internal.ads.zzgpe r7 = com.google.android.gms.internal.ads.zzgpe.SINT64_LIST_PACKED
            int r7 = r7.zza()
            if (r5 > r7) goto L_0x0038
            int[] r7 = r11.zzc
            int r8 = r2 + 2
            r7 = r7[r8]
        L_0x0038:
            long r7 = (long) r4
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0567;
                case 1: goto L_0x0557;
                case 2: goto L_0x0540;
                case 3: goto L_0x052b;
                case 4: goto L_0x0516;
                case 5: goto L_0x0509;
                case 6: goto L_0x04fc;
                case 7: goto L_0x04ec;
                case 8: goto L_0x04bd;
                case 9: goto L_0x04a9;
                case 10: goto L_0x0489;
                case 11: goto L_0x0473;
                case 12: goto L_0x045d;
                case 13: goto L_0x044f;
                case 14: goto L_0x0441;
                case 15: goto L_0x0426;
                case 16: goto L_0x040a;
                case 17: goto L_0x03f5;
                case 18: goto L_0x03e8;
                case 19: goto L_0x03dd;
                case 20: goto L_0x03d2;
                case 21: goto L_0x03c7;
                case 22: goto L_0x03bc;
                case 23: goto L_0x03b1;
                case 24: goto L_0x03a6;
                case 25: goto L_0x039b;
                case 26: goto L_0x0390;
                case 27: goto L_0x0381;
                case 28: goto L_0x0375;
                case 29: goto L_0x0369;
                case 30: goto L_0x035d;
                case 31: goto L_0x0351;
                case 32: goto L_0x0345;
                case 33: goto L_0x0339;
                case 34: goto L_0x032d;
                case 35: goto L_0x0314;
                case 36: goto L_0x02fd;
                case 37: goto L_0x02e6;
                case 38: goto L_0x02cf;
                case 39: goto L_0x02b8;
                case 40: goto L_0x02a0;
                case 41: goto L_0x0288;
                case 42: goto L_0x026e;
                case 43: goto L_0x0256;
                case 44: goto L_0x023e;
                case 45: goto L_0x0226;
                case 46: goto L_0x020e;
                case 47: goto L_0x01f6;
                case 48: goto L_0x01de;
                case 49: goto L_0x01ce;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b3;
                case 52: goto L_0x01a5;
                case 53: goto L_0x018f;
                case 54: goto L_0x0179;
                case 55: goto L_0x0163;
                case 56: goto L_0x0155;
                case 57: goto L_0x0147;
                case 58: goto L_0x0139;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f4;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00bf;
                case 63: goto L_0x00a9;
                case 64: goto L_0x009b;
                case 65: goto L_0x008d;
                case 66: goto L_0x0072;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0577
        L_0x0040:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgqw r4 = (com.google.android.gms.internal.ads.zzgqw) r4
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzw(r6, r4, r5)
            goto L_0x03f2
        L_0x0056:
            boolean r5 = r11.zzW(r12, r6, r2)
            if (r5 == 0) goto L_0x0577
            long r7 = zzA(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.ads.zzgot.zzB(r5)
            goto L_0x0424
        L_0x0072:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0554
        L_0x008d:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0573
        L_0x009b:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0563
        L_0x00a9:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzx(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x00bf:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x00d5:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgoe r4 = (com.google.android.gms.internal.ads.zzgoe) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x04a6
        L_0x00f4:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzn(r6, r4, r5)
            goto L_0x03f2
        L_0x0108:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgoe
            if (r5 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzgoe r4 = (com.google.android.gms.internal.ads.zzgoe) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x04a6
        L_0x012b:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzz(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x0139:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x04f8
        L_0x0147:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0563
        L_0x0155:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0573
        L_0x0163:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzx(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x0179:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzB(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r6)
            goto L_0x0554
        L_0x018f:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzB(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r6)
            goto L_0x0554
        L_0x01a5:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0563
        L_0x01b3:
            boolean r4 = r11.zzW(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0573
        L_0x01c1:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.lang.Object r5 = r11.zzE(r2)
            com.google.android.gms.internal.ads.zzgqr.zza(r6, r4, r5)
            goto L_0x0577
        L_0x01ce:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzi(r6, r4, r5)
            goto L_0x03f2
        L_0x01de:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzs(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x01f6:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzq(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x020e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x0226:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x023e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzd(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x0256:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzv(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x026e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.gms.internal.ads.zzgrr.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x0288:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x02a0:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x02b8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzk(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x02cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzx(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x02e6:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzm(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x02fd:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x032a
        L_0x0314:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
        L_0x032a:
            int r5 = r5 + r6
            goto L_0x0554
        L_0x032d:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzr(r6, r4, r1)
            goto L_0x03f2
        L_0x0339:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzp(r6, r4, r1)
            goto L_0x03f2
        L_0x0345:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzg(r6, r4, r1)
            goto L_0x03f2
        L_0x0351:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x035d:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzc(r6, r4, r1)
            goto L_0x03f2
        L_0x0369:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzu(r6, r4, r1)
            goto L_0x03f2
        L_0x0375:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzb(r6, r4)
            goto L_0x03f2
        L_0x0381:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzo(r6, r4, r5)
            goto L_0x03f2
        L_0x0390:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzt(r6, r4)
            goto L_0x03f2
        L_0x039b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zza(r6, r4, r1)
            goto L_0x03f2
        L_0x03a6:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x03b1:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzg(r6, r4, r1)
            goto L_0x03f2
        L_0x03bc:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzj(r6, r4, r1)
            goto L_0x03f2
        L_0x03c7:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzw(r6, r4, r1)
            goto L_0x03f2
        L_0x03d2:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzl(r6, r4, r1)
            goto L_0x03f2
        L_0x03dd:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x03e8:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzg(r6, r4, r1)
        L_0x03f2:
            int r3 = r3 + r4
            goto L_0x0577
        L_0x03f5:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgqw r4 = (com.google.android.gms.internal.ads.zzgqw) r4
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgot.zzw(r6, r4, r5)
            goto L_0x03f2
        L_0x040a:
            boolean r5 = r11.zzS(r12, r2)
            if (r5 == 0) goto L_0x0577
            long r7 = com.google.android.gms.internal.ads.zzgsq.zzf(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.ads.zzgot.zzB(r5)
        L_0x0424:
            int r4 = r4 + r5
            goto L_0x03f2
        L_0x0426:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.gms.internal.ads.zzgsq.zzd(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0554
        L_0x0441:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0573
        L_0x044f:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0563
        L_0x045d:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.gms.internal.ads.zzgsq.zzd(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzx(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x0473:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.gms.internal.ads.zzgsq.zzd(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x0489:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgoe r4 = (com.google.android.gms.internal.ads.zzgoe) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
        L_0x04a6:
            int r4 = r4 + r6
            goto L_0x03f2
        L_0x04a9:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgrp r5 = r11.zzC(r2)
            int r4 = com.google.android.gms.internal.ads.zzgrr.zzn(r6, r4, r5)
            goto L_0x03f2
        L_0x04bd:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgsq.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgoe
            if (r5 == 0) goto L_0x04df
            com.google.android.gms.internal.ads.zzgoe r4 = (com.google.android.gms.internal.ads.zzgoe) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgot.zzf
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x04a6
        L_0x04df:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzz(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x04ec:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x04f8:
            int r4 = r4 + 1
            goto L_0x03f2
        L_0x04fc:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0563
        L_0x0509:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
            goto L_0x0573
        L_0x0516:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.gms.internal.ads.zzgsq.zzd(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzx(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r5)
            goto L_0x0554
        L_0x052b:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = com.google.android.gms.internal.ads.zzgsq.zzf(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzB(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r6)
            goto L_0x0554
        L_0x0540:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = com.google.android.gms.internal.ads.zzgsq.zzf(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzB(r4)
            int r5 = com.google.android.gms.internal.ads.zzgot.zzA(r6)
        L_0x0554:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0577
        L_0x0557:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x0563:
            int r4 = r4 + 4
            goto L_0x03f2
        L_0x0567:
            boolean r4 = r11.zzS(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgot.zzA(r4)
        L_0x0573:
            int r4 = r4 + 8
            goto L_0x03f2
        L_0x0577:
            int r2 = r2 + 3
            goto L_0x000d
        L_0x057b:
            com.google.android.gms.internal.ads.zzgsg r0 = r11.zzn
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        L_0x0587:
            int r12 = r11.zzp(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0201, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x020f, code lost:
        r2 = r2 + ((int) (r3 ^ (r3 >>> 32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0214, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0218
            int r3 = r9.zzz(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzy(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0203;
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ee;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01de;
                case 5: goto L_0x01d5;
                case 6: goto L_0x01ce;
                case 7: goto L_0x01c3;
                case 8: goto L_0x01b6;
                case 9: goto L_0x01a8;
                case 10: goto L_0x019d;
                case 11: goto L_0x0196;
                case 12: goto L_0x018e;
                case 13: goto L_0x0186;
                case 14: goto L_0x017c;
                case 15: goto L_0x0174;
                case 16: goto L_0x016a;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0214
        L_0x0021:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0033:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0043:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x0051:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0061:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x006f:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x007d:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x008b:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x009d:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00af:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00c3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            boolean r3 = zzX(r10, r5)
            int r3 = com.google.android.gms.internal.ads.zzgpw.zza(r3)
            goto L_0x0201
        L_0x00d5:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x00e3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x00f3:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0201
        L_0x0101:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0111:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0121:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            float r3 = zzo(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0201
        L_0x0133:
            boolean r3 = r9.zzW(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            double r3 = zzn(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
            goto L_0x01b2
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgsq.zzf(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgsq.zzf(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x019d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01a8:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
        L_0x01b2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0214
        L_0x01b6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgsq.zzh(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01c3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzgsq.zzz(r10, r5)
            int r3 = com.google.android.gms.internal.ads.zzgpw.zza(r3)
            goto L_0x0201
        L_0x01ce:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x01d5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgsq.zzf(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgsq.zzd(r10, r5)
            goto L_0x0201
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgsq.zzf(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x01ee:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgsq.zzf(r10, r5)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
            goto L_0x020f
        L_0x01f7:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzgsq.zzc(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
        L_0x0201:
            int r2 = r2 + r3
            goto L_0x0214
        L_0x0203:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzgsq.zzb(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.ads.zzgpw.zzd
        L_0x020f:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r4 = (int) r3
            int r2 = r2 + r4
        L_0x0214:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0218:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzgsg r0 = r9.zzn
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 != 0) goto L_0x022a
            return r2
        L_0x022a:
            com.google.android.gms.internal.ads.zzgoz r0 = r9.zzo
            r0.zza(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x030a, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0327, code lost:
        r2 = r0;
        r7 = r20;
        r6 = r23;
        r0 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x035b, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0383, code lost:
        if (r0 != r15) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0151, code lost:
        r5 = r7 | r8;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0154, code lost:
        r1 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0158, code lost:
        r12 = r6;
        r20 = r13;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ec, code lost:
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x021f, code lost:
        r6 = r23;
        r8 = -1;
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x024d, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x024f, code lost:
        r5 = r7 | r8;
        r13 = r31;
        r2 = r6;
        r1 = r11;
        r3 = r20;
        r6 = r23;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x025a, code lost:
        r11 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025e, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x025f, code lost:
        r0 = r32;
        r19 = r7;
        r26 = r10;
        r30 = r11;
        r21 = r12;
        r2 = r13;
        r7 = r20;
        r6 = r23;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.ads.zzgnq r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            zzI(r28)
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r8 = -1
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r0 >= r13) goto L_0x03f7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzk(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            int r0 = r4 >>> 3
            r7 = 3
            if (r0 <= r1) goto L_0x003a
            int r2 = r2 / r7
            int r1 = r15.zzv(r0, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzu(r0)
        L_0x003e:
            r2 = r1
            if (r2 != r8) goto L_0x0050
            r30 = r0
            r2 = r3
            r7 = r4
            r19 = r5
            r26 = r10
            r0 = r11
            r18 = -1
            r21 = 0
            goto L_0x0386
        L_0x0050:
            r1 = r4 & 7
            int[] r8 = r15.zzc
            int r19 = r2 + 1
            r7 = r8[r19]
            int r11 = zzy(r7)
            r19 = r0
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r17
            r21 = r3
            r20 = r4
            long r3 = (long) r0
            r0 = 17
            if (r11 > r0) goto L_0x0272
            int r0 = r2 + 2
            r0 = r8[r0]
            int r8 = r0 >>> 20
            r13 = 1
            int r8 = r13 << r8
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r13
            r17 = r7
            if (r0 == r6) goto L_0x008c
            if (r6 == r13) goto L_0x0083
            long r6 = (long) r6
            r10.putInt(r14, r6, r5)
        L_0x0083:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r23 = r0
            r7 = r5
            goto L_0x008f
        L_0x008c:
            r7 = r5
            r23 = r6
        L_0x008f:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x023a;
                case 1: goto L_0x0225;
                case 2: goto L_0x0200;
                case 3: goto L_0x0200;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01d4;
                case 6: goto L_0x01c2;
                case 7: goto L_0x01a7;
                case 8: goto L_0x0189;
                case 9: goto L_0x015e;
                case 10: goto L_0x013e;
                case 11: goto L_0x01ef;
                case 12: goto L_0x010f;
                case 13: goto L_0x01c2;
                case 14: goto L_0x01d4;
                case 15: goto L_0x00f8;
                case 16: goto L_0x00c9;
                default: goto L_0x0093;
            }
        L_0x0093:
            r6 = r2
            r11 = r19
            r13 = r21
            r0 = 3
            if (r1 != r0) goto L_0x025e
            java.lang.Object r5 = r15.zzF(r14, r6)
            int r0 = r11 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.ads.zzgrp r1 = r15.zzC(r6)
            r0 = r5
            r2 = r29
            r3 = r13
            r4 = r31
            r13 = r5
            r5 = r17
            r12 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzO(r14, r12, r13)
            r5 = r7 | r8
            r13 = r31
            r1 = r11
            r2 = r12
            r3 = r20
            r6 = r23
            r8 = -1
            r12 = r29
            goto L_0x025a
        L_0x00c9:
            if (r1 != 0) goto L_0x00f1
            r5 = r21
            int r6 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r5, r9)
            long r0 = r9.zzb
            long r21 = com.google.android.gms.internal.ads.zzgom.zzG(r0)
            r11 = r19
            r0 = r10
            r1 = r28
            r5 = r2
            r2 = r3
            r17 = r6
            r13 = r20
            r6 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r3 = r13
            r0 = r17
            goto L_0x021f
        L_0x00f1:
            r11 = r19
            r12 = r2
            r13 = r21
            goto L_0x025f
        L_0x00f8:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            if (r1 != 0) goto L_0x0158
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r5, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.ads.zzgom.zzF(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0151
        L_0x010f:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            if (r1 != 0) goto L_0x0158
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r5, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.ads.zzgpq r2 = r15.zzB(r6)
            if (r2 == 0) goto L_0x013a
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x012b
            goto L_0x013a
        L_0x012b:
            com.google.android.gms.internal.ads.zzgsh r2 = zzd(r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r13, r1)
            r2 = r6
            r5 = r7
            goto L_0x0154
        L_0x013a:
            r10.putInt(r14, r3, r1)
            goto L_0x0151
        L_0x013e:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0158
            int r0 = com.google.android.gms.internal.ads.zzgnr.zza(r12, r5, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
        L_0x0151:
            r5 = r7 | r8
            r2 = r6
        L_0x0154:
            r1 = r11
            r3 = r13
            goto L_0x021f
        L_0x0158:
            r12 = r6
            r20 = r13
            r13 = r5
            goto L_0x025f
        L_0x015e:
            r6 = r2
            r11 = r19
            r13 = r20
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0185
            java.lang.Object r4 = r15.zzF(r14, r6)
            com.google.android.gms.internal.ads.zzgrp r1 = r15.zzC(r6)
            r0 = r4
            r2 = r29
            r3 = r5
            r5 = r4
            r4 = r31
            r20 = r13
            r13 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r6, r13)
            goto L_0x024f
        L_0x0185:
            r20 = r13
            goto L_0x01ec
        L_0x0189:
            r6 = r2
            r11 = r19
            r5 = r21
            r0 = 2
            if (r1 != r0) goto L_0x01ec
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r17 & r0
            if (r0 != 0) goto L_0x019c
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzg(r12, r5, r9)
            goto L_0x01a0
        L_0x019c:
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzh(r12, r5, r9)
        L_0x01a0:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x024f
        L_0x01a7:
            r6 = r2
            r11 = r19
            r5 = r21
            if (r1 != 0) goto L_0x01ec
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r5, r9)
            long r1 = r9.zzb
            r21 = 0
            int r5 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r5 == 0) goto L_0x01bc
            r13 = 1
            goto L_0x01bd
        L_0x01bc:
            r13 = 0
        L_0x01bd:
            com.google.android.gms.internal.ads.zzgsq.zzp(r14, r3, r13)
            goto L_0x024f
        L_0x01c2:
            r6 = r2
            r11 = r19
            r5 = r21
            if (r1 != r0) goto L_0x01ec
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzb(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
            goto L_0x024f
        L_0x01d4:
            r6 = r2
            r11 = r19
            r5 = r21
            r0 = 1
            if (r1 != r0) goto L_0x01ec
            long r21 = com.google.android.gms.internal.ads.zzgnr.zzp(r12, r5)
            r0 = r10
            r1 = r28
            r13 = r5
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x024d
        L_0x01ec:
            r13 = r5
            goto L_0x025e
        L_0x01ef:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != 0) goto L_0x025e
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x024f
        L_0x0200:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != 0) goto L_0x025e
            int r13 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r21 = r1
            r1 = r28
            r2 = r3
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r0 = r13
            r3 = r20
        L_0x021f:
            r6 = r23
            r8 = -1
            r13 = r31
            goto L_0x025a
        L_0x0225:
            r6 = r2
            r11 = r19
            r13 = r21
            if (r1 != r0) goto L_0x025e
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgsq.zzs(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x024f
        L_0x023a:
            r6 = r2
            r11 = r19
            r13 = r21
            r0 = 1
            if (r1 != r0) goto L_0x025e
            long r0 = com.google.android.gms.internal.ads.zzgnr.zzp(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgsq.zzr(r14, r3, r0)
        L_0x024d:
            int r0 = r13 + 8
        L_0x024f:
            r5 = r7 | r8
            r13 = r31
            r2 = r6
            r1 = r11
            r3 = r20
            r6 = r23
            r8 = -1
        L_0x025a:
            r11 = r32
            goto L_0x001d
        L_0x025e:
            r12 = r6
        L_0x025f:
            r0 = r32
            r19 = r7
            r26 = r10
            r30 = r11
            r21 = r12
            r2 = r13
            r7 = r20
            r6 = r23
            r18 = -1
            goto L_0x0386
        L_0x0272:
            r12 = r2
            r17 = r7
            r8 = r19
            r13 = r21
            r0 = 27
            if (r11 != r0) goto L_0x02d4
            r0 = 2
            if (r1 != r0) goto L_0x02c5
            java.lang.Object r0 = r10.getObject(r14, r3)
            com.google.android.gms.internal.ads.zzgpv r0 = (com.google.android.gms.internal.ads.zzgpv) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x029d
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0295
            r1 = 10
            goto L_0x0296
        L_0x0295:
            int r1 = r1 + r1
        L_0x0296:
            com.google.android.gms.internal.ads.zzgpv r0 = r0.zzd(r1)
            r10.putObject(r14, r3, r0)
        L_0x029d:
            r7 = r0
            com.google.android.gms.internal.ads.zzgrp r0 = r15.zzC(r12)
            r1 = r20
            r2 = r29
            r3 = r13
            r4 = r31
            r19 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r31
            r11 = r32
            r1 = r8
            r2 = r12
            r5 = r19
            r3 = r20
            r6 = r23
            r8 = -1
            r12 = r29
            goto L_0x001d
        L_0x02c5:
            r19 = r5
            r23 = r6
            r30 = r8
            r26 = r10
            r21 = r12
            r15 = r13
            r18 = -1
            goto L_0x035e
        L_0x02d4:
            r19 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0330
            r7 = r17
            long r6 = (long) r7
            r0 = r27
            r5 = r1
            r1 = r28
            r2 = r29
            r24 = r3
            r3 = r13
            r4 = r31
            r17 = r5
            r5 = r20
            r21 = r6
            r6 = r8
            r7 = r17
            r30 = r8
            r18 = -1
            r8 = r12
            r26 = r10
            r9 = r21
            r15 = r32
            r21 = r12
            r15 = r13
            r12 = r24
            r14 = r33
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0327
        L_0x030c:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r5 = r19
            r3 = r20
            r2 = r21
            r6 = r23
            r10 = r26
            r8 = -1
            goto L_0x001d
        L_0x0327:
            r2 = r0
            r7 = r20
            r6 = r23
            r0 = r32
            goto L_0x0386
        L_0x0330:
            r24 = r3
            r30 = r8
            r26 = r10
            r21 = r12
            r15 = r13
            r7 = r17
            r18 = -1
            r17 = r1
            r0 = 50
            if (r11 != r0) goto L_0x0366
            r8 = r17
            r0 = 2
            if (r8 != r0) goto L_0x035e
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r21
            r6 = r24
            r8 = r33
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0327
            goto L_0x030c
        L_0x035e:
            r0 = r32
            r2 = r15
            r7 = r20
            r6 = r23
            goto L_0x0386
        L_0x0366:
            r8 = r17
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r20
            r6 = r30
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r24
            r12 = r21
            r13 = r33
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0327
            goto L_0x030c
        L_0x0386:
            if (r7 != r0) goto L_0x0398
            if (r0 == 0) goto L_0x0398
            r8 = r27
            r12 = r28
            r9 = r0
            r0 = r6
            r5 = r19
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2
            goto L_0x0407
        L_0x0398:
            r8 = r27
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x03cf
            r10 = r33
            com.google.android.gms.internal.ads.zzgoy r0 = r10.zzd
            com.google.android.gms.internal.ads.zzgoy r1 = com.google.android.gms.internal.ads.zzgoy.zza
            if (r0 == r1) goto L_0x03ca
            com.google.android.gms.internal.ads.zzgqw r1 = r8.zzg
            r11 = r30
            com.google.android.gms.internal.ads.zzgpk r0 = r0.zzc(r1, r11)
            if (r0 != 0) goto L_0x03c3
            com.google.android.gms.internal.ads.zzgsh r4 = zzd(r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r28
            goto L_0x03e4
        L_0x03c3:
            r12 = r28
            r0 = r12
            com.google.android.gms.internal.ads.zzgpj r0 = (com.google.android.gms.internal.ads.zzgpj) r0
            r0 = 0
            throw r0
        L_0x03ca:
            r12 = r28
            r11 = r30
            goto L_0x03d5
        L_0x03cf:
            r12 = r28
            r11 = r30
            r10 = r33
        L_0x03d5:
            com.google.android.gms.internal.ads.zzgsh r4 = zzd(r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzi(r0, r1, r2, r3, r4, r5)
        L_0x03e4:
            r13 = r31
            r3 = r7
            r15 = r8
            r1 = r11
            r14 = r12
            r5 = r19
            r2 = r21
            r8 = -1
            r12 = r29
            r11 = r9
            r9 = r10
            r10 = r26
            goto L_0x001d
        L_0x03f7:
            r19 = r5
            r23 = r6
            r26 = r10
            r9 = r11
            r12 = r14
            r8 = r15
            r6 = r0
            r7 = r3
            r0 = r23
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0407:
            if (r0 == r1) goto L_0x040f
            long r0 = (long) r0
            r2 = r26
            r2.putInt(r12, r0, r5)
        L_0x040f:
            int r0 = r8.zzk
            r10 = r0
        L_0x0412:
            int r0 = r8.zzl
            if (r10 >= r0) goto L_0x0429
            int[] r0 = r8.zzj
            r2 = r0[r10]
            r3 = 0
            com.google.android.gms.internal.ads.zzgsg r4 = r8.zzn
            r0 = r27
            r1 = r28
            r5 = r28
            r0.zzD(r1, r2, r3, r4, r5)
            int r10 = r10 + 1
            goto L_0x0412
        L_0x0429:
            if (r9 != 0) goto L_0x0435
            r0 = r31
            if (r6 != r0) goto L_0x0430
            goto L_0x043b
        L_0x0430:
            com.google.android.gms.internal.ads.zzgpy r0 = com.google.android.gms.internal.ads.zzgpy.zzg()
            throw r0
        L_0x0435:
            r0 = r31
            if (r6 > r0) goto L_0x043c
            if (r7 != r9) goto L_0x043c
        L_0x043b:
            return r6
        L_0x043c:
            com.google.android.gms.internal.ads.zzgpy r0 = com.google.android.gms.internal.ads.zzgpy.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgnq):int");
    }

    public final Object zze() {
        return ((zzgpm) this.zzg).zzaD();
    }

    public final void zzf(Object obj) {
        if (zzV(obj)) {
            if (obj instanceof zzgpm) {
                zzgpm zzgpm = (zzgpm) obj;
                zzgpm.zzaV(Integer.MAX_VALUE);
                zzgpm.zza = 0;
                zzgpm.zzaT();
            }
            int length = this.zzc.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int zzz = zzz(i2);
                int i3 = 1048575 & zzz;
                int zzy = zzy(zzz);
                long j2 = (long) i3;
                if (zzy != 9) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzW(obj, this.zzc[i2], i2)) {
                            zzC(i2).zzf(zzb.getObject(obj, j2));
                        }
                    } else {
                        switch (zzy) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zzb(obj, j2);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j2);
                                if (object != null) {
                                    ((zzgqq) object).zzc();
                                    unsafe.putObject(obj, j2, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzS(obj, i2)) {
                    zzC(i2).zzf(zzb.getObject(obj, j2));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzI(obj);
        obj2.getClass();
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int zzz = zzz(i2);
            int i3 = this.zzc[i2];
            long j2 = (long) (1048575 & zzz);
            switch (zzy(zzz)) {
                case 0:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzr(obj, j2, zzgsq.zzb(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 1:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzs(obj, j2, zzgsq.zzc(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 2:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzu(obj, j2, zzgsq.zzf(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 3:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzu(obj, j2, zzgsq.zzf(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 4:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 5:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzu(obj, j2, zzgsq.zzf(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 6:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 7:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzp(obj, j2, zzgsq.zzz(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 8:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzv(obj, j2, zzgsq.zzh(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 9:
                    zzJ(obj, obj2, i2);
                    break;
                case 10:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzv(obj, j2, zzgsq.zzh(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 11:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 12:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 13:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 14:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzu(obj, j2, zzgsq.zzf(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 15:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzt(obj, j2, zzgsq.zzd(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 16:
                    if (!zzS(obj2, i2)) {
                        break;
                    } else {
                        zzgsq.zzu(obj, j2, zzgsq.zzf(obj2, j2));
                        zzM(obj, i2);
                        break;
                    }
                case 17:
                    zzJ(obj, obj2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzc(obj, obj2, j2);
                    break;
                case 50:
                    int i4 = zzgrr.zza;
                    zzgsq.zzv(obj, j2, zzgqr.zzc(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzW(obj2, i3, i2)) {
                        break;
                    } else {
                        zzgsq.zzv(obj, j2, zzgsq.zzh(obj2, j2));
                        zzN(obj, i3, i2);
                        break;
                    }
                case 60:
                    zzK(obj, obj2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzW(obj2, i3, i2)) {
                        break;
                    } else {
                        zzgsq.zzv(obj, j2, zzgsq.zzh(obj2, j2));
                        zzN(obj, i3, i2);
                        break;
                    }
                case 68:
                    zzK(obj, obj2, i2);
                    break;
            }
        }
        zzgrr.zzC(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05e5, code lost:
        r15 = r9;
        r5 = r11;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0621, code lost:
        r4 = r10.zzc(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x062c, code lost:
        r0 = r7.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0630, code lost:
        if (r0 < r7.zzl) goto L_0x0632;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0632, code lost:
        r4 = zzD(r18, r7.zzj[r0], r4, r10, r18);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0644, code lost:
        if (r4 != null) goto L_0x0646;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0646, code lost:
        r10.zzn(r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0183, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x061c */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0621 A[Catch:{ all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0659 A[LOOP:5: B:197:0x0655->B:199:0x0659, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x062c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.ads.zzgrh r19, com.google.android.gms.internal.ads.zzgoy r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            r20.getClass()
            zzI(r18)
            com.google.android.gms.internal.ads.zzgsg r14 = r7.zzn
            com.google.android.gms.internal.ads.zzgoz r5 = r7.zzo
            r16 = 0
            r4 = r16
            r8 = r4
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x064d }
            int r1 = r7.zzu(r2)     // Catch:{ all -> 0x064d }
            if (r1 >= 0) goto L_0x00b6
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0044
            int r0 = r7.zzk
        L_0x0028:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x003e
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r14
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r4 == 0) goto L_0x0649
            r14.zzn(r15, r4)
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.gms.internal.ads.zzgqw r1 = r7.zzg     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r5.zzc(r6, r1, r2)     // Catch:{ all -> 0x00b1 }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x0070
            if (r8 != 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzgpd r1 = r5.zzb(r15)     // Catch:{ all -> 0x064d }
            goto L_0x005c
        L_0x005b:
            r1 = r8
        L_0x005c:
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            java.lang.Object r4 = r8.zzd(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00ac }
            r8 = r1
        L_0x006d:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x0070:
            r3 = r14
            r2 = r15
            r3.zzq(r0)     // Catch:{ all -> 0x00ac }
            if (r4 != 0) goto L_0x007c
            java.lang.Object r1 = r3.zzc(r2)     // Catch:{ all -> 0x00ac }
            r4 = r1
        L_0x007c:
            boolean r1 = r3.zzp(r4, r0)     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x006d
            int r0 = r7.zzk
        L_0x0084:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x009f
            int[] r1 = r7.zzj
            r5 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r5
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0084
        L_0x009f:
            r9 = r2
            r10 = r3
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x00a7:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0652
        L_0x00ac:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x064b
        L_0x00b1:
            r0 = move-exception
            r10 = r14
            r9 = r15
            goto L_0x064b
        L_0x00b6:
            r10 = r14
            r9 = r15
            int r3 = r7.zzz(r1)     // Catch:{ all -> 0x064a }
            int r11 = zzy(r3)     // Catch:{ zzgpx -> 0x0618 }
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d5;
                case 1: goto L_0x05c4;
                case 2: goto L_0x05b3;
                case 3: goto L_0x05a2;
                case 4: goto L_0x0591;
                case 5: goto L_0x0580;
                case 6: goto L_0x056e;
                case 7: goto L_0x055c;
                case 8: goto L_0x054e;
                case 9: goto L_0x0539;
                case 10: goto L_0x0527;
                case 11: goto L_0x0515;
                case 12: goto L_0x04f0;
                case 13: goto L_0x04de;
                case 14: goto L_0x04cc;
                case 15: goto L_0x04ba;
                case 16: goto L_0x04a8;
                case 17: goto L_0x0493;
                case 18: goto L_0x0482;
                case 19: goto L_0x0471;
                case 20: goto L_0x0460;
                case 21: goto L_0x044f;
                case 22: goto L_0x043e;
                case 23: goto L_0x042d;
                case 24: goto L_0x041c;
                case 25: goto L_0x040b;
                case 26: goto L_0x03de;
                case 27: goto L_0x03c9;
                case 28: goto L_0x03b8;
                case 29: goto L_0x03a7;
                case 30: goto L_0x038b;
                case 31: goto L_0x037a;
                case 32: goto L_0x0369;
                case 33: goto L_0x0358;
                case 34: goto L_0x0347;
                case 35: goto L_0x0336;
                case 36: goto L_0x0325;
                case 37: goto L_0x0314;
                case 38: goto L_0x0303;
                case 39: goto L_0x02f2;
                case 40: goto L_0x02e1;
                case 41: goto L_0x02d0;
                case 42: goto L_0x02bf;
                case 43: goto L_0x02ae;
                case 44: goto L_0x0291;
                case 45: goto L_0x0283;
                case 46: goto L_0x0275;
                case 47: goto L_0x0267;
                case 48: goto L_0x0259;
                case 49: goto L_0x0247;
                case 50: goto L_0x0211;
                case 51: goto L_0x01ff;
                case 52: goto L_0x01ee;
                case 53: goto L_0x01dd;
                case 54: goto L_0x01cc;
                case 55: goto L_0x01bb;
                case 56: goto L_0x01aa;
                case 57: goto L_0x0199;
                case 58: goto L_0x0188;
                case 59: goto L_0x017d;
                case 60: goto L_0x016c;
                case 61: goto L_0x015f;
                case 62: goto L_0x014e;
                case 63: goto L_0x0129;
                case 64: goto L_0x0118;
                case 65: goto L_0x0107;
                case 66: goto L_0x00f5;
                case 67: goto L_0x00e3;
                case 68: goto L_0x00d1;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05ee
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05ec
        L_0x00d1:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqw r3 = (com.google.android.gms.internal.ads.zzgqw) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgrp r11 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzt(r3, r11, r6)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x00e3:
            r3 = r3 & r12
            long r11 = r19.zzn()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x00f5:
            r3 = r3 & r12
            int r11 = r19.zzi()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0107:
            r3 = r3 & r12
            long r11 = r19.zzm()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0118:
            r3 = r3 & r12
            int r11 = r19.zzh()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0129:
            int r11 = r19.zze()     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgpq r13 = r7.zzB(r1)     // Catch:{ zzgpx -> 0x0618 }
            if (r13 == 0) goto L_0x0141
            boolean r13 = r13.zza(r11)     // Catch:{ zzgpx -> 0x0618 }
            if (r13 == 0) goto L_0x013a
            goto L_0x0141
        L_0x013a:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgrr.zzB(r9, r2, r11, r4, r10)     // Catch:{ zzgpx -> 0x0618 }
            r15 = r9
            goto L_0x05e9
        L_0x0141:
            r3 = r3 & r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x014e:
            r3 = r3 & r12
            int r11 = r19.zzj()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x015f:
            r3 = r3 & r12
            com.google.android.gms.internal.ads.zzgoe r11 = r19.zzp()     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x016c:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqw r3 = (com.google.android.gms.internal.ads.zzgqw) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgrp r11 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzu(r3, r11, r6)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x017d:
            r7.zzL(r9, r3, r0)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
        L_0x0183:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e5
        L_0x0188:
            r3 = r3 & r12
            boolean r11 = r19.zzN()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0199:
            r3 = r3 & r12
            int r11 = r19.zzf()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01aa:
            r3 = r3 & r12
            long r11 = r19.zzk()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01bb:
            r3 = r3 & r12
            int r11 = r19.zzg()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01cc:
            r3 = r3 & r12
            long r11 = r19.zzo()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01dd:
            r3 = r3 & r12
            long r11 = r19.zzl()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01ee:
            r3 = r3 & r12
            float r11 = r19.zzb()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x01ff:
            r3 = r3 & r12
            double r11 = r19.zza()     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ zzgpx -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r12, r11)     // Catch:{ zzgpx -> 0x0618 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0211:
            java.lang.Object r2 = r7.zzE(r1)     // Catch:{ zzgpx -> 0x0618 }
            int r1 = r7.zzz(r1)     // Catch:{ zzgpx -> 0x0618 }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{ zzgpx -> 0x0618 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgsq.zzh(r9, r11)     // Catch:{ zzgpx -> 0x0618 }
            if (r1 == 0) goto L_0x0237
            boolean r3 = com.google.android.gms.internal.ads.zzgqr.zzb(r1)     // Catch:{ zzgpx -> 0x0618 }
            if (r3 == 0) goto L_0x0242
            com.google.android.gms.internal.ads.zzgqq r3 = com.google.android.gms.internal.ads.zzgqq.zza()     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqq r3 = r3.zzb()     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqr.zzc(r3, r1)     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r11, r3)     // Catch:{ zzgpx -> 0x0618 }
            r1 = r3
            goto L_0x0242
        L_0x0237:
            com.google.android.gms.internal.ads.zzgqq r1 = com.google.android.gms.internal.ads.zzgqq.zza()     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqq r1 = r1.zzb()     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r11, r1)     // Catch:{ zzgpx -> 0x0618 }
        L_0x0242:
            com.google.android.gms.internal.ads.zzgqq r1 = (com.google.android.gms.internal.ads.zzgqq) r1     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqp r2 = (com.google.android.gms.internal.ads.zzgqp) r2     // Catch:{ zzgpx -> 0x0618 }
            throw r16     // Catch:{ zzgpx -> 0x0618 }
        L_0x0247:
            r2 = r3 & r12
            com.google.android.gms.internal.ads.zzgrp r1 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgqk r3 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            long r11 = (long) r2     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r2 = r3.zza(r9, r11)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzC(r2, r1, r6)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0259:
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzJ(r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0267:
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzI(r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0275:
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzH(r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0283:
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzG(r1)     // Catch:{ zzgpx -> 0x0618 }
            goto L_0x0183
        L_0x0291:
            com.google.android.gms.internal.ads.zzgqk r11 = r7.zzm     // Catch:{ zzgpx -> 0x0618 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzgpx -> 0x0618 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzgpx -> 0x0618 }
            r0.zzy(r3)     // Catch:{ zzgpx -> 0x0618 }
            com.google.android.gms.internal.ads.zzgpq r11 = r7.zzB(r1)     // Catch:{ zzgpx -> 0x0618 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgrr.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x02ae:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02bf:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02d0:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02e1:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02f2:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0303:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0314:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0325:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0336:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0347:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzJ(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0358:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzI(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0369:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzH(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x037a:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzG(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x038b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r4 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzy(r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgpq r4 = r7.zzB(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgrr.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x03a7:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03b8:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzw(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03c9:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgrp r1 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            com.google.android.gms.internal.ads.zzgqk r3 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r2 = r3.zza(r9, r4)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzF(r2, r1, r14)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03de:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzR(r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            if (r1 == 0) goto L_0x03f9
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.ads.zzgon r2 = (com.google.android.gms.internal.ads.zzgon) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03f9:
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.ads.zzgon r2 = (com.google.android.gms.internal.ads.zzgon) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x040b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x041c:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x042d:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x043e:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x044f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0460:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0471:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0482:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.ads.zzgqk r1 = r7.zzm     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0493:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgqw r2 = (com.google.android.gms.internal.ads.zzgqw) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgrp r3 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzt(r2, r3, r14)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04a8:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzn()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzu(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04ba:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzi()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04cc:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzm()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzu(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04de:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzh()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04f0:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgpq r5 = r7.zzB(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x050a
            boolean r5 = r5.zza(r4)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x0504
            goto L_0x050a
        L_0x0504:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgrr.zzB(r9, r2, r4, r13, r10)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x050a:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r2, r4)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0515:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzj()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0527:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            com.google.android.gms.internal.ads.zzgoe r3 = r19.zzp()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzv(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0539:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgqw r2 = (com.google.android.gms.internal.ads.zzgqw) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgrp r3 = r7.zzC(r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r0.zzu(r2, r3, r14)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x054e:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zzL(r9, r3, r0)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0559:
            r0 = move-exception
            goto L_0x0651
        L_0x055c:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            boolean r3 = r19.zzN()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzp(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x056e:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzf()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0580:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzk()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzu(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0591:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzg()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzt(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05a2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzo()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzu(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05b3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzl()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzu(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05c4:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            float r3 = r19.zzb()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzs(r9, r4, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05d5:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            double r3 = r19.zza()     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.ads.zzgsq.zzr(r9, r5, r3)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
            r7.zzM(r9, r1)     // Catch:{ zzgpx -> 0x061b, all -> 0x0559 }
        L_0x05e5:
            r15 = r9
            r5 = r11
            r4 = r13
        L_0x05e8:
            r6 = r14
        L_0x05e9:
            r14 = r10
            goto L_0x0017
        L_0x05ec:
            r4 = r1
            goto L_0x05ef
        L_0x05ee:
            r4 = r13
        L_0x05ef:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ zzgpx -> 0x061c }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x05f7:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x060d
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x05f7
        L_0x060d:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x0613:
            r15 = r9
            r5 = r11
            goto L_0x05e8
        L_0x0616:
            r0 = move-exception
            goto L_0x0652
        L_0x0618:
            r13 = r4
            r11 = r5
            r14 = r6
        L_0x061b:
            r4 = r13
        L_0x061c:
            r10.zzq(r0)     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x0626
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0616 }
            r4 = r1
        L_0x0626:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ all -> 0x0616 }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x062e:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x0644
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x062e
        L_0x0644:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
        L_0x0649:
            return
        L_0x064a:
            r0 = move-exception
        L_0x064b:
            r13 = r4
            goto L_0x0651
        L_0x064d:
            r0 = move-exception
            r13 = r4
            r10 = r14
            r9 = r15
        L_0x0651:
            r4 = r13
        L_0x0652:
            int r1 = r7.zzk
            r8 = r1
        L_0x0655:
            int r1 = r7.zzl
            if (r8 >= r1) goto L_0x066b
            int[] r1 = r7.zzj
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzD(r2, r3, r4, r5, r6)
            int r8 = r8 + 1
            goto L_0x0655
        L_0x066b:
            if (r4 == 0) goto L_0x0670
            r10.zzn(r9, r4)
        L_0x0670:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgrh, com.google.android.gms.internal.ads.zzgoy):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02e6, code lost:
        if (r0 != r15) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x030a, code lost:
        if (r0 != r15) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x019a, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fe, code lost:
        r6 = r6 | r22;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0201, code lost:
        r1 = r19;
        r8 = 1048575;
        r9 = -1;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x020b, code lost:
        r2 = r5;
        r27 = r10;
        r22 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02a3, code lost:
        if (r0 != r15) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02b9, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(java.lang.Object r29, byte[] r30, int r31, int r32, com.google.android.gms.internal.ads.zzgnq r33) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            com.google.android.gms.internal.ads.zzgsw r0 = com.google.android.gms.internal.ads.zzgsw.DOUBLE
            int r0 = r15.zzp
            r9 = -1
            int r0 = r0 + r9
            if (r0 == 0) goto L_0x0350
            zzI(r29)
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r31
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0024:
            if (r0 >= r13) goto L_0x0333
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0036
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0039
        L_0x0036:
            r17 = r0
            r4 = r3
        L_0x0039:
            int r5 = r17 >>> 3
            if (r5 <= r1) goto L_0x0044
            int r2 = r2 / 3
            int r0 = r15.zzv(r5, r2)
            goto L_0x0048
        L_0x0044:
            int r0 = r15.zzu(r5)
        L_0x0048:
            r2 = r0
            if (r2 != r9) goto L_0x0056
            r2 = r4
            r19 = r5
            r27 = r10
            r18 = -1
            r22 = 0
            goto L_0x030d
        L_0x0056:
            r3 = r17 & 7
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = zzy(r1)
            r9 = r1 & r8
            long r8 = (long) r9
            r31 = r5
            r5 = 17
            r20 = r1
            if (r13 > r5) goto L_0x0214
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r22 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r19 = r2
            if (r0 == r7) goto L_0x008d
            if (r7 == r5) goto L_0x0084
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0084:
            if (r0 == r5) goto L_0x008c
            long r1 = (long) r0
            int r1 = r10.getInt(r14, r1)
            r6 = r1
        L_0x008c:
            r7 = r0
        L_0x008d:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x01e6;
                case 1: goto L_0x01ce;
                case 2: goto L_0x01b1;
                case 3: goto L_0x01b1;
                case 4: goto L_0x019d;
                case 5: goto L_0x017e;
                case 6: goto L_0x016a;
                case 7: goto L_0x014d;
                case 8: goto L_0x012d;
                case 9: goto L_0x010a;
                case 10: goto L_0x00f5;
                case 11: goto L_0x019d;
                case 12: goto L_0x00e1;
                case 13: goto L_0x016a;
                case 14: goto L_0x017e;
                case 15: goto L_0x00c9;
                case 16: goto L_0x009b;
                default: goto L_0x0091;
            }
        L_0x0091:
            r5 = r4
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            goto L_0x020b
        L_0x009b:
            if (r3 != 0) goto L_0x00be
            int r13 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r20 = com.google.android.gms.internal.ads.zzgom.zzG(r0)
            r0 = r10
            r1 = r29
            r4 = r19
            r2 = r8
            r19 = r31
            r8 = r4
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r20
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r2 = r8
            r0 = r13
            goto L_0x0201
        L_0x00be:
            r8 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            r5 = r4
            r13 = r8
            goto L_0x020b
        L_0x00c9:
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != 0) goto L_0x019a
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.ads.zzgom.zzF(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x01fe
        L_0x00e1:
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != 0) goto L_0x019a
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x01fe
        L_0x00f5:
            r13 = r19
            r0 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x019a
            int r0 = com.google.android.gms.internal.ads.zzgnr.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x01fe
        L_0x010a:
            r13 = r19
            r0 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x019a
            java.lang.Object r8 = r15.zzF(r14, r13)
            com.google.android.gms.internal.ads.zzgrp r1 = r15.zzC(r13)
            r0 = r8
            r2 = r30
            r3 = r4
            r4 = r32
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r13, r8)
            goto L_0x01fe
        L_0x012d:
            r13 = r19
            r0 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x019a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0142
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzg(r12, r4, r11)
            goto L_0x0146
        L_0x0142:
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzh(r12, r4, r11)
        L_0x0146:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x01fe
        L_0x014d:
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != 0) goto L_0x019a
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0164
            r1 = 1
            goto L_0x0165
        L_0x0164:
            r1 = 0
        L_0x0165:
            com.google.android.gms.internal.ads.zzgsq.zzp(r14, r8, r1)
            goto L_0x01fe
        L_0x016a:
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x019a
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x01fe
        L_0x017e:
            r13 = r19
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x019a
            long r20 = com.google.android.gms.internal.ads.zzgnr.zzp(r12, r4)
            r0 = r10
            r1 = r29
            r2 = r8
            r8 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x01fe
        L_0x019a:
            r5 = r4
            goto L_0x020b
        L_0x019d:
            r5 = r4
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != 0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzj(r12, r5, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x01fe
        L_0x01b1:
            r5 = r4
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != 0) goto L_0x020b
            int r17 = com.google.android.gms.internal.ads.zzgnr.zzm(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r29
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r2 = r13
            r0 = r17
            goto L_0x0201
        L_0x01ce:
            r5 = r4
            r13 = r19
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x020b
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzb(r12, r5)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgsq.zzs(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x01fe
        L_0x01e6:
            r5 = r4
            r13 = r19
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r31
            if (r3 != r0) goto L_0x020b
            long r0 = com.google.android.gms.internal.ads.zzgnr.zzp(r12, r5)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgsq.zzr(r14, r8, r0)
            int r0 = r5 + 8
        L_0x01fe:
            r6 = r6 | r22
            r2 = r13
        L_0x0201:
            r1 = r19
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = -1
            r13 = r32
            goto L_0x0024
        L_0x020b:
            r2 = r5
            r27 = r10
            r22 = r13
            r18 = -1
            goto L_0x030d
        L_0x0214:
            r19 = r31
            r5 = r4
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r13 != r0) goto L_0x026b
            r0 = 2
            if (r3 != r0) goto L_0x025e
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.ads.zzgpv r0 = (com.google.android.gms.internal.ads.zzgpv) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x023f
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0237
            r1 = 10
            goto L_0x0238
        L_0x0237:
            int r1 = r1 + r1
        L_0x0238:
            com.google.android.gms.internal.ads.zzgpv r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x023f:
            r8 = r0
            com.google.android.gms.internal.ads.zzgrp r0 = r15.zzC(r4)
            r1 = r17
            r2 = r30
            r3 = r5
            r22 = r4
            r4 = r32
            r5 = r8
            r8 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r32
            r6 = r8
            r1 = r19
            r2 = r22
            goto L_0x032d
        L_0x025e:
            r22 = r4
            r15 = r5
            r25 = r6
            r26 = r7
            r27 = r10
            r18 = -1
            goto L_0x02e9
        L_0x026b:
            r22 = r4
            r0 = 49
            if (r13 > r0) goto L_0x02bb
            r1 = r20
            long r1 = (long) r1
            r0 = r28
            r20 = r1
            r1 = r29
            r2 = r30
            r4 = r3
            r3 = r5
            r31 = r4
            r4 = r32
            r15 = r5
            r5 = r17
            r25 = r6
            r6 = r19
            r26 = r7
            r7 = r31
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r22
            r27 = r10
            r18 = -1
            r9 = r20
            r11 = r13
            r12 = r23
            r14 = r33
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02b9
        L_0x02a5:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r1 = r19
            r2 = r22
            r6 = r25
            r7 = r26
            goto L_0x032b
        L_0x02b9:
            r2 = r0
            goto L_0x02ea
        L_0x02bb:
            r31 = r3
            r15 = r5
            r25 = r6
            r26 = r7
            r23 = r8
            r27 = r10
            r1 = r20
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x02ef
            r7 = r31
            r0 = 2
            if (r7 != r0) goto L_0x02e9
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r22
            r6 = r23
            r8 = r33
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02b9
            goto L_0x02a5
        L_0x02e9:
            r2 = r15
        L_0x02ea:
            r6 = r25
            r7 = r26
            goto L_0x030d
        L_0x02ef:
            r7 = r31
            r0 = r28
            r8 = r1
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r17
            r6 = r19
            r9 = r13
            r10 = r23
            r12 = r22
            r13 = r33
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02b9
            goto L_0x02a5
        L_0x030d:
            com.google.android.gms.internal.ads.zzgsh r4 = zzd(r29)
            r0 = r17
            r1 = r30
            r3 = r32
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzgnr.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r1 = r19
            r2 = r22
        L_0x032b:
            r10 = r27
        L_0x032d:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = -1
            goto L_0x0024
        L_0x0333:
            r25 = r6
            r27 = r10
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0346
            long r1 = (long) r7
            r3 = r29
            r6 = r25
            r4 = r27
            r4.putInt(r3, r1, r6)
        L_0x0346:
            r4 = r32
            if (r0 != r4) goto L_0x034b
            return
        L_0x034b:
            com.google.android.gms.internal.ads.zzgpy r0 = com.google.android.gms.internal.ads.zzgpy.zzg()
            throw r0
        L_0x0350:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r6 = r33
            r0.zzc(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqz.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzgnq):void");
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z2;
        int length = this.zzc.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzz = zzz(i2);
            long j2 = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    if (zzQ(obj, obj2, i2) && Double.doubleToLongBits(zzgsq.zzb(obj, j2)) == Double.doubleToLongBits(zzgsq.zzb(obj2, j2))) {
                        continue;
                    }
                case 1:
                    if (zzQ(obj, obj2, i2) && Float.floatToIntBits(zzgsq.zzc(obj, j2)) == Float.floatToIntBits(zzgsq.zzc(obj2, j2))) {
                        continue;
                    }
                case 2:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzf(obj, j2) == zzgsq.zzf(obj2, j2)) {
                        continue;
                    }
                case 3:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzf(obj, j2) == zzgsq.zzf(obj2, j2)) {
                        continue;
                    }
                case 4:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 5:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzf(obj, j2) == zzgsq.zzf(obj2, j2)) {
                        continue;
                    }
                case 6:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 7:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzz(obj, j2) == zzgsq.zzz(obj2, j2)) {
                        continue;
                    }
                case 8:
                    if (zzQ(obj, obj2, i2) && zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2))) {
                        continue;
                    }
                case 9:
                    if (zzQ(obj, obj2, i2) && zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2))) {
                        continue;
                    }
                case 10:
                    if (zzQ(obj, obj2, i2) && zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2))) {
                        continue;
                    }
                case 11:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 12:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 13:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 14:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzf(obj, j2) == zzgsq.zzf(obj2, j2)) {
                        continue;
                    }
                case 15:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzd(obj, j2) == zzgsq.zzd(obj2, j2)) {
                        continue;
                    }
                case 16:
                    if (zzQ(obj, obj2, i2) && zzgsq.zzf(obj, j2) == zzgsq.zzf(obj2, j2)) {
                        continue;
                    }
                case 17:
                    if (zzQ(obj, obj2, i2) && zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z2 = zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2));
                    break;
                case 50:
                    z2 = zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzw = (long) (zzw(i2) & 1048575);
                    if (zzgsq.zzd(obj, zzw) == zzgsq.zzd(obj2, zzw) && zzgrr.zzE(zzgsq.zzh(obj, j2), zzgsq.zzh(obj2, j2))) {
                        continue;
                    }
            }
            if (!z2) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i2;
        int i3;
        Object obj2 = obj;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int i7 = this.zzj[i6];
            int i8 = this.zzc[i7];
            int zzz = zzz(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj2, (long) i10);
                }
                i2 = i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if ((268435456 & zzz) != 0 && !zzT(obj, i7, i3, i2, i11)) {
                return false;
            }
            int zzy = zzy(zzz);
            if (zzy != 9 && zzy != 17) {
                if (zzy != 27) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzW(obj2, i8, i7) && !zzU(obj2, zzz, zzC(i7))) {
                            return false;
                        }
                    } else if (zzy != 49) {
                        if (zzy == 50 && !((zzgqq) zzgsq.zzh(obj2, (long) (zzz & 1048575))).isEmpty()) {
                            zzgqp zzgqp = (zzgqp) zzE(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) zzgsq.zzh(obj2, (long) (zzz & 1048575));
                if (!list.isEmpty()) {
                    zzgrp zzC = zzC(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzC.zzk(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzT(obj, i7, i3, i2, i11) && !zzU(obj2, zzz, zzC(i7))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzm(Object obj, zzgou zzgou) throws IOException {
        int i2;
        Object obj2 = obj;
        zzgou zzgou2 = zzgou;
        zzgsw zzgsw = zzgsw.DOUBLE;
        int i3 = 1048575;
        if (this.zzp - 1 != 0) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i4 = 0; i4 < length; i4 += 3) {
                    int zzz = zzz(i4);
                    int i5 = this.zzc[i4];
                    switch (zzy(zzz)) {
                        case 0:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzf(i5, zzgsq.zzb(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 1:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzo(i5, zzgsq.zzc(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 2:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzt(i5, zzgsq.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 3:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzJ(i5, zzgsq.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 4:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzr(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 5:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzm(i5, zzgsq.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 6:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzk(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 7:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzb(i5, zzgsq.zzz(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 8:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzZ(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2);
                                break;
                            }
                        case 9:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzv(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzC(i4));
                                break;
                            }
                        case 10:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzd(i5, (zzgoe) zzgsq.zzh(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 11:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzH(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 12:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzi(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 13:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzw(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 14:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzy(i5, zzgsq.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 15:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzA(i5, zzgsq.zzd(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 16:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzC(i5, zzgsq.zzf(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 17:
                            if (!zzS(obj2, i4)) {
                                break;
                            } else {
                                zzgou2.zzq(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzC(i4));
                                break;
                            }
                        case 18:
                            zzgrr.zzH(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 19:
                            zzgrr.zzL(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 20:
                            zzgrr.zzO(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 21:
                            zzgrr.zzW(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 22:
                            zzgrr.zzN(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 23:
                            zzgrr.zzK(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 24:
                            zzgrr.zzJ(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 25:
                            zzgrr.zzF(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 26:
                            zzgrr.zzU(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2);
                            break;
                        case 27:
                            zzgrr.zzP(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, zzC(i4));
                            break;
                        case 28:
                            zzgrr.zzG(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2);
                            break;
                        case 29:
                            zzgrr.zzV(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 30:
                            zzgrr.zzI(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 31:
                            zzgrr.zzQ(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 32:
                            zzgrr.zzR(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 33:
                            zzgrr.zzS(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 34:
                            zzgrr.zzT(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, false);
                            break;
                        case 35:
                            zzgrr.zzH(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 36:
                            zzgrr.zzL(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 37:
                            zzgrr.zzO(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 38:
                            zzgrr.zzW(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 39:
                            zzgrr.zzN(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 40:
                            zzgrr.zzK(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 41:
                            zzgrr.zzJ(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 42:
                            zzgrr.zzF(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 43:
                            zzgrr.zzV(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 44:
                            zzgrr.zzI(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 45:
                            zzgrr.zzQ(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 46:
                            zzgrr.zzR(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 47:
                            zzgrr.zzS(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 48:
                            zzgrr.zzT(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, true);
                            break;
                        case 49:
                            zzgrr.zzM(i5, (List) zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2, zzC(i4));
                            break;
                        case 50:
                            zzY(zzgou2, i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), i4);
                            break;
                        case 51:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzf(i5, zzn(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 52:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzo(i5, zzo(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 53:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzt(i5, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 54:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzJ(i5, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 55:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzr(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 56:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzm(i5, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 57:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzk(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 58:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzb(i5, zzX(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 59:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzZ(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzgou2);
                                break;
                            }
                        case 60:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzv(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzC(i4));
                                break;
                            }
                        case 61:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzd(i5, (zzgoe) zzgsq.zzh(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 62:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzH(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 63:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzi(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 64:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzw(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 65:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzy(i5, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 66:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzA(i5, zzq(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 67:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzC(i5, zzA(obj2, (long) (zzz & 1048575)));
                                break;
                            }
                        case 68:
                            if (!zzW(obj2, i5, i4)) {
                                break;
                            } else {
                                zzgou2.zzq(i5, zzgsq.zzh(obj2, (long) (zzz & 1048575)), zzC(i4));
                                break;
                            }
                    }
                }
                zzgsg zzgsg = this.zzn;
                zzgsg.zzr(zzgsg.zzd(obj2), zzgou2);
                return;
            }
            this.zzo.zza(obj2);
            throw null;
        } else if (!this.zzh) {
            int length2 = this.zzc.length;
            Unsafe unsafe = zzb;
            int i6 = 0;
            int i7 = 1048575;
            int i8 = 0;
            while (i6 < length2) {
                int zzz2 = zzz(i6);
                int[] iArr = this.zzc;
                int i9 = iArr[i6];
                int zzy = zzy(zzz2);
                if (zzy <= 17) {
                    int i10 = iArr[i6 + 2];
                    int i11 = i10 & i3;
                    if (i11 != i7) {
                        i8 = unsafe.getInt(obj2, (long) i11);
                        i7 = i11;
                    }
                    i2 = 1 << (i10 >>> 20);
                } else {
                    i2 = 0;
                }
                long j2 = (long) (zzz2 & i3);
                switch (zzy) {
                    case 0:
                        if ((i8 & i2) == 0) {
                            break;
                        } else {
                            zzgou2.zzf(i9, zzgsq.zzb(obj2, j2));
                            continue;
                        }
                    case 1:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzo(i9, zzgsq.zzc(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzt(i9, unsafe.getLong(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzJ(i9, unsafe.getLong(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzr(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzm(i9, unsafe.getLong(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzk(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzb(i9, zzgsq.zzz(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i8 & i2) != 0) {
                            zzZ(i9, unsafe.getObject(obj2, j2), zzgou2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzv(i9, unsafe.getObject(obj2, j2), zzC(i6));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzd(i9, (zzgoe) unsafe.getObject(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzH(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzi(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzw(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzy(i9, unsafe.getLong(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzA(i9, unsafe.getInt(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzC(i9, unsafe.getLong(obj2, j2));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i8 & i2) != 0) {
                            zzgou2.zzq(i9, unsafe.getObject(obj2, j2), zzC(i6));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzgrr.zzH(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 19:
                        zzgrr.zzL(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 20:
                        zzgrr.zzO(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 21:
                        zzgrr.zzW(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 22:
                        zzgrr.zzN(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 23:
                        zzgrr.zzK(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 24:
                        zzgrr.zzJ(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 25:
                        zzgrr.zzF(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        continue;
                    case 26:
                        zzgrr.zzU(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2);
                        break;
                    case 27:
                        zzgrr.zzP(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, zzC(i6));
                        break;
                    case 28:
                        zzgrr.zzG(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2);
                        break;
                    case 29:
                        zzgrr.zzV(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 30:
                        zzgrr.zzI(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 31:
                        zzgrr.zzQ(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 32:
                        zzgrr.zzR(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 33:
                        zzgrr.zzS(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 34:
                        zzgrr.zzT(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, false);
                        break;
                    case 35:
                        zzgrr.zzH(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 36:
                        zzgrr.zzL(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 37:
                        zzgrr.zzO(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 38:
                        zzgrr.zzW(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 39:
                        zzgrr.zzN(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 40:
                        zzgrr.zzK(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 41:
                        zzgrr.zzJ(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 42:
                        zzgrr.zzF(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 43:
                        zzgrr.zzV(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 44:
                        zzgrr.zzI(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 45:
                        zzgrr.zzQ(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 46:
                        zzgrr.zzR(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 47:
                        zzgrr.zzS(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 48:
                        zzgrr.zzT(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, true);
                        break;
                    case 49:
                        zzgrr.zzM(this.zzc[i6], (List) unsafe.getObject(obj2, j2), zzgou2, zzC(i6));
                        break;
                    case 50:
                        zzY(zzgou2, i9, unsafe.getObject(obj2, j2), i6);
                        break;
                    case 51:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzf(i9, zzn(obj2, j2));
                            break;
                        }
                        break;
                    case 52:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzo(i9, zzo(obj2, j2));
                            break;
                        }
                        break;
                    case 53:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzt(i9, zzA(obj2, j2));
                            break;
                        }
                        break;
                    case 54:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzJ(i9, zzA(obj2, j2));
                            break;
                        }
                        break;
                    case 55:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzr(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 56:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzm(i9, zzA(obj2, j2));
                            break;
                        }
                        break;
                    case 57:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzk(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 58:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzb(i9, zzX(obj2, j2));
                            break;
                        }
                        break;
                    case 59:
                        if (zzW(obj2, i9, i6)) {
                            zzZ(i9, unsafe.getObject(obj2, j2), zzgou2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzv(i9, unsafe.getObject(obj2, j2), zzC(i6));
                            break;
                        }
                        break;
                    case 61:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzd(i9, (zzgoe) unsafe.getObject(obj2, j2));
                            break;
                        }
                        break;
                    case 62:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzH(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 63:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzi(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 64:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzw(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 65:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzy(i9, zzA(obj2, j2));
                            break;
                        }
                        break;
                    case 66:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzA(i9, zzq(obj2, j2));
                            break;
                        }
                        break;
                    case 67:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzC(i9, zzA(obj2, j2));
                            break;
                        }
                        break;
                    case 68:
                        if (zzW(obj2, i9, i6)) {
                            zzgou2.zzq(i9, unsafe.getObject(obj2, j2), zzC(i6));
                            break;
                        }
                        break;
                }
                i6 += 3;
                i3 = 1048575;
            }
            zzgsg zzgsg2 = this.zzn;
            zzgsg2.zzr(zzgsg2.zzd(obj2), zzgou2);
        } else {
            this.zzo.zza(obj2);
            throw null;
        }
    }
}
