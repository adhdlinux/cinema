package com.applovin.impl.sdk;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkConfiguration;
import lombok.NonNull;

public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final m f14988a;

    public SdkConfigurationImpl(m mVar) {
        this.f14988a = mVar;
    }

    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String str = this.f14988a.p().getExtraParameters().get("consent_dialog_state");
        if (!StringUtils.isValidString(str)) {
            str = (String) this.f14988a.a(b.eU);
        }
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    public String getCountryCode() {
        return (String) this.f14988a.a(b.eV);
    }

    @NonNull
    public String toString() {
        return "AppLovinSdkConfiguration{consentDialogState=" + getConsentDialogState() + ", countryCode=" + getCountryCode() + '}';
    }
}
