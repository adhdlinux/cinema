package com.google.android.gms.internal.auth;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i2, int i3, zzfw zzfw, boolean z2, boolean z3, int[] iArr2, int i4, int i5, zzgb zzgb, zzfk zzfk, zzgy zzgy, zzel zzel, zzfr zzfr, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i2;
        this.zzf = i3;
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzgb;
        this.zzl = zzfk;
        this.zzm = zzgy;
        this.zzn = zzel;
        this.zzg = zzfw;
        this.zzp = zzfr;
    }

    private static Field zzA(Class cls, String str) {
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

    private final void zzB(Object obj, Object obj2, int i2) {
        long zzv = (long) (zzv(i2) & 1048575);
        if (zzG(obj2, i2)) {
            Object zzf2 = zzhi.zzf(obj, zzv);
            Object zzf3 = zzhi.zzf(obj2, zzv);
            if (zzf2 != null && zzf3 != null) {
                zzhi.zzp(obj, zzv, zzez.zzg(zzf2, zzf3));
                zzD(obj, i2);
            } else if (zzf3 != null) {
                zzhi.zzp(obj, zzv, zzf3);
                zzD(obj, i2);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i2) {
        Object obj3;
        int zzv = zzv(i2);
        int i3 = this.zzc[i2];
        long j2 = (long) (zzv & 1048575);
        if (zzJ(obj2, i3, i2)) {
            if (zzJ(obj, i3, i2)) {
                obj3 = zzhi.zzf(obj, j2);
            } else {
                obj3 = null;
            }
            Object zzf2 = zzhi.zzf(obj2, j2);
            if (obj3 != null && zzf2 != null) {
                zzhi.zzp(obj, j2, zzez.zzg(obj3, zzf2));
                zzE(obj, i3, i2);
            } else if (zzf2 != null) {
                zzhi.zzp(obj, j2, zzf2);
                zzE(obj, i3, i2);
            }
        }
    }

    private final void zzD(Object obj, int i2) {
        int zzs = zzs(i2);
        long j2 = (long) (1048575 & zzs);
        if (j2 != 1048575) {
            zzhi.zzn(obj, j2, (1 << (zzs >>> 20)) | zzhi.zzc(obj, j2));
        }
    }

    private final void zzE(Object obj, int i2, int i3) {
        zzhi.zzn(obj, (long) (zzs(i3) & 1048575), i2);
    }

    private final boolean zzF(Object obj, Object obj2, int i2) {
        return zzG(obj, i2) == zzG(obj2, i2);
    }

    private final boolean zzG(Object obj, int i2) {
        int zzs = zzs(i2);
        long j2 = (long) (zzs & 1048575);
        if (j2 == 1048575) {
            int zzv = zzv(i2);
            long j3 = (long) (zzv & 1048575);
            switch (zzu(zzv)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhi.zza(obj, j3)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzhi.zzb(obj, j3)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzhi.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzhi.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzhi.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzhi.zzt(obj, j3);
                case 8:
                    Object zzf2 = zzhi.zzf(obj, j3);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzee)) {
                        throw new IllegalArgumentException();
                    } else if (!zzee.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzhi.zzf(obj, j3) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzee.zzb.equals(zzhi.zzf(obj, j3))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzhi.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzhi.zzc(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzhi.zzd(obj, j3) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzhi.zzf(obj, j3) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzhi.zzc(obj, j2) & (1 << (zzs >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzH(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? zzG(obj, i2) : (i4 & i5) != 0;
    }

    private static boolean zzI(Object obj, int i2, zzgh zzgh) {
        return zzgh.zzi(zzhi.zzf(obj, (long) (i2 & 1048575)));
    }

    private final boolean zzJ(Object obj, int i2, int i3) {
        if (zzhi.zzc(obj, (long) (zzs(i3) & 1048575)) == i2) {
            return true;
        }
        return false;
    }

    static zzgz zzc(Object obj) {
        zzeu zzeu = (zzeu) obj;
        zzgz zzgz = zzeu.zzc;
        if (zzgz != zzgz.zza()) {
            return zzgz;
        }
        zzgz zzc2 = zzgz.zzc();
        zzeu.zzc = zzc2;
        return zzc2;
    }

    static zzfz zzj(Class cls, zzft zzft, zzgb zzgb, zzfk zzfk, zzgy zzgy, zzel zzel, zzfr zzfr) {
        if (zzft instanceof zzgg) {
            return zzk((zzgg) zzft, zzgb, zzfk, zzgy, zzel, zzfr);
        }
        zzgv zzgv = (zzgv) zzft;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.auth.zzfz zzk(com.google.android.gms.internal.auth.zzgg r34, com.google.android.gms.internal.auth.zzgb r35, com.google.android.gms.internal.auth.zzfk r36, com.google.android.gms.internal.auth.zzgy r37, com.google.android.gms.internal.auth.zzel r38, com.google.android.gms.internal.auth.zzfr r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
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
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
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
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
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
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
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
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.auth.zzfw r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r1) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0193:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a5
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0193
        L_0x01a5:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ad
        L_0x01ab:
            r3 = r24
        L_0x01ad:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01da
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d4
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bb
        L_0x01d4:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r1
            r1 = r24
        L_0x01de:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0222
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzA(r2, r12)
            r17[r1] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r1 = r1 + 1
            r7 = r17[r1]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzA(r2, r7)
            r17[r1] = r7
        L_0x0283:
            r1 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r0 = r6
            r7 = r8
            r29 = r11
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzA(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0354
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r1 = r1 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r1 = r1 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r1 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzA(r2, r11)
            r17[r7] = r11
        L_0x036f:
            r0 = r6
            long r6 = r15.objectFieldOffset(r11)
            int r7 = (int) r6
            int r1 = r1 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r0 = r6
            r27 = r1
            r1 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0381:
            r6 = 18
            if (r5 < r6) goto L_0x038f
            r6 = 49
            if (r5 > r6) goto L_0x038f
            int r6 = r23 + 1
            r13[r23] = r8
            r23 = r6
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r6 = r9 + 1
            r31[r9] = r4
            int r4 = r6 + 1
            r9 = r3 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a6
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r3 = 0
        L_0x03a7:
            r3 = r3 | r9
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r31[r6] = r3
            int r9 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r7
            r31[r4] = r1
            r6 = r0
            r8 = r14
            r14 = r24
            r4 = r27
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.auth.zzfz r0 = new com.google.android.gms.internal.auth.zzfz
            r4 = r0
            com.google.android.gms.internal.auth.zzfw r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzk(com.google.android.gms.internal.auth.zzgg, com.google.android.gms.internal.auth.zzgb, com.google.android.gms.internal.auth.zzfk, com.google.android.gms.internal.auth.zzgy, com.google.android.gms.internal.auth.zzel, com.google.android.gms.internal.auth.zzfr):com.google.android.gms.internal.auth.zzfz");
    }

    private static int zzl(Object obj, long j2) {
        return ((Integer) zzhi.zzf(obj, j2)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, zzds zzds) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i4);
        Object object = unsafe.getObject(obj, j2);
        if (!((zzfq) object).zze()) {
            zzfq zzb2 = zzfq.zza().zzb();
            zzfr.zza(zzb2, object);
            unsafe.putObject(obj, j2, zzb2);
        }
        zzfp zzfp = (zzfp) zzz;
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzds zzds) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        int i14 = i9;
        zzds zzds2 = zzds;
        Unsafe unsafe = zzb;
        long j4 = (long) (this.zzc[i14 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i2))));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 8;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i2))));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 4;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    int zzm2 = zzdt.zzm(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, Long.valueOf(zzds2.zzb));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    int zzj2 = zzdt.zzj(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzds2.zza));
                    unsafe.putInt(obj2, j4, i12);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Long.valueOf(zzdt.zzn(bArr, i2)));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 8;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzdt.zzb(bArr, i2)));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 4;
                }
                break;
            case 58:
                if (i13 == 0) {
                    int zzm3 = zzdt.zzm(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, Boolean.valueOf(zzds2.zzb != 0));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm3;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int zzj3 = zzdt.zzj(bArr2, i10, zzds2);
                    int i15 = zzds2.zza;
                    if (i15 == 0) {
                        unsafe.putObject(obj2, j3, "");
                    } else if ((i7 & 536870912) == 0 || zzhm.zzd(bArr2, zzj3, zzj3 + i15)) {
                        unsafe.putObject(obj2, j3, new String(bArr2, zzj3, i15, zzez.zzb));
                        zzj3 += i15;
                    } else {
                        throw zzfa.zzb();
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return zzj3;
                }
                break;
            case 60:
                if (i13 == 2) {
                    int zzd2 = zzdt.zzd(zzy(i14), bArr2, i10, i3, zzds2);
                    Object object = unsafe.getInt(obj2, j4) == i12 ? unsafe.getObject(obj2, j3) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j3, zzds2.zzc);
                    } else {
                        unsafe.putObject(obj2, j3, zzez.zzg(object, zzds2.zzc));
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return zzd2;
                }
                break;
            case 61:
                if (i13 == 2) {
                    int zza2 = zzdt.zza(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, zzds2.zzc);
                    unsafe.putInt(obj2, j4, i12);
                    return zza2;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int zzj4 = zzdt.zzj(bArr2, i10, zzds2);
                    int i16 = zzds2.zza;
                    zzex zzx = zzx(i14);
                    if (zzx == null || zzx.zza()) {
                        unsafe.putObject(obj2, j3, Integer.valueOf(i16));
                        unsafe.putInt(obj2, j4, i12);
                    } else {
                        zzc(obj).zzf(i11, Long.valueOf((long) i16));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i13 == 0) {
                    int zzj5 = zzdt.zzj(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(zzei.zzb(zzds2.zza)));
                    unsafe.putInt(obj2, j4, i12);
                    return zzj5;
                }
                break;
            case 67:
                if (i13 == 0) {
                    int zzm4 = zzdt.zzm(bArr2, i10, zzds2);
                    unsafe.putObject(obj2, j3, Long.valueOf(zzei.zzc(zzds2.zzb)));
                    unsafe.putInt(obj2, j4, i12);
                    return zzm4;
                }
                break;
            case 68:
                if (i13 == 3) {
                    int zzc2 = zzdt.zzc(zzy(i14), bArr, i2, i3, (i11 & -8) | 4, zzds);
                    Object object2 = unsafe.getInt(obj2, j4) == i12 ? unsafe.getObject(obj2, j3) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j3, zzds2.zzc);
                    } else {
                        unsafe.putObject(obj2, j3, zzez.zzg(object2, zzds2.zzc));
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return zzc2;
                }
                break;
        }
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02d0, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0300, code lost:
        if (r0 != r14) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0322, code lost:
        if (r0 != r14) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0101, code lost:
        r6 = r6 | r22;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a9, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e2, code lost:
        r6 = r6 | r22;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x021b, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x021d, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0220, code lost:
        r2 = r8;
        r28 = r9;
        r24 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b5, code lost:
        if (r0 != r32) goto L_0x02b7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzo(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.auth.zzds r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x034b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.auth.zzdt.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzr(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzq(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r8) goto L_0x004e
            r2 = r4
            r21 = r5
            r28 = r9
            r18 = -1
            r24 = 0
            goto L_0x0325
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r8 = zzu(r1)
            r32 = r5
            r5 = r1 & r10
            long r10 = (long) r5
            r5 = 17
            r20 = r10
            if (r8 > r5) goto L_0x0229
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x0080
            if (r7 == r5) goto L_0x0078
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
        L_0x0078:
            if (r0 == r5) goto L_0x007f
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x007f:
            r7 = r0
        L_0x0080:
            r0 = 5
            switch(r8) {
                case 0: goto L_0x0202;
                case 1: goto L_0x01e7;
                case 2: goto L_0x01c4;
                case 3: goto L_0x01c4;
                case 4: goto L_0x01ac;
                case 5: goto L_0x018c;
                case 6: goto L_0x0175;
                case 7: goto L_0x0155;
                case 8: goto L_0x0131;
                case 9: goto L_0x0106;
                case 10: goto L_0x00eb;
                case 11: goto L_0x01ac;
                case 12: goto L_0x00d5;
                case 13: goto L_0x0175;
                case 14: goto L_0x018c;
                case 15: goto L_0x00bb;
                case 16: goto L_0x008f;
                default: goto L_0x0084;
            }
        L_0x0084:
            r21 = r32
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0220
        L_0x008f:
            if (r3 != 0) goto L_0x00b1
            r11 = r34
            r0 = r20
            int r8 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r19 = com.google.android.gms.internal.auth.zzei.zzc(r3)
            r3 = r0
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r3
            r21 = r32
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x01e2
        L_0x00b1:
            r21 = r32
            r11 = r34
            r10 = r2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x01a9
        L_0x00bb:
            r11 = r34
            r10 = r2
            r0 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.auth.zzei.zzb(r3)
            r9.putInt(r14, r0, r3)
            goto L_0x0101
        L_0x00d5:
            r11 = r34
            r10 = r2
            r0 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x0101
        L_0x00eb:
            r11 = r34
            r10 = r2
            r0 = r20
            r2 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r2) goto L_0x01a9
            int r2 = com.google.android.gms.internal.auth.zzdt.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x0101:
            r6 = r6 | r22
            r0 = r2
            goto L_0x026c
        L_0x0106:
            r11 = r34
            r10 = r2
            r0 = r20
            r2 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r2) goto L_0x01a9
            com.google.android.gms.internal.auth.zzgh r2 = r15.zzy(r10)
            int r2 = com.google.android.gms.internal.auth.zzdt.zzd(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0127
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x0101
        L_0x0127:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzez.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x0101
        L_0x0131:
            r11 = r34
            r10 = r2
            r25 = r20
            r0 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0148
            int r0 = com.google.android.gms.internal.auth.zzdt.zzg(r12, r4, r11)
            goto L_0x014c
        L_0x0148:
            int r0 = com.google.android.gms.internal.auth.zzdt.zzh(r12, r4, r11)
        L_0x014c:
            java.lang.Object r1 = r11.zzc
            r2 = r25
            r9.putObject(r14, r2, r1)
            goto L_0x021d
        L_0x0155:
            r11 = r34
            r10 = r2
            r1 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r0 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r19 = 0
            int r5 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x016f
            r3 = 1
            goto L_0x0170
        L_0x016f:
            r3 = 0
        L_0x0170:
            com.google.android.gms.internal.auth.zzhi.zzk(r14, r1, r3)
            goto L_0x021d
        L_0x0175:
            r11 = r34
            r10 = r2
            r1 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r4)
            r9.putInt(r14, r1, r0)
            int r0 = r4 + 4
            goto L_0x021d
        L_0x018c:
            r11 = r34
            r10 = r2
            r1 = r20
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            long r19 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r4)
            r0 = r9
            r2 = r1
            r1 = r30
            r8 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x021b
        L_0x01a9:
            r8 = r4
            goto L_0x0220
        L_0x01ac:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x0220
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r4, r1)
            goto L_0x021d
        L_0x01c4:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x0220
            int r8 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r8, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x01e2:
            r6 = r6 | r22
            r0 = r8
            goto L_0x026c
        L_0x01e7:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x0220
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r8)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzhi.zzm(r14, r4, r0)
            int r0 = r8 + 4
            goto L_0x021d
        L_0x0202:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x0220
            long r0 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r8)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzhi.zzl(r14, r4, r0)
        L_0x021b:
            int r0 = r8 + 8
        L_0x021d:
            r6 = r6 | r22
            goto L_0x026c
        L_0x0220:
            r2 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x0325
        L_0x0229:
            r11 = r34
            r10 = r2
            r2 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            r0 = 27
            if (r8 != r0) goto L_0x027d
            r0 = 2
            if (r3 != r0) goto L_0x0271
            java.lang.Object r0 = r9.getObject(r14, r4)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0258
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0250
            r1 = 10
            goto L_0x0251
        L_0x0250:
            int r1 = r1 + r1
        L_0x0251:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r9.putObject(r14, r4, r0)
        L_0x0258:
            r5 = r0
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r10)
            r1 = r17
            r3 = r2
            r2 = r31
            r4 = r33
            r8 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.auth.zzdt.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x026c:
            r2 = r10
            r1 = r21
            goto L_0x0345
        L_0x0271:
            r14 = r2
            r23 = r6
            r15 = r7
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x0303
        L_0x027d:
            r0 = 49
            if (r8 > r0) goto L_0x02d2
            long r0 = (long) r1
            r19 = r0
            r0 = r29
            r1 = r30
            r32 = r2
            r2 = r31
            r22 = r3
            r3 = r32
            r25 = r4
            r4 = r33
            r5 = r17
            r15 = r6
            r6 = r21
            r23 = r15
            r15 = r7
            r7 = r22
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r24 = r10
            r9 = r19
            r11 = r27
            r12 = r25
            r14 = r34
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r32
            if (r0 == r14) goto L_0x02d0
        L_0x02b7:
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r7 = r15
            r1 = r21
            r6 = r23
            r2 = r24
            r9 = r28
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r29
            goto L_0x001a
        L_0x02d0:
            r2 = r0
            goto L_0x0304
        L_0x02d2:
            r14 = r2
            r22 = r3
            r25 = r4
            r23 = r6
            r15 = r7
            r27 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x0308
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x0303
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r24
            r6 = r25
            r8 = r34
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02d0
            goto L_0x02b7
        L_0x0303:
            r2 = r14
        L_0x0304:
            r7 = r15
            r6 = r23
            goto L_0x0325
        L_0x0308:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r17
            r6 = r21
            r10 = r25
            r12 = r24
            r13 = r34
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02d0
            goto L_0x02b7
        L_0x0325:
            com.google.android.gms.internal.auth.zzgz r4 = zzc(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.auth.zzdt.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r21
            r2 = r24
            r9 = r28
        L_0x0345:
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x001a
        L_0x034b:
            r23 = r6
            r15 = r7
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 == r1) goto L_0x035f
            long r1 = (long) r15
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x035f:
            r1 = r33
            if (r0 != r1) goto L_0x0364
            return r0
        L_0x0364:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzo(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x044f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzp(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.auth.zzds r29) throws java.io.IOException {
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
            com.google.android.gms.internal.auth.zzey r12 = (com.google.android.gms.internal.auth.zzey) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.auth.zzey r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.auth.zzgh r1 = r15.zzy(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdt.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.auth.zzei.zzc(r4)
            r12.zze(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzei.zzc(r8)
            r12.zze(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzei.zzc(r8)
            r12.zze(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.auth.zzdt.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.auth.zzdt.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.auth.zzeu r1 = (com.google.android.gms.internal.auth.zzeu) r1
            com.google.android.gms.internal.auth.zzgz r3 = r1.zzc
            com.google.android.gms.internal.auth.zzgz r4 = com.google.android.gms.internal.auth.zzgz.zza()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.auth.zzex r4 = r15.zzx(r8)
            com.google.android.gms.internal.auth.zzgy r5 = r0.zzm
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgj.zzd(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.auth.zzgz r3 = (com.google.android.gms.internal.auth.zzgz) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.auth.zzgh r1 = r15.zzy(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.auth.zzdt.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01fa
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f5
            if (r6 != 0) goto L_0x01c2
            r12.add(r1)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01cc:
            int r4 = r4 + r6
        L_0x01cd:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f0
            if (r6 != 0) goto L_0x01e5
            r12.add(r1)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01fa:
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0255
            if (r6 != 0) goto L_0x0208
            r12.add(r1)
            goto L_0x021b
        L_0x0208:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.auth.zzhm.zzd(r3, r4, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x021a:
            r4 = r8
        L_0x021b:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024b
            if (r6 != 0) goto L_0x0233
            r12.add(r1)
            goto L_0x021b
        L_0x0233:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.auth.zzhm.zzd(r3, r4, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.auth.zzdu r12 = (com.google.android.gms.internal.auth.zzdu) r12
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0274
            r5 = 1
            goto L_0x0275
        L_0x0274:
            r5 = 0
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzdu r12 = (com.google.android.gms.internal.auth.zzdu) r12
            int r4 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = 1
            goto L_0x0294
        L_0x0293:
            r6 = 0
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r1)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r17, r18)
            r12.zze(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r4)
            r12.zze(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r1)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r17, r18)
            r12.zze(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r4)
            r12.zze(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.auth.zzdt.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.auth.zzdt.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zze(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zze(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zze(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.auth.zzeq r12 = (com.google.android.gms.internal.auth.zzeq) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.auth.zzeq r12 = (com.google.android.gms.internal.auth.zzeq) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.auth.zzej r12 = (com.google.android.gms.internal.auth.zzej) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.auth.zzej r12 = (com.google.android.gms.internal.auth.zzej) r12
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdt.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzp(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.auth.zzds):int");
    }

    private final int zzq(int i2) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzt(i2, 0);
    }

    private final int zzr(int i2, int i3) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzt(i2, i3);
    }

    private final int zzs(int i2) {
        return this.zzc[i2 + 2];
    }

    private final int zzt(int i2, int i3) {
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

    private static int zzu(int i2) {
        return (i2 >>> 20) & JfifUtil.MARKER_FIRST_BYTE;
    }

    private final int zzv(int i2) {
        return this.zzc[i2 + 1];
    }

    private static long zzw(Object obj, long j2) {
        return ((Long) zzhi.zzf(obj, j2)).longValue();
    }

    private final zzex zzx(int i2) {
        int i3 = i2 / 3;
        return (zzex) this.zzd[i3 + i3 + 1];
    }

    private final zzgh zzy(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        zzgh zzgh = (zzgh) this.zzd[i4];
        if (zzgh != null) {
            return zzgh;
        }
        zzgh zzb2 = zzge.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i2) {
        int i3 = i2 / 3;
        return this.zzd[i3 + i3];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0238, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0239, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x023d
            int r3 = r8.zzv(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzu(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x022a;
                case 1: goto L_0x021f;
                case 2: goto L_0x0214;
                case 3: goto L_0x0209;
                case 4: goto L_0x0202;
                case 5: goto L_0x01f7;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01e5;
                case 8: goto L_0x01d8;
                case 9: goto L_0x01ca;
                case 10: goto L_0x01be;
                case 11: goto L_0x01b6;
                case 12: goto L_0x01ae;
                case 13: goto L_0x01a6;
                case 14: goto L_0x019a;
                case 15: goto L_0x0192;
                case 16: goto L_0x0186;
                case 17: goto L_0x017b;
                case 18: goto L_0x016f;
                case 19: goto L_0x016f;
                case 20: goto L_0x016f;
                case 21: goto L_0x016f;
                case 22: goto L_0x016f;
                case 23: goto L_0x016f;
                case 24: goto L_0x016f;
                case 25: goto L_0x016f;
                case 26: goto L_0x016f;
                case 27: goto L_0x016f;
                case 28: goto L_0x016f;
                case 29: goto L_0x016f;
                case 30: goto L_0x016f;
                case 31: goto L_0x016f;
                case 32: goto L_0x016f;
                case 33: goto L_0x016f;
                case 34: goto L_0x016f;
                case 35: goto L_0x016f;
                case 36: goto L_0x016f;
                case 37: goto L_0x016f;
                case 38: goto L_0x016f;
                case 39: goto L_0x016f;
                case 40: goto L_0x016f;
                case 41: goto L_0x016f;
                case 42: goto L_0x016f;
                case 43: goto L_0x016f;
                case 44: goto L_0x016f;
                case 45: goto L_0x016f;
                case 46: goto L_0x016f;
                case 47: goto L_0x016f;
                case 48: goto L_0x016f;
                case 49: goto L_0x016f;
                case 50: goto L_0x0163;
                case 51: goto L_0x0147;
                case 52: goto L_0x012f;
                case 53: goto L_0x011d;
                case 54: goto L_0x010b;
                case 55: goto L_0x00fd;
                case 56: goto L_0x00eb;
                case 57: goto L_0x00dd;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0239
        L_0x001f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x0031:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0043:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0051:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0063:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0071:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x007f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x008d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x009f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00b1:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00c5:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x0238
        L_0x00dd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x00eb:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x00fd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x010b:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x011d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x012f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x0147:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0163:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x016f:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x017b:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
            goto L_0x01d4
        L_0x0186:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0192:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x019a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x01a6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01ae:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01b6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01be:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01ca:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
        L_0x01d4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0239
        L_0x01d8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01e5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.zzhi.zzt(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x0238
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0202:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x0209:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0214:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x021f:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.zzhi.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x022a:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.zzhi.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
        L_0x0238:
            int r2 = r2 + r3
        L_0x0239:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x023d:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.zzgy r0 = r8.zzm
            java.lang.Object r9 = r0.zza(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0334, code lost:
        if (r0 != r15) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x034e, code lost:
        r7 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0371, code lost:
        if (r0 != r15) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0397, code lost:
        if (r0 != r15) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0156, code lost:
        r5 = r6 | r23;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e5, code lost:
        r5 = r6 | r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e7, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e8, code lost:
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x020c, code lost:
        r13 = r3;
        r17 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0277, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0279, code lost:
        r5 = r6 | r23;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x027d, code lost:
        r3 = r11;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0280, code lost:
        r2 = r19;
        r6 = r25;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0296, code lost:
        r7 = r34;
        r22 = r6;
        r28 = r10;
        r21 = r11;
        r2 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.auth.zzds r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x03c8
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.auth.zzdt.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x0038
            int r3 = r3 / r7
            int r2 = r15.zzr(r0, r3)
            goto L_0x003c
        L_0x0038:
            int r2 = r15.zzq(r0)
        L_0x003c:
            r3 = -1
            if (r2 != r3) goto L_0x004e
            r19 = r0
            r2 = r1
            r8 = r4
            r22 = r5
            r28 = r10
            r7 = r11
            r20 = -1
            r21 = 0
            goto L_0x039a
        L_0x004e:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r7 = r3[r19]
            int r11 = zzu(r7)
            r19 = r0
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r17
            r20 = r1
            long r0 = (long) r0
            r21 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02a1
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x0087
            r17 = r4
            if (r6 == r3) goto L_0x007f
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x007f:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r25 = r0
            goto L_0x008b
        L_0x0087:
            r17 = r4
            r25 = r6
        L_0x008b:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x025f;
                case 1: goto L_0x0245;
                case 2: goto L_0x0227;
                case 3: goto L_0x0227;
                case 4: goto L_0x0211;
                case 5: goto L_0x01eb;
                case 6: goto L_0x01ce;
                case 7: goto L_0x01ad;
                case 8: goto L_0x018a;
                case 9: goto L_0x015b;
                case 10: goto L_0x013e;
                case 11: goto L_0x0211;
                case 12: goto L_0x0108;
                case 13: goto L_0x01ce;
                case 14: goto L_0x01eb;
                case 15: goto L_0x00eb;
                case 16: goto L_0x00bc;
                default: goto L_0x0090;
            }
        L_0x0090:
            r11 = r2
            r13 = r20
            r2 = r21
            r0 = 3
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0296
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r11)
            int r1 = r19 << 3
            r4 = r1 | 4
            r1 = r31
            r7 = r2
            r2 = r13
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x0288
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r7, r1)
            goto L_0x0279
        L_0x00bc:
            if (r8 != 0) goto L_0x00e0
            r3 = r20
            int r7 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.auth.zzei.zzc(r0)
            r0 = r10
            r1 = r30
            r11 = r2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r2 = r21
            r8 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r0 = r7
            r1 = r8
            goto L_0x01e8
        L_0x00e0:
            r11 = r2
            r3 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r13 = r3
            goto L_0x0296
        L_0x00eb:
            r11 = r2
            r4 = r17
            r3 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.auth.zzei.zzb(r1)
            r7 = r21
            r10.putInt(r14, r7, r1)
            goto L_0x01e5
        L_0x0108:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020c
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r3, r9)
            int r3 = r9.zza
            com.google.android.gms.internal.auth.zzex r5 = r15.zzx(r11)
            if (r5 == 0) goto L_0x013a
            boolean r5 = r5.zza()
            if (r5 == 0) goto L_0x0129
            goto L_0x013a
        L_0x0129:
            com.google.android.gms.internal.auth.zzgz r0 = zzc(r30)
            long r7 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0.zzf(r4, r1)
            r0 = r2
            r1 = r4
            r5 = r6
            goto L_0x01e8
        L_0x013a:
            r10.putInt(r14, r0, r3)
            goto L_0x0156
        L_0x013e:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020c
            int r2 = com.google.android.gms.internal.auth.zzdt.zza(r12, r3, r9)
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
        L_0x0156:
            r5 = r6 | r23
            r0 = r2
            goto L_0x01e7
        L_0x015b:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020c
            com.google.android.gms.internal.auth.zzgh r2 = r15.zzy(r11)
            int r2 = com.google.android.gms.internal.auth.zzdt.zzd(r2, r12, r3, r13, r9)
            r3 = r6 & r23
            if (r3 != 0) goto L_0x017c
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0156
        L_0x017c:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r5 = r9.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzez.zzg(r3, r5)
            r10.putObject(r14, r0, r3)
            goto L_0x0156
        L_0x018a:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020c
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x01a3
            int r2 = com.google.android.gms.internal.auth.zzdt.zzg(r12, r3, r9)
            goto L_0x01a7
        L_0x01a3:
            int r2 = com.google.android.gms.internal.auth.zzdt.zzh(r12, r3, r9)
        L_0x01a7:
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0156
        L_0x01ad:
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r21 = 0
            int r3 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01c9
            r3 = 1
            goto L_0x01ca
        L_0x01c9:
            r3 = 0
        L_0x01ca:
            com.google.android.gms.internal.auth.zzhi.zzk(r14, r1, r3)
            goto L_0x01e5
        L_0x01ce:
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x020c
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r3)
            r10.putInt(r14, r1, r0)
            int r0 = r3 + 4
        L_0x01e5:
            r5 = r6 | r23
        L_0x01e7:
            r1 = r4
        L_0x01e8:
            r3 = r11
            goto L_0x0280
        L_0x01eb:
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x020c
            long r7 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r3)
            r0 = r10
            r5 = r3
            r2 = r1
            r1 = r30
            r17 = r4
            r13 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x0277
        L_0x020c:
            r13 = r3
            r17 = r4
            goto L_0x0296
        L_0x0211:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0296
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            goto L_0x0279
        L_0x0227:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0296
            int r7 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r13, r9)
            long r4 = r9.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r13 = r33
            r0 = r7
            goto L_0x027d
        L_0x0245:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0296
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzhi.zzm(r14, r2, r0)
            int r0 = r13 + 4
            goto L_0x0279
        L_0x025f:
            r11 = r2
            r13 = r20
            r2 = r21
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0296
            long r0 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzhi.zzl(r14, r2, r0)
        L_0x0277:
            int r0 = r13 + 8
        L_0x0279:
            r5 = r6 | r23
            r13 = r33
        L_0x027d:
            r3 = r11
            r1 = r17
        L_0x0280:
            r2 = r19
            r6 = r25
            r11 = r34
            goto L_0x0019
        L_0x0288:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzez.zzg(r1, r2)
            r10.putObject(r14, r7, r1)
            goto L_0x0279
        L_0x0296:
            r7 = r34
            r22 = r6
            r28 = r10
            r21 = r11
            r2 = r13
            goto L_0x0377
        L_0x02a1:
            r17 = r4
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r4 = r2
            r2 = r21
            r0 = 27
            if (r11 != r0) goto L_0x0303
            r0 = 2
            if (r8 != r0) goto L_0x02f8
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02d1
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02c9
            r1 = 10
            goto L_0x02ca
        L_0x02c9:
            int r1 = r1 + r1
        L_0x02ca:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r10.putObject(r14, r2, r0)
        L_0x02d1:
            r7 = r0
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r4)
            r1 = r17
            r2 = r31
            r3 = r13
            r21 = r4
            r4 = r33
            r22 = r5
            r5 = r7
            r25 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r33
            r11 = r34
            r2 = r19
            r3 = r21
            r5 = r22
            r6 = r25
            goto L_0x0019
        L_0x02f8:
            r21 = r4
            r22 = r5
            r25 = r6
            r28 = r10
            r15 = r13
            goto L_0x0374
        L_0x0303:
            r21 = r4
            r22 = r5
            r25 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0352
            long r6 = (long) r7
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r13
            r4 = r33
            r5 = r17
            r26 = r6
            r6 = r19
            r7 = r8
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r21
            r28 = r10
            r9 = r26
            r15 = r34
            r15 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x034e
        L_0x0336:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r17
            r2 = r19
            r3 = r21
            r5 = r22
            r6 = r25
            goto L_0x03c4
        L_0x034e:
            r7 = r34
            r2 = r0
            goto L_0x0377
        L_0x0352:
            r23 = r2
            r28 = r10
            r15 = r13
            r0 = 50
            if (r11 != r0) goto L_0x037c
            r0 = 2
            if (r8 != r0) goto L_0x0374
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r21
            r6 = r23
            r8 = r35
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x034e
            goto L_0x0336
        L_0x0374:
            r7 = r34
            r2 = r15
        L_0x0377:
            r8 = r17
            r6 = r25
            goto L_0x039a
        L_0x037c:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r19
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r23
            r12 = r21
            r13 = r35
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x034e
            goto L_0x0336
        L_0x039a:
            if (r8 != r7) goto L_0x03a3
            if (r7 == 0) goto L_0x03a3
            r0 = r2
            r1 = r8
            r5 = r22
            goto L_0x03cf
        L_0x03a3:
            com.google.android.gms.internal.auth.zzgz r4 = zzc(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r9 = r35
            r11 = r7
            r1 = r8
            r2 = r19
            r3 = r21
            r5 = r22
        L_0x03c4:
            r10 = r28
            goto L_0x0019
        L_0x03c8:
            r22 = r5
            r25 = r6
            r28 = r10
            r7 = r11
        L_0x03cf:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x03dd
            long r3 = (long) r6
            r6 = r30
            r8 = r28
            r8.putInt(r6, r3, r5)
            goto L_0x03df
        L_0x03dd:
            r6 = r30
        L_0x03df:
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r29
            int r4 = r2.zzj
        L_0x03e6:
            int r5 = r2.zzk
            if (r4 >= r5) goto L_0x0412
            int[] r5 = r2.zzi
            r5 = r5[r4]
            int[] r8 = r2.zzc
            r8 = r8[r5]
            int r8 = r2.zzv(r5)
            r8 = r8 & r3
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.auth.zzhi.zzf(r6, r8)
            if (r8 != 0) goto L_0x03ff
            goto L_0x0405
        L_0x03ff:
            com.google.android.gms.internal.auth.zzex r9 = r2.zzx(r5)
            if (r9 != 0) goto L_0x0408
        L_0x0405:
            int r4 = r4 + 1
            goto L_0x03e6
        L_0x0408:
            com.google.android.gms.internal.auth.zzfq r8 = (com.google.android.gms.internal.auth.zzfq) r8
            java.lang.Object r0 = r2.zzz(r5)
            com.google.android.gms.internal.auth.zzfp r0 = (com.google.android.gms.internal.auth.zzfp) r0
            r0 = 0
            throw r0
        L_0x0412:
            if (r7 != 0) goto L_0x041e
            r3 = r33
            if (r0 != r3) goto L_0x0419
            goto L_0x0424
        L_0x0419:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        L_0x041e:
            r3 = r33
            if (r0 > r3) goto L_0x0425
            if (r1 != r7) goto L_0x0425
        L_0x0424:
            return r0
        L_0x0425:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, (Object) null, (Object) null);
    }

    public final void zze(Object obj) {
        int i2;
        int i3 = this.zzj;
        while (true) {
            i2 = this.zzk;
            if (i3 >= i2) {
                break;
            }
            long zzv = (long) (zzv(this.zzi[i3]) & 1048575);
            Object zzf2 = zzhi.zzf(obj, zzv);
            if (zzf2 != null) {
                ((zzfq) zzf2).zzc();
                zzhi.zzp(obj, zzv, zzf2);
            }
            i3++;
        }
        int length = this.zzi.length;
        while (i2 < length) {
            this.zzl.zza(obj, (long) this.zzi[i2]);
            i2++;
        }
        this.zzm.zze(obj);
    }

    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int zzv = zzv(i2);
            long j2 = (long) (1048575 & zzv);
            int i3 = this.zzc[i2];
            switch (zzu(zzv)) {
                case 0:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzl(obj, j2, zzhi.zza(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 1:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzm(obj, j2, zzhi.zzb(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 2:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 3:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 4:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 5:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 6:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 7:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzk(obj, j2, zzhi.zzt(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 8:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i2);
                    break;
                case 10:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 11:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 12:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 13:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 14:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 15:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j2, zzhi.zzc(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 16:
                    if (!zzG(obj2, i2)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j2, zzhi.zzd(obj2, j2));
                        zzD(obj, i2);
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i2);
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
                    this.zzl.zzb(obj, obj2, j2);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j2);
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
                    if (!zzJ(obj2, i3, i2)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzE(obj, i3, i2);
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzJ(obj2, i3, i2)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j2, zzhi.zzf(obj2, j2));
                        zzE(obj, i3, i2);
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i2);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    public final void zzg(Object obj, byte[] bArr, int i2, int i3, zzds zzds) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i2, i3, zzds);
        } else {
            zzb(obj, bArr, i2, i3, 0, zzds);
        }
    }

    public final boolean zzh(Object obj, Object obj2) {
        boolean z2;
        int length = this.zzc.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzv = zzv(i2);
            long j2 = (long) (zzv & 1048575);
            switch (zzu(zzv)) {
                case 0:
                    if (zzF(obj, obj2, i2) && Double.doubleToLongBits(zzhi.zza(obj, j2)) == Double.doubleToLongBits(zzhi.zza(obj2, j2))) {
                        continue;
                    }
                case 1:
                    if (zzF(obj, obj2, i2) && Float.floatToIntBits(zzhi.zzb(obj, j2)) == Float.floatToIntBits(zzhi.zzb(obj2, j2))) {
                        continue;
                    }
                case 2:
                    if (zzF(obj, obj2, i2) && zzhi.zzd(obj, j2) == zzhi.zzd(obj2, j2)) {
                        continue;
                    }
                case 3:
                    if (zzF(obj, obj2, i2) && zzhi.zzd(obj, j2) == zzhi.zzd(obj2, j2)) {
                        continue;
                    }
                case 4:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 5:
                    if (zzF(obj, obj2, i2) && zzhi.zzd(obj, j2) == zzhi.zzd(obj2, j2)) {
                        continue;
                    }
                case 6:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 7:
                    if (zzF(obj, obj2, i2) && zzhi.zzt(obj, j2) == zzhi.zzt(obj2, j2)) {
                        continue;
                    }
                case 8:
                    if (zzF(obj, obj2, i2) && zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2))) {
                        continue;
                    }
                case 9:
                    if (zzF(obj, obj2, i2) && zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2))) {
                        continue;
                    }
                case 10:
                    if (zzF(obj, obj2, i2) && zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2))) {
                        continue;
                    }
                case 11:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 12:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 13:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 14:
                    if (zzF(obj, obj2, i2) && zzhi.zzd(obj, j2) == zzhi.zzd(obj2, j2)) {
                        continue;
                    }
                case 15:
                    if (zzF(obj, obj2, i2) && zzhi.zzc(obj, j2) == zzhi.zzc(obj2, j2)) {
                        continue;
                    }
                case 16:
                    if (zzF(obj, obj2, i2) && zzhi.zzd(obj, j2) == zzhi.zzd(obj2, j2)) {
                        continue;
                    }
                case 17:
                    if (zzF(obj, obj2, i2) && zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2))) {
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
                    z2 = zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2));
                    break;
                case 50:
                    z2 = zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2));
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
                    long zzs = (long) (zzs(i2) & 1048575);
                    if (zzhi.zzc(obj, zzs) == zzhi.zzc(obj2, zzs) && zzgj.zzh(zzhi.zzf(obj, j2), zzhi.zzf(obj2, j2))) {
                        continue;
                    }
            }
            if (!z2) {
                return false;
            }
        }
        if (!this.zzm.zza(obj).equals(this.zzm.zza(obj2))) {
            return false;
        }
        return true;
    }

    public final boolean zzi(Object obj) {
        int i2;
        int i3;
        Object obj2 = obj;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzj) {
            int i7 = this.zzi[i6];
            int i8 = this.zzc[i7];
            int zzv = zzv(i7);
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
            if ((268435456 & zzv) != 0 && !zzH(obj, i7, i3, i2, i11)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu == 60 || zzu == 68) {
                        if (zzJ(obj2, i8, i7) && !zzI(obj2, zzv, zzy(i7))) {
                            return false;
                        }
                    } else if (zzu != 49) {
                        if (zzu == 50 && !((zzfq) zzhi.zzf(obj2, (long) (zzv & 1048575))).isEmpty()) {
                            zzfp zzfp = (zzfp) zzz(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhi.zzf(obj2, (long) (zzv & 1048575));
                if (!list.isEmpty()) {
                    zzgh zzy = zzy(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzy.zzi(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzH(obj, i7, i3, i2, i11) && !zzI(obj2, zzv, zzy(i7))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
        return true;
    }
}
