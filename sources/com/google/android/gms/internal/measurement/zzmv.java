package com.google.android.gms.internal.measurement;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzmv {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd = zzin.zza();
    private static final boolean zze;
    private static final zzmu zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012e  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzg()
            zzc = r1
            java.lang.Class r2 = com.google.android.gms.internal.measurement.zzin.zza()
            zzd = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzv(r2)
            zze = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzv(r4)
            r5 = 0
            if (r1 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.measurement.zzmt r5 = new com.google.android.gms.internal.measurement.zzmt
            r5.<init>(r1)
            goto L_0x002f
        L_0x0028:
            if (r4 == 0) goto L_0x002f
            com.google.android.gms.internal.measurement.zzms r5 = new com.google.android.gms.internal.measurement.zzms
            r5.<init>(r1)
        L_0x002f:
            zzf = r5
            java.lang.String r1 = "getLong"
            java.lang.String r3 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r4 = java.lang.reflect.Field.class
            r6 = 2
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r8 = 1
            r9 = 0
            if (r5 != 0) goto L_0x0040
        L_0x003e:
            r2 = 0
            goto L_0x0064
        L_0x0040:
            sun.misc.Unsafe r5 = r5.zza
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x005f }
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch:{ all -> 0x005f }
            r10[r9] = r4     // Catch:{ all -> 0x005f }
            r5.getMethod(r3, r10)     // Catch:{ all -> 0x005f }
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch:{ all -> 0x005f }
            r10[r9] = r7     // Catch:{ all -> 0x005f }
            r10[r8] = r2     // Catch:{ all -> 0x005f }
            r5.getMethod(r1, r10)     // Catch:{ all -> 0x005f }
            java.lang.reflect.Field r2 = zzB()     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x005d
            goto L_0x003e
        L_0x005d:
            r2 = 1
            goto L_0x0064
        L_0x005f:
            r2 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzmv.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r2.toString()))
            goto L_0x003e
        L_0x0064:
            zzg = r2
            com.google.android.gms.internal.measurement.zzmu r2 = zzf
            if (r2 != 0) goto L_0x006c
        L_0x006a:
            r0 = 0
            goto L_0x00dd
        L_0x006c:
            sun.misc.Unsafe r2 = r2.zza
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r5[r9] = r4     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r3, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r3[r9] = r0     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "arrayBaseOffset"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r3[r9] = r0     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "arrayIndexScale"
            r2.getMethod(r0, r3)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r0[r9] = r7     // Catch:{ all -> 0x00d8 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x00d8 }
            r0[r8] = r3     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "getInt"
            r2.getMethod(r4, r0)     // Catch:{ all -> 0x00d8 }
            r0 = 3
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r4[r9] = r7     // Catch:{ all -> 0x00d8 }
            r4[r8] = r3     // Catch:{ all -> 0x00d8 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00d8 }
            r4[r6] = r5     // Catch:{ all -> 0x00d8 }
            java.lang.String r5 = "putInt"
            r2.getMethod(r5, r4)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r4 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r4[r9] = r7     // Catch:{ all -> 0x00d8 }
            r4[r8] = r3     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r1, r4)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r1[r9] = r7     // Catch:{ all -> 0x00d8 }
            r1[r8] = r3     // Catch:{ all -> 0x00d8 }
            r1[r6] = r3     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "putLong"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r1[r9] = r7     // Catch:{ all -> 0x00d8 }
            r1[r8] = r3     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "getObject"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r0[r9] = r7     // Catch:{ all -> 0x00d8 }
            r0[r8] = r3     // Catch:{ all -> 0x00d8 }
            r0[r6] = r7     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "putObject"
            r2.getMethod(r1, r0)     // Catch:{ all -> 0x00d8 }
            r0 = 1
            goto L_0x00dd
        L_0x00d8:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzmv.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006a
        L_0x00dd:
            zzh = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzz(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0125
            com.google.android.gms.internal.measurement.zzmu r1 = zzf
            if (r1 == 0) goto L_0x0125
            r1.zzl(r0)
        L_0x0125:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r8 = 0
        L_0x012f:
            zzb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmv.<clinit>():void");
    }

    private zzmv() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i2 = zzin.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzC = zzC(cls, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(cls, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        zzmu zzmu = zzf;
        int zzj = zzmu.zzj(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        zzmu.zzn(obj, j3, ((255 & b2) << i2) | (zzj & (~(JfifUtil.MARKER_FIRST_BYTE << i2))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        zzmu zzmu = zzf;
        int i2 = (((int) j2) & 3) << 3;
        zzmu.zzn(obj, j3, ((255 & b2) << i2) | (zzmu.zzj(obj, j3) & (~(JfifUtil.MARKER_FIRST_BYTE << i2))));
    }

    static double zza(Object obj, long j2) {
        return zzf.zza(obj, j2);
    }

    static float zzb(Object obj, long j2) {
        return zzf.zzb(obj, j2);
    }

    static int zzc(Object obj, long j2) {
        return zzf.zzj(obj, j2);
    }

    static long zzd(Object obj, long j2) {
        return zzf.zzk(obj, j2);
    }

    static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static Object zzf(Object obj, long j2) {
        return zzf.zzm(obj, j2);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmr());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void zzm(Object obj, long j2, boolean z2) {
        zzf.zzc(obj, j2, z2);
    }

    static void zzn(byte[] bArr, long j2, byte b2) {
        zzf.zzd(bArr, zza + j2, b2);
    }

    static void zzo(Object obj, long j2, double d2) {
        zzf.zze(obj, j2, d2);
    }

    static void zzp(Object obj, long j2, float f2) {
        zzf.zzf(obj, j2, f2);
    }

    static void zzq(Object obj, long j2, int i2) {
        zzf.zzn(obj, j2, i2);
    }

    static void zzr(Object obj, long j2, long j3) {
        zzf.zzo(obj, j2, j3);
    }

    static void zzs(Object obj, long j2, Object obj2) {
        zzf.zzp(obj, j2, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j2) {
        return ((byte) ((zzf.zzj(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j2) {
        return ((byte) ((zzf.zzj(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE)) != 0;
    }

    static boolean zzv(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i2 = zzin.zza;
        try {
            Class cls3 = zzd;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j2) {
        return zzf.zzg(obj, j2);
    }

    static boolean zzx() {
        return zzh;
    }

    static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }
}
