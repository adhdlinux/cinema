package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;

public final class zzcbo extends FrameLayout implements zzcbf {
    final zzccc zza;
    private final zzcca zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbce zze;
    private final long zzf;
    private final zzcbg zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    /* JADX WARNING: type inference failed for: r13v0, types: [android.view.View, com.google.android.gms.internal.ads.zzcbg] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.google.android.gms.internal.ads.zzcbe] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.google.android.gms.internal.ads.zzccs] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcbo(android.content.Context r16, com.google.android.gms.internal.ads.zzcca r17, int r18, boolean r19, com.google.android.gms.internal.ads.zzbce r20, com.google.android.gms.internal.ads.zzcbz r21) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r20
            r15.<init>(r16)
            r7 = r17
            r0.zzb = r7
            r0.zze = r9
            android.widget.FrameLayout r10 = new android.widget.FrameLayout
            r10.<init>(r8)
            r0.zzc = r10
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r11 = -1
            r1.<init>(r11, r11)
            r15.addView(r10, r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzj()
            com.google.android.gms.internal.ads.zzcbh r1 = r1.zza
            com.google.android.gms.internal.ads.zzccb r12 = new com.google.android.gms.internal.ads.zzccb
            com.google.android.gms.internal.ads.zzbzx r3 = r17.zzn()
            java.lang.String r4 = r17.zzbm()
            com.google.android.gms.internal.ads.zzbcb r6 = r17.zzk()
            r1 = r12
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = 2
            r2 = r18
            if (r2 != r1) goto L_0x005a
            com.google.android.gms.internal.ads.zzccs r13 = new com.google.android.gms.internal.ads.zzccs
            boolean r6 = com.google.android.gms.internal.ads.zzcbh.zza(r17)
            r1 = r13
            r2 = r16
            r3 = r12
            r4 = r17
            r5 = r19
            r7 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0082
        L_0x005a:
            com.google.android.gms.internal.ads.zzcbe r13 = new com.google.android.gms.internal.ads.zzcbe
            boolean r12 = com.google.android.gms.internal.ads.zzcbh.zza(r17)
            com.google.android.gms.internal.ads.zzccb r14 = new com.google.android.gms.internal.ads.zzccb
            com.google.android.gms.internal.ads.zzbzx r3 = r17.zzn()
            java.lang.String r4 = r17.zzbm()
            com.google.android.gms.internal.ads.zzbcb r6 = r17.zzk()
            r1 = r14
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = r13
            r3 = r17
            r4 = r19
            r5 = r12
            r6 = r21
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
        L_0x0082:
            r0.zzg = r13
            android.view.View r1 = new android.view.View
            r1.<init>(r8)
            r0.zzd = r1
            r2 = 0
            r1.setBackgroundColor(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r11, r11, r3)
            r10.addView(r13, r2)
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzF
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b6
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r11, r11)
            r10.addView(r1, r2)
            r10.bringChildToFront(r1)
        L_0x00b6:
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzC
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00cb
            r15.zzn()
        L_0x00cb:
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r8)
            r0.zzq = r1
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzI
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.zzf = r1
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzE
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.zzk = r1
            if (r9 == 0) goto L_0x0105
            r2 = 1
            if (r2 == r1) goto L_0x00fe
            java.lang.String r1 = "0"
            goto L_0x0100
        L_0x00fe:
            java.lang.String r1 = "1"
        L_0x0100:
            java.lang.String r2 = "spinner_used"
            r9.zzd(r2, r1)
        L_0x0105:
            com.google.android.gms.internal.ads.zzccc r1 = new com.google.android.gms.internal.ads.zzccc
            r1.<init>(r15)
            r0.zza = r1
            r13.zzr(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbo.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcca, int, boolean, com.google.android.gms.internal.ads.zzbce, com.google.android.gms.internal.ads.zzcbz):void");
    }

    private final void zzJ() {
        if (this.zzb.zzi() != null && this.zzi && !this.zzj) {
            this.zzb.zzi().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl2 = zzl();
        if (zzl2 != null) {
            hashMap.put("playerId", zzl2.toString());
        }
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            zzcbg zzcbg = this.zzg;
            if (zzcbg != null) {
                zzcae.zze.execute(new zzcbi(zzcbg));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        zzs.zza.post(new zzcbj(this, z2));
    }

    public final void onWindowVisibilityChanged(int i2) {
        boolean z2;
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            this.zza.zzb();
            z2 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z2 = false;
        }
        zzs.zza.post(new zzcbn(this, z2));
    }

    public final void zzA(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzz(i2);
        }
    }

    public final void zzB(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzA(i2);
        }
    }

    public final void zzC(int i2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzF)).booleanValue()) {
            this.zzc.setBackgroundColor(i2);
            this.zzd.setBackgroundColor(i2);
        }
    }

    public final void zzD(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzB(i2);
        }
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i2, int i3, int i4, int i5) {
        if (zze.zzc()) {
            zze.zza("Set video bounds to x:" + i2 + ";y:" + i3 + ";w:" + i4 + ";h:" + i5);
        }
        if (i4 != 0 && i5 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.setMargins(i2, i3, 0, 0);
            this.zzc.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzG(float f2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzb.zze(f2);
            zzcbg.zzn();
        }
    }

    public final void zzH(float f2, float f3) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzu(f2, f3);
        }
    }

    public final void zzI() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzb.zzd(false);
            zzcbg.zzn();
        }
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbL)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    public final void zzb(String str, String str2) {
        zzK(MRAIDPresenter.ERROR, "what", str, "extra", str2);
    }

    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    public final void zze() {
        boolean z2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbL)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            if ((this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.zzj = z2;
            if (!z2) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzf() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null && this.zzm == 0) {
            zzK("canplaythrough", "duration", String.valueOf(((float) zzcbg.zzc()) / 1000.0f), "videoWidth", String.valueOf(this.zzg.zze()), "videoHeight", String.valueOf(this.zzg.zzd()));
        }
    }

    public final void zzg() {
        this.zzd.setVisibility(4);
        zzs.zza.post(new zzcbk(this));
    }

    public final void zzh() {
        this.zza.zzb();
        zzs.zza.post(new zzcbl(this));
    }

    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        zzs.zza.post(new zzcbm(this));
    }

    public final void zzj(int i2, int i3) {
        if (this.zzk) {
            zzbbe zzbbe = zzbbm.zzH;
            int max = Math.max(i2 / ((Integer) zzba.zzc().zzb(zzbbe)).intValue(), 1);
            int max2 = Math.max(i3 / ((Integer) zzba.zzc().zzb(zzbbe)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg != null && this.zzp != null) {
            long elapsedRealtime = zzt.zzB().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = zzt.zzB().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                zze.zza("Spinner frame grab took " + elapsedRealtime2 + "ms");
            }
            if (elapsedRealtime2 > this.zzf) {
                zzbzr.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbce zzbce = this.zze;
                if (zzbce != null) {
                    zzbce.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final Integer zzl() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            return zzcbg.zzw();
        }
        return null;
    }

    public final void zzn() {
        String str;
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            TextView textView = new TextView(zzcbg.getContext());
            Resources zzd2 = zzt.zzo().zzd();
            if (zzd2 == null) {
                str = "AdMob - ";
            } else {
                str = zzd2.getString(R.string.watermark_label_prefix);
            }
            textView.setText(String.valueOf(str).concat(this.zzg.zzj()));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzc.bringChildToFront(textView);
        }
    }

    public final void zzo() {
        this.zza.zza();
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzt();
        }
        zzJ();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(boolean z2) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z2));
    }

    public final void zzr(Integer num) {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzC(this.zzn, this.zzo, num);
            } else {
                zzK("no_src", new String[0]);
            }
        }
    }

    public final void zzs() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzb.zzd(true);
            zzcbg.zzn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            long zza2 = (long) zzcbg.zza();
            if (this.zzl != zza2 && zza2 > 0) {
                float f2 = ((float) zza2) / 1000.0f;
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue()) {
                    zzK("timeupdate", "time", String.valueOf(f2), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(zzt.zzB().currentTimeMillis()));
                } else {
                    zzK("timeupdate", "time", String.valueOf(f2));
                }
                this.zzl = zza2;
            }
        }
    }

    public final void zzu() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzo();
        }
    }

    public final void zzv() {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzp();
        }
    }

    public final void zzw(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzq(i2);
        }
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzy(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzx(i2);
        }
    }

    public final void zzz(int i2) {
        zzcbg zzcbg = this.zzg;
        if (zzcbg != null) {
            zzcbg.zzy(i2);
        }
    }
}
