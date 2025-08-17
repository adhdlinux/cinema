package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzoe {
    public static final zzoe zza = new zzoe(new int[]{2}, 10);
    private static final zzfsc zzb = zzfsc.zzo(2, 5, 6);
    /* access modifiers changed from: private */
    public static final zzfsf zzc;
    private final int[] zzd;
    private final int zze = 10;

    static {
        zzfse zzfse = new zzfse();
        zzfse.zza(5, 6);
        zzfse.zza(17, 6);
        zzfse.zza(7, 6);
        zzfse.zza(30, 10);
        zzfse.zza(18, 6);
        zzfse.zza(6, 8);
        zzfse.zza(8, 8);
        zzfse.zza(14, 8);
        zzc = zzfse.zzc();
    }

    public zzoe(int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, 1);
        this.zzd = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzoe) && Arrays.equals(this.zzd, ((zzoe) obj).zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 10;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzd);
        return "AudioCapabilities[maxChannelCount=10, supportedEncodings=" + arrays + "]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (zzc(30) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009e, code lost:
        if (r7 != 5) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zza(com.google.android.gms.internal.ads.zzam r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.zzm
            r0.getClass()
            java.lang.String r1 = r10.zzj
            int r0 = com.google.android.gms.internal.ads.zzcc.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfsf r1 = zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r1.containsKey(r2)
            r3 = 0
            if (r2 != 0) goto L_0x0019
            return r3
        L_0x0019:
            r2 = 7
            r4 = 6
            r5 = 8
            r6 = 18
            if (r0 != r6) goto L_0x002b
            boolean r0 = r9.zzc(r6)
            if (r0 != 0) goto L_0x0029
            r0 = 6
            goto L_0x0043
        L_0x0029:
            r0 = 18
        L_0x002b:
            if (r0 != r5) goto L_0x0038
            boolean r0 = r9.zzc(r5)
            if (r0 == 0) goto L_0x0036
            r0 = 8
            goto L_0x0038
        L_0x0036:
            r0 = 7
            goto L_0x0043
        L_0x0038:
            r7 = 30
            if (r0 != r7) goto L_0x0043
            boolean r7 = r9.zzc(r7)
            if (r7 != 0) goto L_0x0043
            goto L_0x0036
        L_0x0043:
            boolean r7 = r9.zzc(r0)
            if (r7 != 0) goto L_0x004a
            return r3
        L_0x004a:
            int r7 = r10.zzz
            r8 = -1
            if (r7 == r8) goto L_0x0064
            if (r0 != r6) goto L_0x0052
            goto L_0x0064
        L_0x0052:
            java.lang.String r10 = r10.zzm
            java.lang.String r1 = "audio/vnd.dts.uhd;profile=p2"
            boolean r10 = r10.equals(r1)
            r1 = 10
            if (r10 == 0) goto L_0x0061
            if (r7 <= r1) goto L_0x008c
            return r3
        L_0x0061:
            if (r7 <= r1) goto L_0x008c
            return r3
        L_0x0064:
            int r10 = r10.zzA
            if (r10 != r8) goto L_0x006b
            r10 = 48000(0xbb80, float:6.7262E-41)
        L_0x006b:
            int r6 = com.google.android.gms.internal.ads.zzfj.zza
            r7 = 29
            if (r6 < r7) goto L_0x0076
            int r7 = com.google.android.gms.internal.ads.zzod.zza(r0, r10)
            goto L_0x008c
        L_0x0076:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r10 = r1.getOrDefault(r10, r6)
            java.lang.Integer r10 = (java.lang.Integer) r10
            r10.getClass()
            int r7 = r10.intValue()
        L_0x008c:
            int r10 = com.google.android.gms.internal.ads.zzfj.zza
            r1 = 28
            if (r10 > r1) goto L_0x00a1
            if (r7 != r2) goto L_0x0097
            r4 = 8
            goto L_0x00a2
        L_0x0097:
            r1 = 3
            if (r7 == r1) goto L_0x00a2
            r1 = 4
            if (r7 == r1) goto L_0x00a2
            r1 = 5
            if (r7 != r1) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r4 = r7
        L_0x00a2:
            r1 = 26
            if (r10 > r1) goto L_0x00b4
            java.lang.String r10 = "fugu"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfj.zzb
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x00b4
            r10 = 1
            if (r4 != r10) goto L_0x00b4
            r4 = 2
        L_0x00b4:
            int r10 = com.google.android.gms.internal.ads.zzfj.zzf(r4)
            if (r10 != 0) goto L_0x00bb
            return r3
        L_0x00bb:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r0, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoe.zza(com.google.android.gms.internal.ads.zzam):android.util.Pair");
    }

    public final boolean zzc(int i2) {
        return Arrays.binarySearch(this.zzd, i2) >= 0;
    }
}
