package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

public final class zzfkd {
    public static boolean zza(int i2) {
        int i3 = i2 - 1;
        return i3 == 2 || i3 == 4 || i3 == 5 || i3 == 6;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b8 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0133  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0063=Splitter:B:17:0x0063, B:43:0x00b8=Splitter:B:43:0x00b8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int zzb(android.content.Context r14, com.google.android.gms.internal.ads.zzfjb r15) {
        /*
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            java.io.File r1 = new java.io.File
            java.io.File r2 = new java.io.File
            android.content.pm.ApplicationInfo r3 = r14.getApplicationInfo()
            java.lang.String r3 = r3.dataDir
            r2.<init>(r3)
            java.lang.String r3 = "lib"
            r1.<init>(r2, r3)
            boolean r2 = r1.exists()
            r3 = 5017(0x1399, float:7.03E-42)
            r4 = 7
            r5 = 6
            r6 = 1000(0x3e8, float:1.401E-42)
            r7 = 0
            r8 = 5
            r9 = 3
            r10 = 1
            if (r2 != 0) goto L_0x002d
            java.lang.String r0 = "No lib/"
            r15.zzb(r3, r0)
        L_0x0029:
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L_0x00ca
        L_0x002d:
            com.google.android.gms.internal.ads.zzfug r2 = new com.google.android.gms.internal.ads.zzfug
            java.lang.String r11 = ".*\\.so$"
            r12 = 2
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11, r12)
            r2.<init>(r11)
            java.io.File[] r1 = r1.listFiles(r2)
            if (r1 == 0) goto L_0x00c3
            int r2 = r1.length
            if (r2 != 0) goto L_0x0044
            goto L_0x00c3
        L_0x0044:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00b9 }
            r3 = 0
            r1 = r1[r3]     // Catch:{ IOException -> 0x00b9 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x00b9 }
            r1 = 20
            byte[] r11 = new byte[r1]     // Catch:{ all -> 0x00a1 }
            int r13 = r2.read(r11)     // Catch:{ all -> 0x00a1 }
            if (r13 != r1) goto L_0x0063
            byte[] r1 = new byte[r12]     // Catch:{ all -> 0x00a1 }
            r1[r3] = r3     // Catch:{ all -> 0x00a1 }
            r1[r10] = r3     // Catch:{ all -> 0x00a1 }
            byte r13 = r11[r8]     // Catch:{ all -> 0x00a1 }
            if (r13 != r12) goto L_0x0067
            zzd(r11, r7, r14, r15)     // Catch:{ all -> 0x00a1 }
        L_0x0063:
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00c1
        L_0x0067:
            r12 = 19
            byte r12 = r11[r12]     // Catch:{ all -> 0x00a1 }
            r1[r3] = r12     // Catch:{ all -> 0x00a1 }
            r12 = 18
            byte r12 = r11[r12]     // Catch:{ all -> 0x00a1 }
            r1[r10] = r12     // Catch:{ all -> 0x00a1 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ all -> 0x00a1 }
            short r1 = r1.getShort()     // Catch:{ all -> 0x00a1 }
            if (r1 == r9) goto L_0x009c
            r12 = 40
            if (r1 == r12) goto L_0x0097
            r12 = 62
            if (r1 == r12) goto L_0x0092
            r12 = 183(0xb7, float:2.56E-43)
            if (r1 == r12) goto L_0x008d
            zzd(r11, r7, r14, r15)     // Catch:{ all -> 0x00a1 }
            goto L_0x0063
        L_0x008d:
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            r0 = 6
            goto L_0x00ca
        L_0x0092:
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            r0 = 7
            goto L_0x00ca
        L_0x0097:
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            r0 = 3
            goto L_0x00ca
        L_0x009c:
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            r0 = 5
            goto L_0x00ca
        L_0x00a1:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x00a6 }
            goto L_0x00b8
        L_0x00a6:
            r2 = move-exception
            java.lang.String r11 = "addSuppressed"
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x00b8 }
            r12[r3] = r0     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x00b8 }
            r11[r3] = r2     // Catch:{ Exception -> 0x00b8 }
            r0.invoke(r1, r11)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            throw r1     // Catch:{ IOException -> 0x00b9 }
        L_0x00b9:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            zzd(r7, r0, r14, r15)
        L_0x00c1:
            r0 = 1
            goto L_0x00ca
        L_0x00c3:
            java.lang.String r0 = "No .so"
            r15.zzb(r3, r0)
            goto L_0x0029
        L_0x00ca:
            if (r0 != r6) goto L_0x011a
            java.lang.String r0 = zzc(r14, r15)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00dd
            java.lang.String r0 = "Empty dev arch"
            zzd(r7, r0, r14, r15)
        L_0x00db:
            r0 = 1
            goto L_0x011a
        L_0x00dd:
            java.lang.String r1 = "i686"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0119
            java.lang.String r1 = "x86"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0119
        L_0x00ee:
            java.lang.String r1 = "x86_64"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00f8
            r0 = 7
            goto L_0x011a
        L_0x00f8:
            java.lang.String r1 = "arm64-v8a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0102
            r0 = 6
            goto L_0x011a
        L_0x0102:
            java.lang.String r1 = "armeabi-v7a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0117
            java.lang.String r1 = "armv71"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0113
            goto L_0x0117
        L_0x0113:
            zzd(r7, r0, r14, r15)
            goto L_0x00db
        L_0x0117:
            r0 = 3
            goto L_0x011a
        L_0x0119:
            r0 = 5
        L_0x011a:
            if (r0 == r10) goto L_0x0133
            if (r0 == r9) goto L_0x0130
            if (r0 == r8) goto L_0x012d
            if (r0 == r5) goto L_0x012a
            if (r0 == r4) goto L_0x0127
            java.lang.String r14 = "null"
            goto L_0x0135
        L_0x0127:
            java.lang.String r14 = "X86_64"
            goto L_0x0135
        L_0x012a:
            java.lang.String r14 = "ARM64"
            goto L_0x0135
        L_0x012d:
            java.lang.String r14 = "X86"
            goto L_0x0135
        L_0x0130:
            java.lang.String r14 = "ARM7"
            goto L_0x0135
        L_0x0133:
            java.lang.String r14 = "UNSUPPORTED"
        L_0x0135:
            r1 = 5018(0x139a, float:7.032E-42)
            r15.zzb(r1, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfkd.zzb(android.content.Context, com.google.android.gms.internal.ads.zzfjb):int");
    }

    private static final String zzc(Context context, zzfjb zzfjb) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzfpv.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e2) {
            zzfjb.zzc(2024, 0, e2);
        } catch (IllegalAccessException e3) {
            zzfjb.zzc(2024, 0, e3);
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            return str;
        }
        return Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfjb zzfjb) {
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzfpv.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfjb.zzb(4007, sb.toString());
    }
}
