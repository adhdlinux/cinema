package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NotificationActionCreator")
@SafeParcelable.Reserved({1})
public class NotificationAction extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationAction> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getAction", id = 2)
    private final String zza;
    @SafeParcelable.Field(getter = "getIconResId", id = 3)
    private final int zzb;
    @SafeParcelable.Field(getter = "getContentDescription", id = 4)
    private final String zzc;

    public static final class Builder {
        String zza;
        int zzb;
        String zzc;

        public NotificationAction build() {
            return new NotificationAction(this.zza, this.zzb, this.zzc);
        }

        public Builder setAction(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.zza = str;
                return this;
            }
            throw new IllegalArgumentException("action cannot be null or an empty string.");
        }

        public Builder setContentDescription(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.zzc = str;
                return this;
            }
            throw new IllegalArgumentException("contentDescription cannot be null  or an empty string.");
        }

        public Builder setIconResId(int i2) {
            this.zzb = i2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    NotificationAction(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = str2;
    }

    public String getAction() {
        return this.zza;
    }

    public String getContentDescription() {
        return this.zzc;
    }

    public int getIconResId() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAction(), false);
        SafeParcelWriter.writeInt(parcel, 3, getIconResId());
        SafeParcelWriter.writeString(parcel, 4, getContentDescription(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
