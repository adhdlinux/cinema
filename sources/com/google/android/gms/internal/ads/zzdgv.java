package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdgv extends zzcrd {
    public static final zzfsc zzc = zzfsc.zzq("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzauc zzA;
    /* access modifiers changed from: private */
    public zzfwv zzB;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final zzdha zze;
    private final zzdhi zzf;
    private final zzdia zzg;
    private final zzdhf zzh;
    private final zzdhl zzi;
    private final zzgvy zzj;
    private final zzgvy zzk;
    private final zzgvy zzl;
    private final zzgvy zzm;
    private final zzgvy zzn;
    /* access modifiers changed from: private */
    public zzdiw zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzbxe zzs;
    private final zzaqs zzt;
    private final zzbzx zzu;
    private final Context zzv;
    private final zzdgx zzw;
    private final zzejp zzx;
    /* access modifiers changed from: private */
    public final Map zzy = new HashMap();
    private final List zzz = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdgv(zzcrc zzcrc, Executor executor, zzdha zzdha, zzdhi zzdhi, zzdia zzdia, zzdhf zzdhf, zzdhl zzdhl, zzgvy zzgvy, zzgvy zzgvy2, zzgvy zzgvy3, zzgvy zzgvy4, zzgvy zzgvy5, zzbxe zzbxe, zzaqs zzaqs, zzbzx zzbzx, Context context, zzdgx zzdgx, zzejp zzejp, zzauc zzauc) {
        super(zzcrc);
        this.zzd = executor;
        this.zze = zzdha;
        this.zzf = zzdhi;
        this.zzg = zzdia;
        this.zzh = zzdhf;
        this.zzi = zzdhl;
        this.zzj = zzgvy;
        this.zzk = zzgvy2;
        this.zzl = zzgvy3;
        this.zzm = zzgvy4;
        this.zzn = zzgvy5;
        this.zzs = zzbxe;
        this.zzt = zzaqs;
        this.zzu = zzbzx;
        this.zzv = context;
        this.zzw = zzdgx;
        this.zzx = zzejp;
        this.zzA = zzauc;
    }

    public static boolean zzW(View view) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjk)).booleanValue()) {
            zzt.zzp();
            long zzs2 = zzs.zzs(view);
            if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                if (zzs2 >= ((long) ((Integer) zzba.zzc().zzb(zzbbm.zzjl)).intValue())) {
                    return true;
                }
            }
            return false;
        } else if (!view.isShown() || !view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            return false;
        } else {
            return true;
        }
    }

    private final synchronized View zzY(Map map) {
        if (map == null) {
            return null;
        }
        zzfsc zzfsc = zzc;
        int size = zzfsc.size();
        int i2 = 0;
        while (i2 < size) {
            WeakReference weakReference = (WeakReference) map.get((String) zzfsc.get(i2));
            i2++;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    private final synchronized ImageView.ScaleType zzZ() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhA)).booleanValue()) {
            return null;
        }
        zzdiw zzdiw = this.zzo;
        if (zzdiw == null) {
            zzbzr.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj2 = zzdiw.zzj();
        if (zzj2 != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj2);
        }
        return zzdia.zza;
    }

    private final void zzaa(String str, boolean z2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            zzfwm zzv2 = this.zze.zzv();
            if (zzv2 != null) {
                this.zzB = zzfwv.zzf();
                zzfwc.zzq(zzv2, new zzdgu(this, "Google", true), this.zzd);
                return;
            }
            return;
        }
        zzt("Google", true);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzZ());
        this.zzq = true;
    }

    private final void zzac(View view, zzfgw zzfgw) {
        zzcez zzq2 = this.zze.zzq();
        if (this.zzh.zzd() && zzfgw != null && zzq2 != null && view != null) {
            zzt.zzA().zzh(zzfgw, view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzad */
    public final synchronized void zzy(zzdiw zzdiw) {
        View view;
        if (!this.zzp) {
            this.zzo = zzdiw;
            this.zzg.zze(zzdiw);
            this.zzf.zzy(zzdiw.zzf(), zzdiw.zzm(), zzdiw.zzn(), zzdiw, zzdiw);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
                this.zzt.zzc().zzo(zzdiw.zzf());
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbE)).booleanValue()) {
                zzezn zzezn = this.zzb;
                if (zzezn.zzal) {
                    Iterator<String> keys = zzezn.zzak.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            WeakReference weakReference = (WeakReference) this.zzo.zzl().get(next);
                            this.zzy.put(next, Boolean.FALSE);
                            if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                                zzaub zzaub = new zzaub(this.zzv, view);
                                this.zzz.add(zzaub);
                                zzaub.zzc(new zzdgt(this, next));
                            }
                        }
                    }
                }
            }
            if (zzdiw.zzi() != null) {
                zzdiw.zzi().zzc(this.zzs);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzz(zzdiw zzdiw) {
        this.zzf.zzz(zzdiw.zzf(), zzdiw.zzl());
        if (zzdiw.zzh() != null) {
            zzdiw.zzh().setClickable(false);
            zzdiw.zzh().removeAllViews();
        }
        if (zzdiw.zzi() != null) {
            zzdiw.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    public static /* synthetic */ void zzq(zzdgv zzdgv) {
        try {
            zzdha zzdha = zzdgv.zze;
            int zzc2 = zzdha.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzbzr.zzg("Wrong native template id!");
                                return;
                            }
                            zzdhl zzdhl = zzdgv.zzi;
                            if (zzdhl.zzg() != null) {
                                zzdhl.zzg().zzg((zzbku) zzdgv.zzm.zzb());
                            }
                        } else if (zzdgv.zzi.zzf() != null) {
                            zzdgv.zzaa("Google", true);
                            zzdgv.zzi.zzf().zze((zzbgo) zzdgv.zzl.zzb());
                        }
                    } else if (zzdgv.zzi.zzd(zzdha.zzz()) != null) {
                        if (zzdgv.zze.zzr() != null) {
                            zzdgv.zzt("Google", true);
                        }
                        zzdgv.zzi.zzd(zzdgv.zze.zzz()).zze((zzbfl) zzdgv.zzn.zzb());
                    }
                } else if (zzdgv.zzi.zza() != null) {
                    zzdgv.zzaa("Google", true);
                    zzdgv.zzi.zza().zze((zzbfg) zzdgv.zzk.zzb());
                }
            } else if (zzdgv.zzi.zzb() != null) {
                zzdgv.zzaa("Google", true);
                zzdgv.zzi.zzb().zze((zzbfi) zzdgv.zzj.zzb());
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("RemoteException when notifyAdLoad is called", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ec, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzA(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzbE     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzezn r0 = r3.zzb     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.zzal     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0045
            java.util.Map r0 = r3.zzy     // Catch:{ all -> 0x00f2 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00f2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00f2 }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00f2 }
            java.util.Map r2 = r3.zzy     // Catch:{ all -> 0x00f2 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00f2 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r1 != 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0045:
            if (r7 != 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzbbe r7 = com.google.android.gms.internal.ads.zzbbm.zzdC     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r7 = r0.zzb(r7)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00f2 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r7 == 0) goto L_0x0088
            if (r5 == 0) goto L_0x0088
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00f2 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00f2 }
        L_0x0063:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00f2 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00f2 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00f2 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0063
            boolean r0 = zzW(r0)     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0063
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x0088:
            monitor-exit(r3)
            return
        L_0x008a:
            android.view.View r7 = r3.zzY(r5)     // Catch:{ all -> 0x00f2 }
            if (r7 != 0) goto L_0x0095
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x0095:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdD     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00b4
            boolean r7 = zzW(r7)     // Catch:{ all -> 0x00f2 }
            if (r7 == 0) goto L_0x00b2
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00b2:
            monitor-exit(r3)
            return
        L_0x00b4:
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdE     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00ed
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ all -> 0x00f2 }
            r0.<init>()     // Catch:{ all -> 0x00f2 }
            r1 = 0
            boolean r1 = r7.getGlobalVisibleRect(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00eb
            int r1 = r7.getHeight()     // Catch:{ all -> 0x00f2 }
            int r2 = r0.height()     // Catch:{ all -> 0x00f2 }
            if (r1 != r2) goto L_0x00eb
            int r7 = r7.getWidth()     // Catch:{ all -> 0x00f2 }
            int r0 = r0.width()     // Catch:{ all -> 0x00f2 }
            if (r7 != r0) goto L_0x00eb
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00eb:
            monitor-exit(r3)
            return
        L_0x00ed:
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00f2:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdgv.zzA(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzB(zzcw zzcw) {
        this.zzf.zzj(zzcw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzC(android.view.View r10, android.view.View r11, java.util.Map r12, java.util.Map r13, boolean r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzdia r0 = r9.zzg     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdiw r1 = r9.zzo     // Catch:{ all -> 0x0035 }
            r0.zzc(r1)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdhi r2 = r9.zzf     // Catch:{ all -> 0x0035 }
            android.widget.ImageView$ScaleType r8 = r9.zzZ()     // Catch:{ all -> 0x0035 }
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.zzk(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0035 }
            boolean r10 = r9.zzr     // Catch:{ all -> 0x0035 }
            if (r10 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzdha r10 = r9.zze     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcez r11 = r10.zzr()     // Catch:{ all -> 0x0035 }
            if (r11 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            com.google.android.gms.internal.ads.zzcez r10 = r10.zzr()     // Catch:{ all -> 0x0035 }
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0035 }
            r11.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r12 = "onSdkAdUserInteractionClick"
            r10.zzd(r12, r11)     // Catch:{ all -> 0x0035 }
            monitor-exit(r9)
            return
        L_0x0033:
            monitor-exit(r9)
            return
        L_0x0035:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdgv.zzC(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzD(View view, int i2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjS)).booleanValue()) {
            zzdiw zzdiw = this.zzo;
            if (zzdiw == null) {
                zzbzr.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                this.zzd.execute(new zzdgl(this, view, zzdiw instanceof zzdhu, i2));
            }
        }
    }

    public final synchronized void zzE(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzF(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzG() {
        zzdiw zzdiw = this.zzo;
        if (zzdiw == null) {
            zzbzr.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzd.execute(new zzdgq(this, zzdiw instanceof zzdhu));
        }
    }

    public final synchronized void zzH() {
        if (!this.zzq) {
            this.zzf.zzr();
        }
    }

    public final void zzI(View view) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            zzfwv zzfwv = this.zzB;
            if (zzfwv != null) {
                zzfwv.zzc(new zzdgm(this, view), this.zzd);
                return;
            }
            return;
        }
        zzac(view, this.zze.zzt());
    }

    public final synchronized void zzJ(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzK(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzL(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzM() {
        this.zzf.zzv();
    }

    public final synchronized void zzN(zzcs zzcs) {
        this.zzf.zzw(zzcs);
    }

    public final synchronized void zzO(zzdg zzdg) {
        this.zzx.zza(zzdg);
    }

    public final synchronized void zzP(zzbgl zzbgl) {
        this.zzf.zzx(zzbgl);
    }

    public final synchronized void zzQ(zzdiw zzdiw) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbC)).booleanValue()) {
            zzs.zza.post(new zzdgr(this, zzdiw));
        } else {
            zzy(zzdiw);
        }
    }

    public final synchronized void zzR(zzdiw zzdiw) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbC)).booleanValue()) {
            zzs.zza.post(new zzdgn(this, zzdiw));
        } else {
            zzz(zzdiw);
        }
    }

    public final boolean zzS() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzT() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzU() {
        return this.zzf.zzB();
    }

    public final boolean zzV() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzX(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzC = this.zzf.zzC(bundle);
        this.zzq = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new zzdgs(this));
        super.zzb();
    }

    public final zzdgx zzc() {
        return this.zzw;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzZ());
    }

    public final void zzj() {
        this.zzd.execute(new zzdgo(this));
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            zzdhi zzdhi = this.zzf;
            zzdhi.getClass();
            executor.execute(new zzdgp(zzdhi));
        }
        super.zzj();
    }

    public final synchronized JSONObject zzk(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzZ());
    }

    public final void zzr(View view) {
        zzfgw zzt2 = this.zze.zzt();
        if (this.zzh.zzd() && zzt2 != null && view != null) {
            zzt.zzA().zzf(zzt2, view);
        }
    }

    public final synchronized void zzs() {
        this.zzf.zzh();
    }

    public final void zzt(String str, boolean z2) {
        boolean z3;
        boolean z4;
        String str2;
        zzeca zzeca;
        zzecb zzecb;
        String str3;
        if (this.zzh.zzd() && !TextUtils.isEmpty(str)) {
            zzdha zzdha = this.zze;
            zzcez zzq2 = zzdha.zzq();
            zzcez zzr2 = zzdha.zzr();
            if (zzq2 == null && zzr2 == null) {
                zzbzr.zzj("Omid display and video webview are null. Skipping initialization.");
                return;
            }
            boolean z5 = false;
            if (zzq2 != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (zzr2 != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzeQ)).booleanValue()) {
                this.zzh.zza();
                int zzb = this.zzh.zza().zzb();
                int i2 = zzb - 1;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (zzb == 1) {
                            str3 = "VIDEO";
                        } else if (zzb != 2) {
                            str3 = "UNKNOWN";
                        } else {
                            str3 = "DISPLAY";
                        }
                        zzbzr.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                        return;
                    } else if (zzq2 != null) {
                        z5 = true;
                        z4 = false;
                    } else {
                        zzbzr.zzj("Omid media type was display but there was no display webview.");
                        return;
                    }
                } else if (zzr2 != null) {
                    z4 = true;
                } else {
                    zzbzr.zzj("Omid media type was video but there was no video webview.");
                    return;
                }
            } else {
                z5 = z3;
            }
            if (z5) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzq2 = zzr2;
            }
            String str4 = str2;
            zzq2.zzG();
            if (!zzt.zzA().zzj(this.zzv)) {
                zzbzr.zzj("Failed to initialize omid in InternalNativeAd");
                return;
            }
            zzbzx zzbzx = this.zzu;
            String str5 = zzbzx.zzb + "." + zzbzx.zzc;
            if (z4) {
                zzeca = zzeca.VIDEO;
                zzecb = zzecb.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeca = zzeca.NATIVE_DISPLAY;
                if (this.zze.zzc() == 3) {
                    zzecb = zzecb.UNSPECIFIED;
                } else {
                    zzecb = zzecb.ONE_PIXEL;
                }
            }
            zzfgw zzb2 = zzt.zzA().zzb(str5, zzq2.zzG(), "", "javascript", str4, str, zzecb, zzeca, this.zzb.zzam);
            if (zzb2 == null) {
                zzbzr.zzj("Failed to create omid session in InternalNativeAd");
                return;
            }
            this.zze.zzV(zzb2);
            zzq2.zzap(zzb2);
            if (z4) {
                zzt.zzA().zzh(zzb2, zzr2.zzF());
                this.zzr = true;
            }
            if (z2) {
                zzt.zzA().zzi(zzb2);
                zzq2.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzu() {
        this.zzf.zzi();
        this.zze.zzH();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(View view, boolean z2, int i2) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z2, zzZ(), i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(boolean z2) {
        this.zzf.zzo((View) null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z2, zzZ(), 0);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(View view) {
        zzac(view, this.zze.zzt());
    }
}
