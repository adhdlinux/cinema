package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import java.util.List;

public final class AdManagerAdRequest extends AdRequest {

    public static final class Builder extends AdRequest.Builder {
        public Builder addCategoryExclusion(String str) {
            this.zza.zzp(str);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zza.zzr(str, str2);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zza.zzE(str);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zza.zzr(str, TextUtils.join(",", list));
            }
            return this;
        }

        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, (zza) null);
        }
    }

    /* synthetic */ AdManagerAdRequest(Builder builder, zza zza) {
        super(builder);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zze();
    }

    public String getPublisherProvidedId() {
        return this.zza.zzl();
    }
}
