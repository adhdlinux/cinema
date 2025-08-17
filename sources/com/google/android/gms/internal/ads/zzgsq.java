package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzgsq {
    static final long zza = ((long) zzC(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd = Memory.class;
    private static final boolean zze;
    private static final zzgsp zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0136  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzi()
            zzc = r1
            int r2 = com.google.android.gms.internal.ads.zzgnp.zza
            java.lang.Class<libcore.io.Memory> r2 = libcore.io.Memory.class
            zzd = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzy(r2)
            zze = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzy(r4)
            r5 = 0
            if (r1 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzgso r5 = new com.google.android.gms.internal.ads.zzgso
            r5.<init>(r1)
            goto L_0x002f
        L_0x0028:
            if (r4 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzgsn r5 = new com.google.android.gms.internal.ads.zzgsn
            r5.<init>(r1)
        L_0x002f:
            zzf = r5
            java.lang.String r1 = "getLong"
            java.lang.Class<java.lang.reflect.Field> r3 = java.lang.reflect.Field.class
            java.lang.String r4 = "objectFieldOffset"
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
            r10[r9] = r3     // Catch:{ all -> 0x005f }
            r5.getMethod(r4, r10)     // Catch:{ all -> 0x005f }
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch:{ all -> 0x005f }
            r10[r9] = r7     // Catch:{ all -> 0x005f }
            r10[r8] = r2     // Catch:{ all -> 0x005f }
            r5.getMethod(r1, r10)     // Catch:{ all -> 0x005f }
            java.lang.reflect.Field r2 = zzE()     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x005d
            goto L_0x003e
        L_0x005d:
            r2 = 1
            goto L_0x0064
        L_0x005f:
            r2 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgsq.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r2.toString()))
            goto L_0x003e
        L_0x0064:
            zzg = r2
            com.google.android.gms.internal.ads.zzgsp r2 = zzf
            if (r2 != 0) goto L_0x006c
        L_0x006a:
            r0 = 0
            goto L_0x00dd
        L_0x006c:
            sun.misc.Unsafe r2 = r2.zza
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r5[r9] = r3     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r4, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "arrayBaseOffset"
            java.lang.Class[] r4 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r4[r9] = r0     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r3, r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "arrayIndexScale"
            java.lang.Class[] r4 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d8 }
            r4[r9] = r0     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r3, r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "getInt"
            java.lang.Class[] r3 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r3[r9] = r7     // Catch:{ all -> 0x00d8 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x00d8 }
            r3[r8] = r4     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r0, r3)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "putInt"
            r3 = 3
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r5[r9] = r7     // Catch:{ all -> 0x00d8 }
            r5[r8] = r4     // Catch:{ all -> 0x00d8 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00d8 }
            r5[r6] = r10     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r0, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r0[r9] = r7     // Catch:{ all -> 0x00d8 }
            r0[r8] = r4     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r1, r0)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "putLong"
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r1[r9] = r7     // Catch:{ all -> 0x00d8 }
            r1[r8] = r4     // Catch:{ all -> 0x00d8 }
            r1[r6] = r4     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r0, r1)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "getObject"
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00d8 }
            r1[r9] = r7     // Catch:{ all -> 0x00d8 }
            r1[r8] = r4     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r0, r1)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = "putObject"
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r1[r9] = r7     // Catch:{ all -> 0x00d8 }
            r1[r8] = r4     // Catch:{ all -> 0x00d8 }
            r1[r6] = r7     // Catch:{ all -> 0x00d8 }
            r2.getMethod(r0, r1)     // Catch:{ all -> 0x00d8 }
            r0 = 1
            goto L_0x00dd
        L_0x00d8:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgsq.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006a
        L_0x00dd:
            zzh = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzC(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzC(r0)
            zzD(r0)
            java.lang.reflect.Field r0 = zzE()
            r1 = -1
            if (r0 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzgsp r3 = zzf
            if (r3 != 0) goto L_0x0125
            goto L_0x012b
        L_0x0125:
            sun.misc.Unsafe r1 = r3.zza
            long r1 = r1.objectFieldOffset(r0)
        L_0x012b:
            zzi = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r8 = 0
        L_0x0137:
            zzb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsq.<clinit>():void");
    }

    private zzgsq() {
    }

    static boolean zzA() {
        return zzh;
    }

    static boolean zzB() {
        return zzg;
    }

    private static int zzC(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzD(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i2 = zzgnp.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzF = zzF(cls, "effectiveDirectAddress");
        if (zzF != null) {
            return zzF;
        }
        Field zzF2 = zzF(cls, "address");
        if (zzF2 == null || zzF2.getType() != Long.TYPE) {
            return null;
        }
        return zzF2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzG(Object obj, long j2, byte b2) {
        zzgsp zzgsp = zzf;
        long j3 = -4 & j2;
        int i2 = zzgsp.zza.getInt(obj, j3);
        int i3 = ((~((int) j2)) & 3) << 3;
        zzgsp.zza.putInt(obj, j3, ((255 & b2) << i3) | (i2 & (~(JfifUtil.MARKER_FIRST_BYTE << i3))));
    }

    /* access modifiers changed from: private */
    public static void zzH(Object obj, long j2, byte b2) {
        zzgsp zzgsp = zzf;
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        zzgsp.zza.putInt(obj, j3, ((255 & b2) << i2) | (zzgsp.zza.getInt(obj, j3) & (~(JfifUtil.MARKER_FIRST_BYTE << i2))));
    }

    static byte zza(long j2) {
        return zzf.zza(j2);
    }

    static double zzb(Object obj, long j2) {
        return zzf.zzb(obj, j2);
    }

    static float zzc(Object obj, long j2) {
        return zzf.zzc(obj, j2);
    }

    static int zzd(Object obj, long j2) {
        return zzf.zza.getInt(obj, j2);
    }

    static long zze(ByteBuffer byteBuffer) {
        zzgsp zzgsp = zzf;
        return zzgsp.zza.getLong(byteBuffer, zzi);
    }

    static long zzf(Object obj, long j2) {
        return zzf.zza.getLong(obj, j2);
    }

    static Object zzg(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static Object zzh(Object obj, long j2) {
        return zzf.zza.getObject(obj, j2);
    }

    static Unsafe zzi() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgsm());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void zzo(long j2, byte[] bArr, long j3, long j4) {
        zzf.zzd(j2, bArr, j3, j4);
    }

    static void zzp(Object obj, long j2, boolean z2) {
        zzf.zze(obj, j2, z2);
    }

    static void zzq(byte[] bArr, long j2, byte b2) {
        zzf.zzf(bArr, zza + j2, b2);
    }

    static void zzr(Object obj, long j2, double d2) {
        zzf.zzg(obj, j2, d2);
    }

    static void zzs(Object obj, long j2, float f2) {
        zzf.zzh(obj, j2, f2);
    }

    static void zzt(Object obj, long j2, int i2) {
        zzf.zza.putInt(obj, j2, i2);
    }

    static void zzu(Object obj, long j2, long j3) {
        zzf.zza.putLong(obj, j2, j3);
    }

    static void zzv(Object obj, long j2, Object obj2) {
        zzf.zza.putObject(obj, j2, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzw(Object obj, long j2) {
        return ((byte) ((zzf.zza.getInt(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzx(Object obj, long j2) {
        return ((byte) ((zzf.zza.getInt(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & JfifUtil.MARKER_FIRST_BYTE)) != 0;
    }

    static boolean zzy(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i2 = zzgnp.zza;
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

    static boolean zzz(Object obj, long j2) {
        return zzf.zzi(obj, j2);
    }
}
