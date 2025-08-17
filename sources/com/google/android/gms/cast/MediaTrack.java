package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzfh;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaTrackCreator")
@SafeParcelable.Reserved({1})
public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<MediaTrack> CREATOR = new zzcn();
    public static final String ROLE_ALTERNATE = "alternate";
    public static final String ROLE_CAPTION = "caption";
    public static final String ROLE_COMMENTARY = "commentary";
    public static final String ROLE_DESCRIPTION = "description";
    public static final String ROLE_DUB = "dub";
    public static final String ROLE_EMERGENCY = "emergency";
    public static final String ROLE_FORCED_SUBTITLE = "forced_subtitle";
    public static final String ROLE_MAIN = "main";
    public static final String ROLE_SIGN = "sign";
    public static final String ROLE_SUBTITLE = "subtitle";
    public static final String ROLE_SUPPLEMENTARY = "supplementary";
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    @SafeParcelable.Field(id = 10)
    String zza;
    @SafeParcelable.Field(getter = "getId", id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getType", id = 3)
    private final int zzc;
    @SafeParcelable.Field(getter = "getContentId", id = 4)
    private String zzd;
    @SafeParcelable.Field(getter = "getContentType", id = 5)
    private String zze;
    @SafeParcelable.Field(getter = "getName", id = 6)
    private final String zzf;
    @SafeParcelable.Field(getter = "getLanguage", id = 7)
    private final String zzg;
    @SafeParcelable.Field(getter = "getSubtype", id = 8)
    private final int zzh;
    @SafeParcelable.Field(getter = "getRoles", id = 9)
    private final List zzi;
    private final JSONObject zzj;

    public static class Builder {
        private final long zza;
        private final int zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private int zzg = 0;
        private List zzh;
        private JSONObject zzi;

        public Builder(long j2, int i2) throws IllegalArgumentException {
            this.zza = j2;
            this.zzb = i2;
        }

        public MediaTrack build() {
            return new MediaTrack(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
        }

        public Builder setContentId(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setContentType(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzi = jSONObject;
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzf = str;
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzf = CastUtils.zzb(locale);
            return this;
        }

        public Builder setName(String str) {
            this.zze = str;
            return this;
        }

        public Builder setRoles(List<String> list) {
            if (list != null) {
                list = zzfh.zzj(list);
            }
            this.zzh = list;
            return this;
        }

        public Builder setSubtype(int i2) throws IllegalArgumentException {
            if (i2 < -1 || i2 > 5) {
                throw new IllegalArgumentException("invalid subtype " + i2);
            } else if (i2 == 0 || this.zzb == 1) {
                this.zzg = i2;
                return this;
            } else {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            }
        }
    }

    MediaTrack(long j2, int i2, String str, String str2, String str3, String str4, int i3, List list, JSONObject jSONObject) {
        this.zzb = j2;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = i3;
        this.zzi = list;
        this.zzj = jSONObject;
    }

    public boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.zzj;
        if (jSONObject != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        JSONObject jSONObject2 = mediaTrack.zzj;
        if (jSONObject2 != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z2 != z3) {
            return false;
        }
        if ((jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzb == mediaTrack.zzb && this.zzc == mediaTrack.zzc && CastUtils.zze(this.zzd, mediaTrack.zzd) && CastUtils.zze(this.zze, mediaTrack.zze) && CastUtils.zze(this.zzf, mediaTrack.zzf) && CastUtils.zze(this.zzg, mediaTrack.zzg) && this.zzh == mediaTrack.zzh && CastUtils.zze(this.zzi, mediaTrack.zzi)) {
            return true;
        }
        return false;
    }

    public String getContentId() {
        return this.zzd;
    }

    public String getContentType() {
        return this.zze;
    }

    public JSONObject getCustomData() {
        return this.zzj;
    }

    public long getId() {
        return this.zzb;
    }

    public String getLanguage() {
        return this.zzg;
    }

    @TargetApi(21)
    public Locale getLanguageLocale() {
        if (TextUtils.isEmpty(this.zzg)) {
            return null;
        }
        if (PlatformVersion.isAtLeastLollipop()) {
            return Locale.forLanguageTag(this.zzg);
        }
        String[] split = this.zzg.split("-", -1);
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        return new Locale(split[0], split[1]);
    }

    public String getName() {
        return this.zzf;
    }

    public List<String> getRoles() {
        return this.zzi;
    }

    public int getSubtype() {
        return this.zzh;
    }

    public int getType() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, Integer.valueOf(this.zzh), this.zzi, String.valueOf(this.zzj));
    }

    public void setContentId(String str) {
        this.zzd = str;
    }

    public void setContentType(String str) {
        this.zze = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        JSONObject jSONObject = this.zzj;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getId());
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeString(parcel, 4, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 5, getContentType(), false);
        SafeParcelWriter.writeString(parcel, 6, getName(), false);
        SafeParcelWriter.writeString(parcel, 7, getLanguage(), false);
        SafeParcelWriter.writeInt(parcel, 8, getSubtype());
        SafeParcelWriter.writeStringList(parcel, 9, getRoles(), false);
        SafeParcelWriter.writeString(parcel, 10, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzb);
            int i2 = this.zzc;
            if (i2 == 1) {
                jSONObject.put("type", AdPreferences.TYPE_TEXT);
            } else if (i2 == 2) {
                jSONObject.put("type", "AUDIO");
            } else if (i2 == 3) {
                jSONObject.put("type", "VIDEO");
            }
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("trackContentId", str);
            }
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("trackContentType", str2);
            }
            String str3 = this.zzf;
            if (str3 != null) {
                jSONObject.put("name", str3);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject.put("language", this.zzg);
            }
            int i3 = this.zzh;
            if (i3 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i3 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i3 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i3 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i3 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            if (this.zzi != null) {
                jSONObject.put("roles", new JSONArray(this.zzi));
            }
            JSONObject jSONObject2 = this.zzj;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
