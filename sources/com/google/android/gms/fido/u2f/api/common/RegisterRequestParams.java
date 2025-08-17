package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "RegisterRequestParamsCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new zzh();
    public static final int MAX_DISPLAY_HINT_LENGTH = 80;
    @SafeParcelable.Field(getter = "getRequestId", id = 2)
    private final Integer zza;
    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 3)
    private final Double zzb;
    @SafeParcelable.Field(getter = "getAppId", id = 4)
    private final Uri zzc;
    @SafeParcelable.Field(getter = "getRegisterRequests", id = 5)
    private final List zzd;
    @SafeParcelable.Field(getter = "getRegisteredKeys", id = 6)
    private final List zze;
    @SafeParcelable.Field(getter = "getChannelIdValue", id = 7)
    private final ChannelIdValue zzf;
    @SafeParcelable.Field(getter = "getDisplayHint", id = 8)
    private final String zzg;
    private Set zzh;

    public static final class Builder {
        Integer zza;
        Double zzb;
        Uri zzc;
        List zzd;
        List zze;
        ChannelIdValue zzf;
        String zzg;

        public RegisterRequestParams build() {
            return new RegisterRequestParams(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder setAppId(Uri uri) {
            this.zzc = uri;
            return this;
        }

        public Builder setChannelIdValue(ChannelIdValue channelIdValue) {
            this.zzf = channelIdValue;
            return this;
        }

        public Builder setDisplayHint(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setRegisterRequests(List<RegisterRequest> list) {
            this.zzd = list;
            return this;
        }

        public Builder setRegisteredKeys(List<RegisteredKey> list) {
            this.zze = list;
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zza = num;
            return this;
        }

        public Builder setTimeoutSeconds(Double d2) {
            this.zzb = d2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    RegisterRequestParams(@SafeParcelable.Param(id = 2) Integer num, @SafeParcelable.Param(id = 3) Double d2, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) ChannelIdValue channelIdValue, @SafeParcelable.Param(id = 8) String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.zza = num;
        this.zzb = d2;
        this.zzc = uri;
        boolean z5 = false;
        if (list == null || list.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "empty list of register requests is provided");
        this.zzd = list;
        this.zze = list2;
        this.zzf = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            RegisterRequest registerRequest = (RegisterRequest) it2.next();
            if (uri == null && registerRequest.getAppId() == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            Preconditions.checkArgument(z4, "register request has null appId and no request appId is provided");
            if (registerRequest.getAppId() != null) {
                hashSet.add(Uri.parse(registerRequest.getAppId()));
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it3.next();
            if (uri == null && registeredKey.getAppId() == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "registered key has null appId and no request appId is provided");
            if (registeredKey.getAppId() != null) {
                hashSet.add(Uri.parse(registeredKey.getAppId()));
            }
        }
        this.zzh = hashSet;
        Preconditions.checkArgument((str == null || str.length() <= 80) ? true : z5, "Display Hint cannot be longer than 80 characters");
        this.zzg = str;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        if (!Objects.equal(this.zza, registerRequestParams.zza) || !Objects.equal(this.zzb, registerRequestParams.zzb) || !Objects.equal(this.zzc, registerRequestParams.zzc) || !Objects.equal(this.zzd, registerRequestParams.zzd) || ((((list = this.zze) != null || registerRequestParams.zze != null) && (list == null || (list2 = registerRequestParams.zze) == null || !list.containsAll(list2) || !registerRequestParams.zze.containsAll(this.zze))) || !Objects.equal(this.zzf, registerRequestParams.zzf) || !Objects.equal(this.zzg, registerRequestParams.zzg))) {
            return false;
        }
        return true;
    }

    public Set<Uri> getAllAppIds() {
        return this.zzh;
    }

    public Uri getAppId() {
        return this.zzc;
    }

    public ChannelIdValue getChannelIdValue() {
        return this.zzf;
    }

    public String getDisplayHint() {
        return this.zzg;
    }

    public List<RegisterRequest> getRegisterRequests() {
        return this.zzd;
    }

    public List<RegisteredKey> getRegisteredKeys() {
        return this.zze;
    }

    public Integer getRequestId() {
        return this.zza;
    }

    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 2, getRequestId(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getAppId(), i2, false);
        SafeParcelWriter.writeTypedList(parcel, 5, getRegisterRequests(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getRegisteredKeys(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getChannelIdValue(), i2, false);
        SafeParcelWriter.writeString(parcel, 8, getDisplayHint(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
