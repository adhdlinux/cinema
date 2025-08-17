package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class zzwy extends zzxd implements zzlj {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final zzftl zzc = zzftl.zzb(zzwe.zza);
    /* access modifiers changed from: private */
    public static final zzftl zzd = zzftl.zzb(zzwf.zza);
    public final Context zza;
    private final Object zze = new Object();
    private final boolean zzf;
    private zzwm zzg;
    private zzwr zzh;
    private zzk zzi;
    private final zzvt zzj;

    public zzwy(Context context) {
        Context context2;
        zzvt zzvt = new zzvt();
        zzwm zzd2 = zzwm.zzd(context);
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.zza = context2;
        this.zzj = zzvt;
        this.zzg = zzd2;
        this.zzi = zzk.zza;
        boolean z2 = false;
        if (context != null && zzfj.zzE(context)) {
            z2 = true;
        }
        this.zzf = z2;
        if (!z2 && context != null && zzfj.zza >= 32) {
            this.zzh = zzwr.zza(context);
        }
        if (this.zzg.zzQ && context == null) {
            zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    protected static int zza(zzam zzam, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(zzam.zzd)) {
            return 4;
        }
        String zzg2 = zzg(str);
        String zzg3 = zzg(zzam.zzd);
        if (zzg3 == null || zzg2 == null) {
            if (!z2 || zzg3 != null) {
                return 0;
            }
            return 1;
        } else if (zzg3.startsWith(zzg2) || zzg2.startsWith(zzg3)) {
            return 3;
        } else {
            int i2 = zzfj.zza;
            if (zzg3.split("-", 2)[0].equals(zzg2.split("-", 2)[0])) {
                return 2;
            }
            return 0;
        }
    }

    protected static String zzg(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzl(com.google.android.gms.internal.ads.zzwy r8, com.google.android.gms.internal.ads.zzam r9) {
        /*
            java.lang.Object r0 = r8.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzwm r1 = r8.zzg     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzQ     // Catch:{ all -> 0x008f }
            r2 = 1
            if (r1 == 0) goto L_0x008d
            boolean r1 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x008d
            int r1 = r9.zzz     // Catch:{ all -> 0x008f }
            r3 = 2
            if (r1 <= r3) goto L_0x008d
            java.lang.String r1 = r9.zzm     // Catch:{ all -> 0x008f }
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L_0x001b
            goto L_0x0065
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008f }
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0042;
                case 187078296: goto L_0x0038;
                case 187078297: goto L_0x002e;
                case 1504578661: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x004c
        L_0x0024:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x002e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 3
            goto L_0x004d
        L_0x0038:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 0
            goto L_0x004d
        L_0x0042:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 2
            goto L_0x004d
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 == 0) goto L_0x0056
            if (r1 == r2) goto L_0x0056
            if (r1 == r3) goto L_0x0056
            if (r1 == r7) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008d
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008d
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x0065
            goto L_0x008d
        L_0x0065:
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            boolean r3 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x008c
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzk r8 = r8.zzi     // Catch:{ all -> 0x008f }
            boolean r8 = r1.zzd(r8, r9)     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwy.zzl(com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzam):boolean");
    }

    protected static boolean zzn(int i2, boolean z2) {
        int i3 = i2 & 7;
        if (i3 != 4) {
            return z2 && i3 == 3;
        }
        return true;
    }

    private static void zzt(zzvn zzvn, zzdd zzdd, Map map) {
        int i2 = 0;
        while (i2 < zzvn.zzc) {
            if (((zzda) zzdd.zzC.get(zzvn.zzb(i2))) == null) {
                i2++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        boolean z2;
        zzwr zzwr;
        synchronized (this.zze) {
            z2 = false;
            if (this.zzg.zzQ && !this.zzf && zzfj.zza >= 32 && (zzwr = this.zzh) != null && zzwr.zzg()) {
                z2 = true;
            }
        }
        if (z2) {
            zzs();
        }
    }

    private static final Pair zzv(int i2, zzxc zzxc, int[][][] iArr, zzwt zzwt, Comparator comparator) {
        Object obj;
        zzxc zzxc2 = zzxc;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            if (i2 == zzxc2.zzc(i3)) {
                zzvn zzd2 = zzxc2.zzd(i3);
                for (int i4 = 0; i4 < zzd2.zzc; i4++) {
                    zzcy zzb2 = zzd2.zzb(i4);
                    List zza2 = zzwt.zza(i3, zzb2, iArr[i3][i4]);
                    int i5 = zzb2.zzb;
                    int i6 = 1;
                    boolean[] zArr = new boolean[1];
                    int i7 = 0;
                    while (i7 <= 0) {
                        zzwu zzwu = (zzwu) zza2.get(i7);
                        int zzb3 = zzwu.zzb();
                        if (!zArr[i7] && zzb3 != 0) {
                            if (zzb3 == i6) {
                                obj = zzfsc.zzm(zzwu);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzwu);
                                for (int i8 = i7 + 1; i8 <= 0; i8++) {
                                    zzwu zzwu2 = (zzwu) zza2.get(i8);
                                    if (zzwu2.zzb() == 2 && zzwu.zzc(zzwu2)) {
                                        arrayList2.add(zzwu2);
                                        zArr[i8] = true;
                                    }
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i7++;
                        i6 = 1;
                    }
                }
            }
            zzwt zzwt2 = zzwt;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((zzwu) list.get(i9)).zzc;
        }
        zzwu zzwu3 = (zzwu) list.get(0);
        return Pair.create(new zzwz(zzwu3.zzb, iArr2, 0), Integer.valueOf(zzwu3.zza));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.android.gms.internal.ads.zzxa[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: com.google.android.gms.internal.ads.zzvu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v47, resolved type: com.google.android.gms.internal.ads.zzxb} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: com.google.android.gms.internal.ads.zzxb} */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzxc r24, int[][][] r25, int[] r26, com.google.android.gms.internal.ads.zzto r27, com.google.android.gms.internal.ads.zzcw r28) throws com.google.android.gms.internal.ads.zzih {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            java.lang.Object r3 = r1.zze
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzwm r4 = r1.zzg     // Catch:{ all -> 0x021f }
            boolean r5 = r4.zzQ     // Catch:{ all -> 0x021f }
            if (r5 == 0) goto L_0x0023
            int r5 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x021f }
            r6 = 32
            if (r5 < r6) goto L_0x0023
            com.google.android.gms.internal.ads.zzwr r5 = r1.zzh     // Catch:{ all -> 0x021f }
            if (r5 == 0) goto L_0x0023
            android.os.Looper r6 = android.os.Looper.myLooper()     // Catch:{ all -> 0x021f }
            com.google.android.gms.internal.ads.zzdy.zzb(r6)     // Catch:{ all -> 0x021f }
            r5.zzb(r1, r6)     // Catch:{ all -> 0x021f }
        L_0x0023:
            monitor-exit(r3)     // Catch:{ all -> 0x021f }
            r3 = 2
            com.google.android.gms.internal.ads.zzwz[] r5 = new com.google.android.gms.internal.ads.zzwz[r3]
            com.google.android.gms.internal.ads.zzwa r6 = new com.google.android.gms.internal.ads.zzwa
            r7 = r26
            r6.<init>(r4, r7)
            com.google.android.gms.internal.ads.zzwb r7 = com.google.android.gms.internal.ads.zzwb.zza
            android.util.Pair r6 = zzv(r3, r0, r2, r6, r7)
            if (r6 == 0) goto L_0x0044
            java.lang.Object r7 = r6.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.first
            com.google.android.gms.internal.ads.zzwz r6 = (com.google.android.gms.internal.ads.zzwz) r6
            r5[r7] = r6
        L_0x0044:
            r6 = 0
            r7 = 0
        L_0x0046:
            r8 = 1
            if (r7 >= r3) goto L_0x005c
            int r9 = r0.zzc(r7)
            if (r9 != r3) goto L_0x0059
            com.google.android.gms.internal.ads.zzvn r9 = r0.zzd(r7)
            int r9 = r9.zzc
            if (r9 <= 0) goto L_0x0059
            r7 = 1
            goto L_0x005d
        L_0x0059:
            int r7 = r7 + 1
            goto L_0x0046
        L_0x005c:
            r7 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzvy r9 = new com.google.android.gms.internal.ads.zzvy
            r9.<init>(r1, r4, r7)
            com.google.android.gms.internal.ads.zzvz r7 = com.google.android.gms.internal.ads.zzvz.zza
            android.util.Pair r7 = zzv(r8, r0, r2, r9, r7)
            if (r7 == 0) goto L_0x0078
            java.lang.Object r9 = r7.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r10 = r7.first
            com.google.android.gms.internal.ads.zzwz r10 = (com.google.android.gms.internal.ads.zzwz) r10
            r5[r9] = r10
        L_0x0078:
            if (r7 != 0) goto L_0x007c
            r7 = 0
            goto L_0x008f
        L_0x007c:
            java.lang.Object r7 = r7.first
            r10 = r7
            com.google.android.gms.internal.ads.zzwz r10 = (com.google.android.gms.internal.ads.zzwz) r10
            com.google.android.gms.internal.ads.zzcy r10 = r10.zza
            com.google.android.gms.internal.ads.zzwz r7 = (com.google.android.gms.internal.ads.zzwz) r7
            int[] r7 = r7.zzb
            r7 = r7[r6]
            com.google.android.gms.internal.ads.zzam r7 = r10.zzb(r7)
            java.lang.String r7 = r7.zzd
        L_0x008f:
            com.google.android.gms.internal.ads.zzwc r10 = new com.google.android.gms.internal.ads.zzwc
            r10.<init>(r4, r7)
            com.google.android.gms.internal.ads.zzwd r7 = com.google.android.gms.internal.ads.zzwd.zza
            r11 = 3
            android.util.Pair r7 = zzv(r11, r0, r2, r10, r7)
            if (r7 == 0) goto L_0x00ab
            java.lang.Object r10 = r7.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzwz r7 = (com.google.android.gms.internal.ads.zzwz) r7
            r5[r10] = r7
        L_0x00ab:
            r7 = 0
        L_0x00ac:
            if (r7 >= r3) goto L_0x011e
            int r10 = r0.zzc(r7)
            if (r10 == r3) goto L_0x0115
            if (r10 == r8) goto L_0x0115
            if (r10 == r11) goto L_0x0115
            com.google.android.gms.internal.ads.zzvn r10 = r0.zzd(r7)
            r12 = r2[r7]
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x00c3:
            int r11 = r10.zzc
            if (r13 >= r11) goto L_0x0104
            com.google.android.gms.internal.ads.zzcy r11 = r10.zzb(r13)
            r17 = r12[r13]
            r9 = r16
            r3 = 0
        L_0x00d0:
            int r6 = r11.zzb
            if (r3 > 0) goto L_0x00fa
            r6 = r17[r3]
            boolean r8 = r4.zzR
            boolean r6 = zzn(r6, r8)
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzam r6 = r11.zzb(r3)
            com.google.android.gms.internal.ads.zzwh r8 = new com.google.android.gms.internal.ads.zzwh
            r2 = r17[r3]
            r8.<init>(r6, r2)
            if (r9 == 0) goto L_0x00f1
            int r2 = r8.compareTo(r9)
            if (r2 <= 0) goto L_0x00f4
        L_0x00f1:
            r15 = r3
            r9 = r8
            r14 = r11
        L_0x00f4:
            int r3 = r3 + 1
            r2 = r25
            r8 = 1
            goto L_0x00d0
        L_0x00fa:
            int r13 = r13 + 1
            r2 = r25
            r16 = r9
            r3 = 2
            r6 = 0
            r8 = 1
            goto L_0x00c3
        L_0x0104:
            if (r14 != 0) goto L_0x0108
            r2 = 0
            goto L_0x0113
        L_0x0108:
            com.google.android.gms.internal.ads.zzwz r2 = new com.google.android.gms.internal.ads.zzwz
            r3 = 1
            int[] r6 = new int[r3]
            r3 = 0
            r6[r3] = r15
            r2.<init>(r14, r6, r3)
        L_0x0113:
            r5[r7] = r2
        L_0x0115:
            int r7 = r7 + 1
            r2 = r25
            r3 = 2
            r6 = 0
            r8 = 1
            r11 = 3
            goto L_0x00ac
        L_0x011e:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            r6 = 2
        L_0x0125:
            if (r3 >= r6) goto L_0x0131
            com.google.android.gms.internal.ads.zzvn r7 = r0.zzd(r3)
            zzt(r7, r4, r2)
            int r3 = r3 + 1
            goto L_0x0125
        L_0x0131:
            com.google.android.gms.internal.ads.zzvn r3 = r24.zze()
            zzt(r3, r4, r2)
            r3 = 0
        L_0x0139:
            if (r3 >= r6) goto L_0x0150
            int r7 = r0.zzc(r3)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r7 = r2.get(r7)
            com.google.android.gms.internal.ads.zzda r7 = (com.google.android.gms.internal.ads.zzda) r7
            if (r7 != 0) goto L_0x014e
            int r3 = r3 + 1
            goto L_0x0139
        L_0x014e:
            r3 = 0
            throw r3
        L_0x0150:
            r3 = 0
            r2 = 0
        L_0x0152:
            if (r2 >= r6) goto L_0x016c
            com.google.android.gms.internal.ads.zzvn r6 = r0.zzd(r2)
            boolean r7 = r4.zzg(r2, r6)
            if (r7 != 0) goto L_0x015f
            goto L_0x0167
        L_0x015f:
            com.google.android.gms.internal.ads.zzwo r6 = r4.zze(r2, r6)
            if (r6 != 0) goto L_0x016b
            r5[r2] = r3
        L_0x0167:
            int r2 = r2 + 1
            r6 = 2
            goto L_0x0152
        L_0x016b:
            throw r3
        L_0x016c:
            r2 = 2
            r3 = 0
        L_0x016e:
            if (r3 >= r2) goto L_0x0190
            int r2 = r0.zzc(r3)
            boolean r6 = r4.zzf(r3)
            if (r6 != 0) goto L_0x0189
            com.google.android.gms.internal.ads.zzfsh r6 = r4.zzD
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x0187
            goto L_0x0189
        L_0x0187:
            r2 = 0
            goto L_0x018c
        L_0x0189:
            r2 = 0
            r5[r3] = r2
        L_0x018c:
            int r3 = r3 + 1
            r2 = 2
            goto L_0x016e
        L_0x0190:
            r2 = 0
            com.google.android.gms.internal.ads.zzvt r3 = r1.zzj
            com.google.android.gms.internal.ads.zzxo r12 = r23.zzq()
            com.google.android.gms.internal.ads.zzfsc r13 = com.google.android.gms.internal.ads.zzvu.zzf(r5)
            r6 = 2
            com.google.android.gms.internal.ads.zzxa[] r14 = new com.google.android.gms.internal.ads.zzxa[r6]
            r15 = 0
        L_0x019f:
            if (r15 >= r6) goto L_0x01e8
            r6 = r5[r15]
            if (r6 == 0) goto L_0x01e0
            int[] r8 = r6.zzb
            int r7 = r8.length
            if (r7 != 0) goto L_0x01ab
            goto L_0x01e0
        L_0x01ab:
            r11 = 1
            if (r7 != r11) goto L_0x01c6
            com.google.android.gms.internal.ads.zzxb r7 = new com.google.android.gms.internal.ads.zzxb
            com.google.android.gms.internal.ads.zzcy r6 = r6.zza
            r16 = 0
            r19 = r8[r16]
            r20 = 0
            r21 = 0
            r22 = 0
            r17 = r7
            r18 = r6
            r17.<init>(r18, r19, r20, r21, r22)
            r18 = 1
            goto L_0x01dd
        L_0x01c6:
            r16 = 0
            com.google.android.gms.internal.ads.zzcy r7 = r6.zza
            r9 = 0
            java.lang.Object r6 = r13.get(r15)
            r17 = r6
            com.google.android.gms.internal.ads.zzfsc r17 = (com.google.android.gms.internal.ads.zzfsc) r17
            r6 = r3
            r10 = r12
            r18 = 1
            r11 = r17
            com.google.android.gms.internal.ads.zzvu r7 = r6.zza(r7, r8, r9, r10, r11)
        L_0x01dd:
            r14[r15] = r7
            goto L_0x01e4
        L_0x01e0:
            r16 = 0
            r18 = 1
        L_0x01e4:
            int r15 = r15 + 1
            r6 = 2
            goto L_0x019f
        L_0x01e8:
            r16 = 0
            com.google.android.gms.internal.ads.zzll[] r3 = new com.google.android.gms.internal.ads.zzll[r6]
            r5 = 0
        L_0x01ed:
            if (r5 >= r6) goto L_0x021a
            int r7 = r0.zzc(r5)
            boolean r8 = r4.zzf(r5)
            if (r8 != 0) goto L_0x0214
            com.google.android.gms.internal.ads.zzfsh r8 = r4.zzD
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0206
            goto L_0x0214
        L_0x0206:
            int r7 = r0.zzc(r5)
            r8 = -2
            if (r7 == r8) goto L_0x0211
            r7 = r14[r5]
            if (r7 == 0) goto L_0x0214
        L_0x0211:
            com.google.android.gms.internal.ads.zzll r7 = com.google.android.gms.internal.ads.zzll.zza
            goto L_0x0215
        L_0x0214:
            r7 = r2
        L_0x0215:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x01ed
        L_0x021a:
            android.util.Pair r0 = android.util.Pair.create(r3, r14)
            return r0
        L_0x021f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x021f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwy.zzb(com.google.android.gms.internal.ads.zzxc, int[][][], int[], com.google.android.gms.internal.ads.zzto, com.google.android.gms.internal.ads.zzcw):android.util.Pair");
    }

    public final zzlj zzc() {
        return this;
    }

    public final zzwm zzd() {
        zzwm zzwm;
        synchronized (this.zze) {
            zzwm = this.zzg;
        }
        return zzwm;
    }

    public final void zzi() {
        zzwr zzwr;
        synchronized (this.zze) {
            if (zzfj.zza >= 32 && (zzwr = this.zzh) != null) {
                zzwr.zzc();
            }
        }
        super.zzi();
    }

    public final void zzj(zzk zzk) {
        boolean z2;
        synchronized (this.zze) {
            z2 = !this.zzi.equals(zzk);
            this.zzi = zzk;
        }
        if (z2) {
            zzu();
        }
    }

    public final void zzk(zzwk zzwk) {
        boolean z2;
        zzwm zzwm = new zzwm(zzwk);
        synchronized (this.zze) {
            z2 = !this.zzg.equals(zzwm);
            this.zzg = zzwm;
        }
        if (z2) {
            if (zzwm.zzQ && this.zza == null) {
                zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    public final boolean zzm() {
        return true;
    }
}
