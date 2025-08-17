package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class zzfha extends zzfgw {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfgy zzb;
    private final zzfgx zzc;
    private final List zzd = new ArrayList();
    private zzfiu zze;
    private zzfhx zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    zzfha(zzfgx zzfgx, zzfgy zzfgy) {
        this.zzc = zzfgx;
        this.zzb = zzfgy;
        this.zzi = UUID.randomUUID().toString();
        zzk((View) null);
        if (zzfgy.zzd() == zzfgz.HTML || zzfgy.zzd() == zzfgz.JAVASCRIPT) {
            this.zzf = new zzfhy(zzfgy.zza());
        } else {
            this.zzf = new zzfia(zzfgy.zzi(), (String) null);
        }
        this.zzf.zzj();
        zzfhl.zza().zzd(this);
        zzfhq.zza().zzd(this.zzf.zza(), zzfgx.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzfiu(view);
    }

    public final void zzb(View view, zzfhc zzfhc, String str) {
        zzfhn zzfhn;
        if (this.zzh) {
            return;
        }
        if (zza.matcher("Ad overlay").matches()) {
            Iterator it2 = this.zzd.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    zzfhn = null;
                    break;
                }
                zzfhn = (zzfhn) it2.next();
                if (zzfhn.zzb().get() == view) {
                    break;
                }
            }
            if (zzfhn == null) {
                this.zzd.add(new zzfhn(view, zzfhc, "Ad overlay"));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            if (!this.zzh) {
                this.zzd.clear();
            }
            this.zzh = true;
            zzfhq.zza().zzc(this.zzf.zza());
            zzfhl.zza().zze(this);
            this.zzf.zzc();
            this.zzf = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzh && zzf() != view) {
            zzk(view);
            this.zzf.zzb();
            Collection<zzfha> zzc2 = zzfhl.zza().zzc();
            if (zzc2 != null && !zzc2.isEmpty()) {
                for (zzfha zzfha : zzc2) {
                    if (zzfha != this && zzfha.zzf() == view) {
                        zzfha.zze.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zzg) {
            this.zzg = true;
            zzfhl.zza().zzf(this);
            this.zzf.zzh(zzfhr.zzb().zza());
            this.zzf.zzf(this, this.zzb);
        }
    }

    public final View zzf() {
        return (View) this.zze.get();
    }

    public final zzfhx zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzg && !this.zzh;
    }
}
