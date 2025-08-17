package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbsq;
import java.util.List;
import java.util.Map;

@KeepForSdk
public final class ReportingInfo {
    private final zzbsq zza;

    @KeepForSdk
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzbsp zza;

        @KeepForSdk
        public Builder(View view) {
            zzbsp zzbsp = new zzbsp();
            this.zza = zzbsp;
            zzbsp.zzb(view);
        }

        @KeepForSdk
        public ReportingInfo build() {
            return new ReportingInfo(this, (zzb) null);
        }

        @KeepForSdk
        public Builder setAssetViews(Map<String, View> map) {
            this.zza.zzc(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzb) {
        this.zza = new zzbsq(builder.zza);
    }

    @KeepForSdk
    public void recordClick(List<Uri> list) {
        this.zza.zza(list);
    }

    @KeepForSdk
    public void recordImpression(List<Uri> list) {
        this.zza.zzb(list);
    }

    @KeepForSdk
    public void reportTouchEvent(MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    @KeepForSdk
    public void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzd(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zze(list, updateImpressionUrlsCallback);
    }
}
