package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.startapp.y1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzafp implements zzaaw {
    public static final zzabd zza = zzafl.zza;
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfot.zzc);
    private static final byte[] zzd = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] zze = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final UUID zzf = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map zzg;
    private long zzA;
    private zzafo zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    private zzes zzJ;
    private zzes zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzaaz zzai;
    private final zzafk zzh;
    private final zzafr zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzfa zzl;
    private final zzfa zzm;
    private final zzfa zzn;
    private final zzfa zzo;
    private final zzfa zzp;
    private final zzfa zzq;
    private final zzfa zzr;
    private final zzfa zzs;
    private final zzfa zzt;
    private final zzfa zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i2 = zzfj.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", Integer.valueOf(RotationOptions.ROTATE_180));
        hashMap.put("htc_video_rotA-270", Integer.valueOf(RotationOptions.ROTATE_270));
        zzg = Collections.unmodifiableMap(hashMap);
    }

    public zzafp() {
        this(0);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzn(zzaax zzaax, zzafo zzafo, int i2, boolean z2) throws IOException {
        int i3;
        if ("S_TEXT/UTF8".equals(zzafo.zzb)) {
            zzv(zzaax, zzb, i2);
            int i4 = this.zzaa;
            zzu();
            return i4;
        } else if ("S_TEXT/ASS".equals(zzafo.zzb)) {
            zzv(zzaax, zzd, i2);
            int i5 = this.zzaa;
            zzu();
            return i5;
        } else if ("S_TEXT/WEBVTT".equals(zzafo.zzb)) {
            zzv(zzaax, zze, i2);
            int i6 = this.zzaa;
            zzu();
            return i6;
        } else {
            zzabz zzabz = zzafo.zzV;
            boolean z3 = true;
            if (!this.zzac) {
                if (zzafo.zzg) {
                    this.zzV &= -1073741825;
                    int i7 = 128;
                    if (!this.zzad) {
                        ((zzaam) zzaax).zzn(this.zzn.zzH(), 0, 1, false);
                        this.zzZ++;
                        if ((this.zzn.zzH()[0] & y1.f36938c) != 128) {
                            this.zzag = this.zzn.zzH()[0];
                            this.zzad = true;
                        } else {
                            throw zzcd.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b2 = this.zzag;
                    if ((b2 & 1) == 1) {
                        byte b3 = b2 & 2;
                        this.zzV |= 1073741824;
                        if (!this.zzah) {
                            ((zzaam) zzaax).zzn(this.zzs.zzH(), 0, 8, false);
                            this.zzZ += 8;
                            this.zzah = true;
                            byte[] zzH2 = this.zzn.zzH();
                            if (b3 != 2) {
                                i7 = 0;
                            }
                            zzH2[0] = (byte) (i7 | 8);
                            this.zzn.zzF(0);
                            zzabz.zzr(this.zzn, 1, 1);
                            this.zzaa++;
                            this.zzs.zzF(0);
                            zzabz.zzr(this.zzs, 8, 1);
                            this.zzaa += 8;
                        }
                        if (b3 == 2) {
                            if (!this.zzae) {
                                ((zzaam) zzaax).zzn(this.zzn.zzH(), 0, 1, false);
                                this.zzZ++;
                                this.zzn.zzF(0);
                                this.zzaf = this.zzn.zzk();
                                this.zzae = true;
                            }
                            int i8 = this.zzaf * 4;
                            this.zzn.zzC(i8);
                            ((zzaam) zzaax).zzn(this.zzn.zzH(), 0, i8, false);
                            this.zzZ += i8;
                            int i9 = (this.zzaf >> 1) + 1;
                            int i10 = (i9 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzv;
                            if (byteBuffer == null || byteBuffer.capacity() < i10) {
                                this.zzv = ByteBuffer.allocate(i10);
                            }
                            this.zzv.position(0);
                            this.zzv.putShort((short) i9);
                            int i11 = 0;
                            int i12 = 0;
                            while (true) {
                                i3 = this.zzaf;
                                if (i11 >= i3) {
                                    break;
                                }
                                int zzn2 = this.zzn.zzn();
                                if (i11 % 2 == 0) {
                                    this.zzv.putShort((short) (zzn2 - i12));
                                } else {
                                    this.zzv.putInt(zzn2 - i12);
                                }
                                i11++;
                                i12 = zzn2;
                            }
                            int i13 = (i2 - this.zzZ) - i12;
                            if ((i3 & 1) == 1) {
                                this.zzv.putInt(i13);
                            } else {
                                this.zzv.putShort((short) i13);
                                this.zzv.putInt(0);
                            }
                            this.zzt.zzD(this.zzv.array(), i10);
                            zzabz.zzr(this.zzt, i10, 1);
                            this.zzaa += i10;
                        }
                    }
                } else {
                    byte[] bArr = zzafo.zzh;
                    if (bArr != null) {
                        this.zzq.zzD(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzafo.zzb) ? zzafo.zzf > 0 : z2) {
                    this.zzV |= 268435456;
                    this.zzu.zzC(0);
                    int zzd2 = (this.zzq.zzd() + i2) - this.zzZ;
                    this.zzn.zzC(4);
                    this.zzn.zzH()[0] = (byte) ((zzd2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                    this.zzn.zzH()[1] = (byte) ((zzd2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    this.zzn.zzH()[2] = (byte) ((zzd2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    this.zzn.zzH()[3] = (byte) (zzd2 & JfifUtil.MARKER_FIRST_BYTE);
                    zzabz.zzr(this.zzn, 4, 2);
                    this.zzaa += 4;
                }
                this.zzac = true;
            }
            int zzd3 = i2 + this.zzq.zzd();
            if (!"V_MPEG4/ISO/AVC".equals(zzafo.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzafo.zzb)) {
                if (zzafo.zzS != null) {
                    if (this.zzq.zzd() != 0) {
                        z3 = false;
                    }
                    zzdy.zzf(z3);
                    zzafo.zzS.zzd(zzaax);
                }
                while (true) {
                    int i14 = this.zzZ;
                    if (i14 >= zzd3) {
                        break;
                    }
                    int zzo2 = zzo(zzaax, zzabz, zzd3 - i14);
                    this.zzZ += zzo2;
                    this.zzaa += zzo2;
                }
            } else {
                byte[] zzH3 = this.zzm.zzH();
                zzH3[0] = 0;
                zzH3[1] = 0;
                zzH3[2] = 0;
                int i15 = zzafo.zzW;
                int i16 = 4 - i15;
                while (this.zzZ < zzd3) {
                    int i17 = this.zzab;
                    if (i17 == 0) {
                        int min = Math.min(i15, this.zzq.zza());
                        ((zzaam) zzaax).zzn(zzH3, i16 + min, i15 - min, false);
                        if (min > 0) {
                            this.zzq.zzB(zzH3, i16, min);
                        }
                        this.zzZ += i15;
                        this.zzm.zzF(0);
                        this.zzab = this.zzm.zzn();
                        this.zzl.zzF(0);
                        zzabx.zzb(zzabz, this.zzl, 4);
                        this.zzaa += 4;
                    } else {
                        int zzo3 = zzo(zzaax, zzabz, i17);
                        this.zzZ += zzo3;
                        this.zzaa += zzo3;
                        this.zzab -= zzo3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzafo.zzb)) {
                this.zzo.zzF(0);
                zzabx.zzb(zzabz, this.zzo, 4);
                this.zzaa += 4;
            }
            int i18 = this.zzaa;
            zzu();
            return i18;
        }
    }

    private final int zzo(zzaax zzaax, zzabz zzabz, int i2) throws IOException {
        int zza2 = this.zzq.zza();
        if (zza2 <= 0) {
            return zzabx.zza(zzabz, zzaax, i2, false);
        }
        int min = Math.min(i2, zza2);
        zzabx.zzb(zzabz, this.zzq, min);
        return min;
    }

    private final long zzp(long j2) throws zzcd {
        long j3 = this.zzy;
        if (j3 != -9223372036854775807L) {
            return zzfj.zzp(j2, j3, 1000);
        }
        throw zzcd.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int i2) throws zzcd {
        if (this.zzJ == null || this.zzK == null) {
            throw zzcd.zza("Element " + i2 + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzr(int i2) throws zzcd {
        if (this.zzB == null) {
            throw zzcd.zza("Element " + i2 + " must be in a TrackEntry", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0 A[EDGE_INSN: B:59:0x00e0->B:48:0x00e0 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzs(com.google.android.gms.internal.ads.zzafo r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zzaca r2 = r1.zzS
            r9 = 1
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzabz r3 = r1.zzV
            com.google.android.gms.internal.ads.zzaby r8 = r1.zzi
            r1 = r2
            r2 = r3
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            r1.zzc(r2, r3, r5, r6, r7, r8)
            goto L_0x0121
        L_0x001c:
            java.lang.String r2 = r1.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            java.lang.String r4 = "S_TEXT/WEBVTT"
            java.lang.String r5 = "S_TEXT/ASS"
            r6 = 0
            r7 = 2
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0058
        L_0x003c:
            int r2 = r0.zzR
            java.lang.String r8 = "MatroskaExtractor"
            if (r2 <= r9) goto L_0x0048
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            com.google.android.gms.internal.ads.zzer.zzf(r8, r2)
            goto L_0x0058
        L_0x0048:
            long r10 = r0.zzP
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "Skipping subtitle sample with no duration."
            com.google.android.gms.internal.ads.zzer.zzf(r8, r2)
        L_0x0058:
            r2 = r22
            goto L_0x00f3
        L_0x005c:
            java.lang.String r2 = r1.zzb
            com.google.android.gms.internal.ads.zzfa r8 = r0.zzr
            byte[] r8 = r8.zzH()
            int r12 = r2.hashCode()
            r13 = 738597099(0x2c0618eb, float:1.9056378E-12)
            if (r12 == r13) goto L_0x0088
            r5 = 1045209816(0x3e4ca2d8, float:0.19983995)
            if (r12 == r5) goto L_0x0080
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r12 == r4) goto L_0x0078
            goto L_0x0090
        L_0x0078:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0090
            r2 = 0
            goto L_0x0091
        L_0x0080:
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = 2
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0090
            r2 = 1
            goto L_0x0091
        L_0x0090:
            r2 = -1
        L_0x0091:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00b3
            if (r2 == r9) goto L_0x00a8
            if (r2 != r7) goto L_0x00a2
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = zzw(r10, r2, r3)
            r3 = 25
            goto L_0x00bb
        L_0x00a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x00a8:
            java.lang.String r2 = "%01d:%02d:%02d:%02d"
            r3 = 10000(0x2710, double:4.9407E-320)
            byte[] r2 = zzw(r10, r2, r3)
            r3 = 21
            goto L_0x00bb
        L_0x00b3:
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = zzw(r10, r2, r3)
            r3 = 19
        L_0x00bb:
            int r4 = r2.length
            java.lang.System.arraycopy(r2, r6, r8, r3, r4)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzr
            int r2 = r2.zzc()
        L_0x00c5:
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzr
            int r3 = r3.zzd()
            if (r2 >= r3) goto L_0x00e0
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzr
            byte[] r3 = r3.zzH()
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzr
            r3.zzE(r2)
            goto L_0x00e0
        L_0x00dd:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00e0:
            com.google.android.gms.internal.ads.zzabz r2 = r1.zzV
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzr
            int r4 = r3.zzd()
            com.google.android.gms.internal.ads.zzabx.zzb(r2, r3, r4)
            com.google.android.gms.internal.ads.zzfa r2 = r0.zzr
            int r2 = r2.zzd()
            int r2 = r22 + r2
        L_0x00f3:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x0111
            int r3 = r0.zzR
            if (r3 <= r9) goto L_0x0103
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzu
            r3.zzC(r6)
            goto L_0x0111
        L_0x0103:
            com.google.android.gms.internal.ads.zzfa r3 = r0.zzu
            int r3 = r3.zzd()
            com.google.android.gms.internal.ads.zzabz r4 = r1.zzV
            com.google.android.gms.internal.ads.zzfa r5 = r0.zzu
            r4.zzr(r5, r3, r7)
            int r2 = r2 + r3
        L_0x0111:
            r14 = r2
            com.google.android.gms.internal.ads.zzabz r10 = r1.zzV
            com.google.android.gms.internal.ads.zzaby r1 = r1.zzi
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.zzs(r11, r13, r14, r15, r16)
        L_0x0121:
            r0.zzM = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzs(com.google.android.gms.internal.ads.zzafo, long, int, int, int):void");
    }

    private final void zzt(zzaax zzaax, int i2) throws IOException {
        if (this.zzn.zzd() < i2) {
            if (this.zzn.zzb() < i2) {
                zzfa zzfa = this.zzn;
                int zzb2 = zzfa.zzb();
                zzfa.zzz(Math.max(zzb2 + zzb2, i2));
            }
            ((zzaam) zzaax).zzn(this.zzn.zzH(), this.zzn.zzd(), i2 - this.zzn.zzd(), false);
            this.zzn.zzE(i2);
        }
    }

    private final void zzu() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = 0;
        this.zzah = false;
        this.zzq.zzC(0);
    }

    private final void zzv(zzaax zzaax, byte[] bArr, int i2) throws IOException {
        int length = bArr.length;
        int i3 = length + i2;
        if (this.zzr.zzb() < i3) {
            zzfa zzfa = this.zzr;
            byte[] copyOf = Arrays.copyOf(bArr, i3 + i2);
            zzfa.zzD(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzH(), 0, length);
        }
        ((zzaam) zzaax).zzn(this.zzr.zzH(), length, i2, false);
        this.zzr.zzF(0);
        this.zzr.zzE(i3);
    }

    private static byte[] zzw(long j2, String str, long j3) {
        boolean z2;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - (((long) i2) * 3600000000L);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - (((long) i3) * 60000000);
        int i4 = (int) (j5 / 1000000);
        String format = String.format(Locale.US, str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (((long) i4) * 1000000)) / j3))});
        int i5 = zzfj.zza;
        return format.getBytes(zzfot.zzc);
    }

    private static int[] zzx(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        int length = iArr.length;
        if (length >= i2) {
            return iArr;
        }
        return new int[Math.max(length + length, i2)];
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (this.zzh.zzc(zzaax)) {
                long zzf2 = zzaax.zzf();
                if (this.zzF) {
                    this.zzH = zzf2;
                    zzabs.zza = this.zzG;
                    this.zzF = false;
                    return 1;
                } else if (this.zzC) {
                    long j2 = this.zzH;
                    if (j2 != -1) {
                        zzabs.zza = j2;
                        this.zzH = -1;
                        return 1;
                    }
                }
            } else {
                for (int i2 = 0; i2 < this.zzj.size(); i2++) {
                    zzafo zzafo = (zzafo) this.zzj.valueAt(i2);
                    zzafo.zzV.getClass();
                    zzaca zzaca = zzafo.zzS;
                    if (zzaca != null) {
                        zzaca.zza(zzafo.zzV, zzafo.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final void zzb(zzaaz zzaaz) {
        this.zzai = zzaaz;
    }

    public final void zzc(long j2, long j3) {
        this.zzI = -9223372036854775807L;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzu();
        for (int i2 = 0; i2 < this.zzj.size(); i2++) {
            zzaca zzaca = ((zzafo) this.zzj.valueAt(i2)).zzS;
            if (zzaca != null) {
                zzaca.zzb();
            }
        }
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        return new zzafq().zza(zzaax);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x027e, code lost:
        throw com.google.android.gms.internal.ads.zzcd.zza("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(int r20, int r21, com.google.android.gms.internal.ads.zzaax r22) throws java.io.IOException {
        /*
            r19 = this;
            r7 = r19
            r0 = r20
            r1 = r21
            r8 = r22
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 0
            r4 = 4
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            if (r0 == r2) goto L_0x0112
            if (r0 == r5) goto L_0x0112
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00dc
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00b2
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x00a2
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x008d
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0067
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0057
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0041
            r19.zzr(r20)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzu = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0041:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected id: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r3)
            throw r0
        L_0x0057:
            r19.zzr(r20)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0067:
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzp
            byte[] r0 = r0.zzH()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzp
            byte[] r0 = r0.zzH()
            int r2 = 4 - r1
            r3 = r8
            com.google.android.gms.internal.ads.zzaam r3 = (com.google.android.gms.internal.ads.zzaam) r3
            r3.zzn(r0, r2, r1, r10)
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzp
            r0.zzF(r10)
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzp
            long r0 = r0.zzs()
            int r1 = (int) r0
            r7.zzD = r1
            return
        L_0x008d:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzaam r3 = (com.google.android.gms.internal.ads.zzaam) r3
            r3.zzn(r2, r10, r1, r10)
            r19.zzr(r20)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            com.google.android.gms.internal.ads.zzaby r1 = new com.google.android.gms.internal.ads.zzaby
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x00a2:
            r19.zzr(r20)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00b2:
            r19.zzr(r20)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            int r2 = r0.zzX
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00d1
            int r2 = r0.zzX
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzo(r1, r10)
            return
        L_0x00d1:
            byte[] r2 = new byte[r1]
            r0.zzM = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00dc:
            int r0 = r7.zzN
            if (r0 == r6) goto L_0x00e1
            return
        L_0x00e1:
            android.util.SparseArray r0 = r7.zzj
            int r2 = r7.zzT
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzafo r0 = (com.google.android.gms.internal.ads.zzafo) r0
            int r2 = r7.zzW
            if (r2 != r4) goto L_0x010b
            java.lang.String r0 = r0.zzb
            java.lang.String r2 = "V_VP9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x010b
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzu
            r0.zzC(r1)
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzu
            byte[] r0 = r0.zzH()
            r2 = r8
            com.google.android.gms.internal.ads.zzaam r2 = (com.google.android.gms.internal.ads.zzaam) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x010b:
            r0 = r8
            com.google.android.gms.internal.ads.zzaam r0 = (com.google.android.gms.internal.ads.zzaam) r0
            r0.zzo(r1, r10)
            return
        L_0x0112:
            int r2 = r7.zzN
            r11 = 8
            if (r2 != 0) goto L_0x0137
            com.google.android.gms.internal.ads.zzafr r2 = r7.zzi
            long r12 = r2.zzd(r8, r10, r9, r11)
            int r2 = (int) r12
            r7.zzT = r2
            com.google.android.gms.internal.ads.zzafr r2 = r7.zzi
            int r2 = r2.zza()
            r7.zzU = r2
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzP = r12
            r7.zzN = r9
            com.google.android.gms.internal.ads.zzfa r2 = r7.zzn
            r2.zzC(r10)
        L_0x0137:
            android.util.SparseArray r2 = r7.zzj
            int r12 = r7.zzT
            java.lang.Object r2 = r2.get(r12)
            r12 = r2
            com.google.android.gms.internal.ads.zzafo r12 = (com.google.android.gms.internal.ads.zzafo) r12
            if (r12 != 0) goto L_0x0151
            int r0 = r7.zzU
            int r0 = r1 - r0
            r1 = r8
            com.google.android.gms.internal.ads.zzaam r1 = (com.google.android.gms.internal.ads.zzaam) r1
            r1.zzo(r0, r10)
            r7.zzN = r10
            return
        L_0x0151:
            r12.zzV.getClass()
            int r2 = r7.zzN
            if (r2 != r9) goto L_0x02dd
            r2 = 3
            r7.zzt(r8, r2)
            com.google.android.gms.internal.ads.zzfa r13 = r7.zzn
            byte[] r13 = r13.zzH()
            byte r13 = r13[r6]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x017e
            r7.zzR = r9
            int[] r2 = r7.zzS
            int[] r2 = zzx(r2, r9)
            r7.zzS = r2
            int r3 = r7.zzU
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x028f
        L_0x017e:
            r7.zzt(r8, r4)
            com.google.android.gms.internal.ads.zzfa r15 = r7.zzn
            byte[] r15 = r15.zzH()
            byte r15 = r15[r2]
            r15 = r15 & r14
            int r15 = r15 + r9
            r7.zzR = r15
            int[] r4 = r7.zzS
            int[] r4 = zzx(r4, r15)
            r7.zzS = r4
            if (r13 != r6) goto L_0x01a4
            int r2 = r7.zzU
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r2 = r7.zzR
            int r1 = r1 / r2
            java.util.Arrays.fill(r4, r10, r2, r1)
            goto L_0x028f
        L_0x01a4:
            if (r13 != r9) goto L_0x01dc
            r2 = 0
            r3 = 0
            r4 = 4
        L_0x01a9:
            int r13 = r7.zzR
            int r13 = r13 + -1
            if (r2 >= r13) goto L_0x01d1
            int[] r13 = r7.zzS
            r13[r2] = r10
        L_0x01b3:
            int r4 = r4 + r9
            r7.zzt(r8, r4)
            com.google.android.gms.internal.ads.zzfa r13 = r7.zzn
            byte[] r13 = r13.zzH()
            int r15 = r4 + -1
            byte r13 = r13[r15]
            r13 = r13 & r14
            int[] r15 = r7.zzS
            r16 = r15[r2]
            int r16 = r16 + r13
            r15[r2] = r16
            if (r13 == r14) goto L_0x01b3
            int r3 = r3 + r16
            int r2 = r2 + 1
            goto L_0x01a9
        L_0x01d1:
            int[] r2 = r7.zzS
            int r15 = r7.zzU
            int r1 = r1 - r15
            int r1 = r1 - r4
            int r1 = r1 - r3
            r2[r13] = r1
            goto L_0x028f
        L_0x01dc:
            if (r13 != r2) goto L_0x02d6
            r2 = 0
            r4 = 4
            r13 = 0
        L_0x01e1:
            int r15 = r7.zzR
            int r15 = r15 + -1
            if (r2 >= r15) goto L_0x0286
            int[] r15 = r7.zzS
            r15[r2] = r10
            int r4 = r4 + 1
            r7.zzt(r8, r4)
            com.google.android.gms.internal.ads.zzfa r15 = r7.zzn
            byte[] r15 = r15.zzH()
            int r16 = r4 + -1
            byte r15 = r15[r16]
            if (r15 == 0) goto L_0x027f
            r15 = 0
        L_0x01fd:
            if (r15 >= r11) goto L_0x0250
            int r17 = 7 - r15
            int r5 = r9 << r17
            com.google.android.gms.internal.ads.zzfa r6 = r7.zzn
            byte[] r6 = r6.zzH()
            byte r6 = r6[r16]
            r6 = r6 & r5
            if (r6 == 0) goto L_0x0246
            int r4 = r4 + r15
            r7.zzt(r8, r4)
            com.google.android.gms.internal.ads.zzfa r6 = r7.zzn
            byte[] r6 = r6.zzH()
            int r18 = r16 + 1
            byte r6 = r6[r16]
            r6 = r6 & r14
            int r5 = ~r5
            r5 = r5 & r6
            long r5 = (long) r5
            r9 = r18
        L_0x0222:
            if (r9 >= r4) goto L_0x0238
            long r5 = r5 << r11
            com.google.android.gms.internal.ads.zzfa r11 = r7.zzn
            byte[] r11 = r11.zzH()
            int r16 = r9 + 1
            byte r9 = r11[r9]
            r9 = r9 & r14
            long r10 = (long) r9
            long r5 = r5 | r10
            r9 = r16
            r10 = 0
            r11 = 8
            goto L_0x0222
        L_0x0238:
            if (r2 <= 0) goto L_0x0252
            int r15 = r15 * 7
            int r15 = r15 + 6
            r9 = 1
            long r9 = r9 << r15
            r15 = -1
            long r9 = r9 + r15
            long r5 = r5 - r9
            goto L_0x0252
        L_0x0246:
            int r15 = r15 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            goto L_0x01fd
        L_0x0250:
            r5 = 0
        L_0x0252:
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0278
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0278
            int[] r9 = r7.zzS
            int r6 = (int) r5
            if (r2 == 0) goto L_0x026a
            int r5 = r2 + -1
            r5 = r9[r5]
            int r6 = r6 + r5
        L_0x026a:
            r9[r2] = r6
            int r13 = r13 + r6
            int r2 = r2 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            goto L_0x01e1
        L_0x0278:
            java.lang.String r0 = "EBML lacing sample size out of range."
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r3)
            throw r0
        L_0x027f:
            java.lang.String r0 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r3)
            throw r0
        L_0x0286:
            int[] r2 = r7.zzS
            int r3 = r7.zzU
            int r1 = r1 - r3
            int r1 = r1 - r4
            int r1 = r1 - r13
            r2[r15] = r1
        L_0x028f:
            com.google.android.gms.internal.ads.zzfa r1 = r7.zzn
            byte[] r1 = r1.zzH()
            r2 = 0
            byte r1 = r1[r2]
            r2 = 8
            int r1 = r1 << r2
            com.google.android.gms.internal.ads.zzfa r2 = r7.zzn
            byte[] r2 = r2.zzH()
            r3 = 1
            byte r2 = r2[r3]
            r2 = r2 & r14
            long r3 = r7.zzI
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzp(r1)
            long r3 = r3 + r1
            r7.zzO = r3
            int r1 = r12.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02cd
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02cb
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzn
            byte[] r0 = r0.zzH()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02c9
            r0 = 163(0xa3, float:2.28E-43)
            goto L_0x02cd
        L_0x02c9:
            r0 = 163(0xa3, float:2.28E-43)
        L_0x02cb:
            r1 = 0
            goto L_0x02ce
        L_0x02cd:
            r1 = 1
        L_0x02ce:
            r7.zzV = r1
            r7.zzN = r2
            r1 = 0
            r7.zzQ = r1
            goto L_0x02dd
        L_0x02d6:
            java.lang.String r0 = "Unexpected lacing value: 2"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r3)
            throw r0
        L_0x02dd:
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x0310
        L_0x02e1:
            int r0 = r7.zzQ
            int r1 = r7.zzR
            if (r0 >= r1) goto L_0x030c
            int[] r1 = r7.zzS
            r0 = r1[r0]
            r1 = 0
            int r5 = r7.zzn(r8, r12, r0, r1)
            long r0 = r7.zzO
            int r2 = r7.zzQ
            int r3 = r12.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzV
            r6 = 0
            r0 = r19
            r1 = r12
            r0.zzs(r1, r2, r4, r5, r6)
            int r0 = r7.zzQ
            r1 = 1
            int r0 = r0 + r1
            r7.zzQ = r0
            goto L_0x02e1
        L_0x030c:
            r0 = 0
            r7.zzN = r0
            return
        L_0x0310:
            r1 = 1
        L_0x0311:
            int r0 = r7.zzQ
            int r2 = r7.zzR
            if (r0 >= r2) goto L_0x0327
            int[] r2 = r7.zzS
            r3 = r2[r0]
            int r3 = r7.zzn(r8, r12, r3, r1)
            r2[r0] = r3
            int r0 = r7.zzQ
            int r0 = r0 + r1
            r7.zzQ = r0
            goto L_0x0311
        L_0x0327:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzg(int, int, com.google.android.gms.internal.ads.zzaax):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e8, code lost:
        if (r5.equals("V_MPEGH/ISO/HEVC") != false) goto L_0x0315;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r22) throws com.google.android.gms.internal.ads.zzcd {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            com.google.android.gms.internal.ads.zzaaz r1 = r7.zzai
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 8
            java.lang.String r3 = "A_OPUS"
            r4 = 2
            r5 = 0
            if (r0 == r1) goto L_0x0334
            r1 = 174(0xae, float:2.44E-43)
            r10 = -1
            if (r0 == r1) goto L_0x018a
            r1 = 19899(0x4dbb, float:2.7884E-41)
            r2 = -1
            r4 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 == r1) goto L_0x0172
            r1 = 25152(0x6240, float:3.5245E-41)
            if (r0 == r1) goto L_0x013f
            r1 = 28032(0x6d80, float:3.9281E-41)
            if (r0 == r1) goto L_0x0129
            r1 = 357149030(0x1549a966, float:4.072526E-26)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == r1) goto L_0x0111
            r1 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r0 == r1) goto L_0x00fb
            if (r0 == r4) goto L_0x003d
            goto L_0x0181
        L_0x003d:
            boolean r0 = r7.zzC
            if (r0 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzaaz r0 = r7.zzai
            com.google.android.gms.internal.ads.zzes r1 = r7.zzJ
            com.google.android.gms.internal.ads.zzes r4 = r7.zzK
            long r14 = r7.zzx
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 == 0) goto L_0x00e8
            long r2 = r7.zzA
            int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x00e8
            if (r1 == 0) goto L_0x00e8
            int r2 = r1.zza()
            if (r2 == 0) goto L_0x00e8
            if (r4 == 0) goto L_0x00e8
            int r2 = r4.zza()
            int r3 = r1.zza()
            if (r2 == r3) goto L_0x0069
            goto L_0x00e8
        L_0x0069:
            int r2 = r1.zza()
            int[] r3 = new int[r2]
            long[] r12 = new long[r2]
            long[] r13 = new long[r2]
            long[] r14 = new long[r2]
            r15 = 0
        L_0x0076:
            if (r15 >= r2) goto L_0x008b
            long r16 = r1.zzb(r15)
            r14[r15] = r16
            long r8 = r7.zzx
            long r18 = r4.zzb(r15)
            long r8 = r8 + r18
            r12[r15] = r8
            int r15 = r15 + 1
            goto L_0x0076
        L_0x008b:
            r9 = 0
        L_0x008c:
            int r1 = r2 + -1
            if (r9 >= r1) goto L_0x00a6
            int r1 = r9 + 1
            r17 = r12[r1]
            r19 = r12[r9]
            long r10 = r17 - r19
            int r4 = (int) r10
            r3[r9] = r4
            r10 = r14[r1]
            r17 = r14[r9]
            long r10 = r10 - r17
            r13[r9] = r10
            r9 = r1
            r10 = -1
            goto L_0x008c
        L_0x00a6:
            long r8 = r7.zzx
            long r10 = r7.zzw
            long r8 = r8 + r10
            r10 = r12[r1]
            long r8 = r8 - r10
            int r2 = (int) r8
            r3[r1] = r2
            long r8 = r7.zzA
            r10 = r14[r1]
            long r8 = r8 - r10
            r13[r1] = r8
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x00e2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Discarding last cue point with unexpected duration: "
            r2.append(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "MatroskaExtractor"
            com.google.android.gms.internal.ads.zzer.zzf(r4, r2)
            int[] r3 = java.util.Arrays.copyOf(r3, r1)
            long[] r12 = java.util.Arrays.copyOf(r12, r1)
            long[] r13 = java.util.Arrays.copyOf(r13, r1)
            long[] r14 = java.util.Arrays.copyOf(r14, r1)
        L_0x00e2:
            com.google.android.gms.internal.ads.zzaak r1 = new com.google.android.gms.internal.ads.zzaak
            r1.<init>(r3, r12, r13, r14)
            goto L_0x00ef
        L_0x00e8:
            com.google.android.gms.internal.ads.zzabu r1 = new com.google.android.gms.internal.ads.zzabu
            long r2 = r7.zzA
            r1.<init>(r2, r5)
        L_0x00ef:
            r0.zzN(r1)
            r0 = 1
            r7.zzC = r0
        L_0x00f5:
            r0 = 0
            r7.zzJ = r0
            r7.zzK = r0
            return
        L_0x00fb:
            r0 = 0
            android.util.SparseArray r1 = r7.zzj
            int r1 = r1.size()
            if (r1 == 0) goto L_0x010a
            com.google.android.gms.internal.ads.zzaaz r0 = r7.zzai
            r0.zzC()
            return
        L_0x010a:
            java.lang.String r1 = "No valid tracks were found"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r1, r0)
            throw r0
        L_0x0111:
            long r0 = r7.zzy
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x011c
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzy = r0
        L_0x011c:
            long r0 = r7.zzz
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0181
            long r0 = r7.zzp(r0)
            r7.zzA = r0
            return
        L_0x0129:
            r21.zzr(r22)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0181
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x0137
            goto L_0x0181
        L_0x0137:
            java.lang.String r0 = "Combining encryption and compression is not supported"
            r1 = 0
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r1)
            throw r0
        L_0x013f:
            r21.zzr(r22)
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzaby r1 = r0.zzi
            if (r1 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r2 = 1
            com.google.android.gms.internal.ads.zzac[] r2 = new com.google.android.gms.internal.ads.zzac[r2]
            com.google.android.gms.internal.ads.zzac r3 = new com.google.android.gms.internal.ads.zzac
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzo.zza
            com.google.android.gms.internal.ads.zzafo r5 = r7.zzB
            com.google.android.gms.internal.ads.zzaby r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r8 = 0
            r3.<init>(r4, r8, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r8, r2)
            r0.zzk = r1
            return
        L_0x016a:
            r8 = 0
            java.lang.String r0 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r8)
            throw r0
        L_0x0172:
            int r0 = r7.zzD
            r1 = -1
            if (r0 == r1) goto L_0x0182
            long r5 = r7.zzE
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0182
            if (r0 != r4) goto L_0x0181
            r7.zzG = r5
        L_0x0181:
            return
        L_0x0182:
            java.lang.String r0 = "Mandatory element SeekID or SeekPosition not found"
            r1 = 0
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r0, r1)
            throw r0
        L_0x018a:
            r1 = -1
            com.google.android.gms.internal.ads.zzafo r0 = r7.zzB
            com.google.android.gms.internal.ads.zzdy.zzb(r0)
            java.lang.String r5 = r0.zzb
            if (r5 == 0) goto L_0x032c
            int r6 = r5.hashCode()
            switch(r6) {
                case -2095576542: goto L_0x030a;
                case -2095575984: goto L_0x0300;
                case -1985379776: goto L_0x02f5;
                case -1784763192: goto L_0x02ea;
                case -1730367663: goto L_0x02df;
                case -1482641358: goto L_0x02d4;
                case -1482641357: goto L_0x02c9;
                case -1373388978: goto L_0x02be;
                case -933872740: goto L_0x02b3;
                case -538363189: goto L_0x02a8;
                case -538363109: goto L_0x029d;
                case -425012669: goto L_0x0291;
                case -356037306: goto L_0x0285;
                case 62923557: goto L_0x0279;
                case 62923603: goto L_0x026d;
                case 62927045: goto L_0x0261;
                case 82318131: goto L_0x0256;
                case 82338133: goto L_0x024b;
                case 82338134: goto L_0x0240;
                case 99146302: goto L_0x0234;
                case 444813526: goto L_0x0228;
                case 542569478: goto L_0x021c;
                case 635596514: goto L_0x0210;
                case 725948237: goto L_0x0204;
                case 725957860: goto L_0x01f8;
                case 738597099: goto L_0x01ec;
                case 855502857: goto L_0x01e2;
                case 1045209816: goto L_0x01d6;
                case 1422270023: goto L_0x01ca;
                case 1809237540: goto L_0x01bf;
                case 1950749482: goto L_0x01b3;
                case 1950789798: goto L_0x01a7;
                case 1951062397: goto L_0x019d;
                default: goto L_0x019b;
            }
        L_0x019b:
            goto L_0x0314
        L_0x019d:
            boolean r2 = r5.equals(r3)
            if (r2 == 0) goto L_0x0314
            r2 = 11
            goto L_0x0315
        L_0x01a7:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 22
            goto L_0x0315
        L_0x01b3:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 17
            goto L_0x0315
        L_0x01bf:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 3
            goto L_0x0315
        L_0x01ca:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 27
            goto L_0x0315
        L_0x01d6:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 29
            goto L_0x0315
        L_0x01e2:
            java.lang.String r3 = "V_MPEGH/ISO/HEVC"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0314
            goto L_0x0315
        L_0x01ec:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 28
            goto L_0x0315
        L_0x01f8:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 24
            goto L_0x0315
        L_0x0204:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 25
            goto L_0x0315
        L_0x0210:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 26
            goto L_0x0315
        L_0x021c:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 20
            goto L_0x0315
        L_0x0228:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 10
            goto L_0x0315
        L_0x0234:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 31
            goto L_0x0315
        L_0x0240:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 1
            goto L_0x0315
        L_0x024b:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 0
            goto L_0x0315
        L_0x0256:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 2
            goto L_0x0315
        L_0x0261:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 19
            goto L_0x0315
        L_0x026d:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 16
            goto L_0x0315
        L_0x0279:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 13
            goto L_0x0315
        L_0x0285:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 21
            goto L_0x0315
        L_0x0291:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 30
            goto L_0x0315
        L_0x029d:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 7
            goto L_0x0315
        L_0x02a8:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 5
            goto L_0x0315
        L_0x02b3:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 32
            goto L_0x0315
        L_0x02be:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 9
            goto L_0x0315
        L_0x02c9:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 15
            goto L_0x0315
        L_0x02d4:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 14
            goto L_0x0315
        L_0x02df:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 12
            goto L_0x0315
        L_0x02ea:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 18
            goto L_0x0315
        L_0x02f5:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 23
            goto L_0x0315
        L_0x0300:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 4
            goto L_0x0315
        L_0x030a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0314
            r2 = 6
            goto L_0x0315
        L_0x0314:
            r2 = -1
        L_0x0315:
            switch(r2) {
                case 0: goto L_0x031a;
                case 1: goto L_0x031a;
                case 2: goto L_0x031a;
                case 3: goto L_0x031a;
                case 4: goto L_0x031a;
                case 5: goto L_0x031a;
                case 6: goto L_0x031a;
                case 7: goto L_0x031a;
                case 8: goto L_0x031a;
                case 9: goto L_0x031a;
                case 10: goto L_0x031a;
                case 11: goto L_0x031a;
                case 12: goto L_0x031a;
                case 13: goto L_0x031a;
                case 14: goto L_0x031a;
                case 15: goto L_0x031a;
                case 16: goto L_0x031a;
                case 17: goto L_0x031a;
                case 18: goto L_0x031a;
                case 19: goto L_0x031a;
                case 20: goto L_0x031a;
                case 21: goto L_0x031a;
                case 22: goto L_0x031a;
                case 23: goto L_0x031a;
                case 24: goto L_0x031a;
                case 25: goto L_0x031a;
                case 26: goto L_0x031a;
                case 27: goto L_0x031a;
                case 28: goto L_0x031a;
                case 29: goto L_0x031a;
                case 30: goto L_0x031a;
                case 31: goto L_0x031a;
                case 32: goto L_0x031a;
                default: goto L_0x0318;
            }
        L_0x0318:
            r0 = 0
            goto L_0x0329
        L_0x031a:
            com.google.android.gms.internal.ads.zzaaz r1 = r7.zzai
            int r2 = r0.zzc
            r0.zze(r1, r2)
            android.util.SparseArray r1 = r7.zzj
            int r2 = r0.zzc
            r1.put(r2, r0)
            goto L_0x0318
        L_0x0329:
            r7.zzB = r0
            return
        L_0x032c:
            r0 = 0
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzcd r0 = com.google.android.gms.internal.ads.zzcd.zza(r1, r0)
            throw r0
        L_0x0334:
            int r0 = r7.zzN
            if (r0 == r4) goto L_0x0339
            return
        L_0x0339:
            android.util.SparseArray r0 = r7.zzj
            int r1 = r7.zzT
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            com.google.android.gms.internal.ads.zzafo r8 = (com.google.android.gms.internal.ads.zzafo) r8
            r8.zzV.getClass()
            long r0 = r7.zzY
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x036f
            java.lang.String r0 = r8.zzb
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x036f
            com.google.android.gms.internal.ads.zzfa r0 = r7.zzu
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r1 = r1.order(r2)
            long r2 = r7.zzY
            java.nio.ByteBuffer r1 = r1.putLong(r2)
            byte[] r1 = r1.array()
            int r2 = r1.length
            r0.zzD(r1, r2)
        L_0x036f:
            r0 = 0
            r4 = 0
        L_0x0371:
            int r1 = r7.zzR
            if (r4 >= r1) goto L_0x037d
            int[] r1 = r7.zzS
            r1 = r1[r4]
            int r0 = r0 + r1
            int r4 = r4 + 1
            goto L_0x0371
        L_0x037d:
            r4 = 0
        L_0x037e:
            int r1 = r7.zzR
            if (r4 >= r1) goto L_0x03ae
            long r1 = r7.zzO
            int r3 = r8.zze
            int r3 = r3 * r4
            int r3 = r3 / 1000
            long r5 = (long) r3
            long r2 = r1 + r5
            int r1 = r7.zzV
            if (r4 != 0) goto L_0x039a
            boolean r4 = r7.zzX
            if (r4 != 0) goto L_0x0397
            r1 = r1 | 1
        L_0x0397:
            r4 = r1
            r9 = 0
            goto L_0x039c
        L_0x039a:
            r9 = r4
            r4 = r1
        L_0x039c:
            int[] r1 = r7.zzS
            r5 = r1[r9]
            int r10 = r0 - r5
            r0 = r21
            r1 = r8
            r6 = r10
            r0.zzs(r1, r2, r4, r5, r6)
            r0 = 1
            int r4 = r9 + 1
            r0 = r10
            goto L_0x037e
        L_0x03ae:
            r1 = 0
            r7.zzN = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzh(int):void");
    }

    /* access modifiers changed from: protected */
    public final void zzi(int i2, double d2) throws zzcd {
        if (i2 == 181) {
            zzr(i2);
            this.zzB.zzP = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    zzr(i2);
                    this.zzB.zzC = (float) d2;
                    return;
                case 21970:
                    zzr(i2);
                    this.zzB.zzD = (float) d2;
                    return;
                case 21971:
                    zzr(i2);
                    this.zzB.zzE = (float) d2;
                    return;
                case 21972:
                    zzr(i2);
                    this.zzB.zzF = (float) d2;
                    return;
                case 21973:
                    zzr(i2);
                    this.zzB.zzG = (float) d2;
                    return;
                case 21974:
                    zzr(i2);
                    this.zzB.zzH = (float) d2;
                    return;
                case 21975:
                    zzr(i2);
                    this.zzB.zzI = (float) d2;
                    return;
                case 21976:
                    zzr(i2);
                    this.zzB.zzJ = (float) d2;
                    return;
                case 21977:
                    zzr(i2);
                    this.zzB.zzK = (float) d2;
                    return;
                case 21978:
                    zzr(i2);
                    this.zzB.zzL = (float) d2;
                    return;
                default:
                    switch (i2) {
                        case 30323:
                            zzr(i2);
                            this.zzB.zzr = (float) d2;
                            return;
                        case 30324:
                            zzr(i2);
                            this.zzB.zzs = (float) d2;
                            return;
                        case 30325:
                            zzr(i2);
                            this.zzB.zzt = (float) d2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzz = (long) d2;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(int i2, long j2) throws zzcd {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case MRAID_JS_WRITE_FAILED_VALUE:
                        zzr(i2);
                        this.zzB.zzd = (int) j2;
                        return;
                    case PRIVACY_URL_ERROR_VALUE:
                        zzr(i2);
                        zzafo zzafo = this.zzB;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        zzafo.zzU = z2;
                        return;
                    case 155:
                        this.zzP = zzp(j2);
                        return;
                    case 159:
                        zzr(i2);
                        this.zzB.zzN = (int) j2;
                        return;
                    case 176:
                        zzr(i2);
                        this.zzB.zzl = (int) j2;
                        return;
                    case 179:
                        zzq(i2);
                        this.zzJ.zzc(zzp(j2));
                        return;
                    case 186:
                        zzr(i2);
                        this.zzB.zzm = (int) j2;
                        return;
                    case 215:
                        zzr(i2);
                        this.zzB.zzc = (int) j2;
                        return;
                    case 231:
                        this.zzI = zzp(j2);
                        return;
                    case 238:
                        this.zzW = (int) j2;
                        return;
                    case 241:
                        if (!this.zzL) {
                            zzq(i2);
                            this.zzK.zzc(j2);
                            this.zzL = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzX = true;
                        return;
                    case 16871:
                        zzr(i2);
                        this.zzB.zzX = (int) j2;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw zzcd.zza("ContentCompAlgo " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw zzcd.zza("DocTypeReadVersion " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw zzcd.zza("EBMLReadVersion " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw zzcd.zza("ContentEncAlgo " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw zzcd.zza("AESSettingsCipherMode " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzE = j2 + this.zzx;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        zzr(i2);
                        if (i3 == 0) {
                            this.zzB.zzv = 0;
                            return;
                        } else if (i3 == 1) {
                            this.zzB.zzv = 2;
                            return;
                        } else if (i3 == 3) {
                            this.zzB.zzv = 1;
                            return;
                        } else if (i3 == 15) {
                            this.zzB.zzv = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzr(i2);
                        this.zzB.zzn = (int) j2;
                        return;
                    case 21682:
                        zzr(i2);
                        this.zzB.zzp = (int) j2;
                        return;
                    case 21690:
                        zzr(i2);
                        this.zzB.zzo = (int) j2;
                        return;
                    case 21930:
                        zzr(i2);
                        zzafo zzafo2 = this.zzB;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        zzafo2.zzT = z2;
                        return;
                    case 21998:
                        zzr(i2);
                        this.zzB.zzf = (int) j2;
                        return;
                    case 22186:
                        zzr(i2);
                        this.zzB.zzQ = j2;
                        return;
                    case 22203:
                        zzr(i2);
                        this.zzB.zzR = j2;
                        return;
                    case 25188:
                        zzr(i2);
                        this.zzB.zzO = (int) j2;
                        return;
                    case 30114:
                        this.zzY = j2;
                        return;
                    case 30321:
                        zzr(i2);
                        int i4 = (int) j2;
                        if (i4 == 0) {
                            this.zzB.zzq = 0;
                            return;
                        } else if (i4 == 1) {
                            this.zzB.zzq = 1;
                            return;
                        } else if (i4 == 2) {
                            this.zzB.zzq = 2;
                            return;
                        } else if (i4 == 3) {
                            this.zzB.zzq = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzr(i2);
                        this.zzB.zze = (int) j2;
                        return;
                    case 2807729:
                        this.zzy = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                zzr(i2);
                                int i5 = (int) j2;
                                if (i5 == 1) {
                                    this.zzB.zzz = 2;
                                    return;
                                } else if (i5 == 2) {
                                    this.zzB.zzz = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzr(i2);
                                int zzb2 = zzs.zzb((int) j2);
                                if (zzb2 != -1) {
                                    this.zzB.zzy = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzr(i2);
                                this.zzB.zzw = true;
                                int zza2 = zzs.zza((int) j2);
                                if (zza2 != -1) {
                                    this.zzB.zzx = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzr(i2);
                                this.zzB.zzA = (int) j2;
                                return;
                            case 21949:
                                zzr(i2);
                                this.zzB.zzB = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw zzcd.zza("ContentEncodingScope " + j2 + " not supported", (Throwable) null);
            }
        } else if (j2 != 0) {
            throw zzcd.zza("ContentEncodingOrder " + j2 + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i2, long j2, long j3) throws zzcd {
        zzdy.zzb(this.zzai);
        if (i2 == 160) {
            this.zzX = false;
            this.zzY = 0;
        } else if (i2 == 174) {
            this.zzB = new zzafo();
        } else if (i2 == 187) {
            this.zzL = false;
        } else if (i2 == 19899) {
            this.zzD = -1;
            this.zzE = -1;
        } else if (i2 == 20533) {
            zzr(i2);
            this.zzB.zzg = true;
        } else if (i2 == 21968) {
            zzr(i2);
            this.zzB.zzw = true;
        } else if (i2 == 408125543) {
            long j4 = this.zzx;
            if (j4 == -1 || j4 == j2) {
                this.zzx = j2;
                this.zzw = j3;
                return;
            }
            throw zzcd.zza("Multiple Segment elements not supported", (Throwable) null);
        } else if (i2 == 475249515) {
            this.zzJ = new zzes(32);
            this.zzK = new zzes(32);
        } else if (i2 != 524531317 || this.zzC) {
        } else {
            if (!this.zzk || this.zzG == -1) {
                this.zzai.zzN(new zzabu(this.zzA, 0));
                this.zzC = true;
                return;
            }
            this.zzF = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i2, String str) throws zzcd {
        if (i2 == 134) {
            zzr(i2);
            this.zzB.zzb = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                zzr(i2);
                this.zzB.zza = str;
            } else if (i2 == 2274716) {
                zzr(i2);
                this.zzB.zzY = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw zzcd.zza("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public zzafp(int i2) {
        zzafi zzafi = new zzafi();
        this.zzx = -1;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzG = -1;
        this.zzH = -1;
        this.zzI = -9223372036854775807L;
        this.zzh = zzafi;
        zzafi.zza(new zzafn(this, (zzafm) null));
        this.zzk = true;
        this.zzi = new zzafr();
        this.zzj = new SparseArray();
        this.zzn = new zzfa(4);
        this.zzo = new zzfa(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzfa(4);
        this.zzl = new zzfa(zzfu.zza);
        this.zzm = new zzfa(4);
        this.zzq = new zzfa();
        this.zzr = new zzfa();
        this.zzs = new zzfa(8);
        this.zzt = new zzfa();
        this.zzu = new zzfa();
        this.zzS = new int[1];
    }
}
