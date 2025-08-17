package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzfag {
    /* access modifiers changed from: private */
    public zzl zza;
    /* access modifiers changed from: private */
    public zzq zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzfl zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList zzf;
    /* access modifiers changed from: private */
    public ArrayList zzg;
    /* access modifiers changed from: private */
    public zzbef zzh;
    /* access modifiers changed from: private */
    public zzw zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzcb zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzbkr zzn;
    /* access modifiers changed from: private */
    public final zzezt zzo = new zzezt();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public zzejm zzq;
    /* access modifiers changed from: private */
    public boolean zzr = false;
    /* access modifiers changed from: private */
    public zzcf zzs;

    public final zzfag zzA(zzbef zzbef) {
        this.zzh = zzbef;
        return this;
    }

    public final zzfag zzB(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfag zzC(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfag zzD(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfag zzE(zzl zzl2) {
        this.zza = zzl2;
        return this;
    }

    public final zzfag zzF(zzfl zzfl) {
        this.zzd = zzfl;
        return this;
    }

    public final zzfai zzG() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfai(this, (zzfah) null);
    }

    public final String zzI() {
        return this.zzc;
    }

    public final boolean zzO() {
        return this.zzp;
    }

    public final zzfag zzQ(zzcf zzcf) {
        this.zzs = zzcf;
        return this;
    }

    public final zzl zze() {
        return this.zza;
    }

    public final zzq zzg() {
        return this.zzb;
    }

    public final zzezt zzo() {
        return this.zzo;
    }

    public final zzfag zzp(zzfai zzfai) {
        this.zzo.zza(zzfai.zzo.zza);
        this.zza = zzfai.zzd;
        this.zzb = zzfai.zze;
        this.zzs = zzfai.zzr;
        this.zzc = zzfai.zzf;
        this.zzd = zzfai.zza;
        this.zzf = zzfai.zzg;
        this.zzg = zzfai.zzh;
        this.zzh = zzfai.zzi;
        this.zzi = zzfai.zzj;
        zzq(zzfai.zzl);
        zzD(zzfai.zzm);
        this.zzp = zzfai.zzp;
        this.zzq = zzfai.zzc;
        this.zzr = zzfai.zzq;
        return this;
    }

    public final zzfag zzq(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfag zzr(zzq zzq2) {
        this.zzb = zzq2;
        return this;
    }

    public final zzfag zzs(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfag zzt(zzw zzw) {
        this.zzi = zzw;
        return this;
    }

    public final zzfag zzu(zzejm zzejm) {
        this.zzq = zzejm;
        return this;
    }

    public final zzfag zzv(zzbkr zzbkr) {
        this.zzn = zzbkr;
        this.zzd = new zzfl(false, true, false);
        return this;
    }

    public final zzfag zzw(boolean z2) {
        this.zzp = z2;
        return this;
    }

    public final zzfag zzx(boolean z2) {
        this.zzr = true;
        return this;
    }

    public final zzfag zzy(boolean z2) {
        this.zze = z2;
        return this;
    }

    public final zzfag zzz(int i2) {
        this.zzm = i2;
        return this;
    }
}
