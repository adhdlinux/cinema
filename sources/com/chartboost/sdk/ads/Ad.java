package com.chartboost.sdk.ads;

public interface Ad {
    void cache();

    void cache(String str);

    void clearCache();

    String getLocation();

    boolean isCached();

    void show();
}
