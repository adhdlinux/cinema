package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "ChannelIdValueCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class ChannelIdValue extends AbstractSafeParcelable {
    public static final ChannelIdValue ABSENT = new ChannelIdValue();
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new zzb();
    public static final ChannelIdValue UNAVAILABLE = new ChannelIdValue("unavailable");
    public static final ChannelIdValue UNUSED = new ChannelIdValue("unused");
    @SafeParcelable.Field(getter = "getTypeAsInt", id = 2, type = "int")
    private final ChannelIdValueType zza;
    @SafeParcelable.Field(getter = "getStringValue", id = 3)
    private final String zzb;
    @SafeParcelable.Field(getter = "getObjectValueAsString", id = 4)
    private final String zzc;

    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);
        
        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = null;
        /* access modifiers changed from: private */
        public final int zzb;

        static {
            CREATOR = new zza();
        }

        private ChannelIdValueType(int i2) {
            this.zzb = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.zzb);
        }
    }

    public static class UnsupportedChannelIdValueTypeException extends Exception {
        public UnsupportedChannelIdValueTypeException(int i2) {
            super(String.format("ChannelIdValueType %s not supported", new Object[]{Integer.valueOf(i2)}));
        }
    }

    private ChannelIdValue() {
        this.zza = ChannelIdValueType.ABSENT;
        this.zzc = null;
        this.zzb = null;
    }

    public static ChannelIdValueType toChannelIdValueType(int i2) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (i2 == channelIdValueType.zzb) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) obj;
        if (!this.zza.equals(channelIdValue.zza)) {
            return false;
        }
        int ordinal = this.zza.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 1) {
            return this.zzb.equals(channelIdValue.zzb);
        }
        if (ordinal != 2) {
            return false;
        }
        return this.zzc.equals(channelIdValue.zzc);
    }

    public JSONObject getObjectValue() {
        if (this.zzc == null) {
            return null;
        }
        try {
            return new JSONObject(this.zzc);
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String getObjectValueAsString() {
        return this.zzc;
    }

    public String getStringValue() {
        return this.zzb;
    }

    public ChannelIdValueType getType() {
        return this.zza;
    }

    public int getTypeAsInt() {
        return this.zza.zzb;
    }

    public int hashCode() {
        int i2;
        int hashCode;
        int hashCode2 = this.zza.hashCode() + 31;
        int ordinal = this.zza.ordinal();
        if (ordinal == 1) {
            i2 = hashCode2 * 31;
            hashCode = this.zzb.hashCode();
        } else if (ordinal != 2) {
            return hashCode2;
        } else {
            i2 = hashCode2 * 31;
            hashCode = this.zzc.hashCode();
        }
        return i2 + hashCode;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getTypeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getStringValue(), false);
        SafeParcelWriter.writeString(parcel, 4, getObjectValueAsString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    ChannelIdValue(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        try {
            this.zza = toChannelIdValueType(i2);
            this.zzb = str;
            this.zzc = str2;
        } catch (UnsupportedChannelIdValueTypeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private ChannelIdValue(String str) {
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zza = ChannelIdValueType.STRING;
        this.zzc = null;
    }

    public ChannelIdValue(JSONObject jSONObject) {
        this.zzc = (String) Preconditions.checkNotNull(jSONObject.toString());
        this.zza = ChannelIdValueType.OBJECT;
        this.zzb = null;
    }
}
