package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaQueueItemCreator")
@SafeParcelable.Reserved({1})
public class MediaQueueItem extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<MediaQueueItem> CREATOR = new zzck();
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    @SafeParcelable.Field(id = 9)
    String zza;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getMedia", id = 2)
    public MediaInfo zzb;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getItemId", id = 3)
    public int zzc;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAutoplay", id = 4)
    public boolean zzd;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStartTime", id = 5)
    public double zze;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getPlaybackDuration", id = 6)
    public double zzf;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getPreloadTime", id = 7)
    public double zzg;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getActiveTrackIds", id = 8)
    public long[] zzh;
    /* access modifiers changed from: private */
    public JSONObject zzi;
    private final Writer zzj;

    public static class Builder {
        private final MediaQueueItem zza;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            this.zza = new MediaQueueItem(mediaInfo, (zzcj) null);
        }

        public MediaQueueItem build() {
            this.zza.zzi();
            return this.zza;
        }

        public Builder clearItemId() {
            this.zza.getWriter().setItemId(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zza.getWriter().setActiveTrackIds(jArr);
            return this;
        }

        public Builder setAutoplay(boolean z2) {
            this.zza.getWriter().setAutoplay(z2);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zza.getWriter().setCustomData(jSONObject);
            return this;
        }

        public Builder setItemId(int i2) {
            this.zza.getWriter().setItemId(i2);
            return this;
        }

        public Builder setPlaybackDuration(double d2) {
            this.zza.getWriter().setPlaybackDuration(d2);
            return this;
        }

        public Builder setPreloadTime(double d2) throws IllegalArgumentException {
            this.zza.getWriter().setPreloadTime(d2);
            return this;
        }

        public Builder setStartTime(double d2) throws IllegalArgumentException {
            this.zza.getWriter().setStartTime(d2);
            return this;
        }

        public Builder(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
            this.zza = new MediaQueueItem(mediaQueueItem, (zzcj) null);
        }

        public Builder(JSONObject jSONObject) throws JSONException {
            this.zza = new MediaQueueItem(jSONObject);
        }
    }

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @KeepForSdk
        public void setActiveTrackIds(long[] jArr) {
            MediaQueueItem.this.zzh = jArr;
        }

        @KeepForSdk
        public void setAutoplay(boolean z2) {
            MediaQueueItem.this.zzd = z2;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject) {
            MediaQueueItem.this.zzi = jSONObject;
        }

        @KeepForSdk
        public void setItemId(int i2) {
            MediaQueueItem.this.zzc = i2;
        }

        @KeepForSdk
        public void setMedia(MediaInfo mediaInfo) {
            MediaQueueItem.this.zzb = mediaInfo;
        }

        @KeepForSdk
        public void setPlaybackDuration(double d2) {
            if (!Double.isNaN(d2)) {
                MediaQueueItem.this.zzf = d2;
                return;
            }
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }

        @KeepForSdk
        public void setPreloadTime(double d2) {
            if (Double.isNaN(d2) || d2 < 0.0d) {
                throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
            }
            MediaQueueItem.this.zzg = d2;
        }

        @KeepForSdk
        public void setStartTime(double d2) {
            if (Double.isNaN(d2) || d2 >= 0.0d) {
                MediaQueueItem.this.zze = d2;
                return;
            }
            throw new IllegalArgumentException("startTime cannot be negative.");
        }
    }

    @SafeParcelable.Constructor
    MediaQueueItem(@SafeParcelable.Param(id = 2) MediaInfo mediaInfo, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) double d2, @SafeParcelable.Param(id = 6) double d3, @SafeParcelable.Param(id = 7) double d4, @SafeParcelable.Param(id = 8) long[] jArr, @SafeParcelable.Param(id = 9) String str) {
        this.zze = Double.NaN;
        this.zzj = new Writer();
        this.zzb = mediaInfo;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = d2;
        this.zzf = d3;
        this.zzg = d4;
        this.zzh = jArr;
        this.zza = str;
        if (str != null) {
            try {
                this.zzi = new JSONObject(this.zza);
            } catch (JSONException unused) {
                this.zzi = null;
                this.zza = null;
            }
        } else {
            this.zzi = null;
        }
    }

    public boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        JSONObject jSONObject = this.zzi;
        if (jSONObject != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        JSONObject jSONObject2 = mediaQueueItem.zzi;
        if (jSONObject2 != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z2 != z3) {
            return false;
        }
        if ((jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zze(this.zzb, mediaQueueItem.zzb) && this.zzc == mediaQueueItem.zzc && this.zzd == mediaQueueItem.zzd && (((Double.isNaN(this.zze) && Double.isNaN(mediaQueueItem.zze)) || this.zze == mediaQueueItem.zze) && this.zzf == mediaQueueItem.zzf && this.zzg == mediaQueueItem.zzg && Arrays.equals(this.zzh, mediaQueueItem.zzh))) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public boolean fromJson(JSONObject jSONObject) throws JSONException {
        boolean z2;
        long[] jArr;
        boolean z3;
        int i2;
        boolean z4 = false;
        if (jSONObject.has("media")) {
            this.zzb = new MediaInfo(jSONObject.getJSONObject("media"));
            z2 = true;
        } else {
            z2 = false;
        }
        if (jSONObject.has("itemId") && this.zzc != (i2 = jSONObject.getInt("itemId"))) {
            this.zzc = i2;
            z2 = true;
        }
        if (jSONObject.has(AudienceNetworkActivity.AUTOPLAY) && this.zzd != (z3 = jSONObject.getBoolean(AudienceNetworkActivity.AUTOPLAY))) {
            this.zzd = z3;
            z2 = true;
        }
        double optDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(optDouble) != Double.isNaN(this.zze) || (!Double.isNaN(optDouble) && Math.abs(optDouble - this.zze) > 1.0E-7d)) {
            this.zze = optDouble;
            z2 = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.zzf) > 1.0E-7d) {
                this.zzf = d2;
                z2 = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.zzg) > 1.0E-7d) {
                this.zzg = d3;
                z2 = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i3 = 0; i3 < length; i3++) {
                jArr[i3] = jSONArray.getLong(i3);
            }
            long[] jArr2 = this.zzh;
            if (jArr2 != null && jArr2.length == length) {
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    } else if (this.zzh[i4] != jArr[i4]) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            z4 = true;
        } else {
            jArr = null;
        }
        if (z4) {
            this.zzh = jArr;
            z2 = true;
        }
        if (!jSONObject.has("customData")) {
            return z2;
        }
        this.zzi = jSONObject.getJSONObject("customData");
        return true;
    }

    public long[] getActiveTrackIds() {
        return this.zzh;
    }

    public boolean getAutoplay() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzi;
    }

    public int getItemId() {
        return this.zzc;
    }

    public MediaInfo getMedia() {
        return this.zzb;
    }

    public double getPlaybackDuration() {
        return this.zzf;
    }

    public double getPreloadTime() {
        return this.zzg;
    }

    public double getStartTime() {
        return this.zze;
    }

    @KeepForSdk
    public Writer getWriter() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd), Double.valueOf(this.zze), Double.valueOf(this.zzf), Double.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), String.valueOf(this.zzi));
    }

    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.zzb;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.zza());
            }
            int i2 = this.zzc;
            if (i2 != 0) {
                jSONObject.put("itemId", i2);
            }
            jSONObject.put(AudienceNetworkActivity.AUTOPLAY, this.zzd);
            if (!Double.isNaN(this.zze)) {
                jSONObject.put("startTime", this.zze);
            }
            double d2 = this.zzf;
            if (d2 != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d2);
            }
            jSONObject.put("preloadTime", this.zzg);
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzh) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.zzi;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        JSONObject jSONObject = this.zzi;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zza = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMedia(), i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getItemId());
        SafeParcelWriter.writeBoolean(parcel, 4, getAutoplay());
        SafeParcelWriter.writeDouble(parcel, 5, getStartTime());
        SafeParcelWriter.writeDouble(parcel, 6, getPlaybackDuration());
        SafeParcelWriter.writeDouble(parcel, 7, getPreloadTime());
        SafeParcelWriter.writeLongArray(parcel, 8, getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel, 9, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final void zzi() throws IllegalArgumentException {
        if (this.zzb == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (!Double.isNaN(this.zze) && this.zze < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzf)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzg) || this.zzg < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    /* synthetic */ MediaQueueItem(MediaInfo mediaInfo, zzcj zzcj) {
        this(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, (long[]) null, (String) null);
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
    }

    /* synthetic */ MediaQueueItem(MediaQueueItem mediaQueueItem, zzcj zzcj) {
        this(mediaQueueItem.getMedia(), mediaQueueItem.getItemId(), mediaQueueItem.getAutoplay(), mediaQueueItem.getStartTime(), mediaQueueItem.getPlaybackDuration(), mediaQueueItem.getPreloadTime(), mediaQueueItem.getActiveTrackIds(), (String) null);
        if (this.zzb != null) {
            this.zzi = mediaQueueItem.getCustomData();
            return;
        }
        throw new IllegalArgumentException("media cannot be null.");
    }

    @KeepForSdk
    public MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this((MediaInfo) null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, (long[]) null, (String) null);
        fromJson(jSONObject);
    }
}
