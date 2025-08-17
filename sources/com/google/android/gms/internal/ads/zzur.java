package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzur implements zztm, zzaaz, zzxu, zzxz, zzvd {
    /* access modifiers changed from: private */
    public static final Map zzb;
    /* access modifiers changed from: private */
    public static final zzam zzc;
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private int zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private boolean zzI;
    private int zzJ;
    private boolean zzK;
    private boolean zzL;
    private final zzxt zzM;
    private final zzxp zzN;
    private final Uri zzd;
    private final zzge zze;
    private final zzqu zzf;
    private final zztx zzg;
    private final zzqo zzh;
    private final zzun zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final zzyc zzk = new zzyc("ProgressiveMediaPeriod");
    private final zzuh zzl;
    private final zzeb zzm;
    private final Runnable zzn;
    /* access modifiers changed from: private */
    public final Runnable zzo;
    /* access modifiers changed from: private */
    public final Handler zzp;
    private zztl zzq;
    /* access modifiers changed from: private */
    public zzadw zzr;
    private zzve[] zzs;
    private zzup[] zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private zzuq zzx;
    private zzabv zzy;
    private long zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(hashMap);
        zzak zzak = new zzak();
        zzak.zzH("icy");
        zzak.zzS("application/x-icy");
        zzc = zzak.zzY();
    }

    public zzur(Uri uri, zzge zzge, zzuh zzuh, zzqu zzqu, zzqo zzqo, zzxt zzxt, zztx zztx, zzun zzun, zzxp zzxp, String str, int i2) {
        this.zzd = uri;
        this.zze = zzge;
        this.zzf = zzqu;
        this.zzh = zzqo;
        this.zzM = zzxt;
        this.zzg = zztx;
        this.zzi = zzun;
        this.zzN = zzxp;
        this.zzj = (long) i2;
        this.zzl = zzuh;
        this.zzm = new zzeb(zzdz.zza);
        this.zzn = new zzui(this);
        this.zzo = new zzuj(this);
        this.zzp = zzfj.zzt((Handler.Callback) null);
        this.zzt = new zzup[0];
        this.zzs = new zzve[0];
        this.zzH = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzB = 1;
    }

    private final int zzP() {
        int i2 = 0;
        for (zzve zzc2 : this.zzs) {
            i2 += zzc2.zzc();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public final long zzQ(boolean z2) {
        int i2 = 0;
        long j2 = Long.MIN_VALUE;
        while (true) {
            zzve[] zzveArr = this.zzs;
            if (i2 >= zzveArr.length) {
                return j2;
            }
            if (!z2) {
                zzuq zzuq = this.zzx;
                zzuq.getClass();
                if (!zzuq.zzc[i2]) {
                    i2++;
                }
            }
            j2 = Math.max(j2, zzveArr[i2].zzg());
            i2++;
        }
    }

    private final zzabz zzR(zzup zzup) {
        int length = this.zzs.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zzup.equals(this.zzt[i2])) {
                return this.zzs[i2];
            }
        }
        zzve zzve = new zzve(this.zzN, this.zzf, this.zzh);
        zzve.zzu(this);
        int i3 = length + 1;
        zzup[] zzupArr = (zzup[]) Arrays.copyOf(this.zzt, i3);
        zzupArr[length] = zzup;
        int i4 = zzfj.zza;
        this.zzt = zzupArr;
        zzve[] zzveArr = (zzve[]) Arrays.copyOf(this.zzs, i3);
        zzveArr[length] = zzve;
        this.zzs = zzveArr;
        return zzve;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzS() {
        zzdy.zzf(this.zzv);
        this.zzx.getClass();
        this.zzy.getClass();
    }

    /* access modifiers changed from: private */
    public final void zzT() {
        boolean z2;
        int i2;
        zzbz zzbz;
        if (!this.zzL && !this.zzv && this.zzu && this.zzy != null) {
            zzve[] zzveArr = this.zzs;
            int length = zzveArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (zzveArr[i3].zzh() != null) {
                    i3++;
                } else {
                    return;
                }
            }
            this.zzm.zzc();
            int length2 = this.zzs.length;
            zzcy[] zzcyArr = new zzcy[length2];
            boolean[] zArr = new boolean[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                zzam zzh2 = this.zzs[i4].zzh();
                zzh2.getClass();
                String str = zzh2.zzm;
                boolean zzf2 = zzcc.zzf(str);
                if (zzf2 || zzcc.zzg(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i4] = z2;
                this.zzw = z2 | this.zzw;
                zzadw zzadw = this.zzr;
                if (zzadw != null) {
                    if (zzf2 || this.zzt[i4].zzb) {
                        zzbz zzbz2 = zzh2.zzk;
                        if (zzbz2 == null) {
                            zzbz = new zzbz(-9223372036854775807L, zzadw);
                        } else {
                            zzbz = zzbz2.zzc(zzadw);
                        }
                        zzak zzb2 = zzh2.zzb();
                        zzb2.zzM(zzbz);
                        zzh2 = zzb2.zzY();
                    }
                    if (zzf2 && zzh2.zzg == -1 && zzh2.zzh == -1 && (i2 = zzadw.zza) != -1) {
                        zzak zzb3 = zzh2.zzb();
                        zzb3.zzv(i2);
                        zzh2 = zzb3.zzY();
                    }
                }
                zzam zzc2 = zzh2.zzc(this.zzf.zza(zzh2));
                zzcyArr[i4] = new zzcy(Integer.toString(i4), zzc2);
            }
            this.zzx = new zzuq(new zzvn(zzcyArr), zArr);
            this.zzv = true;
            zztl zztl = this.zzq;
            zztl.getClass();
            zztl.zzi(this);
        }
    }

    private final void zzU(int i2) {
        zzS();
        zzuq zzuq = this.zzx;
        boolean[] zArr = zzuq.zzd;
        if (!zArr[i2]) {
            zzam zzb2 = zzuq.zza.zzb(i2).zzb(0);
            this.zzg.zzc(new zztk(1, zzcc.zzb(zzb2.zzm), zzb2, 0, (Object) null, zzfj.zzq(this.zzG), -9223372036854775807L));
            zArr[i2] = true;
        }
    }

    private final void zzV(int i2) {
        zzS();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzI && zArr[i2] && !this.zzs[i2].zzx(false)) {
            this.zzH = 0;
            this.zzI = false;
            this.zzD = true;
            this.zzG = 0;
            this.zzJ = 0;
            for (zzve zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
            zztl zztl = this.zzq;
            zztl.getClass();
            zztl.zzg(this);
        }
    }

    private final void zzW() {
        zzum zzum = new zzum(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzv) {
            zzdy.zzf(zzX());
            long j2 = this.zzz;
            if (j2 == -9223372036854775807L || this.zzH <= j2) {
                zzabv zzabv = this.zzy;
                zzabv.getClass();
                zzum.zzf(zzum, zzabv.zzg(this.zzH).zza.zzc, this.zzH);
                for (zzve zzt2 : this.zzs) {
                    zzt2.zzt(this.zzH);
                }
                this.zzH = -9223372036854775807L;
            } else {
                this.zzK = true;
                this.zzH = -9223372036854775807L;
                return;
            }
        }
        this.zzJ = zzP();
        long zza = this.zzk.zza(zzum, this, zzxt.zza(this.zzB));
        zzgj zzd2 = zzum.zzl;
        this.zzg.zzg(new zztf(zzum.zzb, zzd2, zzd2.zza, Collections.emptyMap(), zza, 0, 0), new zztk(1, -1, (zzam) null, 0, (Object) null, zzfj.zzq(zzum.zzk), zzfj.zzq(this.zzz)));
    }

    private final boolean zzX() {
        return this.zzH != -9223372036854775807L;
    }

    private final boolean zzY() {
        return this.zzD || zzX();
    }

    public final void zzC() {
        this.zzu = true;
        this.zzp.post(this.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzD() {
        if (!this.zzL) {
            zztl zztl = this.zzq;
            zztl.getClass();
            zztl.zzg(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE() {
        this.zzF = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF(zzabv zzabv) {
        zzabv zzabv2;
        if (this.zzr == null) {
            zzabv2 = zzabv;
        } else {
            zzabv2 = new zzabu(-9223372036854775807L, 0);
        }
        this.zzy = zzabv2;
        this.zzz = zzabv.zze();
        boolean z2 = false;
        int i2 = 1;
        if (!this.zzF && zzabv.zze() == -9223372036854775807L) {
            z2 = true;
        }
        this.zzA = z2;
        if (true == z2) {
            i2 = 7;
        }
        this.zzB = i2;
        this.zzi.zza(this.zzz, zzabv.zzh(), this.zzA);
        if (!this.zzv) {
            zzT();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzG() throws IOException {
        this.zzk.zzi(zzxt.zza(this.zzB));
    }

    /* access modifiers changed from: package-private */
    public final void zzH(int i2) throws IOException {
        this.zzs[i2].zzm();
        zzG();
    }

    public final /* bridge */ /* synthetic */ void zzI(zzxy zzxy, long j2, long j3, boolean z2) {
        zzum zzum = (zzum) zzxy;
        zzhf zze2 = zzum.zzd;
        zztf zztf = new zztf(zzum.zzb, zzum.zzl, zze2.zzh(), zze2.zzi(), j2, j3, zze2.zzg());
        long unused = zzum.zzb;
        this.zzg.zzd(zztf, new zztk(1, -1, (zzam) null, 0, (Object) null, zzfj.zzq(zzum.zzk), zzfj.zzq(this.zzz)));
        if (!z2) {
            for (zzve zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
            if (this.zzE > 0) {
                zztl zztl = this.zzq;
                zztl.getClass();
                zztl.zzg(this);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzJ(zzxy zzxy, long j2, long j3) {
        zzabv zzabv;
        long j4;
        if (this.zzz == -9223372036854775807L && (zzabv = this.zzy) != null) {
            boolean zzh2 = zzabv.zzh();
            long zzQ = zzQ(true);
            if (zzQ == Long.MIN_VALUE) {
                j4 = 0;
            } else {
                j4 = zzQ + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
            }
            this.zzz = j4;
            this.zzi.zza(j4, zzh2, this.zzA);
        }
        zzum zzum = (zzum) zzxy;
        zzhf zze2 = zzum.zzd;
        zztf zztf = new zztf(zzum.zzb, zzum.zzl, zze2.zzh(), zze2.zzi(), j2, j3, zze2.zzg());
        long unused = zzum.zzb;
        this.zzg.zze(zztf, new zztk(1, -1, (zzam) null, 0, (Object) null, zzfj.zzq(zzum.zzk), zzfj.zzq(this.zzz)));
        this.zzK = true;
        zztl zztl = this.zzq;
        zztl.getClass();
        zztl.zzg(this);
    }

    public final void zzK() {
        for (zzve zzo2 : this.zzs) {
            zzo2.zzo();
        }
        this.zzl.zze();
    }

    public final void zzL(zzam zzam) {
        this.zzp.post(this.zzn);
    }

    public final void zzM() {
        if (this.zzv) {
            for (zzve zzn2 : this.zzs) {
                zzn2.zzn();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages((Object) null);
        this.zzq = null;
        this.zzL = true;
    }

    public final void zzN(zzabv zzabv) {
        this.zzp.post(new zzul(this, zzabv));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(int i2) {
        return !zzY() && this.zzs[i2].zzx(this.zzK);
    }

    public final long zza(long j2, zzlm zzlm) {
        boolean z2;
        long j3 = j2;
        zzlm zzlm2 = zzlm;
        zzS();
        if (!this.zzy.zzh()) {
            return 0;
        }
        zzabt zzg2 = this.zzy.zzg(j3);
        long j4 = zzg2.zza.zzb;
        long j5 = zzg2.zzb.zzb;
        long j6 = zzlm2.zzf;
        if (j6 == 0) {
            if (zzlm2.zzg == 0) {
                return j3;
            }
            j6 = 0;
        }
        int i2 = zzfj.zza;
        long j7 = j3 - j6;
        long j8 = zzlm2.zzg;
        long j9 = j3 + j8;
        long j10 = j3 ^ j9;
        long j11 = j8 ^ j9;
        if (((j6 ^ j3) & (j3 ^ j7)) < 0) {
            j7 = Long.MIN_VALUE;
        }
        if ((j10 & j11) < 0) {
            j9 = Clock.MAX_TIME;
        }
        boolean z3 = true;
        if (j7 > j4 || j4 > j9) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (j7 > j5 || j5 > j9) {
            z3 = false;
        }
        if (z2 && z3) {
            if (Math.abs(j4 - j3) > Math.abs(j5 - j3)) {
                return j5;
            }
        } else if (!z2) {
            if (z3) {
                return j5;
            }
            return j7;
        }
        return j4;
    }

    public final long zzb() {
        long j2;
        zzS();
        if (this.zzK || this.zzE == 0) {
            return Long.MIN_VALUE;
        }
        if (zzX()) {
            return this.zzH;
        }
        if (this.zzw) {
            int length = this.zzs.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                zzuq zzuq = this.zzx;
                if (zzuq.zzb[i2] && zzuq.zzc[i2] && !this.zzs[i2].zzw()) {
                    j2 = Math.min(j2, this.zzs[i2].zzg());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Clock.MAX_TIME) {
            j2 = zzQ(false);
        }
        if (j2 == Long.MIN_VALUE) {
            return this.zzG;
        }
        return j2;
    }

    public final long zzc() {
        return zzb();
    }

    public final long zzd() {
        if (!this.zzD) {
            return -9223372036854775807L;
        }
        if (!this.zzK && zzP() <= this.zzJ) {
            return -9223372036854775807L;
        }
        this.zzD = false;
        return this.zzG;
    }

    public final long zze(long j2) {
        zzS();
        boolean[] zArr = this.zzx.zzb;
        if (true != this.zzy.zzh()) {
            j2 = 0;
        }
        this.zzD = false;
        this.zzG = j2;
        if (zzX()) {
            this.zzH = j2;
            return j2;
        }
        if (this.zzB != 7) {
            int length = this.zzs.length;
            int i2 = 0;
            while (i2 < length) {
                if (this.zzs[i2].zzy(j2, false) || (!zArr[i2] && this.zzw)) {
                    i2++;
                }
            }
            return j2;
        }
        this.zzI = false;
        this.zzH = j2;
        this.zzK = false;
        zzyc zzyc = this.zzk;
        if (zzyc.zzl()) {
            for (zzve zzj2 : this.zzs) {
                zzj2.zzj();
            }
            this.zzk.zzg();
        } else {
            zzyc.zzh();
            for (zzve zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
        }
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r2 == 0) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzxa[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzvf[] r10, boolean[] r11, long r12) {
        /*
            r7 = this;
            r7.zzS()
            com.google.android.gms.internal.ads.zzuq r0 = r7.zzx
            com.google.android.gms.internal.ads.zzvn r1 = r0.zza
            boolean[] r0 = r0.zzc
            int r2 = r7.zzE
            r3 = 0
            r4 = 0
        L_0x000d:
            int r5 = r8.length
            if (r4 >= r5) goto L_0x0035
            r5 = r10[r4]
            if (r5 == 0) goto L_0x0032
            r6 = r8[r4]
            if (r6 == 0) goto L_0x001c
            boolean r6 = r9[r4]
            if (r6 != 0) goto L_0x0032
        L_0x001c:
            com.google.android.gms.internal.ads.zzuo r5 = (com.google.android.gms.internal.ads.zzuo) r5
            int r5 = r5.zzb
            boolean r6 = r0[r5]
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
            int r6 = r7.zzE
            int r6 = r6 + -1
            r7.zzE = r6
            r0[r5] = r3
            r5 = 0
            r10[r4] = r5
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0035:
            boolean r9 = r7.zzC
            r4 = 1
            if (r9 == 0) goto L_0x003d
            if (r2 != 0) goto L_0x0046
            goto L_0x0043
        L_0x003d:
            r5 = 0
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0045
        L_0x0043:
            r9 = 1
            goto L_0x0047
        L_0x0045:
            r12 = r5
        L_0x0046:
            r9 = 0
        L_0x0047:
            r2 = 0
        L_0x0048:
            int r5 = r8.length
            if (r2 >= r5) goto L_0x00a1
            r5 = r10[r2]
            if (r5 != 0) goto L_0x009e
            r5 = r8[r2]
            if (r5 == 0) goto L_0x009e
            int r6 = r5.zzc()
            if (r6 != r4) goto L_0x005b
            r6 = 1
            goto L_0x005c
        L_0x005b:
            r6 = 0
        L_0x005c:
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
            int r6 = r5.zza(r3)
            if (r6 != 0) goto L_0x0067
            r6 = 1
            goto L_0x0068
        L_0x0067:
            r6 = 0
        L_0x0068:
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
            com.google.android.gms.internal.ads.zzcy r5 = r5.zze()
            int r5 = r1.zza(r5)
            boolean r6 = r0[r5]
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzdy.zzf(r6)
            int r6 = r7.zzE
            int r6 = r6 + r4
            r7.zzE = r6
            r0[r5] = r4
            com.google.android.gms.internal.ads.zzuo r6 = new com.google.android.gms.internal.ads.zzuo
            r6.<init>(r7, r5)
            r10[r2] = r6
            r11[r2] = r4
            if (r9 != 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzve[] r9 = r7.zzs
            r9 = r9[r5]
            boolean r5 = r9.zzy(r12, r4)
            if (r5 != 0) goto L_0x009d
            int r9 = r9.zza()
            if (r9 == 0) goto L_0x009d
            r9 = 1
            goto L_0x009e
        L_0x009d:
            r9 = 0
        L_0x009e:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x00a1:
            int r8 = r7.zzE
            if (r8 != 0) goto L_0x00d2
            r7.zzI = r3
            r7.zzD = r3
            com.google.android.gms.internal.ads.zzyc r8 = r7.zzk
            boolean r8 = r8.zzl()
            if (r8 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzve[] r8 = r7.zzs
            int r9 = r8.length
        L_0x00b4:
            if (r3 >= r9) goto L_0x00be
            r10 = r8[r3]
            r10.zzj()
            int r3 = r3 + 1
            goto L_0x00b4
        L_0x00be:
            com.google.android.gms.internal.ads.zzyc r8 = r7.zzk
            r8.zzg()
            goto L_0x00e4
        L_0x00c4:
            com.google.android.gms.internal.ads.zzve[] r8 = r7.zzs
            int r9 = r8.length
            r10 = 0
        L_0x00c8:
            if (r10 >= r9) goto L_0x00e4
            r11 = r8[r10]
            r11.zzp(r3)
            int r10 = r10 + 1
            goto L_0x00c8
        L_0x00d2:
            if (r9 == 0) goto L_0x00e4
            long r12 = r7.zze(r12)
        L_0x00d8:
            int r8 = r10.length
            if (r3 >= r8) goto L_0x00e4
            r8 = r10[r3]
            if (r8 == 0) goto L_0x00e1
            r11[r3] = r4
        L_0x00e1:
            int r3 = r3 + 1
            goto L_0x00d8
        L_0x00e4:
            r7.zzC = r4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzur.zzf(com.google.android.gms.internal.ads.zzxa[], boolean[], com.google.android.gms.internal.ads.zzvf[], boolean[], long):long");
    }

    /* access modifiers changed from: package-private */
    public final int zzg(int i2, zzkj zzkj, zzhp zzhp, int i3) {
        if (zzY()) {
            return -3;
        }
        zzU(i2);
        int zzd2 = this.zzs[i2].zzd(zzkj, zzhp, i3, this.zzK);
        if (zzd2 == -3) {
            zzV(i2);
        }
        return zzd2;
    }

    public final zzvn zzh() {
        zzS();
        return this.zzx.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(int i2, long j2) {
        if (zzY()) {
            return 0;
        }
        zzU(i2);
        zzve zzve = this.zzs[i2];
        int zzb2 = zzve.zzb(j2, this.zzK);
        zzve.zzv(zzb2);
        if (zzb2 != 0) {
            return zzb2;
        }
        zzV(i2);
        return 0;
    }

    public final void zzj(long j2, boolean z2) {
        zzS();
        if (!zzX()) {
            boolean[] zArr = this.zzx.zzc;
            int length = this.zzs.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.zzs[i2].zzi(j2, false, zArr[i2]);
            }
        }
    }

    public final void zzk() throws IOException {
        zzG();
        if (this.zzK && !this.zzv) {
            throw zzcd.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzl(zztl zztl, long j2) {
        this.zzq = zztl;
        this.zzm.zze();
        zzW();
    }

    public final void zzm(long j2) {
    }

    public final boolean zzo(long j2) {
        if (this.zzK || this.zzk.zzk() || this.zzI) {
            return false;
        }
        if (this.zzv && this.zzE == 0) {
            return false;
        }
        boolean zze2 = this.zzm.zze();
        if (this.zzk.zzl()) {
            return zze2;
        }
        zzW();
        return true;
    }

    public final boolean zzp() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzxw zzt(com.google.android.gms.internal.ads.zzxy r22, long r23, long r25, java.io.IOException r27, int r28) {
        /*
            r21 = this;
            r0 = r21
            r1 = r27
            r2 = r22
            com.google.android.gms.internal.ads.zzum r2 = (com.google.android.gms.internal.ads.zzum) r2
            com.google.android.gms.internal.ads.zzhf r3 = r2.zzd
            com.google.android.gms.internal.ads.zztf r14 = new com.google.android.gms.internal.ads.zztf
            long r5 = r2.zzb
            com.google.android.gms.internal.ads.zzgj r7 = r2.zzl
            android.net.Uri r8 = r3.zzh()
            java.util.Map r9 = r3.zzi()
            long r15 = r3.zzg()
            r4 = r14
            r10 = r23
            r12 = r25
            r3 = r14
            r14 = r15
            r4.<init>(r5, r7, r8, r9, r10, r12, r14)
            long unused = r2.zzk
            int r4 = com.google.android.gms.internal.ads.zzfj.zza
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzcd
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof java.io.FileNotFoundException
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzgw
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzyb
            if (r4 != 0) goto L_0x0068
            r4 = r1
        L_0x0047:
            if (r4 == 0) goto L_0x005c
            boolean r7 = r4 instanceof com.google.android.gms.internal.ads.zzgf
            if (r7 == 0) goto L_0x0057
            r7 = r4
            com.google.android.gms.internal.ads.zzgf r7 = (com.google.android.gms.internal.ads.zzgf) r7
            int r7 = r7.zza
            r8 = 2008(0x7d8, float:2.814E-42)
            if (r7 != r8) goto L_0x0057
            goto L_0x0068
        L_0x0057:
            java.lang.Throwable r4 = r4.getCause()
            goto L_0x0047
        L_0x005c:
            int r4 = r28 + -1
            int r4 = r4 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r4 = java.lang.Math.min(r4, r7)
            long r7 = (long) r4
            goto L_0x0069
        L_0x0068:
            r7 = r5
        L_0x0069:
            r4 = 1
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzxw r5 = com.google.android.gms.internal.ads.zzyc.zzd
            goto L_0x00bd
        L_0x0071:
            int r9 = r21.zzP()
            int r10 = r0.zzJ
            r11 = 0
            if (r9 <= r10) goto L_0x007c
            r10 = 1
            goto L_0x007d
        L_0x007c:
            r10 = 0
        L_0x007d:
            boolean r12 = r0.zzF
            if (r12 != 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzabv r12 = r0.zzy
            if (r12 == 0) goto L_0x008e
            long r12 = r12.zze()
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 == 0) goto L_0x008e
            goto L_0x00b7
        L_0x008e:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x009d
            boolean r6 = r21.zzY()
            if (r6 != 0) goto L_0x009d
            r0.zzI = r4
            com.google.android.gms.internal.ads.zzxw r5 = com.google.android.gms.internal.ads.zzyc.zzc
            goto L_0x00bd
        L_0x009d:
            r0.zzD = r5
            r5 = 0
            r0.zzG = r5
            r0.zzJ = r11
            com.google.android.gms.internal.ads.zzve[] r9 = r0.zzs
            int r12 = r9.length
            r13 = 0
        L_0x00a9:
            if (r13 >= r12) goto L_0x00b3
            r14 = r9[r13]
            r14.zzp(r11)
            int r13 = r13 + 1
            goto L_0x00a9
        L_0x00b3:
            com.google.android.gms.internal.ads.zzum.zzf(r2, r5, r5)
            goto L_0x00b9
        L_0x00b7:
            r0.zzJ = r9
        L_0x00b9:
            com.google.android.gms.internal.ads.zzxw r5 = com.google.android.gms.internal.ads.zzyc.zzb(r10, r7)
        L_0x00bd:
            boolean r6 = r5.zzc()
            r4 = r4 ^ r6
            com.google.android.gms.internal.ads.zztx r6 = r0.zzg
            long r7 = r2.zzk
            long r9 = r0.zzz
            long r17 = com.google.android.gms.internal.ads.zzfj.zzq(r7)
            long r19 = com.google.android.gms.internal.ads.zzfj.zzq(r9)
            com.google.android.gms.internal.ads.zztk r7 = new com.google.android.gms.internal.ads.zztk
            r12 = 1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r7
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)
            r6.zzf(r3, r7, r1, r4)
            if (r4 == 0) goto L_0x00e6
            long unused = r2.zzb
        L_0x00e6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzur.zzt(com.google.android.gms.internal.ads.zzxy, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zzxw");
    }

    /* access modifiers changed from: package-private */
    public final zzabz zzu() {
        return zzR(new zzup(0, true));
    }

    public final zzabz zzv(int i2, int i3) {
        return zzR(new zzup(i2, false));
    }
}
