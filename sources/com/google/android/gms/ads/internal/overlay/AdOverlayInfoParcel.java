package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhe;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcvt;
import com.google.android.gms.internal.ads.zzdcu;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    public final zzc zza;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zza zzb;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzo zzc;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzcez zzd;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzbhe zze;
    @SafeParcelable.Field(id = 7)
    public final String zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(id = 9)
    public final String zzh;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzz zzi;
    @SafeParcelable.Field(id = 11)
    public final int zzj;
    @SafeParcelable.Field(id = 12)
    public final int zzk;
    @SafeParcelable.Field(id = 13)
    public final String zzl;
    @SafeParcelable.Field(id = 14)
    public final zzbzx zzm;
    @SafeParcelable.Field(id = 16)
    public final String zzn;
    @SafeParcelable.Field(id = 17)
    public final zzj zzo;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzbhc zzp;
    @SafeParcelable.Field(id = 19)
    public final String zzq;
    @SafeParcelable.Field(getter = "getWorkManagerUtilAsBinder", id = 23, type = "android.os.IBinder")
    public final zzbr zzr;
    @SafeParcelable.Field(id = 24)
    public final String zzs;
    @SafeParcelable.Field(id = 25)
    public final String zzt;
    @SafeParcelable.Field(getter = "getAdFailedToShowEventEmitterAsBinder", id = 26, type = "android.os.IBinder")
    public final zzcvt zzu;
    @SafeParcelable.Field(getter = "getPhysicalClickListenerAsBinder", id = 27, type = "android.os.IBinder")
    public final zzdcu zzv;
    @SafeParcelable.Field(getter = "getOfflineUtilsAsBinder", id = 28, type = "android.os.IBinder")
    public final zzbrm zzw;

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzbhc zzbhc, zzbhe zzbhe, zzz zzz, zzcez zzcez, boolean z2, int i2, String str, zzbzx zzbzx, zzdcu zzdcu, zzbrm zzbrm) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzp = zzbhc;
        this.zze = zzbhe;
        this.zzf = null;
        this.zzg = z2;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = i2;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzbzx;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcu;
        this.zzw = zzbrm;
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i2, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i2, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i2, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 27, ObjectWrapper.wrap(this.zzv).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 28, ObjectWrapper.wrap(this.zzw).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzbhc zzbhc, zzbhe zzbhe, zzz zzz, zzcez zzcez, boolean z2, int i2, String str, String str2, zzbzx zzbzx, zzdcu zzdcu, zzbrm zzbrm) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzp = zzbhc;
        this.zze = zzbhe;
        this.zzf = str2;
        this.zzg = z2;
        this.zzh = str;
        this.zzi = zzz;
        this.zzj = i2;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzbzx;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcu;
        this.zzw = zzbrm;
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzz zzz, zzcez zzcez, int i2, zzbzx zzbzx, String str, zzj zzj2, String str2, String str3, String str4, zzcvt zzcvt, zzbrm zzbrm) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaF)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i2;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzbzx;
        this.zzn = str;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = str4;
        this.zzu = zzcvt;
        this.zzv = null;
        this.zzw = zzbrm;
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzz zzz, zzcez zzcez, boolean z2, int i2, zzbzx zzbzx, zzdcu zzdcu, zzbrm zzbrm) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z2;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = i2;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzbzx;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcu;
        this.zzw = zzbrm;
    }

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzc zzc2, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbzx zzbzx, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) zzj zzj2, @SafeParcelable.Param(id = 18) IBinder iBinder6, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 23) IBinder iBinder7, @SafeParcelable.Param(id = 24) String str6, @SafeParcelable.Param(id = 25) String str7, @SafeParcelable.Param(id = 26) IBinder iBinder8, @SafeParcelable.Param(id = 27) IBinder iBinder9, @SafeParcelable.Param(id = 28) IBinder iBinder10) {
        this.zza = zzc2;
        this.zzb = (zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcez) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbhc) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbhe) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z2;
        this.zzh = str2;
        this.zzi = (zzz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i2;
        this.zzk = i3;
        this.zzl = str3;
        this.zzm = zzbzx;
        this.zzn = str4;
        this.zzo = zzj2;
        this.zzq = str5;
        this.zzs = str6;
        this.zzr = (zzbr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzt = str7;
        this.zzu = (zzcvt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzv = (zzdcu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzw = (zzbrm) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
    }

    public AdOverlayInfoParcel(zzc zzc2, zza zza2, zzo zzo2, zzz zzz, zzbzx zzbzx, zzcez zzcez, zzdcu zzdcu) {
        this.zza = zzc2;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzbzx;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcu;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzo zzo2, zzcez zzcez, int i2, zzbzx zzbzx) {
        this.zzc = zzo2;
        this.zzd = zzcez;
        this.zzj = 1;
        this.zzm = zzbzx;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzcez zzcez, zzbzx zzbzx, zzbr zzbr, String str, String str2, int i2, zzbrm zzbrm) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcez;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzbzx;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzs = str2;
        this.zzr = zzbr;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = zzbrm;
    }
}
