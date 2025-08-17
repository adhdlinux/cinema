package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzhj;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
public class AppMeasurementSdk {
    private final zzee zza;

    @KeepForSdk
    public static final class ConditionalUserProperty {
        @KeepForSdk
        public static final String ACTIVE = "active";
        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        @KeepForSdk
        public static final String NAME = "name";
        @KeepForSdk
        public static final String ORIGIN = "origin";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        @KeepForSdk
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzhi {
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j2);
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzhj {
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j2);
    }

    public AppMeasurementSdk(zzee zzee) {
        this.zza = zzee;
    }

    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context) {
        return zzee.zzg(context, (String) null, (String) null, (String) null, (Bundle) null).zzd();
    }

    @KeepForSdk
    public void beginAdUnitExposure(String str) {
        this.zza.zzu(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zzv(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(String str) {
        this.zza.zzw(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zzb();
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.zza.zzj();
    }

    @KeepForSdk
    public String getAppInstanceId() {
        return this.zza.zzl();
    }

    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzp(str, str2);
    }

    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.zza.zzm();
    }

    @KeepForSdk
    public String getCurrentScreenName() {
        return this.zza.zzn();
    }

    @KeepForSdk
    public String getGmpAppId() {
        return this.zza.zzo();
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zza.zza(str);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(String str, String str2, boolean z2) {
        return this.zza.zzq(str, str2, z2);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzy(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j2) {
        this.zza.zzz(str, str2, bundle, j2);
    }

    @KeepForSdk
    public void performAction(Bundle bundle) {
        this.zza.zzc(bundle, false);
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zzc(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzB(onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zzD(bundle);
    }

    @KeepForSdk
    public void setConsent(Bundle bundle) {
        this.zza.zzE(bundle);
    }

    @KeepForSdk
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zzG(activity, str, str2);
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zzJ(eventInterceptor);
    }

    @KeepForSdk
    public void setMeasurementEnabled(Boolean bool) {
        this.zza.zzK(bool);
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zzN(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzO(onEventListener);
    }

    public final void zza(boolean z2) {
        this.zza.zzH(z2);
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z2) {
        this.zza.zzK(Boolean.valueOf(z2));
    }

    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzee.zzg(context, str, str2, str3, bundle).zzd();
    }
}
