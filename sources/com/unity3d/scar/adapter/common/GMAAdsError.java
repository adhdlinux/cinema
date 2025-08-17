package com.unity3d.scar.adapter.common;

import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class GMAAdsError extends WebViewAdsError {
    public GMAAdsError(GMAEvent gMAEvent, Object... objArr) {
        super(gMAEvent, (String) null, objArr);
    }

    public static GMAAdsError a(ScarAdMetadata scarAdMetadata) {
        String format = String.format("Cannot show ad that is not loaded for placement %s", new Object[]{scarAdMetadata.c()});
        return new GMAAdsError(GMAEvent.AD_NOT_LOADED_ERROR, format, scarAdMetadata.c(), scarAdMetadata.d(), format);
    }

    public static GMAAdsError b(String str) {
        return new GMAAdsError(GMAEvent.SCAR_UNSUPPORTED, str, new Object[0]);
    }

    public static GMAAdsError c(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_LOAD_ERROR, str, scarAdMetadata.c(), scarAdMetadata.d(), str);
    }

    public static GMAAdsError d(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_SHOW_ERROR, str, scarAdMetadata.c(), scarAdMetadata.d(), str);
    }

    public static GMAAdsError e(String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_SIGNALS_ERROR, str, str);
    }

    public static GMAAdsError f(String str, String str2, String str3) {
        return new GMAAdsError(GMAEvent.NO_AD_ERROR, str3, str, str2, str3);
    }

    public static GMAAdsError g(ScarAdMetadata scarAdMetadata) {
        String format = String.format("Missing queryInfoMetadata for ad %s", new Object[]{scarAdMetadata.c()});
        return new GMAAdsError(GMAEvent.QUERY_NOT_FOUND_ERROR, format, scarAdMetadata.c(), scarAdMetadata.d(), format);
    }

    public String getDomain() {
        return "GMA";
    }

    public GMAAdsError(GMAEvent gMAEvent, String str, Object... objArr) {
        super(gMAEvent, str, objArr);
    }
}
