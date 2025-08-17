package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;

public final class zzve implements zzabz {
    private boolean zzA;
    private boolean zzB;
    private zzqv zzC;
    private final zzuy zza;
    private final zzva zzb = new zzva();
    private final zzvl zzc = new zzvl(zzuz.zza);
    private final zzqu zzd;
    private final zzqo zze;
    private zzvd zzf;
    private zzam zzg;
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private int[] zzk = new int[1000];
    private int[] zzl = new int[1000];
    private long[] zzm = new long[1000];
    private zzaby[] zzn = new zzaby[1000];
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzv;
    private boolean zzw = true;
    private boolean zzx = true;
    private zzam zzy;
    private zzam zzz;

    protected zzve(zzxp zzxp, zzqu zzqu, zzqo zzqo) {
        this.zzd = zzqu;
        this.zze = zzqo;
        this.zza = new zzuy(zzxp);
    }

    private final int zzA(int i2) {
        int i3 = this.zzq + i2;
        int i4 = this.zzh;
        return i3 < i4 ? i3 : i3 - i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzB(com.google.android.gms.internal.ads.zzkj r7, com.google.android.gms.internal.ads.zzhp r8, boolean r9, boolean r10, com.google.android.gms.internal.ads.zzva r11) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r8.zzc = r0     // Catch:{ all -> 0x0096 }
            boolean r0 = r6.zzJ()     // Catch:{ all -> 0x0096 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x002b
            if (r10 != 0) goto L_0x0025
            boolean r10 = r6.zzv     // Catch:{ all -> 0x0096 }
            if (r10 == 0) goto L_0x0014
            goto L_0x0025
        L_0x0014:
            com.google.android.gms.internal.ads.zzam r8 = r6.zzz     // Catch:{ all -> 0x0096 }
            if (r8 == 0) goto L_0x0023
            if (r9 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzam r9 = r6.zzg     // Catch:{ all -> 0x0096 }
            if (r8 == r9) goto L_0x0023
        L_0x001e:
            r6.zzG(r8, r7)     // Catch:{ all -> 0x0096 }
            monitor-exit(r6)
            return r1
        L_0x0023:
            monitor-exit(r6)
            return r2
        L_0x0025:
            r7 = 4
            r8.zzc(r7)     // Catch:{ all -> 0x0096 }
            monitor-exit(r6)
            return r3
        L_0x002b:
            com.google.android.gms.internal.ads.zzvl r0 = r6.zzc     // Catch:{ all -> 0x0096 }
            int r4 = r6.zzp     // Catch:{ all -> 0x0096 }
            int r5 = r6.zzr     // Catch:{ all -> 0x0096 }
            int r4 = r4 + r5
            java.lang.Object r0 = r0.zza(r4)     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzvc r0 = (com.google.android.gms.internal.ads.zzvc) r0     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzam r0 = r0.zza     // Catch:{ all -> 0x0096 }
            if (r9 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzam r9 = r6.zzg     // Catch:{ all -> 0x0096 }
            if (r0 == r9) goto L_0x0041
            goto L_0x0091
        L_0x0041:
            int r7 = r6.zzr     // Catch:{ all -> 0x0096 }
            int r7 = r6.zzA(r7)     // Catch:{ all -> 0x0096 }
            boolean r9 = r6.zzK(r7)     // Catch:{ all -> 0x0096 }
            if (r9 != 0) goto L_0x0052
            r7 = 1
            r8.zzc = r7     // Catch:{ all -> 0x0096 }
            monitor-exit(r6)
            return r2
        L_0x0052:
            int[] r9 = r6.zzl     // Catch:{ all -> 0x0096 }
            r9 = r9[r7]     // Catch:{ all -> 0x0096 }
            r8.zzc(r9)     // Catch:{ all -> 0x0096 }
            int r9 = r6.zzr     // Catch:{ all -> 0x0096 }
            int r0 = r6.zzo     // Catch:{ all -> 0x0096 }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x006c
            if (r10 != 0) goto L_0x0067
            boolean r9 = r6.zzv     // Catch:{ all -> 0x0096 }
            if (r9 == 0) goto L_0x006c
        L_0x0067:
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            r8.zza(r9)     // Catch:{ all -> 0x0096 }
        L_0x006c:
            long[] r9 = r6.zzm     // Catch:{ all -> 0x0096 }
            r0 = r9[r7]     // Catch:{ all -> 0x0096 }
            r8.zzd = r0     // Catch:{ all -> 0x0096 }
            long r9 = r6.zzs     // Catch:{ all -> 0x0096 }
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x007d
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r8.zza(r9)     // Catch:{ all -> 0x0096 }
        L_0x007d:
            int[] r8 = r6.zzk     // Catch:{ all -> 0x0096 }
            r8 = r8[r7]     // Catch:{ all -> 0x0096 }
            r11.zza = r8     // Catch:{ all -> 0x0096 }
            long[] r8 = r6.zzj     // Catch:{ all -> 0x0096 }
            r9 = r8[r7]     // Catch:{ all -> 0x0096 }
            r11.zzb = r9     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzaby[] r8 = r6.zzn     // Catch:{ all -> 0x0096 }
            r7 = r8[r7]     // Catch:{ all -> 0x0096 }
            r11.zzc = r7     // Catch:{ all -> 0x0096 }
            monitor-exit(r6)
            return r3
        L_0x0091:
            r6.zzG(r0, r7)     // Catch:{ all -> 0x0096 }
            monitor-exit(r6)
            return r1
        L_0x0096:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzB(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhp, boolean, boolean, com.google.android.gms.internal.ads.zzva):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzC(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r12 = r9.zzo     // Catch:{ all -> 0x002f }
            r0 = -1
            if (r12 == 0) goto L_0x002d
            long[] r2 = r9.zzm     // Catch:{ all -> 0x002f }
            int r4 = r9.zzq     // Catch:{ all -> 0x002f }
            r5 = r2[r4]     // Catch:{ all -> 0x002f }
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r13 == 0) goto L_0x001a
            int r13 = r9.zzr     // Catch:{ all -> 0x002f }
            if (r13 == r12) goto L_0x001a
            int r12 = r13 + 1
        L_0x001a:
            r5 = r12
            r8 = 0
            r3 = r9
            r6 = r10
            int r10 = r3.zzz(r4, r5, r6, r8)     // Catch:{ all -> 0x002f }
            r11 = -1
            if (r10 != r11) goto L_0x0027
            monitor-exit(r9)
            return r0
        L_0x0027:
            long r10 = r9.zzE(r10)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)
            return r10
        L_0x002d:
            monitor-exit(r9)
            return r0
        L_0x002f:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzC(long, boolean, boolean):long");
    }

    private final synchronized long zzD() {
        int i2 = this.zzo;
        if (i2 == 0) {
            return -1;
        }
        return zzE(i2);
    }

    private final long zzE(int i2) {
        long j2 = this.zzt;
        long j3 = Long.MIN_VALUE;
        if (i2 != 0) {
            int zzA2 = zzA(i2 - 1);
            for (int i3 = 0; i3 < i2; i3++) {
                j3 = Math.max(j3, this.zzm[zzA2]);
                if ((this.zzl[zzA2] & 1) != 0) {
                    break;
                }
                zzA2--;
                if (zzA2 == -1) {
                    zzA2 = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j2, j3);
        this.zzo -= i2;
        int i4 = this.zzp + i2;
        this.zzp = i4;
        int i5 = this.zzq + i2;
        this.zzq = i5;
        int i6 = this.zzh;
        if (i5 >= i6) {
            this.zzq = i5 - i6;
        }
        int i7 = this.zzr - i2;
        this.zzr = i7;
        if (i7 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i4);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i8 = this.zzq;
        if (i8 == 0) {
            i8 = this.zzh;
        }
        int i9 = i8 - 1;
        return this.zzj[i9] + ((long) this.zzk[i9]);
    }

    private final synchronized void zzF(long j2, int i2, long j3, int i3, zzaby zzaby) {
        boolean z2;
        boolean z3;
        int i4 = this.zzo;
        if (i4 > 0) {
            int zzA2 = zzA(i4 - 1);
            if (this.zzj[zzA2] + ((long) this.zzk[zzA2]) <= j3) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzdy.zzd(z3);
        }
        if ((536870912 & i2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzv = z2;
        this.zzu = Math.max(this.zzu, j2);
        int zzA3 = zzA(this.zzo);
        this.zzm[zzA3] = j2;
        this.zzj[zzA3] = j3;
        this.zzk[zzA3] = i3;
        this.zzl[zzA3] = i2;
        this.zzn[zzA3] = zzaby;
        this.zzi[zzA3] = 0;
        if (this.zzc.zzf() || !((zzvc) this.zzc.zzb()).zza.equals(this.zzz)) {
            zzqt zzqt = zzqt.zzb;
            zzvl zzvl = this.zzc;
            int i5 = this.zzp + this.zzo;
            zzam zzam = this.zzz;
            zzam.getClass();
            zzvl.zzc(i5, new zzvc(zzam, zzqt, (zzvb) null));
        }
        int i6 = this.zzo + 1;
        this.zzo = i6;
        int i7 = this.zzh;
        if (i6 == i7) {
            int i8 = i7 + 1000;
            long[] jArr = new long[i8];
            long[] jArr2 = new long[i8];
            long[] jArr3 = new long[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            zzaby[] zzabyArr = new zzaby[i8];
            int i9 = this.zzq;
            int i10 = i7 - i9;
            System.arraycopy(this.zzj, i9, jArr2, 0, i10);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i10);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i10);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i10);
            System.arraycopy(this.zzn, this.zzq, zzabyArr, 0, i10);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i10);
            int i11 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i10, i11);
            System.arraycopy(this.zzm, 0, jArr3, i10, i11);
            System.arraycopy(this.zzl, 0, iArr, i10, i11);
            System.arraycopy(this.zzk, 0, iArr2, i10, i11);
            System.arraycopy(this.zzn, 0, zzabyArr, i10, i11);
            System.arraycopy(this.zzi, 0, jArr, i10, i11);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzabyArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i8;
        }
    }

    private final void zzG(zzam zzam, zzkj zzkj) {
        boolean z2;
        zzad zzad;
        zzam zzam2 = this.zzg;
        if (zzam2 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzqv zzqv = null;
        if (z2) {
            zzad = null;
        } else {
            zzad = zzam2.zzp;
        }
        this.zzg = zzam;
        zzad zzad2 = zzam.zzp;
        zzkj.zza = zzam.zzc(this.zzd.zza(zzam));
        zzkj.zzb = this.zzC;
        if (z2 || !zzfj.zzC(zzad, zzad2)) {
            if (zzam.zzp != null) {
                zzqv = new zzqv(new zzqm(new zzqx(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
            }
            this.zzC = zzqv;
            zzkj.zzb = zzqv;
        }
    }

    private final void zzH() {
        if (this.zzC != null) {
            this.zzC = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzI() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzJ() {
        return this.zzr != this.zzo;
    }

    private final boolean zzK(int i2) {
        if (this.zzC != null) {
            return (this.zzl[i2] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzL(zzam zzam) {
        this.zzx = false;
        if (zzfj.zzC(zzam, this.zzz)) {
            return false;
        }
        if (this.zzc.zzf() || !((zzvc) this.zzc.zzb()).zza.equals(zzam)) {
            this.zzz = zzam;
        } else {
            this.zzz = ((zzvc) this.zzc.zzb()).zza;
        }
        zzam zzam2 = this.zzz;
        this.zzA = zzcc.zze(zzam2.zzm, zzam2.zzj);
        this.zzB = false;
        return true;
    }

    static /* synthetic */ void zzl(zzvc zzvc) {
        zzqt zzqt = zzvc.zzb;
        int i2 = zzqs.zza;
    }

    private final int zzz(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = (this.zzm[i2] > j2 ? 1 : (this.zzm[i2] == j2 ? 0 : -1));
            if (i6 > 0) {
                break;
            }
            if (!z2 || (this.zzl[i2] & 1) != 0) {
                i4 = i5;
                if (i6 == 0) {
                    break;
                }
            }
            i2++;
            if (i2 == this.zzh) {
                i2 = 0;
            }
        }
        return i4;
    }

    public final int zza() {
        return this.zzp + this.zzr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r9 != -1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzr     // Catch:{ all -> 0x0038 }
            int r2 = r8.zzA(r0)     // Catch:{ all -> 0x0038 }
            boolean r1 = r8.zzJ()     // Catch:{ all -> 0x0038 }
            r7 = 0
            if (r1 == 0) goto L_0x0036
            long[] r1 = r8.zzm     // Catch:{ all -> 0x0038 }
            r3 = r1[r2]     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0017
            goto L_0x0036
        L_0x0017:
            long r3 = r8.zzu     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0025
            if (r11 != 0) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            int r9 = r8.zzo     // Catch:{ all -> 0x0038 }
            int r9 = r9 - r0
            monitor-exit(r8)
            return r9
        L_0x0025:
            int r11 = r8.zzo     // Catch:{ all -> 0x0038 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzz(r2, r3, r4, r6)     // Catch:{ all -> 0x0038 }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0035
            return r7
        L_0x0035:
            return r9
        L_0x0036:
            monitor-exit(r8)
            return r7
        L_0x0038:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzb(long, boolean):int");
    }

    public final int zzc() {
        return this.zzp + this.zzo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r9 != 0) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzd(com.google.android.gms.internal.ads.zzkj r9, com.google.android.gms.internal.ads.zzhp r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r5 = 1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r5 = 0
        L_0x0009:
            com.google.android.gms.internal.ads.zzva r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzB(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L_0x003e
            boolean r9 = r10.zzg()
            if (r9 != 0) goto L_0x003d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L_0x0034
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzuy r9 = r8.zza
            com.google.android.gms.internal.ads.zzva r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L_0x003d
        L_0x002c:
            com.google.android.gms.internal.ads.zzuy r9 = r8.zza
            com.google.android.gms.internal.ads.zzva r11 = r8.zzb
            r9.zze(r10, r11)
            goto L_0x0037
        L_0x0034:
            if (r9 == 0) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L_0x003d:
            r9 = -4
        L_0x003e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzd(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhp, int, boolean):int");
    }

    public final /* synthetic */ int zze(zzt zzt2, int i2, boolean z2) {
        return zzabx.zza(this, zzt2, i2, z2);
    }

    public final int zzf(zzt zzt2, int i2, boolean z2, int i3) throws IOException {
        return this.zza.zza(zzt2, i2, z2);
    }

    public final synchronized long zzg() {
        return this.zzu;
    }

    public final synchronized zzam zzh() {
        if (this.zzx) {
            return null;
        }
        return this.zzz;
    }

    public final void zzi(long j2, boolean z2, boolean z3) {
        this.zza.zzc(zzC(j2, false, z3));
    }

    public final void zzj() {
        this.zza.zzc(zzD());
    }

    public final void zzk(zzam zzam) {
        this.zzy = zzam;
        boolean zzL = zzL(zzam);
        zzvd zzvd = this.zzf;
        if (zzvd != null && zzL) {
            zzvd.zzL(zzam);
        }
    }

    public final void zzm() throws IOException {
        zzqv zzqv = this.zzC;
        if (zzqv != null) {
            throw zzqv.zza();
        }
    }

    public final void zzn() {
        zzj();
        zzH();
    }

    public final void zzo() {
        zzp(true);
        zzH();
    }

    public final void zzp(boolean z2) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z2) {
            this.zzy = null;
            this.zzz = null;
            this.zzx = true;
        }
    }

    public final /* synthetic */ void zzq(zzfa zzfa, int i2) {
        zzabx.zzb(this, zzfa, i2);
    }

    public final void zzr(zzfa zzfa, int i2, int i3) {
        this.zza.zzh(zzfa, i2);
    }

    public final void zzs(long j2, int i2, int i3, int i4, zzaby zzaby) {
        if (this.zzw) {
            if ((i2 & 1) != 0) {
                this.zzw = false;
            } else {
                return;
            }
        }
        if (this.zzA) {
            if (j2 >= this.zzs) {
                if ((i2 & 1) == 0) {
                    if (!this.zzB) {
                        zzer.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzz)));
                        this.zzB = true;
                    }
                    i2 |= 1;
                }
            } else {
                return;
            }
        }
        zzF(j2, i2, (this.zza.zzb() - ((long) i3)) - ((long) i4), i3, zzaby);
    }

    public final void zzt(long j2) {
        this.zzs = j2;
    }

    public final void zzu(zzvd zzvd) {
        this.zzf = zzvd;
    }

    public final synchronized void zzv(int i2) {
        boolean z2 = false;
        if (i2 >= 0) {
            try {
                if (this.zzr + i2 <= this.zzo) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdy.zzd(z2);
        this.zzr += i2;
    }

    public final synchronized boolean zzw() {
        return this.zzv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzx(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzJ()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzv     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzam r4 = r3.zzz     // Catch:{ all -> 0x003e }
            r0 = 0
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzam r2 = r3.zzg     // Catch:{ all -> 0x003e }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = 0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzvl r4 = r3.zzc     // Catch:{ all -> 0x003e }
            int r0 = r3.zzp     // Catch:{ all -> 0x003e }
            int r2 = r3.zzr     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzvc r4 = (com.google.android.gms.internal.ads.zzvc) r4     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzam r4 = r4.zza     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzam r0 = r3.zzg     // Catch:{ all -> 0x003e }
            if (r4 == r0) goto L_0x0032
            monitor-exit(r3)
            return r1
        L_0x0032:
            int r4 = r3.zzr     // Catch:{ all -> 0x003e }
            int r4 = r3.zzA(r4)     // Catch:{ all -> 0x003e }
            boolean r4 = r3.zzK(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzx(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzy(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.zzI()     // Catch:{ all -> 0x003d }
            int r0 = r8.zzr     // Catch:{ all -> 0x003d }
            int r2 = r8.zzA(r0)     // Catch:{ all -> 0x003d }
            boolean r1 = r8.zzJ()     // Catch:{ all -> 0x003d }
            r7 = 0
            if (r1 == 0) goto L_0x003b
            long[] r1 = r8.zzm     // Catch:{ all -> 0x003d }
            r3 = r1[r2]     // Catch:{ all -> 0x003d }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x003b
            long r3 = r8.zzu     // Catch:{ all -> 0x003d }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0021
            if (r11 == 0) goto L_0x003b
        L_0x0021:
            int r11 = r8.zzo     // Catch:{ all -> 0x003d }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.zzz(r2, r3, r4, r6)     // Catch:{ all -> 0x003d }
            r0 = -1
            if (r11 != r0) goto L_0x0031
            monitor-exit(r8)
            return r7
        L_0x0031:
            r8.zzs = r9     // Catch:{ all -> 0x003d }
            int r9 = r8.zzr     // Catch:{ all -> 0x003d }
            int r9 = r9 + r11
            r8.zzr = r9     // Catch:{ all -> 0x003d }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x003b:
            monitor-exit(r8)
            return r7
        L_0x003d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzy(long, boolean):boolean");
    }
}
