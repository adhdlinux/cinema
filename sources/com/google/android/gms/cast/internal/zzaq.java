package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaq extends zzd {
    public static final String zzb = "urn:x-cast:com.google.cast.media";
    @VisibleForTesting
    final zzav zzc;
    @VisibleForTesting
    final zzav zzd;
    @VisibleForTesting
    final zzav zze;
    @VisibleForTesting
    final zzav zzf;
    @VisibleForTesting
    final zzav zzg;
    @VisibleForTesting
    final zzav zzh;
    @VisibleForTesting
    final zzav zzi;
    @VisibleForTesting
    final zzav zzj;
    @VisibleForTesting
    final zzav zzk;
    @VisibleForTesting
    final zzav zzl;
    @VisibleForTesting
    final zzav zzm;
    @VisibleForTesting
    final zzav zzn;
    @VisibleForTesting
    final zzav zzo;
    @VisibleForTesting
    final zzav zzp;
    @VisibleForTesting
    final zzav zzq;
    @VisibleForTesting
    final zzav zzr;
    @VisibleForTesting
    final zzav zzs;
    @VisibleForTesting
    final zzav zzt;
    @VisibleForTesting
    final zzav zzu;
    private long zzv;
    private MediaStatus zzw;
    /* access modifiers changed from: private */
    public Long zzx;
    /* access modifiers changed from: private */
    public zzan zzy;
    /* access modifiers changed from: private */
    public int zzz = -1;

    static {
        int i2 = CastUtils.zza;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaq(String str) {
        super(zzb, "MediaControlChannel", (String) null);
        zzav zzav = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzc = zzav;
        zzav zzav2 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzd = zzav2;
        zzav zzav3 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zze = zzav3;
        zzav zzav4 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzf = zzav4;
        zzav zzav5 = new zzav(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        this.zzg = zzav5;
        zzav zzav6 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzh = zzav6;
        zzav zzav7 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzi = zzav7;
        zzav zzav8 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzj = zzav8;
        zzav zzav9 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzk = zzav9;
        zzav zzav10 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzl = zzav10;
        zzav zzav11 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzm = zzav11;
        zzav zzav12 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzn = zzav12;
        zzav zzav13 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzo = zzav13;
        zzav zzav14 = zzav13;
        zzav zzav15 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzp = zzav15;
        zzav zzav16 = zzav15;
        zzav zzav17 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzq = zzav17;
        zzav zzav18 = zzav17;
        zzav zzav19 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzs = zzav19;
        zzav zzav20 = zzav19;
        this.zzr = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        zzav zzav21 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzt = zzav21;
        zzav zzav22 = zzav21;
        zzav zzav23 = new zzav(SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.zzu = zzav23;
        zzc(zzav);
        zzc(zzav2);
        zzc(zzav3);
        zzc(zzav4);
        zzc(zzav5);
        zzc(zzav6);
        zzc(zzav7);
        zzc(zzav8);
        zzc(zzav9);
        zzc(zzav10);
        zzc(zzav11);
        zzc(zzav12);
        zzc(zzav14);
        zzc(zzav16);
        zzc(zzav18);
        zzav zzav24 = zzav20;
        zzc(zzav24);
        zzc(zzav24);
        zzc(zzav22);
        zzc(zzav23);
        zzT();
    }

    private final long zzR(double d2, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzv;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j2;
        }
        long j4 = j2 + ((long) (((double) elapsedRealtime) * d2));
        if (j3 > 0 && j4 > j3) {
            return j3;
        }
        if (j4 >= 0) {
            return j4;
        }
        return 0;
    }

    private static zzap zzS(JSONObject jSONObject) {
        JSONObject jSONObject2;
        MediaError zza = MediaError.zza(jSONObject);
        zzap zzap = new zzap();
        int i2 = CastUtils.zza;
        if (jSONObject.has("customData")) {
            jSONObject2 = jSONObject.optJSONObject("customData");
        } else {
            jSONObject2 = null;
        }
        zzap.zza = jSONObject2;
        zzap.zzb = zza;
        return zzap;
    }

    private final void zzT() {
        this.zzv = 0;
        this.zzw = null;
        for (zzav zzc2 : zza()) {
            zzc2.zzc(2002);
        }
    }

    private final void zzU(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.zzz = jSONObject.optInt("sequenceNumber", -1);
        } else {
            this.zza.w(str.concat(" message is missing a sequence number."), new Object[0]);
        }
    }

    private final void zzV() {
        zzan zzan = this.zzy;
        if (zzan != null) {
            zzan.zzc();
        }
    }

    private final void zzW() {
        zzan zzan = this.zzy;
        if (zzan != null) {
            zzan.zzd();
        }
    }

    private final void zzX() {
        zzan zzan = this.zzy;
        if (zzan != null) {
            zzan.zzk();
        }
    }

    private final void zzY() {
        zzan zzan = this.zzy;
        if (zzan != null) {
            zzan.zzm();
        }
    }

    private final boolean zzZ() {
        return this.zzz != -1;
    }

    private static int[] zzaa(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            iArr[i2] = jSONArray.getInt(i2);
        }
        return iArr;
    }

    public final long zzA(zzat zzat, int i2, long j2, MediaQueueItem[] mediaQueueItemArr, int i3, Boolean bool, Integer num, JSONObject jSONObject) throws IllegalArgumentException, IllegalStateException, zzao {
        int i4 = i2;
        long j3 = j2;
        MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        int i5 = i3;
        Boolean bool2 = bool;
        JSONObject jSONObject2 = jSONObject;
        int i6 = (j3 > -1 ? 1 : (j3 == -1 ? 0 : -1));
        if (i6 == 0 || j3 >= 0) {
            JSONObject jSONObject3 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject3.put("requestId", zzd2);
                jSONObject3.put("type", "QUEUE_UPDATE");
                jSONObject3.put("mediaSessionId", zzn());
                if (i4 != 0) {
                    jSONObject3.put("currentItemId", i4);
                }
                if (i5 != 0) {
                    jSONObject3.put("jump", i5);
                }
                if (mediaQueueItemArr2 != null && mediaQueueItemArr2.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i7 = 0; i7 < mediaQueueItemArr2.length; i7++) {
                        jSONArray.put(i7, mediaQueueItemArr2[i7].toJson());
                    }
                    jSONObject3.put("items", jSONArray);
                }
                if (bool2 != null) {
                    jSONObject3.put("shuffle", bool2);
                }
                String zza = MediaCommon.zza(num);
                if (zza != null) {
                    jSONObject3.put("repeatMode", zza);
                }
                if (i6 != 0) {
                    jSONObject3.put("currentTime", CastUtils.millisecToSec(j2));
                }
                if (jSONObject2 != null) {
                    jSONObject3.put("customData", jSONObject2);
                }
                if (zzZ()) {
                    jSONObject3.put("sequenceNumber", this.zzz);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject3.toString(), zzd2, (String) null);
            this.zzn.zzb(zzd2, new zzam(this, zzat));
            return zzd2;
        }
        throw new IllegalArgumentException("playPosition cannot be negative: " + j3);
    }

    public final long zzB(zzat zzat) throws IllegalStateException {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "GET_STATUS");
            MediaStatus mediaStatus = this.zzw;
            if (mediaStatus != null) {
                jSONObject.put("mediaSessionId", mediaStatus.zzb());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzj.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzC(zzat zzat, MediaSeekOptions mediaSeekOptions) throws IllegalStateException, zzao {
        long j2;
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        if (mediaSeekOptions.isSeekToInfinite()) {
            j2 = 4294967296000L;
        } else {
            j2 = mediaSeekOptions.getPosition();
        }
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("currentTime", CastUtils.millisecToSec(j2));
            if (mediaSeekOptions.getResumeState() == 1) {
                jSONObject.put("resumeState", "PLAYBACK_START");
            } else if (mediaSeekOptions.getResumeState() == 2) {
                jSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (mediaSeekOptions.getCustomData() != null) {
                jSONObject.put("customData", mediaSeekOptions.getCustomData());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzx = Long.valueOf(j2);
        this.zzg.zzb(zzd2, new zzal(this, zzat));
        return zzd2;
    }

    public final long zzD(zzat zzat, long[] jArr) throws IllegalStateException, zzao {
        if (jArr != null) {
            JSONObject jSONObject = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject.put("requestId", zzd2);
                jSONObject.put("type", "EDIT_TRACKS_INFO");
                jSONObject.put("mediaSessionId", zzn());
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    jSONArray.put(i2, jArr[i2]);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            } catch (JSONException unused) {
            }
            zzg(jSONObject.toString(), zzd2, (String) null);
            this.zzk.zzb(zzd2, zzat);
            return zzd2;
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public final long zzE(zzat zzat, double d2, JSONObject jSONObject) throws IllegalStateException, zzao {
        if (this.zzw != null) {
            JSONObject jSONObject2 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject2.put("requestId", zzd2);
                jSONObject2.put("type", "SET_PLAYBACK_RATE");
                jSONObject2.put("playbackRate", d2);
                Preconditions.checkNotNull(this.zzw, "mediaStatus should not be null");
                jSONObject2.put("mediaSessionId", this.zzw.zzb());
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject2.toString(), zzd2, (String) null);
            this.zzt.zzb(zzd2, zzat);
            return zzd2;
        }
        throw new zzao();
    }

    public final long zzF(zzat zzat, boolean z2, JSONObject jSONObject) throws IllegalStateException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z2);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzi.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzG(zzat zzat, double d2, JSONObject jSONObject) throws IllegalStateException, zzao, IllegalArgumentException {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Volume cannot be " + d2);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, d2);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzh.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzH(zzat zzat, TextTrackStyle textTrackStyle) throws IllegalStateException, zzao {
        if (textTrackStyle != null) {
            JSONObject jSONObject = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject.put("requestId", zzd2);
                jSONObject.put("type", "EDIT_TRACKS_INFO");
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
                jSONObject.put("mediaSessionId", zzn());
            } catch (JSONException unused) {
            }
            zzg(jSONObject.toString(), zzd2, (String) null);
            this.zzl.zzb(zzd2, zzat);
            return zzd2;
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public final long zzI(zzat zzat) throws IllegalStateException, zzao {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException e2) {
            this.zza.w(String.format(Locale.ROOT, "Error creating SkipAd message: %s", new Object[]{e2.getMessage()}), new Object[0]);
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzu.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzJ(zzat zzat, JSONObject jSONObject) throws IllegalStateException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzf.zzb(zzd2, zzat);
        return zzd2;
    }

    public final MediaInfo zzK() {
        MediaStatus mediaStatus = this.zzw;
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getMediaInfo();
    }

    public final MediaStatus zzL() {
        return this.zzw;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x025c A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0279 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0289 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0296 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02a0 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a7 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02ae A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02b5 A[Catch:{ JSONException -> 0x02f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c6 A[Catch:{ JSONException -> 0x02f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(java.lang.String r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "insertBefore"
            com.google.android.gms.cast.internal.Logger r3 = r1.zza
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            r5[r6] = r2
            java.lang.String r7 = "message received: %s"
            r3.d(r7, r5)
            r3 = 2
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02f7 }
            r5.<init>(r2)     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r7 = "type"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r8 = "requestId"
            r9 = -1
            long r8 = r5.optLong(r8, r9)     // Catch:{ JSONException -> 0x02f7 }
            int r10 = r7.hashCode()     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r11 = "QUEUE_ITEM_IDS"
            java.lang.String r12 = "QUEUE_CHANGE"
            java.lang.String r13 = "QUEUE_ITEMS"
            r14 = 3
            switch(r10) {
                case -1830647528: goto L_0x0081;
                case -1790231854: goto L_0x0078;
                case -1125000185: goto L_0x006e;
                case -262628938: goto L_0x0064;
                case 66247144: goto L_0x005a;
                case 154411710: goto L_0x0052;
                case 431600379: goto L_0x0048;
                case 823510221: goto L_0x003e;
                case 2107149050: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x008b
        L_0x0036:
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x008b
            r7 = 6
            goto L_0x008c
        L_0x003e:
            java.lang.String r10 = "MEDIA_STATUS"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 0
            goto L_0x008c
        L_0x0048:
            java.lang.String r10 = "INVALID_PLAYER_STATE"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 1
            goto L_0x008c
        L_0x0052:
            boolean r7 = r7.equals(r12)
            if (r7 == 0) goto L_0x008b
            r7 = 7
            goto L_0x008c
        L_0x005a:
            java.lang.String r10 = "ERROR"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 5
            goto L_0x008c
        L_0x0064:
            java.lang.String r10 = "LOAD_FAILED"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 2
            goto L_0x008c
        L_0x006e:
            java.lang.String r10 = "INVALID_REQUEST"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 4
            goto L_0x008c
        L_0x0078:
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x008b
            r7 = 8
            goto L_0x008c
        L_0x0081:
            java.lang.String r10 = "LOAD_CANCELLED"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x008b
            r7 = 3
            goto L_0x008c
        L_0x008b:
            r7 = -1
        L_0x008c:
            java.lang.String r10 = "itemIds"
            r15 = 0
            switch(r7) {
                case 0: goto L_0x021f;
                case 1: goto L_0x01f8;
                case 2: goto L_0x01ec;
                case 3: goto L_0x01e0;
                case 4: goto L_0x01b9;
                case 5: goto L_0x018b;
                case 6: goto L_0x016f;
                case 7: goto L_0x00cb;
                case 8: goto L_0x0094;
                default: goto L_0x0092;
            }
        L_0x0092:
            goto L_0x02f6
        L_0x0094:
            com.google.android.gms.cast.internal.zzav r0 = r1.zzr     // Catch:{ JSONException -> 0x02f7 }
            r0.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x02f7 }
            r1.zzU(r5, r13)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            if (r0 == 0) goto L_0x02f6
            java.lang.String r0 = "items"
            org.json.JSONArray r0 = r5.getJSONArray(r0)     // Catch:{ JSONException -> 0x02f7 }
            int r5 = r0.length()     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.MediaQueueItem[] r5 = new com.google.android.gms.cast.MediaQueueItem[r5]     // Catch:{ JSONException -> 0x02f7 }
            r7 = 0
        L_0x00ad:
            int r8 = r0.length()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 >= r8) goto L_0x00c5
            com.google.android.gms.cast.MediaQueueItem$Builder r8 = new com.google.android.gms.cast.MediaQueueItem$Builder     // Catch:{ JSONException -> 0x02f7 }
            org.json.JSONObject r9 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x02f7 }
            r8.<init>((org.json.JSONObject) r9)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.MediaQueueItem r8 = r8.build()     // Catch:{ JSONException -> 0x02f7 }
            r5[r7] = r8     // Catch:{ JSONException -> 0x02f7 }
            int r7 = r7 + 1
            goto L_0x00ad
        L_0x00c5:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r0.zzg(r5)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x00cb:
            com.google.android.gms.cast.internal.zzav r7 = r1.zzs     // Catch:{ JSONException -> 0x02f7 }
            r7.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x02f7 }
            r1.zzU(r5, r12)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r7 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x02f6
            java.lang.String r7 = "changeType"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x02f7 }
            org.json.JSONArray r8 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x02f7 }
            int[] r8 = zzaa(r8)     // Catch:{ JSONException -> 0x02f7 }
            int r9 = r5.optInt(r0, r6)     // Catch:{ JSONException -> 0x02f7 }
            if (r8 == 0) goto L_0x02f6
            int r11 = r7.hashCode()     // Catch:{ JSONException -> 0x02f7 }
            switch(r11) {
                case -2130463047: goto L_0x0111;
                case -1881281404: goto L_0x0107;
                case -1785516855: goto L_0x00fd;
                case 1122976047: goto L_0x00f3;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x011b
        L_0x00f3:
            java.lang.String r11 = "ITEMS_CHANGE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x011b
            r15 = 1
            goto L_0x011c
        L_0x00fd:
            java.lang.String r11 = "UPDATE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x011b
            r15 = 3
            goto L_0x011c
        L_0x0107:
            java.lang.String r11 = "REMOVE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x011b
            r15 = 2
            goto L_0x011c
        L_0x0111:
            java.lang.String r11 = "INSERT"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x011b
            r15 = 0
            goto L_0x011c
        L_0x011b:
            r15 = -1
        L_0x011c:
            if (r15 == 0) goto L_0x0169
            if (r15 == r4) goto L_0x0163
            if (r15 == r3) goto L_0x015d
            if (r15 == r14) goto L_0x0126
            goto L_0x02f6
        L_0x0126:
            org.json.JSONArray r7 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x02f7 }
            int[] r7 = zzaa(r7)     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r8 = "A list of item IDs is expected in a QUEUE UPDATE message."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7, r8)     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r8 = "reorderItemIds"
            org.json.JSONArray r8 = r5.optJSONArray(r8)     // Catch:{ JSONException -> 0x02f7 }
            if (r8 == 0) goto L_0x0157
            java.util.List r7 = com.google.android.gms.cast.internal.CastUtils.zzd(r7)     // Catch:{ JSONException -> 0x02f7 }
            int r0 = r5.optInt(r0, r6)     // Catch:{ JSONException -> 0x02f7 }
            int[] r5 = zzaa(r8)     // Catch:{ JSONException -> 0x02f7 }
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ JSONException -> 0x02f7 }
            int[] r5 = (int[]) r5     // Catch:{ JSONException -> 0x02f7 }
            java.util.List r5 = com.google.android.gms.cast.internal.CastUtils.zzd(r5)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r8 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r8.zzi(r7, r5, r0)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x0157:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r0.zze(r7)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x015d:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r0.zzh(r8)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x0163:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r0.zzj(r8)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x0169:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r0.zzf(r8, r9)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x016f:
            com.google.android.gms.cast.internal.zzav r0 = r1.zzq     // Catch:{ JSONException -> 0x02f7 }
            r0.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x02f7 }
            r1.zzU(r5, r11)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            if (r0 == 0) goto L_0x02f6
            org.json.JSONArray r0 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x02f7 }
            int[] r0 = zzaa(r0)     // Catch:{ JSONException -> 0x02f7 }
            if (r0 == 0) goto L_0x02f6
            com.google.android.gms.cast.internal.zzan r5 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r5.zze(r0)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x018b:
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x02f7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x02f7 }
        L_0x0193:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x01a9
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r7 = (com.google.android.gms.cast.internal.zzav) r7     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzap r10 = zzS(r5)     // Catch:{ JSONException -> 0x02f7 }
            r11 = 2100(0x834, float:2.943E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x0193
        L_0x01a9:
            com.google.android.gms.cast.internal.zzan r0 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            if (r0 != 0) goto L_0x01af
            goto L_0x02f6
        L_0x01af:
            com.google.android.gms.cast.MediaError r0 = com.google.android.gms.cast.MediaError.zza(r5)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r5 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            r5.zzb(r0)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x01b9:
            com.google.android.gms.cast.internal.Logger r0 = r1.zza     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r7 = "received unexpected error: Invalid Request."
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x02f7 }
            r0.w(r7, r10)     // Catch:{ JSONException -> 0x02f7 }
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x02f7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x02f7 }
        L_0x01ca:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x02f6
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r7 = (com.google.android.gms.cast.internal.zzav) r7     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzap r10 = zzS(r5)     // Catch:{ JSONException -> 0x02f7 }
            r11 = 2001(0x7d1, float:2.804E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x01ca
        L_0x01e0:
            com.google.android.gms.cast.internal.zzav r0 = r1.zzc     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzap r5 = zzS(r5)     // Catch:{ JSONException -> 0x02f7 }
            r7 = 2101(0x835, float:2.944E-42)
            r0.zzd(r8, r7, r5)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x01ec:
            com.google.android.gms.cast.internal.zzav r0 = r1.zzc     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzap r5 = zzS(r5)     // Catch:{ JSONException -> 0x02f7 }
            r7 = 2100(0x834, float:2.943E-42)
            r0.zzd(r8, r7, r5)     // Catch:{ JSONException -> 0x02f7 }
            return
        L_0x01f8:
            com.google.android.gms.cast.internal.Logger r0 = r1.zza     // Catch:{ JSONException -> 0x02f7 }
            java.lang.String r7 = "received unexpected error: Invalid Player State."
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x02f7 }
            r0.w(r7, r10)     // Catch:{ JSONException -> 0x02f7 }
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x02f7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x02f7 }
        L_0x0209:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x02f6
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r7 = (com.google.android.gms.cast.internal.zzav) r7     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzap r10 = zzS(r5)     // Catch:{ JSONException -> 0x02f7 }
            r11 = 2100(0x834, float:2.943E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x0209
        L_0x021f:
            java.lang.String r0 = "status"
            org.json.JSONArray r0 = r5.getJSONArray(r0)     // Catch:{ JSONException -> 0x02f7 }
            int r5 = r0.length()     // Catch:{ JSONException -> 0x02f7 }
            if (r5 <= 0) goto L_0x02d0
            org.json.JSONObject r0 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r5 = r1.zzc     // Catch:{ JSONException -> 0x02f7 }
            boolean r5 = r5.zzf(r8)     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r7 = r1.zzh     // Catch:{ JSONException -> 0x02f7 }
            boolean r7 = r7.zze()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x0248
            com.google.android.gms.cast.internal.zzav r7 = r1.zzh     // Catch:{ JSONException -> 0x02f7 }
            boolean r7 = r7.zzf(r8)     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r7 = 1
            goto L_0x025a
        L_0x0248:
            com.google.android.gms.cast.internal.zzav r7 = r1.zzi     // Catch:{ JSONException -> 0x02f7 }
            boolean r7 = r7.zze()     // Catch:{ JSONException -> 0x02f7 }
            if (r7 == 0) goto L_0x0259
            com.google.android.gms.cast.internal.zzav r7 = r1.zzi     // Catch:{ JSONException -> 0x02f7 }
            boolean r7 = r7.zzf(r8)     // Catch:{ JSONException -> 0x02f7 }
            if (r7 != 0) goto L_0x0259
            goto L_0x0246
        L_0x0259:
            r7 = 0
        L_0x025a:
            if (r5 != 0) goto L_0x0266
            com.google.android.gms.cast.MediaStatus r5 = r1.zzw     // Catch:{ JSONException -> 0x02f7 }
            if (r5 != 0) goto L_0x0261
            goto L_0x0266
        L_0x0261:
            int r0 = r5.zza(r0, r7)     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x0275
        L_0x0266:
            com.google.android.gms.cast.MediaStatus r5 = new com.google.android.gms.cast.MediaStatus     // Catch:{ JSONException -> 0x02f7 }
            r5.<init>(r0)     // Catch:{ JSONException -> 0x02f7 }
            r1.zzw = r5     // Catch:{ JSONException -> 0x02f7 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
            r0 = 127(0x7f, float:1.78E-43)
        L_0x0275:
            r5 = r0 & 1
            if (r5 == 0) goto L_0x0285
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
            r5 = -1
            r1.zzz = r5     // Catch:{ JSONException -> 0x02f7 }
            r16.zzY()     // Catch:{ JSONException -> 0x02f7 }
        L_0x0285:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0292
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
            r16.zzY()     // Catch:{ JSONException -> 0x02f7 }
        L_0x0292:
            r5 = r0 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x029c
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
        L_0x029c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x02a3
            r16.zzV()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02a3:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x02aa
            r16.zzX()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02aa:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x02b1
            r16.zzW()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02b1:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x02c2
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzan r5 = r1.zzy     // Catch:{ JSONException -> 0x02f7 }
            if (r5 == 0) goto L_0x02c2
            r5.zza()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02c2:
            r0 = r0 & 64
            if (r0 == 0) goto L_0x02de
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f7 }
            r1.zzv = r10     // Catch:{ JSONException -> 0x02f7 }
            r16.zzY()     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x02de
        L_0x02d0:
            r1.zzw = r15     // Catch:{ JSONException -> 0x02f7 }
            r16.zzY()     // Catch:{ JSONException -> 0x02f7 }
            r16.zzV()     // Catch:{ JSONException -> 0x02f7 }
            r16.zzX()     // Catch:{ JSONException -> 0x02f7 }
            r16.zzW()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02de:
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x02f7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x02f7 }
        L_0x02e6:
            boolean r5 = r0.hasNext()     // Catch:{ JSONException -> 0x02f7 }
            if (r5 == 0) goto L_0x02f6
            java.lang.Object r5 = r0.next()     // Catch:{ JSONException -> 0x02f7 }
            com.google.android.gms.cast.internal.zzav r5 = (com.google.android.gms.cast.internal.zzav) r5     // Catch:{ JSONException -> 0x02f7 }
            r5.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x02f7 }
            goto L_0x02e6
        L_0x02f6:
            return
        L_0x02f7:
            r0 = move-exception
            com.google.android.gms.cast.internal.Logger r5 = r1.zza
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = r0.getMessage()
            r3[r6] = r0
            r3[r4] = r2
            java.lang.String r0 = "Message is malformed (%s); ignoring: %s"
            r5.w(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzaq.zzO(java.lang.String):void");
    }

    public final void zzP(long j2, int i2) {
        for (zzav zzd2 : zza()) {
            zzd2.zzd(j2, i2, (Object) null);
        }
    }

    public final void zzQ(zzan zzan) {
        this.zzy = zzan;
    }

    public final void zzf() {
        zzb();
        zzT();
    }

    public final long zzj() {
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        double d2;
        if (this.zzv == 0 || (mediaStatus = this.zzw) == null || (adBreakStatus = mediaStatus.getAdBreakStatus()) == null) {
            return 0;
        }
        double playbackRate = mediaStatus.getPlaybackRate();
        if (playbackRate == 0.0d) {
            playbackRate = 1.0d;
        }
        if (mediaStatus.getPlayerState() != 2) {
            d2 = 0.0d;
        } else {
            d2 = playbackRate;
        }
        return zzR(d2, adBreakStatus.getCurrentBreakClipTimeInMs(), 0);
    }

    public final long zzk() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzw;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0;
        }
        long endTime = liveSeekableRange.getEndTime();
        if (!liveSeekableRange.isLiveDone()) {
            return zzR(1.0d, endTime, -1);
        }
        return endTime;
    }

    public final long zzl() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzw;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0;
        }
        long startTime = liveSeekableRange.getStartTime();
        if (liveSeekableRange.isMovingWindow()) {
            startTime = zzR(1.0d, startTime, -1);
        }
        if (liveSeekableRange.isLiveDone()) {
            return Math.min(startTime, liveSeekableRange.getEndTime());
        }
        return startTime;
    }

    public final long zzm() {
        MediaStatus mediaStatus;
        MediaInfo zzK = zzK();
        if (zzK == null || (mediaStatus = this.zzw) == null) {
            return 0;
        }
        Long l2 = this.zzx;
        if (l2 != null) {
            if (l2.equals(4294967296000L)) {
                if (this.zzw.getLiveSeekableRange() != null) {
                    return Math.min(l2.longValue(), zzk());
                }
                if (zzo() >= 0) {
                    return Math.min(l2.longValue(), zzo());
                }
            }
            return l2.longValue();
        } else if (this.zzv == 0) {
            return 0;
        } else {
            double playbackRate = mediaStatus.getPlaybackRate();
            long streamPosition = mediaStatus.getStreamPosition();
            int playerState = mediaStatus.getPlayerState();
            if (playbackRate == 0.0d || playerState != 2) {
                return streamPosition;
            }
            return zzR(playbackRate, streamPosition, zzK.getStreamDuration());
        }
    }

    public final long zzn() throws zzao {
        MediaStatus mediaStatus = this.zzw;
        if (mediaStatus != null) {
            return mediaStatus.zzb();
        }
        throw new zzao();
    }

    public final long zzo() {
        MediaInfo zzK = zzK();
        if (zzK != null) {
            return zzK.getStreamDuration();
        }
        return 0;
    }

    public final long zzp(zzat zzat, MediaLoadRequestData mediaLoadRequestData) throws IllegalStateException, IllegalArgumentException {
        if (mediaLoadRequestData.getMediaInfo() == null && mediaLoadRequestData.getQueueData() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject json = mediaLoadRequestData.toJson();
        if (json != null) {
            long zzd2 = zzd();
            try {
                json.put("requestId", zzd2);
                json.put("type", "LOAD");
            } catch (JSONException unused) {
            }
            zzg(json.toString(), zzd2, (String) null);
            this.zzc.zzb(zzd2, zzat);
            return zzd2;
        }
        throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
    }

    public final long zzq(zzat zzat, JSONObject jSONObject) throws IllegalStateException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzd.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzr(zzat zzat, JSONObject jSONObject) throws IllegalStateException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zze.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzs(String str, List list) throws IllegalStateException {
        long zzd2 = zzd();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "PRECACHE");
            jSONObject.put("precacheData", str);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        return zzd2;
    }

    public final long zzt(zzat zzat, int i2, int i3, int i4) throws zzao, IllegalArgumentException {
        if (i3 > 0 && i4 == 0) {
            i4 = 0;
        } else if (i3 != 0 || i4 <= 0) {
            throw new IllegalArgumentException("Exactly one of nextCount and prevCount must be positive and the other must be zero");
        }
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEM_RANGE");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("itemId", i2);
            if (i3 > 0) {
                jSONObject.put("nextCount", i3);
            }
            if (i4 > 0) {
                jSONObject.put("prevCount", i4);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzs.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzu(zzat zzat) throws zzao, IllegalStateException {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzq.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzv(zzat zzat, int[] iArr) throws zzao, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int put : iArr) {
                jSONArray.put(put);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzr.zzb(zzd2, zzat);
        return zzd2;
    }

    public final long zzw(zzat zzat, MediaQueueItem[] mediaQueueItemArr, int i2, int i3, int i4, long j2, JSONObject jSONObject) throws IllegalStateException, zzao, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        int i5 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if (i5 == 0 || j2 >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject2.put("requestId", zzd2);
                jSONObject2.put("type", "QUEUE_INSERT");
                jSONObject2.put("mediaSessionId", zzn());
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < mediaQueueItemArr.length; i6++) {
                    jSONArray.put(i6, mediaQueueItemArr[i6].toJson());
                }
                jSONObject2.put("items", jSONArray);
                if (i2 != 0) {
                    jSONObject2.put("insertBefore", i2);
                }
                if (i4 != -1) {
                    jSONObject2.put("currentItemIndex", 0);
                }
                if (i5 != 0) {
                    jSONObject2.put("currentTime", CastUtils.millisecToSec(j2));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
                if (zzZ()) {
                    jSONObject2.put("sequenceNumber", this.zzz);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject2.toString(), zzd2, (String) null);
            this.zzm.zzb(zzd2, new zzam(this, zzat));
            return zzd2;
        }
        throw new IllegalArgumentException("playPosition can not be negative: " + j2);
    }

    public final long zzx(zzat zzat, MediaQueueItem[] mediaQueueItemArr, int i2, int i3, long j2, JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        int length;
        if (mediaQueueItemArr == null || (length = mediaQueueItemArr.length) == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i2 < 0 || i2 >= length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i2);
        } else {
            int i4 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if (i4 == 0 || j2 >= 0) {
                JSONObject jSONObject2 = new JSONObject();
                long zzd2 = zzd();
                this.zzc.zzb(zzd2, zzat);
                try {
                    jSONObject2.put("requestId", zzd2);
                    jSONObject2.put("type", "QUEUE_LOAD");
                    JSONArray jSONArray = new JSONArray();
                    for (int i5 = 0; i5 < mediaQueueItemArr.length; i5++) {
                        jSONArray.put(i5, mediaQueueItemArr[i5].toJson());
                    }
                    jSONObject2.put("items", jSONArray);
                    String zza = MediaCommon.zza(Integer.valueOf(i3));
                    if (zza != null) {
                        jSONObject2.put("repeatMode", zza);
                        jSONObject2.put("startIndex", i2);
                        if (i4 != 0) {
                            jSONObject2.put("currentTime", CastUtils.millisecToSec(j2));
                        }
                        if (jSONObject != null) {
                            jSONObject2.put("customData", jSONObject);
                        }
                        if (zzZ()) {
                            jSONObject2.put("sequenceNumber", this.zzz);
                        }
                        zzg(jSONObject2.toString(), zzd2, (String) null);
                        return zzd2;
                    }
                    throw new IllegalArgumentException("Invalid repeat mode: " + i3);
                } catch (JSONException unused) {
                }
            } else {
                throw new IllegalArgumentException("playPosition can not be negative: " + j2);
            }
        }
    }

    public final long zzy(zzat zzat, int[] iArr, JSONObject jSONObject) throws IllegalStateException, zzao, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzZ()) {
                jSONObject2.put("sequenceNumber", this.zzz);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzo.zzb(zzd2, new zzam(this, zzat));
        return zzd2;
    }

    public final long zzz(zzat zzat, int[] iArr, int i2, JSONObject jSONObject) throws IllegalStateException, zzao, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                jSONArray.put(i3, iArr[i3]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i2 != 0) {
                jSONObject2.put("insertBefore", i2);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzZ()) {
                jSONObject2.put("sequenceNumber", this.zzz);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzp.zzb(zzd2, new zzam(this, zzat));
        return zzd2;
    }
}
