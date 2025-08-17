package com.unity3d.services.ads.gmascar.adapters;

import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarAdapter;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.v1920.ScarAdapter;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;

public class ScarAdapterFactory {

    /* renamed from: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion[] r0 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion = r0
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion r1 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.V192     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion r1 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.V195     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion r1 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.V20     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion r1 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.V21     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion     // Catch:{ NoSuchFieldError -> 0x003e }
                com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion r1 = com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion.NA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory.AnonymousClass1.<clinit>():void");
        }
    }

    private void reportAdapterFailure(ScarAdapterVersion scarAdapterVersion, IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        String format = String.format("SCAR version %s is not supported.", new Object[]{scarAdapterVersion.name()});
        iAdsErrorHandler.handleError(GMAAdsError.b(format));
        DeviceLog.debug(format);
    }

    public IScarAdapter createScarAdapter(ScarAdapterVersion scarAdapterVersion, IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        int i2 = AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[scarAdapterVersion.ordinal()];
        if (i2 == 1) {
            return new ScarAdapter(iAdsErrorHandler);
        }
        if (i2 == 2) {
            return new com.unity3d.scar.adapter.v1950.ScarAdapter(iAdsErrorHandler);
        }
        if (i2 == 3) {
            return new com.unity3d.scar.adapter.v2000.ScarAdapter(iAdsErrorHandler);
        }
        if (i2 == 4) {
            return new com.unity3d.scar.adapter.v2100.ScarAdapter(iAdsErrorHandler, SdkProperties.getVersionName());
        }
        reportAdapterFailure(scarAdapterVersion, iAdsErrorHandler);
        return null;
    }
}
