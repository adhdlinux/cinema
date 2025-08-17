package com.vungle.ads.internal.platform;

import androidx.core.util.Consumer;
import com.vungle.ads.internal.model.AdvertisingInfo;

public interface Platform {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String MANUFACTURER_AMAZON = "Amazon";

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String MANUFACTURER_AMAZON = "Amazon";

        private Companion() {
        }
    }

    AdvertisingInfo getAdvertisingInfo();

    String getAppSetId();

    Integer getAppSetIdScope();

    String getCarrierName();

    String getUserAgent();

    void getUserAgentLazy(Consumer<String> consumer);

    float getVolumeLevel();

    boolean isBatterySaverEnabled();

    boolean isSdCardPresent();

    boolean isSideLoaded();

    boolean isSilentModeEnabled();

    boolean isSoundEnabled();
}
