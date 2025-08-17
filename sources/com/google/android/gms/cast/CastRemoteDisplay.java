package com.google.android.gms.cast;

import android.content.Context;
import android.view.Display;
import com.google.android.gms.cast.internal.zzak;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzdm;

@Deprecated
public final class CastRemoteDisplay {
    @Deprecated
    public static final Api<CastRemoteDisplayOptions> API;
    public static final int CONFIGURATION_INTERACTIVE_NONREALTIME = 2;
    public static final int CONFIGURATION_INTERACTIVE_REALTIME = 1;
    public static final int CONFIGURATION_NONINTERACTIVE = 3;
    @Deprecated
    public static final CastRemoteDisplayApi CastRemoteDisplayApi;
    public static final String EXTRA_INT_SESSION_ENDED_STATUS_CODE = "extra_int_session_ended_status_code";
    private static final Api.AbstractClientBuilder zza;

    @Deprecated
    public static final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zza;
        final CastRemoteDisplaySessionCallbacks zzb;
        final int zzc;

        @Deprecated
        public static final class Builder {
            final CastDevice zza;
            final CastRemoteDisplaySessionCallbacks zzb;
            int zzc = 2;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                this.zza = castDevice;
                this.zzb = castRemoteDisplaySessionCallbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this, (zzy) null);
            }

            public Builder setConfigPreset(@Configuration int i2) {
                this.zzc = i2;
                return this;
            }
        }

        /* synthetic */ CastRemoteDisplayOptions(Builder builder, zzy zzy) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.zzc = builder.zzc;
        }
    }

    @Deprecated
    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    @Deprecated
    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public @interface Configuration {
    }

    static {
        zzx zzx = new zzx();
        zza = zzx;
        Api<CastRemoteDisplayOptions> api = new Api<>("CastRemoteDisplay.API", zzx, zzak.zzc);
        API = api;
        CastRemoteDisplayApi = new zzdm(api);
    }

    private CastRemoteDisplay() {
    }

    public static CastRemoteDisplayClient getClient(Context context) {
        return new CastRemoteDisplayClient(context);
    }

    @Deprecated
    public static final boolean isRemoteDisplaySdkSupported(Context context) {
        return false;
    }
}
