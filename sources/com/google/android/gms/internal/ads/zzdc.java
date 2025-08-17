package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class zzdc {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzfsc zzh;
    /* access modifiers changed from: private */
    public final zzfsc zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzfsc zzl;
    /* access modifiers changed from: private */
    public zzfsc zzm;
    /* access modifiers changed from: private */
    public int zzn;
    /* access modifiers changed from: private */
    public final HashMap zzo;
    /* access modifiers changed from: private */
    public final HashSet zzp;

    @Deprecated
    public zzdc() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfsc.zzl();
        this.zzi = zzfsc.zzl();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfsc.zzl();
        this.zzm = zzfsc.zzl();
        this.zzn = 0;
        this.zzo = new HashMap();
        this.zzp = new HashSet();
    }

    public final zzdc zzd(Context context) {
        CaptioningManager captioningManager;
        if ((zzfj.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzn = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzm = zzfsc.zzm(zzfj.zzx(locale));
            }
        }
        return this;
    }

    public zzdc zze(int i2, int i3, boolean z2) {
        this.zze = i2;
        this.zzf = i3;
        this.zzg = true;
        return this;
    }

    protected zzdc(zzdd zzdd) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzdd.zzl;
        this.zzf = zzdd.zzm;
        this.zzg = zzdd.zzn;
        this.zzh = zzdd.zzo;
        this.zzi = zzdd.zzq;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzdd.zzu;
        this.zzm = zzdd.zzw;
        this.zzn = zzdd.zzx;
        this.zzp = new HashSet(zzdd.zzD);
        this.zzo = new HashMap(zzdd.zzC);
    }
}
