package com.applovin.impl.sdk.a;

import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;

public interface a {
    String getOpenMeasurementContentUrl();

    String getOpenMeasurementCustomReferenceData();

    List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources();

    boolean isOpenMeasurementEnabled();
}
