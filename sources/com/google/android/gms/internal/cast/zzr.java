package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzr {
    private static final Logger zza = new Logger("FeatureUsageAnalytics");
    private static final String zzb = "21.3.0";
    private static zzr zzc;
    private final zzf zzd;
    private final SharedPreferences zze;
    private final String zzf;
    private final Runnable zzg = new zzq(this);
    private final Handler zzh = new zzdy(Looper.getMainLooper());
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Clock zzk = DefaultClock.getInstance();
    private long zzl;

    private zzr(SharedPreferences sharedPreferences, zzf zzf2, String str) {
        this.zze = sharedPreferences;
        this.zzd = zzf2;
        this.zzf = str;
    }

    public static synchronized zzr zza(SharedPreferences sharedPreferences, zzf zzf2, String str) {
        zzr zzr;
        synchronized (zzr.class) {
            if (zzc == null) {
                zzc = new zzr(sharedPreferences, zzf2, str);
            }
            zzr = zzc;
        }
        return zzr;
    }

    @VisibleForTesting
    static String zzb(String str, String str2) {
        return String.format("%s%s", new Object[]{str, str2});
    }

    public static /* synthetic */ void zzc(zzr zzr) {
        long j2;
        if (!zzr.zzi.isEmpty()) {
            if (true != zzr.zzj.equals(zzr.zzi)) {
                j2 = SignalManager.TWENTY_FOUR_HOURS_MILLIS;
            } else {
                j2 = 172800000;
            }
            long zzf2 = zzr.zzf();
            long j3 = zzr.zzl;
            if (j3 == 0 || zzf2 - j3 >= j2) {
                zza.d("Upload the feature usage report.", new Object[0]);
                zzmf zza2 = zzmg.zza();
                zza2.zzb(zzb);
                zza2.zza(zzr.zzf);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(zzr.zzi);
                zzlz zza3 = zzma.zza();
                zza3.zza(arrayList);
                zza3.zzb((zzmg) zza2.zzp());
                zzmp zzc2 = zzmq.zzc();
                zzc2.zzc((zzma) zza3.zzp());
                zzr.zzd.zzd((zzmq) zzc2.zzp(), 243);
                SharedPreferences.Editor edit = zzr.zze.edit();
                if (!zzr.zzj.equals(zzr.zzi)) {
                    zzr.zzj.clear();
                    zzr.zzj.addAll(zzr.zzi);
                    for (zzln zza4 : zzr.zzj) {
                        String num = Integer.toString(zza4.zza());
                        String zzh2 = zzr.zzh(num);
                        String zzb2 = zzb("feature_usage_timestamp_reported_feature_", num);
                        if (!TextUtils.equals(zzh2, zzb2)) {
                            long j4 = zzr.zze.getLong(zzh2, 0);
                            edit.remove(zzh2);
                            if (j4 != 0) {
                                edit.putLong(zzb2, j4);
                            }
                        }
                    }
                }
                zzr.zzl = zzf2;
                edit.putLong("feature_usage_last_report_time", zzf2).apply();
            }
        }
    }

    public static void zzd(zzln zzln) {
        zzr zzr = zzc;
        if (zzr != null) {
            zzr.zze.edit().putLong(zzr.zzh(Integer.toString(zzln.zza())), zzr.zzf()).apply();
            zzr.zzi.add(zzln);
            zzr.zzj();
        }
    }

    private final long zzf() {
        return ((Clock) Preconditions.checkNotNull(this.zzk)).currentTimeMillis();
    }

    private static zzln zzg(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            zzln zzln = zzln.DEVELOPER_FEATURE_FLAG_UNKNOWN;
            switch (parseInt) {
                case 0:
                    return zzln.DEVELOPER_FEATURE_FLAG_UNKNOWN;
                case 1:
                    return zzln.CAF_CAST_BUTTON;
                case 2:
                    return zzln.CAF_EXPANDED_CONTROLLER;
                case 3:
                    return zzln.CAF_MINI_CONTROLLER;
                case 4:
                    return zzln.CAF_CONTAINER_CONTROLLER;
                case 5:
                    return zzln.CAST_CONTEXT;
                case 6:
                    return zzln.IMAGE_CACHE;
                case 7:
                    return zzln.IMAGE_PICKER;
                case 8:
                    return zzln.AD_BREAK_PARSER;
                case 9:
                    return zzln.UI_STYLE;
                case 10:
                    return zzln.HARDWARE_VOLUME_BUTTON;
                case 11:
                    return zzln.NON_CAST_DEVICE_PROVIDER;
                case 12:
                    return zzln.PAUSE_CONTROLLER;
                case 13:
                    return zzln.SEEK_CONTROLLER;
                case 14:
                    return zzln.STREAM_VOLUME;
                case 15:
                    return zzln.UI_MEDIA_CONTROLLER;
                case 16:
                    return zzln.PLAYBACK_RATE_CONTROLLER;
                case 17:
                    return zzln.PRECACHE;
                case 18:
                    return zzln.INSTRUCTIONS_VIEW;
                case 19:
                    return zzln.OPTION_SUSPEND_SESSIONS_WHEN_BACKGROUNDED;
                case 20:
                    return zzln.OPTION_STOP_RECEIVER_APPLICATION_WHEN_ENDING_SESSION;
                case 21:
                    return zzln.OPTION_DISABLE_DISCOVERY_AUTOSTART;
                case 22:
                    return zzln.OPTION_DISABLE_ANALYTICS_LOGGING;
                case 23:
                    return zzln.OPTION_PHYSICAL_VOLUME_BUTTONS_WILL_CONTROL_DEVICE_VOLUME;
                case 24:
                    return zzln.CAF_EXPANDED_CONTROLLER_HIDE_STREAM_POSITION_CONTROLS_FOR_LIVE_CONTENT;
                case 25:
                    return zzln.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT;
                case 26:
                    return zzln.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_OPTIONS;
                case 27:
                    return zzln.REMOTE_MEDIA_CLIENT_QUEUE_LOAD_ITEMS_WITH_OPTIONS;
                case 28:
                    return zzln.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_LOAD_REQUEST_DATA;
                case 29:
                    return zzln.LAUNCH_OPTION_ANDROID_RECEIVER_COMPATIBLE;
                case 30:
                    return zzln.CAST_CONTEXT_SET_LAUNCH_CREDENTIALS_DATA;
                case 31:
                    return zzln.START_DISCOVERY_AFTER_FIRST_TAP_ON_CAST_BUTTON;
                case 32:
                    return zzln.CAST_UNAVAILABLE_BUTTON_VISIBLE;
                case 33:
                    return zzln.CAST_DEFAULT_MEDIA_ROUTER_DIALOG;
                case 34:
                    return zzln.CAST_CUSTOM_MEDIA_ROUTER_DIALOG;
                case 35:
                    return zzln.CAST_OUTPUT_SWITCHER_ENABLED;
                case 36:
                    return zzln.CAST_TRANSFER_TO_LOCAL_ENABLED;
                case 37:
                    return zzln.CAST_BUTTON_IS_TRIGGERED_DEFAULT_CAST_DIALOG_FALSE;
                case 38:
                    return zzln.CAST_BUTTON_DELEGATE;
                case 39:
                    return zzln.CAST_BUTTON_DELEGATE_PRESENT_LNA_PERMISSION_CUSTOM_DIALOG;
                case 40:
                    return zzln.CAST_BUTTON_DELEGATE_PRESENT_CAST_STATE_CUSTOM_DIALOG;
                case 41:
                    return zzln.CAST_TRANSFER_TO_LOCAL_USED;
                case 42:
                    return zzln.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                case 43:
                    return zzln.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                case 44:
                    return zzln.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                case 45:
                    return zzln.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                case 46:
                    return zzln.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_TO_STRING;
                case 47:
                    return zzln.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_STRING_TO_ENUM;
                case 48:
                    return zzln.CAST_SLIDER_SET_AD_BLOCK_POSITIONS;
                case 49:
                    return zzln.CAF_NOTIFICATION_SERVICE;
                case 50:
                    return zzln.HARDWARE_VOLUME_BUTTON_PRESS;
                case 51:
                    return zzln.CAST_SDK_DEFAULT_DEVICE_DIALOG;
                case 52:
                    return zzln.CAST_SDK_CUSTOM_DEVICE_DIALOG;
                case 53:
                    return zzln.PERSISTENT_CAST_BUTTON_DISCOVERY_DISABLED_WITH_CONFLICT_TYPES;
                case 54:
                    return zzln.CAST_DEVICE_DIALOG_FACTORY_INSTANTIATED;
                case 55:
                    return zzln.CAF_MEDIA_NOTIFICATION_PROXY;
                default:
                    return null;
            }
        } catch (NumberFormatException unused) {
            return zzln.DEVELOPER_FEATURE_FLAG_UNKNOWN;
        }
    }

    @RequiresNonNull({"sharedPreferences"})
    private final String zzh(String str) {
        String zzb2 = zzb("feature_usage_timestamp_reported_feature_", str);
        if (this.zze.contains(zzb2)) {
            return zzb2;
        }
        return zzb("feature_usage_timestamp_detected_feature_", str);
    }

    private final void zzi(Set set) {
        if (!set.isEmpty()) {
            SharedPreferences.Editor edit = this.zze.edit();
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                edit.remove((String) it2.next());
            }
            edit.apply();
        }
    }

    @RequiresNonNull({"handler", "reportFeatureUsageRunnable"})
    private final void zzj() {
        this.zzh.post(this.zzg);
    }

    public final void zze() {
        String string = this.zze.getString("feature_usage_sdk_version", (String) null);
        String string2 = this.zze.getString("feature_usage_package_name", (String) null);
        this.zzi.clear();
        this.zzj.clear();
        this.zzl = 0;
        if (!zzb.equals(string) || !this.zzf.equals(string2)) {
            HashSet hashSet = new HashSet();
            for (String next : this.zze.getAll().keySet()) {
                if (next.startsWith("feature_usage_timestamp_")) {
                    hashSet.add(next);
                }
            }
            hashSet.add("feature_usage_last_report_time");
            zzi(hashSet);
            this.zze.edit().putString("feature_usage_sdk_version", zzb).putString("feature_usage_package_name", this.zzf).apply();
            return;
        }
        this.zzl = this.zze.getLong("feature_usage_last_report_time", 0);
        long zzf2 = zzf();
        HashSet hashSet2 = new HashSet();
        for (String next2 : this.zze.getAll().keySet()) {
            if (next2.startsWith("feature_usage_timestamp_")) {
                long j2 = this.zze.getLong(next2, 0);
                if (j2 != 0 && zzf2 - j2 > 1209600000) {
                    hashSet2.add(next2);
                } else if (next2.startsWith("feature_usage_timestamp_reported_feature_")) {
                    zzln zzg2 = zzg(next2.substring(41));
                    this.zzj.add(zzg2);
                    this.zzi.add(zzg2);
                } else if (next2.startsWith("feature_usage_timestamp_detected_feature_")) {
                    this.zzi.add(zzg(next2.substring(41)));
                }
            }
        }
        zzi(hashSet2);
        Preconditions.checkNotNull(this.zzh);
        Preconditions.checkNotNull(this.zzg);
        zzj();
    }
}
