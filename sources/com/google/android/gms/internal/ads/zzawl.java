package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzawl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawl> CREATOR = new zzawm();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final long zzb;
    @SafeParcelable.Field(id = 4)
    public final String zzc;
    @SafeParcelable.Field(id = 5)
    public final String zzd;
    @SafeParcelable.Field(id = 6)
    public final String zze;
    @SafeParcelable.Field(id = 7)
    public final Bundle zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @SafeParcelable.Field(id = 9)
    public long zzh;
    @SafeParcelable.Field(id = 10)
    public String zzi;
    @SafeParcelable.Field(id = 11)
    public int zzj;

    @SafeParcelable.Constructor
    zzawl(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) long j3, @SafeParcelable.Param(id = 10) String str5, @SafeParcelable.Param(id = 11) int i2) {
        this.zza = str;
        this.zzb = j2;
        this.zzc = str2 == null ? "" : str2;
        this.zzd = str3 == null ? "" : str3;
        this.zze = str4 == null ? "" : str4;
        this.zzf = bundle == null ? new Bundle() : bundle;
        this.zzg = z2;
        this.zzh = j3;
        this.zzi = str5;
        this.zzj = i2;
    }

    public static zzawl zza(Uri uri) {
        long parseLong;
        Uri uri2 = uri;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                zzbzr.zzj("Expected 2 path parts for namespace and id, found :" + size);
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri2.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri2.getQueryParameter("read_only"));
            String queryParameter2 = uri2.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(queryParameter2);
            }
            long j2 = parseLong;
            Bundle bundle = new Bundle();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri2.getQueryParameter(next));
                }
            }
            return new zzawl(queryParameter, j2, host, str, str2, bundle, equals, 0, "", 0);
        } catch (NullPointerException | NumberFormatException e2) {
            zzbzr.zzk("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeString(parcel, 10, this.zzi, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
