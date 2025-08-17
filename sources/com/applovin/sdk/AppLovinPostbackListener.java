package com.applovin.sdk;

public interface AppLovinPostbackListener {
    void onPostbackFailure(String str, int i2);

    void onPostbackSuccess(String str);
}
