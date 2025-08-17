package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class zzjx extends zzm implements zzis {
    public static final /* synthetic */ int zzd = 0;
    private final zzlr zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzlm zzG;
    private zzcl zzH;
    private zzbv zzI;
    private zzbv zzJ;
    /* access modifiers changed from: private */
    public zzam zzK;
    /* access modifiers changed from: private */
    public zzam zzL;
    private AudioTrack zzM;
    /* access modifiers changed from: private */
    public Object zzN;
    private Surface zzO;
    private int zzP;
    private zzfb zzQ;
    /* access modifiers changed from: private */
    public zzhz zzR;
    /* access modifiers changed from: private */
    public zzhz zzS;
    private int zzT;
    private zzk zzU;
    private float zzV;
    /* access modifiers changed from: private */
    public boolean zzW;
    private zzdx zzX;
    private boolean zzY;
    private boolean zzZ;
    private zzz zzaa;
    /* access modifiers changed from: private */
    public zzdn zzab;
    private zzbv zzac;
    private zzlc zzad;
    private int zzae;
    private long zzaf;
    private final zzjc zzag;
    private zzvi zzah;
    final zzxh zzb;
    final zzcl zzc;
    private final zzeb zze;
    private final Context zzf;
    private final zzcp zzg;
    private final zzli[] zzh;
    private final zzxg zzi;
    private final zzei zzj;
    private final zzkh zzk;
    /* access modifiers changed from: private */
    public final zzeo zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzct zzn;
    private final List zzo;
    private final boolean zzp;
    private final zztn zzq;
    /* access modifiers changed from: private */
    public final zzls zzr;
    private final Looper zzs;
    private final zzxo zzt;
    private final zzdz zzu;
    private final zzjt zzv;
    private final zzjv zzw;
    private final zzht zzx;
    private final zzhx zzy;
    private final zzlq zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzls, java.lang.Object, com.google.android.gms.internal.ads.zzxn] */
    @SuppressLint({"HandlerLeak"})
    public zzjx(zzir zzir, zzcp zzcp) {
        zzoc zza;
        Object obj;
        zzir zzir2 = zzir;
        zzcp zzcp2 = zzcp;
        zzeb zzeb = new zzeb(zzdz.zza);
        this.zze = zzeb;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfj.zze;
            zzer.zze("ExoPlayerImpl", "Init " + hexString + " [AndroidXMedia3/1.1.0-beta01] [" + str + "]");
            Context applicationContext = zzir2.zza.getApplicationContext();
            this.zzf = applicationContext;
            ? apply = zzir2.zzh.apply(zzir2.zzb);
            this.zzr = apply;
            this.zzU = zzir2.zzj;
            this.zzP = zzir2.zzk;
            this.zzW = false;
            this.zzB = zzir2.zzo;
            zzjt zzjt = new zzjt(this, (zzjs) null);
            this.zzv = zzjt;
            zzjv zzjv = new zzjv((zzju) null);
            this.zzw = zzjv;
            Handler handler = new Handler(zzir2.zzi);
            Handler handler2 = handler;
            zzli[] zza2 = ((zzil) zzir2.zzc).zza.zza(handler, zzjt, zzjt, zzjt, zzjt);
            this.zzh = zza2;
            int length = zza2.length;
            zzxg zzxg = (zzxg) zzir2.zze.zza();
            this.zzi = zzxg;
            this.zzq = zzir.zza(((zzim) zzir2.zzd).zza);
            zzxs zzg2 = zzxs.zzg(((zzip) zzir2.zzg).zza);
            this.zzt = zzg2;
            this.zzp = zzir2.zzl;
            this.zzG = zzir2.zzm;
            Looper looper = zzir2.zzi;
            this.zzs = looper;
            zzdz zzdz = zzir2.zzb;
            this.zzu = zzdz;
            this.zzg = zzcp2;
            zzeo zzeo = new zzeo(looper, zzdz, new zzjb(this));
            this.zzl = zzeo;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            zzjv zzjv2 = zzjv;
            this.zzah = new zzvi(0);
            int length2 = zza2.length;
            CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
            zzxs zzxs = zzg2;
            zzeo zzeo2 = zzeo;
            zzxh zzxh = new zzxh(new zzll[2], new zzxa[2], zzdh.zza, (Object) null);
            this.zzb = zzxh;
            this.zzn = new zzct();
            zzcj zzcj = new zzcj();
            zzcj.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 24, 27, 28, 32);
            zzxg.zzm();
            zzcj.zzd(29, true);
            zzcj.zzd(23, false);
            zzcj.zzd(25, false);
            zzcj.zzd(33, false);
            zzcj.zzd(26, false);
            zzcj.zzd(34, false);
            zzcl zze2 = zzcj.zze();
            this.zzc = zze2;
            zzcj zzcj2 = new zzcj();
            zzcj2.zzb(zze2);
            zzcj2.zza(4);
            zzcj2.zza(10);
            this.zzH = zzcj2.zze();
            this.zzj = zzdz.zzb(looper, (Handler.Callback) null);
            zzjc zzjc = new zzjc(this);
            this.zzag = zzjc;
            this.zzad = zzlc.zzi(zzxh);
            apply.zzP(zzcp2, looper);
            int i2 = zzfj.zza;
            if (i2 < 31) {
                zza = new zzoc();
            } else {
                zza = zzjo.zza(applicationContext, this, zzir2.zzp);
            }
            zzoc zzoc = zza;
            zzlm zzlm = this.zzG;
            zzeo zzeo3 = zzeo2;
            zzkh zzkh = r7;
            zzlm zzlm2 = zzlm;
            CopyOnWriteArraySet copyOnWriteArraySet3 = copyOnWriteArraySet2;
            Looper looper2 = looper;
            zzxh zzxh2 = zzxh;
            zzxs zzxs2 = zzxs;
            zzxg zzxg2 = zzxg;
            zzjv zzjv3 = zzjv2;
            zzjt zzjt2 = zzjt;
            zzkh zzkh2 = new zzkh(zza2, zzxg, zzxh2, (zzkk) zzir2.zzf.zza(), zzxs2, 0, false, apply, zzlm2, zzir2.zzr, zzir2.zzn, false, looper2, zzdz, zzjc, zzoc, (Looper) null);
            this.zzk = zzkh2;
            this.zzV = 1.0f;
            zzbv zzbv = zzbv.zza;
            this.zzI = zzbv;
            this.zzJ = zzbv;
            this.zzac = zzbv;
            int i3 = -1;
            this.zzae = -1;
            if (i2 >= 21) {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (audioManager != null) {
                    i3 = audioManager.generateAudioSessionId();
                }
                this.zzT = i3;
                obj = null;
            } else {
                AudioTrack audioTrack = this.zzM;
                if (audioTrack == null || audioTrack.getAudioSessionId() == 0) {
                    obj = null;
                } else {
                    this.zzM.release();
                    obj = null;
                    this.zzM = null;
                }
                if (this.zzM == null) {
                    this.zzM = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.zzT = this.zzM.getAudioSessionId();
            }
            this.zzX = zzdx.zza;
            this.zzY = true;
            apply.getClass();
            zzeo3.zzb(apply);
            zzxs2.zze(new Handler(looper2), apply);
            zzjt zzjt3 = zzjt2;
            copyOnWriteArraySet3.add(zzjt3);
            Handler handler3 = handler2;
            this.zzx = new zzht(zzir2.zza, handler3, zzjt3);
            this.zzy = new zzhx(zzir2.zza, handler3, zzjt3);
            zzfj.zzC(obj, obj);
            this.zzz = new zzlq(zzir2.zza);
            this.zzA = new zzlr(zzir2.zza);
            this.zzaa = new zzx(0).zza();
            this.zzab = zzdn.zza;
            this.zzQ = zzfb.zza;
            zzxg2.zzj(this.zzU);
            zzah(1, 10, Integer.valueOf(this.zzT));
            zzah(2, 10, Integer.valueOf(this.zzT));
            zzah(1, 3, this.zzU);
            zzah(2, 4, Integer.valueOf(this.zzP));
            zzah(2, 5, 0);
            zzah(1, 9, Boolean.valueOf(this.zzW));
            zzjv zzjv4 = zzjv3;
            zzah(2, 7, zzjv4);
            zzah(6, 8, zzjv4);
            zzeb.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzjx zzjx, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjx.zzaj(surface);
        zzjx.zzO = surface;
    }

    private final int zzX(zzlc zzlc) {
        if (zzlc.zza.zzo()) {
            return this.zzae;
        }
        return zzlc.zza.zzn(zzlc.zzb.zza, this.zzn).zzd;
    }

    /* access modifiers changed from: private */
    public static int zzY(boolean z2, int i2) {
        return (!z2 || i2 == 1) ? 1 : 2;
    }

    private final long zzZ(zzlc zzlc) {
        if (!zzlc.zzb.zzb()) {
            return zzfj.zzq(zzaa(zzlc));
        }
        zzlc.zza.zzn(zzlc.zzb.zza, this.zzn);
        long j2 = zzlc.zzc;
        if (j2 != -9223372036854775807L) {
            return zzfj.zzq(j2) + zzfj.zzq(0);
        }
        long j3 = zzlc.zza.zze(zzX(zzlc), this.zza, 0).zzm;
        return zzfj.zzq(0);
    }

    private final long zzaa(zzlc zzlc) {
        long j2;
        if (zzlc.zza.zzo()) {
            return zzfj.zzo(this.zzaf);
        }
        if (zzlc.zzo) {
            j2 = zzlc.zza();
        } else {
            j2 = zzlc.zzr;
        }
        if (zzlc.zzb.zzb()) {
            return j2;
        }
        zzac(zzlc.zza, zzlc.zzb, j2);
        return j2;
    }

    private static long zzab(zzlc zzlc) {
        zzcv zzcv = new zzcv();
        zzct zzct = new zzct();
        zzlc.zza.zzn(zzlc.zzb.zza, zzct);
        long j2 = zzlc.zzc;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = zzlc.zza.zze(zzct.zzd, zzcv, 0).zzm;
        return 0;
    }

    private final long zzac(zzcw zzcw, zzto zzto, long j2) {
        zzcw.zzn(zzto.zza, this.zzn);
        return j2;
    }

    private final Pair zzad(zzcw zzcw, int i2, long j2) {
        if (zzcw.zzo()) {
            this.zzae = i2;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.zzaf = j2;
            return null;
        }
        if (i2 == -1 || i2 >= zzcw.zzc()) {
            i2 = zzcw.zzg(false);
            long j3 = zzcw.zze(i2, this.zza, 0).zzm;
            j2 = zzfj.zzq(0);
        }
        return zzcw.zzl(this.zza, this.zzn, i2, zzfj.zzo(j2));
    }

    private final zzlc zzae(zzlc zzlc, zzcw zzcw, Pair pair) {
        boolean z2;
        zzto zzto;
        zzvn zzvn;
        zzxh zzxh;
        List list;
        int i2;
        long j2;
        zzcw zzcw2 = zzcw;
        Pair pair2 = pair;
        if (zzcw.zzo() || pair2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        zzcw zzcw3 = zzlc.zza;
        long zzZ2 = zzZ(zzlc);
        zzlc zzh2 = zzlc.zzh(zzcw);
        if (zzcw.zzo()) {
            zzto zzj2 = zzlc.zzj();
            long zzo2 = zzfj.zzo(this.zzaf);
            zzlc zzc2 = zzh2.zzd(zzj2, zzo2, zzo2, zzo2, 0, zzvn.zza, this.zzb, zzfsc.zzl()).zzc(zzj2);
            zzc2.zzp = zzc2.zzr;
            return zzc2;
        }
        Object obj = zzh2.zzb.zza;
        int i3 = zzfj.zza;
        boolean z3 = !obj.equals(pair2.first);
        if (z3) {
            zzto = new zzto(pair2.first);
        } else {
            zzto = zzh2.zzb;
        }
        zzto zzto2 = zzto;
        long longValue = ((Long) pair2.second).longValue();
        long zzo3 = zzfj.zzo(zzZ2);
        if (!zzcw3.zzo()) {
            zzcw3.zzn(obj, this.zzn);
        }
        if (z3 || longValue < zzo3) {
            long j3 = longValue;
            zzto zzto3 = zzto2;
            zzdy.zzf(!zzto3.zzb());
            if (z3) {
                zzvn = zzvn.zza;
            } else {
                zzvn = zzh2.zzh;
            }
            zzvn zzvn2 = zzvn;
            if (z3) {
                zzxh = this.zzb;
            } else {
                zzxh = zzh2.zzi;
            }
            zzxh zzxh2 = zzxh;
            if (z3) {
                list = zzfsc.zzl();
            } else {
                list = zzh2.zzj;
            }
            zzlc zzc3 = zzh2.zzd(zzto3, j3, j3, j3, 0, zzvn2, zzxh2, list).zzc(zzto3);
            zzc3.zzp = j3;
            return zzc3;
        } else if (i2 == 0) {
            int zza = zzcw2.zza(zzh2.zzk.zza);
            if (zza != -1 && zzcw2.zzd(zza, this.zzn, false).zzd == zzcw2.zzn(zzto2.zza, this.zzn).zzd) {
                return zzh2;
            }
            zzcw2.zzn(zzto2.zza, this.zzn);
            if (zzto2.zzb()) {
                j2 = this.zzn.zzh(zzto2.zzb, zzto2.zzc);
            } else {
                j2 = this.zzn.zze;
            }
            zzlc zzc4 = zzh2.zzd(zzto2, zzh2.zzr, zzh2.zzr, zzh2.zzd, j2 - zzh2.zzr, zzh2.zzh, zzh2.zzi, zzh2.zzj).zzc(zzto2);
            zzc4.zzp = j2;
            return zzc4;
        } else {
            zzto zzto4 = zzto2;
            zzdy.zzf(!zzto4.zzb());
            long max = Math.max(0, zzh2.zzq - (longValue - zzo3));
            long j4 = zzh2.zzp;
            if (zzh2.zzk.equals(zzh2.zzb)) {
                j4 = longValue + max;
            }
            zzlc zzd2 = zzh2.zzd(zzto4, longValue, longValue, longValue, max, zzh2.zzh, zzh2.zzi, zzh2.zzj);
            zzd2.zzp = j4;
            return zzd2;
        }
    }

    private final zzlf zzaf(zzle zzle) {
        int i2;
        int zzX2 = zzX(this.zzad);
        zzkh zzkh = this.zzk;
        zzcw zzcw = this.zzad.zza;
        if (zzX2 == -1) {
            i2 = 0;
        } else {
            i2 = zzX2;
        }
        return new zzlf(zzkh, zzle, zzcw, i2, this.zzu, zzkh.zzb());
    }

    /* access modifiers changed from: private */
    public final void zzag(int i2, int i3) {
        if (i2 != this.zzQ.zzb() || i3 != this.zzQ.zza()) {
            this.zzQ = new zzfb(i2, i3);
            zzeo zzeo = this.zzl;
            zzeo.zzd(24, new zzjf(i2, i3));
            zzeo.zzc();
            zzah(2, 14, new zzfb(i2, i3));
        }
    }

    private final void zzah(int i2, int i3, Object obj) {
        zzli[] zzliArr = this.zzh;
        int length = zzliArr.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzli zzli = zzliArr[i4];
            if (zzli.zzb() == i2) {
                zzlf zzaf2 = zzaf(zzli);
                zzaf2.zzf(i3);
                zzaf2.zze(obj);
                zzaf2.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzai() {
        zzah(1, 2, Float.valueOf(this.zzV * this.zzy.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzaj(Object obj) {
        ArrayList<zzlf> arrayList = new ArrayList<>();
        zzli[] zzliArr = this.zzh;
        int length = zzliArr.length;
        boolean z2 = false;
        for (int i2 = 0; i2 < 2; i2++) {
            zzli zzli = zzliArr[i2];
            if (zzli.zzb() == 2) {
                zzlf zzaf2 = zzaf(zzli);
                zzaf2.zzf(1);
                zzaf2.zze(obj);
                zzaf2.zzd();
                arrayList.add(zzaf2);
            }
        }
        Object obj2 = this.zzN;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (zzlf zzi2 : arrayList) {
                    zzi2.zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            Object obj3 = this.zzN;
            Surface surface = this.zzO;
            if (obj3 == surface) {
                surface.release();
                this.zzO = null;
            }
        }
        this.zzN = obj;
        if (z2) {
            zzak(zzih.zzd(new zzki(3), 1003));
        }
    }

    private final void zzak(zzih zzih) {
        zzlc zzlc = this.zzad;
        zzlc zzc2 = zzlc.zzc(zzlc.zzb);
        zzc2.zzp = zzc2.zzr;
        zzc2.zzq = 0;
        zzlc zzg2 = zzc2.zzg(1);
        if (zzih != null) {
            zzg2 = zzg2.zzf(zzih);
        }
        this.zzC++;
        this.zzk.zzo();
        zzam(zzg2, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* access modifiers changed from: private */
    public final void zzal(boolean z2, int i2, int i3) {
        boolean z3;
        int i4 = 0;
        if (!z2 || i2 == -1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 && i2 != 1) {
            i4 = 1;
        }
        zzlc zzlc = this.zzad;
        if (zzlc.zzl != z3 || zzlc.zzm != i4) {
            this.zzC++;
            if (zzlc.zzo) {
                zzlc = zzlc.zzb();
            }
            zzlc zze2 = zzlc.zze(z3, i4);
            this.zzk.zzn(z3, i4);
            zzam(zze2, 0, i3, false, 5, -9223372036854775807L, -1, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x045b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0465 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0470 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0481 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x048d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x04a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x04b0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:213:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzam(com.google.android.gms.internal.ads.zzlc r43, int r44, int r45, boolean r46, int r47, long r48, int r50, boolean r51) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = r47
            com.google.android.gms.internal.ads.zzlc r3 = r0.zzad
            r0.zzad = r1
            com.google.android.gms.internal.ads.zzcw r4 = r3.zza
            com.google.android.gms.internal.ads.zzcw r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzcw r6 = r3.zza
            com.google.android.gms.internal.ads.zzcw r7 = r1.zza
            boolean r8 = r7.zzo()
            r10 = 3
            r11 = -1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r13 = 0
            r15 = 0
            if (r8 == 0) goto L_0x0036
            boolean r8 = r6.zzo()
            if (r8 == 0) goto L_0x0036
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7, r12)
            goto L_0x00c0
        L_0x0036:
            boolean r8 = r7.zzo()
            boolean r9 = r6.zzo()
            if (r8 == r9) goto L_0x004d
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r6.<init>(r7, r8)
            goto L_0x00c0
        L_0x004d:
            com.google.android.gms.internal.ads.zzto r8 = r3.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzct r9 = r0.zzn
            com.google.android.gms.internal.ads.zzct r8 = r6.zzn(r8, r9)
            int r8 = r8.zzd
            com.google.android.gms.internal.ads.zzcv r9 = r0.zza
            com.google.android.gms.internal.ads.zzcv r6 = r6.zze(r8, r9, r13)
            java.lang.Object r6 = r6.zzc
            com.google.android.gms.internal.ads.zzto r8 = r1.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzct r9 = r0.zzn
            com.google.android.gms.internal.ads.zzct r8 = r7.zzn(r8, r9)
            int r8 = r8.zzd
            com.google.android.gms.internal.ads.zzcv r9 = r0.zza
            com.google.android.gms.internal.ads.zzcv r7 = r7.zze(r8, r9, r13)
            java.lang.Object r7 = r7.zzc
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x009d
            if (r46 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0081
            r6 = 1
            goto L_0x008a
        L_0x0081:
            if (r46 == 0) goto L_0x0087
            if (r2 != r5) goto L_0x0087
            r6 = 2
            goto L_0x008a
        L_0x0087:
            if (r4 == 0) goto L_0x0097
            r6 = 3
        L_0x008a:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.<init>(r8, r6)
            r6 = r7
            goto L_0x00c0
        L_0x0097:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x009d:
            if (r46 == 0) goto L_0x00b9
            if (r2 != 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzto r6 = r3.zzb
            long r6 = r6.zzd
            com.google.android.gms.internal.ads.zzto r8 = r1.zzb
            long r8 = r8.zzd
            int r16 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r16 >= 0) goto L_0x00b9
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r6.<init>(r7, r8)
            goto L_0x00c0
        L_0x00b9:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7, r12)
        L_0x00c0:
            java.lang.Object r7 = r6.first
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            com.google.android.gms.internal.ads.zzbv r8 = r0.zzI
            if (r7 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzcw r12 = r1.zza
            boolean r12 = r12.zzo()
            if (r12 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzcw r12 = r1.zza
            com.google.android.gms.internal.ads.zzto r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzct r10 = r0.zzn
            com.google.android.gms.internal.ads.zzct r9 = r12.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcw r10 = r1.zza
            com.google.android.gms.internal.ads.zzcv r12 = r0.zza
            com.google.android.gms.internal.ads.zzcv r9 = r10.zze(r9, r12, r13)
            com.google.android.gms.internal.ads.zzbp r9 = r9.zzd
            goto L_0x00f6
        L_0x00f5:
            r9 = 0
        L_0x00f6:
            com.google.android.gms.internal.ads.zzbv r10 = com.google.android.gms.internal.ads.zzbv.zza
            r0.zzac = r10
            goto L_0x00fc
        L_0x00fb:
            r9 = 0
        L_0x00fc:
            if (r7 != 0) goto L_0x0108
            java.util.List r10 = r3.zzj
            java.util.List r12 = r1.zzj
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0160
        L_0x0108:
            com.google.android.gms.internal.ads.zzbv r8 = r0.zzac
            com.google.android.gms.internal.ads.zzbt r8 = r8.zza()
            java.util.List r10 = r1.zzj
            r12 = 0
        L_0x0111:
            int r11 = r10.size()
            if (r12 >= r11) goto L_0x0132
            java.lang.Object r11 = r10.get(r12)
            com.google.android.gms.internal.ads.zzbz r11 = (com.google.android.gms.internal.ads.zzbz) r11
        L_0x011d:
            int r5 = r11.zza()
            if (r15 >= r5) goto L_0x012d
            com.google.android.gms.internal.ads.zzby r5 = r11.zzb(r15)
            r5.zza(r8)
            int r15 = r15 + 1
            goto L_0x011d
        L_0x012d:
            int r12 = r12 + 1
            r5 = 1
            r15 = 0
            goto L_0x0111
        L_0x0132:
            com.google.android.gms.internal.ads.zzbv r5 = r8.zzu()
            r0.zzac = r5
            com.google.android.gms.internal.ads.zzcw r5 = r42.zzn()
            boolean r8 = r5.zzo()
            if (r8 == 0) goto L_0x0145
            com.google.android.gms.internal.ads.zzbv r8 = r0.zzac
            goto L_0x0160
        L_0x0145:
            int r8 = r42.zzd()
            com.google.android.gms.internal.ads.zzcv r10 = r0.zza
            com.google.android.gms.internal.ads.zzcv r5 = r5.zze(r8, r10, r13)
            com.google.android.gms.internal.ads.zzbp r5 = r5.zzd
            com.google.android.gms.internal.ads.zzbv r8 = r0.zzac
            com.google.android.gms.internal.ads.zzbt r8 = r8.zza()
            com.google.android.gms.internal.ads.zzbv r5 = r5.zzg
            r8.zzb(r5)
            com.google.android.gms.internal.ads.zzbv r8 = r8.zzu()
        L_0x0160:
            com.google.android.gms.internal.ads.zzbv r5 = r0.zzI
            boolean r5 = r8.equals(r5)
            r10 = 1
            r5 = r5 ^ r10
            r0.zzI = r8
            boolean r8 = r3.zzl
            boolean r10 = r1.zzl
            if (r8 == r10) goto L_0x0172
            r10 = 1
            goto L_0x0173
        L_0x0172:
            r10 = 0
        L_0x0173:
            int r8 = r3.zze
            int r11 = r1.zze
            if (r8 == r11) goto L_0x017b
            r8 = 1
            goto L_0x017c
        L_0x017b:
            r8 = 0
        L_0x017c:
            if (r8 != 0) goto L_0x0180
            if (r10 == 0) goto L_0x0183
        L_0x0180:
            r42.zzan()
        L_0x0183:
            boolean r11 = r3.zzg
            boolean r12 = r1.zzg
            if (r11 == r12) goto L_0x018b
            r11 = 1
            goto L_0x018c
        L_0x018b:
            r11 = 0
        L_0x018c:
            if (r4 == 0) goto L_0x019b
            com.google.android.gms.internal.ads.zzeo r4 = r0.zzl
            com.google.android.gms.internal.ads.zzjh r12 = new com.google.android.gms.internal.ads.zzjh
            r15 = r44
            r12.<init>(r1, r15)
            r15 = 0
            r4.zzd(r15, r12)
        L_0x019b:
            if (r46 == 0) goto L_0x02c9
            com.google.android.gms.internal.ads.zzct r12 = new com.google.android.gms.internal.ads.zzct
            r12.<init>()
            com.google.android.gms.internal.ads.zzcw r15 = r3.zza
            boolean r15 = r15.zzo()
            if (r15 != 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzto r15 = r3.zzb
            java.lang.Object r15 = r15.zza
            com.google.android.gms.internal.ads.zzcw r4 = r3.zza
            r4.zzn(r15, r12)
            int r4 = r12.zzd
            com.google.android.gms.internal.ads.zzcw r13 = r3.zza
            int r13 = r13.zza(r15)
            com.google.android.gms.internal.ads.zzcw r14 = r3.zza
            r46 = r13
            com.google.android.gms.internal.ads.zzcv r13 = r0.zza
            r18 = r10
            r19 = r11
            r10 = 0
            com.google.android.gms.internal.ads.zzcv r13 = r14.zze(r4, r13, r10)
            java.lang.Object r10 = r13.zzc
            com.google.android.gms.internal.ads.zzcv r11 = r0.zza
            com.google.android.gms.internal.ads.zzbp r11 = r11.zzd
            r25 = r46
            r22 = r4
            r21 = r10
            r23 = r11
            r24 = r15
            goto L_0x01ea
        L_0x01dc:
            r18 = r10
            r19 = r11
            r22 = r50
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x01ea:
            if (r2 != 0) goto L_0x0214
            com.google.android.gms.internal.ads.zzto r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x0203
            com.google.android.gms.internal.ads.zzto r4 = r3.zzb
            int r10 = r4.zzb
            int r4 = r4.zzc
            long r10 = r12.zzh(r10, r4)
            long r12 = zzab(r3)
            goto L_0x0226
        L_0x0203:
            com.google.android.gms.internal.ads.zzto r4 = r3.zzb
            int r4 = r4.zze
            r10 = -1
            if (r4 == r10) goto L_0x0211
            com.google.android.gms.internal.ads.zzlc r4 = r0.zzad
            long r10 = zzab(r4)
            goto L_0x0225
        L_0x0211:
            long r10 = r12.zze
            goto L_0x0225
        L_0x0214:
            com.google.android.gms.internal.ads.zzto r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x0223
            long r10 = r3.zzr
            long r12 = zzab(r3)
            goto L_0x0226
        L_0x0223:
            long r10 = r3.zzr
        L_0x0225:
            r12 = r10
        L_0x0226:
            com.google.android.gms.internal.ads.zzco r4 = new com.google.android.gms.internal.ads.zzco
            int r14 = com.google.android.gms.internal.ads.zzfj.zza
            com.google.android.gms.internal.ads.zzto r14 = r3.zzb
            int r15 = r14.zzb
            int r14 = r14.zzc
            long r26 = com.google.android.gms.internal.ads.zzfj.zzq(r10)
            long r28 = com.google.android.gms.internal.ads.zzfj.zzq(r12)
            r20 = r4
            r30 = r15
            r31 = r14
            r20.<init>(r21, r22, r23, r24, r25, r26, r28, r30, r31)
            int r10 = r42.zzd()
            com.google.android.gms.internal.ads.zzlc r11 = r0.zzad
            com.google.android.gms.internal.ads.zzcw r11 = r11.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x0282
            com.google.android.gms.internal.ads.zzlc r11 = r0.zzad
            com.google.android.gms.internal.ads.zzto r12 = r11.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcw r11 = r11.zza
            com.google.android.gms.internal.ads.zzct r13 = r0.zzn
            r11.zzn(r12, r13)
            com.google.android.gms.internal.ads.zzlc r11 = r0.zzad
            com.google.android.gms.internal.ads.zzcw r11 = r11.zza
            int r11 = r11.zza(r12)
            com.google.android.gms.internal.ads.zzlc r13 = r0.zzad
            com.google.android.gms.internal.ads.zzcw r13 = r13.zza
            com.google.android.gms.internal.ads.zzcv r14 = r0.zza
            r46 = r11
            r15 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcv r13 = r13.zze(r10, r14, r11)
            java.lang.Object r11 = r13.zzc
            com.google.android.gms.internal.ads.zzcv r12 = r0.zza
            com.google.android.gms.internal.ads.zzbp r12 = r12.zzd
            r35 = r46
            r31 = r11
            r33 = r12
            r34 = r15
            goto L_0x028a
        L_0x0282:
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = -1
        L_0x028a:
            long r36 = com.google.android.gms.internal.ads.zzfj.zzq(r48)
            com.google.android.gms.internal.ads.zzco r11 = new com.google.android.gms.internal.ads.zzco
            com.google.android.gms.internal.ads.zzlc r12 = r0.zzad
            com.google.android.gms.internal.ads.zzto r12 = r12.zzb
            boolean r12 = r12.zzb()
            if (r12 == 0) goto L_0x02a7
            com.google.android.gms.internal.ads.zzlc r12 = r0.zzad
            long r12 = zzab(r12)
            long r12 = com.google.android.gms.internal.ads.zzfj.zzq(r12)
            r38 = r12
            goto L_0x02a9
        L_0x02a7:
            r38 = r36
        L_0x02a9:
            com.google.android.gms.internal.ads.zzlc r12 = r0.zzad
            com.google.android.gms.internal.ads.zzto r12 = r12.zzb
            int r13 = r12.zzb
            int r12 = r12.zzc
            r30 = r11
            r32 = r10
            r40 = r13
            r41 = r12
            r30.<init>(r31, r32, r33, r34, r35, r36, r38, r40, r41)
            com.google.android.gms.internal.ads.zzeo r10 = r0.zzl
            com.google.android.gms.internal.ads.zzjm r12 = new com.google.android.gms.internal.ads.zzjm
            r12.<init>(r2, r4, r11)
            r2 = 11
            r10.zzd(r2, r12)
            goto L_0x02cd
        L_0x02c9:
            r18 = r10
            r19 = r11
        L_0x02cd:
            if (r7 == 0) goto L_0x02db
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjn r4 = new com.google.android.gms.internal.ads.zzjn
            r4.<init>(r9, r6)
            r10 = 1
            r2.zzd(r10, r4)
            goto L_0x02dc
        L_0x02db:
            r10 = 1
        L_0x02dc:
            com.google.android.gms.internal.ads.zzih r2 = r3.zzf
            com.google.android.gms.internal.ads.zzih r4 = r1.zzf
            r6 = 10
            if (r2 == r4) goto L_0x02fc
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zzit r4 = new com.google.android.gms.internal.ads.zzit
            r4.<init>(r1)
            r2.zzd(r6, r4)
            com.google.android.gms.internal.ads.zzih r2 = r1.zzf
            if (r2 == 0) goto L_0x02fc
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zziu r4 = new com.google.android.gms.internal.ads.zziu
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x02fc:
            com.google.android.gms.internal.ads.zzxh r2 = r3.zzi
            com.google.android.gms.internal.ads.zzxh r4 = r1.zzi
            if (r2 == r4) goto L_0x0314
            com.google.android.gms.internal.ads.zzxg r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzp(r4)
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zziv r4 = new com.google.android.gms.internal.ads.zziv
            r4.<init>(r1)
            r7 = 2
            r2.zzd(r7, r4)
        L_0x0314:
            if (r5 == 0) goto L_0x0324
            com.google.android.gms.internal.ads.zzbv r2 = r0.zzI
            com.google.android.gms.internal.ads.zzeo r4 = r0.zzl
            com.google.android.gms.internal.ads.zziw r5 = new com.google.android.gms.internal.ads.zziw
            r5.<init>(r2)
            r2 = 14
            r4.zzd(r2, r5)
        L_0x0324:
            if (r19 == 0) goto L_0x0331
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zzix r4 = new com.google.android.gms.internal.ads.zzix
            r4.<init>(r1)
            r5 = 3
            r2.zzd(r5, r4)
        L_0x0331:
            if (r8 != 0) goto L_0x0335
            if (r18 == 0) goto L_0x0340
        L_0x0335:
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zziy r4 = new com.google.android.gms.internal.ads.zziy
            r4.<init>(r1)
            r5 = -1
            r2.zzd(r5, r4)
        L_0x0340:
            r2 = 4
            if (r8 == 0) goto L_0x034d
            com.google.android.gms.internal.ads.zzeo r4 = r0.zzl
            com.google.android.gms.internal.ads.zziz r5 = new com.google.android.gms.internal.ads.zziz
            r5.<init>(r1)
            r4.zzd(r2, r5)
        L_0x034d:
            r4 = 5
            if (r18 == 0) goto L_0x035c
            com.google.android.gms.internal.ads.zzeo r5 = r0.zzl
            com.google.android.gms.internal.ads.zzji r7 = new com.google.android.gms.internal.ads.zzji
            r8 = r45
            r7.<init>(r1, r8)
            r5.zzd(r4, r7)
        L_0x035c:
            int r5 = r3.zzm
            int r7 = r1.zzm
            r8 = 6
            if (r5 == r7) goto L_0x036d
            com.google.android.gms.internal.ads.zzeo r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjj r7 = new com.google.android.gms.internal.ads.zzjj
            r7.<init>(r1)
            r5.zzd(r8, r7)
        L_0x036d:
            boolean r5 = r3.zzk()
            boolean r7 = r43.zzk()
            r9 = 7
            if (r5 == r7) goto L_0x0382
            com.google.android.gms.internal.ads.zzeo r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjk r7 = new com.google.android.gms.internal.ads.zzjk
            r7.<init>(r1)
            r5.zzd(r9, r7)
        L_0x0382:
            com.google.android.gms.internal.ads.zzch r5 = r3.zzn
            com.google.android.gms.internal.ads.zzch r7 = r1.zzn
            boolean r5 = r5.equals(r7)
            r7 = 12
            if (r5 != 0) goto L_0x0398
            com.google.android.gms.internal.ads.zzeo r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjl r11 = new com.google.android.gms.internal.ads.zzjl
            r11.<init>(r1)
            r5.zzd(r7, r11)
        L_0x0398:
            com.google.android.gms.internal.ads.zzcl r5 = r0.zzH
            com.google.android.gms.internal.ads.zzcp r11 = r0.zzg
            com.google.android.gms.internal.ads.zzcl r12 = r0.zzc
            int r13 = com.google.android.gms.internal.ads.zzfj.zza
            boolean r13 = r11.zzx()
            r14 = r11
            com.google.android.gms.internal.ads.zzm r14 = (com.google.android.gms.internal.ads.zzm) r14
            com.google.android.gms.internal.ads.zzcw r15 = r14.zzn()
            boolean r16 = r15.zzo()
            if (r16 != 0) goto L_0x03c3
            int r10 = r14.zzd()
            com.google.android.gms.internal.ads.zzcv r7 = r14.zza
            r8 = 0
            com.google.android.gms.internal.ads.zzcv r7 = r15.zze(r10, r7, r8)
            boolean r7 = r7.zzh
            if (r7 == 0) goto L_0x03c3
            r10 = 1
            goto L_0x03c4
        L_0x03c3:
            r10 = 0
        L_0x03c4:
            com.google.android.gms.internal.ads.zzcw r7 = r14.zzn()
            boolean r8 = r7.zzo()
            if (r8 == 0) goto L_0x03d3
            r8 = -1
            r9 = 0
        L_0x03d0:
            r17 = 0
            goto L_0x03e7
        L_0x03d3:
            int r8 = r14.zzd()
            r14.zzh()
            r14.zzw()
            r9 = 0
            int r7 = r7.zzk(r8, r9, r9)
            r8 = -1
            if (r7 == r8) goto L_0x03d0
            r17 = 1
        L_0x03e7:
            com.google.android.gms.internal.ads.zzcw r7 = r14.zzn()
            boolean r15 = r7.zzo()
            if (r15 == 0) goto L_0x03f3
        L_0x03f1:
            r7 = 0
            goto L_0x0404
        L_0x03f3:
            int r15 = r14.zzd()
            r14.zzh()
            r14.zzw()
            int r7 = r7.zzj(r15, r9, r9)
            if (r7 == r8) goto L_0x03f1
            r7 = 1
        L_0x0404:
            com.google.android.gms.internal.ads.zzcw r8 = r14.zzn()
            boolean r15 = r8.zzo()
            if (r15 != 0) goto L_0x0424
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzcv r9 = r14.zza
            r49 = r7
            r6 = 0
            com.google.android.gms.internal.ads.zzcv r8 = r8.zze(r15, r9, r6)
            boolean r8 = r8.zzb()
            if (r8 == 0) goto L_0x0428
            r8 = 1
            goto L_0x0429
        L_0x0424:
            r49 = r7
            r6 = 0
        L_0x0428:
            r8 = 0
        L_0x0429:
            com.google.android.gms.internal.ads.zzcw r9 = r14.zzn()
            boolean r15 = r9.zzo()
            if (r15 != 0) goto L_0x0443
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzcv r14 = r14.zza
            com.google.android.gms.internal.ads.zzcv r6 = r9.zze(r15, r14, r6)
            boolean r6 = r6.zzi
            if (r6 == 0) goto L_0x0443
            r6 = 1
            goto L_0x0444
        L_0x0443:
            r6 = 0
        L_0x0444:
            com.google.android.gms.internal.ads.zzcw r7 = r11.zzn()
            boolean r7 = r7.zzo()
            com.google.android.gms.internal.ads.zzcj r9 = new com.google.android.gms.internal.ads.zzcj
            r9.<init>()
            r9.zzb(r12)
            r11 = r13 ^ 1
            r9.zzd(r2, r11)
            if (r10 == 0) goto L_0x045f
            if (r13 != 0) goto L_0x045f
            r2 = 1
            goto L_0x0460
        L_0x045f:
            r2 = 0
        L_0x0460:
            r9.zzd(r4, r2)
            if (r17 == 0) goto L_0x0469
            if (r13 != 0) goto L_0x0469
            r2 = 1
            goto L_0x046a
        L_0x0469:
            r2 = 0
        L_0x046a:
            r4 = 6
            r9.zzd(r4, r2)
            if (r7 != 0) goto L_0x047a
            if (r17 != 0) goto L_0x0476
            if (r8 == 0) goto L_0x0476
            if (r10 == 0) goto L_0x047a
        L_0x0476:
            if (r13 != 0) goto L_0x047a
            r2 = 1
            goto L_0x047b
        L_0x047a:
            r2 = 0
        L_0x047b:
            r4 = 7
            r9.zzd(r4, r2)
            if (r49 == 0) goto L_0x0485
            if (r13 != 0) goto L_0x0485
            r2 = 1
            goto L_0x0486
        L_0x0485:
            r2 = 0
        L_0x0486:
            r4 = 8
            r9.zzd(r4, r2)
            if (r7 != 0) goto L_0x0497
            if (r49 != 0) goto L_0x0493
            if (r8 == 0) goto L_0x0497
            if (r6 == 0) goto L_0x0497
        L_0x0493:
            if (r13 != 0) goto L_0x0497
            r2 = 1
            goto L_0x0498
        L_0x0497:
            r2 = 0
        L_0x0498:
            r4 = 9
            r9.zzd(r4, r2)
            r2 = 10
            r9.zzd(r2, r11)
            if (r10 == 0) goto L_0x04a8
            if (r13 != 0) goto L_0x04a8
            r2 = 1
            goto L_0x04a9
        L_0x04a8:
            r2 = 0
        L_0x04a9:
            r4 = 11
            r9.zzd(r4, r2)
            if (r10 == 0) goto L_0x04b4
            if (r13 != 0) goto L_0x04b4
            r2 = 1
            goto L_0x04b5
        L_0x04b4:
            r2 = 0
        L_0x04b5:
            r4 = 12
            r9.zzd(r4, r2)
            com.google.android.gms.internal.ads.zzcl r2 = r9.zze()
            r0.zzH = r2
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x04d2
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            com.google.android.gms.internal.ads.zzja r4 = new com.google.android.gms.internal.ads.zzja
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x04d2:
            com.google.android.gms.internal.ads.zzeo r2 = r0.zzl
            r2.zzc()
            boolean r2 = r3.zzo
            boolean r3 = r1.zzo
            if (r2 == r3) goto L_0x04f5
            java.util.concurrent.CopyOnWriteArraySet r2 = r0.zzm
            java.util.Iterator r2 = r2.iterator()
        L_0x04e3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04f5
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.ads.zzii r3 = (com.google.android.gms.internal.ads.zzii) r3
            boolean r4 = r1.zzo
            r3.zza(r4)
            goto L_0x04e3
        L_0x04f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzam(com.google.android.gms.internal.ads.zzlc, int, int, boolean, int, long, int, boolean):void");
    }

    /* access modifiers changed from: private */
    public final void zzan() {
        int zzf2 = zzf();
        if (zzf2 == 2 || zzf2 == 3) {
            zzao();
            boolean z2 = this.zzad.zzo;
            zzv();
            zzv();
        }
    }

    private final void zzao() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", new Object[]{Thread.currentThread().getName(), this.zzs.getThread().getName()});
            if (!this.zzY) {
                if (this.zzZ) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzer.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzZ = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    public final void zzA(zzlv zzlv) {
        zzao();
        this.zzr.zzO(zzlv);
    }

    public final void zzB(zztq zztq) {
        boolean z2;
        zzao();
        List singletonList = Collections.singletonList(zztq);
        zzao();
        zzao();
        zzX(this.zzad);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                this.zzo.remove(i2);
            }
            this.zzah = this.zzah.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < singletonList.size(); i3++) {
            zzkz zzkz = new zzkz((zztq) singletonList.get(i3), this.zzp);
            arrayList.add(zzkz);
            this.zzo.add(i3, new zzjw(zzkz.zzb, zzkz.zza.zzB()));
        }
        this.zzah = this.zzah.zzg(0, arrayList.size());
        zzlg zzlg = new zzlg(this.zzo, this.zzah);
        if (zzlg.zzo() || zzlg.zzc() >= 0) {
            int zzg2 = zzlg.zzg(false);
            zzlc zzae2 = zzae(this.zzad, zzlg, zzad(zzlg, zzg2, -9223372036854775807L));
            int i4 = zzae2.zze;
            if (!(zzg2 == -1 || i4 == 1)) {
                i4 = 4;
                if (!zzlg.zzo() && zzg2 < zzlg.zzc()) {
                    i4 = 2;
                }
            }
            zzlc zzg3 = zzae2.zzg(i4);
            this.zzk.zzq(arrayList, zzg2, zzfj.zzo(-9223372036854775807L), this.zzah);
            if (this.zzad.zzb.zza.equals(zzg3.zzb.zza) || this.zzad.zza.zzo()) {
                z2 = false;
            } else {
                z2 = true;
            }
            zzam(zzg3, 0, 1, z2, 4, zzaa(zzg3), -1, false);
            return;
        }
        throw new zzan(zzlg, -1, -9223372036854775807L);
    }

    public final zzih zzE() {
        zzao();
        return this.zzad.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(zzkf zzkf) {
        long j2;
        boolean z2;
        boolean z3;
        int i2 = this.zzC - zzkf.zzb;
        this.zzC = i2;
        boolean z4 = true;
        if (zzkf.zzc) {
            this.zzD = zzkf.zzd;
            this.zzE = true;
        }
        if (zzkf.zze) {
            this.zzF = zzkf.zzf;
        }
        if (i2 == 0) {
            zzcw zzcw = zzkf.zza.zza;
            if (!this.zzad.zza.zzo() && zzcw.zzo()) {
                this.zzae = -1;
                this.zzaf = 0;
            }
            if (!zzcw.zzo()) {
                List zzw2 = ((zzlg) zzcw).zzw();
                if (zzw2.size() == this.zzo.size()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzdy.zzf(z3);
                for (int i3 = 0; i3 < zzw2.size(); i3++) {
                    ((zzjw) this.zzo.get(i3)).zzb = (zzcw) zzw2.get(i3);
                }
            }
            if (this.zzE) {
                if (zzkf.zza.zzb.equals(this.zzad.zzb) && zzkf.zza.zzd == this.zzad.zzr) {
                    z4 = false;
                }
                if (!z4) {
                    j2 = -9223372036854775807L;
                } else if (zzcw.zzo() || zzkf.zza.zzb.zzb()) {
                    j2 = zzkf.zza.zzd;
                } else {
                    zzlc zzlc = zzkf.zza;
                    zzto zzto = zzlc.zzb;
                    j2 = zzlc.zzd;
                    zzac(zzcw, zzto, j2);
                }
                z2 = z4;
            } else {
                j2 = -9223372036854775807L;
                z2 = false;
            }
            this.zzE = false;
            zzam(zzkf.zza, 1, this.zzF, z2, this.zzD, j2, -1, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzkf zzkf) {
        this.zzj.zzh(new zzjd(this, zzkf));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzV(zzcm zzcm) {
        zzcm.zza(this.zzH);
    }

    public final void zza(int i2, long j2, int i3, boolean z2) {
        boolean z3;
        zzao();
        if (i2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zzr.zzu();
        zzcw zzcw = this.zzad.zza;
        if (zzcw.zzo() || i2 < zzcw.zzc()) {
            this.zzC++;
            if (zzx()) {
                zzer.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkf zzkf = new zzkf(this.zzad);
                zzkf.zza(1);
                this.zzag.zza.zzU(zzkf);
                return;
            }
            zzlc zzlc = this.zzad;
            int i4 = zzlc.zze;
            if (i4 == 3 || (i4 == 4 && !zzcw.zzo())) {
                zzlc = this.zzad.zzg(2);
            }
            int zzd2 = zzd();
            zzlc zzae2 = zzae(zzlc, zzcw, zzad(zzcw, i2, j2));
            this.zzk.zzl(zzcw, i2, zzfj.zzo(j2));
            zzam(zzae2, 0, 1, true, 1, zzaa(zzae2), zzd2, false);
        }
    }

    public final int zzb() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzb;
        }
        return -1;
    }

    public final int zzc() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzc;
        }
        return -1;
    }

    public final int zzd() {
        zzao();
        int zzX2 = zzX(this.zzad);
        if (zzX2 == -1) {
            return 0;
        }
        return zzX2;
    }

    public final int zze() {
        zzao();
        if (this.zzad.zza.zzo()) {
            return 0;
        }
        zzlc zzlc = this.zzad;
        return zzlc.zza.zza(zzlc.zzb.zza);
    }

    public final int zzf() {
        zzao();
        return this.zzad.zze;
    }

    public final int zzg() {
        zzao();
        return this.zzad.zzm;
    }

    public final int zzh() {
        zzao();
        return 0;
    }

    public final long zzi() {
        zzao();
        if (zzx()) {
            zzlc zzlc = this.zzad;
            if (zzlc.zzk.equals(zzlc.zzb)) {
                return zzfj.zzq(this.zzad.zzp);
            }
            return zzl();
        }
        zzao();
        if (this.zzad.zza.zzo()) {
            return this.zzaf;
        }
        zzlc zzlc2 = this.zzad;
        long j2 = 0;
        if (zzlc2.zzk.zzd != zzlc2.zzb.zzd) {
            return zzfj.zzq(zzlc2.zza.zze(zzd(), this.zza, 0).zzn);
        }
        long j3 = zzlc2.zzp;
        if (this.zzad.zzk.zzb()) {
            zzlc zzlc3 = this.zzad;
            zzlc3.zza.zzn(zzlc3.zzk.zza, this.zzn).zzi(this.zzad.zzk.zzb);
        } else {
            j2 = j3;
        }
        zzlc zzlc4 = this.zzad;
        zzac(zzlc4.zza, zzlc4.zzk, j2);
        return zzfj.zzq(j2);
    }

    public final long zzj() {
        zzao();
        return zzZ(this.zzad);
    }

    public final long zzk() {
        zzao();
        return zzfj.zzq(zzaa(this.zzad));
    }

    public final long zzl() {
        zzao();
        if (!zzx()) {
            zzcw zzn2 = zzn();
            if (zzn2.zzo()) {
                return -9223372036854775807L;
            }
            return zzfj.zzq(zzn2.zze(zzd(), this.zza, 0).zzn);
        }
        zzlc zzlc = this.zzad;
        zzto zzto = zzlc.zzb;
        zzlc.zza.zzn(zzto.zza, this.zzn);
        return zzfj.zzq(this.zzn.zzh(zzto.zzb, zzto.zzc));
    }

    public final long zzm() {
        zzao();
        return zzfj.zzq(this.zzad.zzq);
    }

    public final zzcw zzn() {
        zzao();
        return this.zzad.zza;
    }

    public final zzdh zzo() {
        zzao();
        return this.zzad.zzi.zzd;
    }

    public final void zzp() {
        zzao();
        boolean zzv2 = zzv();
        int i2 = 2;
        int zzb2 = this.zzy.zzb(zzv2, 2);
        zzal(zzv2, zzb2, zzY(zzv2, zzb2));
        zzlc zzlc = this.zzad;
        if (zzlc.zze == 1) {
            zzlc zzf2 = zzlc.zzf((zzih) null);
            if (true == zzf2.zza.zzo()) {
                i2 = 4;
            }
            zzlc zzg2 = zzf2.zzg(i2);
            this.zzC++;
            this.zzk.zzk();
            zzam(zzg2, 1, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void zzq() {
        AudioTrack audioTrack;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfj.zze;
        String zza = zzbq.zza();
        zzer.zze("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.1.0-beta01] [" + str + "] [" + zza + "]");
        zzao();
        if (zzfj.zza < 21 && (audioTrack = this.zzM) != null) {
            audioTrack.release();
            this.zzM = null;
        }
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzeo zzeo = this.zzl;
            zzeo.zzd(10, zzje.zza);
            zzeo.zzc();
        }
        this.zzl.zze();
        this.zzj.zze((Object) null);
        this.zzt.zzf(this.zzr);
        zzlc zzlc = this.zzad;
        if (zzlc.zzo) {
            this.zzad = zzlc.zzb();
        }
        zzlc zzg2 = this.zzad.zzg(1);
        this.zzad = zzg2;
        zzlc zzc2 = zzg2.zzc(zzg2.zzb);
        this.zzad = zzc2;
        zzc2.zzp = zzc2.zzr;
        this.zzad.zzq = 0;
        this.zzr.zzN();
        this.zzi.zzi();
        Surface surface = this.zzO;
        if (surface != null) {
            surface.release();
            this.zzO = null;
        }
        this.zzX = zzdx.zza;
    }

    public final void zzr(boolean z2) {
        zzao();
        int zzb2 = this.zzy.zzb(z2, zzf());
        zzal(z2, zzb2, zzY(z2, zzb2));
    }

    public final void zzs(Surface surface) {
        int i2;
        zzao();
        zzaj(surface);
        if (surface == null) {
            i2 = 0;
        } else {
            i2 = -1;
        }
        zzag(i2, i2);
    }

    public final void zzt(float f2) {
        zzao();
        float max = Math.max(0.0f, Math.min(f2, 1.0f));
        if (this.zzV != max) {
            this.zzV = max;
            zzai();
            zzeo zzeo = this.zzl;
            zzeo.zzd(22, new zzjg(max));
            zzeo.zzc();
        }
    }

    public final void zzu() {
        zzao();
        this.zzy.zzb(zzv(), 1);
        zzak((zzih) null);
        this.zzX = new zzdx(zzfsc.zzl(), this.zzad.zzr);
    }

    public final boolean zzv() {
        zzao();
        return this.zzad.zzl;
    }

    public final boolean zzw() {
        zzao();
        return false;
    }

    public final boolean zzx() {
        zzao();
        return this.zzad.zzb.zzb();
    }

    public final int zzy() {
        zzao();
        int length = this.zzh.length;
        return 2;
    }

    public final void zzz(zzlv zzlv) {
        this.zzr.zzt(zzlv);
    }
}
