package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzcem extends zzcbr implements zzhg, zzlv {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdx zzc;
    private final zzwy zzd;
    private final zzcbz zze;
    private final WeakReference zzf;
    private final zzuu zzg;
    private zzis zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcbq zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private final Object zzq = new Object();
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcdz zzt;
    private final Set zzu = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e3, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzbJ)).booleanValue() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e7, code lost:
        if (r5.zzj == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e9, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ec, code lost:
        if (r5.zzm == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ee, code lost:
        r6 = new com.google.android.gms.internal.ads.zzced(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        if (r5.zzi <= 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcee(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcef(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0105, code lost:
        if (r5.zzj == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        r5 = new com.google.android.gms.internal.ads.zzceg(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x010e, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010f, code lost:
        r4 = r3.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r4 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r4.limit() <= 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        r4 = new byte[r3.zzi.limit()];
        r3.zzi.get(r4);
        r5 = new com.google.android.gms.internal.ads.zzceh(r5, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcem(android.content.Context r4, com.google.android.gms.internal.ads.zzcbz r5, com.google.android.gms.internal.ads.zzcca r6, java.lang.Integer r7) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.zzq = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.zzu = r0
            r3.zzb = r4
            r3.zze = r5
            r3.zzr = r7
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            r7.<init>(r6)
            r3.zzf = r7
            com.google.android.gms.internal.ads.zzcdx r7 = new com.google.android.gms.internal.ads.zzcdx
            r7.<init>()
            r3.zzc = r7
            com.google.android.gms.internal.ads.zzwy r0 = new com.google.android.gms.internal.ads.zzwy
            r0.<init>(r4)
            r3.zzd = r0
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "SimpleExoPlayerAdapter initialize "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r1)
        L_0x003f:
            java.util.concurrent.atomic.AtomicInteger r1 = com.google.android.gms.internal.ads.zzcbr.zzD()
            r1.incrementAndGet()
            com.google.android.gms.internal.ads.zzln r1 = new com.google.android.gms.internal.ads.zzln
            com.google.android.gms.internal.ads.zzcei r2 = new com.google.android.gms.internal.ads.zzcei
            r2.<init>(r3)
            r1.<init>(r4, r2)
            r1.zzb(r0)
            r1.zza(r7)
            com.google.android.gms.internal.ads.zzlo r7 = r1.zzc()
            r3.zzh = r7
            r7.zzz(r3)
            r7 = 0
            r3.zzl = r7
            r0 = 0
            r3.zzn = r0
            r3.zzm = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.zzs = r0
            r0 = 0
            r3.zzt = r0
            if (r6 == 0) goto L_0x0078
            java.lang.String r0 = r6.zzbl()
        L_0x0078:
            com.google.android.gms.internal.ads.zzfpd r0 = com.google.android.gms.internal.ads.zzfpd.zzd(r0)
            java.lang.String r1 = ""
            java.lang.Object r0 = r0.zzb(r1)
            java.lang.String r0 = (java.lang.String) r0
            r3.zzo = r0
            if (r6 == 0) goto L_0x008d
            int r0 = r6.zzf()
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            r3.zzp = r0
            com.google.android.gms.internal.ads.zzuu r0 = new com.google.android.gms.internal.ads.zzuu
            com.google.android.gms.ads.internal.util.zzs r1 = com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.internal.ads.zzbzx r6 = r6.zzn()
            java.lang.String r6 = r6.zza
            java.lang.String r4 = r1.zzc(r4, r6)
            boolean r6 = r3.zzj
            if (r6 == 0) goto L_0x00c0
            java.nio.ByteBuffer r6 = r3.zzi
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x00c0
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r5 = r3.zzi
            r5.get(r4)
            com.google.android.gms.internal.ads.zzceb r5 = new com.google.android.gms.internal.ads.zzceb
            r5.<init>(r4)
            goto L_0x012c
        L_0x00c0:
            com.google.android.gms.internal.ads.zzbbe r6 = com.google.android.gms.internal.ads.zzbbm.zzbR
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r1.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1 = 1
            if (r6 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbbe r6 = com.google.android.gms.internal.ads.zzbbm.zzbJ
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r2.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00e9
        L_0x00e5:
            boolean r6 = r5.zzj
            if (r6 != 0) goto L_0x00ea
        L_0x00e9:
            r7 = 1
        L_0x00ea:
            boolean r6 = r5.zzm
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzced r6 = new com.google.android.gms.internal.ads.zzced
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00f4:
            int r6 = r5.zzi
            if (r6 <= 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzcee r6 = new com.google.android.gms.internal.ads.zzcee
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.internal.ads.zzcef r6 = new com.google.android.gms.internal.ads.zzcef
            r6.<init>(r3, r4, r7)
        L_0x0103:
            boolean r4 = r5.zzj
            if (r4 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzceg r4 = new com.google.android.gms.internal.ads.zzceg
            r4.<init>(r3, r6)
            r5 = r4
            goto L_0x010f
        L_0x010e:
            r5 = r6
        L_0x010f:
            java.nio.ByteBuffer r4 = r3.zzi
            if (r4 == 0) goto L_0x012c
            int r4 = r4.limit()
            if (r4 <= 0) goto L_0x012c
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r6 = r3.zzi
            r6.get(r4)
            com.google.android.gms.internal.ads.zzceh r6 = new com.google.android.gms.internal.ads.zzceh
            r6.<init>(r5, r4)
            r5 = r6
        L_0x012c:
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzo
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r6.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0141
            com.google.android.gms.internal.ads.zzcek r4 = com.google.android.gms.internal.ads.zzcek.zza
            goto L_0x0143
        L_0x0141:
            com.google.android.gms.internal.ads.zzcel r4 = com.google.android.gms.internal.ads.zzcel.zza
        L_0x0143:
            com.google.android.gms.internal.ads.zzut r6 = new com.google.android.gms.internal.ads.zzut
            r6.<init>(r4)
            r0.<init>(r5, r6)
            r3.zzg = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcem.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbz, com.google.android.gms.internal.ads.zzcca, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzcbr.zzD().decrementAndGet();
        if (zze.zzc()) {
            zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzad()) {
            return (long) this.zzl;
        }
        return 0;
    }

    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j2 = this.zzn;
                Map zze2 = ((zzhb) this.zzs.remove(0)).zze();
                long j3 = 0;
                if (zze2 != null) {
                    Iterator it2 = zze2.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it2.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfon.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j3 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j2 + j3;
            }
        }
        return this.zzn;
    }

    public final Integer zzC() {
        return this.zzr;
    }

    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z2) {
        zztq zztq;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z2;
            int length = uriArr.length;
            if (length == 1) {
                zztq = zzaa(uriArr[0]);
            } else {
                zztq[] zztqArr = new zztq[length];
                for (int i2 = 0; i2 < uriArr.length; i2++) {
                    zztqArr[i2] = zzaa(uriArr[i2]);
                }
                zztq = new zzug(false, false, zztqArr);
            }
            this.zzh.zzB(zztq);
            this.zzh.zzp();
            zzcbr.zzE().incrementAndGet();
        }
    }

    public final void zzH() {
        zzis zzis = this.zzh;
        if (zzis != null) {
            zzis.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzcbr.zzE().decrementAndGet();
        }
    }

    public final void zzI(long j2) {
        zzm zzm2 = (zzm) this.zzh;
        zzm2.zza(zzm2.zzd(), j2, 5, false);
    }

    public final void zzJ(int i2) {
        this.zzc.zzk(i2);
    }

    public final void zzK(int i2) {
        this.zzc.zzl(i2);
    }

    public final void zzL(zzcbq zzcbq) {
        this.zzk = zzcbq;
    }

    public final void zzM(int i2) {
        this.zzc.zzm(i2);
    }

    public final void zzN(int i2) {
        this.zzc.zzn(i2);
    }

    public final void zzO(boolean z2) {
        this.zzh.zzr(z2);
    }

    public final void zzP(Integer num) {
        this.zzr = num;
    }

    public final void zzQ(boolean z2) {
        if (this.zzh != null) {
            int i2 = 0;
            while (true) {
                this.zzh.zzy();
                if (i2 < 2) {
                    zzwy zzwy = this.zzd;
                    zzwk zzc2 = zzwy.zzd().zzc();
                    zzc2.zzo(i2, !z2);
                    zzwy.zzk(zzc2);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzR(int i2) {
        for (WeakReference weakReference : this.zzu) {
            zzcdw zzcdw = (zzcdw) weakReference.get();
            if (zzcdw != null) {
                zzcdw.zzm(i2);
            }
        }
    }

    public final void zzS(Surface surface, boolean z2) {
        zzis zzis = this.zzh;
        if (zzis != null) {
            zzis.zzs(surface);
        }
    }

    public final void zzT(float f2, boolean z2) {
        zzis zzis = this.zzh;
        if (zzis != null) {
            zzis.zzt(f2);
        }
    }

    public final void zzU() {
        this.zzh.zzu();
    }

    public final boolean zzV() {
        return this.zzh != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzW(String str, boolean z2) {
        zzcbz zzcbz = this.zze;
        return new zzcep(str, true != z2 ? null : this, zzcbz.zzd, zzcbz.zzf, zzcbz.zzn, zzcbz.zzo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzX(String str, boolean z2) {
        zzcem zzcem;
        zzcbz zzcbz = this.zze;
        int i2 = zzcbz.zzd;
        int i3 = zzcbz.zzf;
        int i4 = zzcbz.zzi;
        if (true != z2) {
            zzcem = null;
        } else {
            zzcem = this;
        }
        zzcdw zzcdw = new zzcdw(str, zzcem, i2, i3, i4);
        this.zzu.add(new WeakReference(zzcdw));
        return zzcdw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzY(String str, boolean z2) {
        zzcem zzcem;
        zzgm zzgm = new zzgm();
        zzgm.zzf(str);
        if (true != z2) {
            zzcem = null;
        } else {
            zzcem = this;
        }
        zzgm.zze(zzcem);
        zzgm.zzc(this.zze.zzd);
        zzgm.zzd(this.zze.zzf);
        zzgm.zzb(true);
        return zzgm.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzZ(zzgd zzgd) {
        return new zzcdz(this.zzb, zzgd.zza(), this.zzo, this.zzp, this, new zzcec(this));
    }

    public final void zza(zzge zzge, zzgj zzgj, boolean z2, int i2) {
        this.zzl += i2;
    }

    /* access modifiers changed from: package-private */
    public final zztq zzaa(Uri uri) {
        zzar zzar = new zzar();
        zzar.zzb(uri);
        zzbp zzc2 = zzar.zzc();
        zzuu zzuu = this.zzg;
        zzuu.zza(this.zze.zzg);
        return zzuu.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(boolean z2, long j2) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq != null) {
            zzcbq.zzi(z2, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzli[] zzac(Handler handler, zzzr zzzr, zzot zzot, zzvq zzvq, zzso zzso) {
        Context context = this.zzb;
        zzry zzry = zzry.zzb;
        zzoe zzoe = zzoe.zza;
        zzdr[] zzdrArr = new zzdr[0];
        zzpn zzpn = new zzpn();
        if (zzoe == null && zzoe == null) {
            throw new NullPointerException("Both parameters are null");
        }
        zzpn.zzc(zzoe);
        zzpn.zzd(zzdrArr);
        zzpz zze2 = zzpn.zze();
        zzro zzro = zzro.zza;
        return new zzli[]{new zzqf(context, zzro, zzry, false, handler, zzot, zze2), new zzyu(this.zzb, zzro, zzry, 0, false, handler, zzzr, -1, 30.0f)};
    }

    public final void zzb(zzge zzge, zzgj zzgj, boolean z2) {
    }

    public final void zzc(zzge zzge, zzgj zzgj, boolean z2) {
    }

    public final void zzd(zzge zzge, zzgj zzgj, boolean z2) {
        if (zzge instanceof zzhb) {
            synchronized (this.zzq) {
                this.zzs.add((zzhb) zzge);
            }
        } else if (zzge instanceof zzcdz) {
            this.zzt = (zzcdz) zzge;
            zzcca zzcca = (zzcca) this.zzf.get();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzcca != null && this.zzt.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                zzs.zza.post(new zzcej(zzcca, hashMap));
            }
        }
    }

    public final void zze(zzlt zzlt, zzam zzam, zzia zzia) {
        zzcca zzcca = (zzcca) this.zzf.get();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzcca != null && zzam != null) {
            HashMap hashMap = new HashMap();
            String str = zzam.zzl;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzam.zzm;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzam.zzj;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzcca.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzlt zzlt, int i2, long j2, long j3) {
    }

    public final /* synthetic */ void zzg(zzlt zzlt, zztk zztk) {
    }

    public final void zzh(zzlt zzlt, int i2, long j2) {
        this.zzm += i2;
    }

    public final /* synthetic */ void zzi(zzcp zzcp, zzlu zzlu) {
    }

    public final void zzj(zzlt zzlt, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq == null) {
            return;
        }
        if (this.zze.zzk) {
            zzcbq.zzl("onLoadException", iOException);
        } else {
            zzcbq.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzlt zzlt, int i2) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq != null) {
            zzcbq.zzm(i2);
        }
    }

    public final void zzl(zzlt zzlt, zzcf zzcf) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq != null) {
            zzcbq.zzk("onPlayerError", zzcf);
        }
    }

    public final /* synthetic */ void zzm(zzlt zzlt, zzco zzco, zzco zzco2, int i2) {
    }

    public final void zzn(zzlt zzlt, Object obj, long j2) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq != null) {
            zzcbq.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzlt zzlt, zzhz zzhz) {
    }

    public final void zzp(zzlt zzlt, zzam zzam, zzia zzia) {
        zzcca zzcca = (zzcca) this.zzf.get();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzcca != null && zzam != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzam.zzt));
            hashMap.put("bitRate", String.valueOf(zzam.zzi));
            int i2 = zzam.zzr;
            int i3 = zzam.zzs;
            hashMap.put("resolution", i2 + "x" + i3);
            String str = zzam.zzl;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzam.zzm;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzam.zzj;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzcca.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzlt zzlt, zzdn zzdn) {
        zzcbq zzcbq = this.zzk;
        if (zzcbq != null) {
            zzcbq.zzD(zzdn.zzc, zzdn.zzd);
        }
    }

    public final int zzr() {
        return this.zzm;
    }

    public final int zzt() {
        return this.zzh.zzf();
    }

    public final long zzv() {
        return this.zzh.zzi();
    }

    public final long zzw() {
        return (long) this.zzl;
    }

    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min((long) this.zzl, this.zzt.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzh.zzk();
    }

    public final long zzz() {
        return this.zzh.zzl();
    }
}
