package com.startapp.sdk.adsbase.adlisteners;

import com.startapp.sdk.adsbase.Ad;

public interface AdDisplayListener {
    void adClicked(Ad ad);

    void adDisplayed(Ad ad);

    void adHidden(Ad ad);

    void adNotDisplayed(Ad ad);
}
