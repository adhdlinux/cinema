package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbyh;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcgu;
import com.google.android.gms.internal.ads.zzdlx;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzfbe;
import com.google.android.gms.internal.ads.zzffm;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfvt;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzfwn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class zzaa extends zzbyh {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final zzbzx zzA;
    /* access modifiers changed from: private */
    public String zzB;
    /* access modifiers changed from: private */
    public final String zzC;
    private final List zzD;
    private final List zzE;
    private final List zzF;
    private final List zzG;
    private final zzcgu zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzaqs zzh;
    private final zzfbe zzi;
    /* access modifiers changed from: private */
    public zzdpv zzj = null;
    private final zzfwn zzk;
    private final ScheduledExecutorService zzl;
    private zzbsr zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final Set zzp = Collections.newSetFromMap(new WeakHashMap());
    private final zzc zzq;
    /* access modifiers changed from: private */
    public final zzdqf zzr;
    /* access modifiers changed from: private */
    public final zzfgr zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final boolean zzv;
    /* access modifiers changed from: private */
    public final boolean zzw;
    /* access modifiers changed from: private */
    public final String zzx;
    /* access modifiers changed from: private */
    public final String zzy;
    /* access modifiers changed from: private */
    public final AtomicInteger zzz = new AtomicInteger(0);

    public zzaa(zzcgu zzcgu, Context context, zzaqs zzaqs, zzfbe zzfbe, zzfwn zzfwn, ScheduledExecutorService scheduledExecutorService, zzdqf zzdqf, zzfgr zzfgr, zzbzx zzbzx) {
        List list;
        this.zzf = zzcgu;
        this.zzg = context;
        this.zzh = zzaqs;
        this.zzi = zzfbe;
        this.zzk = zzfwn;
        this.zzl = scheduledExecutorService;
        this.zzq = zzcgu.zzm();
        this.zzr = zzdqf;
        this.zzs = zzfgr;
        this.zzA = zzbzx;
        this.zzt = ((Boolean) zzba.zzc().zzb(zzbbm.zzgZ)).booleanValue();
        this.zzu = ((Boolean) zzba.zzc().zzb(zzbbm.zzgY)).booleanValue();
        this.zzv = ((Boolean) zzba.zzc().zzb(zzbbm.zzha)).booleanValue();
        this.zzw = ((Boolean) zzba.zzc().zzb(zzbbm.zzhc)).booleanValue();
        this.zzx = (String) zzba.zzc().zzb(zzbbm.zzhb);
        this.zzy = (String) zzba.zzc().zzb(zzbbm.zzhd);
        this.zzC = (String) zzba.zzc().zzb(zzbbm.zzhe);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhf)).booleanValue()) {
            this.zzD = zzX((String) zzba.zzc().zzb(zzbbm.zzhg));
            this.zzE = zzX((String) zzba.zzc().zzb(zzbbm.zzhh));
            this.zzF = zzX((String) zzba.zzc().zzb(zzbbm.zzhi));
            list = zzX((String) zzba.zzc().zzb(zzbbm.zzhj));
        } else {
            this.zzD = zza;
            this.zzE = zzb;
            this.zzF = zzc;
            list = zzd;
        }
        this.zzG = list;
    }

    static /* bridge */ /* synthetic */ void zzF(zzaa zzaa, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (zzaa.zzN((Uri) it2.next())) {
                zzaa.zzz.getAndIncrement();
                return;
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzG(zzaa zzaa, String str, String str2, zzdpv zzdpv) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgK)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzgQ)).booleanValue()) {
                zzcae.zza.execute(new zzi(zzaa, str, str2, zzdpv));
            } else {
                zzaa.zzq.zzd(str, str2, zzdpv);
            }
        }
    }

    static final /* synthetic */ Uri zzP(Uri uri, String str) {
        if (!TextUtils.isEmpty(str)) {
            return zzW(uri, "nas", str);
        }
        return uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzh zzQ(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfag r0 = new com.google.android.gms.internal.ads.zzfag
            r0.<init>()
            java.lang.String r1 = "REWARDED"
            boolean r2 = r1.equals(r10)
            java.lang.String r3 = "REWARDED_INTERSTITIAL"
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzezt r2 = r0.zzo()
            r2.zza(r5)
            goto L_0x0026
        L_0x0019:
            boolean r2 = r3.equals(r10)
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzezt r2 = r0.zzo()
            r2.zza(r4)
        L_0x0026:
            com.google.android.gms.internal.ads.zzcgu r2 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzg r2 = r2.zzn()
            com.google.android.gms.internal.ads.zzcuo r6 = new com.google.android.gms.internal.ads.zzcuo
            r6.<init>()
            r6.zze(r8)
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = "adUnitId"
        L_0x0038:
            r0.zzs(r9)
            if (r12 != 0) goto L_0x0046
            com.google.android.gms.ads.internal.client.zzm r9 = new com.google.android.gms.ads.internal.client.zzm
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzl r12 = r9.zza()
        L_0x0046:
            r0.zzE(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00aa
            int r11 = r10.hashCode()
            r12 = 4
            switch(r11) {
                case -1999289321: goto L_0x0079;
                case -428325382: goto L_0x006f;
                case 543046670: goto L_0x0067;
                case 1854800829: goto L_0x005f;
                case 1951953708: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0083
        L_0x0055:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 0
            goto L_0x0084
        L_0x005f:
            boolean r11 = r10.equals(r3)
            if (r11 == 0) goto L_0x0083
            r11 = 2
            goto L_0x0084
        L_0x0067:
            boolean r11 = r10.equals(r1)
            if (r11 == 0) goto L_0x0083
            r11 = 1
            goto L_0x0084
        L_0x006f:
            java.lang.String r11 = "APP_OPEN_AD"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 4
            goto L_0x0084
        L_0x0079:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 3
            goto L_0x0084
        L_0x0083:
            r11 = -1
        L_0x0084:
            if (r11 == 0) goto L_0x00a3
            if (r11 == r9) goto L_0x009e
            if (r11 == r5) goto L_0x009e
            if (r11 == r4) goto L_0x0099
            if (r11 == r12) goto L_0x0094
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00aa
        L_0x0094:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzb()
            goto L_0x00aa
        L_0x0099:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzc()
            goto L_0x00aa
        L_0x009e:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzd()
            goto L_0x00aa
        L_0x00a3:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
        L_0x00aa:
            r0.zzr(r11)
            r0.zzx(r9)
            com.google.android.gms.internal.ads.zzfai r8 = r0.zzG()
            r6.zzi(r8)
            com.google.android.gms.internal.ads.zzcuq r8 = r6.zzj()
            r2.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzac r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzac
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzae r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzae
            r10 = 0
            r9.<init>(r8, r10)
            r2.zzb(r9)
            com.google.android.gms.internal.ads.zzdar r8 = new com.google.android.gms.internal.ads.zzdar
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzh r8 = r2.zzc()
            com.google.android.gms.internal.ads.zzdpv r9 = r8.zza()
            r7.zzj = r9
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzQ(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl):com.google.android.gms.ads.nonagon.signalgeneration.zzh");
    }

    private final zzfwm zzR(String str) {
        zzdlx[] zzdlxArr = new zzdlx[1];
        zzfwm zzm2 = zzfwc.zzm(this.zzi.zza(), new zzk(this, zzdlxArr, str), this.zzk);
        zzm2.zzc(new zzl(this, zzdlxArr), this.zzk);
        return zzfwc.zze(zzfwc.zzl((zzfvt) zzfwc.zzn(zzfvt.zzv(zzm2), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzhp)).intValue(), TimeUnit.MILLISECONDS, this.zzl), zzv.zza, this.zzk), Exception.class, zzj.zza, this.zzk);
    }

    private final void zzS(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi, boolean z2) {
        zzfwm zzfwm;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            zzbzr.zzj("The updating URL feature is not enabled.");
            try {
                zzbsi.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e2) {
                zzbzr.zzh("", e2);
            }
        } else {
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (zzN((Uri) it2.next())) {
                    i2++;
                }
            }
            if (i2 > 1) {
                zzbzr.zzj("Multiple google urls found: ".concat(String.valueOf(list)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                Uri uri = (Uri) it3.next();
                if (!zzN(uri)) {
                    zzbzr.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    zzfwm = zzfwc.zzh(uri);
                } else {
                    zzfwm = this.zzk.zzb(new zzq(this, uri, iObjectWrapper));
                    if (zzV()) {
                        zzfwm = zzfwc.zzm(zzfwm, new zzr(this), this.zzk);
                    } else {
                        zzbzr.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(zzfwm);
            }
            zzfwc.zzq(zzfwc.zzd(arrayList), new zzy(this, zzbsi, z2), this.zzf.zzA());
        }
    }

    private final void zzT(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi, boolean z2) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            try {
                zzbsi.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e2) {
                zzbzr.zzh("", e2);
            }
        } else {
            zzfwm zzb2 = this.zzk.zzb(new zzs(this, list, iObjectWrapper));
            if (zzV()) {
                zzb2 = zzfwc.zzm(zzb2, new zzt(this), this.zzk);
            } else {
                zzbzr.zzi("Asset view map is empty.");
            }
            zzfwc.zzq(zzb2, new zzx(this, zzbsi, z2), this.zzf.zzA());
        }
    }

    private static boolean zzU(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (path.contains((String) it2.next())) {
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        if (host.endsWith((String) it3.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzV() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzbsr r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzV():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzW(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i2 = indexOf + 1;
        return Uri.parse(uri2.substring(0, i2) + str + "=" + str2 + "&" + uri2.substring(i2));
    }

    private static final List zzX(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfpw.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzffy zzr(zzfwm zzfwm, zzbym zzbym) {
        String str;
        if (!zzfgb.zza() || !((Boolean) zzbcy.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzffy zzb2 = ((zzh) zzfwc.zzo(zzfwm)).zzb();
            zzb2.zzd(new ArrayList(Collections.singletonList(zzbym.zzb)));
            zzl zzl2 = zzbym.zzd;
            if (zzl2 == null) {
                str = "";
            } else {
                str = zzl2.zzp;
            }
            zzb2.zzb(str);
            return zzb2;
        } catch (ExecutionException e2) {
            zzt.zzo().zzu(e2, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Uri uri = (Uri) it2.next();
            if (!zzO(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzW(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        this.zzh.zzc();
        String zzh2 = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        if (!TextUtils.isEmpty(zzh2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzO(uri)) {
                    zzbzr.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzW(uri, "ms", zzh2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(zzdlx[] zzdlxArr) {
        zzdlx zzdlx = zzdlxArr[0];
        if (zzdlx != null) {
            this.zzi.zzb(zzfwc.zzh(zzdlx));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(String str, String str2, zzdpv zzdpv) {
        this.zzq.zzd(str, str2, zzdpv);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzN(Uri uri) {
        return zzU(uri, this.zzD, this.zzE);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(Uri uri) {
        return zzU(uri, this.zzF, this.zzG);
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbym zzbym, zzbyf zzbyf) {
        zzfwm zzfwm;
        zzfwm zzfwm2;
        zzbym zzbym2 = zzbym;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzffn zza2 = zzffm.zza(context, 22);
        zza2.zzh();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjE)).booleanValue()) {
            zzfwn zzfwn = zzcae.zza;
            zzfwm = zzfwn.zzb(new zzo(this, zzbym));
            zzfwm2 = zzfwc.zzm(zzfwm, zzp.zza, zzfwn);
        } else {
            zzh zzQ = zzQ(this.zzg, zzbym2.zza, zzbym2.zzb, zzbym2.zzc, zzbym2.zzd);
            zzfwm = zzfwc.zzh(zzQ);
            zzfwm2 = zzQ.zzc();
        }
        zzfwc.zzq(zzfwm2, new zzw(this, zzfwm, zzbym, zzbyf, zza2, zzt.zzB().currentTimeMillis()), this.zzf.zzA());
    }

    public final void zzf(zzbsr zzbsr) {
        this.zzm = zzbsr;
        this.zzi.zzc(1);
    }

    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) {
        zzS(list, iObjectWrapper, zzbsi, true);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) {
        zzT(list, iObjectWrapper, zzbsi, true);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void zzi(IObjectWrapper iObjectWrapper) {
        zzfwm zzfwm;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziT)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziU)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zzb(zzbbm.zziX)).booleanValue()) {
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzjE)).booleanValue()) {
                        zzfwm = zzfwc.zzk(new zzu(this), zzcae.zza);
                    } else {
                        zzfwm = zzQ(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null).zzc();
                    }
                    zzfwc.zzq(zzfwm, new zzz(this), this.zzf.zzA());
                }
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzbzr.zzg("The webView cannot be null.");
            } else if (this.zzp.contains(webView)) {
                zzbzr.zzi("This webview has already been registered.");
            } else {
                this.zzp.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzr, this.zzs), "gmaSdk");
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzho)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbsr zzbsr = this.zzm;
            if (zzbsr == null) {
                view = null;
            } else {
                view = zzbsr.zza;
            }
            this.zzn = zzbx.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) {
        zzS(list, iObjectWrapper, zzbsi, false);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsi) {
        zzT(list, iObjectWrapper, zzbsi, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzm(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzaqt e2) {
            zzbzr.zzk("", e2);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzh zzq(zzbym zzbym) throws Exception {
        return zzQ(this.zzg, zzbym.zza, zzbym.zzb, zzbym.zzc, zzbym.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzu() throws Exception {
        return zzQ(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null).zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzv(zzdlx[] zzdlxArr, String str, zzdlx zzdlx) throws Exception {
        zzdlxArr[0] = zzdlx;
        Context context = this.zzg;
        zzbsr zzbsr = this.zzm;
        Map map = zzbsr.zzb;
        JSONObject zzd2 = zzbx.zzd(context, map, map, zzbsr.zza, (ImageView.ScaleType) null);
        JSONObject zzg2 = zzbx.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbx.zzf(this.zzm.zza);
        JSONObject zze2 = zzbx.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbx.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdlx.zzd(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzw(ArrayList arrayList) throws Exception {
        return zzfwc.zzl(zzR("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzn(this, arrayList), this.zzk);
    }
}
