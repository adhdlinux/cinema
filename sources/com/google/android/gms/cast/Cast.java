package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.cast.internal.zzak;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.UUID;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API;
    public static final CastApi CastApi = new zzm();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    @VisibleForTesting
    static final Api.AbstractClientBuilder zza;

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    @Deprecated
    public interface CastApi {
        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z2);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z2) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d2) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zza;
        final Listener zzb;
        final Bundle zzc;
        final int zzd;
        final String zze = UUID.randomUUID().toString();

        public static final class Builder {
            final CastDevice zza;
            final Listener zzb;
            /* access modifiers changed from: private */
            public int zzc = 0;
            /* access modifiers changed from: private */
            public Bundle zzd;

            public Builder(CastDevice castDevice, Listener listener) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                Preconditions.checkNotNull(listener, "CastListener parameter cannot be null");
                this.zza = castDevice;
                this.zzb = listener;
            }

            public CastOptions build() {
                return new CastOptions(this, (zzn) null);
            }

            public Builder setVerboseLoggingEnabled(boolean z2) {
                this.zzc = z2 ? 1 : 0;
                return this;
            }

            public final Builder zzc(Bundle bundle) {
                this.zzd = bundle;
                return this;
            }
        }

        /* synthetic */ CastOptions(Builder builder, zzn zzn) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.zzd = builder.zzc;
            this.zzc = builder.zzd;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CastOptions)) {
                return false;
            }
            CastOptions castOptions = (CastOptions) obj;
            if (!Objects.equal(this.zza, castOptions.zza) || !Objects.checkBundlesEquality(this.zzc, castOptions.zzc) || this.zzd != castOptions.zzd || !Objects.equal(this.zze, castOptions.zze)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.zza, this.zzc, Integer.valueOf(this.zzd), this.zze);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i2) {
        }

        public void onApplicationDisconnected(int i2) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onDeviceNameChanged() {
        }

        public void onStandbyStateChanged(int i2) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static {
        zze zze = new zze();
        zza = zze;
        API = new Api<>("Cast.API", zze, zzak.zza);
    }

    private Cast() {
    }

    @ShowFirstParty
    public static zzr zza(Context context, CastOptions castOptions) {
        return new zzbt(context, castOptions);
    }
}
