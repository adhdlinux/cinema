package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaQueueDataCreator")
@SafeParcelable.Reserved({1})
public class MediaQueueData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueData> CREATOR = new zzci();
    public static final int MEDIA_QUEUE_TYPE_ALBUM = 1;
    public static final int MEDIA_QUEUE_TYPE_AUDIO_BOOK = 3;
    public static final int MEDIA_QUEUE_TYPE_GENERIC = 0;
    public static final int MEDIA_QUEUE_TYPE_LIVE_TV = 8;
    public static final int MEDIA_QUEUE_TYPE_MOVIE = 9;
    public static final int MEDIA_QUEUE_TYPE_PLAYLIST = 2;
    public static final int MEDIA_QUEUE_TYPE_PODCAST_SERIES = 5;
    public static final int MEDIA_QUEUE_TYPE_RADIO_STATION = 4;
    public static final int MEDIA_QUEUE_TYPE_TV_SERIES = 6;
    public static final int MEDIA_QUEUE_TYPE_VIDEO_PLAYLIST = 7;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getQueueId", id = 2)
    public String zza;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getEntity", id = 3)
    public String zzb;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getQueueType", id = 4)
    public int zzc;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getName", id = 5)
    public String zzd;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getContainerMetadata", id = 6)
    public MediaQueueContainerMetadata zze;
    @SafeParcelable.Field(getter = "getRepeatMode", id = 7)
    private int zzf;
    @SafeParcelable.Field(getter = "getItems", id = 8)
    private List zzg;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStartIndex", id = 9)
    public int zzh;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStartTime", id = 10)
    public long zzi;
    @SafeParcelable.Field(getter = "getShuffle", id = 11)
    private boolean zzj;

    public static class Builder {
        private final MediaQueueData zza;

        public Builder() {
            this.zza = new MediaQueueData((zzch) null);
        }

        public MediaQueueData build() {
            return new MediaQueueData(this.zza, (zzch) null);
        }

        public Builder setContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata) {
            this.zza.zze = mediaQueueContainerMetadata;
            return this;
        }

        public Builder setEntity(String str) {
            this.zza.zzb = str;
            return this;
        }

        public Builder setItems(List<MediaQueueItem> list) {
            MediaQueueData.zze(this.zza, list);
            return this;
        }

        public Builder setName(String str) {
            this.zza.zzd = str;
            return this;
        }

        public Builder setQueueId(String str) {
            this.zza.zza = str;
            return this;
        }

        public Builder setQueueType(int i2) {
            this.zza.zzc = i2;
            return this;
        }

        public Builder setRepeatMode(int i2) {
            this.zza.setRepeatMode(i2);
            return this;
        }

        public Builder setStartIndex(int i2) {
            this.zza.zzh = i2;
            return this;
        }

        public Builder setStartTime(long j2) {
            this.zza.zzi = j2;
            return this;
        }

        public final Builder zza(JSONObject jSONObject) {
            MediaQueueData.zzb(this.zza, jSONObject);
            return this;
        }

        @KeepForSdk
        public Builder(MediaQueueData mediaQueueData) {
            this.zza = new MediaQueueData(mediaQueueData, (zzch) null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueType {
    }

    private MediaQueueData() {
        zzl();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzb(com.google.android.gms.cast.MediaQueueData r11, org.json.JSONObject r12) {
        /*
            r11.zzl()
            if (r12 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r0 = "id"
            java.lang.String r0 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r12, r0)
            r11.zza = r0
            java.lang.String r0 = "entity"
            java.lang.String r0 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r12, r0)
            r11.zzb = r0
            java.lang.String r0 = "queueType"
            java.lang.String r0 = r12.optString(r0)
            int r1 = r0.hashCode()
            r2 = 7
            r3 = 6
            r4 = 8
            r5 = 0
            r6 = 5
            r7 = 2
            r8 = 3
            r9 = 4
            r10 = 1
            switch(r1) {
                case -1803151310: goto L_0x007f;
                case -1758903120: goto L_0x0075;
                case -1632865838: goto L_0x006b;
                case -1319760993: goto L_0x0061;
                case -1088524588: goto L_0x0057;
                case 62359119: goto L_0x004d;
                case 73549584: goto L_0x0042;
                case 393100598: goto L_0x0038;
                case 902303413: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0089
        L_0x002e:
            java.lang.String r1 = "LIVE_TV"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 7
            goto L_0x008a
        L_0x0038:
            java.lang.String r1 = "VIDEO_PLAYLIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 6
            goto L_0x008a
        L_0x0042:
            java.lang.String r1 = "MOVIE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 8
            goto L_0x008a
        L_0x004d:
            java.lang.String r1 = "ALBUM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 0
            goto L_0x008a
        L_0x0057:
            java.lang.String r1 = "TV_SERIES"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 5
            goto L_0x008a
        L_0x0061:
            java.lang.String r1 = "AUDIOBOOK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 2
            goto L_0x008a
        L_0x006b:
            java.lang.String r1 = "PLAYLIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 1
            goto L_0x008a
        L_0x0075:
            java.lang.String r1 = "RADIO_STATION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 3
            goto L_0x008a
        L_0x007f:
            java.lang.String r1 = "PODCAST_SERIES"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r0 = 4
            goto L_0x008a
        L_0x0089:
            r0 = -1
        L_0x008a:
            switch(r0) {
                case 0: goto L_0x00a8;
                case 1: goto L_0x00a5;
                case 2: goto L_0x00a2;
                case 3: goto L_0x009f;
                case 4: goto L_0x009c;
                case 5: goto L_0x0099;
                case 6: goto L_0x0096;
                case 7: goto L_0x0093;
                case 8: goto L_0x008e;
                default: goto L_0x008d;
            }
        L_0x008d:
            goto L_0x00aa
        L_0x008e:
            r0 = 9
            r11.zzc = r0
            goto L_0x00aa
        L_0x0093:
            r11.zzc = r4
            goto L_0x00aa
        L_0x0096:
            r11.zzc = r2
            goto L_0x00aa
        L_0x0099:
            r11.zzc = r3
            goto L_0x00aa
        L_0x009c:
            r11.zzc = r6
            goto L_0x00aa
        L_0x009f:
            r11.zzc = r9
            goto L_0x00aa
        L_0x00a2:
            r11.zzc = r8
            goto L_0x00aa
        L_0x00a5:
            r11.zzc = r7
            goto L_0x00aa
        L_0x00a8:
            r11.zzc = r10
        L_0x00aa:
            java.lang.String r0 = "name"
            java.lang.String r0 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r12, r0)
            r11.zzd = r0
            java.lang.String r0 = "containerMetadata"
            boolean r1 = r12.has(r0)
            if (r1 == 0) goto L_0x00bf
            org.json.JSONObject r0 = r12.optJSONObject(r0)
            goto L_0x00c0
        L_0x00bf:
            r0 = 0
        L_0x00c0:
            if (r0 == 0) goto L_0x00d0
            com.google.android.gms.cast.MediaQueueContainerMetadata$Builder r1 = new com.google.android.gms.cast.MediaQueueContainerMetadata$Builder
            r1.<init>()
            r1.zza(r0)
            com.google.android.gms.cast.MediaQueueContainerMetadata r0 = r1.build()
            r11.zze = r0
        L_0x00d0:
            java.lang.String r0 = "repeatMode"
            java.lang.String r0 = r12.optString(r0)
            java.lang.Integer r0 = com.google.android.gms.cast.internal.media.MediaCommon.mediaRepeatModeFromString(r0)
            if (r0 == 0) goto L_0x00e2
            int r0 = r0.intValue()
            r11.zzf = r0
        L_0x00e2:
            java.lang.String r0 = "items"
            org.json.JSONArray r0 = r12.optJSONArray(r0)
            if (r0 == 0) goto L_0x0108
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.zzg = r1
        L_0x00f1:
            int r2 = r0.length()
            if (r5 >= r2) goto L_0x0108
            org.json.JSONObject r2 = r0.optJSONObject(r5)
            if (r2 == 0) goto L_0x0105
            com.google.android.gms.cast.MediaQueueItem r3 = new com.google.android.gms.cast.MediaQueueItem     // Catch:{ JSONException -> 0x0105 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0105 }
            r1.add(r3)     // Catch:{ JSONException -> 0x0105 }
        L_0x0105:
            int r5 = r5 + 1
            goto L_0x00f1
        L_0x0108:
            int r0 = r11.zzh
            java.lang.String r1 = "startIndex"
            int r0 = r12.optInt(r1, r0)
            r11.zzh = r0
            java.lang.String r0 = "startTime"
            boolean r1 = r12.has(r0)
            if (r1 == 0) goto L_0x0127
            long r1 = r11.zzi
            double r1 = (double) r1
            double r0 = r12.optDouble(r0, r1)
            long r0 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((double) r0)
            r11.zzi = r0
        L_0x0127:
            java.lang.String r0 = "shuffle"
            boolean r12 = r12.optBoolean(r0)
            r11.zzj = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaQueueData.zzb(com.google.android.gms.cast.MediaQueueData, org.json.JSONObject):void");
    }

    static /* bridge */ /* synthetic */ void zze(MediaQueueData mediaQueueData, List list) {
        mediaQueueData.zzg = list == null ? null : new ArrayList(list);
    }

    private final void zzl() {
        this.zza = null;
        this.zzb = null;
        this.zzc = 0;
        this.zzd = null;
        this.zzf = 0;
        this.zzg = null;
        this.zzh = 0;
        this.zzi = -1;
        this.zzj = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueData)) {
            return false;
        }
        MediaQueueData mediaQueueData = (MediaQueueData) obj;
        if (!TextUtils.equals(this.zza, mediaQueueData.zza) || !TextUtils.equals(this.zzb, mediaQueueData.zzb) || this.zzc != mediaQueueData.zzc || !TextUtils.equals(this.zzd, mediaQueueData.zzd) || !Objects.equal(this.zze, mediaQueueData.zze) || this.zzf != mediaQueueData.zzf || !Objects.equal(this.zzg, mediaQueueData.zzg) || this.zzh != mediaQueueData.zzh || this.zzi != mediaQueueData.zzi || this.zzj != mediaQueueData.zzj) {
            return false;
        }
        return true;
    }

    public MediaQueueContainerMetadata getContainerMetadata() {
        return this.zze;
    }

    public String getEntity() {
        return this.zzb;
    }

    public List<MediaQueueItem> getItems() {
        List list = this.zzg;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getName() {
        return this.zzd;
    }

    public String getQueueId() {
        return this.zza;
    }

    public int getQueueType() {
        return this.zzc;
    }

    public int getRepeatMode() {
        return this.zzf;
    }

    public int getStartIndex() {
        return this.zzh;
    }

    public long getStartTime() {
        return this.zzi;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), this.zzg, Integer.valueOf(this.zzh), Long.valueOf(this.zzi), Boolean.valueOf(this.zzj));
    }

    @KeepForSdk
    public void setRepeatMode(int i2) {
        this.zzf = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getQueueId(), false);
        SafeParcelWriter.writeString(parcel, 3, getEntity(), false);
        SafeParcelWriter.writeInt(parcel, 4, getQueueType());
        SafeParcelWriter.writeString(parcel, 5, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getContainerMetadata(), i2, false);
        SafeParcelWriter.writeInt(parcel, 7, getRepeatMode());
        SafeParcelWriter.writeTypedList(parcel, 8, getItems(), false);
        SafeParcelWriter.writeInt(parcel, 9, getStartIndex());
        SafeParcelWriter.writeLong(parcel, 10, getStartTime());
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.zza)) {
                jSONObject.put("id", this.zza);
            }
            if (!TextUtils.isEmpty(this.zzb)) {
                jSONObject.put("entity", this.zzb);
            }
            switch (this.zzc) {
                case 1:
                    jSONObject.put("queueType", "ALBUM");
                    break;
                case 2:
                    jSONObject.put("queueType", "PLAYLIST");
                    break;
                case 3:
                    jSONObject.put("queueType", "AUDIOBOOK");
                    break;
                case 4:
                    jSONObject.put("queueType", "RADIO_STATION");
                    break;
                case 5:
                    jSONObject.put("queueType", "PODCAST_SERIES");
                    break;
                case 6:
                    jSONObject.put("queueType", "TV_SERIES");
                    break;
                case 7:
                    jSONObject.put("queueType", "VIDEO_PLAYLIST");
                    break;
                case 8:
                    jSONObject.put("queueType", "LIVE_TV");
                    break;
                case 9:
                    jSONObject.put("queueType", "MOVIE");
                    break;
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                jSONObject.put("name", this.zzd);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata = this.zze;
            if (mediaQueueContainerMetadata != null) {
                jSONObject.put("containerMetadata", mediaQueueContainerMetadata.zza());
            }
            String zza2 = MediaCommon.zza(Integer.valueOf(this.zzf));
            if (zza2 != null) {
                jSONObject.put("repeatMode", zza2);
            }
            List list = this.zzg;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (MediaQueueItem json : this.zzg) {
                    jSONArray.put(json.toJson());
                }
                jSONObject.put("items", jSONArray);
            }
            jSONObject.put("startIndex", this.zzh);
            long j2 = this.zzi;
            if (j2 != -1) {
                jSONObject.put("startTime", CastUtils.millisecToSec(j2));
            }
            jSONObject.put("shuffle", this.zzj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @ShowFirstParty
    public final boolean zzk() {
        return this.zzj;
    }

    /* synthetic */ MediaQueueData(zzch zzch) {
        zzl();
    }

    /* synthetic */ MediaQueueData(MediaQueueData mediaQueueData, zzch zzch) {
        this.zza = mediaQueueData.zza;
        this.zzb = mediaQueueData.zzb;
        this.zzc = mediaQueueData.zzc;
        this.zzd = mediaQueueData.zzd;
        this.zze = mediaQueueData.zze;
        this.zzf = mediaQueueData.zzf;
        this.zzg = mediaQueueData.zzg;
        this.zzh = mediaQueueData.zzh;
        this.zzi = mediaQueueData.zzi;
        this.zzj = mediaQueueData.zzj;
    }

    @SafeParcelable.Constructor
    MediaQueueData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) MediaQueueContainerMetadata mediaQueueContainerMetadata, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) List list, @SafeParcelable.Param(id = 9) int i4, @SafeParcelable.Param(id = 10) long j2, @SafeParcelable.Param(id = 11) boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        this.zzd = str3;
        this.zze = mediaQueueContainerMetadata;
        this.zzf = i3;
        this.zzg = list;
        this.zzh = i4;
        this.zzi = j2;
        this.zzj = z2;
    }
}
