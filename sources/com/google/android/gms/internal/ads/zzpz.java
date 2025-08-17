package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

public final class zzpz implements zzoz {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private float zzI;
    private ByteBuffer zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private byte[] zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    /* access modifiers changed from: private */
    public boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzl zzT;
    private zzpl zzU;
    /* access modifiers changed from: private */
    public long zzV;
    private boolean zzW;
    private boolean zzX;
    private final zzpp zzY;
    private final zzph zzZ;
    private final zzpe zzd;
    private final zzqj zze;
    private final zzfsc zzf;
    private final zzfsc zzg;
    private final zzeb zzh;
    private final zzpd zzi = new zzpd(new zzpu(this, (zzpt) null));
    private final ArrayDeque zzj;
    private zzpx zzk;
    private final zzps zzl;
    private final zzps zzm;
    private final zzpm zzn;
    private zzoc zzo;
    /* access modifiers changed from: private */
    public zzow zzp;
    private zzpo zzq;
    private zzpo zzr;
    private zzdo zzs;
    /* access modifiers changed from: private */
    public AudioTrack zzt;
    private zzoe zzu;
    private zzk zzv;
    private zzpr zzw;
    private zzpr zzx;
    private zzch zzy;
    private boolean zzz;

    /* synthetic */ zzpz(zzpn zzpn, zzpy zzpy) {
        this.zzu = zzpn.zza;
        this.zzY = zzpn.zzd;
        int i2 = zzfj.zza;
        this.zzn = zzpn.zzc;
        zzph zzg2 = zzpn.zze;
        zzg2.getClass();
        this.zzZ = zzg2;
        zzeb zzeb = new zzeb(zzdz.zza);
        this.zzh = zzeb;
        zzeb.zze();
        zzpe zzpe = new zzpe();
        this.zzd = zzpe;
        zzqj zzqj = new zzqj();
        this.zze = zzqj;
        this.zzf = zzfsc.zzo(new zzdv(), zzpe, zzqj);
        this.zzg = zzfsc.zzm(new zzqi());
        this.zzI = 1.0f;
        this.zzv = zzk.zza;
        this.zzS = 0;
        this.zzT = new zzl(0, 0.0f);
        zzch zzch = zzch.zza;
        this.zzx = new zzpr(zzch, 0, 0, (zzpq) null);
        this.zzy = zzch;
        this.zzz = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzps(100);
        this.zzm = new zzps(100);
    }

    static /* synthetic */ void zzD(AudioTrack audioTrack, zzeb zzeb) {
        try {
            audioTrack.flush();
            audioTrack.release();
            zzeb.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            zzeb.zze();
            synchronized (zza) {
                int i3 = zzc - 1;
                zzc = i3;
                if (i3 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final long zzF() {
        zzpo zzpo = this.zzr;
        if (zzpo.zzc == 0) {
            return this.zzA / ((long) zzpo.zzb);
        }
        return this.zzB;
    }

    /* access modifiers changed from: private */
    public final long zzG() {
        zzpo zzpo = this.zzr;
        if (zzpo.zzc == 0) {
            return this.zzC / ((long) zzpo.zzd);
        }
        return this.zzD;
    }

    private final AudioTrack zzH(zzpo zzpo) throws zzov {
        try {
            return zzpo.zzb(false, this.zzv, this.zzS);
        } catch (zzov e2) {
            zzow zzow = this.zzp;
            if (zzow != null) {
                zzow.zza(e2);
            }
            throw e2;
        }
    }

    private final void zzI(long j2) {
        zzch zzch;
        boolean z2;
        if (zzS()) {
            zzpp zzpp = this.zzY;
            zzch = this.zzy;
            zzpp.zzc(zzch);
        } else {
            zzch = zzch.zza;
        }
        zzch zzch2 = zzch;
        this.zzy = zzch2;
        if (zzS()) {
            zzpp zzpp2 = this.zzY;
            z2 = this.zzz;
            zzpp2.zzd(z2);
        } else {
            z2 = false;
        }
        this.zzz = z2;
        this.zzj.add(new zzpr(zzch2, Math.max(0, j2), this.zzr.zza(zzG()), (zzpq) null));
        zzN();
        zzow zzow = this.zzp;
        if (zzow != null) {
            ((zzqe) zzow).zza.zzc.zzs(this.zzz);
        }
    }

    private final void zzJ() {
        if (!this.zzP) {
            this.zzP = true;
            this.zzi.zzc(zzG());
            this.zzt.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r0 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0.hasRemaining() != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r2.zzs.zze(r2.zzJ);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r0 = r2.zzJ;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzK(long r3) throws com.google.android.gms.internal.ads.zzoy {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x003a
        L_0x0008:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x0039
        L_0x0010:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0026
            r2.zzO(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0010
            return
        L_0x0026:
            java.nio.ByteBuffer r0 = r2.zzJ
            if (r0 == 0) goto L_0x0039
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            java.nio.ByteBuffer r1 = r2.zzJ
            r0.zze(r1)
            goto L_0x0008
        L_0x0039:
            return
        L_0x003a:
            java.nio.ByteBuffer r0 = r2.zzJ
            if (r0 != 0) goto L_0x0040
            java.nio.ByteBuffer r0 = com.google.android.gms.internal.ads.zzdr.zza
        L_0x0040:
            r2.zzO(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zzK(long):void");
    }

    private final void zzL(zzch zzch) {
        zzpr zzpr = new zzpr(zzch, -9223372036854775807L, -9223372036854775807L, (zzpq) null);
        if (zzQ()) {
            this.zzw = zzpr;
        } else {
            this.zzx = zzpr;
        }
    }

    private final void zzM() {
        if (zzQ()) {
            if (zzfj.zza >= 21) {
                this.zzt.setVolume(this.zzI);
                return;
            }
            AudioTrack audioTrack = this.zzt;
            float f2 = this.zzI;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private final void zzN() {
        zzdo zzdo = this.zzr.zzi;
        this.zzs = zzdo;
        zzdo.zzc();
    }

    private final void zzO(ByteBuffer byteBuffer, long j2) throws zzoy {
        int i2;
        zzow zzow;
        boolean z2;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzL;
            boolean z3 = true;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzdy.zzd(z2);
            } else {
                this.zzL = byteBuffer;
                if (zzfj.zza < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.zzM;
                    if (bArr == null || bArr.length < remaining) {
                        this.zzM = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.zzM, 0, remaining);
                    byteBuffer.position(position);
                    this.zzN = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            int i3 = zzfj.zza;
            if (i3 < 21) {
                int zza2 = this.zzi.zza(this.zzC);
                if (zza2 > 0) {
                    i2 = this.zzt.write(this.zzM, this.zzN, Math.min(remaining2, zza2));
                    if (i2 > 0) {
                        this.zzN += i2;
                        byteBuffer.position(byteBuffer.position() + i2);
                    }
                } else {
                    i2 = 0;
                }
            } else {
                i2 = this.zzt.write(byteBuffer, remaining2, 1);
            }
            this.zzV = SystemClock.elapsedRealtime();
            if (i2 < 0) {
                if (((i3 < 24 || i2 != -6) && i2 != -32) || this.zzD <= 0) {
                    z3 = false;
                }
                zzoy zzoy = new zzoy(i2, this.zzr.zza, z3);
                zzow zzow2 = this.zzp;
                if (zzow2 != null) {
                    zzow2.zza(zzoy);
                }
                if (!zzoy.zzb) {
                    this.zzm.zzb(zzoy);
                } else {
                    this.zzu = zzoe.zza;
                    throw zzoy;
                }
            } else {
                this.zzm.zza();
                if (zzR(this.zzt)) {
                    if (this.zzD > 0) {
                        this.zzX = false;
                    }
                    if (this.zzQ && (zzow = this.zzp) != null && i2 < remaining2) {
                        zzqf zzqf = ((zzqe) zzow).zza;
                        if (zzqf.zzm != null) {
                            zzqf.zzm.zza();
                        }
                    }
                }
                int i4 = this.zzr.zzc;
                if (i4 == 0) {
                    this.zzC += (long) i2;
                }
                if (i2 == remaining2) {
                    if (i4 != 0) {
                        if (byteBuffer != this.zzJ) {
                            z3 = false;
                        }
                        zzdy.zzf(z3);
                        this.zzD += ((long) this.zzE) * ((long) this.zzK);
                    }
                    this.zzL = null;
                }
            }
        }
    }

    private final boolean zzP() throws zzoy {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                return true;
            }
            zzO(byteBuffer, Long.MIN_VALUE);
            if (this.zzL == null) {
                return true;
            }
            return false;
        }
        this.zzs.zzd();
        zzK(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
            return true;
        }
        return false;
    }

    private final boolean zzQ() {
        return this.zzt != null;
    }

    private static boolean zzR(AudioTrack audioTrack) {
        return zzfj.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzS() {
        zzpo zzpo = this.zzr;
        if (zzpo.zzc != 0) {
            return false;
        }
        int i2 = zzpo.zza.zzB;
        return true;
    }

    public final int zza(zzam zzam) {
        if ("audio/raw".equals(zzam.zzm)) {
            if (!zzfj.zzD(zzam.zzB)) {
                int i2 = zzam.zzB;
                zzer.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i2);
                return 0;
            } else if (zzam.zzB != 2) {
                return 1;
            } else {
                return 2;
            }
        } else if (this.zzu.zza(zzam) != null) {
            return 2;
        } else {
            return 0;
        }
    }

    public final long zzb(boolean z2) {
        long j2;
        if (!zzQ() || this.zzG) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzi.zzb(z2), this.zzr.zza(zzG()));
        while (!this.zzj.isEmpty() && min >= ((zzpr) this.zzj.getFirst()).zzc) {
            this.zzx = (zzpr) this.zzj.remove();
        }
        zzpr zzpr = this.zzx;
        long j3 = min - zzpr.zzc;
        if (zzpr.zza.equals(zzch.zza)) {
            j2 = this.zzx.zzb + j3;
        } else if (this.zzj.isEmpty()) {
            j2 = this.zzY.zza(j3) + this.zzx.zzb;
        } else {
            zzpr zzpr2 = (zzpr) this.zzj.getFirst();
            j2 = zzpr2.zzb - zzfj.zzm(zzpr2.zzc - min, this.zzx.zza.zzc);
        }
        return j2 + this.zzr.zza(this.zzY.zzb());
    }

    public final zzch zzc() {
        return this.zzy;
    }

    public final zzoh zzd(zzam zzam) {
        if (this.zzW) {
            return zzoh.zza;
        }
        return this.zzZ.zza(zzam, this.zzv);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzam r19, int r20, int[] r21) throws com.google.android.gms.internal.ads.zzou {
        /*
            r18 = this;
            r1 = r18
            r3 = r19
            java.lang.String r0 = r3.zzm
            java.lang.String r2 = "audio/raw"
            boolean r0 = r2.equals(r0)
            r2 = 8
            r5 = -1
            if (r0 == 0) goto L_0x0098
            int r0 = r3.zzB
            boolean r0 = com.google.android.gms.internal.ads.zzfj.zzD(r0)
            com.google.android.gms.internal.ads.zzdy.zzd(r0)
            int r0 = r3.zzB
            int r6 = r3.zzz
            int r0 = com.google.android.gms.internal.ads.zzfj.zzk(r0, r6)
            com.google.android.gms.internal.ads.zzfrz r6 = new com.google.android.gms.internal.ads.zzfrz
            r6.<init>()
            com.google.android.gms.internal.ads.zzfsc r7 = r1.zzf
            r6.zzh(r7)
            com.google.android.gms.internal.ads.zzpp r7 = r1.zzY
            com.google.android.gms.internal.ads.zzdr[] r7 = r7.zze()
            r6.zzg(r7)
            com.google.android.gms.internal.ads.zzdo r7 = new com.google.android.gms.internal.ads.zzdo
            com.google.android.gms.internal.ads.zzfsc r6 = r6.zzi()
            r7.<init>(r6)
            com.google.android.gms.internal.ads.zzdo r6 = r1.zzs
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzdo r7 = r1.zzs
        L_0x0048:
            com.google.android.gms.internal.ads.zzqj r6 = r1.zze
            int r8 = r3.zzC
            int r9 = r3.zzD
            r6.zzq(r8, r9)
            int r6 = com.google.android.gms.internal.ads.zzfj.zza
            r8 = 21
            if (r6 >= r8) goto L_0x0068
            int r6 = r3.zzz
            if (r6 != r2) goto L_0x0068
            if (r21 != 0) goto L_0x0068
            r6 = 6
            int[] r8 = new int[r6]
            r9 = 0
        L_0x0061:
            if (r9 >= r6) goto L_0x006a
            r8[r9] = r9
            int r9 = r9 + 1
            goto L_0x0061
        L_0x0068:
            r8 = r21
        L_0x006a:
            com.google.android.gms.internal.ads.zzpe r6 = r1.zzd
            r6.zzo(r8)
            com.google.android.gms.internal.ads.zzdp r6 = new com.google.android.gms.internal.ads.zzdp
            int r8 = r3.zzA
            int r9 = r3.zzz
            int r10 = r3.zzB
            r6.<init>(r8, r9, r10)
            com.google.android.gms.internal.ads.zzdp r6 = r7.zza(r6)     // Catch:{ zzdq -> 0x0090 }
            int r8 = r6.zzd
            int r9 = r6.zzb
            int r6 = r6.zzc
            int r10 = com.google.android.gms.internal.ads.zzfj.zzf(r6)
            int r6 = com.google.android.gms.internal.ads.zzfj.zzk(r8, r6)
            r11 = r7
            r7 = r9
            r9 = 0
            goto L_0x00c3
        L_0x0090:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzou r0 = new com.google.android.gms.internal.ads.zzou
            r0.<init>((java.lang.Throwable) r2, (com.google.android.gms.internal.ads.zzam) r3)
            throw r0
        L_0x0098:
            com.google.android.gms.internal.ads.zzdo r0 = new com.google.android.gms.internal.ads.zzdo
            com.google.android.gms.internal.ads.zzfsc r6 = com.google.android.gms.internal.ads.zzfsc.zzl()
            r0.<init>(r6)
            int r6 = r3.zzA
            com.google.android.gms.internal.ads.zzoh r7 = com.google.android.gms.internal.ads.zzoh.zza
            com.google.android.gms.internal.ads.zzoe r7 = r1.zzu
            android.util.Pair r7 = r7.zza(r3)
            if (r7 == 0) goto L_0x01aa
            java.lang.Object r8 = r7.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r7 = r7.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 2
            r11 = r0
            r10 = r7
            r0 = -1
            r7 = r6
            r6 = -1
        L_0x00c3:
            java.lang.String r12 = ") for: "
            if (r8 == 0) goto L_0x0189
            if (r10 == 0) goto L_0x0168
            int r12 = android.media.AudioTrack.getMinBufferSize(r7, r10, r8)
            r13 = -2
            r14 = 1
            if (r12 == r13) goto L_0x00d3
            r13 = 1
            goto L_0x00d4
        L_0x00d3:
            r13 = 0
        L_0x00d4:
            com.google.android.gms.internal.ads.zzdy.zzf(r13)
            if (r6 == r5) goto L_0x00db
            r13 = r6
            goto L_0x00dc
        L_0x00db:
            r13 = 1
        L_0x00dc:
            int r15 = r3.zzi
            r4 = 250000(0x3d090, float:3.50325E-40)
            if (r9 == 0) goto L_0x0120
            r16 = 1000000(0xf4240, double:4.940656E-318)
            if (r9 == r14) goto L_0x010d
            r14 = 5
            if (r8 != r14) goto L_0x00f0
            r4 = 500000(0x7a120, float:7.00649E-40)
            r8 = 5
            goto L_0x00f1
        L_0x00f0:
            r14 = r8
        L_0x00f1:
            if (r15 == r5) goto L_0x00fa
            java.math.RoundingMode r8 = java.math.RoundingMode.CEILING
            int r2 = com.google.android.gms.internal.ads.zzfui.zza(r15, r2, r8)
            goto L_0x00fe
        L_0x00fa:
            int r2 = com.google.android.gms.internal.ads.zzqb.zzb(r8)
        L_0x00fe:
            r21 = r6
            long r5 = (long) r4
            r4 = r14
            long r14 = (long) r2
            long r5 = r5 * r14
            long r5 = r5 / r16
            int r2 = com.google.android.gms.internal.ads.zzfuk.zza(r5)
            r14 = r4
            goto L_0x0138
        L_0x010d:
            r21 = r6
            int r2 = com.google.android.gms.internal.ads.zzqb.zzb(r8)
            long r4 = (long) r2
            r14 = 50000000(0x2faf080, double:2.47032823E-316)
            long r4 = r4 * r14
            long r4 = r4 / r16
            int r2 = com.google.android.gms.internal.ads.zzfuk.zza(r4)
            goto L_0x0137
        L_0x0120:
            r21 = r6
            int r2 = r12 * 4
            int r4 = com.google.android.gms.internal.ads.zzqb.zza(r4, r7, r13)
            r5 = 750000(0xb71b0, float:1.050974E-39)
            int r5 = com.google.android.gms.internal.ads.zzqb.zza(r5, r7, r13)
            int r2 = java.lang.Math.min(r2, r5)
            int r2 = java.lang.Math.max(r4, r2)
        L_0x0137:
            r14 = r8
        L_0x0138:
            double r4 = (double) r2
            int r2 = (int) r4
            int r2 = java.lang.Math.max(r12, r2)
            int r2 = r2 + r13
            r4 = -1
            int r2 = r2 + r4
            int r2 = r2 / r13
            int r12 = r2 * r13
            r2 = 0
            r1.zzW = r2
            com.google.android.gms.internal.ads.zzpo r15 = new com.google.android.gms.internal.ads.zzpo
            r13 = 0
            r16 = 0
            r2 = r15
            r3 = r19
            r4 = r0
            r5 = r9
            r6 = r21
            r8 = r10
            r9 = r14
            r10 = r12
            r12 = r13
            r13 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = r18.zzQ()
            if (r0 == 0) goto L_0x0165
            r1.zzq = r15
            return
        L_0x0165:
            r1.zzr = r15
            return
        L_0x0168:
            com.google.android.gms.internal.ads.zzou r0 = new com.google.android.gms.internal.ads.zzou
            java.lang.String r2 = java.lang.String.valueOf(r19)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Invalid output channel config (mode="
            r4.append(r5)
            r4.append(r9)
            r4.append(r12)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.<init>((java.lang.String) r2, (com.google.android.gms.internal.ads.zzam) r3)
            throw r0
        L_0x0189:
            com.google.android.gms.internal.ads.zzou r0 = new com.google.android.gms.internal.ads.zzou
            java.lang.String r2 = java.lang.String.valueOf(r19)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Invalid output encoding (mode="
            r4.append(r5)
            r4.append(r9)
            r4.append(r12)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.<init>((java.lang.String) r2, (com.google.android.gms.internal.ads.zzam) r3)
            throw r0
        L_0x01aa:
            com.google.android.gms.internal.ads.zzou r0 = new com.google.android.gms.internal.ads.zzou
            java.lang.String r2 = java.lang.String.valueOf(r19)
            java.lang.String r4 = "Unable to configure passthrough for: "
            java.lang.String r2 = r4.concat(r2)
            r0.<init>((java.lang.String) r2, (com.google.android.gms.internal.ads.zzam) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zze(com.google.android.gms.internal.ads.zzam, int, int[]):void");
    }

    public final void zzf() {
        if (zzQ()) {
            this.zzA = 0;
            this.zzB = 0;
            this.zzC = 0;
            this.zzD = 0;
            this.zzX = false;
            this.zzE = 0;
            this.zzx = new zzpr(this.zzy, 0, 0, (zzpq) null);
            this.zzH = 0;
            this.zzw = null;
            this.zzj.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzP = false;
            this.zzO = false;
            this.zze.zzp();
            zzN();
            if (this.zzi.zzh()) {
                this.zzt.pause();
            }
            if (zzR(this.zzt)) {
                zzpx zzpx = this.zzk;
                zzpx.getClass();
                zzpx.zzb(this.zzt);
            }
            if (zzfj.zza < 21 && !this.zzR) {
                this.zzS = 0;
            }
            zzpo zzpo = this.zzq;
            if (zzpo != null) {
                this.zzr = zzpo;
                this.zzq = null;
            }
            this.zzi.zzd();
            AudioTrack audioTrack = this.zzt;
            zzeb zzeb = this.zzh;
            zzeb.zzc();
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfj.zzA("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new zzpi(audioTrack, zzeb));
            }
            this.zzt = null;
        }
        this.zzm.zza();
        this.zzl.zza();
    }

    public final void zzg() {
        this.zzF = true;
    }

    public final void zzh() {
        this.zzQ = false;
        if (zzQ() && this.zzi.zzk()) {
            this.zzt.pause();
        }
    }

    public final void zzi() {
        this.zzQ = true;
        if (zzQ()) {
            this.zzi.zzf();
            this.zzt.play();
        }
    }

    public final void zzj() throws zzoy {
        if (!this.zzO && zzQ() && zzP()) {
            zzJ();
            this.zzO = true;
        }
    }

    public final void zzk() {
        zzf();
        zzfsc zzfsc = this.zzf;
        int size = zzfsc.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzdr) zzfsc.get(i2)).zzf();
        }
        zzfsc zzfsc2 = this.zzg;
        int size2 = zzfsc2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((zzdr) zzfsc2.get(i3)).zzf();
        }
        zzdo zzdo = this.zzs;
        if (zzdo != null) {
            zzdo.zzf();
        }
        this.zzQ = false;
        this.zzW = false;
    }

    public final void zzl(zzk zzk2) {
        if (!this.zzv.equals(zzk2)) {
            this.zzv = zzk2;
            zzf();
        }
    }

    public final void zzm(int i2) {
        if (this.zzS != i2) {
            this.zzS = i2;
            this.zzR = i2 != 0;
            zzf();
        }
    }

    public final void zzn(zzl zzl2) {
        if (!this.zzT.equals(zzl2)) {
            int i2 = zzl2.zza;
            if (this.zzt != null) {
                int i3 = this.zzT.zza;
            }
            this.zzT = zzl2;
        }
    }

    public final void zzo(zzow zzow) {
        this.zzp = zzow;
    }

    public final void zzp(zzch zzch) {
        this.zzy = new zzch(Math.max(0.1f, Math.min(zzch.zzc, 8.0f)), Math.max(0.1f, Math.min(zzch.zzd, 8.0f)));
        zzL(zzch);
    }

    public final void zzq(zzoc zzoc) {
        this.zzo = zzoc;
    }

    public final void zzr(AudioDeviceInfo audioDeviceInfo) {
        zzpl zzpl;
        if (audioDeviceInfo == null) {
            zzpl = null;
        } else {
            zzpl = new zzpl(audioDeviceInfo);
        }
        this.zzU = zzpl;
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzpj.zza(audioTrack, zzpl);
        }
    }

    public final void zzs(boolean z2) {
        this.zzz = z2;
        zzL(this.zzy);
    }

    public final void zzt(float f2) {
        if (this.zzI != f2) {
            this.zzI = f2;
            zzM();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:41|42|43|44|(3:46|47|48)|186|187|(1:189)|190) */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0210, code lost:
        r0 = 1024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0221, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02bb, code lost:
        r1.zzE = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02bd, code lost:
        if (r0 == 0) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02c0, code lost:
        return r11;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:186:0x0396 */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x039e A[Catch:{ zzov -> 0x0084, zzov -> 0x03a2 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x00c2=Splitter:B:49:0x00c2, B:186:0x0396=Splitter:B:186:0x0396} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzu(java.nio.ByteBuffer r28, long r29, int r31) throws com.google.android.gms.internal.ads.zzov, com.google.android.gms.internal.ads.zzoy {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            r5 = r31
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            java.nio.ByteBuffer r0 = r1.zzJ
            r8 = 0
            if (r0 == 0) goto L_0x0014
            if (r2 != r0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            com.google.android.gms.internal.ads.zzdy.zzd(r0)
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzq
            r9 = 0
            if (r0 == 0) goto L_0x0069
            boolean r0 = r27.zzP()
            if (r0 != 0) goto L_0x0024
            return r8
        L_0x0024:
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzq
            com.google.android.gms.internal.ads.zzpo r10 = r1.zzr
            int r11 = r10.zzc
            int r12 = r0.zzc
            if (r11 != r12) goto L_0x0059
            int r11 = r10.zzg
            int r12 = r0.zzg
            if (r11 != r12) goto L_0x0059
            int r11 = r10.zze
            int r12 = r0.zze
            if (r11 != r12) goto L_0x0059
            int r11 = r10.zzf
            int r12 = r0.zzf
            if (r11 != r12) goto L_0x0059
            int r10 = r10.zzd
            int r11 = r0.zzd
            if (r10 != r11) goto L_0x0059
            r1.zzr = r0
            r1.zzq = r9
            android.media.AudioTrack r0 = r1.zzt
            if (r0 == 0) goto L_0x0066
            boolean r0 = zzR(r0)
            if (r0 == 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr
            boolean r0 = r0.zzk
            goto L_0x0066
        L_0x0059:
            r27.zzJ()
            boolean r0 = r27.zzv()
            if (r0 == 0) goto L_0x0063
            return r8
        L_0x0063:
            r27.zzf()
        L_0x0066:
            r1.zzI(r3)
        L_0x0069:
            boolean r0 = r27.zzQ()
            if (r0 == 0) goto L_0x0071
            goto L_0x0125
        L_0x0071:
            com.google.android.gms.internal.ads.zzeb r0 = r1.zzh     // Catch:{ zzov -> 0x03a2 }
            boolean r0 = r0.zzd()     // Catch:{ zzov -> 0x03a2 }
            if (r0 != 0) goto L_0x007a
            return r8
        L_0x007a:
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr     // Catch:{ zzov -> 0x0084 }
            r0.getClass()
            android.media.AudioTrack r0 = r1.zzH(r0)     // Catch:{ zzov -> 0x0084 }
            goto L_0x00c2
        L_0x0084:
            r0 = move-exception
            r12 = r0
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr     // Catch:{ zzov -> 0x03a2 }
            int r13 = r0.zzh     // Catch:{ zzov -> 0x03a2 }
            r14 = 1000000(0xf4240, float:1.401298E-39)
            if (r13 <= r14) goto L_0x0396
            com.google.android.gms.internal.ads.zzpo r13 = new com.google.android.gms.internal.ads.zzpo     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzam r14 = r0.zza     // Catch:{ zzov -> 0x03a2 }
            int r15 = r0.zzb     // Catch:{ zzov -> 0x03a2 }
            int r9 = r0.zzc     // Catch:{ zzov -> 0x03a2 }
            int r8 = r0.zzd     // Catch:{ zzov -> 0x03a2 }
            int r7 = r0.zze     // Catch:{ zzov -> 0x03a2 }
            int r11 = r0.zzf     // Catch:{ zzov -> 0x03a2 }
            int r10 = r0.zzg     // Catch:{ zzov -> 0x03a2 }
            r23 = 1000000(0xf4240, float:1.401298E-39)
            com.google.android.gms.internal.ads.zzdo r0 = r0.zzi     // Catch:{ zzov -> 0x03a2 }
            r25 = 0
            r26 = 0
            r17 = r15
            r15 = r13
            r16 = r14
            r18 = r9
            r19 = r8
            r20 = r7
            r21 = r11
            r22 = r10
            r24 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ zzov -> 0x03a2 }
            android.media.AudioTrack r0 = r1.zzH(r13)     // Catch:{ zzov -> 0x0382 }
            r1.zzr = r13     // Catch:{ zzov -> 0x0382 }
        L_0x00c2:
            r1.zzt = r0     // Catch:{ zzov -> 0x03a2 }
            boolean r0 = zzR(r0)     // Catch:{ zzov -> 0x03a2 }
            if (r0 == 0) goto L_0x00e0
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpx r6 = r1.zzk     // Catch:{ zzov -> 0x03a2 }
            if (r6 != 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzpx r6 = new com.google.android.gms.internal.ads.zzpx     // Catch:{ zzov -> 0x03a2 }
            r6.<init>(r1)     // Catch:{ zzov -> 0x03a2 }
            r1.zzk = r6     // Catch:{ zzov -> 0x03a2 }
        L_0x00d7:
            com.google.android.gms.internal.ads.zzpx r6 = r1.zzk     // Catch:{ zzov -> 0x03a2 }
            r6.zza(r0)     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr     // Catch:{ zzov -> 0x03a2 }
            boolean r0 = r0.zzk     // Catch:{ zzov -> 0x03a2 }
        L_0x00e0:
            int r0 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ zzov -> 0x03a2 }
            r6 = 31
            if (r0 < r6) goto L_0x00ef
            com.google.android.gms.internal.ads.zzoc r6 = r1.zzo     // Catch:{ zzov -> 0x03a2 }
            if (r6 == 0) goto L_0x00ef
            android.media.AudioTrack r7 = r1.zzt     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpk.zza(r7, r6)     // Catch:{ zzov -> 0x03a2 }
        L_0x00ef:
            android.media.AudioTrack r6 = r1.zzt     // Catch:{ zzov -> 0x03a2 }
            int r6 = r6.getAudioSessionId()     // Catch:{ zzov -> 0x03a2 }
            r1.zzS = r6     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpd r7 = r1.zzi     // Catch:{ zzov -> 0x03a2 }
            android.media.AudioTrack r8 = r1.zzt     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpo r6 = r1.zzr     // Catch:{ zzov -> 0x03a2 }
            int r9 = r6.zzc     // Catch:{ zzov -> 0x03a2 }
            r10 = 2
            if (r9 != r10) goto L_0x0104
            r9 = 1
            goto L_0x0105
        L_0x0104:
            r9 = 0
        L_0x0105:
            int r10 = r6.zzg     // Catch:{ zzov -> 0x03a2 }
            int r11 = r6.zzd     // Catch:{ zzov -> 0x03a2 }
            int r12 = r6.zzh     // Catch:{ zzov -> 0x03a2 }
            r7.zze(r8, r9, r10, r11, r12)     // Catch:{ zzov -> 0x03a2 }
            r27.zzM()     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzl r6 = r1.zzT     // Catch:{ zzov -> 0x03a2 }
            int r6 = r6.zza     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpl r6 = r1.zzU     // Catch:{ zzov -> 0x03a2 }
            if (r6 == 0) goto L_0x0122
            r7 = 23
            if (r0 < r7) goto L_0x0122
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zzov -> 0x03a2 }
            com.google.android.gms.internal.ads.zzpj.zza(r0, r6)     // Catch:{ zzov -> 0x03a2 }
        L_0x0122:
            r6 = 1
            r1.zzG = r6     // Catch:{ zzov -> 0x03a2 }
        L_0x0125:
            com.google.android.gms.internal.ads.zzps r0 = r1.zzl
            r0.zza()
            boolean r0 = r1.zzG
            r6 = 0
            if (r0 == 0) goto L_0x0145
            long r8 = java.lang.Math.max(r6, r3)
            r1.zzH = r8
            r8 = 0
            r1.zzF = r8
            r1.zzG = r8
            r1.zzI(r3)
            boolean r0 = r1.zzQ
            if (r0 == 0) goto L_0x0145
            r27.zzi()
        L_0x0145:
            com.google.android.gms.internal.ads.zzpd r0 = r1.zzi
            long r8 = r27.zzG()
            boolean r0 = r0.zzj(r8)
            if (r0 != 0) goto L_0x0153
            r8 = 0
            return r8
        L_0x0153:
            java.nio.ByteBuffer r0 = r1.zzJ
            if (r0 != 0) goto L_0x0355
            java.nio.ByteOrder r0 = r28.order()
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r8) goto L_0x0161
            r0 = 1
            goto L_0x0162
        L_0x0161:
            r0 = 0
        L_0x0162:
            com.google.android.gms.internal.ads.zzdy.zzd(r0)
            boolean r0 = r28.hasRemaining()
            if (r0 != 0) goto L_0x016d
            r8 = 1
            return r8
        L_0x016d:
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr
            int r8 = r0.zzc
            if (r8 == 0) goto L_0x02c1
            int r8 = r1.zzE
            if (r8 != 0) goto L_0x02c1
            int r0 = r0.zzg
            r8 = -2
            r9 = 16
            r10 = 1024(0x400, float:1.435E-42)
            r11 = -1
            switch(r0) {
                case 5: goto L_0x02b6;
                case 6: goto L_0x02b6;
                case 7: goto L_0x022a;
                case 8: goto L_0x022a;
                case 9: goto L_0x0213;
                case 10: goto L_0x0210;
                case 11: goto L_0x020d;
                case 12: goto L_0x020d;
                case 13: goto L_0x0182;
                case 14: goto L_0x01bd;
                case 15: goto L_0x01ba;
                case 16: goto L_0x0210;
                case 17: goto L_0x019f;
                case 18: goto L_0x02b6;
                case 19: goto L_0x0182;
                case 20: goto L_0x0199;
                default: goto L_0x0182;
            }
        L_0x0182:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected audio encoding: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0199:
            int r0 = com.google.android.gms.internal.ads.zzabr.zza(r28)
            goto L_0x0221
        L_0x019f:
            int r0 = com.google.android.gms.internal.ads.zzaaa.zza
            byte[] r0 = new byte[r9]
            int r8 = r28.position()
            r2.get(r0)
            r2.position(r8)
            com.google.android.gms.internal.ads.zzez r8 = new com.google.android.gms.internal.ads.zzez
            r8.<init>(r0, r9)
            com.google.android.gms.internal.ads.zzzz r0 = com.google.android.gms.internal.ads.zzaaa.zza(r8)
            int r0 = r0.zzc
            goto L_0x0221
        L_0x01ba:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0221
        L_0x01bd:
            int r0 = com.google.android.gms.internal.ads.zzzx.zza
            int r0 = r28.position()
            int r10 = r28.limit()
            int r10 = r10 + -10
            r12 = r0
        L_0x01ca:
            if (r12 > r10) goto L_0x01dd
            int r13 = r12 + 4
            int r13 = com.google.android.gms.internal.ads.zzfj.zzg(r2, r13)
            r13 = r13 & r8
            r14 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r13 != r14) goto L_0x01da
            int r12 = r12 - r0
            goto L_0x01de
        L_0x01da:
            int r12 = r12 + 1
            goto L_0x01ca
        L_0x01dd:
            r12 = -1
        L_0x01de:
            if (r12 != r11) goto L_0x01e2
            r0 = 0
            goto L_0x0221
        L_0x01e2:
            int r0 = r28.position()
            int r0 = r0 + r12
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r8 = r28.position()
            int r8 = r8 + r12
            r10 = 187(0xbb, float:2.62E-43)
            if (r0 != r10) goto L_0x01fb
            r0 = 9
            goto L_0x01fd
        L_0x01fb:
            r0 = 8
        L_0x01fd:
            int r8 = r8 + r0
            byte r0 = r2.get(r8)
            int r0 = r0 >> 4
            r0 = r0 & 7
            r8 = 40
            int r0 = r8 << r0
            int r0 = r0 * 16
            goto L_0x0221
        L_0x020d:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0221
        L_0x0210:
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x0221
        L_0x0213:
            int r0 = r28.position()
            int r0 = com.google.android.gms.internal.ads.zzfj.zzg(r2, r0)
            int r0 = com.google.android.gms.internal.ads.zzabq.zzc(r0)
            if (r0 == r11) goto L_0x0224
        L_0x0221:
            r11 = 1
            goto L_0x02bb
        L_0x0224:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x022a:
            int r0 = com.google.android.gms.internal.ads.zzaat.zza
            r9 = 0
            int r0 = r2.getInt(r9)
            r12 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r0 == r12) goto L_0x02b2
            int r0 = r2.getInt(r9)
            r12 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r0 != r12) goto L_0x0240
            goto L_0x0210
        L_0x0240:
            int r0 = r2.getInt(r9)
            r9 = 622876772(0x25205864, float:1.3907736E-16)
            if (r0 != r9) goto L_0x024c
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0221
        L_0x024c:
            int r0 = r28.position()
            byte r9 = r2.get(r0)
            if (r9 == r8) goto L_0x0299
            if (r9 == r11) goto L_0x0282
            r8 = 31
            if (r9 == r8) goto L_0x0270
            int r8 = r0 + 4
            byte r8 = r2.get(r8)
            r9 = 1
            r8 = r8 & r9
            int r8 = r8 << 6
            int r0 = r0 + 5
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            r9 = 2
            goto L_0x0295
        L_0x0270:
            r9 = 2
            int r8 = r0 + 5
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 6
            byte r0 = r2.get(r0)
            goto L_0x0293
        L_0x0282:
            r9 = 2
            int r8 = r0 + 4
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
        L_0x0293:
            r0 = r0 & 60
        L_0x0295:
            int r0 = r0 >> r9
            r0 = r0 | r8
            r11 = 1
            goto L_0x02ae
        L_0x0299:
            r9 = 2
            int r8 = r0 + 5
            byte r8 = r2.get(r8)
            r11 = 1
            r8 = r8 & r11
            int r8 = r8 << 6
            int r0 = r0 + 4
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            int r0 = r0 >> r9
            r0 = r0 | r8
        L_0x02ae:
            int r0 = r0 + r11
            int r0 = r0 * 32
            goto L_0x02bb
        L_0x02b2:
            r11 = 1
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x02bb
        L_0x02b6:
            r11 = 1
            int r0 = com.google.android.gms.internal.ads.zzzx.zza(r28)
        L_0x02bb:
            r1.zzE = r0
            if (r0 == 0) goto L_0x02c0
            goto L_0x02c1
        L_0x02c0:
            return r11
        L_0x02c1:
            com.google.android.gms.internal.ads.zzpr r0 = r1.zzw
            if (r0 == 0) goto L_0x02d3
            boolean r0 = r27.zzP()
            if (r0 != 0) goto L_0x02cd
            r8 = 0
            return r8
        L_0x02cd:
            r1.zzI(r3)
            r8 = 0
            r1.zzw = r8
        L_0x02d3:
            long r8 = r1.zzH
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr
            long r10 = r27.zzF()
            com.google.android.gms.internal.ads.zzqj r12 = r1.zze
            long r12 = r12.zzo()
            long r10 = r10 - r12
            com.google.android.gms.internal.ads.zzam r0 = r0.zza
            int r0 = r0.zzA
            long r12 = (long) r0
            r14 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r10 * r14
            long r10 = r10 / r12
            long r8 = r8 + r10
            boolean r0 = r1.zzF
            if (r0 != 0) goto L_0x030e
            long r10 = r8 - r3
            long r10 = java.lang.Math.abs(r10)
            r12 = 200000(0x30d40, double:9.8813E-319)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x030e
            com.google.android.gms.internal.ads.zzow r0 = r1.zzp
            if (r0 == 0) goto L_0x030b
            com.google.android.gms.internal.ads.zzox r10 = new com.google.android.gms.internal.ads.zzox
            r10.<init>(r3, r8)
            r0.zza(r10)
        L_0x030b:
            r10 = 1
            r1.zzF = r10
        L_0x030e:
            boolean r0 = r1.zzF
            if (r0 == 0) goto L_0x0335
            boolean r0 = r27.zzP()
            r10 = 0
            if (r0 != 0) goto L_0x031a
            return r10
        L_0x031a:
            long r8 = r3 - r8
            long r11 = r1.zzH
            long r11 = r11 + r8
            r1.zzH = r11
            r1.zzF = r10
            r1.zzI(r3)
            com.google.android.gms.internal.ads.zzow r0 = r1.zzp
            if (r0 == 0) goto L_0x0335
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x0335
            com.google.android.gms.internal.ads.zzqe r0 = (com.google.android.gms.internal.ads.zzqe) r0
            com.google.android.gms.internal.ads.zzqf r0 = r0.zza
            r0.zzae()
        L_0x0335:
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr
            int r0 = r0.zzc
            if (r0 != 0) goto L_0x0346
            long r6 = r1.zzA
            int r0 = r28.remaining()
            long r8 = (long) r0
            long r6 = r6 + r8
            r1.zzA = r6
            goto L_0x0351
        L_0x0346:
            long r6 = r1.zzB
            int r0 = r1.zzE
            long r8 = (long) r0
            long r10 = (long) r5
            long r8 = r8 * r10
            long r6 = r6 + r8
            r1.zzB = r6
        L_0x0351:
            r1.zzJ = r2
            r1.zzK = r5
        L_0x0355:
            r1.zzK(r3)
            java.nio.ByteBuffer r0 = r1.zzJ
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0368
            r2 = 0
            r1.zzJ = r2
            r2 = 0
            r1.zzK = r2
            r3 = 1
            return r3
        L_0x0368:
            r2 = 0
            r3 = 1
            com.google.android.gms.internal.ads.zzpd r0 = r1.zzi
            long r4 = r27.zzG()
            boolean r0 = r0.zzi(r4)
            if (r0 == 0) goto L_0x0381
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r2 = "Resetting stalled audio track"
            com.google.android.gms.internal.ads.zzer.zzf(r0, r2)
            r27.zzf()
            return r3
        L_0x0381:
            return r2
        L_0x0382:
            r0 = move-exception
            java.lang.String r2 = "addSuppressed"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0396 }
            r5 = 0
            r4[r5] = r6     // Catch:{ Exception -> 0x0396 }
            java.lang.reflect.Method r2 = r6.getDeclaredMethod(r2, r4)     // Catch:{ Exception -> 0x0396 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0396 }
            r4[r5] = r0     // Catch:{ Exception -> 0x0396 }
            r2.invoke(r12, r4)     // Catch:{ Exception -> 0x0396 }
        L_0x0396:
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzr     // Catch:{ zzov -> 0x03a2 }
            boolean r0 = r0.zzc()     // Catch:{ zzov -> 0x03a2 }
            if (r0 == 0) goto L_0x03a1
            r2 = 1
            r1.zzW = r2     // Catch:{ zzov -> 0x03a2 }
        L_0x03a1:
            throw r12     // Catch:{ zzov -> 0x03a2 }
        L_0x03a2:
            r0 = move-exception
            boolean r2 = r0.zzb
            if (r2 != 0) goto L_0x03ae
            com.google.android.gms.internal.ads.zzps r2 = r1.zzl
            r2.zzb(r0)
            r2 = 0
            return r2
        L_0x03ae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zzu(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean zzv() {
        return zzQ() && this.zzi.zzg(zzG());
    }

    public final boolean zzw() {
        if (zzQ()) {
            return this.zzO && !zzv();
        }
        return true;
    }

    public final boolean zzx(zzam zzam) {
        return zza(zzam) != 0;
    }
}
