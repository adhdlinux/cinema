package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ApplicationMetadataCreator")
@SafeParcelable.Reserved({1})
public class ApplicationMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getApplicationId", id = 2)
    String zza;
    @SafeParcelable.Field(getter = "getName", id = 3)
    String zzb;
    @SafeParcelable.Field(getter = "getSupportedNamespaces", id = 5)
    final List zzc;
    @SafeParcelable.Field(getter = "getSenderAppIdentifier", id = 6)
    String zzd;
    @SafeParcelable.Field(getter = "getSenderAppLaunchUrl", id = 7)
    Uri zze;
    @SafeParcelable.Field(getter = "getIconUrl", id = 8)
    String zzf;
    @SafeParcelable.Field(getter = "getApplicationType", id = 9)
    private String zzg;

    private ApplicationMetadata() {
        this.zzc = new ArrayList();
    }

    public boolean areNamespacesSupported(List<String> list) {
        List list2 = this.zzc;
        return list2 != null && list2.containsAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        if (!CastUtils.zze(this.zza, applicationMetadata.zza) || !CastUtils.zze(this.zzb, applicationMetadata.zzb) || !CastUtils.zze(this.zzc, applicationMetadata.zzc) || !CastUtils.zze(this.zzd, applicationMetadata.zzd) || !CastUtils.zze(this.zze, applicationMetadata.zze) || !CastUtils.zze(this.zzf, applicationMetadata.zzf) || !CastUtils.zze(this.zzg, applicationMetadata.zzg)) {
            return false;
        }
        return true;
    }

    public String getApplicationId() {
        return this.zza;
    }

    public String getIconUrl() {
        return this.zzf;
    }

    @Deprecated
    public List<WebImage> getImages() {
        return null;
    }

    public String getName() {
        return this.zzb;
    }

    public String getSenderAppIdentifier() {
        return this.zzd;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzc);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public boolean isNamespaceSupported(String str) {
        List list = this.zzc;
        return list != null && list.contains(str);
    }

    public void setIconUrl(String str) {
        this.zzf = str;
    }

    public String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        List list = this.zzc;
        int size = list == null ? 0 : list.size();
        String str3 = this.zzd;
        String valueOf = String.valueOf(this.zze);
        String str4 = this.zzf;
        String str5 = this.zzg;
        return "applicationId: " + str + ", name: " + str2 + ", namespaces.count: " + size + ", senderAppIdentifier: " + str3 + ", senderAppLaunchUrl: " + valueOf + ", iconUrl: " + str4 + ", type: " + str5;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getApplicationId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getImages(), false);
        SafeParcelWriter.writeStringList(parcel, 5, getSupportedNamespaces(), false);
        SafeParcelWriter.writeString(parcel, 6, getSenderAppIdentifier(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zze, i2, false);
        SafeParcelWriter.writeString(parcel, 8, getIconUrl(), false);
        SafeParcelWriter.writeString(parcel, 9, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    ApplicationMetadata(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List list, @SafeParcelable.Param(id = 5) List list2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) Uri uri, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) String str5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = str5;
    }
}
