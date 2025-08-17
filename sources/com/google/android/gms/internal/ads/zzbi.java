package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

public final class zzbi {
    public static final zzn zza = zzbg.zza;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    public final Uri zzb;
    public final String zzc = null;
    public final zzbb zzd = null;
    public final zzaq zze = null;
    public final List zzf;
    public final String zzg;
    public final zzfsc zzh;
    @Deprecated
    public final List zzi;
    public final Object zzj;

    /* synthetic */ zzbi(Uri uri, String str, zzbb zzbb, zzaq zzaq, List list, String str2, zzfsc zzfsc, Object obj, zzbh zzbh) {
        this.zzb = uri;
        this.zzf = list;
        this.zzg = null;
        this.zzh = zzfsc;
        zzfrz zzfrz = new zzfrz();
        if (zzfsc.size() <= 0) {
            this.zzi = zzfrz.zzi();
            this.zzj = null;
            return;
        }
        zzbn zzbn = (zzbn) zzfsc.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return false;
        }
        zzbi zzbi = (zzbi) obj;
        if (!this.zzb.equals(zzbi.zzb) || !zzfj.zzC((Object) null, (Object) null) || !zzfj.zzC((Object) null, (Object) null) || !zzfj.zzC((Object) null, (Object) null) || !this.zzf.equals(zzbi.zzf) || !zzfj.zzC((Object) null, (Object) null) || !this.zzh.equals(zzbi.zzh) || !zzfj.zzC((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.zzb.hashCode() * 923521) + this.zzf.hashCode()) * 961) + this.zzh.hashCode()) * 31;
    }
}
