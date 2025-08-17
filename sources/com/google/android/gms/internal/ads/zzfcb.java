package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
public final class zzfcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfcb> CREATOR = new zzfcc();
    public final Context zza;
    public final zzfby zzb;
    @SafeParcelable.Field(id = 2)
    public final int zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;
    @SafeParcelable.Field(id = 4)
    public final int zze;
    @SafeParcelable.Field(id = 5)
    public final String zzf;
    public final int zzg;
    private final zzfby[] zzh;
    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzi;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzj;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    @SafeParcelable.Constructor
    public zzfcb(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i6, @SafeParcelable.Param(id = 7) int i7) {
        zzfby[] values = zzfby.values();
        this.zzh = values;
        int[] zza2 = zzfbz.zza();
        this.zzl = zza2;
        int[] zza3 = zzfca.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i2;
        this.zzb = values[i2];
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = str;
        this.zzj = i6;
        this.zzg = zza2[i6];
        this.zzk = i7;
        int i8 = zza3[i7];
    }

    public static zzfcb zza(zzfby zzfby, Context context) {
        if (zzfby == zzfby.Rewarded) {
            return new zzfcb(context, zzfby, ((Integer) zzba.zzc().zzb(zzbbm.zzgg)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgm)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgo)).intValue(), (String) zzba.zzc().zzb(zzbbm.zzgq), (String) zzba.zzc().zzb(zzbbm.zzgi), (String) zzba.zzc().zzb(zzbbm.zzgk));
        } else if (zzfby == zzfby.Interstitial) {
            return new zzfcb(context, zzfby, ((Integer) zzba.zzc().zzb(zzbbm.zzgh)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgn)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgp)).intValue(), (String) zzba.zzc().zzb(zzbbm.zzgr), (String) zzba.zzc().zzb(zzbbm.zzgj), (String) zzba.zzc().zzb(zzbbm.zzgl));
        } else if (zzfby != zzfby.AppOpen) {
            return null;
        } else {
            return new zzfcb(context, zzfby, ((Integer) zzba.zzc().zzb(zzbbm.zzgu)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgw)).intValue(), ((Integer) zzba.zzc().zzb(zzbbm.zzgx)).intValue(), (String) zzba.zzc().zzb(zzbbm.zzgs), (String) zzba.zzc().zzb(zzbbm.zzgt), (String) zzba.zzc().zzb(zzbbm.zzgv));
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfcb(Context context, zzfby zzfby, int i2, int i3, int i4, String str, String str2, String str3) {
        int i5;
        this.zzh = zzfby.values();
        this.zzl = zzfbz.zza();
        this.zzm = zzfca.zza();
        this.zza = context;
        this.zzi = zzfby.ordinal();
        this.zzb = zzfby;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i5 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i5 = 3;
        } else {
            i5 = 2;
        }
        this.zzg = i5;
        this.zzj = i5 - 1;
        this.zzk = 0;
    }
}
