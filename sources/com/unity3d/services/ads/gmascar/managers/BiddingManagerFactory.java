package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.core.configuration.IExperiments;

public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    /* renamed from: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType[] r0 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType = r0
                com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r1 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.EAGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r1 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.LAZY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r1 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.HYBRID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r1 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.DISABLED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory.AnonymousClass1.<clinit>():void");
        }
    }

    private BiddingManagerFactory() {
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (iExperiments == null || iExperiments.getScarBiddingManager() == null) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        SCARBiddingManagerType fromName = SCARBiddingManagerType.fromName(iExperiments.getScarBiddingManager());
        if (iUnityAdsTokenListener == null && fromName != SCARBiddingManagerType.DISABLED) {
            return new BiddingEagerManager((IUnityAdsTokenListener) null);
        }
        int i2 = AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$managers$SCARBiddingManagerType[fromName.ordinal()];
        if (i2 == 1) {
            return new BiddingEagerManager(iUnityAdsTokenListener);
        }
        if (i2 == 2) {
            return new BiddingLazyManager(iUnityAdsTokenListener);
        }
        if (i2 != 3) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        return new BiddingOnDemandManager(iUnityAdsTokenListener);
    }

    public static BiddingManagerFactory getInstance() {
        if (instance == null) {
            instance = new BiddingManagerFactory();
        }
        return instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (GMA.getInstance().hasSCARBiddingSupport()) {
            return getExperiment(iUnityAdsTokenListener, iExperiments);
        }
        return new BiddingDisabledManager(iUnityAdsTokenListener);
    }
}
