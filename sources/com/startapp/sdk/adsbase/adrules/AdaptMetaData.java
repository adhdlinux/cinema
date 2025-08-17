package com.startapp.sdk.adsbase.adrules;

import com.startapp.j0;
import java.io.Serializable;

public class AdaptMetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static transient AdaptMetaData f36307a = new AdaptMetaData();
    @j0(complex = true)
    private AdRules adRules = new AdRules();
    private String adaptMetaDataUpdateVersion = "4.10.0";

    public AdRules a() {
        return this.adRules;
    }
}
