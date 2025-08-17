package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.facebook.react.uimanager.ViewProps;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zza;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzb zza = new zzb();
        private final Bundle zzb = new Bundle();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zza.zzb(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zza.zzc(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zza.zzd(cls, bundle);
            return this;
        }

        public DynamicHeightSearchAdRequest build() {
            this.zza.zzd(AdMobAdapter.class, this.zzb);
            return new DynamicHeightSearchAdRequest(this, (zza) null);
        }

        public Builder setAdBorderSelectors(String str) {
            this.zzb.putString("csa_adBorderSelectors", str);
            return this;
        }

        public Builder setAdTest(boolean z2) {
            this.zzb.putString("csa_adtest", true != z2 ? "off" : ViewProps.ON);
            return this;
        }

        public Builder setAdjustableLineHeight(int i2) {
            this.zzb.putString("csa_adjustableLineHeight", Integer.toString(i2));
            return this;
        }

        public Builder setAdvancedOptionValue(String str, String str2) {
            this.zzb.putString(str, str2);
            return this;
        }

        public Builder setAttributionSpacingBelow(int i2) {
            this.zzb.putString("csa_attributionSpacingBelow", Integer.toString(i2));
            return this;
        }

        public Builder setBorderSelections(String str) {
            this.zzb.putString("csa_borderSelections", str);
            return this;
        }

        public Builder setChannel(String str) {
            this.zzb.putString("csa_channel", str);
            return this;
        }

        public Builder setColorAdBorder(String str) {
            this.zzb.putString("csa_colorAdBorder", str);
            return this;
        }

        public Builder setColorAdSeparator(String str) {
            this.zzb.putString("csa_colorAdSeparator", str);
            return this;
        }

        public Builder setColorAnnotation(String str) {
            this.zzb.putString("csa_colorAnnotation", str);
            return this;
        }

        public Builder setColorAttribution(String str) {
            this.zzb.putString("csa_colorAttribution", str);
            return this;
        }

        public Builder setColorBackground(String str) {
            this.zzb.putString("csa_colorBackground", str);
            return this;
        }

        public Builder setColorBorder(String str) {
            this.zzb.putString("csa_colorBorder", str);
            return this;
        }

        public Builder setColorDomainLink(String str) {
            this.zzb.putString("csa_colorDomainLink", str);
            return this;
        }

        public Builder setColorText(String str) {
            this.zzb.putString("csa_colorText", str);
            return this;
        }

        public Builder setColorTitleLink(String str) {
            this.zzb.putString("csa_colorTitleLink", str);
            return this;
        }

        public Builder setCssWidth(int i2) {
            this.zzb.putString("csa_width", Integer.toString(i2));
            return this;
        }

        public Builder setDetailedAttribution(boolean z2) {
            this.zzb.putString("csa_detailedAttribution", Boolean.toString(z2));
            return this;
        }

        public Builder setFontFamily(String str) {
            this.zzb.putString("csa_fontFamily", str);
            return this;
        }

        public Builder setFontFamilyAttribution(String str) {
            this.zzb.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        public Builder setFontSizeAnnotation(int i2) {
            this.zzb.putString("csa_fontSizeAnnotation", Integer.toString(i2));
            return this;
        }

        public Builder setFontSizeAttribution(int i2) {
            this.zzb.putString("csa_fontSizeAttribution", Integer.toString(i2));
            return this;
        }

        public Builder setFontSizeDescription(int i2) {
            this.zzb.putString("csa_fontSizeDescription", Integer.toString(i2));
            return this;
        }

        public Builder setFontSizeDomainLink(int i2) {
            this.zzb.putString("csa_fontSizeDomainLink", Integer.toString(i2));
            return this;
        }

        public Builder setFontSizeTitle(int i2) {
            this.zzb.putString("csa_fontSizeTitle", Integer.toString(i2));
            return this;
        }

        public Builder setHostLanguage(String str) {
            this.zzb.putString("csa_hl", str);
            return this;
        }

        public Builder setIsClickToCallEnabled(boolean z2) {
            this.zzb.putString("csa_clickToCall", Boolean.toString(z2));
            return this;
        }

        public Builder setIsLocationEnabled(boolean z2) {
            this.zzb.putString("csa_location", Boolean.toString(z2));
            return this;
        }

        public Builder setIsPlusOnesEnabled(boolean z2) {
            this.zzb.putString("csa_plusOnes", Boolean.toString(z2));
            return this;
        }

        public Builder setIsSellerRatingsEnabled(boolean z2) {
            this.zzb.putString("csa_sellerRatings", Boolean.toString(z2));
            return this;
        }

        public Builder setIsSiteLinksEnabled(boolean z2) {
            this.zzb.putString("csa_siteLinks", Boolean.toString(z2));
            return this;
        }

        public Builder setIsTitleBold(boolean z2) {
            this.zzb.putString("csa_titleBold", Boolean.toString(z2));
            return this;
        }

        public Builder setIsTitleUnderlined(boolean z2) {
            this.zzb.putString("csa_noTitleUnderline", Boolean.toString(!z2));
            return this;
        }

        public Builder setLocationColor(String str) {
            this.zzb.putString("csa_colorLocation", str);
            return this;
        }

        public Builder setLocationFontSize(int i2) {
            this.zzb.putString("csa_fontSizeLocation", Integer.toString(i2));
            return this;
        }

        public Builder setLongerHeadlines(boolean z2) {
            this.zzb.putString("csa_longerHeadlines", Boolean.toString(z2));
            return this;
        }

        public Builder setNumber(int i2) {
            this.zzb.putString("csa_number", Integer.toString(i2));
            return this;
        }

        public Builder setPage(int i2) {
            this.zzb.putString("csa_adPage", Integer.toString(i2));
            return this;
        }

        public Builder setQuery(String str) {
            this.zza.zze(str);
            return this;
        }

        public Builder setStyleId(String str) {
            this.zzb.putString("csa_styleId", str);
            return this;
        }

        public Builder setVerticalSpacing(int i2) {
            this.zzb.putString("csa_verticalSpacing", Integer.toString(i2));
            return this;
        }
    }

    /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zza2) {
        this.zza = new SearchAdRequest(builder.zza, (zzc) null);
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zza.getCustomEventExtrasBundle(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zza.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.zza.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.zza.isTestDevice(context);
    }

    /* access modifiers changed from: package-private */
    public final zzdx zza() {
        return this.zza.zza();
    }
}
