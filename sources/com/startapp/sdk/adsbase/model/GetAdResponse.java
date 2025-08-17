package com.startapp.sdk.adsbase.model;

import com.startapp.j0;
import com.startapp.sdk.adsbase.BaseResponse;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import java.util.ArrayList;
import java.util.List;

public class GetAdResponse extends BaseResponse {
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private AdInformationOverrides adInfoOverrides = AdInformationOverrides.a();
    @j0(type = ArrayList.class, value = AdDetails.class)
    private List<AdDetails> adsDetails = new ArrayList();
    private boolean inAppBrowser;
    @j0(type = inAppBrowserPreLoad.class)
    private inAppBrowserPreLoad inAppBrowserPreLoad;
    private String productId;
    private String publisherId;

    public enum inAppBrowserPreLoad {
        DISABLED,
        CONTENT,
        FULL
    }

    public AdInformationOverrides c() {
        return this.adInfoOverrides;
    }

    public List<AdDetails> d() {
        return this.adsDetails;
    }
}
